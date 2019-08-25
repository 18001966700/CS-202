import java.util.Scanner;

public class jonasprelim {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Declare the Dictionaries
        String[][] commands =   {
                                    {"?", "help"},
                                    {"quit", "exit game", "stop playing", "end game"},
                                    {"inspect", "examine", "look", "check"},
                                    {"interact", "talk", "use", "call"},
                                    {"move", "go", "transfer to", "enter"},
                                    {"take", "get", "acquire", "carry"},
                                    {"inventory", "items", "do i have"},
                                    {"wake", "get up", "rise", "awaken", "arise"},
                                    {"hide"},
                                    {"brace", "wait"},
                                    {"clash","fight", "open", "push"},
                                    {"obey", "get down", "comply"},
									{"claim","say"},
									{"kill"}

                                };

        String [][] objects1 =  {
                                    {"area", "room", "surroundings", "around"},
                                    {"jonas", "body", "corpse"},
                                    {"bed"},
									{"ignorance"},
									{"yes"},
										{"roommate"}
                                };
        String playerCommand;
        String playerObject;

        //Declare outputs for commands
        String helpText =   "          +============================================+\n" +
                            "          |                INSTRUCTIONS                |\n" +
                            "          |--------------------------------------------|\n" +
                            "          | Important text are enclosed in **.         |\n" +
                            "          | Commands are enclosed in [].               |\n" +
                            "          | Commands let you interact with the world.  |\n" +
                            "          | Use one command at a time.                 |\n" +
                            "          | i.e. \"command object\"                      |\n" +
                            "          |                                            |\n" +
                            "          |               Basic Commands:              |\n" +
                            "          | >[inspect] - get more info;                |\n" +
                            "          | >[interact] - talk or use;                 |\n" +
                            "          | >[move] - go to location;                  |\n" +
                            "          | >[take] - put into inventory;              |\n" +
                            "          | >[items] - check what's in your inventory; |\n" +
                            "          | >[quit] - to exit the game;                |\n" +
                            "          +============================================+\n";

        String lookText = "You stare into emptiness";

        String useText = "You twiddle your thumbs";

        String moveText = "You start fidgeting in place";

        String takeText = "You grasp at straws";

        String playerItems = "your *phone*";
        String itemsText = "You have " + playerItems + " in your inventory right now";

        //Declare outputs for the story
        String sceneText =  "          +============================================+\n" +
                            "          |            MYCAH'S UNTITLED STORY          |\n" +
                            "          |--------------------------------------------|\n" +
                            "          |         A CS202 Prelim Exam Project        |\n" +
                            "          | By:                                        |\n" +
                            "          |   >Mycah Cabual                            |\n" +
                            "          |   >Noah Angelo Dizon                       |\n" +
                            "          |   >Edzil Ven Lariza                        |\n" +
                            "          +============================================+\n";
        //Scene 1
        String roomText =   "You look around the *room* you're in. It look's like a small apartment.\n" +
                            "You see a *closet* next to the *bed*. Across the room, you see a *bathroom*.\n" +
                            "Sunlight filters in through a nearby *window*. Opposite that, \n" +
                            "you see what seems to be the front *door*. \n";
        String jonasText = "You look at *Jonas*. He was your friend.";
        String bedText ="You examine the *bed*. It looks like any other bed except for the bloodstains";

        //Declare other game variables
        Boolean jonasHidden = false;
        Boolean jonasChecked = false;
        Boolean roommateChecked = false;
        int wake=0;
        int hidingSpot = 0;
        int guilt = 3;
        int questions = 0;
        double scene = 0.0;
        double actionsTaken = 0.0;

        // Title Card
        System.out.println(sceneText);

