package ejercicio_03.problema;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor p1 = new BasicPayment();
        System.out.println("Pago Basico");
        p1.pay(100);

        PaymentProcessor p2 = new PaymentWithLogging();
        System.out.println("\nPago con logging");
        p2.pay(100);

        PaymentProcessor p3 = new PaymentWithDiscount();
        System.out.println("\nPago con descuento");
        p3.pay(100);

        PaymentProcessor p4 = new PaymentWithFraudCheck();
        System.out.println("\nPago con chequeo de fraude");
        p4.pay(1500);

        PaymentProcessor p5 = new PaymentWithLoggingAndDiscount();
        System.out.println("\nPago con logging y descuento");
        p5.pay(100);
    }
}
