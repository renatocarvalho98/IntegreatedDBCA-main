
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package integreateddbca;

import static integreateddbca.DataBase.DB_BASE_URL;
import static integreateddbca.DataBase.DB_URL;
import static integreateddbca.DataBase.PASSWORD;
import static integreateddbca.DataBase.USER;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Renato
 */
// Renato Carvalho - 2022350
// Guilherme Amaral - 2022262
// GitHub Link : https://github.com/RenatoCarvalho2022350/IntegreatedDBCA
// link youtube : https://www.youtube.com/watch?v=hzJpBYisaw0 


public class Menu {

    /**
     * @param args the command line arguments
     */
    
 // Variable to store the authenticated user's ID
    private static int authenticatedUserID = -1;
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // Initialize scanner for user input
       

       
        
        Scanner scanner = new Scanner(System.in);
        boolean continueSystem = true;
  
        while (continueSystem) {
     // Display main menu options
     System.out.println("  == Welcome to the System  ==  ");
     System.out.println("  ==  Consulting your Taxs  ==  ");     
     System.out.println("  ==   Login in your Account // Please press == 1   ==  ");
     System.out.println("  ==   Creating an Account // Please press == 2   ==  ");
     System.out.println("  ==   Close System // Please press == 3   ==  ");
     
     int option;
            // Check if user input is an integer
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                    boolean continueEditing = true;
                    
                 // Process the selected option
                switch (option) {
                    
                    case 1 -> { // logic for login 
                        
                       
                        while (authenticatedUserID == -1){
                          
                       System.out.println("Check Login ");                       
                            int authenticatedUserID = checkLogin();
                       if (authenticatedUserID == -1) {
                            System.out.println("Press 0 to return to the main menu or any other key to continue trying:");
                            int returnToMainMenu = scanner.nextInt();
                            if (returnToMainMenu == 0) {
                                break;
                                    }
                            authenticatedUserID = checkLogin();
                            }
                        if ( authenticatedUserID == 1 ){
                            
                           
                            //WHEN ADM LOGIN IT GONNA SHOW ALL DATA BASE AND LOGINS
                            ArrayList<UserDetails> userDetailsList = new DBaseSetupReader().getALLBaseDetails();
                            
                             boolean continueEditing1 = true;
                    
                        while(continueEditing1){

                    
                        System.out.println("Options to ADM:");
                        System.out.println("1. Edit Details / Password ");
                        System.out.println("2. Delete account ");
                        System.out.println("3. Show details ");
                        System.out.println("4. Exit");
                        System.out.print("Enter USER ID THAT YOU WANT EDIT: "); 
                         if (scanner.hasNextInt()){
                        authenticatedUserID = scanner.nextInt();
                        
                        System.out.print("ENTER WHAT YOU WANT EDIT: ");                                  
                            int optionLoginADM = scanner.nextInt();
                            
                            switch (optionLoginADM) {
                                case 1 -> {
                                 UserDetails editDet = editDetails(authenticatedUserID); 
                                    if (editDet != null) {
                                            System.out.println("Details edited successfully.");
                                        }
                                       
                                         break;
                                    }
                                case 2 -> {
                                 UserDetails deletDetails =  deleteDetails(authenticatedUserID);
                                     if (deletDetails != null) {
                                            System.out.println("Delete edited successfully.");
                                            authenticatedUserID = -1;
                                            continueEditing1 = false; 
                                            break;
                                        }

                                     }
                                case 3 -> { 
                                    ArrayList<UserDetails> userDetailsList1 = new DBaseSetupReader().getUserDataDetails(authenticatedUserID);
                                   // ArrayList<UserDetails> userDetailses = getUserDataDetails(authenticatedUserID);
                                     continueEditing1 = false; 
                                    break;
                                      }
                                case 4 -> { 
                                    authenticatedUserID = -1;
                                    System.out.println("Exiting edit menu...");
                                    continueEditing1 = false; // Set the variable to false to exit the loop
                                    break;
                                     
                                      }
                                
                             default -> //Invalid option 
                        System.out.println("Invalid option. Please enter 1, 2, 3, 4");   
                                
                           //final optionADM
                          }
                            
                            
                            }else {
                 // Clear the scanner buffer if the input is not a number
                        System.out.println("Invalid input. Please enter a number.");
                         scanner.next();
                         
                         }
                        }
                        
                        }
                   
                         
                            
                       
                      
                     do  {  
                         // Display user-specific menu options after successful login
                        System.out.println("Options:");
                        System.out.println("1. Edit Details / Password ");
                        System.out.println("2. Delete account ");
                        System.out.println("3. Show my details ");
                        System.out.println("4. Exit ");
                        System.out.print("Enter option: ");

                            int optionLogin = scanner.nextInt();
                            // Process user-specific menu options  
                                switch (optionLogin) {
                                case 1 -> {
                                 UserDetails editDet = editDetails(authenticatedUserID); 
                                    if (editDet != null) {
                                            System.out.println("Details edited successfully.");
                                        }
                       
                                    }
                                case 2 -> {
                                 UserDetails deletDetails =  deleteDetails(authenticatedUserID);
                                     if (deletDetails != null) {
                                            System.out.println("Delete edited successfully.");
                                            authenticatedUserID = -1;
                                            continueEditing = false; 
                                            break;
                                        }

                                     }
                                case 3 -> { 
                                        ArrayList<UserDetails> userDetailsList = new DBaseSetupReader().getUserDataDetails(authenticatedUserID);
                                      }
                                 case 4 -> { 
                                    authenticatedUserID = -1;
                                    System.out.println("Exiting edit menu...");
                                    continueEditing = false; // Set the variable to false to exit the loop
                                    break;
                                     
                                      }
                                 
                                       default -> System.out.println("Invalid option."); 
                                         }
                                  }
                     while (continueEditing);
                                
                        
                   }  
    //}
                
                
                         } 
                    
                    
                    
                    
                    
                    
                    case 2 -> { // Logic for account creation 
                        System.out.println("Creating a new Account ");                      
                       UserDetails userLogin = CreatLogin();
                       UserDetails userDetails = InsertDetails(userLogin);
                       SaveDataBase(userLogin, userDetails);
                       continueSystem = true;
                       break;
                  
                    
                    }
                    case 3 -> {// Logic to close the system
                        System.out.println("Exiting the system...");
                        continueSystem = false;
                        break;
                        }
                    default -> //Invalid option 
                        System.out.println("Invalid option. Please enter 1, 2, or 3.");
                }
                if (option == 3) {
                    break;
                }
                
            } else {
                 // Clear the scanner buffer if the input is not a number
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                 // Set option to an invalid value to continue the loop
            
            }
             }
        //while (true);
     
     scanner.close();
   }
    
     
     
     
     /**
     * Method to check user login credentials.
     * @return UserDetails object if login is successful, otherwise null.
     */
   private static int checkLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Login ===");
        System.out.println("Login: ");
        String login = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        int userID = DBaseSetupReader.checkLogin(login, password);
       
        if (userID != -1) {
        // Valid login and password, retrieve user details
        ArrayList<UserDetails> userDetailsList = new DBaseSetupReader().getUserDataDetails(userID);

        if (userDetailsList != null && !userDetailsList.isEmpty()) {
            UserDetails userDetails = userDetailsList.get(0);
             // Perform operations with userDetails
            // ...
            return userID;
        } else {
                System.out.println("Details not found.");
        }
    } else {
        System.out.println("Login and/ot password invalid.");
    }
        
        
        return -1;
               
    }
    
    /**
     * Method to edit user details such as name, surname, salary, etc.
     * @param userID ID of the user whose details are to be edited.
     * @return UserDetails object if editing is successful, otherwise null.
     */
    private static UserDetails editDetails(int userID) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Type which User you want edit (ID):  ");
   
    
    DBaseSetupReader dbr = new DBaseSetupReader();
    dbr.getUserDataDetails(userID);
    
    System.out.println("Tell me which option you want edit: ");
    System.out.println("1. Nome");
    System.out.println("2. Surname");
    System.out.println("3. Salary and/or your Tax Credit(Please imput both");
    System.out.println("4. Password");
    System.out.print("Opção: ");
    int option = scanner.nextInt();
   
   
    DatabaseEdit dbWriter = new DatabaseEdit();
    
    
    switch (option) {
        case 1 -> {
            System.out.print("New Name: ");
            String name = scanner.next();
            dbWriter.editName(userID, name);
            }
          case 2 -> {
              System.out.print("New Surname: ");
              String lastName = scanner.next();
              dbWriter.editLastName(userID, lastName);
            }
          case 3 -> {
              System.out.print("New/Same Salary ");
              double salary = scanner.nextDouble();
              System.out.print("New/Same Tax Credit ");
              double taxCredit = scanner.nextDouble();
             
              double salaryTaxCredit = salary - taxCredit;
              
        double tax20 = 0.20; // 20%
        double tax40 = 0.40; // 40%
        double limitTax40 = 40000; // Limit for the 40% tax

        // Calculate the part of the salary that will be taxed at 20%
        double part20 = Math.min(salaryTaxCredit, limitTax40) * tax20;

         // Calculate the part of the salary that will be taxed at 40%
        double part40 = Math.max(salaryTaxCredit - limitTax40, 0) * tax40;

        // Calculate the total tax
        double taxTotal = part20 + part40;

       double grossTax = taxTotal;
               
              dbWriter.editSalary(userID, salary);
              dbWriter.editTaxCredit(userID, taxCredit);
              dbWriter.editGrossTax(userID, grossTax);
    
            }
          case 4 -> {
              System.out.print("New Password: ");
              String password = scanner.next();
              dbWriter.editPassword(userID, password);
            }
           default -> System.out.println("Opção inválida.");
          
    }
        return null;
     
    
  }
   /**
     * Method to delete user account.
     * @param userID ID of the user whose account is to be deleted.
     * @return UserDetails object if deletion is successful, otherwise null.
     */ 
    private static UserDetails deleteDetails(int userID){
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Type which User you want delet (ID): ");
        //int userID = scanner.nextInt();
    
        DBaseSetupReader dbr = new DBaseSetupReader();
        dbr.getUserDataDetails(userID);
        
         System.out.println("Are you sure that want to delete " + userID + "? 1- YES // 2 - NO");
         int option = scanner.nextInt();
   
   
        DatabaseEdit dbWriter = new DatabaseEdit();
    
    
    switch (option) {
        case 1 -> {
            dbWriter.deleteAccount(userID);
            }
          case 2 -> {
              System.out.print("Perfect, back to menu");
            }
        
        
        
    }
        return null;
    
    
   }  
      /**
     * Method to create a new user login.
     * @return UserDetails object with the new login information.
     */
    private static UserDetails CreatLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Creat new Login ===");
        System.out.print("New User name Login: ");
        String login = scanner.nextLine();

        System.out.print("New Password: ");
        String password = scanner.nextLine();

        return new UserDetails(login, password, UserDetails.getCurrentIDuser());
    }
     /**
     * Method to insert additional details for a new user.
     * @param userLogin UserDetails object with login information.
     * @return UserDetails object with additional details.
     */
    private static UserDetails InsertDetails(UserDetails userLogin) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Insert Details ===");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Surname:  ");
        String lastName = scanner.nextLine();

        System.out.print("Birthday date: ");
        String birth = scanner.nextLine();

        System.out.print("Type your salary: ");
        double salary = scanner.nextDouble();

        System.out.print("Type your Tax Credit");
        double taxCredit = scanner.nextDouble();

        UserDetails userDetails = new UserDetails(name, lastName, birth, salary, 0, taxCredit, UserDetails.getCurrentIDuser());
        userDetails.aplicarTaxCredit(); //Apply the tax credit
        userDetails.calcularTaxaTotal(); // Calculate the total tax

        return userDetails;
        
    }  
        /**
     * Method to save user login and details to the database.
     * @param userLogin UserDetails object with login information.
     * @param userDetails UserDetails object with additional details.
     */
    private static void SaveDataBase(UserDetails userLogin, UserDetails userDetails) {
        try(
                java.sql.Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
                Statement stmt = conn.createStatement();  
            ) {
            // Insert the login
            String insertLoginSql = "INSERT INTO Login (user_login, password_hash) VALUES (?, ?)";
            try (PreparedStatement loginStatement = conn.prepareStatement(insertLoginSql)) {
                loginStatement.setString(1, userLogin.getLogin());
                loginStatement.setString(2, userLogin.getPassword());
                loginStatement.executeUpdate();
                
            }

            // Insert the details
            String insertDetailsSql = "INSERT INTO Details (user_id, name, surname, birthdate, salary, gross_tax, credit_tax) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement detailsStatement = conn.prepareStatement(insertDetailsSql)) {
                detailsStatement.setInt(1, userDetails.getUser_ID());
                detailsStatement.setString(2, userDetails.getName());
                detailsStatement.setString(3, userDetails.getLastName());
                detailsStatement.setString(4, userDetails.getBirth());
                detailsStatement.setDouble(5, userDetails.getSalary());
                detailsStatement.setDouble(6, userDetails.getGrossTax());
                detailsStatement.setDouble(7, userDetails.getTaxCredit());
                detailsStatement.executeUpdate();
            }

            System.out.println("Data saved in the database successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Erro to save");
        }
        
        
        
}

    private static ArrayList<UserDetails> getUserDataDetails(int authenticatedUserID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
           
  }  
 
              
        //UserDetails user = new UserDetails("Rena", "Carva", "1998-03-14", 50000, 0, 10000, 0);
        // user.aplicarTaxCredit();
       // user.calcularTaxaTotal();
       // System.out.println("Gross Tax: " + user.getGrossTax());
       // System.out.println("Salary Taxed Credit " + user.getSalaryTaxCredit());
        

     //  if (DBaseSetupLogin.setupDBLogin()) {
  // System.out.println("Database login and table created");
    //    } else {
    //  System.out.println("Oh no! There was a database creation problem...");
    //  }
      
     //     if (DBaseSetupDetails.setupDBDetails()) {
  // System.out.println("Database details and table created");
    //    } else {
    //  System.out.println("Oh no! There was a database creation problem...");
      //}

//DBaseSetupReader dbr = new DBaseSetupReader();
  
   //dbr.getALLBaseDetails();
  // dbr.getUserDataDetails(2);
   
  // dbr.getALLBaseLogin();
   //dbr.getUserDataLogins(2);
         

     //UserDetails checkLogin = checkLogin();
        //editando login
     // UserDetails editDet =  editDetails();
        

        // Criação do login
       // UserDetails userLogin = CreatLogin();

        // Inserir detalhes
       // UserDetails userDetails = InsertDetails(userLogin);

        // Salvar no banco de dados
       // SaveDataBase(userLogin, userDetails);
    



     //deletendo user
    // UserDetails deletDetails =  deleteDetails();
    