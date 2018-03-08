package rpg;

import java.awt.Color;
import java.awt.Graphics2D;

public class XPArea extends SamCustomArea {

	public XPArea(int x, int y, int w, int h, String text) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}
	
	public void update(Graphics2D g){
		super.update(g);
		float thing = (float)MainGUI.leo.getCurrentXP()/(float)MainGUI.leo.getNeededXP() * 100;
		g.setColor(Color.black);
		g.drawRect(9, 49, 101, 11);
		g.setColor(Color.blue);
		g.fillRect(10, 50, (int)thing, 10);
		g.setColor(Color.white);
		g.fillRect((int) (10+ thing), 50, (int) (100-thing), 10);
	}

}
