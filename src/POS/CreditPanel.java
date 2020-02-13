package POS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreditPanel extends JFrame{
	
	
	private JPanel enterPanel;
	private JPanel toolsPanel;
	private JPanel instruction;
	private JLabel toplabel;
	
	
	public CreditPanel() {
		
		enterPanel = new JPanel();
		toolsPanel = new JPanel();
		instruction = new JPanel();
		toplabel = new JLabel();
		
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getCreditPanel();
		
		this.setPreferredSize(new Dimension(500,500));
		this.setTitle("Credit Card");
		
		
		this.add(instruction, BorderLayout.NORTH);
		this.add(enterPanel, BorderLayout.CENTER);
		this.add(toolsPanel, BorderLayout.SOUTH);
		
		
		this.pack();
		this.setVisible(true);
		
		
		
	}
	
	private void getCreditPanel() {
		
		CreditPanel thiswin = this;
		thiswin.setLocation(600,100);
		
		instruction = new JPanel();
		instruction.setPreferredSize(new Dimension(500,70));
		instruction.setBackground(Color.decode("#ff7f7f"));
		
		enterPanel = new JPanel();
		enterPanel.setBounds(0, 110, 500, 400);
		enterPanel.setBackground(Color.LIGHT_GRAY);
		
		toplabel = new JLabel("Please swipe the credit card or enter card information manually:");
		instruction.add(toplabel);
		
		JLabel cardno = new JLabel("Card Number:");
		JTextField numberField = new JTextField();
		numberField.setPreferredSize(new Dimension(350, 30));
		
		enterPanel.add(cardno);
		enterPanel.add(numberField);
		
		JLabel expdate = new JLabel("Expiry Date(MM/YY):");
		JTextField expdate1 = new JTextField();
		expdate1.setPreferredSize(new Dimension(100, 30));
		
		enterPanel.add(expdate);
		enterPanel.add(expdate1);
		
		JLabel code = new JLabel("Enter the three digit code:");
		JTextField code1 = new JTextField();
		code1.setPreferredSize(new Dimension(50, 30));
		
		enterPanel.add(code);
		enterPanel.add(code1);
		
		JLabel zipcode = new JLabel("Enter the zip code:");
		JTextField zipcode1 = new JTextField();
		zipcode1.setPreferredSize(new Dimension(70, 30));
		
		enterPanel.add(zipcode);
		enterPanel.add(zipcode1);
		
		JLabel msg = new JLabel();
		msg.setPreferredSize(new Dimension(500,50));
		enterPanel.add(msg);
		


		toolsPanel = new JPanel();
		JButton enter = new JButton("Enter");
		enter.setPreferredSize(new Dimension(90,35));
		JButton close = new JButton("Go Back");
		close.setPreferredSize(new Dimension(90,35));
		
		
		toolsPanel.add(enter);
		toolsPanel.add(close);
        
		enter.addActionListener(event ->
		msg.setText("Thank you for stopping by!")
		);
		
		 
		close.addActionListener( event ->
		thiswin.dispose());
		
	}

}
