/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

/**
 *
 * @author jacks
 */
public class DatabaseRepository {

    public void saveOrder(String orderData) {
        System.out.println("Guardando en base de datos: " + orderData);
        // Simulación de guardado en BD
    }

    public String getCustomerData(String customerId) {
        return "Datos del cliente " + customerId + " desde BD";
    }
}
