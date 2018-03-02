package rpg;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiTeacher.GUIApplication;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import holiday.HolidayCard;

public class MainGUI extends GUIApplication {

	
	public static MainGUI game;
	public static MainMenuScreen mainMenu;
	public static IntroMap localMap;
	
	public static MusicPlayer player;

//	public static WorldMap worldMap;
	public static BattleScreen battle;
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
		localMap = new IntroMap(getWidth(), getHeight());
		battle = new BattleScreen(getWidth(), getHeight());
		setScreen(mainMenu);

	}
	
	public static void main(String[] args) {
		player = new MusicPlayer("bgm");
		game = new MainGUI(810, 600);
		Thread runner = new Thread(game);
		runner.start();
		player.run();
	}
	

}
