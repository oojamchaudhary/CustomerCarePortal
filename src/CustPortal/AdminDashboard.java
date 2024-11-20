package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDashboard extends JFrame implements ActionListener {
    AdminDashboard(){
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
        JLabel info = new JLabel("Logged in as: ADMIN");
        info.setBounds(600, 160, 500, 40);
        info.setFont(new Font("Tahoma", Font.PLAIN, 30));
        info.setForeground(Color.WHITE);
        image.add(info);

        //Creating MenuBar
        JMenuBar mb2 = new JMenuBar();
        mb2.setBounds(0, 0, 1650, 30);
        mb2.setBackground(Color.WHITE);
        image.add(mb2);

        // Creating Menu
        JMenu join = new JMenu("Add");
        join.setForeground(Color.RED);
        join.addActionListener(this);
        mb2.add(join);

        JMenu remove = new JMenu("Remove");
        remove.setForeground(Color.RED);
        remove.addActionListener(this);
        mb2.add(remove);

        JMenu back = new JMenu("Logout");
        back.setForeground(Color.RED);
        back.addActionListener(this);
        mb2.add(back);



        JMenuItem join1 = new JMenuItem("Join new Employees");
        join1.setForeground(Color.MAGENTA);
        join1.addActionListener(this);
        join.add(join1);

        JMenuItem remove1 = new JMenuItem("Remove Employees");
        remove1.setForeground(Color.MAGENTA);
        remove1.addActionListener(this);
        remove.add(remove1);

        JMenuItem back1 = new JMenuItem("Go to Employee Dashboard");
        back1.setForeground(Color.MAGENTA);
        back1.addActionListener(this);
        back.add(back1);


    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getActionCommand().equals("Join new Employees")){
            setVisible(false);
            new AddEmployee();
        } else if (ae.getActionCommand().equals("Remove Employees")) {
            setVisible(false);
            new RemoveEmployee();
        } else if (ae.getActionCommand().equals("Go to Employee Dashboard")) {
            setVisible(false);
            new EmployeeDashboard();
        }

    }
    public static void main(String[] args) {
        new AdminDashboard();
    }
}
