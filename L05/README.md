# Laboratorio 05: Patrones de Comportamiento

---

## Caso de Estudio: Sistema de Restaurante “QuickServe”

El restaurante QuickServe necesita modernizar distintos procesos de su operación para reducir errores y mejorar la mantenibilidad del sistema. Actualmente existen problemas en la gestión de órdenes de cocina y en el procesamiento de pagos debido al uso de lógica rígida y poco extensible.

---

## Preparación del Proyecto

1. Crea 2 paquetes:
    - `ejercicio01` - Command
    - `ejercicio02` - Strategy

---

# Ejercicio 1: Command Pattern

### 1) Diagrama del Código Actual (Problemático):

```mermaid
classDiagram
    class Waiter {
        +prepareOrder(String type, String details) void
    }

    class Kitchen {
        +cookMainDish(String ingredients, int time) void
        +prepareHotDrink(String drink, int temperature) void
        +prepareDessert(String dessert, String decoration) void
    }

    Waiter --> Kitchen : directly calls

    note for Waiter "❌ El mesero conoce
    todos los detalles de preparación
    de cada tipo de orden"
```

### 2) Diagrama de la Solución (Command):

```mermaid
classDiagram
    class Command {
        <<interface>>
        +execute()* void
    }

    class MainDishCommand {
        -Kitchen kitchen
        -String ingredients
        -int cookingTime
        +execute() void
    }

    class HotDrinkCommand {
        -Kitchen kitchen
        -String drink
        -int temperature
        +execute() void
    }

    class DessertCommand {
        -Kitchen kitchen
        -String dessert
        -String decoration
        +execute() void
    }

    class Waiter {
        +sendOrder(Command command) void
    }

    class Kitchen {
        +cookMainDish(String ingredients, int time) void
        +prepareHotDrink(String drink, int temperature) void
        +prepareDessert(String dessert, String decoration) void
    }

    Command <|.. MainDishCommand
    Command <|.. HotDrinkCommand
    Command <|.. DessertCommand

    MainDishCommand --> Kitchen
    HotDrinkCommand --> Kitchen
    DessertCommand --> Kitchen

    Waiter ..> Command : executes

    note for Command "✅ Cada orden encapsula
    la solicitud y sus parámetros"
```

#### **Implementa la solución creando:**

- `Command` (interface) con el método `execute()`.
- `MainDishCommand`, `HotDrinkCommand` y `DessertCommand`.
- `Kitchen` como receptor de las acciones.
- `Waiter` como invocador que ejecuta comandos.
- Agregar un nuevo comando (`SaladCommand` o similar) para demostrar extensibilidad.

---

# Ejercicio 2: Strategy Pattern

### 1) Diagrama del Código Actual (Problemático):

```mermaid
classDiagram
    class Cashier {
        +processPayment(String type, double amount) void
    }

    note for Cashier "❌ Usa múltiples if/else
    para decidir cómo procesar
    cada tipo de pago"
```

### 2) Diagrama de la Solución (Strategy):

```mermaid
classDiagram
    class PaymentStrategy {
        <<interface>>
        +pay(double amount)* void
    }

    class CashPayment {
        +pay(double amount) void
    }

    class CardPayment {
        -String cardNumber
        +pay(double amount) void
    }

    class MobilePayment {
        -String phoneNumber
        -String appName
        +pay(double amount) void
    }

    class PaymentProcessor {
        -PaymentStrategy strategy
        +setStrategy(PaymentStrategy strategy) void
        +process(double amount) void
    }

    PaymentStrategy <|.. CashPayment
    PaymentStrategy <|.. CardPayment
    PaymentStrategy <|.. MobilePayment

    PaymentProcessor o-- PaymentStrategy

    note for PaymentStrategy "✅ Permite cambiar
    dinámicamente el método
    de pago"
```

#### **Implementa la solución creando:**

- `PaymentStrategy` (interface) con el método `pay(double amount)`.
- `CashPayment`, `CardPayment` y `MobilePayment`.
- `PaymentProcessor` que permita cambiar estrategias dinámicamente.
- Un cliente (`main`) que procese pagos usando diferentes estrategias.
- Agregar una nueva estrategia (`CryptoPayment` o similar) para demostrar extensibilidad.

---

## Entregables

Para cada ejercicio, presente:

1. Diagrama de clases UML con las relaciones correspondientes.
2. Implementación en Java de las clases principales.
3. Un ejemplo de uso (`main`) que demuestre el funcionamiento.

---

_Enfócate en entender por qué el código inicial es problemático antes de implementar la solución._