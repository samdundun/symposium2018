package Tiles;

import rpg.MainGUI;

public class WaterTile extends Tile{
	
	public WaterTile(int id) {
		super(0, 0 , MainGUI.allTiles[13].getImage(),id);
		tiles[id] = this;
	}

	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}

}
