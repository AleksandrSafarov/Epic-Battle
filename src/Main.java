import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void RandomAddUnits(ArrayList<Unit> lst){
        if(lst.size() == 3){
            return;
        }
        Random rnd = new Random();
        int n = rnd.nextInt(3);
        if(n==0){
            lst.add(new Wizard("wizard"+rnd.nextInt(1000)));
        }
        else if(n==1){
            lst.add(new Terminator("terminator"+rnd.nextInt(1000)));
        }
        else{
            lst.add(new Knight("knight"+rnd.nextInt(1000)));
        }
        RandomAddUnits(lst);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать в Epic Battle");
        System.out.println("Введите имя: ");
        String name = scan.nextLine();
        System.out.println("___________________________");
        ArrayList<Unit> u1 = new ArrayList<Unit>();
        ArrayList<Unit> u2 = new ArrayList<Unit>();
        System.out.println("Выберите юнитов в свой отряд");
        while(u1.size()!=3){
            System.out.println("Юнит "+(u1.size()+1)+":");
            System.out.println("1 - Wizard; 2 - Terminator; 3 - Knight");
            int num = scan.nextInt();
            System.out.println("Введите имя юнита (одно слово): ");
            String UName = scan.next();
            if(num == 1){
                u1.add(new Wizard(UName));
            }
            else if(num == 2){
                u1.add(new Terminator(UName));
            }
            else{
                u1.add(new Knight(UName));
            }
        }
        RandomAddUnits(u2);
        Player p1 = new Player(name, u1);
        Player p2 = new Player("Dio Branto", u2);
        Game.setPlayer1(p1);
        Game.setPlayer2(p2);
        Util.getState();
        Scenary.state++;
        int finalRound = 0;
        while(Game.isWon() == 0){
            Util.newRound();
            Player attacker;
            Player defencer;
            if(Scenary.round%2==1){
                attacker = Game.getPlayer1();
                defencer = Game.getPlayer2();
            }
            else{
                attacker = Game.getPlayer2();
                defencer = Game.getPlayer1();
            }
            Unit AttackerUnit;
            int AUNum;
            int DUNum;
            Unit DefencerUnit;
            if(Scenary.round%2==1){
                System.out.println("Выберите своего атакующего юнита:");
                for(int i=0;i<attacker.getUnits().size();i++){
                    System.out.print((i+1) + " - "+attacker.getUnits().get(i).name + "; ");
                }
                AUNum = scan.nextInt() - 1;
                AttackerUnit = attacker.getUnits().get(AUNum);
                System.out.println("Выберите кого будет атаковать ваш юнит:");
                for(int i=0;i<defencer.getUnits().size();i++){
                    System.out.print((i+1) + " - "+defencer.getUnits().get(i).name + "; ");
                }
                DUNum = scan.nextInt() - 1;
                DefencerUnit = defencer.getUnits().get(DUNum);
            }
            else{
                AUNum = Game.chooseAttacker(attacker);
                DUNum = Game.chooseDefencer(defencer);
                AttackerUnit = attacker.getUnits().get(AUNum);
                DefencerUnit = defencer.getUnits().get(DUNum);
            }
            AttackerUnit.attack(DefencerUnit);
            ArrayList<Unit> APU = attacker.getUnits();
            ArrayList<Unit> DPU = defencer.getUnits();
            APU.set(AUNum, AttackerUnit);
            DPU.set(DUNum, DefencerUnit);
            attacker.setUnits(APU);
            defencer.setUnits(DPU);
            if(Scenary.round%2==1){
                Game.setPlayer1(attacker);
                Game.setPlayer2(defencer);
            }
            else{
                Game.setPlayer2(attacker);
                Game.setPlayer1(defencer);
            }
            finalRound = Scenary.round;
            Scenary.round++;
            Game.deleteUnit();
            Util.endRound();
        }
        if(finalRound%2==1){
            Util.GameOver(1, Game.getPlayer1().getName());
        }
        else{
            Util.GameOver(2, Game.getPlayer2().getName());
        }
    }
}