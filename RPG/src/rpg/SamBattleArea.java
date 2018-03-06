package rpg;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import guiTeacher.interfaces.KeyedComponent;

public class SamBattleArea extends SamCustomArea implements KeyedComponent {

	private final static String[] actions = {"Attack", "Magic", "Items","Run"};
	private int selected;

	public SamBattleArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		selected = 0;
		for(int i = 0; i < actions.length; i++) {
			this.setText(this.getText() + actions[i] + "\n");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(selected == 3) {
				selected = 0;
			}
			else {
				selected++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(selected == 0) {
				selected = 3;
			}
			else {
				selected--;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(selected == 3) {
				MainGUI.game.setScreen(MainGUI.localMap);
			}
		}
		update();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

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
	
	public void update(Graphics2D g) {
		super.update(g);
		g.drawRect(2, (5+(36*selected)), 300, 30);
	}

}
