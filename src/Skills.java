/*
 * The Skills class contains all the available skills that the player character can 'level up' to increase specific attributes; i.e. Increasing the 'Strength' skill
 * will increase his/her amount of damage.
 */

public class Skills {
	
	private int level, hitpoints, mana, strength, defense, intelligence, willpower, experience;
	
	public Skills()
	{
		hitpoints = 100;
		mana = 50;
		level = 1;
		strength = 3;
		defense = 3;
		intelligence = 3;
		willpower = 3;
		experience = 0;
	}
	
	// Gets the player's main level.
	public int getLevel()
	{
		return level;
	}
	
	// Gets the player's total hitpoints.
	public int getHP()
	{
		return hitpoints;
	}
	
	// Gets the player's total mana.
	public int getMana()
	{
		return mana;
	}
	
	// If the player drinks an HP potion, his HP will be restored.
	public int addHP(int healing)
	{
		hitpoints = hitpoints + healing;
		return hitpoints;
	}
	
	// If the player takes damage, his total HP will decrease.
	public int lessHP(int damage)
	{
		hitpoints = hitpoints - damage;
		if(hitpoints < 0)
		{
			hitpoints = 0;
		}
		return hitpoints;
	}
	
	// If the player drinks a mana potion, his mana will be restored.
	public int addMana(int healing)
	{
		mana = mana + healing;
		return mana;
	}
	
	// If the player uses mana, his total mana will decrease.
	public int lessMana(int reduction)
	{
		if(mana > reduction)
		{
			mana = mana - reduction;
			return mana;
		}
		else
		{
			System.out.println("You do not have enough mana to cast that spell.\n");
		}
		return mana;
	}
	
	// Gets the player's strength skill value.
	public int getStrength()
	{
		return strength;
	}
	
	// Gets the player's defense skill value.
	public int getDefense()
	{
		return defense;
	}
	
	// Gets the player's intelligence skill value.
	public int getIntelligence()
	{
		return intelligence;
	}
	
	// Gets the player's willpower skill value.
	public int getWillpower()
	{
		return willpower;
	}
	
	// Checks if the player's experience is enough to level up a skill.
	public void checkExp()
	{
		if(experience > 10 && (getLevel() < 2))
		{
			levelUp("Level");
		}
		else if(experience > 50 && (getLevel() < 3))
		{
			levelUp("Level");
		}
		else if(experience > 100 && (getLevel() < 4))
		{
			levelUp("Level");
		}
		else if(experience > 200 && (getLevel() < 5))
		{
			levelUp("Level");
		}
		else if(experience > 300 && (getLevel() < 6))
		{
			levelUp("Level");
		}
		else if(experience > 500 && (getLevel() < 7))
		{
			levelUp("Level");
		}
		else if(experience > 750 && (getLevel() < 8))
		{
			levelUp("Level");
		}
		else if(experience > 1000 && (getLevel() < 9))
		{
			levelUp("Level");
		}
		else if(experience > 1500 && (getLevel() < 10))
		{
			levelUp("Level");
		}
		else if(experience > 2000 && (getLevel() < 11))
		{
			levelUp("Level");
		}
	}
	
	// Adds experience after a monster has been defeated.
	public void addExp(int exp)
	{
		experience = experience + exp;
		checkExp();
	}
	
	// Increases a specified skill of the player.
	public void levelUp(String skill)
	{
		if(skill == "Level")
		{
			level++;
			hitpoints = hitpoints + 20;
			mana = mana + 10;
			System.out.println("Congratulations! You have ascended to level " + getLevel() + "!");
		}
		else if(skill == "Strength")
		{
			strength++;
			System.out.println("Congratulations! You have ascended to Strength level " + getStrength() + "!");
		}
		else if(skill == "Intelligence")
		{
			intelligence++;
			System.out.println("Congratulations! You have ascended to Intelligence level " + getIntelligence() + "!");
		}
		else if(skill == "Defense")
		{
			defense++;
			System.out.println("Congratulations! You have ascended to Defense level " + getDefense() + "!");
		}
		else if (skill == "Willpower")
		{
			willpower++;
			System.out.println("Congratulations! You have ascended to Willpower level " + getWillpower() + "!");
		}
	}
}