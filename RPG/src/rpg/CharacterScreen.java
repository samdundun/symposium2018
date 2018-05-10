package rpg;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.KeyedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;

public class CharacterScreen extends FullFunctionScreen implements IState{

	private SelectMenuArea options;
	private SamCustomArea level;
	private XPArea xp;
	private Button exit;
	private Graphic leo;
	private SamCustomArea hpBack;
	private HealthBar hp;

	public CharacterScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.BLACK);

		String[] stats = {"Strength : " + MainGUI.leo.getStrength(),"Vitality : "+ MainGUI.leo.getVitality(),"Agility : "+ MainGUI.leo.getAgility(),"Intelligence : "+ MainGUI.leo.getIntelligence()};
		Action[] oActions = {
				new Action() {

					@Override
					public void act() {
						if(MainGUI.leo.getStatPoints() > 0) {
							MainGUI.leo.setStrength(MainGUI.leo.getStrength() + 1);
							MainGUI.leo.setStatPoints(MainGUI.leo.getStatPoints() - 1);
							update(0);
						}

					}
				},
				new Action() {

					@Override
					public void act() {
						if(MainGUI.leo.getStatPoints() > 0) {
							MainGUI.leo.setVitality(MainGUI.leo.getVitality() + 1);
							MainGUI.leo.setMaxHP(MainGUI.leo.getMaxHP() + 5);
							MainGUI.leo.setStatPoints(MainGUI.leo.getStatPoints() - 1);
							update(0);
						}

					}
				}	,
				new Action() {

					@Override
					public void act() {
						if(MainGUI.leo.getStatPoints() > 0) {
							MainGUI.leo.setAgility(MainGUI.leo.getAgility() + 1);
							MainGUI.leo.setStatPoints(MainGUI.leo.getStatPoints() - 1);
							update(0);
						}

					}
				}	,
				new Action() {

					@Override
					public void act() {
						if(MainGUI.leo.getStatPoints() > 0) {
							MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() + 1);
							MainGUI.leo.setStatPoints(MainGUI.leo.getStatPoints() - 1);
							update(0);
						}

					}
				}	
		};
		options = new SelectMenuArea(450, 370, 300, 165, stats);
		options.setOActions(oActions);
		viewObjects.add(options);

		leo = new Graphic(50, 150, "resources/leooverhead.png");
		viewObjects.add(leo);

		level = new SamCustomArea(50, 20, 300, 100, "         Leo Lvl:" + MainGUI.leo.getLevel() + "\n          Mage");
		viewObjects.add(level);

		xp = new XPArea(450, 250, 300, 100, " XP: " + MainGUI.leo.getCurrentXP() + "/" + MainGUI.leo.getNeededXP());
		viewObjects.add(xp);

		exit = new Button(740, 30, 50, 50, "X", new Action() {

			@Override
			public void act() {
				MainGUI.prevScreen.onEnter();
				MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
				MainGUI.cScreen.onExit(); 

			}
		});
		exit.setForeground(Color.black);
		exit.setBackground(Color.red);
		exit.update();
		viewObjects.add(exit);

		hpBack = new SamCustomArea(450, 130, 300, 100, "HP:" + MainGUI.leo.getCurrentHP() + "/" + MainGUI.leo.getMaxHP());
		viewObjects.add(hpBack);

		hp = new HealthBar(580, 143, 100, 10, MainGUI.leo);
		hp.update();
		viewObjects.add(hp);
	}

	@Override
	public void onEnter() {
		update(0);
	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;

	}

	public void update(int a) {
		super.update();
		xp.setText(" XP: " + MainGUI.leo.getCurrentXP() + "/" + MainGUI.leo.getNeededXP());
		xp.update();
		level.setText("         Leo Lvl:" + MainGUI.leo.getLevel() + "\n          Mage");
		hpBack.setText("HP:" + MainGUI.leo.getCurrentHP() + "/" + MainGUI.leo.getMaxHP());
		hp.update();
		String[] stats = {"Strength : " + MainGUI.leo.getStrength(),"Vitality : "+ MainGUI.leo.getVitality(),"Agility : "+ MainGUI.leo.getAgility(),"Intelligence : "+ MainGUI.leo.getIntelligence()};
		options.setText(stats);
	}

}
