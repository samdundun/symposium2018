package rpg;

import java.awt.Color;
import java.awt.Graphics2D;

import guiTeacher.components.Component;

public class HealthBar extends Component {

	private Character a;

	
	public HealthBar(int x, int y, int w, int h, Character a) {
		super(x, y, w, h);
		this.a = a;
	}

	
	//Condition: the bar must always be 100 pixels x 10 pixels
	//If smaller bar will not show properly
	@Override
	public void update(Graphics2D g) {
		clear();
		float thing = (float)a.getCurrentHP()/(float)a.getMaxHP() * 100;
		g.setColor(Color.blue);
		g.fillRect(0,0,(int)thing,10);
		g.setColor(Color.red);
		g.fillRect((int) (thing), 0, (int) (100-thing), 10);

	}

}
