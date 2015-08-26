/*
 * Formulates all battles between the player and the monsters which he/she faces. This class heavily interacts with the Player and Monster
 * classes and depending on the outcome of a battle, can have repurcussions with the RoomInfo and Game classes. (i.e. If the player dies,
 * he/she will respawn in the first room of the dungeon and a few items may intentionally 'disappear' from their inventory.
 */

public class BattleSystem {
	
	private int playerHP;
	private int playerMana;
	private int playerDamage;
	private int playerProtection;
	private int monsterHP;
	private int oldMonsterHP;
	private boolean exitBattle;
	Player player;
	Parser parser;
	Monster monster;
	Spell spells;
	Skills attribute;
	Room currentRoom;
	Keywords keywords;
	
	public BattleSystem(Player player, Monster monster, Skills attribute, Room currentRoom, int monsterHP)
	{
		parser = new Parser();
		keywords = new Keywords();
		spells = new Spell("","",0,0);
		spells.createSpell();
		this.player = player;
		this.attribute = attribute;
		this.currentRoom = currentRoom;
		this.monster = monster;
		this.monsterHP = monsterHP;
		this.oldMonsterHP = monsterHP;
		this.playerHP = attribute.getHP();
		this.playerMana = attribute.getMana();
		this.playerDamage = player.getDamage();
		this.exitBattle = false;
		this.playerProtection = player.getProtection();
		printHelp();
		startBattle();
	}
	
