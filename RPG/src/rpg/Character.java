package rpg;

import guiTeacher.components.Action;

public class Character {

	private int maxHP;
	private int currentHP;
	private int maxMana;
	private int currentMana;
	private int strength;
	private int vitality;
	private int agility;
	private int intelligence;
	private int neededXP;
	private int currentXP;
	private int level;
	private boolean dead;
	private int giveXP;
	private boolean stunned;
	private int statPoints;
	private boolean[] equips;

	public static final Attack[] attacks = {new Attack() {

		@Override
		//Basic Attack
		public void attack(Character a, Character b) {
			b.setCurrentHP(b.currentHP - a.strength);

		}
	},

			
	//FireBall
	new Attack() {
		
		@Override
		public void attack(Character a, Character b) {
			b.setCurrentHP(b.currentHP-a.intelligence);			
		}
	},
	//ThunderBolt
	new Attack() {
		
		@Override
		public void attack(Character a, Character b) {
			b.setCurrentHP(b.currentHP - (a.intelligence/2));
			if(Math.random() > .8) {
			b.stunned = true;
			System.out.println(b + " is stunned");
			}
			
		}
	},
	
	//Cure
	new Attack() {
		
		@Override
		public void attack(Character a, Character b) {
			a.setCurrentHP(a.getCurrentHP() + a.getIntelligence());
			if(a.getCurrentHP() > a.getMaxHP()) {
				a.setCurrentHP(a.getMaxHP());
			}
			
		}
	}


	
	

	};

	public Character(int maxHP, int maxMana, int strength, int vitality, int agility, int intelligence, int level, int giveXP) {
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.maxMana = maxMana;
		this.currentMana = maxMana;
		this.strength = strength;
		this.vitality = vitality;
		this.agility = agility;
		this.intelligence = intelligence;
		this.level = level;
		this.dead = false;
		this.giveXP = giveXP;
		this.setStunned(false);
		this.setStatPoints(0);
//		this.setWeaponEquipped(false);
//		this.setHeadEquipped(false);
//		this.setChestequipped(false);
//		this.setPantsEquipped(false);
//		this.setBootsEquipped(false);
		this.equips = new boolean[5];
		for (int i = 0 ; i < equips.length; i++) {
			equips[i] = false;
		}
	}

	public boolean[] getEquips() {
		return equips;
	}

	public void setEquips(boolean equip, int type) {
		this.equips[type] = equip;
	}
	
	public void setEquipped(boolean[] b) {
		this.equips = b;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public void setMaxHP(int maxHP) {
		this.maxHP = maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void setCurrentHP(int currentHP) {
		this.currentHP = currentHP;
	}

	public int getMaxMana() {
		return maxMana;
	}

	public void setMaxMana(int maxMana) {
		this.maxMana = maxMana;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getVitality() {
		return vitality;
	}

	public void setVitality(int vitality) {
		this.vitality = vitality;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getNeededXP() {
		return neededXP;
	}

	public void setNeededXP() {
		this.neededXP = (500 * (level * level) - (500 * level)) + 1000;
	}

	public int getCurrentXP() {
		return currentXP;
	}

	public void setCurrentXP(int currentXP) {
		this.currentXP = currentXP;
	}

	public void setNewStats() {
		this.maxHP = 30;
		this.currentHP = 30;
		this.maxMana = 50;
		this.currentMana = 50;
		this.strength = 3;
		this.vitality = 3;
		this.agility = 3;
		this.intelligence = 5;
		this.level = 1;
		this.currentXP = 0;
		this.setStatPoints(0);
		this.setNeededXP();
	}

	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public void checkDead() {
		if(currentHP <= 0) {
			this.dead = true;
		}
		else {
			this.dead = false;
		}

	}

	public void gainXP(int a) {
		this.currentXP = this.currentXP + a;
		checkLevelUp();
	}

	public void checkLevelUp() {
		if(this.currentXP >=this. neededXP) {
			this.currentXP = this.currentXP - this.neededXP;
			level++;
			this.maxHP= this.maxHP + 5;
			this.currentHP = this.currentHP + 5;
			this.statPoints++;
			setNeededXP();
			checkLevelUp();
		}
	}

	public void setGiveXP(int giveXP) {
		this.giveXP = giveXP;
	}

	public int getGiveXP() {
		return giveXP;
	}

	public boolean isStunned() {
		return stunned;
	}

	public void setStunned(boolean stunned) {
		this.stunned = stunned;
	}
	
	public int[] getStats() {
		int[] a = {maxHP,currentHP, maxMana, currentMana,strength, vitality, agility, intelligence, level, currentXP, statPoints};
		return a;
	}
	public void setStats(int[] a) {
		this.maxHP = a[0];
		this.currentHP = a[1];
		this.maxMana = a[2];
		this.currentMana = a[3];
		this.strength = a[4];
		this.vitality = a[5];
		this.agility = a[6];
		this.intelligence = a[7];
		this.level = a[8];
		this.currentXP = a[9];
		this.setStatPoints(a[10]);
		this.setNeededXP();
	}

	public int getStatPoints() {
		return statPoints;
	}

	public void setStatPoints(int statPoints) {
		this.statPoints = statPoints;
	}




}
