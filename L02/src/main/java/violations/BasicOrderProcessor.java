/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
// Esta clase solo maneja pedidos básicos pero debe implementar TODA la interface
public class BasicOrderProcessor implements OrdeProcessor {

    @Override
    public void createOrder(String customerId, String[] productIds) {
        System.out.println("Creando pedido básico para cliente: " + customerId);
    }

    @Override
    public void cancelOrder(String orderId) {
        System.out.println("Cancelando pedido: " + orderId);
    }

    @Override
    public void updateOrderStatus(String orderId, String status) {
        System.out.println("Actualizando estado del pedido " + orderId + " a: " + status);
    }

    // VIOLACIÓN ISP: Se ve obligada a implementar métodos que no necesita
    @Override
    public boolean processPayment(String orderId, String paymentMethod, String paymentData) {
        throw new UnsupportedOperationException("BasicOrderProcessor no maneja pagos");
    }

    @Override
    public void processRefund(String orderId, double amount) {
        throw new UnsupportedOperationException("BasicOrderProcessor no maneja reembolsos");
    }

    @Override
    public void calculateShippingCost(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no calcula envíos");
    }

    @Override
    public void scheduleDelivery(String orderId, String deliveryDate) {
        throw new UnsupportedOperationException("BasicOrderProcessor no programa entregas");
    }

    @Override
    public void trackShipment(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no rastrea envíos");
    }

    @Override
    public boolean checkProductAvailability(String productId, int quantity) {
        throw new UnsupportedOperationException("BasicOrderProcessor no maneja inventario");
    }

    @Override
    public void reserveProduct(String productId, int quantity) {
        throw new UnsupportedOperationException("BasicOrderProcessor no maneja inventario");
    }

    @Override
    public void releaseProductReservation(String productId, int quantity) {
        throw new UnsupportedOperationException("BasicOrderProcessor no maneja inventario");
    }

    @Override
    public void sendOrderConfirmation(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no envía notificaciones");
    }

    @Override
    public void sendShippingNotification(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no envía notificaciones");
    }

    @Override
    public void sendDeliveryNotification(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no envía notificaciones");
    }

    @Override
    public String generateOrderReport(String orderId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no genera reportes");
    }

    @Override
    public String generateDailyReport(String date) {
        throw new UnsupportedOperationException("BasicOrderProcessor no genera reportes");
    }

    @Override
    public String generateCustomerReport(String customerId) {
        throw new UnsupportedOperationException("BasicOrderProcessor no genera reportes");
    }
}
