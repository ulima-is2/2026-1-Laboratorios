package com.ulima.is2.streaming.ejercicio02;

import com.ulima.is2.streaming.ejercicio01.OptimizadorCalidadVideo;

public class GestorReproduccion {

    private final ServicioSuscripcion servicioSuscripcion;
    private final ServicioCDN servicioCDN;
    private final OptimizadorCalidadVideo optimizador;

    public GestorReproduccion(ServicioSuscripcion servicioSuscripcion, ServicioCDN servicioCDN, OptimizadorCalidadVideo optimizador) {
        this.servicioSuscripcion = servicioSuscripcion;
        this.servicioCDN = servicioCDN;
        this.optimizador = optimizador;
    }

    public String iniciarReproduccion(String idUsuario, String idVideo, double anchoBandaMbps) {
        if (!servicioSuscripcion.cuentaEstaActiva(idUsuario)) {
            return "ERROR: Cuenta inactiva o suspendida";
        }

        if (!servicioCDN.cdnEstaDisponible()) {
            return "ERROR: Servicio CDN no disponible temporalmente";
        }

        String plan = servicioSuscripcion.obtenerPlanSuscripcion(idUsuario);
        
        // Usar lógica del ejercicio 01
        String calidad = optimizador.determinarCalidadOptima(anchoBandaMbps, plan);
        
        String url = servicioCDN.obtenerUrlVideo(idVideo, calidad);
        
        if (url == null || url.isEmpty()) {
            return "ERROR: Video no encontrado en calidad " + calidad;
        }

        return "Reproduciendo en " + calidad + " desde " + url;
    }
}
