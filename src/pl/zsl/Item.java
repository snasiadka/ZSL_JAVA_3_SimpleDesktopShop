package pl.zsl;

public class Item {
	private String name;
	private String price;
	private int amount;
	
	public Item (String name, String price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
