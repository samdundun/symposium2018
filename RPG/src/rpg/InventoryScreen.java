package rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;

public class InventoryScreen extends FullFunctionScreen implements IState,KeyListener {

	private Graphic body;
	SamCustomArea desc;

	public InventoryScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onEnter() {
		MainGUI.currScreen = this;
		MainGUI.iScreen = new InventoryScreen(getWidth(), getHeight());
//		this.update(0);

	}

	@Override
	public void onExit() {
		MainGUI.prevScreen = this;
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		body = new Graphic(60, 100,250,451, "resources/body.png");
		viewObjects.add(body);




		int initialX = 400;
		int initialY = 100;
		int col = 0;
		int row = 0;
		for(Item i: MainGUI.myInventory.getItems()) {

			i.setAction(new Action() {

				@Override
				public void act() {
					i.equip();
				}
			});
			i.setX(initialX + (col *48));
			i.setY(initialY + (row * 48));
			col++;
			if(col >= 10) {
				col = 0;
				row++;
			}
			viewObjects.add(i);
		}
		for(Item i: MainGUI.myInventory.getEquipped()) {
			if(i.getType() == 0) {
				i.setX(75);
				i.setY(310);	
			}
			if(i.getType() == 1) {
				i.setX(168);
				i.setY(100);	
			}
			if(i.getType() == 2) {
				i.setX(168);
				i.setY(200);	
			}
			if(i.getType() == 3) {
				i.setX(168);
				i.setY(325);	
			}
			if(i.getType() == 4) {
				i.setX(168);
				i.setY(500);	
			}
			i.setAction(new Action() {
				
				@Override
				public void act() {
					i.unequip();
					
				}
			});
			viewObjects.add(i);
		}
		
		desc = new SamCustomArea(400, 400, 350, 150, "");
		viewObjects.add( desc);
		

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
			MainGUI.prevScreen.onEnter();
			MainGUI.currScreen.onExit();
		}
	}

//	public void update(int x) {
//		super.update();
//	}
	
	public void update() {
		super.update();
		int initialX = 400;
		int initialY = 100;
		int col = 0;
		int row = 0;
		for(Item i : MainGUI.myInventory.getItems()) {
			i.setX(initialX + (col *48));
			i.setY(initialY + (row * 48));
			col++;
			if(col >= 10) {
				col = 0;
				row++;
			}
		}
	}
}
