package POS;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemAdderPanel extends JFrame{
	

	public ItemAdderPanel(SideStatusCanvas checkout, Item item, ShoppingCart Cart) {
		this.setTitle("Adding " + item.getName());
		ItemAdderPanel f = this;
		JButton add = new JButton("Add");
		JButton cancel = new JButton("Cancel");
		Dimension buttonSize = new Dimension(100,30);
		JPanel buttons = new JPanel();
		buttons.add(add);
		buttons.add(cancel);
		this.add(buttons, BorderLayout.SOUTH);
		
		JPanel editor = new JPanel();
		editor.setBackground(Color.LIGHT_GRAY);
		editor.setPreferredSize(new Dimension(500,300));
		JButton qDecrease = new JButton("-");
		qDecrease.setPreferredSize(new Dimension(50,30));
		editor.add(qDecrease);
		JTextField quantity = new JTextField();
		quantity.setPreferredSize(new Dimension(80,30));
		quantity.setHorizontalAlignment(JTextField.CENTER);
		quantity.setText(0+"");
		editor.add(quantity);
		JButton qIncrease = new JButton("+");
		qIncrease.setPreferredSize(new Dimension(50,30));
		editor.add(qIncrease);
		JTextArea note = new JTextArea("Notes:");
		note.setPreferredSize(new Dimension(400, 200));
		editor.add(note, BorderLayout.SOUTH);
		this.add(editor, BorderLayout.CENTER);
		add.setPreferredSize(buttonSize);
		cancel.setPreferredSize(buttonSize);
		Font font = new Font("Arial", 1, 20);
		qDecrease.setFont(font);
		qIncrease.setFont(font);

		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Item newItem = (Item)item.clone();
				newItem.setId(Math.random());
				newItem.setQuantity(Integer.valueOf(quantity.getText()));
				newItem.setNote(note.getText());
				
				
				if (newItem.getQuantity()!=0) {	
					
					Cart.addItem(newItem);
					checkout.addItem();
					f.dispose();	
					
						
				}
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   f.dispose();

			}
		});
		
		qIncrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = Integer.valueOf((quantity.getText()));
				count +=1;
				quantity.setText(String.valueOf(count));
			}
		});
		qDecrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = Integer.valueOf((quantity.getText()));
				if (count>1) {
					count -=1;	
				}
				else {
					count = 0;
				}
				quantity.setText(String.valueOf(count));
			}
		});
		
		
		
		

	}
}
