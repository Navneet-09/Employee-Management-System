/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Navneet
 */
public class HomeProj extends JFrame implements ActionListener
{
    JTextField Pid, Pname;
    JButton ad, update, delete, exit, go;
    JTable table;
    HomeProj()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel text = new JLabel(" Manage Project ");
        text.setBounds(250,0,710,80);
        text.setFont(new Font("serif", Font.PLAIN, 35));
        text.setForeground(mycolor);
        add(text);
        
        JLabel t = new JLabel("__________________________________________________________________________________________________________");
        t.setBounds(0,10,820,80);
        t.setFont(new Font("serif", Font.PLAIN, 35));
        add(t);
        
        JLabel text2 = new JLabel(" Project Detail ");
        text2.setBounds(70,70,250,80);
        text2.setFont(new Font("serif", Font.ITALIC, 25));
        text2.setForeground(mycolor);
        add(text2);
        
        JLabel search = new JLabel(" ID: ");
        search.setBounds(30, 150,50,20);
        add(search);
        
        Pid =new JTextField();
        Pid.setBounds(30, 170, 50, 25);
        add(Pid);
        
        go = new JButton(" GO ");
        go.setBounds(70,170,60,25);
        go.setFont(new Font("serif", Font.BOLD, 10));
        go.setBackground(mycolor);
        go.setForeground(Color.WHITE);
        go.addActionListener(this);
        add(go);
        
        
        JLabel search1 = new JLabel(" Project Name: ");
        search1.setBounds(185, 150,150,20);
        add(search1);
        
        Pname =new JTextField();
        Pname.setBounds(185, 170, 190, 25);
        add(Pname);
        
        
        ad = new JButton(" Add ");
        ad.setBounds(30,240,100,25);
        ad.setFont(new Font("serif", Font.BOLD, 16));
        ad.setBackground(mycolor);
        ad.setForeground(Color.WHITE);
        ad.addActionListener(this);
        add(ad);
        
        update = new JButton(" Update ");
        update.setBounds(150,240,100,25);
        update.setFont(new Font("serif", Font.BOLD, 16));
        update.setBackground(mycolor);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        
        delete = new JButton(" Delete ");
        delete.setBounds(275,240,100,25);
        delete.setFont(new Font("serif", Font.BOLD, 16));
        delete.setBackground(mycolor);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        exit = new JButton(" <<Back ");
        exit.setBounds(30,300,100,30);
        exit.setFont(new Font("serif", Font.BOLD, 16));
        exit.setBackground(mycolor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        JLabel text1 = new JLabel(" Projects List ");
        text1.setBounds(490,70,180,80);
        text1.setFont(new Font("serif", Font.ITALIC, 25));
        text1.setForeground(mycolor);
        add(text1);
        
        table = new JTable();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select P_Id as Project_ID, P_Name as Project_Name from project");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(430,150,330,140);
        add(jsp);
        
        //getContentPane().setBackground(Color.WHITE);
        setSize(790,450);
        setLocation(370,80);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        // Back Button
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Manage().setVisible(true);
        }
        
        // Add Button
        else if(ae.getSource()==ad)
        {
            String id = Pid.getText();
            String name = Pname.getText();
            try{
                Conn c= new Conn();
                //String sql = "select *from project where P_Id = '"+Pid+"'";
                //ResultSet rs3 = c.s.executeQuery(sql);
                /*if(rs3.next())
                {
                    JOptionPane.showMessageDialog(null, "Project with same ID already exist!!");
                    Pid.setText("");
                    Pname.setText("");
                }
                else{
                    
                }*/
                
                String query ="insert into project values('"+id+"', '"+name+"')";
                String query1="select P_Id as Project_ID, P_Name as Project_Name from project";
                c.s.executeUpdate(query);
                ResultSet rs= c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null, "Project details added successfully");
                Pid.setText("");
                Pname.setText("");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        //Update Button
        else if(ae.getSource()==update)
        {
            String name = Pname.getText();
            String id =Pid.getText();
                       
            try{
                Conn c= new Conn();
                String query ="update project set P_Name ='"+name+"' where P_Id = '"+id+"'";
                String query1="select P_Id as Project_ID, P_Name as Project_Name from project";
                c.s.executeUpdate(query);
                ResultSet rs= c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null, "Project details Updated successfully");
                Pid.setText("");
                Pname.setText("");
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
        }
        
        //Delete Button
        else if(ae.getSource()==delete)
        {
            String id = Pid.getText();
            String name = Pname.getText();
            try{
                Conn c= new Conn();
                String query ="delete from project where P_Id ='"+Pid.getText()+"'";
                String query1="select P_Id as Project_ID, P_Name as Project_Name from project";
                c.s.executeUpdate(query);
                ResultSet rs= c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(null, "Project details deleteded successfully");
                Pid.setText("");
                Pname.setText("");
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        
        //Search Button
        else if(ae.getSource()==go)
        {
            String id= Pid.getText();
            String query ="select * from project where P_Id = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                ResultSet rs1= c.s.executeQuery(query);
                while(rs1.next())
                {
                    Pname.setText(rs1.getString("P_Name"));
                }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {
        new HomeProj();
    }
    
}
