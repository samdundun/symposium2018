package rpg;

import java.awt.Font;
import java.io.File;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;

public class BattleScreen extends FullFunctionScreen implements IState {

	private Graphic background;
	private SelectMenuArea attackBox;
	private SelectMenuArea magic;
	private AnimatedComponent slime;
	private Character bSlime;
	private AnimatedComponent leo;
	private HealthBar enemyHP;
	private HealthBar myHP;
	private SelectMenuArea current;

	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		bSlime.setCurrentHP(bSlime.getMaxHP());
		bSlime.setDead(false);
		enemyHP.update();
		MainGUI.currScreen = this;

	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;
		MainGUI.save1.save();

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		bSlime = new Character(20, 0, 1, 1, 1, 1, 1, 1000);

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

				turn(MainGUI.leo.attacks[0]);

			}},new Action() {

				@Override
				public void act() {
					current = magic;
					viewObjects.add(current);
					moveFocus(current);

				}
			},new Action() {

				@Override
				public void act() {
					// TODO Auto-generated method stub

				}
			},new Action() {

				@Override
				public void act() {
					MainGUI.prevScreen.onEnter();
					MainGUI.game.setScreen(MainGUI.localMap);
					onExit();

				}
			}
		};

		String[] magicArray = {"FireBall", "ThunderBolt"};
		Action[] b = {new Action() {

			@Override
			public void act() {
				turn(MainGUI.leo.attacks[1]);

			}
		},
				new Action() {

			@Override
			public void act() {
				turn(MainGUI.leo.attacks[2]);

			}
		}
		};

		magic = new SelectMenuArea(0,20,794,150,magicArray);
		magic.setOActions(b);

		attackBox = new SelectMenuArea(0, 20, 794, 150, options);
		attackBox.setOActions(a);

		current = attackBox;
		viewObjects.add(current);
		moveFocus(current);

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

	public void turn(Attack a) {
		if(!MainGUI.leo.isDead() && !bSlime.isDead()) {
			if(!MainGUI.leo.isStunned()) {
				a.attack(MainGUI.leo, bSlime);
			}
			else if (MainGUI.leo.isStunned()) {
				MainGUI.leo.setStunned(false);
			}
			if(!bSlime.isStunned()) {
				bSlime.attacks[0].attack(bSlime, MainGUI.leo);
			}
			else if (bSlime.isStunned()) {
				bSlime.setStunned(false);
			}
			myHP.update();
			enemyHP.update();
			MainGUI.leo.checkDead();
			bSlime.checkDead();
			if(MainGUI.leo.isDead()) {
				System.exit(0);
			}
			if(bSlime.isDead()) {
				MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
				MainGUI.prevScreen.onEnter();
				MainGUI.leo.gainXP(bSlime.getGiveXP());
				MainGUI.cScreen.update();
				this.onExit();
			}
		}
		
		current = attackBox;
		viewObjects.add(current);
		moveFocus(current);
		update();
	}

}
