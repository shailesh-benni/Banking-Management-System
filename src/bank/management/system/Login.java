package bank.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    JButton login, signup, clear;
    JTextField cardText;
    JPasswordField pinText;
    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        setSize(800, 500); 
        setLocation(350, 200);
        setResizable(false); // Prevent resizing
        getContentPane().setBackground(Color.WHITE);

        // Logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(50, 20, 100, 100);
        add(label);

        // Welcome Text
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200, 40, 400, 40);
        text.setFont(new Font("Osward", Font.BOLD, 30)); // Adjusted font
        add(text);

        // Card Number
        JLabel cardNo = new JLabel("Card No.: ");
        cardNo.setBounds(120, 150, 150, 30);
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
        add(cardNo);

         cardText = new JTextField();
        cardText.setBounds(250, 150, 300, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14 ));
        add(cardText);

        // PIN
        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120, 220, 150, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        add(pin);

         pinText = new JPasswordField();
        pinText.setBounds(250, 220, 300, 30);
        pinText.setFont(new Font("Arial", Font.BOLD, 14 ));
        add(pinText);

        // Buttons
         login = new JButton("SIGN IN");
        login.setBounds(250, 300, 120, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(400, 300, 120, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("SIGN UP");
        signup.setBounds(250, 360, 270, 40); 
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Show Frame
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == clear) {
    		cardText.setText("");
    		pinText.setText("");
    	}
    	else if(ae.getSource() == login) {
    		
    	}
    	else if(ae.getSource() == signup){
    		setVisible(false);
    		new SignUpOne().setVisible(true);
    	}
    }

    public static void main(String[] args) {
        new Login();
    }
}
