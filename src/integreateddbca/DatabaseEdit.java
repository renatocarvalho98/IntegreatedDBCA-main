/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 * This class handles database editing operations such as updating user details and deleting accounts.
 * @author guiam
 */
public class DatabaseEdit extends DataBase {
     /**
     * Updates the name of a user in the database.
     *
     * @param userID   The ID of the user to update.
     * @param newName  The new name to set for the user.
     */
    public void editName(int userID, String newName) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
        String sql = String.format("UPDATE %s SET name = '%s' WHERE user_id = %d;", TABLE_NAME1, newName, userID);
        stmt.executeUpdate(sql);
        System.out.println("Name Changed ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type your Name");
    }
}
    
     /**
     * Updates the last name of a user in the database.
     *
     * @param userID       The ID of the user to update.
     * @param newLastName  The new last name to set for the user.
     */
    public void editLastName(int userID, String newLastName) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
        String sql = String.format("UPDATE %s SET surname = '%s' WHERE user_id = %d;", TABLE_NAME1, newLastName, userID);
        stmt.executeUpdate(sql);
        System.out.println("Surname Changed ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type your Name");
    }
}
    
    /**
     * Updates the salary of a user in the database.
     *
     * @param userID      The ID of the user to update.
     * @param newSalary   The new salary to set for the user.
     */
    public void editSalary(int userID, double newSalary) {
       Locale defaultLocale = Locale.getDefault();
         
       
       try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
         Locale.setDefault(Locale.US);

         
        String sql = String.format("UPDATE %s SET salary = %.2f WHERE user_id = %d;", TABLE_NAME1, newSalary, userID);
        stmt.executeUpdate(sql);
        
        System.out.println("Salary Changed and new Gross Tax ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type Salary");
    }finally {
        // restore the defalut locale
        Locale.setDefault(defaultLocale);
    }

       
    }
    
     /**
     * Updates the tax credit of a user in the database.
     *
     * @param userID        The ID of the user to update.
     * @param newTaxCredit  The new tax credit to set for the user.
     */
    public void editTaxCredit(int userID, double newTaxCredit) {
        Locale defaultLocale = Locale.getDefault();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
             Locale.setDefault(Locale.US);
             
        String sql = String.format("UPDATE %s SET credit_tax = %.2f WHERE user_id = %d;", TABLE_NAME1,newTaxCredit, userID);
        stmt.executeUpdate(sql);
        System.out.println("New Tax Credit Changed ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type Tax Credit");
    }finally {
        // Restore the default locale
        Locale.setDefault(defaultLocale);
    }
}
    /**
     * Updates the password of a user in the database.
     *
     * @param userID        The ID of the user to update.
     * @param newPassword   The new password to set for the user.
     */
    public void editPassword(int userID, String newPassword) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
        String sql = String.format("UPDATE %s SET password_hash = '%s' WHERE user_id = %d;", TABLE_NAME2,newPassword, userID);
        stmt.executeUpdate(sql);
        System.out.println("New Password Changed ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type New Password");
    }
}
   /**
     * Updates the gross tax of a user in the database.
     *
     * @param userID        The ID of the user to update.
     * @param newGrossTax   The new gross tax to set for the user.
     */
    public void editGrossTax(int userID, double newGrossTax) {
       Locale defaultLocale = Locale.getDefault();
         try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
         Locale.setDefault(Locale.US);
             
             String sql = String.format("UPDATE %s SET gross_tax = %.2f WHERE user_id = %d;", TABLE_NAME1, newGrossTax, userID);
        stmt.executeUpdate(sql);
        System.out.println("Gross Tax Changed ");
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error to type Gross Tax");
    }finally {
       // Restore the default locale
        Locale.setDefault(defaultLocale);
    }
}
     /**
     * Deletes a user account from the database.
     *
     * @param userID  The ID of the user to delete.
     */
  public void deleteAccount(int userID) {
    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
         Statement stmt = conn.createStatement()) {
        String sql = String.format("DELETE FROM %s WHERE user_id = %d;", TABLE_NAME2, userID);
        int rowsAffected = stmt.executeUpdate(sql);

        if (rowsAffected > 0) {
            //System.out.println("Deleted successfully.");
        } else {
            //System.out.println("No record found for userID: " + userID);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.err.println("Error deleting record.");
    }
    
}
}
