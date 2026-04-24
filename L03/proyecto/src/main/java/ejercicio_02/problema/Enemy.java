package ejercicio_02.problema;

public class Enemy extends Character {

    public Enemy(String platform) {
        this.name = "Enemigo";
        this.platform = platform;
        this.health = 150; // Los enemigos pueden tener más vida
    }

    @Override
    public void attack(Character target) {
        int damage = (this.weapon != null) ? this.weapon.getDamage() : 5; // 5 de daño base sin arma
        if (platform.equals("PC")) {
            System.out.println("Enemigo PC ataca con furia en alta resolución a " + target.name);
        } else {
            System.out.println("Enemigo Mobile ataca con furia pixelada a " + target.name);
        }
        if (this.weapon != null) {
            this.weapon.use();
        }
        target.takeDamage(damage);
    }
}
