/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package integreateddbca;

/**
 * Represents user details including personal information, salary, and tax-related attributes.
 * @author Renato
 */
public class UserDetails {
    private String login;
    private String password;
    
    private String name;
    private String lastName;
    private String birth;
    private double salary;
    private double grossTax;
    private double TaxCredit;
    private double salaryTaxCredit;
    private int user_ID;
    private static int currentIDuser = 2;
    
     /**
     * Constructor for creating user details with personal information, salary, and tax credit.
     *
     * @param name      The user's first name.
     * @param lastName  The user's last name.
     * @param birth     The user's birthdate.
     * @param salary    The user's salary.
     * @param taxCredit The user's tax credit.
     * @param grossTax  The user's gross tax.
     */
    public UserDetails(String name, String lastName, String birth, double salary,double taxCredit, double grossTax) {
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.salary = salary;
        this.grossTax = grossTax;
        this.TaxCredit = taxCredit;
        this.user_ID = currentIDuser;
        currentIDuser++;
       
    }
    /**
     * Constructor for creating user details with login credentials.
     *
     * @param login   The user's login name.
     * @param password The user's password.
     * @param user_ID  The user's ID.
     */
    public UserDetails(String login, String password, int user_ID) {
        this.login = login;
        this.password = password;
        this.user_ID = user_ID;
    }
     /**
     * Constructor for creating user details with salary, gross tax, and salary tax credit.
     *
     * @param salary           The user's salary.
     * @param grossTax         The user's gross tax.
     * @param salaryTaxCredit  The user's salary tax credit.
     */
    public UserDetails(double salary, double grossTax, double salaryTaxCredit) {
        this.salary = salary;
        this.grossTax = grossTax;
        this.salaryTaxCredit = salaryTaxCredit;
    }
    
    
    /**
     * Constructor for creating user details with personal information, salary, tax credit, and user ID.
     *
     * @param name      The user's first name.
     * @param lastName  The user's last name.
     * @param birth     The user's birthdate.
     * @param salary    The user's salary.
     * @param grossTax  The user's gross tax.
     * @param taxCredit The user's tax credit.
     * @param user_ID   The user's ID.
     */
    public UserDetails(String name, String lastName, String birth, double salary, double grossTax, double taxCredit, int user_ID) {
      
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.salary = salary;
        this.grossTax = grossTax;
        this.TaxCredit = taxCredit;
        this.salaryTaxCredit = salary - taxCredit;
        this.user_ID = user_ID;
        if (currentIDuser <= user_ID){
            currentIDuser = user_ID+1;
        }
    }
    
  
    /**
     * Applies the tax credit directly to the salary.
     *
     * @return The applied tax credit.
     */
     public double aplicarTaxCredit()   {
        // Apply the taxCredit directly to the salary
        salary -= TaxCredit;
        
         // Ensure that the salary is not negative
        if (salary < 0) {
            salary = 0;
        }
        return TaxCredit;
    }
        
    /**
     * Calculates the total tax based on salary, gross tax, and salary tax credit.
     *
     * @return The calculated gross tax.
     */
    public double calcularTaxaTotal() {
        double tax20 = 0.20; // 20%
        double tax40 = 0.40; // 40%
        double limitTax40 = 40000; // Limit for the 40% tax

       // Calculate the part of the salary that will be taxed at 20%
        double part20 = Math.min(salaryTaxCredit, limitTax40) * tax20;

        // Calculate the part of the salary that will be taxed at 40%
        double part40 = Math.max(salaryTaxCredit - limitTax40, 0) * tax40;

        // Calculate the total tax
        double taxTotal = part20 + part40;

       grossTax = taxTotal;
        return grossTax;
    }

   // Getter methods
    
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public double getSalary() {
        return salary;
    }

    public double getGrossTax() {
        return grossTax;
    }

    public double getTaxCredit() {
        return TaxCredit;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public double getSalaryTaxCredit() {
        return salaryTaxCredit;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public static int getCurrentIDuser() {
        return currentIDuser;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setGrossTax(double grossTax) {
        this.grossTax = grossTax;
    }

    public void setTaxCredit(double TaxCredit) {
        this.TaxCredit = TaxCredit;
    }

   
    
}
