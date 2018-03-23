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
			
			//save stats first
			for(int i = 0; i < a.length;i++) {

				stats += a[i]+",";

			}
			fw.write(stats + "\n");
			String equipsBoolean = "";
			for(int j = 0; j < MainGUI.leo.getEquips().length; j++) {
				equipsBoolean += MainGUI.leo.getEquips()[j] + ",";
			}
			fw.write(equipsBoolean);
			fw.close();
			
			
			//Equipment
			fw = new FileWriter("resources/equipped1.csv");
			String equips = "";
			for(int i = 0; i <  MainGUI.myInventory.getEquipped().size();i++) {
				equips = MainGUI.myInventory.getEquipped().get(i).toString() + "\n";
				fw.write(equips);
			}
			fw.close();
			
			//Inventory
			fw = new FileWriter("resources/inventory1.csv");
			String inventory = "";
			for(int i = 0; i < MainGUI.myInventory.getItems().size();i++) {
				fw.write(MainGUI.myInventory.getItem(i).toString() + "\n");
			}
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		String fileName = "";
		String fileName2 = "";

		boolean opened = false;
		while(!opened) {
			fileName = "resources/save1.csv";
			fileName2 = "resources/equipped1.csv";
			opened = read(new File(fileName));
			opened = read(new File(fileName2));
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
				if(param.length == 11) {
					int[] a = {Integer.parseInt(param[0]),Integer.parseInt(param[1]),Integer.parseInt(param[2]),Integer.parseInt(param[3]),
							Integer.parseInt(param[4]),Integer.parseInt(param[5]),Integer.parseInt(param[6]),
							Integer.parseInt(param[7]),Integer.parseInt(param[8]),Integer.parseInt(param[9]), Integer.parseInt(param[10])};
					MainGUI.leo.setStats(a);
				}
				if(param.length == 5 && f.getName().equals("save1.csv")) {
					for(int i = 0; i < MainGUI.leo.getEquips().length;i++) {
						MainGUI.leo.getEquips()[i] = Boolean.parseBoolean(param[i]);
					}
				}
				if(param.length == 7 && f.getName().equals("equipped1.csv")) {
					MainGUI.myInventory.getEquipped().add(new Item(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2]),
							Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6])));
				}
				if(param.length == 7 && f.getName().equals("inventory1.csv")) {
					MainGUI.myInventory.getEquipped().add(new Item(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2]),
							Integer.parseInt(param[3]), Integer.parseInt(param[4]), Integer.parseInt(param[5]), Integer.parseInt(param[6])));
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
