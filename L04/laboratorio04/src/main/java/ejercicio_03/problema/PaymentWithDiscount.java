package ejercicio_03.problema;

public class PaymentWithDiscount implements PaymentProcessor {
    @Override
    public void pay(double amount) {
        double discounted = amount * 0.9;
        System.out.println("Pagando con descuento: " + discounted);
    }
}