package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.jar.JarFile;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice choiceRollNo;
    JTable table;
    JButton search,cancel,print;

    StudentLeaveDetails(){
        getContentPane().setBackground(new Color(12, 238, 197));

        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(180,20,150,20);
        add(choiceRollNo);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from student");
            while(resultSet.next()){
                choiceRollNo.add(resultSet.getString("rollno"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,100,900,600);
        add(scrollPane);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        add(search);

        cancel = new JButton("Cancel");
        cancel.setBounds(120,70,80,20);
        cancel.addActionListener(this);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        add(cancel);

        print = new JButton("Print");
        print.setBounds(220,70,80,20);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        add(print);




        setSize(900,700);
        setLocation(300,30);
        setLayout(null);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String q = "select * from studentleave where rollno ='"+choiceRollNo.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet resultSet = c.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));


            }catch(Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource() == print) {
            try{
                table.print();

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }




    }

    public static void main(String []args){
        new StudentLeaveDetails();
    }
}
