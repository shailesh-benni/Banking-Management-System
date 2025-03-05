package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUpOne extends JFrame implements ActionListener {
	long random;
    JTextField nameText, dobText, emailText, fnameText, addressText,pinText,cityText,stateText;
    
    JRadioButton male, female, other, married, unmarried;
    JButton next;

    SignUpOne() {
    	Random ran = new Random();
    	random = Math.abs((ran.nextLong()%900L)+1000L);
    	
    	JLabel formno = new JLabel("APPLICATION FORM NO."+random );
    	formno.setFont(new Font("Raleway", Font.BOLD,38));
    	formno.setBounds(140,20,600,40);
    	add(formno);
    	
    	JLabel personalDetails = new JLabel("Page 1 : Personal Details");
    	personalDetails.setFont(new Font("Raleway", Font.BOLD,22));
    	personalDetails.setBounds(290,80,400,30);
    	add(personalDetails);
    	
    	JLabel name = new JLabel("Name: ");
    	name.setFont(new Font("Raleway", Font.BOLD,20));
    	name.setBounds(100,140,100,30);
    	add(name);
    	
    	nameText = new JTextField();
    	nameText.setFont(new Font("Raleway",Font.BOLD,14));
    	nameText.setBounds(300, 140, 400, 30);    	
    	add(nameText);
    	
    	JLabel fname = new JLabel("Father's Name: ");
    	fname.setFont(new Font("Raleway", Font.BOLD,20));
    	fname.setBounds(100,190,200,30);
    	add(fname);
    	fnameText = new JTextField();
    	fnameText.setFont(new Font("Raleway",Font.BOLD,14));
    	fnameText.setBounds(300, 190, 400, 30);    	
    	add(fnameText);
    	
    	
    	JLabel dob = new JLabel("Date of Birth: ");
    	dob.setFont(new Font("Raleway", Font.BOLD,20));
    	dob.setBounds(100,240,200,30);
    	add(dob);
    	
    	dobText = new JTextField("DD-MM-YYYY");
        dobText.setBounds(300, 240, 300, 30);
        add(dobText);
    	
    	JLabel gender = new JLabel("Gender:  ");
    	gender.setFont(new Font("Raleway", Font.BOLD,20));
    	gender.setBounds(100,290,200,30);
    	add(gender);
    	
    	male = new JRadioButton("Male");
    	male.setBounds(300, 290, 60, 30);
    	add(male);
    	 female = new JRadioButton("Female");
    	female.setBounds(450, 290, 120, 30);
    	add(female);
    	
    	ButtonGroup gendergroup = new ButtonGroup();
    	gendergroup.add(male);
    	gendergroup.add(female);
    	
    	
    	JLabel email = new JLabel("Email:  ");
    	email.setFont(new Font("Raleway", Font.BOLD,20));
    	email.setBounds(100,340,200,30);
    	add(email);
    	emailText = new JTextField();
    	emailText.setFont(new Font("Raleway",Font.BOLD,14));
    	emailText.setBounds(300, 340, 400, 30);    	
    	add(emailText);
    	
    	JLabel marital = new JLabel("Marital Status: ");
    	marital.setFont(new Font("Raleway", Font.BOLD,20));
    	marital.setBounds(100,390,200,30);
    	add(marital);
    	
    	 married = new JRadioButton("Married");
    	married.setBounds(300, 390, 100, 30);
    	add(married);
    	 unmarried = new JRadioButton("Unmarried");
    	unmarried.setBounds(450, 390, 120, 30);
    	add(unmarried);
    	 other = new JRadioButton("Other");
    	other.setBounds(630, 390, 120, 30);
    	add(other);
    	
    	
    	ButtonGroup maritalgroup = new ButtonGroup();
    	maritalgroup.add(married);
    	maritalgroup.add(unmarried);
    	maritalgroup.add(other);
    	
    	
    	JLabel address = new JLabel("Address: ");
    	address.setFont(new Font("Raleway", Font.BOLD,20));
    	address.setBounds(100,440,200,30);
    	add(address);
    	addressText = new JTextField();
    	addressText.setFont(new Font("Raleway",Font.BOLD,14));
    	addressText.setBounds(300, 440, 400, 30);    	
    	add(addressText);
    	
    	JLabel city = new JLabel("City: ");
    	city.setFont(new Font("Raleway", Font.BOLD,20));
    	city.setBounds(100,490,200,30);
    	add(city);
    	cityText = new JTextField();
    	cityText.setFont(new Font("Raleway",Font.BOLD,14));
    	cityText.setBounds(300, 490, 400, 30);    	
    	add(cityText);
    	
    	JLabel state = new JLabel("State: ");
    	state.setFont(new Font("Raleway", Font.BOLD,20));
    	state.setBounds(100,540,200,30);
    	add(state);
    	stateText = new JTextField();
    	stateText.setFont(new Font("Raleway",Font.BOLD,14));
    	stateText.setBounds(300, 540, 400, 30);    	
    	add(stateText);
    	
    	JLabel pincode = new JLabel("Pin Code: ");
    	pincode.setFont(new Font("Raleway", Font.BOLD,20));
    	pincode.setBounds(100,590,200,30);
    	add(pincode);
    	pinText = new JTextField();
    	pinText.setFont(new Font("Raleway",Font.BOLD,14));
    	pinText.setBounds(300, 590, 400, 30);    	
    	add(pinText);
    	
    	
    	
    	JButton next = new JButton("Next");
    	next.setBackground(Color.BLACK);
    	next.setForeground(Color.WHITE);
    	next.setFont(new Font("Raleway",Font.BOLD,14));
    	next.setBounds(620,660,80,30);
    	next.addActionListener(this);
    	add(next);
    	
    	setTitle("NEW ACCOUNT");
        setLayout(null);//border layout lega or setBounds ka sunega nahi

        setSize(850, 800);
        setLocation(350, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
    	String formno = ""+ random;//
    	String name = nameText.getText();
    	String fname = fnameText.getText();
    	String dob = dobText.getText();
    	String gender = null;
    	if(male.isSelected()) {
    		gender="Male";
    	}
    	else if(female.isSelected()) {
    		gender="Female";
    	}
    	String email = emailText.getText();
    	String marital =null;
    	if(unmarried.isSelected()) {
    		marital ="Unmarried";    	}
    	else if (married.isSelected()) {
    		marital="Married";
    	}
    	else if(other.isSelected()) {
    		marital="Other";
    	}
    	
    	String address = addressText.getText();
    	String pin = pinText.getText();
    	String city = cityText.getText();
    	String state = stateText.getText();
    	
    	try {
    		if(name.equals("")) {
    			JOptionPane.showMessageDialog(null, "Name is Required");
    		}
    		else if (fname.equals("")) {
    			JOptionPane.showMessageDialog(null,"Father Name is required");
    		}
    		else if(dob.equals("")) {
    			JOptionPane.showMessageDialog(null, "Date of Birth is required");
    		}
    		else if(gender.equals("")) {
    			JOptionPane.showMessageDialog(null, "Gender is Required");
    		}
    		else if(email.equals("")) {
    			JOptionPane.showMessageDialog(null, "EmailId is Required");
    		}
    		else if(marital.equals("")) {
    			JOptionPane.showMessageDialog(null, "Marital is Required");
    		}
    		else if(address.equals("")) {
    			JOptionPane.showMessageDialog(null, "Address is Required");
    		}
    		else if(pin.equals("")) {
    			JOptionPane.showMessageDialog(null, "Pincode is Required");
    		}
    		else if(city.equals("")) {
    			JOptionPane.showMessageDialog(null, "Please Enter Your City");
    		}
    		else if(state.equals("")) {
    			JOptionPane.showMessageDialog(null, "Please Enter Your State");
    		}
    		else {
    			Conn c = new Conn();
    			String query = "insert into signup values ('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
    			c.s.executeUpdate(query);
    		}
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    	
    	
    }

    public static void main(String[] args) {
        new SignUpOne();
    }
}
