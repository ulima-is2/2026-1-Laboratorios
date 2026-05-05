package ejercicio_03.problema;

public class PaymentWithLogging implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("[LOG] Iniciando pago...");
        System.out.println("Pagando: " + amount);
        System.out.println("[LOG] Pago completado");
    }
}