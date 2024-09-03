package college.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddStudent extends JFrame implements ActionListener {

    JTextField textName,textFather,textAddress,textPhone,textEmail,textM10,textM12,textAadharNo;
    JLabel rollNoText;
    JDateChooser cdob;
    JComboBox courseBox,branchBox;
    JButton submit,cancel;
    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddStudent(){

        getContentPane().setBackground(new Color(188, 245, 66));


        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);



        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50,150,100,30);
        name.setFont(new Font("serif",Font.BOLD,20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200,150,200,30);
        textName.setFont(new Font("serif",Font.PLAIN,20));
        add(textName);


        //Farter Name

        JLabel fName = new JLabel("Father Name");
        fName.setBounds(450,150,200,30);
        fName.setFont(new Font("serif",Font.BOLD,20));
        add(fName);

        textFather = new JTextField();
        textFather.setBounds(600,150,200,30);
        textFather.setFont(new Font("serif",Font.PLAIN,20));
        add(textFather);



        //Employee ID
        JLabel rollNo = new JLabel("Roll Number");
        rollNo.setBounds(50,200,200,30);
        rollNo.setFont(new Font("serif",Font.BOLD,20));
        add(rollNo);

        rollNoText = new JLabel("24003200"+f4);
        rollNoText.setBounds(200,200,200,30);
        rollNoText.setFont(new Font("serif",Font.PLAIN,20));
        add(rollNoText);

        //Date of Birth

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(450,200,200,30);
        dob.setFont(new Font("serif",Font.BOLD,20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600,200,200,30);
        cdob.setFont(new Font("serif",Font.PLAIN,20));
        add(cdob);


        // Address

        JLabel address = new JLabel("Address");
        address.setBounds(50,250,200,30);
        address.setFont(new Font("serif",Font.BOLD,20));
        add(address);

        textAddress = new JTextField();
        textAddress.setBounds(200,250,200,30);
        textAddress.setFont(new Font("serif",Font.PLAIN,20));
        add(textAddress);

        //Phone Number

        JLabel phone = new JLabel("Phone");
        phone.setBounds(450,250,200,30);
        phone.setFont(new Font("serif",Font.BOLD,20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600,250,200,30);
        textPhone.setFont(new Font("serif",Font.PLAIN,20));
        add(textPhone);

        // Email

        JLabel email = new JLabel("Email");
        email.setBounds(50,300,200,30);
        email.setFont(new Font("serif",Font.BOLD,20));
        add(email);

        textEmail = new JTextField();
        textEmail.setBounds(200,300,200,30);
        textEmail.setFont(new Font("serif",Font.PLAIN,20));
        add(textEmail);

        //Class X%

        JLabel M10 = new JLabel("Class X (%)");
        M10.setBounds(450,300,200,30);
        M10.setFont(new Font("serif",Font.BOLD,20));
        add(M10);

        textM10 = new JTextField();
        textM10.setBounds(600,300,200,30);
        textM10.setFont(new Font("serif",Font.PLAIN,20));
        add(textM10);

        //Class XII%

        JLabel M12 = new JLabel("Class XII (%)");
        M12.setBounds(50,350,200,30);
        M12.setFont(new Font("serif",Font.BOLD,20));
        add(M12);

        textM12 = new JTextField();
        textM12.setBounds(200,350,200,30);
        textM12.setFont(new Font("serif",Font.PLAIN,20));
        add(textM12);

        //Aadhar Number

        JLabel AadharNo = new JLabel("Aadhar Number");
        AadharNo.setBounds(450,350,200,30);
        AadharNo.setFont(new Font("serif",Font.BOLD,20));
        add(AadharNo);

        textAadharNo = new JTextField();
        textAadharNo.setBounds(600,350,200,30);
        textAadharNo.setFont(new Font("serif",Font.PLAIN,20));
        add(textAadharNo);

        //Course

        JLabel course = new JLabel("Course");
        course.setBounds(50,400,200,30);
        course.setFont(new Font("serif",Font.BOLD,20));
        add(course);

        String Course[] = {"Select","BA","BBA","BCA","B.Tech","BSC","MA","MBA","MCA","MSC"};
        courseBox = new JComboBox(Course);
        courseBox.setBounds(200,400,200,30);
        courseBox.setFont(new Font("serif",Font.PLAIN,20));
        courseBox.setBackground(Color.WHITE);
        add(courseBox);

        // Branch

        JLabel Branch = new JLabel("Branch");
        Branch.setBounds(450,400,200,30);
        Branch.setFont(new Font("serif",Font.BOLD,20));
        add(Branch);

        String branch[] = {"Select","Computer Science","Computer Application","Electronics","Mechanical","Civil","IT"};
        branchBox = new JComboBox(branch);
        branchBox.setBounds(600,400,200,30);
        branchBox.setFont(new Font("serif",Font.PLAIN,20));
        branchBox.setBackground(Color.WHITE);
        add(branchBox);

        //Submit Button

        submit = new JButton("Submit");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("serif",Font.BOLD,20));
        submit.addActionListener(this);
        add(submit);

        // Cancel Button

        cancel = new JButton("Cancel");
        cancel.setBounds(500,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("serif",Font.BOLD,20));
        cancel.addActionListener(this);
        add(cancel);




        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String name = textName.getText();
            String fname = textFather.getText();
            String rollid = rollNoText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAddress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String aadhar = textAadharNo.getText();
            String course = (String) courseBox.getSelectedItem();
            String branch = (String) branchBox.getSelectedItem();
            try{
                String q = "Insert into student values ('"+name+"', '"+fname+"', '"+rollid+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
                Conn c = new Conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Inserted");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }

    }

    public static void main(String []args){
        new AddStudent();
    }
}
