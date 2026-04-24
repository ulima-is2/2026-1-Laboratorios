package ejercicio_02.problema;

public class Claw extends Weapon {

    public Claw(String platform) {
        this.name = "Garra";
        this.platform = platform;
        this.damage = 25;
    }

    @Override
    public void use() {
        if (platform.equals("PC")) {
            System.out.println("Garra PC con rasguños realistas");
        } else {
            System.out.println("Garra Mobile con rasguños simples");
        }
    }
}
