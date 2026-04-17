/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public class PaymentProcessor {

    public boolean processPayment(String paymentMethod, double amount, String paymentData) {
        switch (paymentMethod.toUpperCase()) {
            case "CREDIT_CARD":
                return processCreditCard(amount, paymentData);
            case "PAYPAL":
                return processPayPal(amount, paymentData);
            case "BANK_TRANSFER":
                return processBankTransfer(amount, paymentData);
            case "BITCOIN":  // Nuevo método añadido recientemente
                return processBitcoin(amount, paymentData);
            // TODO: ¿Qué pasa si queremos agregar más métodos de pago?
            default:
                throw new IllegalArgumentException("Método de pago no soportado: " + paymentMethod);
        }
    }

    private boolean processCreditCard(double amount, String cardData) {
        System.out.println("Procesando pago con tarjeta de crédito por $" + amount);
        // Simulación de validación de tarjeta
        if (cardData.length() < 16) {
            return false;
        }
        System.out.println("Pago con tarjeta procesado exitosamente");
        return true;
    }

    private boolean processPayPal(double amount, String paypalData) {
        System.out.println("Procesando pago con PayPal por $" + amount);
        // Simulación de autenticación PayPal
        if (!paypalData.contains("@")) {
            return false;
        }
        System.out.println("Pago con PayPal procesado exitosamente");
        return true;
    }

    private boolean processBankTransfer(double amount, String bankData) {
        System.out.println("Procesando transferencia bancaria por $" + amount);
        // Simulación de validación bancaria
        if (bankData.length() < 10) {
            return false;
        }
        System.out.println("Transferencia bancaria procesada exitosamente");
        return true;
    }

    private boolean processBitcoin(double amount, String bitcoinAddress) {
        System.out.println("Procesando pago con Bitcoin por $" + amount);
        // Simulación de validación de Bitcoin
        if (!bitcoinAddress.startsWith("bc1") && !bitcoinAddress.startsWith("1")) {
            return false;
        }
        System.out.println("Pago con Bitcoin procesado exitosamente");
        return true;
    }

    public double calculateProcessingFee(String paymentMethod, double amount) {
        switch (paymentMethod.toUpperCase()) {
            case "CREDIT_CARD":
                return amount * 0.03;
            case "PAYPAL":
                return amount * 0.025;
            case "BANK_TRANSFER":
                return 5.0;
            case "BITCOIN":
                return amount * 0.001;
            default:
                return 0.0;
        }
    }
}
