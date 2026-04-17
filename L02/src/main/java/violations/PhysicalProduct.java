/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public class PhysicalProduct extends Product {

    public PhysicalProduct(String name, double basePrice, double weight) {
        super(name, basePrice, weight);
    }

    @Override
    public double calculatePrice() {
        return basePrice * 1.15; // Incluye impuestos
    }

    @Override
    public double calculateShippingCost() {
        return weight * 2.5; // $2.5 por kg
    }

    @Override
    public boolean requiresPhysicalDelivery() {
        return true;
    }
}
