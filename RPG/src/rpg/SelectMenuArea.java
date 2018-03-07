package rpg;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import guiTeacher.components.Action;
import guiTeacher.interfaces.KeyedComponent;

public class SelectMenuArea extends SamCustomArea implements KeyedComponent {

	private final static String[] actions = {"Attack", "Magic", "Items","Run"};
	private Action[] oActions;
	private String[] options;
	private int selected;

	public SelectMenuArea(int x, int y, int w, int h, String[] text) {
		super(x, y, w, h, "");
		selected = 0;
		this.options = text;
		for(int i = 0; i < options.length; i++) {
			this.setText(this.getText() + options[i] + "\n");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			if(selected == this.options.length-1) {
				selected = 0;
			}
			else {
				selected++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			if(selected == 0) {
				selected = this.options.length-1;
			}
			else {
				selected--;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			if(oActions[selected] != null) {
				oActions[selected].act();;
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
	
	public void setOActions(Action[] a) {
		this.oActions = a;
	}

}