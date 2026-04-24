/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_03.problema;

/**
 *
 * @author jacks
 */
public class GameSession {

    private GameConfig config;

    public GameSession() {
        this.config = new GameConfig(); //  Nueva instancia
        config.setMaxPlayers(50); // Configuración específica
    }

    public void startSession() {
        System.out.println("Iniciando sesión...");
        System.out.println("Máximo jugadores: " + config.getMaxPlayers());
        System.out.println("Debug mode: " + config.isDebugMode());
    }
}
