package Tiles;

import rpg.MainGUI;

public class WoodFloor extends Tile {

	public WoodFloor(int id) {
		super(0, 0 , MainGUI.allTiles[8].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}
}
