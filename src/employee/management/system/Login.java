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
    JButton log;
    Login()
    {
        setLayout(null);
        setTitle("Admin Login");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        // username
        JLabel text1 = new JLabel(" Username");
        text1.setFont(new Font("Raleway", Font.BOLD, 16));
        text1.setBounds(40, 40, 100, 30);
        add(text1);
        
        user = new JTextField();
        user.setBounds(150,43,150,25);
        add(user);
        
        
        //password
        JLabel text2 = new JLabel(" Password ");
        text2.setFont(new Font("Raleway", Font.BOLD, 16));
        text2.setBounds(40, 90, 100, 30);
        add(text2);
        
        pass = new JPasswordField();
        pass.setBounds(150,93,150,25);
        add(pass);
        
        
        log = new JButton(" Login ");
        log.setBounds(110, 160, 150, 30);
        log.setBackground(mycolor);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        add(log);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adminlogo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200, 200);
        add(image);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(600,300);
        setLocation(300,20);
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
                    new Home().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    
                }
                
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }
    public static void main(String args[])
    {
        new Login();
    }
}
