package rpg;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import guiTeacher.userInterfaces.Screen;

public class InventoryScreen extends FullFunctionScreen implements IState {

	private Graphic body;
	SamCustomArea desc;
	private Button exit;

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
			if(col >= 8) {
				col = 0;
				row++;
			}
			i.setHoverAction(new Action() {

				@Override
				public void act() {
					desc.setText("Name: " + i.getName() + " \nSTR: " + i.getStrengthBuff() + " VIT: "+ i.getVitalityBuff() + " AGI: " + i.getAgilityBuff() + " INT: " + i.getIntelligenceBuff());

				}
			});
			i.setUnHoverAction(new Action() {

				@Override
				public void act() {
					desc.setText("");

				}
			});
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
			i.setUnHoverAction(new Action() {

				@Override
				public void act() {
					desc.setText("Name: " + i.getName() + " \nSTR: " + i.getStrengthBuff() + " VIT: "+ i.getVitalityBuff() + " AGI: " + i.getAgilityBuff() + " INT: " + i.getIntelligenceBuff());

				}
			});
			i.setHoverAction(new Action() {

				@Override
				public void act() {
					desc.setText("");

				}
			});
			viewObjects.add(i);
		}

		desc = new SamCustomArea(400, 400, 350, 150, "");
		viewObjects.add( desc);
		
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


	}

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
			if(col >= 8) {
				col = 0;
				row++;
			}
		}
	}

	@Override
	public Tile getTile(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
