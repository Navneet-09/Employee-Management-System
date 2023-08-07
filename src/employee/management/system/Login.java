/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JTextField user;
    JPasswordField pass;
    JButton log, res, exit;
    Login()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel heading = new JLabel(" Admin Login ");
        heading.setFont(new Font("Raleway", Font.ITALIC, 29));
        heading.setBounds(250, 30, 250, 34);
        add(heading);
        
        // username
        JLabel text1 = new JLabel(" Username");
        text1.setFont(new Font("Raleway", Font.BOLD, 16));
        text1.setBounds(150, 100, 100, 30);
        add(text1);
        
        user = new JTextField();
        user.setBounds(260,103,250,25);
        add(user);
        
        
        //password
        JLabel text2 = new JLabel(" Password ");
        text2.setFont(new Font("Raleway", Font.BOLD, 16));
        text2.setBounds(150, 150, 100, 30);
        add(text2);
        
        pass = new JPasswordField();
        pass.setBounds(260,153,250,25);
        add(pass);
        
        
        log = new JButton(" Login ");
        log.setBounds(200, 220, 150, 30);
        log.setBackground(mycolor);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        add(log);
        
        res = new JButton(" Reset ");
        res.setBounds(380, 220, 150, 30);
        res.setBackground(mycolor);
        res.setForeground(Color.WHITE);
        res.addActionListener(this);
        add(res);
        
        
        exit = new JButton(" Exit ");
        exit.setBounds(260,270,200,30);
        exit.setFont(new Font("serif", Font.BOLD, 16));
        exit.setBackground(mycolor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        //ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adminlogo.jpg"));
        //Image i2 = i1.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
        //ImageIcon i3 = new ImageIcon(i2);
        //JLabel image = new JLabel(i3);
        //image.setBounds(350,0,200, 200);
        //add(image);
        
        //getContentPane().setBackground(Color.WHITE);
        setSize(680,450);
        setLocation(370,80);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==log)
        {
            try
            {
                String username = user.getText();
                String password = pass.getText();
                Conn c = new Conn();
                String query ="select * from login where username ='"+username+"' and password = '"+password+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Manage().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password!! try again");
                    
                }
                
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()== res)
        {
            user.setText("");
            pass.setText("");
        }
        else if(ae.getSource()==exit)
        {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
