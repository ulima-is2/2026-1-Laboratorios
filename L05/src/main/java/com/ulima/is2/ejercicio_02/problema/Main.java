package com.ulima.is2.ejercicio_02.problema;

public class Main {

    public static void main(String[] args) {
        Cashier cashier = new Cashier();
        cashier.processPayment("cash", 150);
        cashier.processPayment("card", 320);
        cashier.processPayment("mobile", 89);
    }
}