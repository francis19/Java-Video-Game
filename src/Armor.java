/* 
 * Contains all information regarding the available weapons in the game. This is a subclass of the 'Items' class.
 */

import java.util.ArrayList;

public class Armor extends Item {
	
	private ArrayList<Armor> armorList = new ArrayList<Armor>();
	
	public Armor(String armorName, String armorDescription, double armorWeight, int defenseRating)
	{
		super(armorName, armorDescription, armorWeight, defenseRating);
	}
	
	// Creates all the armors in the game and sets their damage ratings using the Armor class.
	public void createArmor()
	{
		Armor hideArmor, leatherArmor, bronzeArmor, chainmailArmor, steelArmor, elvenArmor, mithrilArmor;		// Armors

		hideArmor = new Armor("hidearmor", "Armor created from the hides of tough animal skin", 1, 2);
		leatherArmor = new Armor("leatherarmor", "A light leather armor for quick movement but little protection", 2, 3);
		bronzeArmor = new Armor("bronzearmor", "Simple yet tough bronze armor", 3, 4);
		chainmailArmor = new Armor("chainmail", "A light but strong armor", 4, 6);
		steelArmor = new Armor("steelarmor", "A heavy but extremely powerful armor", 6, 8);
		elvenArmor = new Armor("elvenarmor", "A light, finely-crafted, and sturdy armor", 8, 6);
		mithrilArmor = new Armor("mithrilarmor", "A bulwark of an armor, capable of defending the wearer from most attacks", 10, 10);
		
		armorList.add(hideArmor);
		armorList.add(leatherArmor);
		armorList.add(bronzeArmor);
		armorList.add(chainmailArmor);
		armorList.add(steelArmor);
		armorList.add(elvenArmor);
		armorList.add(mithrilArmor);
	}
	
	// Retrieves the array list of armor items.
	public ArrayList<Armor> getArmorList()
	{
		return armorList;
	}
}