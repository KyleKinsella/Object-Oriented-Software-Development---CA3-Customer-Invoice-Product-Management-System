import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java . sql .SQLException;
import java.util.Scanner;

import javax.swing.JFrame;

public class InsertCustomerCLI extends JFrame {
public InsertCustomerCLI(String title) {
        super(title);
        //TODO Auto-generated constructor stub
    }


public static void main(String [] args) {
    // database URL
    final String DATABASE_URL = "jdbc:mysql://localhost/customer";
    Connection connection = null ;
    PreparedStatement pstat = null ;
    
    //signup sign = new signup(DATABASE_URL);


    //String name = "Mary";
    Scanner scan = new Scanner(System.in);

    Scanner namein = new Scanner(System.in);

    Scanner email = new Scanner(System.in);

    //Scanner date_b = new Scanner(System.in);

    int customerId; // int
    String nameN; // string
    int DOB; // int
    String emailE; // string
    int phoneNumber; // int

    //int date_born;
    //int month_born;
    int year_born;

    //String DOB;
   

    System.out.println("This is the sign up page, on this page you create a new Customer");

    System.out.print("Enter Customer Id : ");
    customerId = scan.nextInt();

    System.out.print("Enter your Name: ");
    nameN = namein.nextLine();

    System.out.print("Enter your Date of birth: ");
    DOB = scan.nextInt();

    /* 
    System.out.println("Enter your Date of birth");

    System.out.print("Enter the date you were born: ");
    date_born = date_b.nextInt();

    System.out.print("Enter the month you were born in: ");
    month_born = scan.nextInt();

    System.out.print("Enter the year your were born: ");
    year_born = scan.nextInt();

    DOB = date_born + "/" + month_born + "/" + year_born ;

    System.out.println(DOB);
    */

    System.out.print("Enter your Email: ");
    emailE = email.nextLine();

    System.out.print("Enter your Phone number: ");
    phoneNumber = scan.nextInt();

    int i =0;

    try {
    // establish connection to database
    connection = DriverManager.getConnection(DATABASE_URL, "root","");
    // create Prepared Statement for inserting data into table
    pstat = connection.prepareStatement("INSERT INTO Customer (CustomerId, Name, DateOfBirth, Email, PhoneNumber) VALUES (?,?,?,?,?)");
    pstat.setInt(1, customerId);
    pstat.setString(2, nameN);
    pstat.setInt(3, DOB);
    pstat.setString(4, emailE);
    pstat.setInt(5, phoneNumber);

    // insert data into table
    i = pstat.executeUpdate();
    System.out.println(i + " record successfully added to the table. ");
    }

    catch(SQLException sqlException){
        sqlException.printStackTrace();
        }
        finally {
        try {
        pstat.close();
        connection.close();
        }
        catch (Exception exception){
        exception.printStackTrace();
            }
        }
    }
}