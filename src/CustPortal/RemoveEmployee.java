package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
public class RemoveEmployee extends JFrame implements ActionListener {
    JButton getDetails, goBack;
    JTextField tfEmpId;
    String id;
    RemoveEmployee(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0, 940, 470);
        setVisible(true);

        JLabel heading = new JLabel("Remove Employee");
        heading.setFont(new Font("Tahoma", Font.BOLD, 34));
        heading.setBounds(725, 320, 700,40);
        add(heading);

        JLabel lblEmpId = new JLabel("Enter Employee ID:");
        lblEmpId.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblEmpId.setBounds(700, 410, 200,30);
        add(lblEmpId);

        tfEmpId = new JTextField();
        tfEmpId.setBounds(950, 410, 110, 30);
        add(tfEmpId);

        getDetails = new JButton("Remove Employee" );
        getDetails.setBounds(910, 510, 200, 35);
        getDetails.setFont(new Font("times new roman", Font.PLAIN, 21));
        getDetails.addActionListener(this);
        add(getDetails);

        goBack = new JButton("Cancel");
        goBack.setBounds(670, 510, 200, 35);
        goBack.setFont(new Font("times new roman", Font.PLAIN, 21));
        goBack.addActionListener(this);
        add(goBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/removeEmployee.jpg"));
        Image i1scaled = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(280, 300, 300, 300);
        add(image1);
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == getDetails){
            String ID = tfEmpId.getText();
            String name="";
            String age="";
            String gender="";
            String phone="";
            String email="";
            try{
                conn c = new conn();
                ResultSet rs1 = c.s.executeQuery("Select * from empdetails where ID = '"+ID+"';");
                while(rs1.next()){
                    name = rs1.getString((1));
                    System.out.println(name);
                    age=rs1.getString((2));
                    gender=rs1.getString((3));
                    phone=rs1.getString((4));
                    ID=rs1.getString((5));
                    email=rs1.getString((6));
                }
                JOptionPane.showMessageDialog(null,  "Name - "+name+
                                                                            "\n age -"+age+
                                                                            "\n gender - "+gender+
                                                                            "\n phone -"+phone+
                                                                            "\n ID - "+ID+
                                                                            "\n email -"+email);
                c.s.executeUpdate("delete from empdetails where ID = '"+ID+"';");
                JOptionPane.showMessageDialog(null, "Employee Details have been deleted");
                if(rs1!=null){
                    rs1.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource() == goBack) {
            setVisible(false);
            new AdminDashboard();
        }
    }
    public static void main(String[] args) {
        new RemoveEmployee();
    }
}
