package Tiles;

import rpg.MainGUI;

public class GrayBlock extends Tile {

	public GrayBlock(int id) {
		super(0, 0 , MainGUI.allTiles[14].getImage(),id);
		tiles[id] = this;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}
}
