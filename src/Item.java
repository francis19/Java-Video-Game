/*
 * Contains all information regarding the available items to be found in the game, their weight, a
 * description, and serves as the super class for the different types of items (armor and weapons).
 */

public class Item {
	
	public String itemName;
	public String itemDescription;
	public double itemWeight;
	public int itemPerk;
	private Weapon weapon;
	private Armor armor;
	private Potion potion;
	
	public Item(String itemName, String itemDescription, double itemWeight, int itemPerk)
	{
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.itemWeight = itemWeight;
		this.itemPerk = itemPerk;
	}
	
	// Creates all items
	public void createAllItems()
	{
		weapon = new Weapon("","",0,0);
		armor = new Armor("","",0,0);
		potion = new Potion("","",0,0);
		weapon.createWeapon();
		armor.createArmor();
		potion.createPotion();
	}
	
	// Returns the item's name.
	public String getItemName()
	{
		return itemName;
	}
	
	// Returns the item's description.
	public String getDescription()
	{
		return itemDescription;
	}
	
	// Returns the item's weight.
	public double getWeight()
	{
		return itemWeight;
	}
	
	// Returns the item's 'perk' (i.e. attack damage, defense rating).
	public int getItemPerk(Item item)
	{
		return itemPerk;
	}
	
	// Retrieves a requested item.
	public Item getItem(String item)
	{
		createAllItems();
		Item weap = null;
		Item arm = null;
		Item pot = null;
		
		for(int i = 0; i < weapon.getWeaponList().size(); i++)
		{
			if(weapon.getWeaponList().get(i).getItemName().equals(item))
			{
				weap = weapon.getWeaponList().get(i);
				return weap;
			}	
		}
		
		for(int i = 0; i < armor.getArmorList().size(); i++)
		{
			if(armor.getArmorList().get(i).getItemName().equals(item))
			{
				arm = armor.getArmorList().get(i);
				return arm;
			}
		}
		
		for(int i = 0; i < potion.getPotionList().size(); i++)
		{
			if(potion.getPotionList().get(i).getItemName().equals(item))
			{
				pot = potion.getPotionList().get(i);
				return pot;
			}
		}
		return null;
	}
	
	// Returns the type of item being requested (i.e. if it's a weapon, determinant = 1, armor = 2, etc).
	public int getItemType(Item item)
	{
		createAllItems();
		String temp = item.getItemName();
		int determinant;
		
		for(int i = 0; i < weapon.getWeaponList().size(); i++)
		{
			if(weapon.getWeaponList().get(i).getItemName().equals(temp))
			{
				determinant = 1;
				return determinant;
			}
		}
		for(int i = 0; i < armor.getArmorList().size(); i++)
		{	
			if(armor.getArmorList().get(i).getItemName().equals(temp))
			{
				determinant = 2;
				return determinant;
			}
		}
		for(int i = 0; i < potion.getPotionList().size(); i++)
		{
			if(potion.getPotionList().get(i).getItemName().equals(temp))
			{
				determinant = 3;
				return determinant;
			}
		}
		return 0;
	}
}