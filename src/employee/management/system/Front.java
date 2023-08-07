/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Front extends JFrame implements ActionListener
{
    
    JButton start;
    Front()
    {
        setLayout(null);
        setTitle(" Employee Management System ");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,400 ,Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50,20,400, 500);
        add(image);
        
        JLabel text1 = new JLabel(" Employee ");
        text1.setBounds(500,80,400,80);
        text1.setFont(new Font("serif", Font.PLAIN, 60));
        add(text1);
        
        JLabel text2 = new JLabel(" Management ");
        text2.setBounds(500,160,400,80);
        text2.setFont(new Font("serif", Font.PLAIN, 60));
        add(text2);
        
        JLabel text3 = new JLabel(" System ");
        text3.setBounds(500,230,400,80);
        text3.setFont(new Font("serif", Font.PLAIN, 60));
        add(text3);
        
        start = new JButton(" Click Here To start ");
        start.setBounds(520, 350, 270, 55);
        start.setFont(new Font("serif", Font.BOLD, 20));
        start.setBackground(mycolor);
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        add(start);
        
        
        setSize(1000, 650); //1170,650
        setLocation(300, 40);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
        /*while(true)
        {
            start.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            start.setVisible(true);
            try{
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }*/
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==start)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new Front();
    }
}
