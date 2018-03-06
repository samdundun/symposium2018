package rpg;

public class Character {
	
	private int maxHP;
	private int currentHP;
	private int maxMana;
	private int currentMana;
	private int strength;
	private int vitality;
	private int agility;
	private int intelligence;

	public Character(int maxHP, int maxMana, int strength, int vitality, int agility, int intelligence) {
		this.maxHP = maxHP;
		this.currentHP = maxHP;
		this.maxMana = maxMana;
		this.currentMana = maxMana;
		this.strength = strength;
		this.vitality = vitality;
		this.agility = agility;
		this.intelligence = intelligence;
	}

}
