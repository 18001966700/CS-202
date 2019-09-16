import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combat {
    List<Creature> combatants = new ArrayList<Creature>();
    List<Integer> initOrder = new ArrayList<Integer>();
    Creature currentCombatant = new Creature();

    public void join(Creature newCombatant) {
        newCombatant.initiative = Dice.roll() + newCombatant.dexterity;
        combatants.add(newCombatant);
        initOrder.add(newCombatant.initiative);
    }

    void decideTurns() {
        Collections.sort(initOrder);
        Collections.reverse(initOrder);
    }

    public void start() {
        for (int i = 0; i < initOrder.size(); i++) {
            if (initOrder.get(i) == combatants.get(i).initiative) {
                currentCombatant = combatants.get(i);
                takeTurn();
            }
        }
    }

    public void takeTurn(){
        System.out.println(currentCombatant.name);
    }
}
