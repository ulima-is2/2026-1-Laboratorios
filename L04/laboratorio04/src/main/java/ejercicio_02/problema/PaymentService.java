package ejercicio_02.problema;

public class PaymentService {
    public void processPayment(String type, double amount) {
        if (type.equalsIgnoreCase("paypal")) {
            PayPalAPI paypal = new PayPalAPI();
            paypal.sendPayment(amount);
        } else if (type.equalsIgnoreCase("stripe")) {
            StripeAPI stripe = new StripeAPI();
            stripe.makeCharge(amount);
        } else if (type.equalsIgnoreCase("mercadopago")) {
            MercadoPagoAPI mp = new MercadoPagoAPI();
            mp.pagar(amount);
        } else {
            throw new RuntimeException("Proveedor no soportado");
        }
    }
}
