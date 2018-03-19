package rpg;

public class Item {

	private int strengthBuff;
	private int vitalityBuff;
	private int agilityBuff;
	private int intelligenceBuff;
	private String name;
	
	public Item(String name, int strengthBuff, int vitalityBuff, int agilityBuff, int intelligenceBuff) {
		this.name = name;
		this.strengthBuff = strengthBuff;
		this.vitalityBuff = vitalityBuff;
		this.agilityBuff = agilityBuff;
		this.intelligenceBuff = intelligenceBuff;
	}

}
