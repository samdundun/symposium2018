package rpg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveFile{

	public SaveFile() {
		// TODO Auto-generated constructor stub
	}

	public void save() {
		try {
			int[] a = MainGUI.leo.getStats();
			String stats = "";
			FileWriter fw = new FileWriter("resources/save1.csv");
//			fw.write( "," + MainGUI.leo.getMaxMana() + ",");
			for(int i = 0; i < a.length;i++) {

				stats += a[i]+",";

			}
			fw.write(stats);
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		String fileName = "";

		boolean opened = false;
		while(!opened) {
			fileName = "resources/save1.csv";
			opened = read(new File(fileName));
		}
	}

	public boolean read(File f) {
		FileReader fileReader;
		try {
			fileReader = new FileReader(f);
			String line = "";
			

			BufferedReader br = new BufferedReader(fileReader);
			while((line = br.readLine()) != null) {

				String[] param = line.split(",");
				if(param.length == 10) {
					int[] a = {Integer.parseInt(param[0]),Integer.parseInt(param[1]),Integer.parseInt(param[2]),Integer.parseInt(param[3]),
							Integer.parseInt(param[4]),Integer.parseInt(param[5]),Integer.parseInt(param[6]),
							Integer.parseInt(param[7]),Integer.parseInt(param[8]),Integer.parseInt(param[9])};
					MainGUI.leo.setStats(a);
				}
			}
			br.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
