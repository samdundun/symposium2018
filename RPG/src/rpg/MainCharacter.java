package rpg;

import java.awt.event.KeyEvent;

public class MainCharacter extends MovingCharacter {

	private int direction;
	private int currentDirection;

	public MainCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		addSequence("resources/characters.png", 180,48, 0, 16, 16, 3);
		currentDirection = 3;
		direction = -1;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = getX();
		int y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			direction = 0;
			if(currentDirection != direction) {
				System.out.println(frame);
				frame.clear();
				System.out.println(frame);
				addSequence("resources/characters.png", 180,48, 16, 16, 16, 3);
				System.out.println(frame);
				currentDirection = direction;
			}
			setVx(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			direction = 1;
			if(currentDirection != direction) {
				currentDirection = direction;
				frame.clear();
				addSequence("resources/characters.png", 180,48, 32, 16, 16, 3);
			}
			setVx(3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			direction = 2;
			if(currentDirection != direction) {
				currentDirection = direction;
				frame.clear();
				addSequence("resources/characters.png", 180,48, 48, 16, 16, 3);
			}
			setVy(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			direction = 3;
			if(currentDirection != direction) {
				currentDirection = direction;
				frame.clear();
				addSequence("resources/characters.png", 180,48, 0, 16, 16, 3);
			}
			setVy(3);
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainGUI.game.setScreen(MainGUI.mainMenu);
		}
	}
	public void checkBehaviors() {
		if (getVx() == 0 && getVy() == 0) {
			setCurrentFrame(0);
		}
		if(getX() < 0) {
			setX(0);
		}
		if(getX() > 780) {
			setX(780);
		}
		if(getY() < 0) {
			setY(0);
		}
		if(getY() > 550 && ((!(getX() > 96)) || !(getX() < 144))) {
			setY(550);
		}
		if(getY() > 600) {
			MainGUI.game.setScreen(MainGUI.battle);
		}
	}
}
