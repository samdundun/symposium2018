package rpg;

import java.util.ArrayList;


public class Inventory {

	private ArrayList<Item> myInventory;
	private int gold;
	
	public static final Item[] items = {new Item("Excalibur", 100, 100, 100, 100, 0, 0), new Item("Mythril Helmet", 10, 10, 0, 10, 1, 1),new Item("Mythril Chestplate", 15, 20, 0, 15, 2, 2),
			new Item("Mythril Pants", 10, 15, 0, 10, 3, 3),new Item("Mythril Boots", 10, 10, 0, 10, 4, 4)};
	
	public Inventory() {
		myInventory = new ArrayList<Item>();
		myInventory.add(items[0]);
		myInventory.add(items[1]);
		myInventory.add(items[2]);
		myInventory.add(items[3]);
		myInventory.add(items[4]);
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
