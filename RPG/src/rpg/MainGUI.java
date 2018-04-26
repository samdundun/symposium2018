package rpg;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class MainGUI extends GUIApplication {

	
	public static MainGUI game;
	public static MainMenuScreen mainMenu;
	public static IntroMap localMap;
	public static Map2 map2;
	
	public static Character leo;
	public static CharacterScreen cScreen;
	public static InventoryScreen iScreen;
	public static SaveFile save1;
	public static Inventory myInventory;
	
	public static IState prevScreen;
	public static IState currScreen;
	
//	public static MusicPlayer player;

	public static WorldMap worldMap;
	public static BattleScreen battle;
	
	public static final Tileset setOfTiles = new Tileset(0, 0, 16, 16, "resources/basictiles.png");
	public static final Graphic[] allTiles = setOfTiles.getTiles();
	
	public static BufferedImage MYTHRILARMOR;
	public static BufferedImage ARMOR;
	
	public static final Tile tiles= new Tile(0, 0, allTiles[0].getImage(), 0);
	
	public MainGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		
		
//		for resizing but will work on later
//		addComponentListener(new ComponentAdapter() 
//		{  
//		        public void componentResized(ComponentEvent evt) {
//		            Component c = (Component)evt.getSource();
//		        }
//		});

	}
	

	@Override
	public void initScreen() {
		try {
			 MYTHRILARMOR = ImageIO.read(new File("resources/mythrilarmor.png"));
			 ARMOR = ImageIO.read(new File("resources/armor.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		myInventory = new Inventory();
		leo = new Character(0, 0, 0, 0, 0, 0, 0,0);
		leo.setNewStats();
		save1 = new SaveFile();
		mainMenu = new MainMenuScreen(getWidth(), getHeight());
		localMap = new IntroMap(getWidth(), getHeight());
		battle = new BattleScreen(getWidth(), getHeight());
		cScreen = new CharacterScreen(getWidth(), getHeight());
		iScreen = new InventoryScreen(getWidth(), getHeight());
		worldMap = new WorldMap(getWidth(), getHeight());
		map2 = new Map2(getWidth(), getHeight());
		setScreen(mainMenu);
		mainMenu.onEnter();

	}
	
	public static void main(String[] args) {
//		player = new MusicPlayer("bgm");
		game = new MainGUI(810, 600);
		Thread runner = new Thread(game);
		runner.start();
//		player.run();
	}
	

}
