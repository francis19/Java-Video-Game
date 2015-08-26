/*
 * This class takes string from the Commands class and attempts to interpret what the user wishes to be
 * done with his player character.
 */

import java.util.Scanner;

public class Parser {
	
	private Keywords keywords; //Holds all valid command words.
	private Scanner userInput;
	private Scanner tokenizer;
	
	public Parser()
	{
		keywords = new Keywords();
		userInput = new Scanner(System.in);
	}
	
	public Commands getCommand()
	{
		String inputedLine;
		String wordOne = null;
		String wordTwo = null;
		
		System.out.print("> "); //Prints the prompt.
		inputedLine = userInput.nextLine();
		inputedLine = inputedLine.toLowerCase();
		
		// Search for only 2 words on the line.
		tokenizer = new Scanner(inputedLine);
		
		if(tokenizer.hasNext())
		{
			wordOne = tokenizer.next();
			if(tokenizer.hasNext())
			{
				wordTwo = tokenizer.next();	// Get the second command word. Search stops here; Additional words will not be read.
				wordTwo = wordTwo.trim();
			}
		}
		
		if(keywords.isTravelCommand(wordOne))
		{
			return new Commands(wordOne, wordTwo);
		}
		else if(keywords.isCombatCommand(wordOne))
		{
			return new Commands(wordOne, wordTwo);
		}
		else if(keywords.isSpellCommand(wordOne))
		{
			return new Commands(wordOne, wordTwo);
		}
		else
		{
			return new Commands(null, wordTwo);
		}
	}
	
	// Displays all the available travel command words to the user.
	public void showTravelCommands()
	{
		keywords.displayTravelWords();
	}
	
	// Displays all the available combat command words to the user.
	public void showCombatCommands()
	{
		keywords.displayCombatWords();
	}
	
	// Displays all the available spells to the user.
	public void showAllSpells()
	{
		keywords.displaySpellWords();
	}
}