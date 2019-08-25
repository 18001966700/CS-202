import java.util.*;

public class TextGame{
    private static Scanner in = new Scanner(System.in);
    private static int scene=0;
    private static String command;
    private static String[][] commands={
        {"?","help"},
{"quit", "exit"},
{}

    };

    private static int woke=0;


    static boolean isPlaying(){
        return scene<=0;
    }
    
    static void quit(){
        scene=-1;
    }

    static void display(String text){
        System.out.println("------------------------------------------------------------");
        System.out.println(text);
        System.out.println("------------------------------------------------------------");

    }

    static void getInput(){
        System.out.print("\n>");//Prefix for player input
        String input = " "+in.nextLine().toLowerCase()+" ";//With spaces to avoid cases where command word is inside input 
                                                           //e.g. "remove" is recognised as "move".
        System.out.println();

        for (int i = 0; i < commands.length; i++) { //Loops through each row
            for (int x = 0; x < commands[i].length; x++) { //Loops through each variable in the selected row
                if (input.contains(" "+commands[i][x]+" ")) { //Checks if player input contains variable
                    command = commands[i][0]; //Sets which row contains the player input
                }
            }
        }
    }

    static void checkCommonResponses(String command){

        switch(command) {
            case "q":
                display("The only winning move is not to play.");
                quit();
                break;
            case "?":
                display("Text enclosed in [] can be used to interact with the environment.\n"+
                        "Basic Commands:\n"+
                        " >[inspect] - get more info;\n" +
                        " >[move] - go to location;\n" +
                        " >[i] - check what's in your inventory;\n" +
                        " >[q] - to exit the game;\n");
            case "wake":
                display("You're already awake.");
                woke++;
                if(woke = 10){
                    playEnding(-1);
                }
            default:
                display("I couldn't understand that. Do you need [help]?"); 

        }
    }

    static void playPrologue() {
        d
        

    }


    static void playRoomScene() {

    }

    static void playEscapeScene() {
        
    }

    static void playPoliceScene() {
        
    }

    static void playPrisonScene() {
        
    }
    
    static void playEnding(int end) {
        switch(end){
            case -1:
                display("Dream ending"); 
                break;
            default:
                display("Game over");
        }

        quit();
    }

    public static void main(String[] args){
        System.out.println("Hi");
        while(TextGame.isPlaying()){
            switch(scene){
                case 0: playPrologue(); break;
                case 1: playRoomScene(); break;
                case 2: playEscapeScene(); break;
                case 3: playPoliceScene(); break;
                case 4: playPrisonScene(); break;
                default: 
                playEnding(0);
            }
        }
    }
}
