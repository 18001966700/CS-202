public class Main {

    public static void main(String[] args) {
        Player pc=new Player();
        Player p2=new Player();

        pc.setName("Bob");
        p2.setName("Aerith");

        Combat firstBattle= new Combat();
        firstBattle.join(pc);
        firstBattle.join(p2);
        firstBattle.start();
        System.out.println(pc.name);
        System.out.println(p2.name);

    }
}
