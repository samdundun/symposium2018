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

		for(Item i: MainGUI.myInventory.getItems()) {
			i.setAction(new Action() {

				@Override
				public void act() {
					if(i.getType() < 5 ) {
						if(MainGUI.leo.getEquips()[i.getType()] == false) {
							MainGUI.leo.setEquips(true, i.getType());
							MainGUI.leo.setStrength(MainGUI.leo.getStrength() + i.getStrengthBuff());
							MainGUI.leo.setVitality(MainGUI.leo.getVitality() + i.getVitalityBuff());
							MainGUI.leo.setAgility(MainGUI.leo.getAgility() + i.getAgilityBuff());
							MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() + i.getIntelligenceBuff());
							i.setX(75);
							i.setY(310);
							i.setAction(new Action() {
								
								@Override
								public void act() {
									// TODO Auto-generated method stub
									
								}
							});
						}
					}
				}
			});
			i.setX(400);
			i.setY(300);
			viewObjects.add(i);
		}

	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainGUI.game.setScreen((Screen) MainGUI.prevScreen);
			MainGUI.prevScreen.onEnter();
			MainGUI.currScreen.onExit();
		}
	}
}
