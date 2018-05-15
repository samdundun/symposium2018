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
	private AnimatedComponent leo;
	private HealthBar enemyHP;
	private HealthBar myHP;
	private SelectMenuArea current;
	private Character curBEnemy;
	private AnimatedComponent curEnemy; 

	public static final Character[] BENEMIES = {/*slime*/new Character(20, 0, 1, 1, 1, 1, 1, 400),
			/*skeleton*/new Character(40, 0, 3, 2, 1, 1, 1, 1000),new Character(20, 0, 2, 1, 2, 1, 1, 1000),
			new Character(20, 0, 1, 1, 1, 1, 1, 4000),new Character(20, 0, 1, 1, 1, 1, 1, 6000)};

	public static final AnimatedComponent[] ENEMIES = {new AnimatedComponent(600, 500, 32, 32),
			new AnimatedComponent(600, 500, 32, 32),new AnimatedComponent(600, 500, 32, 32),
			new AnimatedComponent(600, 500, 32, 32),new AnimatedComponent(600, 500, 32, 32)};
	public BattleScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		int mob = (int)(Math.random()*3);
		curBEnemy = BENEMIES[mob];
		curEnemy = ENEMIES[mob];

		curEnemy.setVisible(true);
		curBEnemy.setCurrentHP(curBEnemy.getMaxHP());
		curBEnemy.setDead(false);
		enemyHP.update(curBEnemy);
		enemyHP.update();
		myHP.update();

	}

	@Override
	public void onExit() {
		curEnemy.setVisible(false);
		MainGUI.save1.save();

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		int mob = (int)Math.random()*3;
		curBEnemy = BENEMIES[mob];
		curEnemy = ENEMIES[mob];

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

				turn(MainGUI.leo.ATTACKS[0]);

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

		String[] magicArray = {"FireBall", "ThunderBolt", "Cure"};
		Action[] b = {new Action() {

			@Override
			public void act() {
				turn(MainGUI.leo.ATTACKS[1]);

			}
		},
				new Action() {

			@Override
			public void act() {
				turn(MainGUI.leo.ATTACKS[2]);

			}
		},
				new Action() {

			@Override
			public void act() {
				turn(MainGUI.leo.ATTACKS[3]);

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

		//ESTABLISHING ENEMY SPRITES
		//SLIME
		ENEMIES[0].addSequence("resources/characters.png", 180, 0, 64, 16, 16, 3);
		Thread monster = new Thread(ENEMIES[0]);
		monster.start();
		ENEMIES[0].setVisible(false);
		viewObjects.add(ENEMIES[0]);
		//SKELETON
		ENEMIES[1].addSequence("resources/characters.png", 180, 144, 0, 16, 16, 3);
		Thread monster1 = new Thread(ENEMIES[1]);
		monster1.start();
		ENEMIES[1].setVisible(false);
		viewObjects.add(ENEMIES[1]);
		//BAT
		ENEMIES[2].addSequence("resources/characters.png", 180, 48, 64, 16, 16, 3);
		Thread monster2 = new Thread(ENEMIES[2]);
		monster2.start();
		ENEMIES[2].setVisible(false);
		viewObjects.add(ENEMIES[2]);

		enemyHP = new HealthBar(600, 470, 100, 10, curBEnemy);
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
		if(!MainGUI.leo.isDead() && !curBEnemy.isDead()) {
			if(!MainGUI.leo.isStunned()) {
				a.attack(MainGUI.leo, curBEnemy);
			}
			else if (MainGUI.leo.isStunned()) {
				MainGUI.leo.setStunned(false);
			}
			if(!curBEnemy.isStunned()) {
				curBEnemy.ATTACKS[0].attack(curBEnemy, MainGUI.leo);
			}
			else if (curBEnemy.isStunned()) {
				curBEnemy.setStunned(false);
			}
			myHP.update();
			enemyHP.update();
			MainGUI.leo.checkDead();
			curBEnemy.checkDead();
			if(MainGUI.leo.isDead()) {
				System.exit(0);
			}
			if(curBEnemy.isDead()) {
				MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
				MainGUI.prevScreen.onEnter();
				MainGUI.leo.gainXP(curBEnemy.getGiveXP());
				MainGUI.cScreen.update();

				int drop = (int)(Math.random()*100);
				if(drop > 95) {
					int dropItem = (int)(Math.random()*5);
					MainGUI.myInventory.addItem(new Item(MainGUI.myInventory.ITEMS[dropItem].getName(),
							MainGUI.myInventory.ITEMS[dropItem].getStrengthBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getVitalityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getAgilityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getIntelligenceBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getImageIndex(),
							MainGUI.myInventory.ITEMS[dropItem].getType()));
				}
				else if(drop >75) {
					int dropItem = (int)(Math.random()*3 + 5);
					MainGUI.myInventory.addItem(new Item(MainGUI.myInventory.ITEMS[dropItem].getName(),
							MainGUI.myInventory.ITEMS[dropItem].getStrengthBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getVitalityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getAgilityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getIntelligenceBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getImageIndex(),
							MainGUI.myInventory.ITEMS[dropItem].getType()));
				}
				else if(drop >55) {
					int dropItem = (int)(Math.random()*3 + 9);
					MainGUI.myInventory.addItem(new Item(MainGUI.myInventory.ITEMS[dropItem].getName(),
							MainGUI.myInventory.ITEMS[dropItem].getStrengthBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getVitalityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getAgilityBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getIntelligenceBuff(),
							MainGUI.myInventory.ITEMS[dropItem].getImageIndex(),
							MainGUI.myInventory.ITEMS[dropItem].getType()));
				}

				this.onExit();
			}
		}

		current = attackBox;
		viewObjects.add(current);
		moveFocus(current);
		update();
	}


}
