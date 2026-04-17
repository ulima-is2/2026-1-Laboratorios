/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package violations;

import java.util.regex.Pattern;

/**
 *
 * @author jacks
 */
public class User {

    private String name;
    private String email;
    private String userType; // "PREMIUM", "REGULAR", "VIP"
    private double totalPurchases;

    public User(String name, String email, String userType, double totalPurchases) {
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.totalPurchases = totalPurchases;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public double getTotalPurchases() {
        return totalPurchases;
    }

    public void setTotalPurchases(double totalPurchases) {
        this.totalPurchases = totalPurchases;
    }

    // Responsabilidad 1: Validación de usuario
    public boolean validateUser() {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (email == null || !isValidEmail(email)) {
            return false;
        }
        return userType != null && (userType.equals("PREMIUM")
                || userType.equals("REGULAR") || userType.equals("VIP"));
    }

    private boolean isValidEmail(String email) {
        return Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches();
    }

    // Responsabilidad 2: Cálculo de descuentos
    public double calculateDiscount() {
        switch (userType) {
            case "PREMIUM":
                return totalPurchases > 1000 ? 0.20 : 0.15;
            case "VIP":
                return totalPurchases > 2000 ? 0.30 : 0.25;
            default:
                return totalPurchases > 500 ? 0.10 : 0.05;
        }
    }

    // Responsabilidad 3: Envío de notificaciones
    public void sendWelcomeEmail() {
        System.out.println("Enviando email de bienvenida a: " + email);
        System.out.println("Asunto: ¡Bienvenido " + name + "!");
        System.out.println("Cuerpo: Gracias por registrarte como usuario " + userType);
    }

    // Responsabilidad 4: Generación de reportes
    public String generateUserReport() {
        return "=== REPORTE DE USUARIO ===\n"
                + "Nombre: " + name + "\n"
                + "Email: " + email + "\n"
                + "Tipo: " + userType + "\n"
                + "Total Compras: $" + totalPurchases + "\n"
                + "Descuento Aplicable: " + (calculateDiscount() * 100) + "%\n";
    }
}
