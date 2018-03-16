package rpg;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.Arrays;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MainMenuScreen extends FullFunctionScreen implements IState {

	private Graphic background;
	private Button newGame;
	private Button loadGame;
	private TextLabel title;

	public MainMenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		MainGUI.currScreen = this;
	}

	@Override
	public void onExit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(Color.BLACK);

		try {
			File fontFile = new File("resources/Holiday.ttf");
			//			File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(72f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		background = new Graphic(250,150,"resources/magium.png");
		viewObjects.add(background);

		newGame = new Button(40, 100, 200, 75, "NEW",Color.white, new Action() {

			@Override
			public void act() {
				MainGUI.game.setScreen(MainGUI.localMap);
				MainGUI.localMap.setNewGame(true);
				MainGUI.game.localMap.onEnter();
				MainGUI.game.mainMenu.onExit();
				MainGUI.leo.setNewStats();
				MainGUI.save1.save();
			}
		});
		newGame.setBackgroundColor(Color.white);
		newGame.setActiveBorderColor(Color.white);
		newGame.update();
		viewObjects.add(newGame);

		loadGame = new Button(40, 200, 200, 75, "LOAD",Color.white, new Action() {

			@Override
			public void act() {
				MainGUI.game.setScreen(MainGUI.localMap);
				MainGUI.game.localMap.onEnter();
				MainGUI.game.mainMenu.onExit();
				MainGUI.save1.load();

			}
		});
		loadGame.setBackgroundColor(Color.white);
		loadGame.setActiveBorderColor(Color.white);
		loadGame.update();
		viewObjects.add(loadGame);
		
		StyledComponent.setTextColor(Color.WHITE);
		title = new TextLabel(300, 450, 400, 100, "Magium");
		title.update();
		viewObjects.add(title);


	}


}
