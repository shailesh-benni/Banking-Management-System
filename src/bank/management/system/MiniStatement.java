package bank.management.system;
import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame  {
	
	
	
	MiniStatement(String pinumber){
		
		
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("Shailesh's Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		
		try {
			Conn c = new Conn();
			ResultSet rs =c.s.executeQuery("select * from login where pin = '"+pinumber+"'");
			while(rs.next()) {
				card.setText("Card Number: "+rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12) );
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinumber+"'");
			
			while(rs.next()) {
				mini.setText(mini.getText()+"<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+"<br><br><html>");
				
				
				
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		setSize(400,600);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		setLocation(20,20);
	}
	
	
	

	public static void main(String[] args) {
	new MiniStatement("");
	
	}

}
