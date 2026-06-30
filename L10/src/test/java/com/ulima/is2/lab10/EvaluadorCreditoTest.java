package com.ulima.is2.lab10;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluadorCreditoTest {

    private final EvaluadorCredito evaluador = new EvaluadorCredito();

    // ==========================================
    // TESTS DE EJEMPLOS
    // ==========================================

    @Test
    public void testCamino1_RechazadoPorEdad() {
        // Camino donde edad < 18
        String resultado = evaluador.evaluarCredito(17, 2000, false, 5000);
        assertEquals("RECHAZADO_EDAD", resultado);
    }

    @Test
    public void testCamino6_AprobadoIdeal() {
        // Camino donde cumple todo, no tiene deudas y el monto es permitido
        String resultado = evaluador.evaluarCredito(30, 3000, false, 5000);
        assertEquals("APROBADO", resultado);
    }
    
    // ==========================================
    // TESTS PENDIENTES DE IMPLEMENTAR
    // ==========================================

    @Test
    public void testCamino2() {
        // TODO: Implementar
    }

    @Test
    public void testCamino3() {
        // TODO: Implementar
    }
    
    @Test
    public void testCamino4() {
        // TODO: Implementar
    }

    @Test
    public void testCamino5() {
        // TODO: Implementar
    }
}