	// Officially starts the battle and begins the loop of commands that allows the player to fight until he/she or the monster is defeated.
	public void startBattle()
	{
		try{
			boolean isBattleFinished = false;
			while(!isBattleFinished)
			{
				isPlayerDefeated();
				if(exitBattle == true)
				{
					isBattleFinished = true;
				}
				else
				{
					System.out.println("It is your turn.\n");
					Commands command = parser.getCommand();
					isBattleFinished = enterCombat(command);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Please only input strings for your attack commands.");
			startBattle();
		}
	}
	
	// Attack fields that determine the types of attacks that a player can perform.

	private boolean playerTurn = true;
	private boolean monsterTurn = false;
	private boolean attack = false;
	private boolean doubleAttack = false;
	private int stunCooldown = 0;
	private int finalCooldown = 0;
	private int potency;
	private int manaCost;
	
	// All fighting is turn-based and takes place within a while loop in this method.
	public boolean enterCombat(Commands command)
	{	
		while(exitBattle == false)
		{
			while(playerHP > 0 && monsterHP > 0)
			{
				while(playerTurn == true)
				{
					if(command.isUnknownWord())
					{
						System.out.println("Please input 'use' to select an attack\n");
						return false;
					}
				
					String commandWord = command.getFirstCommand();
					if(commandWord.equals("use"))
					{
						if(command.hasSecondWord() != false)
						{
							System.out.println("What attack skill would you like to use?\n");
							return false;
						}
						
						String attackType = command.getSecondCommand();
						if(keywords.isCombatCommand(attackType) == false)
						{
						    System.out.println("That is not a valid attack.");
						    return false;
						}
						else if(attackType.equals("attack"))
						{
							monsterHP = monster.lessHP(playerDamage);
							System.out.println("You attacked and dealt " + playerDamage + " damage.\nMonster HP: " + monsterHP + "\n");
							attack = true;
							playerTurn = false;
							monsterTurn = true;
						}
						else if(attackType.equals("double"))
						{
							if(attack == true)
							{
								monsterHP = monster.lessHP(playerDamage * 2);
								System.out.println("You attacked and dealt " + playerDamage * 2 + " damage.\nMonster HP: " + monsterHP + "\n");
								attack = false;
								doubleAttack = true;
								playerTurn = false;
								monsterTurn = true;
							}
							else
							{
								System.out.println("You must perform a normal attack before using double.\n");
								return false;
							}
						}
						else if(attackType.equals("triple"))
						{
							if(doubleAttack == true)
							{
								monsterHP = monster.lessHP(playerDamage * 2);
								System.out.println("You attacked and dealt " + playerDamage * 3 + " damage.\nMonster HP: " + monsterHP + "\n");
								doubleAttack = false;
								playerTurn = false;
								monsterTurn = true;
							}
							else
							{
								System.out.println("You must perform a double attack before using triple.\n");
								return false;
							}
						}
						else if(attackType.equals("stun"))
						{
							if(stunCooldown == 0)
							{
								monsterHP = monster.lessHP(playerDamage / 2);
								System.out.println("You attacked and dealt " + playerDamage / 2 + " damage.\nMonster HP: " + monsterHP);
								System.out.println("Monster is stunned for 1 turn.");
								stunCooldown = 5;
							}
							else
							{
								System.out.println("You cannot use stun for another " + stunCooldown + " turns.");
								return false;
							}
						}
						else if(attackType.equals("final"))
						{
							if(finalCooldown == 0)
							{
								monsterHP = monster.lessHP(playerDamage * 3);
								System.out.println("You attacked and dealt " + playerDamage * 3 + " damage.\nMonster HP: " + monsterHP);
								finalCooldown = 10;
								playerTurn = false;
								monsterTurn = true;
							}
							else
							{
								System.out.println("You cannot use final for another " + finalCooldown + " turns.");
								return false;
							}
						}
					}
					else if(commandWord.equals("cast"))
					{
						if(command.hasSecondWord() != false)
						{
							System.out.println("What spell would you like to cast?");
							return false;
						}
						
						String spellType = command.getSecondCommand();
						
						if(spellType.equals("firebolt") || spellType.equals("icebolt") || spellType.equals("lightningbolt") ||
								spellType.equals("darkbolt") || spellType.equals("fireblast") || spellType.equals("iceblast") ||
								spellType.equals("lightningblast") || spellType.equals("darkblast"))
						{
							for(int i = 0; i < spells.getSpellList().size(); i++)
							{
								if(spells.getSpellList().get(i).getSpellName().equals(spellType))
								{
									potency = spells.getSpellList().get(i).getSpellPotency();
									manaCost = spells.getSpellList().get(i).getManaCost();
								}
							}
							
							playerMana = attribute.lessMana(manaCost);
							monsterHP = monster.lessHP(potency);
							System.out.println("You cast " + spellType + " and dealt " + potency + " damage.\nMonster HP: " + monsterHP + "\nMana: " + playerMana + "\n");
							playerTurn = false;
							monsterTurn = true;
						}
						else if(spellType.equals("healing"))
						{
							for(int i = 0; i < spells.getSpellList().size(); i++)
							{	
								if(spells.getSpellList().get(i).getSpellName().equals(spellType))
								{
									potency = spells.getSpellList().get(i).getSpellPotency();
									manaCost = spells.getSpellList().get(i).getManaCost();
								}
							}
							
							playerMana = attribute.lessMana(manaCost);
							playerHP = attribute.addHP(potency);
							System.out.println("You cast healing and regained " + potency + " points of health.\nMana: " + playerMana + "\n");
							playerTurn = false;
							monsterTurn = true;
						}
						else if(spellType.equals("paralysis"))
						{
							for(int i = 0; i < spells.getSpellList().size(); i++)
							{
								if(spells.getSpellList().get(i).getSpellName().equals(spellType))
								{
									potency = spells.getSpellList().get(i).getSpellPotency();
									manaCost = spells.getSpellList().get(i).getManaCost();
								}
							}
							playerMana = attribute.lessMana(manaCost);
							playerHP = attribute.addHP(potency);
							System.out.println("You have paralyzed the monster.\nMana: " + playerMana + "\n");
						}
						else
						{
						    System.out.println("That is not a valid spell");
						    return false;
						}
					}
					else
					{
						System.out.println("You may only type the words 'use' or 'cast' as the first command during a battle.\n");
						return false;
					}
				}
				while(monsterTurn == true)
				{
					if(stunCooldown != 0)
					{
						--stunCooldown;
					}
					
					if(finalCooldown != 0)
					{
						--finalCooldown;
					}
					
					if(monsterHP <= 0)
					{
						System.out.println("You have defeated the monster and received:\n" + "Experience: " + monster.getMonsterExp()
								+ "\n" + "Gold: " + monster.getMonsterGold() + "\n");
						System.out.println(currentRoom.getItemText() + "\n" + currentRoom.getExitText() + "\n");
						attribute.addExp(monster.getMonsterExp());
						player.addGold(monster.getMonsterGold());
						currentRoom.removeMonster(monster.getMonsterName());
						monster.resetHP(oldMonsterHP);
						exitBattle = true;
						return true;
					}
					int damage = monster.monsterDamage(monster) - playerProtection;
					playerHP = attribute.lessHP(damage);
					System.out.println("The monster has attacked and dealt " + damage + " damage.\nPlayer HP:" + playerHP);
					monsterTurn = false;
					playerTurn = true;
					return false;
				}
			}
		}
		return exitBattle;
	}
	
	public void isPlayerDefeated()
	{
		if(playerHP <= 0)
		{
			System.out.println("You have died.");
			playerHP = attribute.addHP(100);
			attribute.addMana(50);
			RoomDesign respawn = new RoomDesign();
			respawn.generateFloor1();
			exitBattle = true;
		}
	}
	
	public void printHelp()
	{
		System.out.println("To fight, type 'use' and an attack keyword of:\n");
					keywords.displayCombatWords();
		System.out.println();
		System.out.println("Spells:\n");
					keywords.displaySpellWords();
	}
}