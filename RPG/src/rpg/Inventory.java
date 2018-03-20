package rpg;

import java.util.ArrayList;


public class Inventory {

	private ArrayList<Item> myInventory;
	private int gold;
	
	public static final Item[] items = {new Item("Excalibur", 100, 100, 100, 100, 0, 0)};
	
	public Inventory() {
		myInventory = new ArrayList<Item>();
		myInventory.add(items[0]);
	}
	
	public ArrayList<Item> getItems(){
		return myInventory;
	}

	public Item getItem(int index){
		return myInventory.get(index);
	}

	public void addItem(Item i){
		myInventory.add(i);
	}

	public void removeItem(Item i) {
		myInventory.remove(i);
	}

}
