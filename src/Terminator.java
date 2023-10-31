import java.util.Random;

public class Terminator extends Unit{

    public Terminator(String name) {
        super(name);
        this.power = 15;
        this.defence = 7;
        this.CriticalChance = 2;
    }

    @Override
    public void attack(Unit unit) {
        Random rnd = new Random();
        int n = rnd.nextInt(100)+1;
        if (n <= CriticalChance){
            power = power*2;
            super.attack(unit);
            System.out.println("КРИТИЧЕСКИЙ УДАР. Юнит "+name+" увеличивает силу на 5, а сейчас наносит двойной урон " + unit.name);
            unit.getDamage(power);
            power = power/2 + 5;
            return;
        }
        Util.attackLog(this, unit);
        super.attack(unit);
        unit.getDamage(power);
    }

    @Override
    public String toString() {
        return "Terminator{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", defence=" + defence +
                ", power=" + power +
                ", CriticalChance=" + CriticalChance +
                ", ParryChance=" + ParryChance +
                '}';
    }
}
