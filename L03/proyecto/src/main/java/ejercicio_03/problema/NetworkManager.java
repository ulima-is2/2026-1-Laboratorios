/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_03.problema;

/**
 *
 * @author jacks
 */
public class NetworkManager {

    private GameConfig config;

    public NetworkManager() {
        this.config = new GameConfig(); //  Otra instancia diferente
        config.setDebugMode(true); // Configuración diferente
    }

    public void connect() {
        System.out.println("Conectando a: " + config.getDatabaseUrl());
        System.out.println("Debug mode: " + config.isDebugMode());
    }
}
