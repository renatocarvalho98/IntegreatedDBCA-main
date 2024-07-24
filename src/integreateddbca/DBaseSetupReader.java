/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

import static integreateddbca.DataBase.DB_URL;
import static integreateddbca.DataBase.PASSWORD;
import static integreateddbca.DataBase.TABLE_NAME1;

import static integreateddbca.DataBase.TABLE_NAME2;
import static integreateddbca.DataBase.USER;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Renato
 */
public class DBaseSetupReader extends DataBase{
    public ArrayList <UserDetails> getALLBaseDetails(){
     /**
     * Method to retrieve all details from the details table.
     * @return ArrayList of UserDetails containing details data.
     */
        ArrayList<UserDetails> DetailsList = new ArrayList<>();
        
         try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
             
         
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s;",
                        TABLE_NAME1)
                        );
                //IT GONNA TAKE ALL THE DATA RESULTS this.name = name;

                //RESULTS IS A STORES THAT GONNA TAKE ALL FROM DATA BASE
              
               while (results.next()){
                 int user_ID = results.getInt("user_id");
                  String name = results.getString("name");
                  String lastName = results.getString("surname");
                  String birth = results.getString("birthdate");
                    double salary = results.getDouble("salary");
                    double grossTax = results.getDouble("gross_tax");
                    double creditTax= results.getDouble("credit_tax");
                   
                  
               
               
         UserDetails ListD = new UserDetails(name, lastName, birth, salary, grossTax, creditTax, user_ID);
              
             DetailsList.add(ListD);
                
      
        System.out.println("ID: " + ListD.getUser_ID());
        System.out.println("Name: " + ListD.getName());
        System.out.println("Surname: " + ListD.getLastName());
        System.out.println("Birthdate: " + ListD.getBirth());
        System.out.println("Salary: " + ListD.getSalary());
        System.out.println("Gross Tax " + ListD.getGrossTax());
        System.out.println("Credit Tax " + ListD.getTaxCredit());
        System.out.println("-----------");
    
               }
                    
                
         }catch (Exception e) {
                     e.printStackTrace();
          
        }       
        return DetailsList;
        
        
    }
/**
     * Method to retrieve details for a specific user from the details table.
     * @param user_ID ID of the user to retrieve details for.
     * @return ArrayList of UserDetails containing details data for the specified user.
     */
  public ArrayList<UserDetails> getUserDataDetails(int user_ID){
          ArrayList<UserDetails> DetailsListID = new ArrayList<>();
     try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
             
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s WHERE user_id= %d;",
                        TABLE_NAME1, user_ID)
                        );
               
                results.next();
    
   
                    String name = results.getString("name");
                    String lastName = results.getString("surname");
                    String birth = results.getString("birthdate");
                    double salary = results.getDouble("salary");
                    double grossTax = results.getDouble("gross_tax");
                    double creditTax= results.getDouble("credit_tax");
                    int user_id = results.getInt("user_id");
                  
               
               
              UserDetails ListD = new UserDetails(name, lastName, birth, salary, grossTax, creditTax, user_ID);
              
          DetailsListID.add(ListD);
                
      
        System.out.println("ID: " + ListD.getUser_ID());
        System.out.println("Name: " + ListD.getName());
        System.out.println("Surname: " + ListD.getLastName());
        System.out.println("Birthdate: " + ListD.getBirth());
        System.out.println("Salary: " + ListD.getSalary());
        System.out.println("Gross Tax " + ListD.getGrossTax());
        System.out.println("Credit Tax " + ListD.getTaxCredit());
        System.out.println("-----------");
    
       
                return DetailsListID;
     
                
             

                }catch (Exception e) {
                     e.printStackTrace();
                     return null;
       
                }
     
     }
     /**
     * Method to retrieve all logins from the login table.
     * @return ArrayList of UserDetails containing login data.
     */
   public ArrayList <UserDetails> getALLBaseLogin(){
        
        ArrayList<UserDetails> LoginsList = new ArrayList<>();
        
         try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
             
         
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s;",
                        TABLE_NAME2)
                        );
                //IT GONNA TAKE ALL THE DATA RESULTS this.name = name;

                //RESULTS IS A STORES THAT GONNA TAKE ALL FROM DATA BASE
              
               while (results.next()){
                 int user_ID = results.getInt("user_id");
                  String login = results.getString("user_login");
                  String password = results.getString("password_hash");
                
                   
                  
               
               
         UserDetails ListL = new UserDetails(login, password, user_ID);
              
           LoginsList.add(ListL);
                
      
        System.out.println("ID: " + ListL.getUser_ID());
        System.out.println("Login: " + ListL.getLogin());
        System.out.println("Password: " + ListL.getPassword());
        System.out.println("-----------");
    
               }
                    
                
         }catch (Exception e) {
                     e.printStackTrace();
          
        }       
        return LoginsList;
        
        
    }
   /**
     * Method to retrieve login data for a specific user from the login table.
     * @param user_ID ID of the user to retrieve login data for.
     * @return ArrayList of UserDetails containing login data for the specified user.
     */
  public ArrayList<UserDetails> getUserDataLogins(int user_ID){
        
      ArrayList<UserDetails> LoginsListID = new ArrayList<>();
     try(
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ){
             
                ResultSet results = stmt.executeQuery(String.format(
                        "SELECT * FROM %s WHERE user_id= %d;",
                        TABLE_NAME2, user_ID)
                        );
               
                results.next();
    
                  String login = results.getString("user_login");
                  String password = results.getString("password_hash");
               
               
              UserDetails ListL = new UserDetails(login, password, user_ID);
        
              LoginsListID.add(ListL);
                System.out.println("ID: " + ListL.getUser_ID());
                System.out.println("Login: " + ListL.getLogin());
                System.out.println("Password: " + ListL.getPassword());
                System.out.println("-----------");
    
              
                return LoginsListID;
     
                
             

                }catch (Exception e) {
                     e.printStackTrace();
                     return null;
       
                }
     
     }

   /**
     * Method to check if a login is valid.
     * @param login User's login.
     * @param senha User's password.
     * @return User ID if login is valid, -1 otherwise.
     */
  public static int checkLogin(String login, String senha) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
        String sql = String.format("SELECT user_id FROM %s WHERE user_login = '%s' AND password_hash = '%s';", TABLE_NAME2, login, senha);
        ResultSet resultSet = stmt.executeQuery(sql);

        if (resultSet.next()) {
            // Return the user_id if the login and password are valid
            return resultSet.getInt("user_id");
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println("Erro ao validar login e senha.");
    }

    // Return -1 if the login and password are not valid
    return -1;
  
  
  
    }

}