# Laboratorio 02: Violación de Principios SOLID


## Caso de Estudio: Sistema de E-Commerce

Una empresa está desarrollando un sistema de e-commerce que maneja productos, usuarios, pedidos y pagos. El sistema actual presenta múltiples violaciones a los principios SOLID que afectan su mantenibilidad, escalabilidad y testabilidad.

### Contexto del Sistema:

- **Gestión de productos:** Diferentes tipos de productos (físicos, digitales, servicios)
- **Procesamiento de pedidos:** Cálculo de precios, aplicación de descuentos, envío
- **Sistema de pagos:** Múltiples métodos de pago (tarjeta, PayPal, transferencia)
- **Notificaciones:** Email, SMS, push notifications
- **Reportes:** Diferentes formatos de reportes de ventas

> **Objetivo**: Identificar, analizar y corregir violaciones a los principios SOLID en un sistema real

---

## Preparación del Proyecto

1. Crear un nuevo proyecto Maven llamado `SolidViolationsLab`
2. Configurar la estructura de paquetes:
   - `com.solid.violations` - Clases con violaciones
   - `com.solid.corrected` - Clases corregidas
   - `com.solid.tests` - Clases de prueba

---

## Ejercicio 1: Violación del Principio SRP (Single Responsibility Principle)

### Descripción del Problema:

La clase `User` tiene múltiples responsabilidades que deberían estar separadas:

- Validación de datos de usuario
- Cálculo de descuentos según tipo de usuario
- Envío de notificaciones de bienvenida
- Generación de reportes de usuario

### Diagrama del Problema (Violación SRP):

```mermaid
classDiagram
    class User {
        -String name
        -String email
        -String userType
        -double totalPurchases
        +validateUser() boolean
        +isValidEmail(email) boolean
        +calculateDiscount() double
        +sendWelcomeEmail() void
        +generateUserReport() String
        +getName() String
        +getEmail() String
        +getUserType() String
        +getTotalPurchases() double
    }

    note for User "PROBLEMA: Una clase con 5 responsabilidades diferentes
    1. Gestión de datos de usuario
    2. Validación de datos
    3. Cálculo de descuentos
    4. Envío de notificaciones
    5. Generación de reportes"
```

### Diagrama de la Solución (Cumple SRP):

```mermaid
classDiagram
    class User {
        -String name
        -String email
        -String userType
        -double totalPurchases
        +getName() String
        +getEmail() String
        +getUserType() String
        +getTotalPurchases() double
    }

    class UserValidator {
        +validateUser(User) boolean
        +isValidEmail(String) boolean
    }

    class DiscountCalculator {
        +calculateDiscount(User) double
    }

    class NotificationService {
        +sendWelcomeEmail(User) void
    }

    class UserReportGenerator {
        +generateUserReport(User) String
    }

    UserValidator --> User : validates
    DiscountCalculator --> User : calculates for
    NotificationService --> User : notifies
    UserReportGenerator --> User : reports on

    note for User "SOLUCIÓN: Una responsabilidad por clase
    Cada clase tiene una sola razón para cambiar"
```

### Indicaciones:

1. **Identifica** las violaciones al principio SRP en la clase `User` proporcionada
2. **Analiza** por qué cada responsabilidad debería estar en una clase separada
3. **Refactoriza** el código separando las responsabilidades en clases apropiadas
4. **Crea** las siguientes clases en el paquete `com.solid.corrected`:
   - `User` - solo datos del usuario y getters/setters
   - `UserValidator` - responsable de validar datos de usuario
   - `DiscountCalculator` - responsable de calcular descuentos por tipo de usuario
   - `NotificationService` - responsable de enviar notificaciones
   - `UserReportGenerator` - responsable de generar reportes de usuario

---

## Ejercicio 2: Violación del Principio OCP (Open/Closed Principle)

### Descripción del Problema:

La clase `PaymentProcessor` usa un `switch` statement que requiere modificación cada vez que se agrega un nuevo método de pago. Esto viola el principio OCP porque la clase no está cerrada para modificación.

### Diagrama del Problema (Violación OCP):

```mermaid
classDiagram
    class PaymentProcessor {
        +processPayment(method, amount, data) boolean
        -processCreditCard(amount, data) boolean
        -processPayPal(amount, data) boolean
        -processBankTransfer(amount, data) boolean
        -processBitcoin(amount, data) boolean
        +calculateProcessingFee(method, amount) double
    }

    note for PaymentProcessor "PROBLEMA: Switch statement
    Para agregar Apple Pay:
    1. Modificar processPayment()
    2. Agregar processApplePay()
    3. Modificar calculateProcessingFee()
    = Modificar código existente ❌"
```

