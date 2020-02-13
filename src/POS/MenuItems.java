package POS;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MenuItems implements Iterable<Item> {
	private ArrayList<Item> items;
	private MenuCanvas menuCanvas;
	
	public MenuItems(MenuCanvas mc) {
		items = new ArrayList<Item>();
		menuCanvas = mc;
		/*
		** Read database
		*/
		try {
			BufferedReader br = new BufferedReader(new FileReader(".db"));
			String st;
			
			while ((st = br.readLine()) != null) {
				String split[] = st.split(" ");
				Item newItem = new Item(split[0], Double.parseDouble(split[1]));
				items.add(newItem);
			}
			drawMenuButton();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void addItem(Item newItem) {
		items.add(newItem);
	}
	
	public void deleteItem(Item item) {
		items.remove(item);
	}
	
	public void modifyItem(String item, String name, double price) {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item tmp = it.next();
			if (tmp.getName().equals(name)) {
				tmp.setName(name);
				tmp.setPrice(price);
			}
		}
	}
	
	public Item findItem(String name) {
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			Item tmp = it.next();
			if (tmp.getName().equals(name))
				return tmp;
		}
		return null;
	}
	
	public void updateDB() {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(".db"));
			
			Iterator<Item> it = items.iterator();
			while (it.hasNext()) {
				Item tmp = it.next();
				writer.write(tmp.getName() + " " + tmp.getPrice() + "\n");
			}
			writer.close();
			drawMenuButton();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public Iterator<Item> iterator() {
		return items.iterator();
	}
	
	private void drawMenuButton() {
		menuCanvas.getMenuPanel().removeAll();
		menuCanvas.getMenuPanel().revalidate();
		for (Item it : items) {
			JButton newButton = new JButton(it.getName());
			newButton.setPreferredSize(new Dimension(150,70));
			menuCanvas.getMenuPanel().add(newButton);
			Item newItem = new Item(it.getName(), it.getPrice());
			newButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ItemAdderPanel adderPanel = new ItemAdderPanel(
						menuCanvas.getSideStatusCanvas(), newItem,
						menuCanvas.getCart());
					adderPanel.pack();
					adderPanel.setVisible(true);
					menuCanvas.getMenuPanel().repaint();
				}
			});
		}
		menuCanvas.getMenuPanel().repaint();
	}
}