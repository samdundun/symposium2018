package rpg;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.KeyedComponent;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class CharacterScreen extends FullFunctionScreen {

	private SelectMenuArea options;
	private SamCustomArea level;
	private SamCustomArea xp;
	private Graphic leo;
	
	public CharacterScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		setBackground(Color.BLACK);
		
		String[] stats = {"Strength : " + MainGUI.leo.getStrength(),"Vitality : "+ MainGUI.leo.getVitality(),"Agility : "+ MainGUI.leo.getAgility(),"Intelligence : "+ MainGUI.leo.getIntelligence()};
		options = new SelectMenuArea(450, 200, 300, 165, stats);
		viewObjects.add(options);
		
		leo = new Graphic(50, 150, "resources/leooverhead.png");
		viewObjects.add(leo);
		
		level = new SamCustomArea(50, 20, 300, 100, "         Leo Lvl:" + MainGUI.leo.getLevel() + "\n          Mage");
		viewObjects.add(level);
	}

}
