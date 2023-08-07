/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
        
public class Home extends JFrame implements ActionListener
{
    JButton ad, view, update, delete, exit;
    Home()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel text = new JLabel(" Manage Employee ");
        text.setBounds(210,10,700,80);
        text.setFont(new Font("serif", Font.PLAIN, 35));
        text.setForeground(mycolor);
        add(text);
        
        JLabel t = new JLabel("_____________________________________________________");
        t.setBounds(0,20,720,80);
        t.setFont(new Font("serif", Font.PLAIN, 35));
        add(t);
        
        /*ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/adminhome.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200 ,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30,110,150, 150);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        image.setBorder(border);
        add(image);
        
        
        
        JLabel text1 = new JLabel(" Welcome Admin ");
        text1.setBounds(30,240,400,80);
        text1.setFont(new Font("serif", Font.BOLD, 20));
        add(text1);*/
        
        ad = new JButton(" Add Employee ");
        ad.setBounds(150,150,170,35);
        ad.setFont(new Font("serif", Font.BOLD, 16));
        ad.setBackground(mycolor);
        ad.setForeground(Color.WHITE);
        ad.addActionListener(this);
        add(ad);
        
        update = new JButton(" Update Employee ");
        update.setBounds(350,150,170,35);
        update.setFont(new Font("serif", Font.BOLD, 16));
        update.setBackground(mycolor);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        view = new JButton(" View Employees ");
        view.setBounds(150,210,170,35);
        view.setFont(new Font("serif", Font.BOLD, 16));
        view.setBackground(mycolor);
        view.setForeground(Color.WHITE);
        view.addActionListener(this);
        add(view);
        
        delete = new JButton(" Delete Employee ");
        delete.setBounds(350,210,170,35);
        delete.setFont(new Font("serif", Font.BOLD, 16));
        delete.setBackground(mycolor);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        exit = new JButton(" Back ");
        exit.setBounds(220,280,200,30);
        exit.setFont(new Font("serif", Font.BOLD, 16));
        exit.setBackground(mycolor);
        exit.setForeground(Color.WHITE);
        exit.addActionListener(this);
        add(exit);
        
        
        /*JLabel text2 = new JLabel(" Date : " + LocalDate.now());
        text2.setBounds(30,270,400,80);
        text2.setFont(new Font("serif", Font.PLAIN, 14));
        add(text2);*/
        
        //getContentPane().setBackground(Color.WHITE);
        setSize(680,450);
        setLocation(370,80);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Manage().setVisible(true);
        }
        else if(ae.getSource()==ad)
        {
            setVisible(false);
            new AddEmployee().setVisible(true);
        }
        else if(ae.getSource()==update)
        {
            setVisible(false);
            new ViewEmployee().setVisible(true);
        }
        else if(ae.getSource()==delete)
        {
            setVisible(false);
            new DeleteEmployee().setVisible(true);
        }
        else if(ae.getSource()==view)
        {
            setVisible(false);
            new ViewEmployee().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Home();
    }
}
