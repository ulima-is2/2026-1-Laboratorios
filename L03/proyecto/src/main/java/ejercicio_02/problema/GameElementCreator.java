/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public class GameElementCreator {

    public Character createCharacter(String platform, String type) {
        Character character = null;

        if (type.equals("Warrior")) {
            character = new Warrior(platform);
        } else if (type.equals("Enemy")) {
            character = new Enemy(platform);
        }
        // Más tipos en el futuro...

        return character;
    }

    public Weapon createWeapon(String platform, String type) {
        Weapon weapon = null;

        if (type.equals("Sword")) {
            weapon = new Sword(platform);
        } else if (type.equals("Claw")) {
            weapon = new Claw(platform);
        }
        // Más tipos en el futuro...

        return weapon;
    }
}