        //Introduction
        while (scene == 0.0) {

            System.out.println("------------------------------------------------------------------");
            System.out.println("Enter [wake up] to start.");
            System.out.println("Enter [help] at any time for instructions.");
            System.out.println("Enter [quit] at any time to exit the game.");
            System.out.println("------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            //Checks if player input is in Dictionary
            playerCommand="";//Resets playerAction
            for (int i = 0; i < commands.length; i++) { //Loops through each row
                for (int x = 0; x < commands[i].length; x++) { //Loops through each variable in the selected row
                    if (playerInput.contains(" "+commands[i][x]+" ")) { //Checks if player input contains variable
                        playerCommand = commands[i][0]; //Sets which row contains the player input
                    }
                }
            }

            if (playerCommand == "?") {
                System.out.println(helpText); //Displays the output for hejalp then loops
            } else if (playerCommand == "wake") {
                scene = 1.0; //Goes to scene 1
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
                return;
            }else {
                System.out.println("------------------------------------------------------------------");
                System.out.println("You are still asleep.");
            }

        }

        //Scene 1 Tutorial
        while (scene == 1.00) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println( "You wake up to find yourself covered in a warm crimson fluid.\n" +
                                "You should [inspect] the *area*.");
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "inspect" && playerObject == "area") {
                sceneText = "You look around you. You are on a *bed* within a *room* you don't know\n" +
                            "Your eyes venture to the side of your bed. \n" +
                            "You see your friend *Jonas* covered in that same red liquid. \n" +
                            "You look at your stained hands as you realize its blood.";
                scene = 1.10;
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
                return;
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println("You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 1.10 Waking up
        while (scene == 1.10) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (actionsTaken >=1) {
                sceneText =         "You suddenly hear a knock on the door. You begin to panic as you\n" +
                                    "realize the situation you're in. You try to think of something quick.\n" +
                                    "You could *answer* the door. You could try to *hide* somewhere. \n" +
                                    "You could try to find a way out.";
                scene = 1.11;

            } else if (playerCommand == "inspect" && playerObject == "area") {
                sceneText = roomText;
                if (!jonasHidden){
                    sceneText = sceneText + "*Jonas* lies on the floor nearby.";
                }

            } else if (playerCommand == "inspect" && playerObject == "bed") {
                sceneText = bedText;
                    if(!playerItems.contains("knife")) {
                        sceneText = sceneText + "Looking under it, You find a *knife*.";
                    }

            } else if (playerCommand == "inspect" && playerObject == "jonas") {
                    sceneText = jonasText;
                    if(!jonasHidden) {
                        sceneText = sceneText + "Blood pools from under him now. \n";
                    }

                    sceneText = sceneText + "He hasn't stirred since you woke up.";

                    if(!jonasChecked) {
                        sceneText = sceneText + "You should try to [call] out to him.";
                    }
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact" && playerObject == "jonas") {
                sceneText =         "\"JONAS!\" you cry\n" +
                                    "\"Jonas! please wake up\" you feel the weight on your shoulders from\n" +
                                    "the troubled past jonas has left you with.";
                jonasChecked = true;
                actionsTaken = actionsTaken + 1.0;
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
                return;
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println("You input something I can't understand. Maybe you should as for [help]?");
            }

        }

        //Scene 1.11 Knock
        while (scene == 1.11) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "inspect" && playerObject == "area") {
                sceneText = "You look around you. You are on a *bed* within a *room* you don't know\n" +
                            "Your eyes venture to the side of your bed. \n" +
                            "You see your friend *Jonas* covered in that same red liquid. \n" +
                            "You look at your stained hands as you realize its blood.";
                scene = 1.1;
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if ((playerCommand == "move" && playerCommand == "closet") || playerCommand == "hide") {
                sceneText = "You hide in the nearby closet. Not much room to move around here.\n" +
                            "You hear the door slam open. \"Jonas!\" a man's voice shouts \n" +
                            "\"Dispatch, I got an officer down here. Requesting back up. \" \n" +
                            "You see his shadow move around through the slit of light under the door. \n" +
                            "His shadow grows larger. Soon, You hear his footsteps as you realise\n" +
                            "He's getting closer. You prepare to [brace] yourself for some sort of [clash]. \n";
                hidingSpot = 1;
                scene = 1.12;
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
                return;
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 1.12 Hidden
        while (scene == 1.12) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "brace") {
                sceneText = "The door opens. \n" +
                            "You stare down the barrel of a [gun]. The man holding it wears the same\n" +
                            "uniform your friend wore just yesterday. The memory fills you with sorrow\n" +
                            "\"Get down on the ground!\" the *officer* commands. \n" +
                            "You catch his dark eyes dart around the room as he waits for you to [obey]";
                scene = 1.13;
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 1.13 Questions
        while (scene == 1.13) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "obey") {
                sceneText =         "You take a deep breath to settle yourself as you get on your knees.\n" +
                                    "\"What happened here?\" The officer demands. \n" +
                                    "Your mind races as you try to think of what to do. \n " +
                                    "You could be cooperative [claim] *ignorance*, *guilt*, or *innocence*.\n" +
                                    "You could [resist] and act with hostility or find a way to [fight] back. " +
                                    "or you could just [remain] *silent*";
            } else if (playerCommand == "claim" && playerObject == "ignorance") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You tell the officer that you have no idea what's going on\n" +
                                    "\"Don't move.\" he commands. \"I'm taking you in for questioning\".\n" +
                                    "He pushes you all the way to the ground and binds your hands. \n" +
                                    "The next events pass by in a blur.");
                System.out.println( "-----------------------------------------------------------------------");
                sceneText =         "You find yourself entering a grim and gloomy room.\n" +
                                    "\"Take a seat\" He points to a chair and you slowly walk over and\n" +
                                    "sitdown in anticipation for your inevitable doom.\n" +
                                    "The officer introduces himself. \n" +
                                    "You watch him slide a picture in front of you as he asks:\n"+
                                    "\"Do you recognize this man?\". It's a picture of Jonas.\n"+
                                    "You want to [say] *yes* and tell him Jonas was your friend but that \n"+
                                    "might implicate you further so maybe you should just tell him *no* \n";
									questions = 3;
                scene = 2.0;
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 1.2 Escape
        while (scene == 1.20) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 2 Station
        while (scene == 2.00) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "say" && playerObject =="yes" || questions == 3) {
                if (guilt > 0) {
                    System.out.println( "-----------------------------------------------------------------------");
                    System.out.println("You're finding it hard to keep track of everything that's happening: waking up" +
										"in that room, Jonas, getting arrested then interrogated. The next thing you know you're" +
										"on trial for murder; The evidence weighing against you. The verdict? guilty.");
                    System.out.println( "-----------------------------------------------------------------------");
                    sceneText = "You've been serving your sentence quietly when a rough-looking man approaches you\n" +
                                "You've heard of him before. He's part of the possy after all. They're one of the most notorious gangs\n " +
                                "around here. He tells you he's giving you an opportunity: You do a job for them and in exchange" +
								"you get protection." +
								" You think about it hard; You could [accept] but the rumors are that to get into the possy you pay with blood." +
								"On the other hand, You shudder to think of the price you would pay if you [reject] him. \n";

                }
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 3 Prison
        while (scene == 3.00) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "accept") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(	"You tell him you'll do it. Hearing that, he hands you a *shiv*. The job, he explains, is simple." +
									"All you'll have to do is take out the guy you share the cell with tonight. He trusts there won't be a problem and with that" +
									"he leaves before you can say anything.");
                sceneText = "The day passes by quickly after that." +
                            "At night, you go back your cells. You lie awake on your bed. The weight of what you have to do stuck on your mind. " +
                            "Your roommate is in the same cell, oblivious to the situation you're in.";
                scene = 3.10;
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Scene 3.1 Test
        while (scene == 3.10) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "kill") {
                if (roommateChecked) {
                    System.out.println(	"As the shiv pierces him, your roommate struggles but it was all in vain." +
										"His blood splatters all over as he tries to fight back. Soon his body goes limp on the" +
										"floor next to your bed, A pool of blood beginning to form.");
                    System.out.println( "-----------------------------------------------------------------------");
                    System.out.println( "-----------------------------------------------------------------------");
                    sceneText = "You wake up to find yourself covered in a cold crimson fluid.\n" +
								"You should [inspect] the *area*.";
                    scene = 4.00;

                }
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }


        //End
        while (scene == 4.00) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake + 1;
                if (wake > 10) {
                    scene = 100.0;
                }
            }else if (playerCommand == "inspect" && playerObject == "area") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(	"You look around you. You are on a bed within your know familiar cell\n" +
									"Your eyes venture to the side of your bed. \n" +
									"You see your roommate covered in that same red liquid. \n");
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "It's a testament to the influence of the possy that you got off with" +
                                    "a slap on the wrist that day. Since then, you've done a lot of jobs for them" +
                                    "and sent others to do the same job because of thet you've made a lot of enemies." +
									"They say \"What comes around goes around\" though." +
                                    "Soon enough, \"You wake up to find yourself covered in a warm crimson fluid.\" one last time." +
									"It's an all too familiar sight. No need to inspect the area this time though, you already know \n" +
									"what the fluid is and this time its your blood staining the sheets. " +
									"You look at your stained hands and go back to sleep.");
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "----------------------------------END----------------------------------");
                System.out.println( "-----------------------------------------------------------------------");

            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }

        //Waking up
        while (scene == 100) {
            System.out.println( "-----------------------------------------------------------------------");
            System.out.println(sceneText);
            System.out.println( "-----------------------------------------------------------------------");
            System.out.print("\nYou: ");
            String input = in.nextLine();
            String playerInput = " "+input.toLowerCase()+" ";
            System.out.println();

            playerCommand=""; playerObject="";
            for (int i = 0; i < commands.length; i++) {
                for (int x = 0; x < commands[i].length; x++) {
                    if (playerInput.contains(" "+commands[i][x]+" ")) {
                        playerCommand = commands[i][0];
                    }
                }
            }

            for (int i = 0; i < objects1.length; i++) {
                for (int x = 0; x < objects1[i].length; x++) {
                    if (playerInput.contains(" "+objects1[i][x]+" ")) {
                        playerObject = objects1[i][0];
                    }
                }
            }

            if (playerCommand=="?") {
                System.out.println(helpText);
            } else if (playerCommand == "wake") {
                System.out.println("You're already awake");
                wake = wake +1;
                if (wake>10){scene = 100.0;}
            } else if (playerCommand == "inspect") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(lookText);
            } else if (playerCommand == "interact") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(useText);
            } else if (playerCommand == "move") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(moveText);
            } else if (playerCommand == "take") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(takeText);
            } else if (playerCommand == "inventory") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println(itemsText);
            } else if (playerCommand == "quit") {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "                The only winning move is not to play.                  ");
                System.out.println( "-----------------------------------------------------------------------");
            } else {
                System.out.println( "-----------------------------------------------------------------------");
                System.out.println( "You input something I can't understand. Maybe you should ask for [help]?");
            }

        }
    }
}
