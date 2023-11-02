import java.util.Random;

public class Unit {
    protected String name;
    protected int health = 100;
    protected int defence = 5;
    protected int power = 10;
    protected int CriticalChance = 1;
    protected int ParryChance = 1;
    protected String type = "Unit";
    protected int mana = 0;
    public Unit(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCriticalChance() {
        return CriticalChance;
    }

    public void setCriticalChance(int criticalChance) {
        CriticalChance = criticalChance;
    }

    public int getParryChance() {
        return ParryChance;
    }

    public void setParryChance(int parryChance) {
        ParryChance = parryChance;
    }

    public String getType() {
        return type;
    }

    public int getMana() {
        return mana;
    }

    public void attack(Unit unit){

    }

    public void getDamage(int damage){
        Random rnd = new Random();
        int n = rnd.nextInt(100) + 1;
        if(n <= defence ){
            Util.parryLog(damage, this);
            return;
        }
        this.health -= damage + this.defence;
        if(this.health<0){
            this.health = 0;
        }
        Util.getDamageLog(damage, this);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", power=" + power +
                '}';
    }
}
