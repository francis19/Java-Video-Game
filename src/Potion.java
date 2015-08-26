/*
 * Contains the available potions that can be acquired by the player and their functions.
 */

import java.util.ArrayList;

public class Potion extends Item {

	private ArrayList<Potion> potionList = new ArrayList<Potion>();
		
	public Potion(String potionName, String potionDescription, double potionWeight, int potency)
	{
		super(potionName, potionDescription, potionWeight, potency);
	}
	
	// Creates all the potions in the game and sets their healing ratings.
	public void createPotion()
	{
		Potion healingPotion, manaPotion;
		
		healingPotion = new Potion("healingpotion", "Restores health", 0.5, 20);
		manaPotion = new Potion("manapotion", "Restores mana", 0.5, 10);
		
		potionList.add(healingPotion);
		potionList.add(manaPotion);
	}
	
	// Retrieves the array list of potion items.
	public ArrayList<Potion> getPotionList()
	{
		return potionList;
	}
}