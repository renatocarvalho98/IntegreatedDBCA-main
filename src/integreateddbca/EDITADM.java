/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

import java.util.Scanner;

/**
 *
 * @author Renato
 */
public class EDITADM {
    
     private static UserDetails editDetailsADMIN(int userID) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Type which User you want edit (ID): ");
   
    
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
    
    
    
    
    
    
}
