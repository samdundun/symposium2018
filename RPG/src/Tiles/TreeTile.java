package Tiles;

import java.awt.image.BufferedImage;

import rpg.MainGUI;

public class TreeTile extends Tile {

	public TreeTile( int id) {
		super(0, 0, MainGUI.allTiles[30].getImage(), id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		return false;
	}
	
}
