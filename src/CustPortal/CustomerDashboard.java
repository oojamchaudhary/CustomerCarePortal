package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerDashboard extends JFrame implements ActionListener{
    JMenuItem reg1;
    CustomerDashboard() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);
        setBounds(0, 0, 1550, 1000);
        setVisible(true);

        // Setting Background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/DashboardBG.jpg"));
        Image i11 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel image = new JLabel(i12);
        image.setBounds(0, 0, 1550, 1000);
        add(image);

        // Welcome text
        JLabel welTxt = new JLabel("Welcome to the Customer Care Portal of Samsung...!!!");
        welTxt.setBounds(250, 80, 1000, 50);
        welTxt.setFont(new Font("Tahoma", Font.PLAIN, 40));
        welTxt.setForeground(Color.WHITE);
        image.add(welTxt);

        //Login info text
        JLabel info = new JLabel("Logged in as: CUSTOMER");
        info.setBounds(600, 160, 500, 40);
        info.setFont(new Font("Tahoma", Font.PLAIN, 30));
        info.setForeground(Color.WHITE);
        image.add(info);


        //Creating MenuBar
        JMenuBar mb1 = new JMenuBar();
        mb1.setBounds(0, 0, 1650, 30);
        image.add(mb1);

        // Creating Menu
        JMenu register = new JMenu("New Complaints");
        register.setForeground(Color.RED);
        mb1.add(register);

        JMenu check = new JMenu("Old Complaints");
        check.setForeground(Color.RED);
        mb1.add(check);

        JMenu logout = new JMenu("Logout");
        logout.setForeground(Color.RED);
        mb1.add(logout);

        // Creating Menu Item
        JMenuItem reg1 = new JMenuItem("Register a new complaint");
        reg1.setForeground(Color.MAGENTA);
        reg1.addActionListener(this);
        register.add(reg1);

        JMenuItem check1 = new JMenuItem("Check Status of complaint");
        check1.setForeground(Color.MAGENTA);
        check1.addActionListener(this);
        check.add(check1);

        JMenuItem logout1 = new JMenuItem("Log Out current session");
        logout1.setForeground(Color.MAGENTA);
        logout1.addActionListener(this); // set visible false
        logout.add(logout1);

    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Register a new complaint")){
            setVisible(false);
            new AddCustomer();
        } else if (ae.getActionCommand().equals("Check Status of complaint")) {
            setVisible(false);
            new CheckComplaint();
        } else if (ae.getActionCommand().equals("Log Out current session")) {
            setVisible(false);
        }


    }


        public static void main (String [] args){
            new CustomerDashboard();
        }


}

