package com.ulima.is2.lab10;

public class ValidadorRegistro {

    /**
     * Valida el registro de un nuevo usuario en el sistema.
     * 
     * @param nombre            Nombre de usuario (No puede estar vacío)
     * @param email             Correo electrónico (Debe contener un @)
     * @param edad              Edad del usuario (Debe ser mayor o igual a 18)
     * @param tipoDocumento     Tipo de documento (Solo permite "DNI" o "CE")
     * @param numeroDocumento   Número de documento (Debe tener exactamente 8 caracteres, sin importar el tipo)
     * @return                  true si el registro es válido, false en caso contrario
     */
    public boolean registrarUsuario(String nombre, String email, int edad, String tipoDocumento, String numeroDocumento) {
        
        // 1. Validar nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }

        // 2. Validar email
        if (email == null || !email.contains("@")) {
            return false;
        }

        // 3. Validar edad
        if (edad < 18) {
            return false;
        }

        // 4. Validar tipoDocumento
        if (tipoDocumento == null || (!tipoDocumento.equals("DNI") && !tipoDocumento.equals("CE"))) {
            return false;
        }

        // 5. Validar numeroDocumento
        if (numeroDocumento == null || numeroDocumento.length() != 8) {
            return false;
        }
        
        return true; // Todo válido
    }
}
