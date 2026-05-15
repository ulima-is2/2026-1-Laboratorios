package com.ulima.is2.ejercicio_01.problema;

public class Waiter {

    private Kitchen kitchen;

    public Waiter() {
        kitchen = new Kitchen();
    }

    public void prepareOrder(String type, String details) {

        if (type.equalsIgnoreCase("main")) {
            String[] data = details.split(",");
            String ingredients = data[0];
            int time = Integer.parseInt(data[1]);
            kitchen.cookMainDish(ingredients, time);
        } else if (type.equalsIgnoreCase("drink")) {
            String[] data = details.split(",");
            String drink = data[0];
            int temperature = Integer.parseInt(data[1]);
            kitchen.prepareHotDrink(drink, temperature);
        } else if (type.equalsIgnoreCase("dessert")) {
            String[] data = details.split(",");
            String dessert = data[0];
            String decoration = data[1];
            kitchen.prepareDessert(dessert, decoration);
        } else {
            System.out.println("Tipo de orden no válido");
        }
    }
}