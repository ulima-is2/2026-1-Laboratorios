/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
// Clase de alto nivel que DEPENDE DIRECTAMENTE de implementaciones concretas
public class OrderService {
    // VIOLACIÓN DIP: Dependencias concretas instanciadas directamente

    private EmailNotifier emailNotifier = new EmailNotifier();
    private SMSNotifier smsNotifier = new SMSNotifier();
    private FileLogger logger = new FileLogger();
    private DatabaseRepository repository = new DatabaseRepository();

    public void processOrder(String customerId, String[] productIds, String notificationType) {
        logger.log("Iniciando procesamiento de pedido para cliente: " + customerId);

        // Lógica de negocio
        String customerData = repository.getCustomerData(customerId);
        logger.log("Datos de cliente obtenidos: " + customerData);

        // Crear pedido
        String orderId = "ORDER-" + System.currentTimeMillis();
        String orderData = "Pedido " + orderId + " para cliente " + customerId;

        // Guardar en base de datos
        repository.saveOrder(orderData);
        logger.log("Pedido guardado: " + orderId);

        // Enviar notificación (fuertemente acoplado)
        if ("EMAIL".equals(notificationType)) {
            emailNotifier.sendEmail("customer@email.com",
                    "Confirmación de Pedido",
                    "Su pedido " + orderId + " ha sido procesado");
        } else if ("SMS".equals(notificationType)) {
            smsNotifier.sendSMS("+123456789",
                    "Pedido " + orderId + " confirmado");
        }
        // TODO: ¿Qué pasa si queremos agregar notificaciones push?

        logger.log("Pedido procesado completamente: " + orderId);
    }

    public void cancelOrder(String orderId) {
        logger.log("Cancelando pedido: " + orderId);

        // PROBLEMA: Si queremos cambiar a un logger diferente o 
        // a un repositorio diferente, tenemos que modificar esta clase
        repository.saveOrder("CANCELLED: " + orderId);
        emailNotifier.sendEmail("customer@email.com",
                "Pedido Cancelado",
                "Su pedido " + orderId + " ha sido cancelado");

        logger.log("Pedido cancelado: " + orderId);
    }

    // PROBLEMA: Esta clase es muy difícil de testear porque depende
    // de implementaciones concretas (archivo, email real, etc.)
    // PROBLEMA: Cualquier cambio en las dependencias requiere
    // modificar esta clase (viola Open/Closed también)
}
