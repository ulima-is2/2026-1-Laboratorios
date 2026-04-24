/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_01.problema;

/**
 *
 * @author jacks
 */
public abstract class Game {
    protected String name;
    protected String genre;

    public abstract void start();

    public String getInfo() {
        return "Juego: " + name + " | Género: " + genre;
    }
}