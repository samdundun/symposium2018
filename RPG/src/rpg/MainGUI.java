package rpg;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import holiday.HolidayCard;

public class MainGUI extends GUIApplication {

	
	public static MainGUI game;
	public static MainMenuScreen mainMenu;
	public static LocalMap localMap;
//	public static WorldMap worldMap;
//	public static BattleScreen battle;
//	public static InGameMenu gameMenu;
	
	public static final Tileset setOfTiles = new Tileset(0, 0, 16, 16, "resources/basictiles.png");
	public static final Graphic[] allTiles = setOfTiles.getTiles();
	
	public MainGUI(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void initScreen() {
		mainMenu = new MainMenuScreen(getWidth(), getHeight());
		localMap = new LocalMap(getWidth(), getHeight());
		setScreen(mainMenu);

	}
	
	public static void main(String[] args) {
		game = new MainGUI(800, 600);
		Thread runner = new Thread(game);
		runner.start();
	}
	

}
