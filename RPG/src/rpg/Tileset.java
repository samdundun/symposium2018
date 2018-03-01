package rpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import guiTeacher.components.Graphic;

public class Tileset {

	Graphic[] tiles;
	Graphic set;

	public Tileset(int x, int y,int pixelWidth, int pixelHeight, String imageLocation) {

		BufferedImage originalImage;
		try {
			
			//makes image
			originalImage = ImageIO.read(new File(imageLocation));
			set = new Graphic(x,y,imageLocation);

			//sets array length and row and col sizes
			int col = set.getHeight()/pixelHeight;
			int row =set.getWidth()/pixelWidth;
			tiles = new Graphic[row*col];
			
			//cuts the tiles up
			int tilelength = 0;
			for(int i = 0; i<col; i++) {
				for(int j = 0; j<row; j++) {
					tiles[tilelength] = new Graphic(x,y,originalImage.getSubimage(x+pixelWidth*j, y+pixelHeight*i, pixelWidth, pixelHeight));
					tilelength++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public Graphic[] getTiles() {
		return tiles;
	}


}
