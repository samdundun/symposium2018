package Tiles;

import rpg.MainGUI;

public class Wood extends Tile {

	public Wood(int id) {
		super(0, 0 , MainGUI.allTiles[16].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
}
