package com.ulima.is2.streaming.ejercicio01;

public class OptimizadorCalidadVideo {

    /**
     * Determina la resolución óptima ("4K", "1080p", "720p", "480p")
     * @param anchoBandaMbps El ancho de banda del usuario en Mbps.
     * @param esDispositivoMovil Si es true, el máximo es 1080p (ahorro de datos).
     * @param planSuscripcion El plan ("Basico", "Estandar", "Premium").
     * @return Resolución sugerida.
     */
    public String determinarCalidadOptima(double anchoBandaMbps, String planSuscripcion) {
        if (anchoBandaMbps <= 0) {
            throw new IllegalArgumentException("Ancho de banda inválido");
        }

        // Basico max 720p, Premium max 4K
        if ("Basico".equalsIgnoreCase(planSuscripcion)) {
            if (anchoBandaMbps >= 5.0) {
                return "720p";
            }
            return "480p";
        }

        if ("Premium".equalsIgnoreCase(planSuscripcion)) {
            if (anchoBandaMbps >= 25.0) {
                return "4K";
            } else if (anchoBandaMbps >= 10.0) {
                return "1080p";
            } else if (anchoBandaMbps >= 5.0) {
                return "720p";
            }
            return "480p";
        }

        throw new IllegalArgumentException("Plan no reconocido");
    }
}
