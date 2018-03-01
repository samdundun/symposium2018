package rpg;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class LocalMap extends FullFunctionScreen implements IState {

	public LocalMap(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Update(float elapsedTime) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Render() {
		// TODO Auto-generated method stub

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
		Graphic currentTile = null;
		Graphic test = null;
		int random = 0;
		for(int i = 0; i < this.getHeight()/16; i++) {
			for(int j = 0; j < this.getWidth()/16; j++) {
				while(test == null) {
				random = (int) (Math.round(Math.random()*1))+56;
				test = MainGUI.allTiles[random];
				}
				currentTile = new Graphic(0,0,test.getImage());
				System.out.println(currentTile);
				currentTile.setX(16*j);
				System.out.println(16*j);
				System.out.println(16*i);
				currentTile.setY(16*i);
				currentTile.update();
				viewObjects.add(currentTile);
				test = null;
			}
		}
		
	}

}
