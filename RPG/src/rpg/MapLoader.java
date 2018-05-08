package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MapLoader {
	
	String fileName;

	public MapLoader(String fileName) {
		this.fileName = fileName;
	}
	
	public int[][] load() {
		int[][] opened = read(new File(fileName));
		if(opened == null) {
			opened = new int[50][27];
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
		int[][] output = new int[50][27];
		try {
			fileReader = new FileReader(f);
			String line = "";
			

			int row = 0;
			BufferedReader br = new BufferedReader(fileReader);
			while((line = br.readLine()) != null) {

				String[] param = line.split(" ");
				for(int i = 0; i < output[0].length; i++) {
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