### Diagrama de la Solución (Cumple OCP):

```mermaid
classDiagram
    class PaymentMethod {
        <<interface>>
        +process(amount, data) boolean
        +calculateProcessingFee(amount) double
        +getPaymentType() String
    }

    class CreditCardPayment {
        +process(amount, data) boolean
        +calculateProcessingFee(amount) double
        +getPaymentType() String
    }

    class PayPalPayment {
        +process(amount, data) boolean
        +calculateProcessingFee(amount) double
        +getPaymentType() String
    }

    class BankTransferPayment {
        +process(amount, data) boolean
        +calculateProcessingFee(amount) double
        +getPaymentType() String
    }

    class ApplePayPayment {
        +process(amount, data) boolean
        +calculateProcessingFee(amount) double
        +getPaymentType() String
    }

    class PaymentProcessor {
        -Map~String, PaymentMethod~ paymentMethods
        +registerPaymentMethod(PaymentMethod) void
        +processPayment(type, amount, data) boolean
        +calculateProcessingFee(type, amount) double
    }

    PaymentMethod <|-- CreditCardPayment
    PaymentMethod <|-- PayPalPayment
    PaymentMethod <|-- BankTransferPayment
    PaymentMethod <|-- ApplePayPayment
    PaymentProcessor o--> PaymentMethod : uses

    note for ApplePayPayment "SOLUCIÓN: Nueva implementación
    sin modificar código existente ✅"
```

### Análisis de la Violación:

- Cada nuevo método de pago requiere **modificar** el `switch` statement existente
- Se deben agregar nuevos métodos privados a la clase existente
- El método `calculateProcessingFee()` también debe ser modificado
- No hay forma de **extender** funcionalidad sin **modificar** código existente

### Indicaciones:

1. **Explica** detalladamente por qué el `switch` statement viola el principio OCP
2. **Diseña** una solución usando el patrón Strategy con interfaces y polimorfismo
3. **Implementa** en el paquete `com.solid.corrected`:
   - Interface `PaymentMethod` con métodos `process()`, `calculateFee()` y `getPaymentType()`
   - Clases concretas: `CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`, `BitcoinPayment`
   - Nueva clase `PaymentProcessor` que use un Map/Registry para almacenar métodos de pago
   - Clase `ApplePayPayment` para demostrar extensión **SIN modificar código existente**

---

## Ejercicio 3: Violación del Principio LSP (Liskov Substitution Principle)

### Descripción del Problema:

En la jerarquía de productos, las subclases `DigitalProduct` y `ServiceProduct` no pueden sustituir completamente a su clase base `Product` porque:

- `DigitalProduct.calculateShippingCost()` lanza una excepción
- `ServiceProduct.calculateShippingCost()` retorna 0 (comportamiento inconsistente)
- El método `processOrder()` falla cuando se usa polimorfismo

### Diagrama del Problema (Violación LSP):

```mermaid
classDiagram
    class Product {
        <<abstract>>
        #String name
        #double basePrice
        #double weight
        +calculatePrice()* double
        +calculateShippingCost()* double
        +requiresPhysicalDelivery()* boolean
        +processOrder() void
    }

    class PhysicalProduct {
        +calculatePrice() double
        +calculateShippingCost() double
        +requiresPhysicalDelivery() boolean
    }

    class DigitalProduct {
        +calculatePrice() double
        +calculateShippingCost() double
        +requiresPhysicalDelivery() boolean
    }

    class ServiceProduct {
        +calculatePrice() double
        +calculateShippingCost() double
        +requiresPhysicalDelivery() boolean
    }

    Product <|-- PhysicalProduct
    Product <|-- DigitalProduct
    Product <|-- ServiceProduct

    note for DigitalProduct "PROBLEMA: Lanza UnsupportedOperationException
    en calculateShippingCost() - No sustituible ❌"

    note for ServiceProduct "PROBLEMA: Retorna 0 en calculateShippingCost()
    comportamiento inconsistente ❌"
```

### Diagrama de la Solución (Cumple LSP):

