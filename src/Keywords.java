/*
 * This class contains an array of all the keywords that a user can type into the interface to properly interact with the game.
 */

public class Keywords {
	
	private Spell spells;
	
	public Keywords()
	{
		spells = new Spell("", "", 0, 0);
		spells.createSpell();
	}
	
	private static final String[] travelCommands = {
		"go", "grab", "drop", "equip", "unequip", "help", "exit", "info", "inventory", "map", "fight", "spellbook"
	};
	
	private static final String[] combatCommands = {
		"use", "cast", "attack", "double", "triple", "stun", "final"
	};
	
	// Returns true if a given string is a valid travel command. Otherwise, returns false.
	public boolean isTravelCommand(String userText)
	{
		for(int i = 0; i < travelCommands.length; i++)
		{
			if(travelCommands[i].equals(userText))
			{
				return true;
			}
		}
		return false;
	}
	
	// Returns true if a given string is a valid combat command. Otherwise, returns false.
	public boolean isCombatCommand(String userText)
	{
		for(int i = 0; i < combatCommands.length; i++)
		{
			if(combatCommands[i].equals(userText))
			{
				return true;
			}
		}
		return false;
	}
	
	// Returns true if a given string is a valid spell incantation. Otherwise, returns false.
	public boolean isSpellCommand(String userText)
	{
		for(int i = 0; i < spells.getSpellList().size(); i++)
		{
			if(spells.getSpellList().get(i).getSpellName().equals(userText))
			{
				return true;
			}
		}
		return false;
	}
	
	// Prints all valid travel commands to the user.
	public void displayTravelWords()
	{
		for(int i = 0; i < travelCommands.length; i++)
		{
			System.out.println(travelCommands[i]);
		}
	}
	
	// Prints all valid combat commands to the user.
	public void displayCombatWords()
	{
		for(int i = 0; i < combatCommands.length; i++)
		{
			System.out.println(combatCommands[i]);
		}
	}
	
	// Prints all valid spell incantations to the user.
	public void displaySpellWords()
	{
		for(int i = 0; i < spells.getSpellList().size(); i++)
		{
			System.out.print(spells.getSpellList().get(i).getSpellName() + ", ");
		}
		System.out.println();
	}
}