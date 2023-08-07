/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener
{
    JTable table;
    JTextField searchid;
    JButton find, print, update, back;
    ViewEmployee()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        
        JLabel head = new JLabel(" Employees List ");
        head.setBounds(320,10,500,50);
        head.setFont(new Font("serif", Font.BOLD,35));
        head.setForeground(mycolor);
        add(head);
        
        JLabel search = new JLabel("Search by Employee id: ");
        search.setBounds(20, 80,150,20);
        add(search);
        
        searchid =new JTextField();
        searchid.setBounds(175, 80, 100, 25);
        add(searchid);
        
        find = new JButton(" Search ");
        find.setBounds(280,80,100,23);
        find.setForeground(Color.WHITE);
        find.addActionListener(this);
        find.setBackground(mycolor);
        add(find);
        
        print = new JButton(" Print ");
        print.setBounds(610,80,100,23);
        print.setForeground(Color.WHITE);
        print.setBackground(mycolor);
        print.addActionListener(this);
        add(print);
        
        update = new JButton(" Update ");
        update.setBounds(715,80,100,23);
        update.setForeground(Color.WHITE);
        update.setBackground(mycolor);
        update.addActionListener(this);
        add(update);
        
        back = new JButton(" Back ");
        back.setBounds(820,80,100,23);
        back.setForeground(Color.WHITE);
        back.setBackground(mycolor);
        back.addActionListener(this);
        add(back);
        
        
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(20,120,900,550);
        add(jsp);
        
        //getContentPane().setBackground(Color.WHITE);
        setSize(950,750);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==find)
        {
            String eid= searchid.getText();
            String query ="select * from employee where id = '"+eid+"'";
            try{
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e){
                System.out.println(e);
            }
                
        }
        else if(ae.getSource()==print)
        {
            try{
                table.print();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new UpdateEmployee(searchid.getText()).setVisible(true);
        }
        else
        {
            setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new ViewEmployee();
    }
}
