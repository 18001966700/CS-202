public class Creature {
    String name;
    int strength = 3;
    int dexterity = 3;
    int constitution = 3;
    int intelligence = 3;
    int wisdom = 3;
    int charisma = 3;
    int initiative = Dice.roll() + dexterity;
    int speed = 0;
    int stance = 1;
    int[] location = {0, 0, 0};
}
