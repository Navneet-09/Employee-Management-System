/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import javax.swing.*;
//import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import javax.swing.border.Border;
//import javax.imageio.ImageIO;

public class AddEmployee  extends JFrame implements ActionListener
{
    JTextField Tname, Tfname, Tsalary, Tadd, Tphone, Tmail, Tadhar, Tdesig, Tempid;
    JDateChooser Tdob;
    JComboBox Tedu;
    JButton submit, upd, back;
    JFileChooser chooser;
    JLabel image;
    String path2= null;
    /*Random ran = new Random();
    int number = ran.nextInt(999999);*/
    AddEmployee()
    {
        setLayout(null);
        setTitle("Employee Management System");
        Color mycolor = new Color(0,24,88); //Dark Blue Colour
        
        JLabel head = new JLabel(" Add Employee ");
        head.setBounds(320,30,500,50);
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
        
        Tname = new JTextField();
        Tname.setBounds(220,150,240,30);
        Tname.setFont(new Font("serif", Font.PLAIN,18));
        add(Tname);
        
        /*************Employee Id**********/
        JLabel lempid = new JLabel("ID : ");
        lempid.setBounds(520,150,150,30);
        lempid.setFont(new Font("serif", Font.PLAIN,25));
        add(lempid);
        
        
        Tempid = new JTextField();
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
        
        Tdob = new JDateChooser();
        Tdob.setBounds(620,200,240,30);
        Tdob.setFont(new Font("serif", Font.PLAIN,18));
        add(Tdob);
        
        /*--------------Education-------------------------*/
        JLabel ledu = new JLabel("Education : ");
        ledu.setBounds(50,250,170,30);
        ledu.setFont(new Font("serif", Font.PLAIN,25));
        add(ledu);
        
        String stream[] ={"","Graduated", "Post-Graduated", "Phd holder"};
        
        Tedu = new JComboBox(stream);
        Tedu.setBounds(220,250,240,30);
        Tedu.setBackground(Color.WHITE);
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
        
        
        
        
         /*****************image Label******************
        image = new JLabel();
        image.setBounds(640, 150, 140,140);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        image.setBorder(border);
        add(image);
        
        /****************************Upload Button***************
        upd = new JButton(" Upload Image ");
        upd.setBounds(590,300,250,30);
        upd.setFont(new Font("serif", Font.BOLD, 18));
        upd.setBackground(mycolor);
        upd.setForeground(Color.WHITE);
        upd.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae)
        {
            chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            String path = f.getAbsolutePath();
            try
            {             
                BufferedImage bi = ImageIO.read(new File(path));
                Image img = bi.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                image.setIcon(icon);
                path2=path;
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }});
        add(upd);*/
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
      
     
        JLabel ladhar = new JLabel("Adhaar No : ");
        ladhar.setBounds(50,400,150,30);
        ladhar.setFont(new Font("serif", Font.PLAIN,25));
        add(ladhar);
        
        Tadhar = new JTextField();
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
        
        
        
        submit = new JButton(" Submit ");
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
            String name = Tname.getText();
            String fname = Tfname.getText();
            String dob = ((JTextField) Tdob.getDateEditor().getUiComponent()).getText();
            String salary = Tsalary.getText();
            String address = Tadd.getText();
            String phone = Tphone.getText();
            String email = Tmail.getText();
            String education = (String) Tedu.getSelectedItem();
            String designation = Tdesig.getText();
            String adharno = Tadhar.getText();
            String eid = Tempid.getText();
            
            
            try{
                Conn c= new Conn();
                String query ="insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"','"+education+"', '"+designation+"', '"+adharno+"', '"+eid+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee details added successfully");
                setVisible(false);
                new Home().setVisible(true);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            
            
        }
        else
        {
            setVisible(false);
            new Home().setVisible(true);
        }
    }
    
    public static void main(String args[])
    {
        new AddEmployee();
    }
    
}
