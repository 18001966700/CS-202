import java.util.Random;

public class Dice{
    static Random r = new Random();

    public static int roll () {
        return r.nextInt(20);
    }

    public static int rollAdvantage(boolean disadvantage){
        int   firstRoll=r.nextInt(20);
        int   secondRoll=r.nextInt(20);

        if (disadvantage && firstRoll>secondRoll){
            return secondRoll;
        } else if (disadvantage) {
            return firstRoll;
        } else if (firstRoll>secondRoll){
            return firstRoll;
        } else {return secondRoll;}

    }
}