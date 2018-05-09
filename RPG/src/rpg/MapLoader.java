package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MapLoader {
	
	public static final int TILEWIDTH = 50;
	public static final int TILEHEIGHT = 37;
	
	String fileName;

	public MapLoader(String fileName) {
		this.fileName = fileName;
	}
	
	public int[][] load() {
		int[][] opened = read(new File(fileName));
		if(opened == null) {
			opened = new int[TILEHEIGHT][TILEWIDTH];
			save(opened);
		}
		return opened;
	}
	
	public void save(int[][] a) {
		try {
			FileWriter fw = new FileWriter(fileName);
			for(int i = 0; i < a.length; i ++) {
				for(int j = 0; j  < a[0].length; j++) {
					fw.write(a[i][j] + " ");
				}
				if(i != a.length-1)
				fw.write("\n");
			}
			fw.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[][] read(File f) {
		FileReader fileReader;
		int[][] output = new int[TILEHEIGHT][TILEWIDTH];
		try {
			fileReader = new FileReader(f);
			String line = "";
			

			int row = 0;
			BufferedReader br = new BufferedReader(fileReader);
			while((line = br.readLine()) != null) {

				String[] param = line.split(" ");
				for(int i = 0; i < output[0].length; i++) {
					if(!param[i].equals(""))
					output[row][i] = Integer.parseInt(param[i]);
				}
			row++;
			}
			br.close();
			return output;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
