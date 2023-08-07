/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
//import java.util.*;
/**
 *
 * @author Navneet
 */
public class Manage extends JFrame implements ActionListener
{
    JButton emp, depart, proj, exit;
    
    Manage(){
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel text = new JLabel(" Admin Panel ");
        text.setBounds(210,10,700,80);
        text.setFont(new Font("serif", Font.PLAIN, 35));
        text.setForeground(mycolor);
        add(text);
        
        JLabel t = new JLabel("_____________________________________________________");
        t.setBounds(0,20,720,80);
        t.setFont(new Font("serif", Font.PLAIN, 35));
        add(t);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adminhome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30,110,150, 150);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        image.setBorder(border);
        add(image);
        
        JLabel text2 = new JLabel(" Date : " + LocalDate.now());
        text2.setBounds(30,270,400,80);
        text2.setFont(new Font("serif", Font.PLAIN, 14));
        add(text2);
        
        JLabel text1 = new JLabel(" Welcome Admin ");
        text1.setBounds(30,240,400,80);
        text1.setFont(new Font("serif", Font.BOLD, 20));
        add(text1);
        
        emp = new JButton(" Manage Employee ");
        emp.setBounds(320,120,200,30);
        emp.setFont(new Font("serif", Font.BOLD, 16));
        emp.setBackground(mycolor);
        emp.setForeground(Color.WHITE);
        emp.addActionListener(this);
        add(emp);
        
        
        depart = new JButton(" Manage Department ");
        depart.setBounds(320,180,200,30);
        depart.setFont(new Font("serif", Font.BOLD, 16));
        depart.setBackground(mycolor);
        depart.setForeground(Color.WHITE);
        depart.addActionListener(this);
        add(depart);
        
        
        proj = new JButton(" Manage Project ");
        proj.setBounds(320,240,200,30);
        proj.setFont(new Font("serif", Font.BOLD, 16));
        proj.setBackground(mycolor);
        proj.setForeground(Color.WHITE);
        proj.addActionListener(this);
        add(proj);
        
        exit = new JButton(" Exit ");
        exit.setBounds(320,300,200,30);
        exit.setFont(new Font("serif", Font.BOLD, 16));
        exit.setBackground(mycolor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        
        setSize(680,450);
        setLocation(370,80);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==emp)
        {
            setVisible(false);
            new Home().setVisible(true);
        }
        else if(ae.getSource()==depart)
        {
            setVisible(false);
            new HomeDep().setVisible(true);
        }
        else if(ae.getSource()==proj)
        {
            setVisible(false);
            new HomeProj().setVisible(true);
        }
        
        
    }
    
    public static void main(String args[])
    {
        new Manage();
    }
}
