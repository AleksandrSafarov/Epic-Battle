import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Unit> units;
    public Player(String name, ArrayList<Unit> units){
        this.name = name;
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    public boolean isDead(){
        for (Unit unit : units) {
            if (unit.health != 0) {
                return false;
            }
        }
        return true;
    }

}
