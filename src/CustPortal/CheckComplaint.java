package CustPortal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
public class CheckComplaint extends JFrame implements ActionListener {
    JButton fetch, goBack;
    JTextField tfTokenNo;
    ResultSet rs = null;
    CheckComplaint(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(0,0, 940, 470);
        setVisible(true);

        JLabel heading = new JLabel("Check your Complaint Status");
        heading.setFont(new Font("Tahoma", Font.BOLD, 34));
        heading.setBounds(615, 320, 700,40);
        add(heading);

        JLabel lblTokenNo = new JLabel("Enter Token No.:");
        lblTokenNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblTokenNo.setBounds(720, 410, 170,30);
        add(lblTokenNo);

        tfTokenNo = new JTextField();
        tfTokenNo.setBounds(950, 410, 110, 30);
        add(tfTokenNo);

        fetch = new JButton("Fetch details");
        fetch.setBounds(910, 510, 200, 35);
        fetch.setFont(new Font("times new roman", Font.PLAIN, 21));
        fetch.addActionListener(this);
        add(fetch);

        goBack = new JButton("Cancel");
        goBack.setBounds(670, 510, 200, 35);
        goBack.setFont(new Font("times new roman", Font.PLAIN, 21));
        goBack.addActionListener(this);
        add(goBack);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/chechStatus.png"));
        Image i1scaled = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(180, 300, 400, 300);
        add(image1);
    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == fetch){
            String tok = tfTokenNo.getText();
            String ret = "";
            int i =1;
            String name="";
            String address="";
            String phone="";
            String email="";
            String type="";
            String status="";
            String tokenno="";
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("Select * from custcomp where tokenno = "+tok+";");
                while(rs.next()){
                    name = rs.getString((1));
                    address=rs.getString((2));
                    phone=rs.getString((3));
                    email=rs.getString((4));
                    type=rs.getString((5));
                    status=rs.getString((6));
                    tokenno=rs.getString((7));
                }
                JOptionPane.showMessageDialog(null, "Product Type - "+type+"\n Status - "+status );
                System.out.println(ret);
                if(rs!=null){
                    rs.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if (ae.getSource() == goBack){
            setVisible(false);
            new CustomerDashboard();
        }
    }
    public static void main(String[] args) {
        new CheckComplaint();
    }
}
