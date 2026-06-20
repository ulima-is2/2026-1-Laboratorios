package com.ulima.is2.streaming.ejercicio01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class OptimizadorCalidadVideoTest {

    private OptimizadorCalidadVideo optimizador;

    @BeforeEach
    void setUp() {
        optimizador = new OptimizadorCalidadVideo();
    }

    @Test
    @DisplayName("Debe lanzar excepcion si el ancho de banda es menor o igual a cero")
    void anchoBandaInvalido() {
        // TODO: Completa la prueba usando assertThrows
        // assertThrows(IllegalArgumentException.class, () -> {
        //     optimizador.determinarCalidadOptima(0, "Basico");
        // });
    }

    @Test
    @DisplayName("Plan Basico con ancho de banda alto debe dar 720p")
    void planBasicoConBuenAnchoBanda() {
        // TODO: Completa la prueba
        // String resultado = optimizador.determinarCalidadOptima(6.0, "Basico");
        // assertEquals("720p", resultado);
    }
    
    // TODO: Agrega más pruebas para cubrir todos los casos de Plan Basico y Premium.
    // ¡Ten en cuenta todos los valores límite para matar a todos los mutantes generados por PITest!
}
