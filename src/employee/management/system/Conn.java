/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee.management.system;
import java.sql.*;
public class Conn 
{
    Connection connection;
    Statement s;
    public Conn()
    {
         
        try
        {
            connection = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem","root","navneetkumar");          
            s = connection.createStatement();
            
            
        }
        catch(Exception e)
        {
            System.out.println(e);
           
        }
    }  
}
