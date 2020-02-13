package POS;

import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;

public class MenuCanvasEditor extends JFrame{
		private JPanel menuListPanel;
		private JPanel menuDetailPanel;
		private JPanel toolBarPanel;
		private MenuItems items;
		private Dimension menuButtonSize = new Dimension(150,70);
		
	public MenuCanvasEditor(MenuItems items) {
		menuListPanel = new JPanel();
		menuDetailPanel = new JPanel();
		toolBarPanel = new JPanel();
		this.items = items;
		
		getEditmenuPanel();
		
		this.setTitle("Edit Menu");
		this.add(menuListPanel, BorderLayout.WEST);
		this.add(menuDetailPanel, BorderLayout.EAST);
		this.add(toolBarPanel, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
	
	}
	
	
	private void getEditmenuPanel() {
		MenuCanvasEditor currWindow = this;
		menuListPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		menuDetailPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
		toolBarPanel = new JPanel();	
		
		/*
		** menuDetail Panel
		*/
		menuDetailPanel.setPreferredSize(new Dimension(350, 500));
		
		JLabel nameLabel = new JLabel("Item Name:");
		JLabel priceLabel = new JLabel("Item Price:");
		JTextField itemName = new JTextField();
		JTextField itemPrice = new JTextField();
		JButton applyButton = new JButton("Apply");
		GridBagConstraints detailGBC = new GridBagConstraints();
		
		itemName.setPreferredSize(new Dimension(200, 50));
		itemPrice.setPreferredSize(new Dimension(200, 50));
		applyButton.setPreferredSize(new Dimension(150, 20));
		
		menuDetailPanel.setLayout(new GridBagLayout());
		detailGBC.gridx = 0;
		detailGBC.gridy = 0;
		menuDetailPanel.add(nameLabel, detailGBC);
		detailGBC.gridx = 1;
		detailGBC.gridy = 0;
		menuDetailPanel.add(itemName, detailGBC);
		detailGBC.gridx = 0;
		detailGBC.gridy = 1;
		menuDetailPanel.add(priceLabel, detailGBC);
		detailGBC.gridx = 1;
		detailGBC.gridy = 1;
		menuDetailPanel.add(itemPrice, detailGBC);
		detailGBC.gridx = 1;
		detailGBC.gridy = 2;
		menuDetailPanel.add(applyButton, detailGBC);
		
		/*
		** toolBarPanel
		*/
		JButton addButton = new JButton("Add");
		JButton delButton = new JButton("Delete");
		JButton closeButton = new JButton("Close");
		
		addButton.setPreferredSize(new Dimension(150, 20));
		delButton.setPreferredSize(new Dimension(150, 20));
		closeButton.setPreferredSize(new Dimension(150, 20));
		
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currWindow.dispose();
			}
		});
		
		toolBarPanel.setBackground(Color.gray);
		toolBarPanel.add(addButton);
		toolBarPanel.add(delButton);
		toolBarPanel.add(closeButton);
		
		/*
		** menuListPanel
		*/
		menuListPanel.setPreferredSize(new Dimension(250, 500));
		menuListPanel.setBackground(Color.white);
		menuListPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		// Parse Items here
		DefaultListModel listModel = new DefaultListModel();
		Iterator<Item> it = items.iterator();
		while (it.hasNext()) {
			listModel.addElement(it.next().getName());
		}
		JList menuList = new JList(listModel);
		//
		menuList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String selectedItem = (String)menuList.getSelectedValue();
				if (selectedItem == null)
					return ;
				Item item = items.findItem(selectedItem);
				itemName.setText(item.getName());
				itemPrice.setText(Double.toString(item.getPrice()));
			}
		});
		menuListPanel.add(menuList);
		
		addButton.addActionListener(event -> {
				String name = itemName.getText();
				String price = itemPrice.getText();
				
				if (name.isEmpty() || price.isEmpty() ||
					items.findItem(name) != null)
					return ;
				Item newitem = new Item(name, Double.parseDouble(price));
				items.addItem(newitem);
				listModel.addElement(name);
				items.updateDB();
				menuList.repaint();
			
		});
		
		
		delButton.addActionListener(event ->{
				String selectedItem = (String)menuList.getSelectedValue();
				if (selectedItem == null)
					return ;
				items.deleteItem(items.findItem(selectedItem));
				listModel.removeElement(selectedItem);
				items.updateDB();
				menuList.repaint();
			
		});
		
		
		applyButton.addActionListener(event ->
				{
				
				String selectedItem = (String)menuList.getSelectedValue();
				if (selectedItem == null)
					return ;
				items.modifyItem(selectedItem,
					itemName.getText(),
					Double.parseDouble(itemPrice.getText()));
				items.updateDB();
				menuList.repaint();
			
				});
	}
}