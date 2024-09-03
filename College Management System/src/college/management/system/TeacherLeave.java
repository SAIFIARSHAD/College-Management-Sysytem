package college.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choiceEmpId, choTime;
    JDateChooser selDate;
    JButton submit, cancel;

    TeacherLeave() {

        getContentPane().setBackground(new Color(58, 246, 246));


        JLabel heading = new JLabel("Apply Leave (Faculty)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);


        JLabel empId = new JLabel("Search by Emp ID Number");
        empId.setBounds(40, 100, 300, 20);
        empId.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(empId);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(40, 130, 200, 20);
        add(choiceEmpId);

        try {
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while (resultSet.next()) {
                choiceEmpId.add(resultSet.getString("empID"));

            }
            JLabel lbldate = new JLabel("Date");
            lbldate.setBounds(40, 180, 200, 20);
            lbldate.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(lbldate);

            selDate = new JDateChooser();
            selDate.setBounds(40, 210, 200, 20);
            add(selDate);

            JLabel time = new JLabel("Time Duration");
            time.setBounds(40, 250, 200, 20);
            time.setFont(new Font("Tahoma", Font.PLAIN, 20));
            add(time);

            choTime = new Choice();
            choTime.setBounds(40, 290, 200, 20);
            choTime.add("Half Day");
            choTime.add("Full Day");
            add(choTime);

            submit = new JButton("Submit");
            submit.setBounds(60, 350, 100, 25);
            submit.setBackground(Color.BLACK);
            submit.setForeground(Color.WHITE);
            submit.addActionListener(this);
            add(submit);

            cancel = new JButton("Cancel");
            cancel.setBounds(230, 350, 100, 25);
            cancel.setBackground(Color.BLACK);
            cancel.setForeground(Color.WHITE);
            cancel.addActionListener(this);
            add(cancel);


        } catch (Exception e) {
            e.printStackTrace();
            ;
        }


        setSize(500, 550);
        setLocation(550, 100);

        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String EmpId = choiceEmpId.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = choTime.getSelectedItem();

            String Q = "insert into teacherleave values('" + EmpId + "','" + date + "','" + time + "')";

            try {
                Conn c = new Conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new TeacherLeave();
    }
}
