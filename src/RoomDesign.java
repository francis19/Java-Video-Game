/*
 * Provides the layout of the entire dungeon and each room's specifications, including exits, items, and monsters.
 * Also contains the methods for operations such as grabbing/dropping, equipping/unequipping items, and starting
 * the battle system which allows the user to fight a monster in a room.
 */

public class RoomDesign {
	
	public Room currentRoom;
	public Item currentItem;
	public Monster currentMonster;
	private Player player;
	private Potion potion;
	private Skills skills;
	@SuppressWarnings("unused")
	private BattleSystem battle;
	private boolean isWeaponEquipped;
	private boolean isArmorEquipped;

	public RoomDesign()
	{
		player = new Player();
		skills = new Skills();
		currentItem = new Item("","",0,0);
		potion = new Potion("","",0,0);
		potion.createAllItems();
		isWeaponEquipped = false;
		isArmorEquipped = false;
		currentItem.createAllItems();
		generateFloor1();
	}
	
	// Generates all the rooms in the game, their exits, descriptions, items, and monsters.
	public void generateFloor1()
	{
		Room startingRoom, armory, room1, room2, room3, room4, room5, room6, room7, room8, room9, room10, room11, room12, room13, room14, bossRoom, healingRoom1,
		healingRoom2, treasureRoom1, treasureRoom2, floorRoom, teleportation;
		
		startingRoom = new Room("the entrance to the dungeon. Tread lightly.");
		armory = new Room("a worn out, abandoned armory with a few rusted items.");
		room1 = new Room("a dim, dark room.");
		room2 = new Room("a dim, dark room.");
		room3 = new Room("a dim, dark room.");
		room4 = new Room("a dim, dark room.");
		room5 = new Room("a dim, dark room.");
		room6 = new Room("a dim, dark room.");
		room7 = new Room("a dim, dark room.");
		room8 = new Room("a dim, dark room.");
		room9 = new Room("a dim, dark room.");
		room10 = new Room("a dim, dark room.");
		room11 = new Room("a dim, dark room.");
		room12 = new Room("a dim, dark room.");
		room13 = new Room("a dim, dark room.");
		room14 = new Room("a dim, dark room.");
		teleportation = new Room("a magical room for teleportation.");
		treasureRoom1 = new Room("a dim, dark room with some items in a corner.");
		treasureRoom2 = new Room("a dim, dark room with some items in a corner.");
		healingRoom1 = new Room("a dim, dark room with potions nearby.");
		healingRoom2 = new Room("a dim, dark room with potions nearby.");
		bossRoom = new Room("a dreadful, vast room containing something powerful...");
		floorRoom = new Room("a dim, dark room with a ladder leading deeper into the dungeon. Beware.");
		
		// Sets all the exits for each room.
		startingRoom.setExit("east", armory);
		armory.setExit("east", room1); armory.setExit("west", startingRoom);
		room1.setExit("south", room2); room1.setExit("west", armory);
		room2.setExit("east", room3); room2.setExit("north", room1);
		room3.setExit("north", room4); room3.setExit("south", room5); room3.setExit("west", room2);
		room4.setExit("south", room3);
		room5.setExit("east", room6); room5.setExit("north",  room3);
		room6.setExit("south", room7); room6.setExit("west", room5);
		room7.setExit("east", healingRoom1); room7.setExit("west", room9); room7.setExit("south", room8); room7.setExit("north", room6);
		healingRoom1.setExit("west", room7);
		room8.setExit("east", treasureRoom1); room8.setExit("north", room7);
		treasureRoom1.setExit("west", room8);
		room9.setExit("south", room10); room9.setExit("east", room7); room9.setExit("west", teleportation);
		teleportation.setExit("east", room9); teleportation.setExit("north", room14);
		room10.setExit("west", room11); room10.setExit("north", room9);
		room11.setExit("south",  room12); room11.setExit("east", room10);
		room12.setExit("west", room13); room12.setExit("east", healingRoom2); room12.setExit("north", room11);
		healingRoom2.setExit("west", room12);
		room13.setExit("south", room14); room13.setExit("east", room12);
		room14.setExit("east", bossRoom); room14.setExit("north", room13);
		bossRoom.setExit("east", treasureRoom2); bossRoom.setExit("west", room14);
		treasureRoom2.setExit("east", floorRoom); treasureRoom2.setExit("west", bossRoom);
		floorRoom.setExit("west", bossRoom);
		
		// Sets all the items in each room.
		armory.setItem("rustedshortsword", currentItem.getItem("rustedshortsword"));
		room1.setItem("hidearmor", currentItem.getItem("hidearmor"));
		room4.setItem("bronzeshortsword", currentItem.getItem("bronzeshortsword"));
		room7.setItem("ironaxe", currentItem.getItem("ironaxe"));
		treasureRoom1.setItem("chainmail", currentItem.getItem("chainmail"));
		healingRoom1.setItem("healingpotion", currentItem.getItem("healingpotion"));
		healingRoom2.setItem("healingpotion", currentItem.getItem("healingpotion"));
		treasureRoom2.setItem("ironlongsword", currentItem.getItem("ironlongsword"));
		room3.setItem("manapotion", currentItem.getItem("manapotion"));
		room10.setItem("manapotion", currentItem.getItem("manapotion"));
		
		Monster rat, spider, wolf, goblin, skeleton, ghoul, elemental, wraith, lich;
		
		rat = new Monster("rat", 5, 4, 5, 3, 5);
		spider = new Monster("spider", 10, 6, 7, 5, 7);
		wolf = new Monster("wolf", 15, 7, 9, 10, 10);
		goblin = new Monster("goblin", 15, 7, 10, 12, 15);
		skeleton = new Monster("skeleton", 15, 9, 12, 15, 10);
		ghoul = new Monster("ghoul", 20, 12, 15, 20, 10);
		elemental = new Monster("elemental", 25, 11, 12, 15, 0);
		wraith = new Monster("wraith", 30, 14, 15, 20, 15);
		lich = new Monster("lich", 150, 15, 25, 50, 100);
		
		// Sets all the monsters in each room.
		room1.setMonster("rat", rat);
		room2.setMonster("rat", rat);
		room3.setMonster("spider", spider);
		room4.setMonster("goblin", goblin);
		room5.setMonster("spider", spider);
		room6.setMonster("skeleton", skeleton);
		room7.setMonster("wolf", wolf);
		room8.setMonster("elemental", elemental);
		room9.setMonster("rat", rat);
		room10.setMonster("spider", spider);
		room11.setMonster("wolf", wolf);
		room12.setMonster("ghoul", ghoul);
		room13.setMonster("wraith", wraith);
		bossRoom.setMonster("lich", lich);
		
		// Sets the startingRoom to be the first room that the player begins his adventure.
		currentRoom = startingRoom;
		System.out.println(currentRoom.getLongDescription());
	}
	
