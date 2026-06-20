package com.ulima.is2.streaming.ejercicio02;

public interface ServicioCDN {
    String obtenerUrlVideo(String idVideo, String calidad);
    boolean cdnEstaDisponible();
}
