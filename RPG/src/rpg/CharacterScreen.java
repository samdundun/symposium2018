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
	
	public CharacterScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.BLACK);
		
		String[] stats = {"Strength : " + MainGUI.leo.getStrength(),"Vitality : "+ MainGUI.leo.getVitality(),"Agility : "+ MainGUI.leo.getAgility(),"Intelligence : "+ MainGUI.leo.getIntelligence()};
		options = new SelectMenuArea(450, 220, 300, 165, stats);
		viewObjects.add(options);
		
		leo = new Graphic(50, 150, "resources/leooverhead.png");
		viewObjects.add(leo);
		
		level = new SamCustomArea(50, 20, 300, 100, "         Leo Lvl:" + MainGUI.leo.getLevel() + "\n          Mage");
		viewObjects.add(level);
		
		xp = new XPArea(450, 100, 300, 100, " XP: " + MainGUI.leo.getCurrentXP() + "/" + MainGUI.leo.getNeededXP());
		viewObjects.add(xp);
		
		exit = new Button(740, 30, 50, 50, "X", new Action() {
			
			@Override
			public void act() {
				MainGUI.prevScreen.OnEnter();
				MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
				MainGUI.cScreen.OnExit();
				
			}
		});
		exit.setForeground(Color.black);
		exit.setBackground(Color.red);
		exit.update();
		viewObjects.add(exit);
	}

	@Override
	public void OnEnter() {
		MainGUI.currScreen = this;
	}

	@Override
	public void OnExit() {
		MainGUI.prevScreen = this;
		
	}

}
