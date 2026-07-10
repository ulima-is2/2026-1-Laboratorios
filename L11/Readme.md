# Taller de Refactoring

**Curso:** Ingeniería de Software II
**Lenguaje:** Java 17
**Duración sugerida:** 3 horas (1 hora por ejercicio)
**Modalidad:** Individual o en parejas

## Objetivos de aprendizaje

Al finalizar el taller, el estudiante será capaz de:

1. Identificar *code smells* comunes en código orientado a objetos.
2. Aplicar correctamente 12 técnicas de refactoring del catálogo de Fowler, agrupadas en las categorías Composing Methods, Moving Features, Organizing Data y Generalización.
3. Justificar, para cada refactor aplicado, qué problema resuelve y qué comportamiento debe preservarse.

## Técnicas cubiertas

| Categoría | Técnica | Ejercicio |
|---|---|---|
| Composing Methods | Extract Method | 1 |
| Composing Methods | Inline Method | 1 |
| Composing Methods | Replace Temp with Query | 1 |
| Composing Methods | Introduce Explaining Variable | 1 |
| Composing Methods | Replace Method with Method Object | 2 |
| Moving Features | Move Method | 2 |
| Moving Features | Extract Class | 2 |
| Moving Features | Inline Class | 2 |
| Organizing Data | Replace Data Value with Object | 3 |
| Generalización | Pull Up Method | 3 |
| Generalización | Push Down Method | 3 |
| Generalización | Extract Subclass | 3 |

## Instrucciones generales

- El comportamiento observable del código **no debe cambiar** después de cada refactor (mismos resultados, misma salida por consola).
- No se permite reescribir el diseño desde cero: cada cambio debe corresponder exactamente a la técnica indicada.
- Para cada técnica aplicada, entregar: (a) el código resultante y (b) 2-3 líneas explicando qué *smell* se eliminó.


# Ejercicio 1 — Sistema de Facturación de Pedidos

**Categoría:** Composing Methods
**Técnicas a aplicar:** Extract Method, Inline Method, Replace Temp with Query, Introduce Explaining Variable

## Contexto

La empresa **QuickCart** tiene una clase `Pedido` que calcula e imprime el resumen de un pedido (subtotal, descuento, impuesto y total). El código funciona, pero el método `imprimirResumen()` es largo, mezcla varias responsabilidades y recalcula valores que ya existen como métodos.

## Código original

```java
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<ItemPedido> items;
    private String cliente;
    private boolean esClientePremium;

    public Pedido(String cliente, boolean esClientePremium) {
        this.cliente = cliente;
        this.esClientePremium = esClientePremium;
        this.items = new ArrayList<>();
    }

    public void agregarItem(ItemPedido item) {
        items.add(item);
    }

    // Método que solo delega, sin agregar valor propio
    public String obtenerNombreCliente() {
        return this.cliente;
    }

    private double calcularSubtotal() {
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal += item.getPrecio() * item.getCantidad();
        }
        return subtotal;
    }

    public void imprimirResumen() {
        // Recalcula el subtotal en vez de reusar calcularSubtotal()
        double subtotal = 0;
        for (ItemPedido item : items) {
            subtotal += item.getPrecio() * item.getCantidad();
        }

        double descuento = esClientePremium ? subtotal * 0.15
                : (subtotal > 500 ? subtotal * 0.10 : 0);

        System.out.println("Cliente: " + obtenerNombreCliente());
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Descuento: " + descuento);

        // Bloque de impresión de items mezclado con el cálculo del total
        System.out.println("--- Items ---");
        for (ItemPedido item : items) {
            System.out.println(item.getNombre() + " x" + item.getCantidad()
                    + " = " + (item.getPrecio() * item.getCantidad()));
        }

        // Expresión compuesta difícil de leer
        double total = subtotal - descuento + (subtotal * 0.19);
        System.out.println("Total: " + total);
    }
}

class ItemPedido {
    private String nombre;
    private double precio;
    private int cantidad;

    public ItemPedido(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
}
```

## Tareas

1. **Inline Method:** el método `obtenerNombreCliente()` no hace nada más que retornar `this.cliente` y solo se usa en un lugar. Elimínalo y usa el campo directamente.
2. **Replace Temp with Query:** `imprimirResumen()` recalcula el subtotal con un bucle en vez de llamar a `calcularSubtotal()`. Reemplaza la variable temporal `subtotal` por la llamada al método existente (o crea `calcularDescuento()` como query si aplica).
3. **Extract Method:** extrae el bloque que imprime los items a un método `imprimirItems()`.
4. **Introduce Explaining Variable:** la línea `subtotal - descuento + (subtotal * 0.19)` mezcla varios conceptos en una sola expresión. Introduce una variable explicativa (por ejemplo `impuesto`) para que la fórmula del total sea legible.

