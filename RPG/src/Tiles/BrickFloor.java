package Tiles;

import rpg.MainGUI;

public class BrickFloor extends Tile {

	public BrickFloor(int id) {
		super(0, 0 , MainGUI.allTiles[3].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
