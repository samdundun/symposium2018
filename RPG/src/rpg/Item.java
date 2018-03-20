package rpg;

import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;

public class Item extends Graphic {

	private int strengthBuff;
	private int vitalityBuff;
	private int agilityBuff;
	private int intelligenceBuff;
	private String name;
	
	public Item(int x, int y, BufferedImage image,String name, int strengthBuff, int vitalityBuff, int agilityBuff, int intelligenceBuff) {
		super(x, y, image);
		this.name = name;
		this.strengthBuff = strengthBuff;
		this.vitalityBuff = vitalityBuff;
		this.agilityBuff = agilityBuff;
		this.intelligenceBuff = intelligenceBuff;
	}
	

}
