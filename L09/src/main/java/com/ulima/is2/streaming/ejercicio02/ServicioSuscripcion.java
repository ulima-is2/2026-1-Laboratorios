package com.ulima.is2.streaming.ejercicio02;

public interface ServicioSuscripcion {
    boolean cuentaEstaActiva(String idUsuario);
    String obtenerPlanSuscripcion(String idUsuario);
}
