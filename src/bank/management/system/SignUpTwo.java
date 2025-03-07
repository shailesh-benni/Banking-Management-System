package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUpTwo extends JFrame implements ActionListener {
    String formno;
    JTextField pan, aadhar;
    JRadioButton eyes, sno, eno, syes;
    JButton next;
    JComboBox<String> religion, category, education, occupation, income;

    SignUpTwo(String formno) {
        this.formno = formno; // Receiving form number from SignUpOne
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        setLayout(null);
        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel lblReligion = new JLabel("Religion:");
        lblReligion.setFont(new Font("Raleway", Font.BOLD, 20));
        lblReligion.setBounds(100, 140, 200, 30);
        add(lblReligion);

        String[] valReligion = {"Hindu", "Muslim", "Sikh", "Christian", "Others"};
        religion = new JComboBox<>(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel lblCategory = new JLabel("Category:");
        lblCategory.setFont(new Font("Raleway", Font.BOLD, 20));
        lblCategory.setBounds(100, 190, 200, 30);
        add(lblCategory);

        String[] valCategory = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel lblIncome = new JLabel("Income:");
        lblIncome.setFont(new Font("Raleway", Font.BOLD, 20));
        lblIncome.setBounds(100, 240, 200, 30);
        add(lblIncome);

        String[] valIncome = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox<>(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel lblEducation = new JLabel("Qualification:");
        lblEducation.setFont(new Font("Raleway", Font.BOLD, 20));
        lblEducation.setBounds(100, 290, 250, 30);
        add(lblEducation);

        String[] valEducation = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others"};
        education = new JComboBox<>(valEducation);
        education.setBounds(300, 330, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel lblOccupation = new JLabel("Occupation:");
        lblOccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        lblOccupation.setBounds(100, 390, 200, 30);
        add(lblOccupation);

        String[] valOccupation = {"Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Other"};
        occupation = new JComboBox<>(valOccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel lblPAN = new JLabel("PAN Number:");
        lblPAN.setFont(new Font("Raleway", Font.BOLD, 20));
        lblPAN.setBounds(100, 440, 200, 30);
        add(lblPAN);

        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel lblAadhar = new JLabel("Aadhar Number:");
        lblAadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        lblAadhar.setBounds(100, 490, 200, 30);
        add(lblAadhar);

        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel lblSeniorCitizen = new JLabel("Senior Citizen:");
        lblSeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        lblSeniorCitizen.setBounds(100, 540, 200, 30);
        add(lblSeniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        JLabel lblExisting = new JLabel("Existing Account:");
        lblExisting.setFont(new Font("Raleway", Font.BOLD, 20));
        lblExisting.setBounds(100, 590, 200, 30);
        add(lblExisting);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        setSize(850, 800);
        setLocation(350, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String span = pan.getText();
        String saadhar = aadhar.getText();
        String seniorCitizen = syes.isSelected() ? "Yes" : "No";
        String existingAccount = eyes.isSelected() ? "Yes" : "No";

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwo VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorCitizen + "', '" + existingAccount + "')";
            c.s.executeUpdate(query);

            setVisible(false);
            new SignUpThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
