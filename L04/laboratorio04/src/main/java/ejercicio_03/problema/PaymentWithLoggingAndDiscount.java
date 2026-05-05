package ejercicio_03.problema;

public class PaymentWithLoggingAndDiscount implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Iniciando pago...");
        double discounted = amount * 0.9;
        System.out.println("Pagando con descuento: " + discounted);
        System.out.println("[LOG] Pago completado");
    }
}