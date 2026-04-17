/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public abstract class Product {

    protected String name;
    protected double basePrice;
    protected double weight;

    public Product(String name, double basePrice, double weight) {
        this.name = name;
        this.basePrice = basePrice;
        this.weight = weight;
    }

    public abstract double calculatePrice();

    public abstract double calculateShippingCost();

    public abstract boolean requiresPhysicalDelivery();

    // Método que todas las subclases deberían poder ejecutar
    public void processOrder() {
        System.out.println("Procesando pedido para: " + name);
        System.out.println("Precio: $" + calculatePrice());
        System.out.println("Costo envío: $" + calculateShippingCost());
        if (requiresPhysicalDelivery()) {
            System.out.println("Preparando para envío físico");
        }
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getWeight() {
        return weight;
    }
}
