package rpg;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
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
	public void Update(float elapsedTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnEnter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void OnExit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		StyledComponent.setButtonOutline(true);
		setBackground(Color.BLACK);

		background = new Graphic(250,150,"resources/magium.png");
		viewObjects.add(background);

		newGame = new Button(40, 100, 150, 75, "NEW",Color.white, new Action() {

			@Override
			public void act() {
				MainGUI.game.setScreen(MainGUI.localMap);

			}
		});
		newGame.setBackgroundColor(Color.white);
		newGame.setActiveBorderColor(Color.white);
		newGame.update();
		viewObjects.add(newGame);

		loadGame = new Button(40, 200, 150, 75, "LOAD",Color.white, new Action() {

			@Override
			public void act() {
				MainGUI.game.setScreen(MainGUI.localMap);

			}
		});
		loadGame.setBackgroundColor(Color.white);
		loadGame.setActiveBorderColor(Color.white);
		loadGame.update();
		viewObjects.add(loadGame);
		
		StyledComponent.setTextColor(Color.WHITE);
		title = new TextLabel(100, 500, 400, 50, "Magium");
		title.update();
		viewObjects.add(title);



	}


}
