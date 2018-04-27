package rpg;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;
import guiTeacher.components.MovingComponent;
import guiTeacher.interfaces.KeyedComponent;

public class MovingCharacter extends AnimatedComponent implements KeyedComponent {

	static final AnimatedComponent[] characterActions = {new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32),new AnimatedComponent(100, 100, 32, 32)};
	private int direction;
	private boolean canMove;
	protected Rectangle bounds;

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
		
		bounds =  new Rectangle (0,0, this.getWidth(), this.getHeight());
		bounds.x = 4;
		bounds.y = 16;
		bounds.width = 18;
		bounds.height = 32;
	}

	public void setDirection(int direction) {
		this.direction = direction;
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
				int tx = (int) (x + 32 + bounds.x + bounds.width) / 16;
				if(collisionWithTile(tx,(y + bounds.y)/16)) {
					setVx(3);	
				}
				else {
					setVx(0);
				}
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
				MainGUI.currScreen.onExit();
				MainGUI.game.setScreen(MainGUI.mainMenu);
				MainGUI.mainMenu.onEnter();
				setVy(0);
				setVx(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_C) {
				MainGUI.currScreen.onExit();
				MainGUI.game.setScreen(MainGUI.cScreen);
				MainGUI.cScreen.onEnter();
				setVy(0);
				setVx(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_I) {
				MainGUI.currScreen.onExit();
				MainGUI.iScreen.onEnter();
				MainGUI.game.setScreen(MainGUI.iScreen);
				setVy(0);
				setVx(0);
			}
			if (e.getKeyCode() == KeyEvent.VK_M) {
				MainGUI.currScreen.onExit();
				MainGUI.worldMap.onEnter();
				MainGUI.game.setScreen(MainGUI.worldMap);
				setVy(0);
				setVx(0);
			}
			
			if(((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_DOWN) )&& Math.random() > .9) {
				MainGUI.currScreen.onExit();
				MainGUI.game.setScreen(MainGUI.battle);
				MainGUI.battle.onEnter();
				setVy(0);
				setVx(0);
			}
		}
	}

	private boolean collisionWithTile(int x, int y) {
		System.out.println( MainGUI.currScreen.getTile(x,y));
		return MainGUI.currScreen.getTile(x,y).isWalkable();
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
		if(getY() < 0) {
			setY(20);
			MainGUI.currScreen.onExit();
			MainGUI.game.setScreen(MainGUI.battle);
			MainGUI.battle.onEnter();
			setVy(0);
			setVx(0);
		}
		if(getY() > 600) {
			setY(550);
			MainGUI.currScreen.onExit();
			MainGUI.game.setScreen(MainGUI.map2);
			MainGUI.battle.onEnter();
			setVy(0);
			setVx(0);
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
		
		g.setColor(Color.red);
		g.fillRect((int)bounds.x, (int)bounds.y, bounds.width, bounds.height);
		//g.drawImage(currentAction.getImage(),0, 0,this.getWidth(),this.getHeight(), null);
	}



}
