package POS;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.*;


public class ChangePanel extends JFrame {
	
	private JPanel enterAmountPanel;
	private JPanel toolbarPanel;
	private JTextField amount;
	private JLabel enter; 
	private JPanel messagePanel;
	private JTextArea message;
	private String msg;
	private double finaltot;
	
	Dimension menuButtonSize = new Dimension(90, 35);
	
	public ChangePanel() {
		
		enterAmountPanel = new JPanel();
		toolbarPanel = new JPanel();
		amount = new JTextField();
		enter = new JLabel();
		messagePanel = new JPanel();
		message = new JTextArea();
		msg = "";
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getChangePanel();
		this.setTitle("Cash Transaction");
		this.setPreferredSize(new Dimension(500,500));
		this.add(enterAmountPanel, BorderLayout.NORTH);
		this.add(messagePanel,BorderLayout.CENTER);
		this.add(toolbarPanel, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
		
	
		
	}
	
	
	public void getChangePanel() {
		
		ChangePanel curwindow = this;
		curwindow.setLocation(200,200);

		enterAmountPanel = new JPanel();
		
		enterAmountPanel.setPreferredSize(new Dimension(500, 60));
		enterAmountPanel.setBackground((Color.decode("#A7F6F1")));

		
		
		toolbarPanel = new JPanel();
		toolbarPanel.setPreferredSize(new Dimension(500,60));
		toolbarPanel.setBackground(Color.LIGHT_GRAY);
		
		
		enter = new JLabel("Please enter cash amount: ");
		
		enterAmountPanel.add(enter);
		
		amount = new JTextField();
		amount.setPreferredSize(new Dimension(90,35));
		enterAmountPanel.add(amount);
		
		messagePanel = new JPanel();
		message = new JTextArea();
		messagePanel.add(message);
		message.setEditable(false);
		
		JButton enter = new JButton("Enter");
		enter.setPreferredSize(menuButtonSize);
		toolbarPanel.add(enter);
		

		
		JButton exit = new JButton("Go Back");
		exit.setPreferredSize(menuButtonSize);
		toolbarPanel.add(exit);
		 
		enter.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	

	        		try {
	        			
	        	    double value1 = Double.parseDouble(amount.getText());
	        	    BigDecimal bd = new BigDecimal(value1);
	        		bd = bd.round(new MathContext(4));
	        		double value = bd.doubleValue();
	        		
	        	    double tot1 = CheckoutPanel.getTotal(); 
	        	    BigDecimal bdt = new BigDecimal(tot1);
	        		bdt = bdt.round(new MathContext(4));
	        	    double tot = bdt.doubleValue();

	        	    if(value >= tot) {
	        	    	
	        	    	
	        	    	finaltot = value - tot;
	        	    	
	        	    	 BigDecimal bdtot = new BigDecimal(finaltot);
	 	        		bdtot = bdtot.round(new MathContext(4));
	 	        	    finaltot = bdtot.doubleValue();
	 	        		
	 	        		msg = "Your change is $" + finaltot+".";
	 	        		message.setText(msg);
	 	        	
	        	    	
	        	    	
	        	    }
	        	    
	        	    else if(value < tot)
	        	    {
	        	    	System.out.println(value);
	        	    	finaltot = tot - value;
	        	    	
	        	    	 BigDecimal bdtot = new BigDecimal(finaltot);
	 	        		bdtot = bdtot.round(new MathContext(4));
	 	        	    finaltot = bdtot.doubleValue();
	 	        		
	 	        		msg = "You are missing $" + finaltot+".";
	 	        		message.setText(msg);
	 	        	
	        	    }
	        	   
	        	    
	        	    else {
	        	    	
	        	    	msg = "Please enter a valid amount.";
	        	    }
	        		
	        		}
	        		catch(Exception e1) {
	        			
	        			msg = "Please enter a valid amount.";
	        			
	        		}
	        	
	        	}
	   
	       });
		
		
		 
		 exit.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	
	        	curwindow.dispose();
	        	
	        	}
	       
	    });
		
		
	}	
		
}


