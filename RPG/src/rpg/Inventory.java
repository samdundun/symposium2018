package rpg;

import java.util.ArrayList;


public class Inventory {

	private ArrayList<Item> myInventory;
	private int gold;
	private ArrayList<Item> equipped;

	public static final Item[] ITEMS = {new Item("Excalibur", 100, 100, 100, 100, 0, 0), new Item("Mythril Helmet", 10, 10, 0, 10, 1, 1),new Item("Mythril Chestplate", 15, 20, 0, 15, 2, 2),
			new Item("Mythril Pants", 10, 15, 5, 10, 3, 3),new Item("Mythril Boots", 10, 10, 10, 10, 4, 4), 
			/*Basic Armor*/new Item("Basic Shirt",1,1,0,0,5,2),new Item("Basic Pants",1,1,0,0,6,3),new Item("Basic Shoes",1,0,1,0,7,4),
			/*Magic Armor*/new Item("Magic Hood",0,1,0,2,8,1),new Item("Magic Shirt",0,1,0,3,9,2),new Item("Magic Kilt",0,1,0,2,10,3),new Item("Magic Boots",0,1,1,1,11,4)};

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
		if(myInventory.size() < 48) {
			myInventory.add(i);
		}
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
