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
public class UpdateEmployee extends JFrame implements ActionListener
{
    JTextField  Tfname, Tsalary, Tadd, Tphone, Tmail, Tdesig, Tedu, Tdepartment;
    JButton submit, upd, back;
    JLabel image;
    String employeeid, Sdid;

    UpdateEmployee(String employeeid)
    {
        this.employeeid=employeeid;
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel head = new JLabel(" Update Employee Details ");
        head.setBounds(300,30,500,50);
        head.setFont(new Font("serif", Font.BOLD,35));
        head.setForeground(mycolor);
        add(head);
        
        JLabel head1 = new JLabel("_____________________________________________________________________________________________________________________________________________");
        head1.setBounds(0,60,900,50);
        add(head1);
        
        /*--------------NAME--------------------*/
        JLabel lname = new JLabel("Full-Name : ");
        lname.setBounds(50,150,170,30);
        lname.setFont(new Font("serif", Font.PLAIN,25));
        add(lname);
        
        JLabel Tname = new JLabel();
        Tname.setBounds(220,150,240,30);
        Tname.setFont(new Font("serif", Font.PLAIN,18));
        add(Tname);
        
        /*************Employee Id**********/
        JLabel lempid = new JLabel("ID : ");
        lempid.setBounds(520,150,150,30);
        lempid.setFont(new Font("serif", Font.PLAIN,25));
        add(lempid);
        
        
        JLabel Tempid = new JLabel();
        Tempid.setBounds(620,150,240,30);
        Tempid.setFont(new Font("serif", Font.PLAIN,18));
        add(Tempid);
        
         /*--------------FATHER-NAME-------------------*/
        JLabel lfname = new JLabel("Father's Name: ");
        lfname.setBounds(50,200,170,30);
        lfname.setFont(new Font("serif", Font.PLAIN,25));
        add(lfname);
        
        Tfname = new JTextField();
        Tfname.setBounds(220,200,240,30);
        Tfname.setFont(new Font("serif", Font.PLAIN,18));
        add(Tfname);
        
         /*--------------DOB---------------------------*/
        JLabel ldob = new JLabel("D.O.B. : ");
        ldob.setBounds(520,200,150,30);
        ldob.setFont(new Font("serif", Font.PLAIN,25));
        add(ldob);
        
        JLabel Tdob = new JLabel();
        Tdob.setBounds(620,200,240,30);
        Tdob.setFont(new Font("serif", Font.PLAIN,18));
        add(Tdob);
        
        /*--------------Education-------------------------*/
        JLabel ledu = new JLabel("Education : ");
        ledu.setBounds(50,250,170,30);
        ledu.setFont(new Font("serif", Font.PLAIN,25));
        add(ledu);
            
        Tedu = new JTextField();
        Tedu.setBounds(220,250,240,30);
        Tedu.setFont(new Font("serif", Font.PLAIN,18));
        add(Tedu);
        
        /*--------------Designation------------------------*/
        JLabel ldesig = new JLabel("Post : ");
        ldesig.setBounds(520,250,150,30);
        ldesig.setFont(new Font("serif", Font.PLAIN,25));
        add(ldesig);
        
        
        Tdesig = new JTextField();
        Tdesig.setBounds(620,250,240,30);
        Tdesig.setFont(new Font("serif", Font.PLAIN,18));
        add(Tdesig);
        
    
         /*--------------Phone---------------------------*/
        
        JLabel lphone = new JLabel("Phone : ");
        lphone.setBounds(50,300,150,30);
        lphone.setFont(new Font("serif", Font.PLAIN,25));
        add(lphone);
        
        Tphone = new JTextField();
        Tphone.setBounds(220,300,240,30);
        Tphone.setFont(new Font("serif", Font.PLAIN,18));
        add(Tphone);
        
        /*--------------Email-------------------------*/
        
        JLabel lemail = new JLabel("E-Mail : ");
        lemail.setBounds(520,300,150,30);
        lemail.setFont(new Font("serif", Font.PLAIN,25));
        add(lemail);
        
        Tmail = new JTextField();
        Tmail.setBounds(620,300,240,30);
        Tmail.setFont(new Font("serif", Font.PLAIN,18));
        add(Tmail);
        
        /*--------------ADDRESS---------------------------*/
        
        JLabel ladd = new JLabel("Address : ");
        ladd.setBounds(50,350,150,30);
        ladd.setFont(new Font("serif", Font.PLAIN,25));
        add(ladd);
        
        Tadd = new JTextField();
        Tadd.setBounds(220,350,640,30);
        Tadd.setFont(new Font("serif", Font.PLAIN,18));
        add(Tadd);
      
        /********************Adaharno****************/
     
        JLabel ladhar = new JLabel("Adhaar No : ");
        ladhar.setBounds(50,400,150,30);
        ladhar.setFont(new Font("serif", Font.PLAIN,25));
        add(ladhar);
        
        JLabel Tadhar = new JLabel();
        Tadhar.setBounds(220,400,250,30);
        Tadhar.setFont(new Font("serif", Font.PLAIN,18));
        add(Tadhar);
        
        
        /*--------------SALARY---------------------------*/
        JLabel lsal = new JLabel("Salary : ");
        lsal.setBounds(520,400,150,30);
        lsal.setFont(new Font("serif", Font.PLAIN,25));
        add(lsal);
        
        Tsalary = new JTextField();
        Tsalary.setBounds(620,400,240,30);
        Tsalary.setFont(new Font("serif", Font.PLAIN,18));
        add(Tsalary);
        
        JLabel ldep = new JLabel("Department : ");
        ldep.setBounds(50,450,150,30);
        ldep.setFont(new Font("serif", Font.PLAIN,25));
        add(ldep);       
        
        Tdepartment = new JTextField();
        Tdepartment.setBounds(220,450,250,30);
        Tdepartment.setBackground(Color.WHITE);
        Tdepartment.setFont(new Font("serif", Font.PLAIN,18));
        Tdepartment.setEditable(false);
        add(Tdepartment);
        
        
        
        
        try{
            Conn c = new Conn();
            String query ="select * from employee where id = '"+employeeid+"'";
            ResultSet rs =c.s.executeQuery(query);
            while(rs.next())
            {
                Tname.setText(rs.getString("name"));
                Tempid.setText(rs.getString("id"));
                Tfname.setText(rs.getString("fathername"));
                Tdob.setText(rs.getString("dob"));
                Tedu.setText(rs.getString("education"));
                Tdesig.setText(rs.getString("post"));
                Tphone.setText(rs.getString("phone"));
                Tmail.setText(rs.getString("email"));
                Tadd.setText(rs.getString("address"));
                Tadhar.setText(rs.getString("Adhaarno"));
                Tsalary.setText(rs.getString("salary"));
                Tdepartment.setText(rs.getString("Dept_Id"));
                
                try
                {
                    String s = (String) Tdepartment.getText();
            
                    String query1 ="select * from department where D_Id = '"+s+"'";
                    ResultSet rs1 =c.s.executeQuery(query1);
                    while(rs1.next())
                    {
                        Tdepartment.setText(rs1.getString("D_Name"));
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
                
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        submit = new JButton(" Update Details ");
        submit.setBounds(220,490,220,40);
        submit.setFont(new Font("serif", Font.BOLD, 20));
        submit.setBackground(mycolor);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton(" Back ");
        back.setBounds(480,490,220,40);
        back.setFont(new Font("serif", Font.BOLD, 20));
        back.setBackground(mycolor);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        getContentPane().setBackground(Color.WHITE);
        setLocation(300,40);
        setSize(900,650);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            
            String fname = Tfname.getText();
            String salary = Tsalary.getText();
            String address = Tadd.getText();
            String phone = Tphone.getText();
            String email = Tmail.getText();
            String education = Tedu.getText();
            String designation = Tdesig.getText();
            String dep = Tdepartment.getText();
            
            try
            {
                Conn c = new Conn();
                String query2 = "select D_Id from department where D_Name='"+dep+"'";
                ResultSet rs2 =c.s.executeQuery(query2);
                while(rs2.next())
                {
                    Sdid = rs2.getString("D_Id");
                }
                
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
            try{
                Conn c= new Conn();
                String query ="update employee set fathername = '"+fname+"', salary = '"+salary+"', address='"+address+"', phone='"+phone+"', email ='"+email+"', education='"+education+"', post ='"+designation+"', Dept_Id='"+Sdid+"' where id = '"+employeeid+"'";               
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details Updated successfully");
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
        new UpdateEmployee("");
    }
}
