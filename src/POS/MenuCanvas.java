package POS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MenuCanvas extends JPanel{
	private MenuItems Items;
	private JPanel menuPanel;
	private SideStatusCanvas sideStatusCanvas;
	private ShoppingCart cart;
	private MenuCanvas menuCanvas;
	
	public MenuCanvas(ShoppingCart cart) {
		this.menuCanvas = this;
		this.cart = cart;
	
		this.setPreferredSize(new Dimension(900,800)) ;
		this.setBackground(Color.decode("#2792DC"));
		this.setLayout(new BorderLayout());
		
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(750,270));
		menuPanel.setBackground(Color.decode("#2792DC"));
		this.add(menuPanel, BorderLayout.CENTER);
		
		JPanel navpanel = new JPanel();
		navpanel.setPreferredSize(new Dimension(750,30));
		this.add(navpanel, BorderLayout.NORTH);

		JButton editMenu = new JButton ("EDIT MENU");
		editMenu.setPreferredSize(new Dimension(150,20));
		navpanel.setLayout(new BorderLayout());
		navpanel.add(editMenu, BorderLayout.WEST);
		editMenu.setPreferredSize(new Dimension(150,20));
		navpanel.setLayout(new BorderLayout());
		navpanel.add(editMenu, BorderLayout.WEST);
		Items = new MenuItems(menuCanvas);
		
		sideStatusCanvas = new SideStatusCanvas(cart);
		this.add(sideStatusCanvas, BorderLayout.EAST);
		editMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCanvasEditor Editor = new MenuCanvasEditor(Items);
			}
		});
	}
	
	public JPanel getMenuPanel() {
		return menuPanel;
	}
	public SideStatusCanvas getSideStatusCanvas() {
		return sideStatusCanvas;
	}
	public ShoppingCart getCart() {
		return cart;
	}
}