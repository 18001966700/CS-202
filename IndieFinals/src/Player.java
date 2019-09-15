public class Player {
    static int strength = 3;
    static int dexterity = 3;
    static int constitution = 3;
    static int intelligence = 3;
    static int wisdom = 3;
    static int charisma = 3;
    static int initiative = Dice.roll() + dexterity;
    static int speed = 0;
    static int stance = 1;
    static int[] location = {0, 0, 0};
    static int terrain;

    public static boolean isInDifficultTerrain(){
        return terrain==0;
    }

    public static boolean isProne(){
        return stance==0;
    }

}

