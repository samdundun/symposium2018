package Tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import rpg.MainGUI;

public class Chest extends Tile {

	private boolean open;

	public Chest(int id) {
		super(0, 0 , MainGUI.allTiles[36].getImage(),id);
		tiles[id] = this;
		open = false;
		interactable = true;
	}

	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean a) {
		open = a;
	}

	public void drawImage(Graphics2D g) {
		if(!open)
			g.drawImage(MainGUI.allTiles[36].getImage(), 0, 0, null);
		if(open) {
			g.drawImage(MainGUI.allTiles[35].getImage(), 0, 0, null);
		}
	}
	
	public void interact(int x, int y) {
		setOpen(true);
		System.out.println("Tile has been changed");
		MainGUI.currScreen.changeTile(x, y, 6);;
	}

}
