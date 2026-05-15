package com.ulima.is2.ejercicio_01.problema;

public class Waiter {

    private Kitchen kitchen;

    public Waiter() {
        kitchen = new Kitchen();
    }

    public void prepareOrder(String type, Object... details) {

        if (type.equalsIgnoreCase("main")) {
            String[] ingredients = (String[]) details[0];
            int time = (int) details[1];
            kitchen.cookMainDish(ingredients, time);
        } else if (type.equalsIgnoreCase("drink")) {
            String drink = (String) details[0];
            int temperature = (int) details[1];
            kitchen.prepareHotDrink(drink, temperature);
        } else if (type.equalsIgnoreCase("dessert")) {
            String dessert = (String) details[0];
            String decoration = (String) details[1];
            kitchen.prepareDessert(dessert, decoration);
        } else {
            System.out.println("Tipo de orden no válido");
        }
    }
}