package college.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class StudentLeave extends JFrame implements ActionListener {
    Choice choiceRollNo,choTime;
    JDateChooser selDate;
    JButton submit,cancel;

    StudentLeave(){

        getContentPane().setBackground(new Color(214, 242, 90));


        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);


        JLabel RollNoSE = new JLabel("Search by Roll Number");
        RollNoSE.setBounds(40,100,300,20);
        RollNoSE.setFont(new Font("Tahoma",Font.BOLD,18));
        add(RollNoSE);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(40,130,200,20);
        add(choiceRollNo);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                choiceRollNo.add(resultSet.getString("rollno"));

            }
            JLabel lbldate = new JLabel("Date");
            lbldate.setBounds(40,180,200,20);
            lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(lbldate);

            selDate = new JDateChooser();
            selDate.setBounds(40,210,200,20);
            add(selDate);

            JLabel time = new JLabel("Time Duration");
            time.setBounds(40,250,200,20);
            time.setFont(new Font("Tahoma",Font.PLAIN,20));
            add(time);

            choTime = new Choice();
            choTime.setBounds(40,290,200,20);
            choTime.add("Half Day");
            choTime.add("Full Day");
            add(choTime);

            submit = new JButton("Submit");
            submit.setBounds(60,350,100,25);
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            submit.addActionListener(this);
            add(submit);

            cancel = new JButton("Cancel");
            cancel.setBounds(230,350,100,25);
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            add(cancel);



        }catch(Exception e){
            e.printStackTrace();;
        }










        setSize(500,550);
        setLocation(550,100);

        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String rollno = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = choTime.getSelectedItem();

            String Q = "insert into studentleave values('"+rollno+"','"+date+"','"+time+"')";

            try{
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }

    }

    public static void main(String []args){
        new StudentLeave();
    }
}
