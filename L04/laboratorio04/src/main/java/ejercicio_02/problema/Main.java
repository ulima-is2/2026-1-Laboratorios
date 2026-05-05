package ejercicio_02.problema;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment("paypal", 100);
        service.processPayment("stripe", 200);
        service.processPayment("mercadopago", 300);
    }
}
