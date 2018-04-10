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

public class Item extends CustomImageButton implements Clickable, Equip {

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
	private int imageIndex;
	
	public static final int HEIGHT = 48;
	public static final int WIDTH = 48;
	
	
	public static final Graphic[] ITEMS = {new Graphic(0,0,48,48, "resources/excalibur.png"), new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(0, 0, 256, 256)),
			new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(256, 0, 256, 256)),new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(0, 256, 256, 256)),
			new Graphic(0,0,48,48,MainGUI.MYTHRILARMOR.getSubimage(256, 256, 256, 256)), new Graphic(0, 0,48,48,MainGUI.ARMOR.getSubimage(50, 0, 50, 50) )};
	
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
		this.imageIndex = imageIndex;
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

	@Override
	public void equip() {
		if(this.getType() < 5 ) {
			if(MainGUI.leo.getEquips()[this.getType()] == false) {
				MainGUI.myInventory.removeItem(this);
				MainGUI.myInventory.getEquipped().add(this);
				MainGUI.leo.setEquips(true, this.getType());
				MainGUI.leo.setStrength(MainGUI.leo.getStrength() + this.getStrengthBuff());
				MainGUI.leo.setVitality(MainGUI.leo.getVitality() + this.getVitalityBuff());
				MainGUI.leo.setAgility(MainGUI.leo.getAgility() + this.getAgilityBuff());
				MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() + this.getIntelligenceBuff());
				MainGUI.save1.save();
				MainGUI.iScreen.update();
				if(this.getType() == 0) {
					this.setX(75);
					this.setY(310);	
				}
				if(this.getType() == 1) {
					this.setX(168);
					this.setY(100);	
				}
				if(this.getType() == 2) {
					this.setX(168);
					this.setY(200);	
				}
				if(this.getType() == 3) {
					this.setX(168);
					this.setY(325);	
				}
				if(this.getType() == 4) {
					this.setX(168);
					this.setY(500);	
				}
				this.setAction(new Action() {
					
					@Override
					public void act() {
						unequip();
						
					}
				});

			}
		}
		
	}

	@Override
	public void unequip() {
		MainGUI.myInventory.addItem(this);
		MainGUI.myInventory.getEquipped().remove(this);
		MainGUI.leo.setEquips(false, this.getType());
		MainGUI.leo.setStrength(MainGUI.leo.getStrength() - this.getStrengthBuff());
		MainGUI.leo.setVitality(MainGUI.leo.getVitality() - this.getVitalityBuff());
		MainGUI.leo.setAgility(MainGUI.leo.getAgility() - this.getAgilityBuff());
		MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() - this.getIntelligenceBuff());
		MainGUI.save1.save();
		MainGUI.iScreen.update();
		this.setAction(new Action() {
			
			@Override
			public void act() {
				equip();
				
			}
		});
		
	}
	
	public String toString() {
		return this.name + "," + this.strengthBuff + "," + this.vitalityBuff + "," + this.agilityBuff + "," + this.intelligenceBuff + ","+imageIndex +","+ type;
		
	}
	
	

}
