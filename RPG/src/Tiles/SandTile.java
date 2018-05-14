package Tiles;

import rpg.MainGUI;

public class SandTile extends Tile {

	public SandTile(int id) {
		super(0, 0 , MainGUI.allTiles[10].getImage(),id);
		tiles[id] = this;
	}

	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}
	
}
