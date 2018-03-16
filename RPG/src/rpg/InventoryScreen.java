package rpg;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class InventoryScreen extends FullFunctionScreen implements IState {
	
	private Graphic body;

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		MainGUI.currScreen = this;

	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		body = new Graphic(60, 100,250,451, "resources/body.png");
		viewObjects.add(body);

	}

}
