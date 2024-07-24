
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

import static integreateddbca.DataBase.DB_BASE_URL;
import static integreateddbca.DataBase.PASSWORD;
import static integreateddbca.DataBase.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;




/**
 *
 * @author Renato
 */
public class DBaseSetupDetails extends DataBase {
    
     /**
     * Method to set up the details database table.
     * @return true if setup is successful, false otherwise.
     */
    public static boolean setupDBDetails() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        {
              
        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
           // Create the database if it does not exist
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
            // Switch to the created database
            stmt.execute("USE " + DB_NAME + ";");
            // SQL query to create the details table
            String sql = 
                 "CREATE TABLE IF NOT EXISTS " + TABLE_NAME1 + "("
                    + "user_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "name VARCHAR(255),"
                    + "surname VARCHAR(255),"
                    + "birthdate DATE,"
                    + "salary DECIMAL(10,2),"
                    + "gross_tax DECIMAL(10,2),"
                    + "credit_tax DECIMAL(10,2),"
                    + "FOREIGN KEY (user_id) REFERENCES Login(user_id) ON DELETE CASCADE "
                    + ");";
            
            // Execute the SQL query to create the table
            stmt.execute(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        
        
        
        
        
    }
    
    
    
    
}

    
    
    

