package com.ulima.is2.streaming.ejercicio02;

import com.ulima.is2.streaming.ejercicio01.OptimizadorCalidadVideo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class GestorReproduccionTest {

    @Mock
    private ServicioSuscripcion servicioSuscripcionMock;

    @Mock
    private ServicioCDN servicioCDNMock;

    @Mock
    private OptimizadorCalidadVideo optimizadorMock;

    @InjectMocks
    private GestorReproduccion gestor;

    @Test
    @DisplayName("Debe devolver error si la cuenta esta inactiva")
    void cuentaInactiva() {
        // Arrange
        // TODO: Simula que la cuenta está inactiva
        // when(servicioSuscripcionMock.cuentaEstaActiva("user123")).thenReturn(false);

        // Act
        // String resultado = gestor.iniciarReproduccion("user123", "video99", 15.0);

        // Assert
        // assertEquals("ERROR: Cuenta inactiva o suspendida", resultado);
        // TODO: Verifica que NO se llamó a servicioCDNMock
        // verifyNoInteractions(servicioCDNMock);
    }

    @Test
    @DisplayName("Debe reproducir el video correctamente si todo está bien")
    void reproduccionExitosa() {
        // Arrange
        // TODO: Configura los mocks para que:
        // 1. La cuenta esté activa
        // 2. El CDN esté disponible
        // 3. El plan sea "Premium"
        // 4. El optimizador devuelva "4K"
        // 5. El CDN devuelva "http://cdn.com/video99_4K.mp4"

        // Act
        // String resultado = gestor.iniciarReproduccion("user123", "video99", 30.0);

        // Assert
        // assertEquals("Reproduciendo en 4K desde http://cdn.com/video99_4K.mp4", resultado);
    }
}
