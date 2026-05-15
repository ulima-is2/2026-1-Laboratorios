package com.ulima.is2.ejercicio_01.problema;

public class Main {

    public static void main(String[] args) {

        Waiter waiter = new Waiter();
        waiter.prepareOrder("main", new String[]{"Pollo", "papas"}, 25);
        waiter.prepareOrder("drink", "Café", 70);
        waiter.prepareOrder("dessert", "Cheesecake", "Fresas");
    }
}