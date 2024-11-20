package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDashboard extends JFrame implements ActionListener {
    EmployeeDashboard(){
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
        JLabel info = new JLabel("Logged in as: EMPLOYEE");
        info.setBounds(600, 160, 500, 40);
        info.setFont(new Font("Tahoma", Font.PLAIN, 30));
        info.setForeground(Color.WHITE);
        image.add(info);
        //Creating MenuBar
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1650, 30);
        image.add(mb);
        // Creating Menu
        JMenu pending = new JMenu("Complaints");
        pending.setForeground(Color.RED);
        mb.add(pending);

        JMenu update = new JMenu("Update Status");
        update.setForeground(Color.RED);
        mb.add(update);

        JMenu empMgmt = new JMenu("Employee Management");
        empMgmt.setForeground(Color.RED);
        mb.add(empMgmt);

        JMenu logout = new JMenu("Log Out");
        logout.setForeground(Color.RED);
        mb.add(logout);
        //Creating MenuItem
        JMenuItem pending1 = new JMenuItem("Check Pending Complaints");
        pending1.setForeground(Color.MAGENTA);
        pending1.addActionListener(this);
        pending.add(pending1);

        JMenuItem update1 = new JMenuItem("Update Status of a Complaint");
        update1.setForeground(Color.MAGENTA);
        update1.addActionListener(this);
        update.add(update1);

        JMenuItem empMgmt1 = new JMenuItem("Go to Admin Login Page");
        empMgmt1.setForeground(Color.MAGENTA);
        empMgmt1.addActionListener(this);
        empMgmt.add(empMgmt1);

        JMenuItem logout1 = new JMenuItem("Go to Login Page");
        logout1.setForeground(Color.MAGENTA);
        logout1.addActionListener(this);
        logout.add(logout1);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("Check Pending Complaints")){
            setVisible(false);
            new PendingComplaints();
        }
        else if (ae.getActionCommand().equals("Update Status of a Complaint")){
            setVisible(false);
            new UpdComplaint2();
        } else if (ae.getActionCommand().equals("Go to Admin Login Page")) {
            setVisible(false);
            new AdminLogin();
        } else if (ae.getActionCommand().equals("Go to Login Page")) {
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args) {
        new EmployeeDashboard();
    }
}
