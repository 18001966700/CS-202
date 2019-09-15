import java.awt.Rectangle;
import java.awt.Point;
public class Monster {
    static int size=0;
    static int location[]={0,0,0};

    public static boolean canReach(int[] position) {
        int spaceModifier;
        switch(size){
            case 0://Tiny
                spaceModifier=10;
                break;
            case 1://Small
            case 2://Medium
                spaceModifier=20;
                break;
            case 3://Large
                spaceModifier=40;
                break;
            case 4://Huge
                spaceModifier=60;
                break;
            case 5://Gargantuan
                spaceModifier=80;
                break;
            default:
                spaceModifier=0;
        }
        Rectangle space = new Rectangle(
                (location[0]-(spaceModifier/2)),
                (location[1]+(spaceModifier/2)),
                spaceModifier, spaceModifier);
        Point point = new Point(position[0],position[1]);
        return space.contains(point);
    }
}
