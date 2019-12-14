package pl.zsl;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
	private List<Item> items = new ArrayList<Item>();
	
	public Item createItem (String name, String price, int amount) {
		return new Item (name, price, amount);
	}
	
	public void addItem (Item item) {
		items.add(item);
	}
	
	public void removeItem (Item item) {
		items.remove(item);
	}
	
	public void removeItem (int itemIndex) {
		items.remove(itemIndex);
	}
	
	public List<Item> getItems () {
		return items;
	}
}
