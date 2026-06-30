package com.ulima.is2.lab10;

public class EvaluadorCredito {

    /**
     * Evalúa la solicitud de un crédito basado en distintos factores de riesgo.
     * 
     * @param edad          Edad del solicitante
     * @param salario       Salario mensual del solicitante
     * @param tieneDeudas   Si el solicitante tiene deudas pendientes activas
     * @param montoPrestamo Monto solicitado para el préstamo
     * @return              El estado de la evaluación: APROBADO o el motivo del rechazo.
     */
    public String evaluarCredito(int edad, double salario, boolean tieneDeudas, int montoPrestamo) {
        if (edad < 18) { // Decisión 1
            return "RECHAZADO_EDAD";
        }
        
        if (salario < 1000) { // Decisión 2
            return "RECHAZADO_SALARIO";
        }
        
        if (tieneDeudas) { // Decisión 3
            if (salario < 2000) { // Decisión 4
                return "RECHAZADO_DEUDAS";
            }
        }
        
        if (montoPrestamo > (salario * 3)) { // Decisión 5
            return "RECHAZADO_MONTO";
        }
        
        return "APROBADO";
    }
}