```mermaid
classDiagram
    class Product {
        <<abstract>>
        #String name
        #double basePrice
        +calculatePrice()* double
        +getName() String
        +getBasePrice() double
    }

    class Shippable {
        <<interface>>
        +calculateShippingCost() double
        +requiresPhysicalDelivery() boolean
    }

    class Downloadable {
        <<interface>>
        +getDownloadUrl() String
        +getFileSize() long
    }

    class Serviceable {
        <<interface>>
        +scheduleService() void
        +getServiceDuration() int
    }

    class PhysicalProduct {
        -double weight
        +calculatePrice() double
        +calculateShippingCost() double
        +requiresPhysicalDelivery() boolean
    }

    class DigitalProduct {
        -String downloadUrl
        -long fileSize
        +calculatePrice() double
        +getDownloadUrl() String
        +getFileSize() long
    }

    class ServiceProduct {
        -int duration
        +calculatePrice() double
        +scheduleService() void
        +getServiceDuration() int
    }

    Product <|-- PhysicalProduct
    Product <|-- DigitalProduct
    Product <|-- ServiceProduct

    Shippable <|.. PhysicalProduct
    Downloadable <|.. DigitalProduct
    Serviceable <|.. ServiceProduct

    note for Product "SOLUCIÓN: Todas las subclases
    son sustituibles por Product ✅"

    note for PhysicalProduct "Solo implementa Shippable
    porque realmente se puede enviar"
```

### Indicaciones:

1. **Explica** por qué se viola el principio LSP con ejemplos específicos
2. **Identifica** los problemas de sustituibilidad en el código de prueba
3. **Rediseña** la jerarquía de clases para que todas las subclases sean completamente sustituibles
4. **Implementa** en el paquete `com.solid.corrected` una solución que puede incluir:
   - Separación de interfaces (`Shippable`, `Downloadable`, `Serviceable`)
   - Uso de composición en lugar de herencia forzada
   - Redefinición de la jerarquía de clases con contratos apropiados
   - ~~Implementación del patrón Strategy para comportamientos específicos~~

---

## Ejercicio 4: Violación del Principio ISP (Interface Segregation Principle)

### Descripción del Problema:

La interface `OrderProcessor` es una "fat interface" que fuerza a las implementaciones a depender de métodos que no necesitan, causando que muchos métodos lancen `UnsupportedOperationException`.

### Diagrama del Problema (Violación ISP):

```mermaid
classDiagram
    class OrderProcessor {
        <<interface>>
        +createOrder(customerId, productIds) void
        +cancelOrder(orderId) void
        +updateOrderStatus(orderId, status) void
        +processPayment(orderId, method, data) boolean
        +processRefund(orderId, amount) void
        +calculateShippingCost(orderId) void
        +scheduleDelivery(orderId, date) void
        +trackShipment(orderId) void
        +checkProductAvailability(productId, qty) boolean
        +reserveProduct(productId, qty) void
        +releaseProductReservation(productId, qty) void
        +sendOrderConfirmation(orderId) void
        +sendShippingNotification(orderId) void
        +sendDeliveryNotification(orderId) void
        +generateOrderReport(orderId) String
        +generateDailyReport(date) String
        +generateCustomerReport(customerId) String
    }

    class BasicOrderProcessor {
        +createOrder(customerId, productIds) void
        +cancelOrder(orderId) void
        +updateOrderStatus(orderId, status) void
        +processPayment(orderId, method, data) UnsupportedOperationException
        +processRefund(orderId, amount) UnsupportedOperationException
        +calculateShippingCost(orderId) UnsupportedOperationException
        +scheduleDelivery(orderId, date) UnsupportedOperationException
        +trackShipment(orderId) UnsupportedOperationException
        +checkProductAvailability(productId, qty) UnsupportedOperationException
        +reserveProduct(productId, qty) UnsupportedOperationException
        +releaseProductReservation(productId, qty) UnsupportedOperationException
        +sendOrderConfirmation(orderId) UnsupportedOperationException
        +sendShippingNotification(orderId) UnsupportedOperationException
        +sendDeliveryNotification(orderId) UnsupportedOperationException
        +generateOrderReport(orderId) UnsupportedOperationException
        +generateDailyReport(date) UnsupportedOperationException
        +generateCustomerReport(customerId) UnsupportedOperationException
    }

    OrderProcessor <|.. BasicOrderProcessor

    note for OrderProcessor "PROBLEMA: Interface 'Fat'
    16 métodos que no todos necesitan"

    note for BasicOrderProcessor "Obligado a implementar
    13 métodos que no usa ❌"
```

### Diagrama de la Solución (Cumple ISP):

