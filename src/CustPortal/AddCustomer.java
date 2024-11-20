package CustPortal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField textField, textField_1, textField_2, textField_3;
    JButton SbtRqt,Cancel;
    JComboBox c1;

    public AddCustomer() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(530, 200, 900, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel AddCustomers = new JLabel("CUSTOMER DETAILS");
        AddCustomers.setForeground(Color.BLUE);
        AddCustomers.setFont(new Font("Tahoma", Font.PLAIN, 31));
        AddCustomers.setBounds(715, 125, 442, 35);
        add(AddCustomers);

        JLabel CustomerName = new JLabel("NAME");
        CustomerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        CustomerName.setBounds(715,200 , 150, 35);
        add(CustomerName);

        textField = new JTextField();
        textField.setBounds(840, 200, 200, 35);
        add(textField);

        JLabel Product = new JLabel("PRODUCT");
        Product.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Product.setBounds(715, 260, 150, 35);
        add(Product);

        String course[] = {"Galaxy S24 Ultra","Galaxy Z Flip5","Galaxy Watch6",
                "Galaxy Tab S9","Galaxy Book3","Galaxy Buds2 Pro","Accessories"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setBounds(840,260,200, 35);
        add(c1);

        JLabel PhnNo = new JLabel("PHONE");
        PhnNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        PhnNo.setBounds(715, 320, 150, 35);
        add(PhnNo);

        textField_1 = new JTextField();
        textField_1.setBounds(840, 320, 200, 35);
        add(textField_1);

        JLabel EmailID = new JLabel("EMAIL");
        EmailID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        EmailID.setBounds(715, 380, 150, 35);
        add(EmailID);

        textField_2 = new JTextField();
        textField_2.setBounds(840, 380, 200, 35);
        add(textField_2);

        JLabel Address = new JLabel("ADDRESS");
        Address.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Address.setBounds(715, 440, 150, 35);
        add(Address);

        textField_3 = new JTextField();
        textField_3.setBounds(840, 440, 200, 100);
        add(textField_3);

        SbtRqt = new JButton("SUBMIT REQUEST");
        SbtRqt.setBounds(910, 610, 150, 45);
        SbtRqt.setBackground(Color.BLACK);
        SbtRqt.setForeground(Color.WHITE);
        SbtRqt.addActionListener(this);
        add(SbtRqt);

        Cancel = new JButton("CANCEL");
        Cancel.setBounds(670, 610, 150, 45);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newComplaint.jpg"));
        Image i1scaled = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(280, 230, 300, 300);
        add(image1);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == SbtRqt) {
            String name = textField.getText();
            String phone = textField_1.getText();
            String email = textField_2.getText();
            String address = textField_3.getText();
            String s6 = (String) c1.getSelectedItem();

            try {
                conn c = new conn();
                ColumnCount obj = new ColumnCount();
                ResultSet j = c.s.executeQuery("SELECT COUNT(*) FROM custcomp;");
                j.next();
                int i = j.getInt(1);

                System.out.println(i+1);
                JOptionPane.showMessageDialog(null, "Token Number - "+(i+1));
                String str = "insert into custcomp values( '" + name + "', '"+ address+ "','" + phone + "'," +
                        "'" + email + "','" + s6+"','"+ "Product Collected"+"','"+(i+1)+"')";
                c.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "Details Added");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel){
            setVisible(false);
            new CustomerDashboard();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}