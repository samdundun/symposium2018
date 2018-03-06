package rpg;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements IState {

	private Graphic background;
	private SamBattleArea attackBox;
	private AnimatedComponent slime;

	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
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
		background = new Graphic(0, 0, "resources/battlescene.jpg");
		viewObjects.add(background);
		
		try {
			File fontFile = new File("resources/Holiday.ttf");
			//			File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(28f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		attackBox = new SamBattleArea(0, 20, 794, 150, "");
		viewObjects.add(attackBox);
		moveFocus(attackBox);
		
		slime = new AnimatedComponent(600, 500, 32, 32);
		slime.addSequence("resources/characters.png", 180, 0, 64, 16, 16, 3);
		Thread monster = new Thread(slime);
		monster.start();
		viewObjects.add(slime);
		

	}

}