```mermaid
classDiagram
    class OrderManager {
        <<interface>>
        +createOrder(customerId, productIds) void
        +cancelOrder(orderId) void
        +updateOrderStatus(orderId, status) void
    }

    class PaymentHandler {
        <<interface>>
        +processPayment(orderId, method, data) boolean
        +processRefund(orderId, amount) void
    }

    class ShippingService {
        <<interface>>
        +calculateShippingCost(orderId) void
        +scheduleDelivery(orderId, date) void
        +trackShipment(orderId) void
    }

    class InventoryManager {
        <<interface>>
        +checkProductAvailability(productId, qty) boolean
        +reserveProduct(productId, qty) void
        +releaseProductReservation(productId, qty) void
    }

    class NotificationSender {
        <<interface>>
        +sendOrderConfirmation(orderId) void
        +sendShippingNotification(orderId) void
        +sendDeliveryNotification(orderId) void
    }

    class ReportGenerator {
        <<interface>>
        +generateOrderReport(orderId) String
        +generateDailyReport(date) String
        +generateCustomerReport(customerId) String
    }

    class BasicOrderProcessor {
        +createOrder(customerId, productIds) void
        +cancelOrder(orderId) void
        +updateOrderStatus(orderId, status) void
    }

    class ShippingOrderProcessor {
        +createOrder(customerId, productIds) void
        +cancelOrder(orderId) void
        +updateOrderStatus(orderId, status) void
        +calculateShippingCost(orderId) void
        +scheduleDelivery(orderId, date) void
        +trackShipment(orderId) void
    }

    class CompleteOrderProcessor {
        -OrderManager orderManager
        -PaymentHandler paymentHandler
        -ShippingService shippingService
        -InventoryManager inventoryManager
        -NotificationSender notificationSender
        -ReportGenerator reportGenerator
    }

    OrderManager <|.. BasicOrderProcessor
    OrderManager <|.. ShippingOrderProcessor
    ShippingService <|.. ShippingOrderProcessor

    CompleteOrderProcessor o--> OrderManager
    CompleteOrderProcessor o--> PaymentHandler
    CompleteOrderProcessor o--> ShippingService
    CompleteOrderProcessor o--> InventoryManager
    CompleteOrderProcessor o--> NotificationSender
    CompleteOrderProcessor o--> ReportGenerator

    note for BasicOrderProcessor "SOLUCIÓN: Solo implementa
    lo que realmente necesita ✅"

    note for CompleteOrderProcessor "Usa composición para
    combinar funcionalidades ✅"
```

### Indicaciones:

1. **Identifica** por qué la interface `OrderProcessor` viola el principio ISP
2. **Analiza** qué problemas causa forzar implementaciones innecesarias
3. **Diseña** interfaces más pequeñas y específicas basadas en responsabilidades
4. **Implementa** en el paquete `com.solid.corrected`:
   - Interfaces segregadas: `OrderManager`, `PaymentHandler`, `ShippingService`, `InventoryManager`, `NotificationSender`, `ReportGenerator`
   - Clase `BasicOrderProcessor` que implemente solo `OrderManager`
   - Clase `ShippingOrderProcessor` que implemente `OrderManager` y `ShippingService`
   - Clase `CompleteOrderProcessor` que combine múltiples interfaces usando composición
   - Demuestra cómo las clases ahora solo dependen de lo que realmente necesitan

---

## Ejercicio 5: Violación del Principio DIP (Dependency Inversion Principle)

### Descripción del Problema:

La clase `OrderService` (alto nivel) depende directamente de implementaciones concretas de bajo nivel:

- Instancia directamente `EmailNotifier`, `SMSNotifier`, `FileLogger`, `DatabaseRepository`
- Está fuertemente acoplada a implementaciones específicas
- Es muy difícil de testear porque hace operaciones reales (archivos, emails, BD)
- Cualquier cambio en las dependencias requiere modificar `OrderService`

### Diagrama del Problema (Violación DIP):

```mermaid
classDiagram
    class OrderService {
        -EmailNotifier emailNotifier
        -SMSNotifier smsNotifier
        -FileLogger logger
        -DatabaseRepository repository
        +processOrder(customerId, productIds, notificationType) void
        +cancelOrder(orderId) void
    }

    class EmailNotifier {
        +sendEmail(recipient, subject, message) void
    }

    class SMSNotifier {
        +sendSMS(phoneNumber, message) void
    }

    class FileLogger {
        +log(message) void
    }

    class DatabaseRepository {
        +saveOrder(orderData) void
        +getCustomerData(customerId) String
    }

    OrderService --> EmailNotifier : depends on
    OrderService --> SMSNotifier : depends on
    OrderService --> FileLogger : depends on
    OrderService --> DatabaseRepository : depends on

    note for OrderService "PROBLEMA: Depende directamente
    de implementaciones concretas
    - Difícil de testear
    - Fuertemente acoplado
    - Viola DIP ❌"
```

