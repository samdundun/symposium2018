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
	private boolean canMove;

	public MovingCharacter(int x, int y, int w, int h) {
		super(x, y, w, h);

		//Down left up right
		characterActions[0].addSequence("resources/leosprite.png", 180,0, 0, 28, 32, 3);
		Thread move = new Thread(characterActions[0]);
		move.start();

		characterActions[1].addSequence("resources/leosprite.png", 180,0, 108, 28, 32, 2);
		Thread move1 = new Thread(characterActions[1]);
		move1.start();
		characterActions[1].setVisible(false);


		characterActions[2].addSequence("resources/leosprite.png", 180,0, 36, 28, 32, 3);
		Thread move2 = new Thread(characterActions[2]);
		move2.start();
		characterActions[2].setVisible(false);

		characterActions[3].addSequence("resources/leosprite.png", 180,0, 72, 28, 32, 2);
		Thread move3 = new Thread(characterActions[3]);
		move3.start();
		characterActions[3].setVisible(false);

		direction = 0;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int x = getX();
		int y = getY(); 
		if(canMove) {
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
				MainGUI.currScreen.OnExit();
				MainGUI.game.setScreen(MainGUI.mainMenu);
				MainGUI.mainMenu.OnEnter();
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				MainGUI.currScreen.OnExit();
				MainGUI.game.setScreen(MainGUI.cScreen);
				MainGUI.cScreen.OnEnter();
			}
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
		if(getX() < 16) {
			setX(16);
		}
		if(getX() > 700) {
			setX(695);
		}
		//top boundaries
		if(getY() < 64 && !(getX() > 90 && getX() < 148)) {
			setY(64);
		}
		if(getY() < 64 && (getX() < 94)) {
			setX(94);
		}
		if(getY() < 64 && (getX() > 138 )) {
			setX(138);
		}
		if(getY() < 0) {
			setY(20);
			MainGUI.game.setScreen(MainGUI.battle);
			setVy(0);
		}

		//bottom boundaries
		if(getY() > 482 && !(getX() > 90 && getX() < 148)) {
			setY(482);
		}
		if(getY() > 482 && getX() < 94 ) {
			setX(94);
		}
		if(getY() > 482 &&  getX() > 138) {
			setX(138);
		}
		if(getY() > 600) {
			setY(550);
			MainGUI.game.setScreen(MainGUI.battle);
			setVy(0);
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

	public void setCanMove(boolean canMove) {
		this.canMove = canMove;
	}

	@Override
	public void drawImage(Graphics2D g) {
		AnimatedComponent currentAction = characterActions[direction];
		//		clear();
		setImage(currentAction.getImage());
		//g.drawImage(currentAction.getImage(),0, 0,this.getWidth(),this.getHeight(), null);
	}



}
