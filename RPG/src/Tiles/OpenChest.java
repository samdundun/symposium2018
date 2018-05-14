package Tiles;

import java.awt.image.BufferedImage;

import rpg.MainGUI;

public class OpenChest extends Tile {

	public OpenChest(int id) {
		super(0, 0 , MainGUI.allTiles[35].getImage(),id);
		tiles[id] = this;
		interactable = false;
	}

	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
}
