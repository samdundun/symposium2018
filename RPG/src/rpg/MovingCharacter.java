package rpg;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;
import guiTeacher.components.MovingComponent;
import guiTeacher.interfaces.KeyedComponent;

public class MovingCharacter extends AnimatedComponent implements KeyedComponent {

   static final AnimatedComponent[] characterActions = {new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32)};
	private int direction;
   
	public MovingCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);
		
		//Down left up right
		characterActions[0].addSequence("resources/characters.png", 180,48, 0, 16, 16, 3);
		Thread move = new Thread(characterActions[0]);
		move.start();
		
		characterActions[1].addSequence("resources/characters.png", 180,48, 16, 16, 16, 3);
		Thread move1 = new Thread(characterActions[1]);
		move1.start();
		characterActions[1].setVisible(false);
		
		
		characterActions[2].addSequence("resources/characters.png", 180,48, 48, 16, 16, 3);
		Thread move2 = new Thread(characterActions[2]);
		move2.start();
		characterActions[2].setVisible(false);
		
		characterActions[3].addSequence("resources/characters.png", 180,48, 32, 16, 16, 3);
		Thread move3 = new Thread(characterActions[3]);
		move3.start();
		characterActions[3].setVisible(false);
		
		direction = 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = getX();
		int y = getY(); 
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			direction = 1;
			setVx(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			direction = 3;
			setVx(3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			direction = 2;
			setVy(-3);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			direction = 0;
			setVy(3);
		}
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			MainGUI.game.setScreen(MainGUI.mainMenu);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			setVx(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			setVx(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
			setVy(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			setVy(0);
		}
	}

	public void checkBehaviors() {
		if (getVx() == 0 && getVy() == 0) {
			characterActions[direction].setCurrentFrame(0);
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
			setY(550);
			MainGUI.game.setScreen(MainGUI.battle);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isHovered(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawImage(Graphics2D g) {
		AnimatedComponent currentAction = characterActions[direction];
//		clear();
		setImage(currentAction.getImage());
		//g.drawImage(currentAction.getImage(),0, 0,this.getWidth(),this.getHeight(), null);
	}



}
