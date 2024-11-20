package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerCarePortal extends JFrame implements ActionListener {
    JButton  empButton, custButton;
    public int i;
    CustomerCarePortal(){
        setSize(1651, 864);
        setVisible(true);
        setLayout(null);
        // Adding bg image to home screen
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("samsungHome.jpg"));
        JLabel image = new JLabel(i1);  //cant paste image directly on the frame so using j label class
        image.setBounds(0 ,0 , 1651, 864);
        add(image);
        // Adding title to the home screen
        JLabel text = new JLabel("DEMO CUSTOMER CARE PORTAL");
        text.setBounds(45, 150, 800, 100);
        image.add(text); // adding text on top of image
        text.setForeground(Color.darkGray);  // adding font colour  -- Colour class in awt package import it
        text.setFont(new Font("times new roman", Font.ITALIC, 40)); // describing font details
        // Creating Customer login button
        custButton = new JButton("Customer login>>>");
        custButton.setBounds(621, 684, 250, 50);
        custButton.setBackground(Color.blue);
        custButton.setForeground(Color.white);
        custButton.setFont(new Font("serif", Font.PLAIN, 23));
        image.add(custButton);
        custButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // setVisible(false);
                new CustomerDashboard();
            }
        });
        // Creating Employee login button
        empButton = new JButton("Employee login>>>");
        empButton.setBounds(621, 764, 250, 50);
        empButton.setBackground(Color.blue);
        empButton.setForeground(Color.white);
        empButton.setFont(new Font("serif", Font.PLAIN, 23));
        image.add(empButton);
        empButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //setVisible(false);
                new Login();
            }
        });

        // adding dipper functionality to title
        while (true){
            text.setVisible(false);
            try {
                Thread.sleep(400);
            }
            catch (Exception e){
                System.out.println(e);
            }
            text.setVisible(true);
            try {
                Thread.sleep(600);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
    }
        @Override
        public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == empButton ){}
        }
    public static void main(String[] args) {
        new CustomerCarePortal();
    }
}
