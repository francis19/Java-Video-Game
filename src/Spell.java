/*
 * Contains all information regarding the available spells in the game that the player can cast.
 */

import java.util.ArrayList;

public class Spell {
	
	private ArrayList<Spell> spellList = new ArrayList<Spell>();
	private String spellName;
	private int spellPotency;
	private int manaCost;
	
	public Spell(String spellName, String spellDescription, int spellPotency, int manaCost)
	{
		this.spellName = spellName;
		this.spellPotency = spellPotency;
		this.manaCost = manaCost;
	}
	
	// Creates all the available spells in the game.
	public void createSpell()
	{
		Spell firebolt, icebolt, lightningbolt, darkbolt;										// Bolt spells
		Spell fireblast, iceblast, lightningblast, darkblast;									// Blast spells
		//Spell sword, axe, spear;																// Conjure weapon spells
		Spell healing, paralysis; //aura														// Miscellaneous spells
		
		firebolt = new Spell("firebolt", "Casts a bolt of fire", 6, 6);
		icebolt = new Spell("icebolt", "Casts a bolt of ice", 5, 5);
		lightningbolt = new Spell("lightningbolt", "Casts a bolt of lightning", 7, 7);
		darkbolt = new Spell("darkbolt", "Casts a bolt of darkness", 6, 6);
		fireblast = new Spell("fireblast", "Casts a blast of fire", 9, 10);
		iceblast = new Spell("iceblast", "Casts a blast of ice", 8, 7);
		lightningblast = new Spell("lightningblast", "Casts a blast of lightning", 11, 15);
		darkblast = new Spell("darkblast", "Casts a blast of darkness", 10, 13);
		//sword = new Spell("Sword", "Casts and equips an ethereal sword", 7, 10);
		//axe = new Spell("Axe", "Casts and equips an ethereal axe", 6, 9);
		//spear = new Spell("Spear", "Casts and equips an ethereal spear", 5, 7);
		healing = new Spell("healing", "Casts a healing spell on yourself", 10, 5);
		paralysis = new Spell("paralysis", "Paralyzes an enemy for 2 turns of combat", 2, 5);
		//aura = new Spell("aura", "Temporarily increases your defense attribute", 5, 12);
		
		spellList.add(firebolt);
		spellList.add(icebolt);
		spellList.add(lightningbolt);
		spellList.add(darkbolt);
		spellList.add(fireblast);
		spellList.add(iceblast);
		spellList.add(lightningblast);
		spellList.add(darkblast);
		//spellList.add(sword);
		//spellList.add(axe);
		//spellList.add(spear);
		spellList.add(healing);
		spellList.add(paralysis);
		//spellList.add(aura);
	}
	
	// Gets the name of a particular spell.
	public String getSpellName()
	{
		return spellName;
	}
	
	// Gets the potency of a particular spell.
	public int getSpellPotency()
	{
		return spellPotency;
	}
	
	// Gets the mana cost of a particular spell.
	public int getManaCost()
	{
		return manaCost;
	}
	
	// Returns to the user the list of all the spells in the player's spell book.
	public ArrayList<Spell> getSpellList()
	{
		return spellList;
	}
}