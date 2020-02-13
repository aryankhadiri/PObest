package POS;
import javax.swing.*;
public class Main {
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		JFrame window = new AppFrame();
		window.pack();
		window.setVisible(true);
	}
}