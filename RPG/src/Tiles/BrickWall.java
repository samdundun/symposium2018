package Tiles;

import rpg.MainGUI;

public class BrickWall extends Tile {

	public BrickWall(int id) {
		super(0, 0 , MainGUI.allTiles[1].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
}
