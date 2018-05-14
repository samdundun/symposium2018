package Tiles;

import java.awt.image.BufferedImage;

import rpg.MainGUI;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(0, 0 , MainGUI.allTiles[65].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}

}
