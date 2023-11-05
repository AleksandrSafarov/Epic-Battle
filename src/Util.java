public class Util {
    public static void getState(){
        if(Scenary.state == 0) {
            System.out.println("Здарова");
            System.out.println("Игрок 1: " + Game.getPlayer1().getName());
            System.out.println("Отряд: ");
            for (int i = 0; i < Game.getPlayer1().getUnits().size(); i++) {
                System.out.println(Game.getPlayer1().getUnits().get(i));
            }
            System.out.println("___________________________");
            System.out.println("Игрок 2: " + Game.getPlayer2().getName());
            System.out.println("Отряд: ");
            for (int i = 0; i < Game.getPlayer2().getUnits().size(); i++) {
                System.out.println(Game.getPlayer2().getUnits().get(i));
            }
        }
    }

    public static void attackLog(Unit attacker, Unit defencer){
        System.out.println(attacker.name + " пробует нанести " + defencer.name + " " + attacker.power+" урон");
    }
    public static void getDamageLog(int damage, Unit defencer){
        System.out.println(defencer.name + " получает " + (damage - defencer.defence) + " урон, у него " + defencer.health + " здоровья");
    }

    public static void parryLog(int damage, Unit defencer){
        System.out.println("ПАРИРОВАНИЕ. " + defencer.name + " отразил " + (damage) + " урон, у него " + defencer.health + " здоровья");
    }

    public static void newRound(){
        if(Scenary.round == 1){
            System.out.println("___________________________");
            System.out.println("Раунд 1. Ход "+Game.getPlayer1().getName());
            System.out.println("___________________________");
            return;
        }
        System.out.println("___________________________");
        System.out.println("Игрок 1: " + Game.getPlayer1().getName());
        System.out.println("Отряд: ");
        for (int i = 0; i < Game.getPlayer1().getUnits().size(); i++) {
            System.out.println(Game.getPlayer1().getUnits().get(i));
        }
        System.out.println("___________________________");
        System.out.println("Игрок 2: " + Game.getPlayer2().getName());
        System.out.println("Отряд: ");
        for (int i = 0; i < Game.getPlayer2().getUnits().size(); i++) {
            System.out.println(Game.getPlayer2().getUnits().get(i));
        }
        System.out.println("___________________________");
        if(Scenary.round%2==1) {
            System.out.println("Раунд " + Scenary.round + ". Ход " + Game.getPlayer1().getName());
        }
        else{
            System.out.println("Раунд " + Scenary.round + ". Ход " + Game.getPlayer2().getName());
        }
        System.out.println("___________________________");
    }
    public static void endRound(){
        System.out.println("___________________________");
        System.out.println("Конец раунда");
        System.out.println("___________________________");
    }

    public static void UnitDeath(String name){
        System.out.println("Юнит "+name+" погиб.");
    }

    public static void GameOver(int playerNum, String name){
        System.out.println("Игрок "+playerNum+", "+name+", победил!");
    }
}