	// Takes the user to the desired room if the intended direction is valid. If the direction is invalid, returns an error message.
	public void goRoom(Commands command)
	{
		if(command.hasSecondWord() != false)
		{
			System.out.println("Where would you like to 'go'?\n");
			return;
		}
		
		String direction = command.getSecondCommand();
		Room nextRoom = currentRoom.getExit(direction);
		
		if(nextRoom == null)
		{
			System.out.println("There is no dungeon room in that direction.\n");
		}
		else
		{
			currentRoom = nextRoom;
			System.out.println(currentRoom.getLongDescription());
		}
	}
	
	// Takes the user to the BattleSystem class where all combat occurs.
	public void fightMonster(Commands command)
	{
		if(command.hasSecondWord() != false)
		{
			System.out.println("What monster would you like to 'fight'?\n");
			return;
		}
		
		String monster = command.getSecondCommand();
		Monster newMonster = currentRoom.getMonster(monster);
		
		if(newMonster == null)
		{
			System.out.println("There is no monster by that name in this room.\n");
		}
		else
		{
			currentMonster = newMonster;
			battle = new BattleSystem(player, currentMonster, skills, currentRoom, currentMonster.getMonsterHP());
		}
	}
	
	// Allows the user to grab a specific item if the item name is valid and it is within the current room.
	public void grabItem(Commands command)
	{
		if(command.hasSecondWord() != false)
		{
			System.out.println("What item would you like to grab?\n");
			return;
		}
		
		String item = command.getSecondCommand();
		Item newItem = currentRoom.getItem(item);
		
		if(newItem == null)
		{
			System.out.println("There is no such item in this room.\n");
		}
		else
		{
			currentItem = newItem;
			if(currentItem.getWeight() > player.getCarryCap())
			{
				System.out.println("You are carrying too much weight to add this item to your inventory.\n");
			}
			else
			{
				player.lessCarryCapacity(currentItem.getWeight());
				player.addInventory(currentItem);
				currentRoom.removeItem(item);
				player.sortInventory();
				System.out.println(currentItem.getItemName() + " " + currentItem.getDescription());
			}
		}
	}
	
