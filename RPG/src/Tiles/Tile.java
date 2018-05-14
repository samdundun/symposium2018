package Tiles;

import java.awt.image.BufferedImage;

import guiTeacher.components.Graphic;



public class Tile extends Graphic {

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile treeTile = new TreeTile(1);
	public static Tile rockTile = new RockTile(2);
	public static Tile waterTile = new WaterTile(3);
	public static Tile sandTile = new SandTile(4);
	public static Tile Chest = new Chest(5);
	public static Tile openChest = new OpenChest(6);

	public final int id;

	private boolean walkable;
	protected boolean interactable;

	public Tile(int x, int y, int w, int h, String imageLocation,int id) {
		super(x, y, w, h, imageLocation);
		this.id = id;
		interactable = false;
		
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

	public boolean isInteractable() {
		return interactable;
	}

	public void setInteractable(boolean interactable) {
		this.interactable = interactable;
	}
	
	public void interact(int x, int y) {
		
	}

}