### Diagrama de la Solución (Cumple DIP):

```mermaid
classDiagram
    class OrderService {
        -NotificationService notificationService
        -Logger logger
        -OrderRepository repository
        +OrderService(notificationService, logger, repository)
        +processOrder(customerId, productIds, notificationType) void
        +cancelOrder(orderId) void
    }

    class NotificationService {
        <<interface>>
        +sendNotification(type, recipient, message) void
    }

    class Logger {
        <<interface>>
        +log(message) void
    }

    class OrderRepository {
        <<interface>>
        +saveOrder(orderData) void
        +getCustomerData(customerId) String
    }

    class EmailNotificationService {
        +sendNotification(type, recipient, message) void
    }

    class FileLoggerService {
        +log(message) void
    }

    class DatabaseOrderRepository {
        +saveOrder(orderData) void
        +getCustomerData(customerId) String
    }

    class MockNotificationService {
        +sendNotification(type, recipient, message) void
    }

    class MockLogger {
        +log(message) void
    }

    class MockRepository {
        +saveOrder(orderData) void
        +getCustomerData(customerId) String
    }

    class DependencyInjector {
        +createOrderService() OrderService
        +createTestOrderService() OrderService
    }

    OrderService --> NotificationService : depends on abstraction
    OrderService --> Logger : depends on abstraction
    OrderService --> OrderRepository : depends on abstraction

    NotificationService <|.. EmailNotificationService
    Logger <|.. FileLoggerService
    OrderRepository <|.. DatabaseOrderRepository

    NotificationService <|.. MockNotificationService
    Logger <|.. MockLogger
    OrderRepository <|.. MockRepository

    DependencyInjector ..> OrderService : creates
    DependencyInjector ..> EmailNotificationService : injects
    DependencyInjector ..> FileLoggerService : injects
    DependencyInjector ..> DatabaseOrderRepository : injects

    note for OrderService "SOLUCIÓN: Depende de abstracciones
    - Fácil de testear con mocks
    - Bajo acoplamiento
    - Cumple DIP ✅"

    note for DependencyInjector "Factory para inyectar
    dependencias apropiadas"
```

### Indicaciones:

1. **Explica** cómo la clase `OrderService` viola el principio DIP con ejemplos específicos
2. **Identifica** los problemas de acoplamiento fuerte
3. **Diseña** una solución usando inyección de dependencias e inversión de control
4. **Implementa** en el paquete `com.solid.corrected`:
   - Interfaces para las dependencias: `NotificationService`, `Logger`, `OrderRepository`
   - Implementaciones concretas: `EmailNotificationService`, `FileLoggerService`, `DatabaseOrderRepository`
   - Implementaciones mock para testing: `MockNotificationService`, `MockLogger`, `MockRepository`
   - Nueva clase `OrderService` que reciba dependencias por constructor
   - ~~Factory o configurador para inyectar dependencias~~
   - Clase de prueba que demuestre testing con mocks

---

## Clase de Demostración

Crear `SolidViolationsDemo.java` en el paquete `com.solid.tests` que:

1. **Demuestre cada violación** ejecutando el código problemático
2. **Muestre los errores/problemas** que causan las violaciones
3. **Execute las versiones corregidas** mostrando cómo se resuelven los problemas
4. **Compare** las diferencias entre antes y después

### Estructura sugerida:

```java
public class SolidViolationsDemo {
    public static void main(String[] args) {
        demonstrateSRPViolation();
        demonstrateOCPViolation();
        demonstrateLSPViolation();
        demonstrateISPViolation();
        demonstrateDIPViolation();
    }
    // ... métodos de demostración
}
```

---

## Conceptos Clave Revisados

- **SRP**: Una clase debe tener una sola razón para cambiar
- **OCP**: Abierto para extensión, cerrado para modificación
- **LSP**: Las subclases deben ser sustituibles por sus clases base
- **ISP**: Los clientes no deben depender de interfaces que no usan
- **DIP**: Depender de abstracciones, no de implementaciones concretas

---

_Recuerda: Los principios SOLID no son reglas absolutas, sino guías para escribir código más mantenible, extensible y testeable._
