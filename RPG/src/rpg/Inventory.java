package rpg;

import java.util.ArrayList;


public class Inventory {

	private ArrayList<Item> myInventory;
	private int gold;
	private ArrayList<Item> equipped;
	
	public static final Item[] items = {new Item("Excalibur", 100, 100, 100, 100, 0, 0), new Item("Mythril Helmet", 10, 10, 0, 10, 1, 1),new Item("Mythril Chestplate", 15, 20, 0, 15, 2, 2),
			new Item("Mythril Pants", 10, 15, 0, 10, 3, 3),new Item("Mythril Boots", 10, 10, 0, 10, 4, 4)};
	
	public Inventory() {
		myInventory = new ArrayList<Item>();
		equipped = new ArrayList<Item>();
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

	public ArrayList<Item> getEquipped() {
		return equipped;
	}

	public void setEquipped(ArrayList<Item> equipped) {
		this.equipped = equipped;
	}

}
