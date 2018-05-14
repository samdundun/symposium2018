package Tiles;

import java.awt.image.BufferedImage;

import rpg.MainGUI;

public class RockTile extends Tile {

	public RockTile( int id) {
		super(0, 0, MainGUI.allTiles[58].getImage(), id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		return false;
	}

}
