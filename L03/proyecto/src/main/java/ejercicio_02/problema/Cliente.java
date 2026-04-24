/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GameElementCreator creator = new GameElementCreator();

        // ❌ PROBLEMA: Nada garantiza que sean compatibles
        Character pcWarrior = creator.createCharacter("PC", "Warrior");
        Character mobileEnemy = creator.createCharacter("Mobile", "Enemy"); // Enemigo en otra plataforma!
        
        Weapon pcSword = creator.createWeapon("PC", "Sword");
        Weapon mobileClaw = creator.createWeapon("Mobile", "Claw"); // Arma para el enemigo

        // Equipar las armas
        pcWarrior.equipWeapon(pcSword);
        mobileEnemy.equipWeapon(mobileClaw);

        System.out.println("--- Inicio del combate ---");
        pcWarrior.attack(mobileEnemy);
        mobileEnemy.attack(pcWarrior);
        
        // ❌ PROBLEMA: Inconsistencia, el guerrero podría equipar un arma incompatible
        Weapon mobileSword = creator.createWeapon("Mobile", "Sword");
        pcWarrior.equipWeapon(mobileSword); // El guerrero PC equipando arma de Mobile
        System.out.println("--- Combate Inconsistente ---");
        pcWarrior.attack(mobileEnemy);
    }

}
