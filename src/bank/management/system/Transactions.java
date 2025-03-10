package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
	JButton deposite, withdrawal, miniStatement, pinchange, fastcash,balanceenquiry,exit;
	String pinumber;
	Transactions(String pinumber){
		this.pinumber= pinumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 =new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transactions");
		text.setBounds(200,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		 deposite = new JButton("Deposite");
		deposite.setBounds(170,415,150,30);
		deposite.addActionListener(this);
		image.add(deposite);
		
		 withdrawal = new JButton("Withdrawal");
		withdrawal.setBounds(355,415,150,30);
		withdrawal.addActionListener(this);		
		image.add(withdrawal);
		
		 fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170,450,150,30);
		fastcash.addActionListener(this);		
		image.add(fastcash);
		

		 miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355,450,150,30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		 pinchange = new JButton("PIN Change");
		pinchange.setBounds(170,485,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		 balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355,485,150,30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		
		 exit = new JButton("Exit");
		exit.setBounds(355,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);//hamesha last m likhna chahiye.... 
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}
		else if(ae.getSource()==deposite) {
			setVisible(false);
			new Deposit(pinumber).setVisible(true);
		}
		else if(ae.getSource()==withdrawal) {
			setVisible(false);
			new Withdrawl(pinumber).setVisible(true);
		}
		
		else if(ae.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinumber).setVisible(true);
		}
		else if(ae.getSource()==balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinumber).setVisible(true);
		}
		else if(ae.getSource()==miniStatement) {
			setVisible(false);
			new MiniStatement(pinumber).setVisible(true);
			
		}
	}

	public static void main(String[] args) {
		new Transactions("");
	}

}
