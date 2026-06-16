# Taller: JUnit 5 — Fundamentos

## Objetivo
Escribir pruebas unitarias con JUnit 5 usando anotaciones del ciclo de vida, aserciones estándar y estructuras de test bien organizadas.

## Tecnología sugerida
- **Lenguaje:** Java 17+
- **Framework:** JUnit 5 (Jupiter)
- **Build tool:** Maven

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

---

## Ejercicio 1: Ciclo de vida — `@BeforeEach` y `@AfterEach`

Dada la siguiente clase `Carrito`, escribe una suite de tests que use `@BeforeEach` para inicializar el carrito antes de cada test y `@AfterEach` para imprimir el estado final.

```java
import java.util.*;

public class Carrito {
    private List<String> productos = new ArrayList<>();
    private double total = 0.0;

    public void agregar(String producto, double precio) {
        productos.add(producto);
        total += precio;
    }

    public boolean eliminar(String producto, double precio) {
        if (!productos.contains(producto)) return false;
        productos.remove(producto);
        total -= precio;
        return true;
    }

    public int cantidad()      { return productos.size(); }
    public double getTotal()   { return total; }
    public boolean estaVacio() { return productos.isEmpty(); }
}
```

**Tareas:**
1. Escribe `@BeforeEach` que inicialice un `Carrito` vacío.
2. Test: carrito recién inicializado está vacío.
3. Test: agregar un producto incrementa la cantidad a 1.
4. Test: agregar dos productos distintos da total correcto.
5. Test: eliminar producto existente retorna `true` y reduce la cantidad.
6. Test: eliminar producto inexistente retorna `false`.
7. Agrega `@AfterEach` que imprima `"Test finalizado. Total: X"`.

---

## Ejercicio 2: `@BeforeAll` y `@AfterAll`

Implementa una suite para `ConexionSimulada` que use `@BeforeAll` para "abrir" la conexión una sola vez y `@AfterAll` para "cerrarla".

```java
public class ConexionSimulada {
    private boolean conectado = false;

    public void conectar()      { conectado = true; }
    public void desconectar()   { conectado = false; }
    public boolean isConectado(){ return conectado; }

    public String ejecutar(String consulta) {
        if (!conectado) throw new IllegalStateException("No hay conexión activa");
        return "Resultado de: " + consulta;
    }
}
```

**Tareas:**
1. Usa `@BeforeAll` para crear la conexión (debe ser `static`).
2. Test: `ejecutar` con conexión activa retorna el resultado.
3. Test: `ejecutar` sin conexión lanza `IllegalStateException`.
4. Usa `@AfterAll` para desconectar y verificar que `isConectado()` es false.
5. Explica cuándo conviene `@BeforeAll` vs `@BeforeEach`.

---

## Ejercicio 3: Aserciones avanzadas

Implementa `GestorTareas` y escribe tests usando las siguientes aserciones de JUnit 5: `assertAll`, `assertThrows`, `assertTimeout`, `assertNull`, `assertNotNull`.

```java
import java.util.*;

public class GestorTareas {
    private List<String> tareas = new ArrayList<>();

    public void agregar(String tarea) {
        if (tarea == null || tarea.isBlank())
            throw new IllegalArgumentException("Tarea inválida");
        tareas.add(tarea);
    }

    public String obtener(int indice) {
        if (indice < 0 || indice >= tareas.size())
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        return tareas.get(indice);
    }

    public String buscar(String nombre) {
        return tareas.stream()
            .filter(t -> t.equals(nombre))
            .findFirst()
            .orElse(null);
    }

    public int total() { return tareas.size(); }
}
```

**Tareas:**
1. Test con `assertAll`: verifica `total()`, `obtener(0)` y `estaVacia()` de una lista con datos en un solo test.
2. Test con `assertThrows`: `agregar(null)` lanza `IllegalArgumentException`.
3. Test con `assertThrows`: verifica también el **mensaje** de la excepción.
4. Test con `assertTimeout`: `agregar` completa en menos de 100ms.
5. Test con `assertNull`: `buscar` de tarea inexistente retorna null.
6. Test con `assertNotNull`: `buscar` de tarea existente no retorna null.

---

## Ejercicio 4: `@Disabled` y `@DisplayName`

Refactoriza los tests anteriores agregando:

1. `@DisplayName` con nombres descriptivos en español para cada test.
2. Un test deshabilitado con `@Disabled("Pendiente de implementación")`.
3. Una clase de test anidada (`@Nested`) para agrupar tests de "agregar" y tests de "buscar".

```java
@Nested
@DisplayName("Cuando se agregan tareas")
class CuandoSeAgregan {
    // Tests de agregar aquí
}

@Nested
@DisplayName("Cuando se buscan tareas")
class CuandoSeBuscan {
    // Tests de buscar aquí
}
```

---

## Ejercicio 5: Suite completa para `BibliotecaDigital`

Implementa y prueba la clase `BibliotecaDigital` con una suite completa de JUnit 5.

```java
import java.util.*;

public class BibliotecaDigital {
    private Map<String, String> catalogo = new HashMap<>(); // ISBN -> Titulo

    public void registrar(String isbn, String titulo) {
        if (isbn == null || titulo == null)
            throw new IllegalArgumentException("ISBN y título son obligatorios");
        if (catalogo.containsKey(isbn))
            throw new IllegalStateException("ISBN ya registrado: " + isbn);
        catalogo.put(isbn, titulo);
    }

    public Optional<String> buscar(String isbn) {
        return Optional.ofNullable(catalogo.get(isbn));
    }

    public boolean eliminar(String isbn) {
        return catalogo.remove(isbn) != null;
    }

    public int totalLibros() { return catalogo.size(); }
}
```

**Tareas (al menos 8 tests):**
1. Biblioteca nueva tiene 0 libros.
2. Registrar libro incrementa el total a 1.
3. Buscar ISBN registrado retorna el título.
4. Buscar ISBN no registrado retorna `Optional.empty()`.
5. Registrar ISBN duplicado lanza `IllegalStateException`.
6. Registrar con ISBN `null` lanza `IllegalArgumentException`.
7. Eliminar libro existente retorna `true` y reduce el total.
8. Eliminar libro inexistente retorna `false`.
9. (Bonus) Registrar y buscar 100 libros en menos de 500ms (`assertTimeout`).
