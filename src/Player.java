/*
 * This class contains all relevant information related to the actual user's player, including name, HP, and inventory.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Player {
	
	private Scanner name;
	private double carryCapacity;
	private int damage;
	private int protection;
	private int gold;
	private Skills attribute;
	private ArrayList<Item> inventory;
	private String username;
	
	public Player()
	{
		attribute = new Skills();
		name = new Scanner(System.in);
		carryCapacity = 50;
		inventory = new ArrayList<Item>();
		damage = attribute.getStrength();
		protection = attribute.getDefense();
		getUsername();
		//test(); // Succeeded
	}
	
	// Test for sorting algorithm.
	/*public void test()
	{
		Item mithril, claymore, staff, bronze, spear, iron, mace, bow, crossbow, sword;
		mithril = new Item("mithril", null, 1, 1);
		claymore = new Item("claymore", null, 1, 1);
		staff = new Item("staff", null, 1, 1);
		bronze = new Item("bronze", null, 1, 1);
		spear = new Item("spear", null, 1, 1);
		iron = new Item("iron", null, 1, 1);
		mace = new Item("mace", null, 1, 1);
		bow = new Item("bow", null, 1, 1);
		crossbow = new Item("crossbow", null, 1, 1);
		sword = new Item("sword", null, 1, 1);
		inventory.add(mithril);
		inventory.add(claymore);
		inventory.add(staff);
		inventory.add(bronze);
		inventory.add(spear);
		inventory.add(iron);
		inventory.add(mace);
		inventory.add(bow);
		inventory.add(crossbow);
		inventory.add(sword);
		sortInventory();
	}*/
	
	// Gets the player's name and returns it to the Game class to store under 'showPlayerInfo'.
	public void getUsername()
	{
		System.out.println("What name will your adventurer have?");
		username = name.nextLine();
		System.out.println();
	}
	
	// Gets the player's carrying capacity.
	public double getCarryCap()
	{
		return carryCapacity;
	}
	
	// Gets the player's damage value.
	public int getDamage()
	{
		return damage;
	}
	
	// Gets the player's defense value.
	public int getProtection()
	{
		return protection;
	}
	
	// Gets the player's gold total.
	public int getGold()
	{
		return gold;
	}
	
	// Adds gold to the player's total should he grab some in a dungeon room.
	public void addGold(int newGold)
	{
		gold = gold + newGold;
	}
	
	// If an item is dropped, the carrying capacity increases.
	public void addCarryCapacity(double weight)
	{
		carryCapacity = carryCapacity + weight;
	}
	
	// If an item is picked up, the carrying capacity decreases.
	public void lessCarryCapacity(double weight)
	{
		carryCapacity = carryCapacity - weight;
	}
	
	// Displays to the user all items in the inventory.
	public void showInventory()
	{
		for(int i = 0; i < inventory.size(); i++)
		{
			System.out.println(inventory.get(i).getItemName());
		}
	}
	
	// If an item is picked up, it is added to the inventory.
	public void addInventory(Item itemName)
	{
		inventory.add(itemName);
	}
	
	// If an item is dropped, it is removed from the inventory.
	public void removeInventory (Item itemName)
	{
		inventory.remove(itemName);
	}
	
	// Retrieves an inventory item that the user wants to use.
	public Item getInventoryItem(String item)
	{
		Item inv = null;
		
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i).getItemName().equals(item))
			{
				inv = inventory.get(i).getItem(item);
			}
		}
		if (inv != null)
		{
			return inv;
		}
		else
		{
			return null;
		}
	}
	
	// Implements a Bubble sorting algorithm to sort the inventory alphabetically.
	public void sortInventory()
	{
		int letter = 0;
		for(int i = inventory.size(); i > -1; --i)
		{
			for(int j = 0; j < inventory.size()-1; ++j)
			{
				if(inventory.get(j).getItemName() == inventory.get(j+1).getItemName())
				{
					// Do nothing
				}
				else if(inventory.get(j).getItemName().charAt(letter) == inventory.get(j+1).getItemName().charAt(letter))
				{
					--j;
					++letter;
				}
				else if(inventory.get(j).getItemName().charAt(letter) < inventory.get(j+1).getItemName().charAt(letter))
				{
					letter = 0;
				}
				else
				{
					letter = 0;
					Item item = inventory.get(j);
					inventory.set(j, inventory.get(j+1));
					inventory.set(j+1, item);
				}				
			}
		}
	}
	
	// Prints the player's key information: Name, HP, carrying capacity, etc.
	public void showPlayerInfo()
	{
		System.out.println("Name: " + username + "\n"
				+ "HP: " + attribute.getHP() + "\n"
				+ "Mana: " + attribute.getMana() + "\n"
				+ "Gold: " + getGold() + "\n"
				+ "You can carry " + getCarryCap() + " kg more" + "\n"
				+ "Strength: " + attribute.getStrength() + "\n"
				+ "Intelligence: " + attribute.getIntelligence() + "\n"
				+ "Defense: " + attribute.getDefense() + "\n"
				+ "Willpower: " + attribute.getWillpower());
	}
	
	// Increases the player's attack value, defense value, etc., if an item is equipped.
	public void addPlayerAttribute(Item item)
	{
		int itemPerk = item.getItemPerk(item);
		int determinant = item.getItemType(item);
		
		if(determinant == 1)
		{
			damage = damage + attribute.getStrength() + itemPerk;
		}
		else if(determinant == 2)
		{
			protection = attribute.getDefense() + itemPerk;
		}
	}
	
	// Decreases the player's attack value, defense value, etc., if an item is un-equipped.
	public void lessPlayerAttribute(Item item)
	{
		int itemPerk = item.getItemPerk(item);
		int determinant = item.getItemType(item);
		
		if(determinant == 1)
		{
			damage = damage + attribute.getStrength() - itemPerk;
		}
		else if(determinant == 2)
		{
			protection = attribute.getDefense() - itemPerk;
		}
	}
}