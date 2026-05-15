package com.ulima.is2.ejercicio_02.problema;

public class Cashier {

    public void processPayment(String type, double amount) {
        if (type.equalsIgnoreCase("cash")) {
            System.out.println("Procesando pago en efectivo");
            System.out.println("Monto recibido: S/ " + amount);
            System.out.println("Calculando cambio...");
        } else if (type.equalsIgnoreCase("card")) {
            System.out.println("Procesando pago con tarjeta");
            System.out.println("Validando tarjeta...");
            System.out.println("Conectando con el banco...");
        } else if (type.equalsIgnoreCase("mobile")) {
            System.out.println("Procesando pago móvil");
            System.out.println("Validando aplicación...");
            System.out.println("Verificando número telefónico...");
        } else {
            System.out.println("Método de pago no válido");
        }
    }
}