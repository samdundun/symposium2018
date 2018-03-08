package rpg;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements IState {

	private Graphic background;
	private SelectMenuArea attackBox;
	private AnimatedComponent slime;
	private Character bSlime;
	private AnimatedComponent leo;
	private HealthBar enemyHP;
	private HealthBar myHP;

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
		bSlime = new Character(20, 0, 1, 1, 1, 1, 1);
		
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
		
		String[] options = {"Attack", "Magic", "Items", "Run"};
		Action[] a = {new Action() {
			
			@Override
			public void act() {
				MainGUI.leo.attacks[0].attack(MainGUI.leo, bSlime);
				bSlime.attacks[0].attack(bSlime, MainGUI.leo);
				myHP.update();
				enemyHP.update();
				
			}},new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					
				}
			},new Action() {
				
				@Override
				public void act() {
					// TODO Auto-generated method stub
					
				}
			},new Action() {
				
				@Override
				public void act() {
					MainGUI.game.setScreen(MainGUI.localMap);
					
				}
			}
		};
		attackBox = new SelectMenuArea(0, 20, 794, 150, options);
		attackBox.setOActions(a);
		viewObjects.add(attackBox);
		moveFocus(attackBox);
		
		slime = new AnimatedComponent(600, 500, 32, 32);
		slime.addSequence("resources/characters.png", 180, 0, 64, 16, 16, 3);
		Thread monster = new Thread(slime);
		monster.start();
		viewObjects.add(slime);
		
		enemyHP = new HealthBar(600, 470, 100, 10, bSlime);
		enemyHP.update();
		viewObjects.add(enemyHP);
		
		
		
		leo = new AnimatedComponent(100, 500, 32, 32);
		leo.addSequence("resources/leosprite.png", 180,0, 0, 28, 32, 3);
		Thread me = new Thread(leo);
		me.start();
		viewObjects.add(leo);
		
		myHP = new HealthBar(100, 470, 100, 10, MainGUI.leo);
		myHP.update();
		viewObjects.add(myHP);
		

	}

}
