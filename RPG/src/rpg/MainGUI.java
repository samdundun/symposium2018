package rpg;

import guiTeacher.GUIApplication;
import holiday.HolidayCard;

public class MainGUI extends GUIApplication {

	
	public static MainGUI game;
	public static MainMenuScreen mainMenu;
	public static LocalMap localMap;
//	public static WorldMap worldMap;
//	public static BattleScreen battle;
//	public static InGameMenu gameMenu;
	
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
