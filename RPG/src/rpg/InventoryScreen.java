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
	Action equip;
	Action unEquip;

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




		int initialX = 400;
		int initialY = 100;
		int col = 0;
		int row = 0;
		for(Item i: MainGUI.myInventory.getItems()) {
			equip = new Action() {

				@Override
				public void act() {
					if(i.getType() < 5 ) {
						if(MainGUI.leo.getEquips()[i.getType()] == false) {
							MainGUI.leo.setEquips(true, i.getType());
							MainGUI.leo.setStrength(MainGUI.leo.getStrength() + i.getStrengthBuff());
							MainGUI.leo.setVitality(MainGUI.leo.getVitality() + i.getVitalityBuff());
							MainGUI.leo.setAgility(MainGUI.leo.getAgility() + i.getAgilityBuff());
							MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() + i.getIntelligenceBuff());
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
							i.setAction(unEquip);

						}
					}
				}
			};

				unEquip = new Action() {

					@Override
					public void act() {
						MainGUI.leo.setEquips(false, i.getType());
						MainGUI.leo.setStrength(MainGUI.leo.getStrength() - i.getStrengthBuff());
						MainGUI.leo.setVitality(MainGUI.leo.getVitality() - i.getVitalityBuff());
						MainGUI.leo.setAgility(MainGUI.leo.getAgility() - i.getAgilityBuff());
						MainGUI.leo.setIntelligence(MainGUI.leo.getIntelligence() - i.getIntelligenceBuff());
						i.setAction(equip);

					}
				};
				i.setAction(equip);
				i.setX(initialX + (col *48));
				i.setY(initialY + (row * 48));
				col++;
				if(col >= 10) {
					col = 0;
					row++;
				}
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
