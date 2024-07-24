/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

/**
 * This class serves as a configuration for database-related constants.
 * @author Renato
 */
public class DataBase {
   
     // Database connection details
   protected final static  String DB_BASE_URL = "jdbc:mysql://localhost"; //java datebase conector
   protected final static  String USER = "ooc2023";
   protected final static  String PASSWORD = "ooc2023";
   protected final static  String DB_NAME = "InteDBCA";
   protected final static  String TABLE_NAME1 = "Details";
   protected final static  String TABLE_NAME2 = "Login";
   protected final static  String DB_URL = DB_BASE_URL + "/" + DB_NAME;


    
    
}
