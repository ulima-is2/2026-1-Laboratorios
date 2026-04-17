/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import violations.OrderService;

/**
 *
 * @author jacks
 */
public class OrderServiceTest {

    public static void main(String[] args) {
        OrderService service = new OrderService();

        // PROBLEMA: No podemos inyectar mocks para testing
        // PROBLEMA: No podemos cambiar implementaciones sin modificar OrderService
        // PROBLEMA: Testing es difícil porque hace operaciones reales (archivos, emails)
        service.processOrder("CUSTOMER-123",
                new String[]{"PRODUCT-1", "PRODUCT-2"},
                "EMAIL");

        service.cancelOrder("ORDER-123");
    }
}
