package POS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.border.Border;
public class SideStatusCanvas extends JPanel{
	private static ShoppingCart cart;
	private JPanel checkoutPanel;
	private JPanel cartPanel = new JPanel();
	private static double total;

	ArrayList<JButton> buttons = new ArrayList<>();

	public SideStatusCanvas(ShoppingCart cart) {
		this.setPreferredSize(new Dimension(400,600));
		this.setBackground(Color.orange);
		this.setLayout(new BorderLayout());
		this.cart = cart;
		
		checkoutPanel = new JPanel();
		checkoutPanel.setPreferredSize(new Dimension(250,40));
		checkoutPanel.setLayout(new BorderLayout());
		JButton checkoutbutton = new JButton("Checkout");
		checkoutbutton.setPreferredSize(new Dimension(100,10));
		checkoutPanel.add(checkoutbutton, BorderLayout.CENTER);
		this.add(checkoutPanel, BorderLayout.SOUTH);
		
		cartPanel = new JPanel();
		cartPanel.setLayout(new GridLayout(20,1));

		cartPanel.setBackground(Color.white);
		JScrollPane panel = new JScrollPane(cartPanel, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER	);
		
		panel.setPreferredSize(new Dimension(250,950));
		this.add(panel, BorderLayout.NORTH);
		
		checkoutbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckoutPanel Editor = new CheckoutPanel();
				Editor.pack();
				Editor.setVisible(true);
			}
		});
		
	}
	
	public void addItem() {
		
		SideStatusCanvas s = this;
		if (cart.getItems().size()!=0){
		Dimension buttonSize = new Dimension(300,70);

		System.out.println(cart.getItems());
		Item item = this.cart.getLastItem();
		
		JButton button = new JButton();
		button.setLayout(new BorderLayout());
		
		JLabel des = new JLabel(item.getQuantity()+"x   "+ item.getName());
		JLabel price = new JLabel("$"+item.getQuantity()*item.getPrice());
		JLabel note = new JLabel("<html>"+item.getNote().replaceAll("\n", "<br/>")+"</html>");
		Font fontheader = new Font("Arial", Font.BOLD, 15);
		Font fontprice = new Font("Arial",1 , 12);
		Font fontnote = new Font("Times", 1,10);
		des.setFont(fontheader);
		price.setFont(fontprice);
		note.setFont(fontnote);
		
		
		button.add(des, BorderLayout.NORTH);
		button.add(price, BorderLayout.LINE_END);
		button.add(note, BorderLayout.AFTER_LAST_LINE);
//		button.setPreferredSize(buttonSize);
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
		this.revalidate();
		this.repaint();
		}
		}
	
	public static double getTotal() {
		total = 0;
		for (Item itemexample:cart.getCart()) {
			System.out.println(itemexample.getName()+"  "+itemexample.getId()+ " " +itemexample.getQuantity());

			total+=(itemexample.getPrice() * itemexample.getQuantity());
			
		}
		System.out.println("-----------------------");
		
		 BigDecimal bd3 = new BigDecimal(total);
		   bd3 = bd3.round(new MathContext(4));
		   double finalt = bd3.doubleValue();
		   
		return finalt;
		
	}
}
		
	
	

