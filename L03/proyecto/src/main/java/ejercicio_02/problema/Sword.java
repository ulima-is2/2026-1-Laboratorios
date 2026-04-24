/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio_02.problema;

/**
 *
 * @author jacks
 */
public class Sword extends Weapon {

    public Sword(String platform) {
        this.name = "Espada";
        this.platform = platform;
        this.damage = 30;
    }

    @Override
    public void use() {
        if (platform.equals("PC")) {
            System.out.println("Espada PC con gráficos detallados");
        } else {
            System.out.println("Espada Mobile con gráficos simples");
        }
    }
}
