package com.ulima.is2.ejercicio_01.problema;

public class Kitchen {

    public void cookMainDish(String[] ingredients, int time) {
        System.out.println("Cocinando plato principal con " + String.join(" y ", ingredients));
        System.out.println("Tiempo de cocción: " + time + " minutos");
    }

    public void prepareHotDrink(String drink, int temperature) {
        System.out.println("Preparando bebida: " + drink);
        System.out.println("Temperatura: " + temperature + "°C");
    }

    public void prepareDessert(String dessert, String decoration) {
        System.out.println("Preparando postre: " + dessert);
        System.out.println("Decoración: " + decoration);
    }
}