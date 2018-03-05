package rpg;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;

import guiTeacher.components.Graphic;
import guiTeacher.components.StyledComponent;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextBox;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class IntroMap extends FullFunctionScreen implements IState, KeyListener {

	private SamCustomArea intro;
	private Graphic leo;
	private MovingCharacter leoSprite;
	
	public IntroMap(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void OnEnter() {
		intro.setVisible(true);
		leo.setVisible(true);
		String start = "My name is Leo and I'm a mage, unknown to the world until today!\nI have entered this mage tournament in the continent of Varathia.\nThis tournament has a prize of the rumored magium, a power which one knows no bounds!\nI intend to seize this power for myself and that begins here.\nI have been magically teleported into the island continent and no word has been spoken yet.\nThe best thing to do for now is to wander and gather intel on what is going on.";
		intro.setText(start.substring(0,1));
		Thread printer = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i = 1; i< start.length(); i++) {
					try {
						Thread.sleep(25);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String contents = "";

					 contents = intro.getText() + start.substring(i, i+1);
					 intro.setText(contents);
					 if(i%278 ==0) {
						 try {
							Thread.sleep(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						intro.setText("");
					 }
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				intro.setVisible(false);
				leo.setVisible(false);
			}
		});
		printer.start();

	}

	@Override
	public void OnExit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		Graphic currentTile = null;
		Graphic test = null;
		//int random = 0;

		//LAYER 1
		for(int i = 0; i < this.getHeight()/16; i++) {
			for(int j = 0; j < this.getWidth()/16; j++) {
				//This was a test for selecting random tiles, can select tiles freely
				//while(test == null) {
				//random = (int) (Math.round(Math.random()*1))+56;
				if(i< 9 && j > 40) {
					test = MainGUI.allTiles[13];
				}
				else if ((i <10 &&j >= 40) || (j>40 && i <= 9) || (i < 10 && i > 4 && j >38) ||(j < 45 && j > 38 && i ==10)) {
					test = MainGUI.allTiles[10];
				}
				else if(i%2 == 0 || j%2 == 0) {
					test = MainGUI.allTiles[64];
				}
				else if (i%3 == 0 && j%3 == 0) {
					test = MainGUI.allTiles[12];
				}
				else {
					test = MainGUI.allTiles[65];
				}
				//}
				currentTile = new Graphic(0,0,test.getImage());
				currentTile.setX(16*j);
				currentTile.setY(16*i);
				viewObjects.add(currentTile);
				//test = null;
			}
		}

		for(int i = 0; i < this.getHeight()/16; i++) {
			for(int j = 0; j < this.getWidth()/16; j++) {
				//This was a test for selecting random tiles, can select tiles freely
				//while(test == null) {
				//random = (int) (Math.round(Math.random()*1))+56;
				if((i<5 || i> 31)&& !(j>5 && j<10) && !(j>40 && i <5) || j==0) {
					test = MainGUI.allTiles[30];
					currentTile = new Graphic(0,0,test.getImage());
					currentTile.setX(16*j);
					currentTile.setY(16*i);
					viewObjects.add(currentTile);
				}
				else if(j> 44 && !(i<9)){
					test = MainGUI.allTiles[38];
					currentTile = new Graphic(0,0,test.getImage());
					currentTile.setX(16*j);
					currentTile.setY(16*i);
					viewObjects.add(currentTile);
				}
				//test = null;
			}
		}
		
		try {
			File fontFile = new File("resources/Holiday.ttf");
			//			File fontFile = new File("resources//DayRoman.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
			Font baseFont=font.deriveFont(24f);
			StyledComponent.setBaseFont(baseFont);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		intro = new SamCustomArea(0, 400, 800, 200, "");
		viewObjects.add(intro);
		
		leo = new Graphic(400,147,450,253,"resources/leo.png");
		viewObjects.add(leo);
		
		leoSprite = new MovingCharacter(100,100,32,32);
		Thread move = new Thread(leoSprite);
		move.start();
		viewObjects.add(leoSprite);
		moveFocus(leoSprite);

	}
	

}
