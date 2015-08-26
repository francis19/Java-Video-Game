/*
 * Generates all monster information and their attributes (attack damage, HP, etc.)
 */

import java.util.Random;

public class Monster {
	
	private Random randNum = new Random();
	private String name;
	private int HP;
	private int minDamage;
	private int maxDamage;
	private int exp;
	private int gold;
	
	public Monster(String name, int HP, int minDamage, int maxDamage, int exp, int gold)
	{
		this.name = name;
		this.HP = HP;
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
		this.exp = exp;
		this.gold = gold;
	}
	
	// Gets a monster's name.
	public String getMonsterName()
	{
		return name;
	}
	
	// Gets a monster's HP.
	public int getMonsterHP()
	{
		return HP;
	}
	
	// Gets the amount of experience that a player receives upon defeating a specific monster.
	public int getMonsterExp()
	{
		return exp;
	}
	
	// Gets the amount of gold that a monster drops upon being defeated.
	public int getMonsterGold()
	{
		return gold;
	}
	
	// Gets the minimum damage value of a monster.
	public int getMinDamage(Monster monster)
	{
		int min;
		min = monster.minDamage;
		return min;
	}
	
	// Gets the maximum damage value of a monster.
	public int getMaxDamage(Monster monster)
	{
		int max;
		max = monster.maxDamage;
		return max;
	}
	
	// Gets the minimum and maximum damage values of a monster and randomly generates a number within this range; this value is the amount
	// of damage that the monster will do to the player's HP when it attacks.
	public int monsterDamage(Monster monster)
	{
		int min, max;
		min = getMinDamage(monster);
		max = getMaxDamage(monster);
		int damage = randNum.nextInt((max - min) + 1) + min;
		
		return damage;
	}
	
	// Lowers the monster's HP when the player attacks.
	public int lessHP(int hit)
	{
		HP = HP - hit;
		if(HP < 0)
		{
			HP = 0;
		}
		return HP;
	}
	
	// Resets a monster's original hit points after a battle.
	public void resetHP(int oldHP)
	{
		HP = oldHP;
	}
}