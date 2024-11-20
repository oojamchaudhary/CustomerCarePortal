package CustPortal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField userText, passText;
    JButton cancelB,proceedB;
    Login(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(500, 200, 600, 300);
        setVisible(true);

        JLabel loginLabel = new JLabel("Employee Login Page");
        loginLabel.setBounds(520, 140, 500, 170);
        loginLabel.setFont(new Font("times new roman", Font.BOLD, 50));
        add(loginLabel);
        // Employee login verification
        JLabel user = new JLabel("UserName: ");
        user.setBounds(450, 350, 150, 50);
        user.setFont(new Font("times new roman", Font.PLAIN, 23));
        add(user);

        JLabel pass = new JLabel("Password: ");
        pass.setBounds(450, 460, 150, 50);
        pass.setFont(new Font("times new roman", Font.PLAIN, 23));
        add(pass);
        // Creating text field to take input
        userText = new JTextField();
        userText.setBounds(700, 350, 400, 50);
        add(userText);

        passText = new JTextField();
        passText.setBounds(700, 460, 400, 50);
        add(passText);
        // Adding proceed and cancel buttons
        cancelB = new JButton("<<..Cancel");
        cancelB.setBounds(480, 600, 250, 50);
        cancelB.setFont(new Font("times new roman", Font.PLAIN, 23));
        cancelB.addActionListener(this);
        add(cancelB);

        proceedB = new JButton("Proceed..>>");
        proceedB.setBounds(820, 600, 250, 50);
        proceedB.setFont(new Font("times new roman", Font.PLAIN, 23));
        proceedB.addActionListener(this);
        add(proceedB);
        // Adding Images to login page
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/loginPageImage.jpg"));
        Image i1scaled = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(220, 330, 200, 200);
        add(image1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icons/samsungLogo.png"));
        Image i2scaled = i2.getImage().getScaledInstance(320, 150, Image.SCALE_DEFAULT);
        ImageIcon i2new = new ImageIcon(i2scaled);
        JLabel image2 = new JLabel(i2new);
        image2.setBounds(1150, 330, 200, 200);
        add(image2);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == proceedB){
            String user = userText.getText();
            String pass = passText.getText();
            try{
                conn c = new conn();
                String query = "select * from emplogin where username = '"+user+"' and password = '"+pass+"'";
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new EmployeeDashboard();
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancelB){
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
