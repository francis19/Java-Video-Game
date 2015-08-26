/*
 * This class contains information about commands that were inputed by a user. If a command cannot be
 * understood, then that word (first or second) is set to 'null'.
 */

public class Commands {
	
	private String firstWord;
	private String secondWord;
	
	public Commands(String firstCommand, String secondWord)
	{
		firstWord = firstCommand;
		this.secondWord = secondWord;
	}
	
	// Returns the first command word. Should the command not be understood, the method returns null.
	public String getFirstCommand()
	{
		return firstWord;
	}
	
	// Returns the second command word. Should the command not be understood, the method returns null.
	public String getSecondCommand()
	{
		return secondWord;
	}
	
	// Return false if the command is valid. If not, returns true.
	public boolean isUnknownWord()
	{
		return (firstWord == null);
	}
	
	// Returns false if the command has a 2nd word. If not, returns true.
	public boolean hasSecondWord()
	{
		return (secondWord == null);
	}
}