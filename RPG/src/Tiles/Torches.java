package Tiles;

import rpg.MainGUI;

public class Torches extends Tile {

	public Torches(int id) {
		super(0, 0 , MainGUI.allTiles[61].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
}
