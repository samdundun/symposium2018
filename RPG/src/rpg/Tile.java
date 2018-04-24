package rpg;

import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;

public class Tile extends Graphic {

	private boolean walkable;

	public Tile(int x, int y, int w, int h, String imageLocation) {
		super(x, y, w, h, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, double scale, String imageLocation) {
		super(x, y, scale, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, BufferedImage image) {
		super(x, y, image);
	}

	public Tile(int x, int y, BufferedImage image, double scale) {
		super(x, y, image, scale);
		// TODO Auto-generated constructor stub
	}

	public Tile(int x, int y, int w, int h, BufferedImage icon) {
		super(x, y, w, h, icon);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

}
