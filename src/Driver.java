/*
 * The driver class of the video game. Provides the main menu, help menu with instructions, and quit buttons.
 * It also officially begins the game with the 'Play' option.
 */

import java.util.Scanner;

class Driver {
	
	private Scanner selection;
	@SuppressWarnings("unused") private Game game;

	// Performs various actions based on selection by the user from the main menu.
	public void consequence()
	{
		try{
			System.out.println("1. Play Game\n2. Help Menu\n3. Exit");
			selection = new Scanner(System.in);
			int decision = selection.nextInt();
		
			while(true)
			{
				if(decision == 1)
				{
					game = new Game();
				}
				else if(decision == 2)
				{
					System.out.println("1. General Instructions\n2. How to Play\n3. Player Information\n4. Back");
					selection = new Scanner(System.in);
					int helpDecision = selection.nextInt();
					if(helpDecision == 1)
					{
						printHelp1();
					}
					else if(helpDecision == 2)
					{
						printHelp2();
					}
					else if(helpDecision == 3)
					{
						printHelp3();
					}
					else if(helpDecision == 4)
					{
						consequence();
					}
				}
				else if(decision == 3)
				{
					System.out.println("Good bye!");
					System.exit(0);
				}
			}
		}
		
		catch(Exception e)
		{
			System.out.println("Please input integers only to make your selection.\n");
			consequence();
		}
	}
	
	// Answers 'General Instructions' from the Help Menu.
	public static void printHelp1()
	{
		System.out.println("This is a text-based game that receives 2 keywords provided by the user as 'commands'\n"
				+ "and then performs an action. The goal of the game is to traverse a dungeon until you\n"
				+ "reach the end of the game and fight the 'boss' which is terrorizing the town which lies\n"
				+ "outside of the dungeon entrance. Along the way you will fight monsters, interact with\n"
				+ "various NPC's dwelling in the caverns, collect new items, and make a name for yourself\n"
				+ "as you actively seek to end the town's suffering by slaying the antagonist.\n");
	}
	
	// Answers 'How to Play'from the Help Menu.
	public static void printHelp2()
	{
		System.out.println("You will be using keywords to navigate through the game. Here are some of the ones available:\n"
				+ "go, grab, drop, equip, map, help, inventory\n"
				+ "The rest of the list can be found within the game via typing 'help'.\n"
				+ "You also have 4 directions to move toward: North, West, South, and East. Some of\n"
				+ "these directions may not be possible depending on the exits of the room you are located in.\n"
				+ "An example of a 'move' command would be: go north\n"
				+ "You can also equip items using 'equip [insert item name here]' or drop them with the\n"
				+ "same syntax. The item name MUST be put together: i.e. 'equip steelsword'. Typing\n"
				+ "'help' also gives you the directions to move toward and any available options.\n");
	}
	
	// Answers 'Player Information' from the Help Menu.
	public static void printHelp3()
	{
		System.out.println("Your player character has an HP meter, mana total, and inventory where he/she can store\n"
				+ "items, equip them, or drop them. You can also interact with nearby NPC's who can sell\n"
				+ "you items or give you helpful tips as to powerful, nearby items, or even where to go.\n"
				+ "You can acquire gold to barter with merchants for strong weapons as well and level up to\n"
				+ "increase your character's skillset and become a powerful adventurer.\n");
	}
}