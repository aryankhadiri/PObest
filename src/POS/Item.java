package POS;

public class Item implements Cloneable{
	private String name;
	private double price;
	private int quantity;
	private String note;
	private double id;
	
	public Item(String name, double d) {
		this.name = name;
		this.price = d;
		id = 1 + Math.random();
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return this.note;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getId() {
		return this.id;
	}
	public void setId(double a) {
		this.id = a;
	}
	public Object clone() {
		try {
			return super.clone();
		}
		catch(CloneNotSupportedException e){
			return null;
			
		}
	}
}
