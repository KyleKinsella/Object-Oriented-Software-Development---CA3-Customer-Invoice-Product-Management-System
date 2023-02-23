import java.util.Scanner;

public class test {
    
    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
  
      System.out.print("Enter your name: ");
      String name = input.nextLine();
  
      System.out.print("Enter your age: ");
      int age = 0;
      while (!input.hasNextInt()) {
        System.out.println("Invalid input! Please enter a valid number for your age: ");
        input.next();
      }
      age = input.nextInt();
  
      System.out.print("Enter your address: ");
      String address = input.nextLine();
  
      System.out.print("Enter your phone number: ");
      String phoneNumber = input.nextLine();
      while (!isValidPhoneNumber(phoneNumber)) {
        System.out.println("Invalid phone number! Please enter a valid phone number: ");
        phoneNumber = input.nextLine();
      }
  
      // Store the user information in the database
  
      System.out.println("\nThank you for your information!");
      System.out.println("Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Address: " + address);
      System.out.println("Phone number: " + phoneNumber);
    }
  
    public static boolean isValidPhoneNumber(String phoneNumber) {
      // validate the phone number
      if (phoneNumber.length() != 10) {
        return false;
      }
      for (int i = 0; i < phoneNumber.length(); i++) {
        if (!Character.isDigit(phoneNumber.charAt(i))) {
          return false;
        }
      }
      return true;
    }
  }