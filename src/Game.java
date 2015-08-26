/*
 * This class is where the main interactivity between the user and the video game occurs. All user commands are accepted here
 * and specific operations are performed based on those commands. The class also provides the welcome message and any
 * information regarding the beginning and end of the game.
 */

public class Game {

    private Parser parser;
    private RoomDesign generate;

    public Game() {
        printGameStartInfo();
        generate = new RoomDesign();
        parser = new Parser();
        playGame();
    }

    // Officially starts the game and begins the loop of commands that takes a player throughout the dungeon until 'exit' has been typed.
    public void playGame() {
        try {
            boolean isGameFinished = false;
            while (!isGameFinished) {
                Commands command = parser.getCommand();
                isGameFinished = initiateCommand(command);
            }
            System.out.println("Thank you for playing. Farewell.");
            System.exit(0);
        }

        catch (Exception e) {
            System.out.println("Please input a string command only.");
        }
    }

    // Checks what keyword was inputed by the user to determine an action, i.e. typing 'inventory' opens the player's inventory.
    private boolean initiateCommand(Commands command) {
        boolean exitGame = false;

        if (command.isUnknownWord()) {
            System.out.println("Please input a valid command");
            return false;
        }

        String commandWord = command.getFirstCommand();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("info")) {
            generate.showPlayerInfo();
        } else if (commandWord.equals("inventory")) {
            generate.showInventory();
        }
        /*else if(commandWord.equals("map"))
        {
        	_____________________________	// Create Map class with GUI
        }*/
        else if (commandWord.equals("go")) {
            generate.goRoom(command);
        } else if (commandWord.equals("grab")) {
            generate.grabItem(command);
        } else if (commandWord.equals("drop")) {
            generate.dropItem(command);
        } else if (commandWord.equals("equip")) {
            generate.equipItem(command);
        } else if (commandWord.equals("unequip")) {
            generate.unequipItem(command);
        } else if (commandWord.equals("fight")) {
            generate.fightMonster(command);
        } else if (commandWord.equals("spellbook")) {
            parser.showAllSpells();
        } else if (commandWord.equals("exit")) {
            exitGame = exit(command);
        } else {
            System.out.println("You are traveling in the dungeon. You cannot use combat commands at this time.\n");
        }
        return exitGame;
    }

    // Prints the introduction of the game to the user.
    private void printGameStartInfo() {
        System.out.println("You are an adventurer in the town of Prospero, isolated\n"
                + "and surrounded by mountains, woodlands, and a river flowing on its\n"
                + "eastern outskirts. On the border of the town, along a wall of mountains, lies\n"
                + "the mysterious Dungeon. The people of Prospero warn of deadly creatures that lurk\n"
                + "within its cavernous depths. Your sense of adventure is heightened and\n"
                + "you decide to venture forth, eager to bring fortune and fame to your name.\n");

    }

    // Prints a short description of the game and all the available command words.
    private void printHelp() {
        System.out.println("You are in the Prospero dungeons, alone, wandering. Your command words are:\n");
        parser.showTravelCommands();
    }

    // Exits the game if 'exit' was inputed. If 'exit' has a 2nd word, the terminal asks the user what they wish to exit out of.
    private boolean exit(Commands command) {
        if (command.hasSecondWord() == false) {
            System.out.println("Exit what? To exit the game, type 'exit'\n");
            return false;
        } else {
            return true;
        }
    }
}