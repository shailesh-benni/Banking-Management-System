package bank.management.system;
import java.awt.Image;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener{

	JPasswordField pin, repin;
	JButton change, back;
	String pinumber;
	PinChange(String pinumber){
		this.pinumber= pinumber;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN");
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System",Font.BOLD,16));
		pintext.setBounds(165,320,180,25);
		image.add(pintext);
		
		
		 pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		
		
		JLabel repintext = new JLabel("Re-Enter New PIN");
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System",Font.BOLD,16));
		repintext.setBounds(165,360,180,25);
		image.add(repintext);
		
		
		 repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		
		
		
		 change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()== change) {
			
		
		try {
			String npin = pin.getText();
			String rnpin = repin.getText();
			if(!npin.equals(rnpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN does not match.");
				return;
			}
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter PIN");
				return;
			}
			
			if(rnpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-enter PIN");
				return;
			}
			
			Conn c1 = new Conn();
			String q1 = "update bank set pin = '"+rnpin+"' where pin='"+pinumber+"' ";
			String q2 = "update login set pin = '"+rnpin+"' where pin='"+pinumber+"' ";
			String q3 = "update signupthree set pin = '"+rnpin+"' where pin='"+pinumber+"' ";
			
			c1.s.executeUpdate(q1);
			c1.s.executeUpdate(q2);
			c1.s.executeUpdate(q3);
			
			JOptionPane.showMessageDialog(null, "PIN Changed Successfully.");
			
			setVisible(false);
			new Transactions(rnpin).setVisible(true);
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transactions(pinumber).setVisible(true);
		}
		
		
	}
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

}
