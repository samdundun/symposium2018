package rpg;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen implements IState {

	private Graphic background;

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

	}

}
