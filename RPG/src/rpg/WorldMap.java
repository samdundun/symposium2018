package rpg;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class WorldMap extends FullFunctionScreen implements IState{

	private Graphic map;
	
	public WorldMap(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		map = new Graphic(0, 0,800,600, "resources/varathia.png");
		viewObjects.add(map);
	}

	@Override
	public void onEnter() {
		MainGUI.currScreen = this;
		
	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;
		
	}

}
