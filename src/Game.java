import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static Player player1;
    private static Player player2;

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        Game.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        Game.player2 = player2;
    }

    public static int isWon(){
        if(getPlayer1().isDead())
        {
            return 2;
        }
        if(getPlayer2().isDead())
        {
            return 1;
        }
        return 0;
    }
    public static void deleteUnit() {
        ArrayList<Unit> lst1 = player1.getUnits();
        ArrayList<Unit> lst2 = player2.getUnits();
        for (int i = 0; i < lst1.size(); i++) {
            if (lst1.get(i).health == 0) {
                Util.UnitDeath(lst1.get(i).name);
                lst1.remove(i);
                player1.setUnits(lst1);
                deleteUnit();
                break;
            }
        }
        for (int i = 0; i < lst2.size(); i++) {
            if (lst2.get(i).health == 0) {
                Util.UnitDeath(lst2.get(i).name);
                lst2.remove(i);
                player2.setUnits(lst2);
                deleteUnit();
                break;
            }

        }
        return;
    }

    public static int chooseAttacker(Player attacker){
        ArrayList<Unit> u = attacker.getUnits();
        int AUNum = -1;
        for(int i=0;i<u.size();i++){
            if (u.get(i).getType().equals("wizard") && u.get(i).getMana() > 0){
                AUNum = i;
                break;
            }
        }
        if(AUNum == -1){
            Random rnd = new Random();
            AUNum = rnd.nextInt(u.size());
        }
        return AUNum;
    }

    public static int chooseDefencer(Player defender){
        ArrayList<Unit> u = defender.getUnits();
        int DUNum = -1;
        for(int i=0;i<u.size();i++){
            if (u.get(i).getType().equals("wizard")){
                DUNum = i;
                break;
            }
        }
        if(DUNum == -1){
            int minHealth = 1000;
            for(int i=0;i<u.size();i++){
                if(u.get(i).getHealth() < minHealth){
                    minHealth = u.get(i).getHealth();
                    DUNum = i;
                }
            }
        }
        if(DUNum == -1){
            DUNum = 0;
        }
        return DUNum;
    }
}
