import java.util.Random;

public class Wizard extends Unit{

    public Wizard(String name) {
        super(name);
        this.power = 25;
        this.defence = 3;
        this.mana = 100;
        this.type = "wizard";
    }

    @Override
    public void attack(Unit unit) {
        Random rnd = new Random();
        int n = rnd.nextInt(100)+1;
        if (n <= CriticalChance){
            mana += 20;
            power = 40;
            super.attack(unit);
            System.out.println("КРИТИЧЕСКИЙ УДАР. Юнит "+name+" восстанавливает 20 маны и наносит 40 урона " + unit.name);
            unit.getDamage(power);
            power = 25;
            return;
        }
        Util.attackLog(this, unit);
        mana -= 10;
        super.attack(unit);
        if(mana <=0){
            mana = 0;
            power = 8;
        }
        unit.getDamage(power);
    }

    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name +
                ", mana=" + mana +
                ", health=" + health +
                ", defence=" + defence +
                ", power=" + power +
                ", CriticalChance=" + CriticalChance +
                ", ParryChance=" + ParryChance +
                '}';
    }
}
