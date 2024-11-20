package CustPortal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AddEmployee extends JFrame implements ActionListener{
    JTextField textField, textField_1, textField_2, textField_3, textField_4, textField_5, textField_6;
    JRadioButton Male, Female;
    JButton Next,Cancel;
    public AddEmployee() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(530, 200, 900, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 31));
        heading.setBounds(640, 165, 442, 35);
        add(heading);

        JLabel name = new JLabel("NAME");
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        name.setBounds(625,240 , 150, 27);
        add(name);

        textField = new JTextField();
        textField.setBounds(790, 240, 190, 30);
        add(textField);

        JLabel age = new JLabel("AGE");
        age.setFont(new Font("Tahoma", Font.PLAIN, 20));
        age.setBounds(625, 310, 150, 27);
        add(age);

        textField_1 = new JTextField();
        textField_1.setBounds(790, 310, 190, 30);
        add(textField_1);

        JLabel Gender = new JLabel("GENDER");
        Gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        Gender.setBounds(625, 380, 150, 27);
        add(Gender);

        Male = new JRadioButton("MALE");
        Male.setBackground(Color.WHITE);
        Male.setBounds(790, 380, 70, 27);
        add(Male);

        JRadioButton Female = new JRadioButton("FEMALE");
        Female.setBackground(Color.WHITE);
        Female.setBounds(870, 380, 100, 27);
        add(Female);

        JLabel phone = new JLabel("PHONE");
        phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        phone.setBounds(625, 450, 150, 27);
        add(phone);

        textField_4 = new JTextField();
        textField_4.setBounds(790, 450, 190, 30);
        add(textField_4);

        JLabel IdProof = new JLabel("ID");
        IdProof.setFont(new Font("Tahoma", Font.PLAIN, 20));
        IdProof.setBounds(625, 520, 150, 27);
        add(IdProof);

        textField_5 = new JTextField();
        textField_5.setBounds(790, 520, 190, 30);
        add(textField_5);

        JLabel email = new JLabel("EMAIL");
        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(625, 590, 150, 27);
        add(email);

        textField_6 = new JTextField();
        textField_6.setBounds(790, 590, 190, 30);
        add(textField_6);

        Next = new JButton("SAVE");
        Next.setBounds(860, 670, 150, 45);
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.addActionListener(this);
        add(Next);

        Cancel = new JButton("CANCEL");
        Cancel.setBounds(620, 670, 150, 45);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newEmployee.png"));
        Image i1scaled = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i1new = new ImageIcon(i1scaled);
        JLabel image1 = new JLabel(i1new);
        image1.setBounds(280, 300, 300, 300);
        add(image1);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == Next) {
            String name = textField.getText();
            String age = textField_1.getText();
            String phone = textField_4.getText();
            String ID = textField_5.getText();
            String email = textField_6.getText();
            String gender = null;
            if (Male.isSelected()) {
                gender = "male";
            } else if (Female.isSelected()) {
                gender = "female";
            }
            try {
                conn c = new conn();
                String str = "INSERT INTO empdetails values( '" + name + "', '" + age + "', '" + gender + "'," +
                        "'" + phone + "','" + ID + "', '" + email + "')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Employee Added");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == Cancel){
            setVisible(false);
            new AdminDashboard();
        }}
    public static void main(String[] args) {
        new AddEmployee();
    }}