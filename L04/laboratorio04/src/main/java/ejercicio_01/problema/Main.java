package ejercicio_01.problema;

public class Main {
    public static void main(String[] args) {
        PaymentValidator validator = new PaymentValidator();
        PaymentGateway gateway = new PaymentGateway();
        NotificationService notifier = new NotificationService();
        double amount = 1500;
        try {
            // ❌ Cliente controla todo el flujo
            validator.validate(amount);
            gateway.process(amount);
            notifier.sendReceipt();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Otro caso
        System.out.println("\nOtro caso");
        double invalidAmount = -10;
        try {
            validator.validate(invalidAmount);
            gateway.process(invalidAmount);
            notifier.sendReceipt();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
