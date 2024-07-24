/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

import static integreateddbca.DataBase.DB_BASE_URL;
import static integreateddbca.DataBase.DB_NAME;
import static integreateddbca.DataBase.PASSWORD;
import static integreateddbca.DataBase.TABLE_NAME2;
import static integreateddbca.DataBase.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Renato
 */
public class DBaseSetupLogin extends DataBase{
    
    public static boolean setupDBLogin() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        
        
    /**
     * Method to set up the login database table.
     * @return true if setup is successful, false otherwise.
     */
        {
            
            
        try(
                Connection conn = DriverManager.getConnection(DB_BASE_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
                 // Create the database if it does not exist
            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DB_NAME + ";");
               // Switch to the created database
            stmt.execute("USE " + DB_NAME + ";");
            
            // SQL query to create the login table
            String sql = 
                   "CREATE TABLE IF NOT EXISTS " + TABLE_NAME2 + "("
                    + "user_id INT PRIMARY KEY AUTO_INCREMENT,"
                    + "user_login VARCHAR (100),"
                    + "password_hash VARCHAR(255)"
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
