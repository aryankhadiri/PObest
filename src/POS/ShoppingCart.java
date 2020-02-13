package POS;

import java.util.ArrayList;

public class ShoppingCart {
	private ArrayList<Item> cart;
	
	public ShoppingCart() {
		cart = new ArrayList<Item>();
	}
	public void addItem(Item item) {
		
		if (item.getQuantity()!=0){
			cart.add(item);
		}
	}
	public ArrayList<Item> getItems(){
		return cart;
		
	}
	public Item getLastItem() {
		return cart.get(cart.size()-1);
	 
	}
	
	public ArrayList<Item> getCart(){
		
		return this.cart;
		
	}
	public void removeItem(Item item) {
		cart.remove(item);
	}
	public void updateItem(Item item) {
		for (Item item1:cart ) {
			if (item1.getId()==item.getId()){
				item1.setQuantity(item.getQuantity());
			}
		}
	}
}
