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
		//int random = 0;
		
		//LAYER 1
		for(int i = 0; i < this.getHeight()/16; i++) {
			for(int j = 0; j < this.getWidth()/16; j++) {
				//This was a test for selecting random tiles, can select tiles freely
				//while(test == null) {
				//random = (int) (Math.round(Math.random()*1))+56;
				if(i< 9 && j > 40) {
					test = MainGUI.allTiles[13];
				}
				else if ((i <10 &&j >= 40) || (j>40 && i <= 9) || (i < 10 && i > 4 && j >38) ||(j < 45 && j > 38 && i ==10)) {
					test = MainGUI.allTiles[10];
				}
				else if(i%2 == 0 || j%2 == 0) {
					test = MainGUI.allTiles[64];
				}
				else if (i%3 == 0 && j%3 == 0) {
					test = MainGUI.allTiles[12];
				}
				else {
				test = MainGUI.allTiles[65];
				}
				//}
				currentTile = new Graphic(0,0,test.getImage());
				System.out.println(currentTile);
				currentTile.setX(16*j);
				System.out.println(16*j);
				System.out.println(16*i);
				currentTile.setY(16*i);
				viewObjects.add(currentTile);
				//test = null;
			}
		}
		
		for(int i = 0; i < this.getHeight()/16; i++) {
			for(int j = 0; j < this.getWidth()/16; j++) {
				//This was a test for selecting random tiles, can select tiles freely
				//while(test == null) {
				//random = (int) (Math.round(Math.random()*1))+56;
				if((i<5 || i> 31)&& !(j>5 && j<10) && !(j>40 && i <5) || j==0) {
				test = MainGUI.allTiles[30];
				currentTile = new Graphic(0,0,test.getImage());
				System.out.println(currentTile);
				currentTile.setX(16*j);
				System.out.println(16*j);
				System.out.println(16*i);
				currentTile.setY(16*i);
				viewObjects.add(currentTile);
				}
				else if(j> 44 && !(i<9)){
				test = MainGUI.allTiles[38];
				currentTile = new Graphic(0,0,test.getImage());
				System.out.println(currentTile);
				currentTile.setX(16*j);
				System.out.println(16*j);
				System.out.println(16*i);
				currentTile.setY(16*i);
				viewObjects.add(currentTile);
				}
				//test = null;
			}
		}
		
	}

}
