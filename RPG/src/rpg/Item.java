package rpg;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import guiTeacher.components.Action;
import guiTeacher.components.CustomImageButton;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Clickable;
import guiTeacher.interfaces.DrawInstructions;

public class Item extends CustomImageButton implements Clickable {

	private int strengthBuff;
	private int vitalityBuff;
	private int agilityBuff;
	private int intelligenceBuff;
	private String name;
	
	/*
	 * Types
	 * 0 - Weapon
	 * 1 - Head
	 * 2 - chest
	 * 3 - Pants
	 * 4 - Boots
	 * 5- NonEquippable
	 */
	private int type;
	
	public static final int HEIGHT = 48;
	public static final int WIDTH = 48;
	
	
	public static final Graphic[] ITEMS = {new Graphic(0,0,48,48, "resources/excalibur.png"), new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(0, 0, 256, 256)),
			new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(256, 0, 256, 256)),new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(0, 256, 256, 256)),
			new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(256, 256, 256, 256))};
	
	public Item(String name, int strengthBuff, int vitalityBuff, int agilityBuff, int intelligenceBuff, int imageIndex , int type) {
		super(0,0,48,48,new DrawInstructions() {

			Graphic image = ITEMS[imageIndex];

			@Override
			public void draw(Graphics2D g, boolean highlight) {
				if(highlight){
					float scaleFactor = 0.9f;
					g.drawImage(image.getImage(), 0, 0, null);
					g.setColor(new Color(0,0,0,30));
					g.fillRect(0, 0, WIDTH, HEIGHT);

				}
				
				else {
					g.drawImage(image.getImage(), 0, 0, null);
				}
			}
		},null);
		this.setName(name);
		this.setStrengthBuff(strengthBuff);
		this.setVitalityBuff(vitalityBuff);
		this.setAgilityBuff(agilityBuff);
		this.setIntelligenceBuff(intelligenceBuff);
		this.setType(type);
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStrengthBuff() {
		return strengthBuff;
	}

	public void setStrengthBuff(int strengthBuff) {
		this.strengthBuff = strengthBuff;
	}

	public int getVitalityBuff() {
		return vitalityBuff;
	}

	public void setVitalityBuff(int vitalityBuff) {
		this.vitalityBuff = vitalityBuff;
	}

	public int getAgilityBuff() {
		return agilityBuff;
	}

	public void setAgilityBuff(int agilityBuff) {
		this.agilityBuff = agilityBuff;
	}

	public int getIntelligenceBuff() {
		return intelligenceBuff;
	}

	public void setIntelligenceBuff(int intelligenceBuff) {
		this.intelligenceBuff = intelligenceBuff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
