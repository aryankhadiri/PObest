package POS;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class EditAddedItemFrame extends JFrame{
	private Item item;
	private ShoppingCart cart;
	private SideStatusCanvas s;
	private JButton buttonChosen;
	private JPanel cartPanel;
	public EditAddedItemFrame(Item item, ShoppingCart cart, SideStatusCanvas s, JButton buttonChosen, JPanel cartPanel) {
		this.item = item;
		this.cart = cart;
		this.s = s;
		this.cartPanel = cartPanel;
		this.buttonChosen = buttonChosen;
		this.setPreferredSize(new Dimension(500,400));
		this.setTitle("Edit " + item.getName());
		this.add(getPanel());
		}
	public JPanel getPanel() {
		EditAddedItemFrame p = this;
		JPanel panel = new JPanel();
		JPanel qpanel = new JPanel();
		JPanel notepanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		panel.setPreferredSize(new Dimension(500,300));
		qpanel.setPreferredSize(new Dimension(100,50));
		notepanel.setPreferredSize(new Dimension(400,200));
		buttonPanel.setPreferredSize(new Dimension(100,50));
<<<<<<< HEAD
		qpanel.setBackground(Color.WHITE);
		notepanel.setBackground(Color.lightGray);
=======
		qpanel.setBackground(Color.decode("#ffe8bb"));
		notepanel.setBackground(Color.LIGHT_GRAY);
>>>>>>> 09255c22b9c33c9edab73aa4e53c639ac2f4c9e0
		buttonPanel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		
		JButton delete = new JButton("Delete");
		JButton update = new JButton("Update");
		JButton cancel = new JButton("Cancel");
		buttonPanel.add(update);
		buttonPanel.add(delete);
		buttonPanel.add(cancel);
		
		JTextArea note = new JTextArea(item.getNote());
		note.setPreferredSize(new Dimension(400, 200));
		notepanel.add(note);
		JTextField quantity = new JTextField();
		
		quantity.setText(Integer.toString(item.getQuantity()));
		quantity.setPreferredSize(new Dimension(80,30));
		quantity.setHorizontalAlignment(JTextField.CENTER);
		
		JButton qDecrease = new JButton("-");
		qDecrease.setPreferredSize(new Dimension(50,30));
		Font font = new Font("Arial", 1, 20);
		qDecrease.setFont(font);
		JButton qIncrease = new JButton("+");
		qIncrease.setPreferredSize(new Dimension(50,30));
		qIncrease.setFont(font);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p.dispose();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart.removeItem(item);
				cartPanel.remove(buttonChosen);
				p.dispose();
				s.revalidate();
				s.repaint();
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
					count = 1;
				}
				quantity.setText(String.valueOf(count));
			}
		});
		
		
		update.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				int value = (Integer.valueOf(quantity.getText()));
				item.setQuantity(value);
				item.setNote(note.getText());
				cartPanel.remove(buttonChosen);
				//box.remove(buttonChosen);
				JButton button = new JButton();
				button.setLayout(new BorderLayout());
				
				JLabel des = new JLabel(item.getQuantity()+"x   "+ item.getName());
				JLabel price = new JLabel("$"+item.getQuantity()*item.getPrice());
				JLabel note = new JLabel("<html>"+item.getNote().replaceAll("\n", "<br/>")+"</html>");
				Font fontheader = new Font("Arial", Font.BOLD, 15);
				Font fontprice = new Font("Consolas",1 , 12);
				Font fontnote = new Font("Times", 1,10);
				des.setFont(fontheader);
				price.setFont(fontheader);
				note.setFont(fontheader);
				
				
				button.add(des, BorderLayout.NORTH);
				button.add(price, BorderLayout.LINE_END);
				button.add(note, BorderLayout.AFTER_LAST_LINE);
//				button.setPreferredSize(buttonSize);
				button.setMargin(new Insets(10,10,10,10));
				button.setBackground(Color.white);
				button.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						EditAddedItemFrame f = new EditAddedItemFrame(item, cart, s, button, cartPanel);
						f.pack();
						f.setVisible(true);
					}
					
				});
				cartPanel.add(button);
				cart.updateItem(item);
				p.dispose();
				s.revalidate();
				s.repaint();
			}
			
		});
		
		cancel.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) {
						
						p.dispose();
					}
					
				}
				);
		
		
		qpanel.add(qDecrease);
		qpanel.add(quantity);
		qpanel.add(qIncrease);
		panel.add(qpanel, BorderLayout.NORTH);
		panel.add(notepanel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		return panel;
	}
}
