package rpg;

import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class Map2 extends FullFunctionScreen {

	
	private MovingCharacter leoSprite;
	
	public Map2(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic currentTile = null;
		Graphic test = null;
		//LAYER 1
				for(int i = 0; i < this.getHeight()/16; i++) {
					for(int j = 0; j < this.getWidth()/16; j++) {
						//This was a test for selecting random tiles, can select tiles freely
						//while(test == null) {
						//random = (int) (Math.round(Math.random()*1))+56;
						 if(i%2 == 0 || j%2 == 0) {
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
						currentTile.setX(16*j);
						currentTile.setY(16*i);
						viewObjects.add(currentTile);
						//test = null;
					}
				}
				
		leoSprite = new MovingCharacter(100,100, 32, 32);
		Thread move = new Thread(leoSprite);
		move.start();
		viewObjects.add(leoSprite);
		moveFocus(leoSprite);
		leoSprite.setCanMove(true);
		
	}

}
