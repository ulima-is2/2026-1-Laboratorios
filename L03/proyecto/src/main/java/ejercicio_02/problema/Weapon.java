/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public abstract class Weapon {

    protected String name;
    protected String platform;
    protected int damage;

    public abstract void use();

    public int getDamage() {
        return damage;
    }

    public String getInfo() {
        return "Arma: " + name + " | Plataforma: " + platform + " | Daño: " + damage;
    }
}
