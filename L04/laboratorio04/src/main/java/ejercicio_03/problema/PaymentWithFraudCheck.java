package ejercicio_03.problema;

public class PaymentWithFraudCheck implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        if (amount > 1000) {
            System.out.println("⚠ Revisando posible fraude...");
        }
        System.out.println("Pagando: " + amount);
    }
}