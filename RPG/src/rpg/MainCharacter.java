package rpg;

import java.awt.event.KeyEvent;

public class MainCharacter extends MovingCharacter {

	public MainCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/characters.png", 180,48, 0, 16, 16, 3);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = getX();
		int y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			addSequence("resources/characters.png", 180,48, 16, 16, 16, 3);
			setVx(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			addSequence("resources/characters.png", 180,48, 32, 16, 16, 3);
			setVx(3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			addSequence("resources/characters.png", 180,48, 48, 16, 16, 3);
			setVy(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			addSequence("resources/characters.png", 180,48, 0, 16, 16, 3);
			setVy(3);
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainGUI.game.setScreen(MainGUI.mainMenu);
		}
	}
}
