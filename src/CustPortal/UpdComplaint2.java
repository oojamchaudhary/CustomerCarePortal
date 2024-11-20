package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class UpdComplaint2 extends JFrame implements ActionListener {
    JButton update,goBack;
    JComboBox availaiblecombo;
    JTextField TokenNo;
    UpdComplaint2(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0, 940, 470);
        setVisible(true);

        JLabel heading = new JLabel("Update Existing Complaint Status");
        heading.setFont(new Font("Tahoma", Font.BOLD, 34));
        heading.setBounds(515, 160, 700,40);
        add(heading);

        JLabel lblTokenNo = new JLabel("Enter Token No.:");
        lblTokenNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTokenNo.setBounds(620, 265, 170,40);
        add(lblTokenNo);

        TokenNo = new JTextField("");  //Take No given from SQL database
        TokenNo.setBounds(850, 265, 110, 40);
        add(TokenNo);

        JLabel lblstatus = new JLabel("Current Status:");
        lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblstatus.setBounds(620, 375, 170, 40);
        add(lblstatus);

        String availableOptions[] = {"Product Collected", "Product Dispatched-In Transit", "Product Delivered"};
        availaiblecombo = new JComboBox(availableOptions);
        availaiblecombo.setFont(new Font("serif", Font.PLAIN, 22));
        availaiblecombo.setBounds(850, 375, 350, 40);
        availaiblecombo.setBackground(Color.WHITE);
        add(availaiblecombo);

        update = new JButton("Update Status" );
        update.setBounds(810, 520, 200, 35);
        update.setFont(new Font("times new roman", Font.PLAIN, 21));
        update.addActionListener(this);
        add(update);

        goBack = new JButton("Cancel");
        goBack.setBounds(570, 520, 200, 35);
        goBack.setFont(new Font("times new roman", Font.PLAIN, 21));
        goBack.addActionListener(this);
        add(goBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/updateStatus.jpg"));
        Image i1scaled = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(220, 220, 300, 300);
        add(image1);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == update){
            try{
                String tok = TokenNo.getText();
                String ava = (String) availaiblecombo.getSelectedItem();
                conn c = new conn();
                c.s.executeUpdate("update custcomp set status = '"+ava+"' where tokenno ='"+tok+"';");
                JOptionPane.showMessageDialog(null, "Changes Established" );
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == goBack) {
            setVisible(false);
            new EmployeeDashboard();
        }
    }
    public static void main(String[] args) {
        new UpdComplaint2();
    }
}
