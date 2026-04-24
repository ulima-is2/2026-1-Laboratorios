/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_01.problema;

/**
 *
 * @author jacks
 */
public class FPSGame extends Game {

    public FPSGame() {
        this.name = "Battle Arena";
        this.genre = "FPS";
    }

    @Override
    public void start() {
        System.out.println("Cargando mapa de combate...");
        System.out.println("Selecciona tu arma inicial");
    }
}
