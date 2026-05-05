package ejercicio_03.problema;

public class BasicPayment implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        System.out.println("Pagando: " + amount);
    }
}
