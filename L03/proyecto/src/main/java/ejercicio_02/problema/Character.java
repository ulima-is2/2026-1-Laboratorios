/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public abstract class Character {

    protected String name;
    protected String platform;
    protected int health = 100;
    protected Weapon weapon;

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
        System.out.println(this.name + " equipó " + weapon.name);
    }

    public abstract void attack(Character target);

    public void takeDamage(int damage) {
        this.health -= damage;
        System.out.println(this.name + " (" + this.platform + ") recibe " + damage + " de daño. Vida restante: " + this.health);
    }

    public String getInfo() {
        return "Personaje: " + name + " | Plataforma: " + platform + " | Vida: " + health;
    }
}
