/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_01.problema;

/**
 *
 * @author jacks
 */
public class RPGGame extends Game {

    public RPGGame() {
        this.name = "Epic Quest";
        this.genre = "RPG";
    }

    @Override
    public void start() {
        System.out.println("Iniciando aventura épica...");
        System.out.println("Selecciona tu clase de personaje");
    }
}
