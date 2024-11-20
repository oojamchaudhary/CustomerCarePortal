package CustPortal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PendingComplaints extends JFrame implements ActionListener {
    JButton done;
// This is check pending complaints for Employee login
    PendingComplaints(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0, 940, 470);
        setVisible(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);
        setBounds(0, 0, 1550, 1000);
        setVisible(true);

        JLabel heading = new JLabel("Pending Complaint Token Numbers:-");
        heading.setFont(new Font("Tahoma", Font.BOLD, 34));
        heading.setBounds(570, 90, 700,40);
        add(heading);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);



        /*JLabel heading = new JLabel("Remove Employee");
        heading.setFont(new Font("Tahoma", Font.BOLD, 34));
        heading.setBounds(610, 190, 700,40);
        add(heading);*/


        JLabel Tokens = new JLabel("Tokens:");
        Tokens.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Tokens.setBounds(580, 280, 210,30);
        add(Tokens);

        try{
            String tok="";
            conn c = new conn();
            ResultSet rs1 = c.s.executeQuery("Select tokenno from custcomp where status = \"Product Collected\"; ");
            int i =0;
            while(rs1.next()){
              tok = (rs1.getString(1)+",");
                JLabel EmpName = new JLabel(""+tok); // Give your input text for Employee Name in the brackets
                EmpName.setFont(new Font("Tahoma", Font.PLAIN, 22));
                EmpName.setBounds((750 + 35*i) , 280, 210,30);
                add(EmpName);
                System.out.println(tok);
                i++;

            }



            if(rs1!=null){
                rs1.close();
            }



        }catch(Exception e){
            e.printStackTrace();
        }

        /*Name.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Name.setBounds(580, 330, 210,30);
        add(Name);

        JLabel Mob = new JLabel("Mobile No.:");
        Mob.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Mob.setBounds(580, 380, 210,30);
        add(Mob);

        JLabel Mail = new JLabel("Email Address:");
        Mail.setFont(new Font("Tahoma", Font.PLAIN, 22));
        Mail.setBounds(580, 430, 210,30);
        add(Mail);*/




        /*//<1>
        JLabel EmpID = new JLabel(""+id1);   // Give your input text for Employee ID in the brackets
        EmpID.setFont(new Font("Tahoma", Font.PLAIN, 22));
        EmpID.setBounds(850, 280, 210,30);
        add(EmpID);*/





        done = new JButton("Done");
        done.setBounds(700, 500, 200, 35);
        done.setFont(new Font("times new roman", Font.PLAIN, 21));
        done.addActionListener(this);
        add(done);
    }
    public void actionPerformed (ActionEvent ae){
        if (ae.getSource() == done){
            setVisible(false);
            new EmployeeDashboard();
        }
    }
    public static void main(String[] args) {
        new PendingComplaints();
    }
}
