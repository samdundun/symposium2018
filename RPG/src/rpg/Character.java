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

	public static final Attack[] attacks = {new Attack() {

		@Override
		//Basic Attack
		public void attack(Character a, Character b) {
			b.setCurrentHP(b.currentHP - a.strength);

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
			this.maxHP= this.maxHP + 10;
			this.currentHP = this.currentHP + 5;
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


}
