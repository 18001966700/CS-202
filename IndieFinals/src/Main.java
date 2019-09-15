import java.util.*;

public class Main {
    static Player current=new Player();
    static Dice d = new Dice();

    public static void main(String[] args){
        System.out.println("You rolled a " + d.roll() + ".");
    }

    static void decideTurnOrder(){

        obj obj1=new obj();
        obj1.text="Hi";
        obj1.init=15;

        obj obj2=new obj();
        obj2.text="Hello";
        obj2.init=30;

        obj obj3=new obj();
        obj3.text="Hey";
        obj3.init=20;

        List<Integer> initOrder=new ArrayList<Integer>();
        initOrder.add(obj1.init);
        initOrder.add(obj2.init);
        initOrder.add(obj3.init);
        Collections.sort(initOrder);
        Collections.reverse(initOrder);
        obj objx= new obj();
        for(int x=0; x<initOrder.size(); x++) {
            if (initOrder.get(x)==obj1.init){
                objx = obj1;
            } else if (initOrder.get(x)==obj2.init){
                objx = obj2;
            } else if (initOrder.get(x)==obj3.init){
                objx = obj3;
            } else {}
            System.out.println(objx.text);
            objx.text = "Bye";
            System.out.println(obj1.text);

        }
    }

    static void move(int distance, String direction, int terrain, int Modifier){
        int speed = current.speed * Modifier;
        if (
                speed>=distance && !current.isInDifficultTerrain() && !current.isProne() ||
                speed>=(distance*2) && current.isInDifficultTerrain() || current.isProne() ||
                speed>=(distance*3) && current.isInDifficultTerrain() && current.isProne()
        ){
        switch (direction){
            case "North":
                current.location[0]+=distance;
                speed-=distance;
                if(current.isInDifficultTerrain()){
                    speed-=distance;
                }
                if (current.isProne()){
                    speed-=distance;
                }
                break;

            case "NorthEast":
                current.location[0]+=distance;
                current.location[1]+=distance;
                speed-=distance;

            case "South":
                current.location[0]-=distance;
                speed-=distance;
                if(current.isInDifficultTerrain()){
                    speed-=distance;
                }
                if (current.isProne()){
                    speed-=distance;
                }
                break;
            case "East":
                current.location[1]+=distance;
                speed-=distance;
                if(current.isInDifficultTerrain()){
                    speed-=distance;
                }
                if (current.isProne()){
                    speed-=distance;
                }
                break;
            case "West":
                current.location[1]-=distance;
                speed-=distance;
                if(current.isInDifficultTerrain()){
                    speed-=distance;
                }
                if (current.isProne()){
                    speed-=distance;
                }
            default:
        }}else {
            System.out.println("Not enough speed to make movement.");
        }

    }

    static void switchProne(){
        if (current.isProne()){
            current.stance=1;
            current.speed/=2;
        } else {
            current.stance=0;
        }

    }
}


class obj{
    String text="nan";
    int init=0;
}

class Dice{
    static Random  r = new Random();

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

