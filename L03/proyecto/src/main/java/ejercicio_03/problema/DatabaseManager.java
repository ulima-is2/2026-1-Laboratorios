package ejercicio_03.problema;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jacks
 */
public class DatabaseManager {

    private GameConfig config;

    public DatabaseManager() {
        this.config = new GameConfig(); //  Tercera instancia
        config.setDatabaseUrl("jdbc:mysql://production:3306/gamedb"); // Configuración diferente
    }

    public void saveData() {
        System.out.println("Guardando en: " + config.getDatabaseUrl());
        System.out.println("Máximo jugadores permitidos: " + config.getMaxPlayers());
    }
}
