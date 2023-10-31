import java.util.Random;

public class Knight extends Unit{

    public Knight(String name) {
        super(name);
        this.health = 110;
    }
    @Override
    public void attack(Unit unit) {
        Random rnd = new Random();
        int n = rnd.nextInt(100)+1;
        if (n <= CriticalChance){
            power = 20;
            health += 15;
            super.attack(unit);
            System.out.println("КРИТИЧЕСКИЙ УДАР. Юнит "+name+" восстанавливает здоровье на 15, а сейчас наносит двойной урон " + unit.name);
            unit.getDamage(power);
            power = 10;
            return;
        }
        Util.attackLog(this, unit);
        super.attack(unit);
        unit.getDamage(power);
    }
    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", defence=" + defence +
                ", power=" + power +
                ", CriticalChance=" + CriticalChance +
                ", ParryChance=" + ParryChance +
                '}';
    }
}
