/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public class Warrior extends Character {

    public Warrior(String platform) {
        this.name = "Guerrero";
        this.platform = platform;
    }

    @Override
    public void attack(Character target) {
        int damage = (this.weapon != null) ? this.weapon.getDamage() : 5; // 5 de daño base sin arma
        if (platform.equals("PC")) {
            System.out.println("Guerrero PC ataca con efectos en HD a " + target.name);
        } else {
            System.out.println("Guerrero Mobile ataca con efectos básicos a " + target.name);
        }
        if (this.weapon != null) {
            this.weapon.use();
        }
        target.takeDamage(damage);
    }
}
