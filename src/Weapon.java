/*
 * Contains all information regarding the available weapons in the game. This is a subclass of the 'Items' class.
 */

import java.util.ArrayList;

public class Weapon extends Item {
	
	private ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	
	public Weapon(String weaponName, String weaponDescription, double weaponWeight, int attackRating)
	{
		super(weaponName, weaponDescription, weaponWeight, attackRating);
	}
	
	// Creates all the weapons in the game and sets their damage ratings using the Weapon class.
	public void createWeapon()
	{
		Weapon rustedshortsword, bronzeshortsword, ironshortsword, steelshortsword, silvershortsword, elvenshortsword, mithrilshortsword; // Shortswords
		Weapon bronzelongsword, ironlongsword, steellongsword, silverlongsword, elvenlongsword, mithrillongsword, dragonbane;			  // Longswords
		Weapon ironclaymore, steelclaymore, mithrilclaymore;																			  // Claymores
		Weapon bronzeaxe, ironaxe, steelaxe, mithrilaxe;																				  // Axes
		Weapon spear, staff, bow, crossbow;																								  // Miscellaneous
		
		rustedshortsword = new Weapon("rustedshortsword", "A worn out, rustic weapon.", 2.0, 3);
		bronzeshortsword = new Weapon("bronzeshortsword", "A potent, short bronze weapon.", 4.0, 5);
		ironshortsword = new Weapon("ironshortsword", "A sharp and deadly iron sword.", 5.0, 7);
		steelshortsword = new Weapon("steelshortsword", "A powerful and razor-sharp shortsword.", 7.0, 10);
		silvershortsword = new Weapon("silvershortsword", "A light, beautiful, yet lethal shortsword.", 2.0, 7);
		elvenshortsword = new Weapon("elven shortsword", "A finely-crafted and elegant shortsword.", 3.0, 9);
		mithrilshortsword = new Weapon("mithrilsword", "A dominant, massive, and powerful shortsword.", 10.0, 12);
		
		bronzelongsword = new Weapon("bronzelongsword", "A potent, long bronze weapon.", 3.0, 4);
		ironlongsword = new Weapon("ironlongsword", "A sharp, deadly, and long iron sword.", 5.0, 6);
		steellongsword = new Weapon("steellongsword", "A powerful and razor-sharp longsword.", 9.0, 12);
		silverlongsword = new Weapon("silverlongsword", "A light, beautiful, yet lethal longsword.", 4.0, 9);
		elvenlongsword = new Weapon("elvenlongsword", "A finely-crafted and elegant longsword.", 3.0, 8);
		mithrillongsword = new Weapon("mithrillongsword", "A dominant, massive and powerful longsword.", 12, 15);
		dragonbane = new Weapon("dragonbane", "A legendary longsword fabled to have been used to slay dragons.", 15, 20);
		
		ironclaymore = new Weapon("ironclaymore", "A long, powerful iron weapon.", 8.0, 9);
		steelclaymore = new Weapon("steelclaymore", "A long, powerful steel weapon.", 12.0, 14);
		mithrilclaymore = new Weapon("mithrilclaymore", "A long, powerful mithril weapon.", 14.0, 18);
		
		bronzeaxe = new Weapon("bronzeaxe", "A sharp, deadly waraxe.", 3.5, 5);
		ironaxe = new Weapon("ironaxe", "A sharp, deadly waraxe.", 5.5, 7);
		steelaxe = new Weapon("steelaxe", "A sharp, deadly waraxe.", 8.5, 12);
		mithrilaxe = new Weapon("mithrilaxe", "A sharp, deadly waraxe.", 11.5, 14);
		
		spear = new Weapon("spear", "A long weapon with a sharp tip.", 2.5, 6);
		staff = new Weapon("staff", "A wizard's staff with an orb at the tip; useful for casting magic.", 3.0, 0);
		bow = new Weapon("bow", "A finely-carved bow", 2.0, 5);
		crossbow = new Weapon("crossbow", "A finely-carved crossbow", 6.0, 8);
		
		weaponList.add(rustedshortsword);
		weaponList.add(bronzeshortsword);
		weaponList.add(ironshortsword);
		weaponList.add(steelshortsword);
		weaponList.add(silvershortsword);
		weaponList.add(elvenshortsword);
		weaponList.add(mithrilshortsword);
		weaponList.add(bronzelongsword);
		weaponList.add(ironlongsword);
		weaponList.add(steellongsword);
		weaponList.add(silverlongsword);
		weaponList.add(elvenlongsword);
		weaponList.add(mithrillongsword);
		weaponList.add(dragonbane);
		weaponList.add(ironclaymore);
		weaponList.add(steelclaymore);
		weaponList.add(mithrilclaymore);
		weaponList.add(bronzeaxe);
		weaponList.add(ironaxe);
		weaponList.add(steelaxe);
		weaponList.add(mithrilaxe);
		weaponList.add(spear);
		weaponList.add(staff);
		weaponList.add(bow);
		weaponList.add(crossbow);
	}
	
	// Retrieves the array list of weapon items.
	public ArrayList<Weapon> getWeaponList()
	{
		return weaponList;
	}
}