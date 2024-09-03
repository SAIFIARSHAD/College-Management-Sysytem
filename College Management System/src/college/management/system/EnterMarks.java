package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice choicerollno;
    JComboBox comboBox;
    JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;
    JButton submit,cancel;

    EnterMarks(){

        getContentPane().setBackground(new Color(226,135,67));

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500,40,400,300);
        add(img);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,10,300,20);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel rollno = new JLabel("Select Roll Number");
        rollno.setBounds(50,80,150,20);
        add(rollno);

        choicerollno = new Choice();
        choicerollno.setBounds(220,80,150,20);
        add(choicerollno);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while(resultSet.next()){
            choicerollno.add(resultSet.getString("rollno"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel sem = new JLabel("Select Semester");
        sem.setBounds(50,120,150,20);
        add(sem);

        String semester[] = {"1st Semester","2st Semester","3st Semester","4st Semester","5st Semester","6st Semester","7st Semester","8st Semester"};
        comboBox = new JComboBox(semester);
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(220,120,150,20);
        add(comboBox);

        JLabel entersub = new JLabel("Enter Subject");
        entersub.setBounds(80,150,200,40);
        entersub.setFont(new Font("Tahoma",Font.BOLD,20));
        add(entersub);


        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(310,150,200,40);
        entermarks.setFont(new Font("Tahoma",Font.BOLD,20));
        add(entermarks);

        sub1 = new JTextField();
        sub1.setBounds(50,190,200,25);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50,230,200,25);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50,270,200,25);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50,310,200,25);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50,350,200,25);
        add(sub5);





        mrk1 = new JTextField();
        mrk1.setBounds(280,190,200,25);
        add(mrk1);

        mrk2 = new JTextField();
        mrk2.setBounds(280,230,200,25);
        add(mrk2);

        mrk3 = new JTextField();
        mrk3.setBounds(280,270,200,25);
        add(mrk3);

        mrk4 = new JTextField();
        mrk4.setBounds(280,310,200,25);
        add(mrk4);

        mrk5 = new JTextField();
        mrk5.setBounds(280,350,200,25);
        add(mrk5);


        submit = new JButton("Submit");
        submit.setBounds(100,420,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(300,420,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);






        setSize(950,520);
        setLocation(250,30);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            try{
                Conn c = new Conn();
                String Q1 = "insert into subject values('"+choicerollno.getSelectedItem()+"', '"+comboBox.getSelectedItem()+"', '"+sub1.getText()+"', '"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
                String Q2 = "insert into marks values('"+choicerollno.getSelectedItem()+"', '"+comboBox.getSelectedItem()+"', '"+mrk1.getText()+"', '"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";


                c.statement.executeUpdate(Q1);
                c.statement.executeUpdate(Q2);

                JOptionPane.showMessageDialog(null,"Marks Inserted Sucessfully");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }



    }

    public static void main(String args[]){
        new EnterMarks();
    }
}