	// Allows the user to drop a specific item if the item name is valid and it is in the player's inventory.
	public void dropItem(Commands command)
	{
		if(command.hasSecondWord() != false)
		{
			System.out.println("What item would you like to drop?\n");
			return;
		}
		
		String item = command.getSecondCommand();
		Item newItem = currentItem.getItem(item);
		
		if(newItem == null)
		{
			System.out.println("There is no such item in your inventory.\n");
		}
		else
		{
			currentItem = newItem;
			player.addCarryCapacity(currentItem.getWeight());
			player.removeInventory(currentItem);
			addItem(item, newItem);
			player.sortInventory();
			System.out.println("Your " + currentItem.getItemName() + " was dropped.\n");
		}
	}
	
	// Allows the user to equip a specific item if the item name is valid, it is in the player's inventory, and no item is currently equipped.
	public void equipItem(Commands command)
	{

		if(command.hasSecondWord() != false)
		{
			System.out.println("What would you like to equip?\n");
		}
		
		String item = command.getSecondCommand();
		int temp = currentItem.getItemType(currentItem);
		currentItem = player.getInventoryItem(item);
		
		if(currentItem == null)
		{
			System.out.println("There is no item by that name in your inventory.\n");
		}
		else if(temp == 3)
		{
			if(currentItem.getItemName().equals("healingpotion"))
			{
				skills.addHP(currentItem.getItemPerk(currentItem));
				player.removeInventory(currentItem);
				System.out.println("You drank a healing potion. Your HP is now: " + skills.getHP() + "\n");
			}
			else if(currentItem.getItemName().equals("manapotion"))
			{
				skills.addMana(currentItem.getItemPerk(currentItem));
				player.removeInventory(currentItem);
				System.out.println("You drank a mana potion. Your mana pool is now: " + skills.getMana() + "\n");
			}
		}
		else if(temp == 1)
		{
			{
				if(isWeaponEquipped == true)
				{
					System.out.println("You already have a weapon equipped.\n");
				}
				else
				{
					isWeaponEquipped = true;
					player.addPlayerAttribute(currentItem);
					System.out.println("You have equipped " + currentItem.getItemName() + "\n");
				}
			}
		}
		else if(temp == 2)
		{
			if(isArmorEquipped == true)
			{
				System.out.println("You already have an armor equipped.\n");
			}
			else
			{
				isArmorEquipped = true;
				player.addPlayerAttribute(currentItem);
				System.out.println("You have equipped " + currentItem.getItemName() + "\n");
			}
		}
	}
	
	// Allows the user to un-equip a specific item if the item name is valid and it is currently equipped by the player.
	public void unequipItem(Commands command)
	{
		if(command.hasSecondWord() != false)
		{
			System.out.println("What would you like to unequip?\n");
			return;
		}
		
		String item = command.getSecondCommand();
		Item newItem = player.getInventoryItem(item);
		int temp = currentItem.getItemType(currentItem);
		currentItem = newItem;
		
		if(currentItem == null)
		{
			System.out.println("There is no item by that name currently equipped.\n");
		}
		else if(temp == 1)
		{
			if(isWeaponEquipped == false)
			{
				System.out.println("You do not have a weapon equipped.\n");
			}
			else
			{
				player.lessPlayerAttribute(currentItem);
				isWeaponEquipped = false;
				System.out.println("You have unequipped " + currentItem.getItemName() + "\n");
			}
		}
		else if(temp == 2)
		{
			if(isArmorEquipped == false)
			{
				System.out.println("You do not have an armor equipped.\n");
			}
			else
			{
				player.lessPlayerAttribute(currentItem);
				isArmorEquipped = false;
				System.out.println("You have unequipped " + currentItem.getItemName() + "\n");
			}
		}
		else if(temp == 3)
		{
			System.out.println("You cannot unequip a potion. Only 'equip' them to drink the contents.\n");
		}
	}
	
	// Adds an item to a room if the player 'drops' it.
	public void addItem(String item, Item newItem)
	{
		currentRoom.setItem(item, newItem);
	}

	// Displays the player's key information.
	public void showPlayerInfo()
	{
		System.out.println("Player Stats");
		player.showPlayerInfo();
	}
	
	// Displays the user's inventory.
	public void showInventory()
	{
		System.out.println("Inventory:");
		player.showInventory();
	}
}