/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_01.problema;

/**
 *
 * @author jacks
 */
public class GameCreator {

    public Game createGame(String type) {
        Game game = null;

        if (type.equals("RPG")) {
            game = new RPGGame();
        } else if (type.equals("FPS")) {
            game = new FPSGame();
        } else {
            throw new IllegalArgumentException("Tipo de juego no soportado: " + type);
        }

        return game;
    }
}
