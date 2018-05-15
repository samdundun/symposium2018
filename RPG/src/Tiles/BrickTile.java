package Tiles;

import rpg.MainGUI;

public class BrickTile extends Tile {

	public BrickTile(int id) {
		super(0, 0 , MainGUI.allTiles[0].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
}
