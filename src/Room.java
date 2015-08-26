/*
 * Contains an instance of every room in the game with each room's exits and descriptions.
 */

import java.util.HashMap;
import java.util.Set;

public class Room {
	
	private String roomDescription;
	private HashMap<String, Room> exits;
	private HashMap<String, Item> items;
	private HashMap<String, Monster> monsters;
	
	// Generates a description to every room and their names, such as: "Armory". Also collects the exits, items, and monsters of the current room in Hash Maps.
	public Room(String roomDescription)
	{
		this.roomDescription = roomDescription;
		exits = new HashMap<String, Room>();
		items = new HashMap<String, Item>();
		monsters = new HashMap<String, Monster>();
	}
	
	// Acquires all the exits of the current room and places them in the HashMap.
	public void setExit(String direction, Room adjacentRoom)
	{
		exits.put(direction, adjacentRoom);
	}
	
	// Acquires all the items of the current room and places them in the HashMap.
	public void setItem(String itemName, Item availableItem)
	{
		items.put(itemName, availableItem);
	}
	
	// Acquires all the monsters of the current room and places them in the HashMap.
	public void setMonster(String monsterName, Monster enemy)
	{
		monsters.put(monsterName, enemy);
	}
	
	// Gives a short description of the room which is defined in the constructor.
	public String getShortDescription()
	{
		return roomDescription;
	}
	
	// Provides explicit details regarding the current location. i.e. "You are in the Armory".
	public String getLongDescription()
	{
		return "You are in " + roomDescription + ".\n" + getItemText() + "\n" + getMonsterText() + "\n" + getExitText() + "\n";
	}
	
	// Displays to the user all the available exits in the current room.
	public String getExitText()
	{
		String showExits = "Exits:";
		Set<String> keys = exits.keySet();
		
		for(String exit : keys)
		{
			showExits += " " + exit;
		}
		return showExits;
	}
	
	// Displays to the user all the available items in the current room.
	public String getItemText()
	{
		String showItems = "Items:";
		Set<String> keys = items.keySet();
		
		for(String item : keys)
		{
			showItems += " " + item;
		}
		return showItems;
	}
	
	// Displays to the user all the monsters in the current room.
	public String getMonsterText()
	{
		String showMonsters = "Monsters:";
		Set<String> keys = monsters.keySet();
		
		for(String monster : keys)
		{
			showMonsters += " " + monster;
		}
		return showMonsters;
	}
	
	// Returns the new room that the user is in should he travel there. If the direction specified contains no room, then this method returns null.
	public Room getExit(String direction)
	{
		return exits.get(direction);
	}
	
	// Returns an item that is currently found within the room.
	public Item getItem(String item)
	{
		return items.get(item);
	}
	
	// Returns a monster that is currently found within the room.
	public Monster getMonster(String monster)
	{
		return monsters.get(monster);
	}
	
	// Returns an item that is currently found within the room.
	public void removeItem(String item)
	{
		items.remove(item);
	}
	
	// Returns a monster that is currently found within the room.
	public void removeMonster(String monster)
	{
		monsters.remove(monster);
	}
}