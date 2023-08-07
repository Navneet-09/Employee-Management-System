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

public class DeleteEmployee extends JFrame implements ActionListener
{
    
    JTextField searchid;
    JButton find;
    JLabel lblname, lblphone, lblemail;
    JButton submit, back;
    DeleteEmployee()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel head = new JLabel(" Delete Employee ");
        head.setBounds(205,20,500,50);
        head.setFont(new Font("serif", Font.BOLD,35));
        head.setForeground(mycolor);
        add(head);
        
        JLabel head1 = new JLabel("_____________________________________________________________________________________________________________________________________________");
        head1.setBounds(0,40,900,50);
        add(head1);
        
        
        JLabel lempid = new JLabel("Employee id: ");
        lempid.setBounds(50,100,150,35);
        lempid.setFont(new Font("serif", Font.PLAIN,20));
        add(lempid);
        
        searchid =new JTextField();
        searchid.setBounds(205, 103, 100, 25);
        add(searchid);
        
        find = new JButton(" Search ");
        find.setBounds(310,103,100,23);
        find.setForeground(Color.WHITE);
        find.addActionListener(this);
        find.setBackground(mycolor);
        add(find);
        
        JLabel lname = new JLabel("Name: ");
        lname.setBounds(50,150,150,35);
        lname.setFont(new Font("serif", Font.PLAIN,20));
        add(lname);
        
        lblname = new JLabel();
        lblname.setBounds(205,150,150,35);
        lblname.setFont(new Font("serif", Font.PLAIN,20));
        add(lblname);
        
        JLabel lphone = new JLabel("Phone : ");
        lphone.setBounds(50,200,150,35);
        lphone.setFont(new Font("serif", Font.PLAIN,20));
        add(lphone);
        
        lblphone = new JLabel();
        lblphone.setBounds(205,200,150,35);
        lblphone.setFont(new Font("serif", Font.PLAIN,20));
        add(lblphone);
        
        JLabel lemail = new JLabel("Email: ");
        lemail.setBounds(50,250,150,35);
        lemail.setFont(new Font("serif", Font.PLAIN,20));
        add(lemail);
        
        lblemail = new JLabel();
        lblemail.setBounds(205,250,200,35);
        lblemail.setFont(new Font("serif", Font.PLAIN,20));
        add(lblemail);
        
        submit = new JButton("Delete");
        submit.setBounds(220,330,100,30);
        submit.setFont(new Font("serif", Font.BOLD, 18));
        submit.setBackground(mycolor);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("Back");
        back.setBounds(360,330,100,30);
        back.setFont(new Font("serif", Font.BOLD, 18));
        back.setBackground(mycolor);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
                
        //getContentPane().setBackground(Color.WHITE);
        setLocation(370,80);
        setSize(700,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==find)
        {
            try
            {
                Conn c = new Conn();
                String query ="select * from employee where id ='"+searchid.getText()+"'";
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next())
                {
                    lblname.setText(rs.getString("name"));
                    lblphone.setText(rs.getString("phone"));
                    lblemail.setText(rs.getString("email"));
                }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==submit)
        {
            try
            {
                Conn c = new Conn();
                String query ="delete from employee where id ='"+searchid.getText()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Deleted Successfully.");
                setVisible(false);
                new Home().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back)
        {
            setVisible(false);
            new Home().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new DeleteEmployee();
    }
    
}
