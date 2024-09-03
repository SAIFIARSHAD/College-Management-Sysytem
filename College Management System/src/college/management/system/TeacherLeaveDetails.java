package college.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice choiceEmpId;
    JTable table;
    JButton search,cancel,print;

    TeacherLeaveDetails(){
        getContentPane().setBackground(new Color(219, 255, 51));

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180,20,150,20);
        add(choiceEmpId);

        try{
            Conn c = new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacher");
            while(resultSet.next()){
                choiceEmpId.add(resultSet.getString("empid"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{
            Conn c= new Conn();
            ResultSet resultSet = c.statement.executeQuery("select * from teacherleave");
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
            String q = "select * from teacherleave where EmpID ='"+choiceEmpId.getSelectedItem()+"'";
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
        new TeacherLeaveDetails();


    }

}
