package POS;

import javax.swing.*;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.MathContext;

public class CheckoutPanel extends JFrame{
		
	private JPanel toolbarPanel;	
	private JPanel tipsPanel;
	private JTextArea TextField;
	Dimension menuButtonSize = new Dimension(90, 35);
	private JTextArea newText;
	private static double totall;
	private static double finall;
	private double total;
	
	public CheckoutPanel() {
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getCheckoutPanel();
		
		this.setTitle("Checkout Page");
		
		this.setPreferredSize(new Dimension(500,500));
		this.add(TextField,BorderLayout.NORTH);
		this.add(toolbarPanel, BorderLayout.SOUTH);
		this.add(tipsPanel,BorderLayout.CENTER);
	
	}
	
	private void getCheckoutPanel() {
		
		
		
		CheckoutPanel currWindow = this;
		toolbarPanel = new JPanel();
		toolbarPanel.setPreferredSize(new Dimension(500,40));
		toolbarPanel.setBackground(Color.gray);
		currWindow.setLocation(100,100);
		
		tipsPanel = new JPanel();
		tipsPanel.setPreferredSize(new Dimension(500,40));
		JLabel enter = new JLabel("Enter tip: ");
		JButton fif = new JButton("15%");
		JButton eig = new JButton("18%");
		JButton twe = new JButton("20%");
		JLabel custom = new JLabel("Custom");
		JTextField customtip = new JTextField();
		newText = new JTextArea();
		customtip.setPreferredSize(menuButtonSize);
		JButton entercustom = new JButton("Enter Custom tip");
		
		tipsPanel.add(enter);
		tipsPanel.add(fif);
		tipsPanel.add(eig);
		tipsPanel.add(twe);
		tipsPanel.add(custom);
		tipsPanel.add(customtip);
		tipsPanel.add(newText);
		newText.setEditable(false);
		
		
		
		
		total = SideStatusCanvas.getTotal();
		
		
		double tax1 = total * 0.08;
		BigDecimal bd = new BigDecimal(tax1);
		bd = bd.round(new MathContext(4));
		double tax = bd.doubleValue();
		
		double final1 = total + tax;
		BigDecimal bd3 = new BigDecimal(final1);
		bd3 = bd3.round(new MathContext(4));
		double finalwtax = bd3.doubleValue();
		
		TextField = new JTextArea("\n\n\n\n   Your Total is: $"+ total + "\n   + Tax(8%): $" + tax + "\n "  
				+"---------------------------------------------------------------\n    Final: $" + finalwtax);

		TextField.setBounds(5, 5, 10, 20);
        TextField.setBackground(new Color(102,171,205));
        TextField.setText(TextField.getText() + "\n \n \n \n \n  Please Choose Tip amount below: \n\n\n");
        TextField.setEditable(false);
        
        JButton cash = new JButton("Cash");
        cash.setPreferredSize(menuButtonSize);
        JButton card = new JButton("Credit Card");
        card.setPreferredSize(menuButtonSize);
        JButton close = new JButton("Close");
        close.setPreferredSize(menuButtonSize);
        
        toolbarPanel.add(entercustom);
        toolbarPanel.add(cash);
        toolbarPanel.add(card);
        toolbarPanel.add(close);
        
		   
        finall = finalwtax;
        
    
        
        fif.addActionListener(new ActionListener() {
     	   
     	   public void actionPerformed(ActionEvent e) {
     		   
     		   totall = 0.15 * total + final1;
     		   
     		   
     		   BigDecimal bd3 = new BigDecimal(totall);
     		   bd3 = bd3.round(new MathContext(4));
     		   finall = bd3.doubleValue();
     		   
     		   
     		   newText.setText("\n\n\n Your Total is: $"+ finall + "\n Please choose a payment method from below:");
     		  
     	   }
        });
        
        eig.addActionListener(new ActionListener() {
     	   
     	   public void actionPerformed(ActionEvent e) {
     		   
     		  totall = 0.18 * total + final1;
    		   
    		   
    		   BigDecimal bd3 = new BigDecimal(totall);
    		   bd3 = bd3.round(new MathContext(4));
    		   finall = bd3.doubleValue();
    		   
    		   newText.setText("\n\n\n Your Total is: $"+ finall + "\n Please choose a payment method from below:");
   
     	   }
        });
        
       twe.addActionListener(new ActionListener() {
     	   
     	   public void actionPerformed(ActionEvent e) {
     		  
     		   
     		  totall = 0.20 * total + final1;
    		   
    		   
    		   BigDecimal bd3 = new BigDecimal(totall);
    		   bd3 = bd3.round(new MathContext(4));
    		   finall = bd3.doubleValue();
    		   
    		   newText.setText( "\n\n\n Your Total is: $"+ finall + "\n Please choose a payment method from below:");
   
     	   }
        });
        
       
		entercustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
				
				double tips = Double.parseDouble(customtip.getText());
				
				if(tips >= 0) {
				
				totall = tips + final1;
	    		   
	    		   
	    		   BigDecimal bd3 = new BigDecimal(totall);
	    		   bd3 = bd3.round(new MathContext(4));
	    		   finall = bd3.doubleValue();
	    		   
	    		  
				newText.setText( "\n\n\n Your Total is: $"+ finall + "\n Please choose a payment method from below:");
				}
				
				else {
					
					newText.setText("\n\n\n Please enter a valid amount of tip.");
					
				}
				}
				catch(Exception e1) {
					
					newText.setText("\n\n\n Please enter a valid amount of tip.");
				}
			}
		});
       
   
        
        
		cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ChangePanel change = new ChangePanel();
				change.pack();
				change.setVisible(true);
			}
		});
        
        card.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
  
        		CreditPanel credit = new CreditPanel();
        		credit.pack();
				credit.setVisible(true);
        	}
       
        });
        
           close.addActionListener(event -> 
           {
        		   currWindow.dispose();
        	   
           });
        
		
	}
	
	public static double getTotal() {
		
		return finall;
		
	
	}
}