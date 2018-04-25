package rpg;

import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;



public class Tile extends Graphic {

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);

	protected final int id;

	private boolean walkable;

	public Tile(int x, int y, int w, int h, String imageLocation,int id) {
		super(x, y, w, h, imageLocation);
		this.id = id;
		
		tiles[id] = this;
	}

	public Tile(int x, int y, double scale, String imageLocation, int id) {
		super(x, y, scale, imageLocation);
		this.id = id;
	}

	public Tile(int x, int y, String imageLocation, int id) {
		super(x, y, imageLocation);
		this.id = id;
	}

	public Tile(int x, int y, BufferedImage image, int id) {
		super(x, y, image);
		this.id = id;
	}

	public Tile(int x, int y, BufferedImage image, double scale, int id) {
		super(x, y, image, scale);
		this.id = id;
	}

	public Tile(int x, int y, int w, int h, BufferedImage icon, int id) {
		super(x, y, w, h, icon);
		this.id = id;
	}

	public boolean isWalkable() {
		return walkable;
	}

	public void setWalkable(boolean walkable) {
		this.walkable = walkable;
	}

}
