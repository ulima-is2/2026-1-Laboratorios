/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public class ServiceProduct extends Product {

    public ServiceProduct(String name, double basePrice) {
        super(name, basePrice, 0.0);
    }

    @Override
    public double calculatePrice() {
        return basePrice * 1.1; // Incluye comisión de servicio
    }

    @Override
    public double calculateShippingCost() {
        // VIOLACIÓN LSP: Los servicios no se envían físicamente
        return 0.0; // Comportamiento inconsistente - debería ser null o excepción
    }

    @Override
    public boolean requiresPhysicalDelivery() {
        return false;
    }
}
