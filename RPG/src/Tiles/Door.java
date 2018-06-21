package Tiles;

import rpg.MainGUI;

public class Door extends Tile {

	public Door(int id) {
		super(0, 0 , MainGUI.allTiles[48].getImage(),id);
		tiles[id] = this;
		interactable = false;
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public void interact(int x, int y) {
//		System.out.println("Tile has been changed");
//		MainGUI.currScreen.changeTile(y, x, 12);
//	}
}
