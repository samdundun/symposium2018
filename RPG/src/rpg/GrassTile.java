package rpg;

import java.awt.image.BufferedImage;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(0, 0 , MainGUI.allTiles[65].getImage(),id);
	}

	@Override
	public boolean isWalkable() {
		// TODO Auto-generated method stub
		return true;
	}

}