## Restricciones

- No cambies la lógica de negocio (porcentajes de descuento e impuesto).
- `calcularSubtotal()` debe seguir siendo privado.
- La salida por consola debe ser idéntica antes y después del refactor.

---

# Ejercicio 2 — Sistema de Reservas de Biblioteca

**Categoría:** Moving Features + Method Object
**Técnicas a aplicar:** Move Method, Extract Class, Inline Class, Replace Method with Method Object

## Contexto

La biblioteca **LectoTech** usa una clase `Prestamo` para representar el préstamo de un libro y una clase `Cliente` que además de guardar datos personales, envía notificaciones por correo. También existe una clase `DireccionCliente` que quedó casi vacía tras una reestructuración anterior.

## Código original

```java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Prestamo {
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    public Prestamo(Libro libro, LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    // Usa casi exclusivamente datos de Libro: candidato a moverse allí
    public double calcularMulta() {
        long diasRetraso = ChronoUnit.DAYS.between(fechaDevolucion, LocalDate.now());
        if (diasRetraso <= 0) {
            return 0;
        }
        return diasRetraso * libro.getTarifaMultaDiaria();
    }

    public Libro getLibro() { return libro; }
}

class Libro {
    private String titulo;
    private double tarifaMultaDiaria;

    public Libro(String titulo, double tarifaMultaDiaria) {
        this.titulo = titulo;
        this.tarifaMultaDiaria = tarifaMultaDiaria;
    }

    public String getTitulo() { return titulo; }
    public double getTarifaMultaDiaria() { return tarifaMultaDiaria; }
}

class Cliente {
    private String nombre;
    private String email;
    private DireccionCliente direccion;

    public Cliente(String nombre, String email, String calle) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = new DireccionCliente(calle);
    }

    public String getNombre() { return nombre; }
    public String getDireccionCompleta() { return direccion.getCalle(); }

    // Responsabilidad de notificación mezclada con datos del cliente
    public void enviarNotificacionRetraso(String tituloLibro, double multa) {
        String asunto = "Aviso de retraso: " + tituloLibro;
        String cuerpo = "Estimado/a " + nombre + ", tiene una multa pendiente de $" + multa;
        System.out.println("Enviando a " + email);
        System.out.println("Asunto: " + asunto);
        System.out.println("Cuerpo: " + cuerpo);
    }
}

// Clase que quedó con una sola responsabilidad trivial
class DireccionCliente {
    private String calle;

    public DireccionCliente(String calle) {
        this.calle = calle;
    }

    public String getCalle() { return calle; }
}
```

También existe este método largo, candidato a **Replace Method with Method Object**, porque usa muchas variables locales interdependientes:

```java
public class ProcesadorDevoluciones {

    public String procesarDevolucion(Prestamo prestamo, Cliente cliente, boolean esRenovable) {
        double multa = prestamo.calcularMulta();
        boolean tieneMulta = multa > 0;
        double descuentoFidelidad = tieneMulta && esRenovable ? multa * 0.5 : multa;
        String estado = tieneMulta ? "DEVUELTO_CON_MULTA" : "DEVUELTO";
        String mensaje = "Cliente " + cliente.getNombre() + " - Estado: " + estado
                + " - Monto a pagar: " + descuentoFidelidad;
        if (tieneMulta) {
            cliente.enviarNotificacionRetraso(prestamo.getLibro().getTitulo(), descuentoFidelidad);
        }
        return mensaje;
    }
}
```

## Tareas

1. **Move Method:** `calcularMulta()` usa principalmente datos de `Libro` (tarifa) y solo la fecha de `Prestamo`. Muévelo a la clase `Libro` (puede recibir la fecha de devolución como parámetro), dejando en `Prestamo` solo la delegación si es necesaria.
2. **Extract Class:** separa de `Cliente` la responsabilidad de notificaciones en una nueva clase `NotificadorCliente`.
3. **Inline Class:** `DireccionCliente` ya no justifica ser una clase aparte (solo envuelve un `String`). Fusiónala de vuelta en `Cliente`.
4. **Replace Method with Method Object:** convierte `procesarDevolucion()` en su propia clase (`ProcesadorDevolucion` como *method object*), donde `prestamo`, `cliente`, `esRenovable` y las variables locales pasan a ser campos.

## Restricciones

- El resultado impreso/retornado por `procesarDevolucion` debe ser idéntico.
- `Libro` no debe depender de `Cliente` ni de `Prestamo` tras el Move Method.

