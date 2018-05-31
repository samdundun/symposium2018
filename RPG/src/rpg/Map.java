package rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;

import Tiles.Tile;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Map extends FullFunctionScreen implements IState {

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	private int row;
	private int col;

	private SamCustomArea intro;
	private Graphic leo;
	private MovingCharacter leoSprite;
	private boolean newGame;

	private MapLoader map;
	private MapLoader topMap;

	private int [][] tiles;
	private int[][] topLayer;


	public void setNewGame(boolean newGame) {
		this.newGame = newGame;
	}

	public Map() {
		super(WIDTH, HEIGHT);
		this.newGame = false;
		this.row = 0;
		this.col = 0;
		setMapContent();
	}

	public Map(int row, int col) {
		super(WIDTH , HEIGHT);
		this.newGame = false;
		loadMap(row, col);
	}

	@Override
	public void onEnter() {
		MainGUI.currScreen = this;

		//		leoSprite.setX();
		//		leoSprite.setY(100);

		if(newGame) {
			newGame = false;
			leoSprite.setCanMove(false);
			leoSprite.setX(100);
			leoSprite.setY(100);
			leoSprite.setDirection(0);
			intro.setVisible(true);
			leo.setVisible(true);
			String start = "My name is Leo and I'm a mage, unknown to the world until today!\nI have entered this mage tournament in the continent of Varathia.\nThis tournament has a prize of the rumored magium, a power which one knows no bounds!\nI intend to seize this power for myself and that begins here.\nI have been magically teleported into the island continent and no word has been spoken yet.\nThe best thing to do for now is to wander and gather intel on what is going on.";
			intro.setText(start.substring(0,1));
			Thread printer = new Thread(new Runnable() {

				@Override
				public void run() {
					for(int i = 1; i< start.length(); i++) {
						try {
							Thread.sleep(25);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						String contents = "";

						contents = intro.getText() + start.substring(i, i+1);
						intro.setText(contents);
						if(i%278 ==0) {
							try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							intro.setText("");
						}
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					intro.setVisible(false);
					leo.setVisible(false);
					leoSprite.setCanMove(true);
				}
			});
			printer.start();
		}
		else {
			intro.setVisible(false);
			leo.setVisible(false);
			leoSprite.setCanMove(true);
		}


	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;

	}

	public Tile getTile(int[][] tileset, int x, int y) {
		//		if(x < 0 || y < 0|| x >= tileWidth || y >= tileHeight) {
		//			return Tile.grassTile;
		//		}

		Tile t = Tile.tiles[tileset[x][y]];
		if(t == null) {
			return Tile.grassTile;
		}
		return t;
	}

	public void setMapContent() {
		map = new MapLoader( "resources/0," +this.row + "," + this.col + ".txt");
		topMap = new MapLoader("resources/1,"+this.row + "," + this.col + ".txt");

		topLayer = topMap.load();
		tiles = map.load();


		Tile currentTile = null;
		//Tile Placement
		for(int i = 0; i < tiles.length; i++) {
			for(int j = 0; j < tiles[0].length; j++) {

				//set base tile location 
				Tile test = getTile(tiles,i,j);
				addTile(test,i,j);
				//test = null;


				if(topLayer[i][j] != 0) {
					test = getTile(topLayer,i,j);
					addTile(test,i,j);
				}

			}

		}


		try {
			File fontFile = new File("resources/Holiday.ttf");
			//			File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(24f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}

		intro = new SamCustomArea(0, 400, 800, 200, "");
		addObject(intro);

		leo = new Graphic(400,147,450,253,"resources/leooverhead.png");
		addObject(leo);
		intro.setVisible(false);
		leo.setVisible(false);

		leoSprite = new MovingCharacter(100,100,32,32);
		Thread move = new Thread(leoSprite);

		move.start();
		addObject(leoSprite);
		moveFocus(leoSprite);
		leoSprite.setCanMove(false);

		update();
	}

	public void addTile(Tile test, int i, int j) {
		Tile currentTile = new Tile(0,0,test.getImage(), test.id);
		currentTile.setX(16*j);
		currentTile.setY(16*i);
		addObject(currentTile);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		//Add permanent fixtures such as buttons that are always permanent

	}

	public int[][] getTopTileSet(){
		return topLayer;
	}

	public void loadMap(int row, int col) {
		this.row = row;
		this.col = col;
		setMapContent();
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public void changeTile(int x, int y, int value) {
		if(topLayer[y][x] != value) {
			topLayer[y][x] = value;
			Tile test = getTile(topLayer,y,x);
			addTile(test,y,x);
			topMap.save(topLayer);
		}
	}

	public String toString() {
		return this.row + "," + this.col + "," + leoSprite.getX() + "," + leoSprite.getY();
	}

	public MovingCharacter getLeoSprite() {
		return leoSprite;
	}

	public void setLeoSpritePosition(int direction, int x, int y) {

//		System.out.println(MainGUI.game.currScreen.getRow() +","+ MainGUI.game.currScreen.getCol());
//		System.out.print(MainGUI.game.currScreen.getLeoSprite().getX());
//		System.out.print(MainGUI.game.currScreen.getLeoSprite().getY());
		if(direction == 0) {
			leoSprite.setY(20);
			leoSprite.setX(x);
		}
		if(direction == 2) {
			leoSprite.setY(530);
			leoSprite.setX(x);
		}
		if(direction == 1) {
			leoSprite.setX(730);
			leoSprite.setY(y);
		}
		if(direction == 3) {
			leoSprite.setX(20);
			leoSprite.setY(y);
		}
	}
}