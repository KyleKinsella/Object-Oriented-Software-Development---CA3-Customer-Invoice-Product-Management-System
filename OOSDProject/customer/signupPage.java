import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.*;


public class signupPage extends JFrame{

		/** 
		 * This is my sign up system (create)
		*/
	  public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Create a new JFrame
		JFrame frame = new JFrame("Sign up !");
	
		// Set the size of the frame
		frame.setSize(900, 200);
	
		// Set the default close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Set the layout of the frame to a grid layout
		frame.setLayout(new GridLayout(4, 2));
	
		// Create labels and text fields for the username and password
		JLabel custId = new JLabel("Enter CustomerId:");
		JTextField custIdField = new JTextField();

		JLabel name = new JLabel("Enter your Name:");
		JTextField nameField = new JTextField();

        JLabel DOB = new JLabel("Enter your Date of birth:");
        JTextField DOBField = new JTextField();

        JLabel email = new JLabel("Enter your Email:");
        JTextField emailField = new JTextField();

        JLabel phoneNum = new JLabel("Enter your Phone Number");
        JTextField phoneNumField = new JTextField();


		//might encrypt down the line
		JLabel password = new JLabel("Enter a secure password");
		JPasswordField passfield = new JPasswordField();

	
		// Create a login button and a cancel button

		JButton signUp = new JButton("Sign up !");
		JButton cancelButton = new JButton("Cancel");
        
	
		// Add the labels, text fields, and buttons to the frame
		frame.add(custId);
		frame.add(custIdField);
		frame.add(name);
		frame.add(nameField);
        frame.add(DOB);
        frame.add(DOBField);
        frame.add(email);
        frame.add(emailField);
        frame.add(phoneNum);
        frame.add(phoneNumField);
		frame.add(password);
		frame.add(passfield);



		frame.add(signUp);
        frame.add(cancelButton);
	
		// Make the frame visible
		frame.setVisible(true);
		


		String myUrl = "jdbc:mysql://localhost/project";
	
		try {
		
			Connection conn = DriverManager.getConnection(myUrl, "root", "");

			JOptionPane.showMessageDialog(null, conn);
			

			String sql = "INSERT INTO customer (CustomerId, Name, DateOfBirth, Email, PhoneNumber, Password) VALUES(?,?,?,?,?,?)";
			
			conn.prepareStatement(sql);
			signUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// code to be executed when button is clicked
					String buttonLabel = e.getActionCommand();

					if(buttonLabel.equals("Sign up !")) {

						PreparedStatement preparedStmt;
						try {
							preparedStmt = conn.prepareStatement(sql);


							try {
							} 
							catch (NumberFormatException NumberFormatException) {
								
							} catch (Exception e2) {
								
							}
							
						

							String CustomerId = custIdField.getText();
							if(CustomerId.length() != 5) {
								JOptionPane.showMessageDialog(null, "CustomerId must be a 5-digit number");
								JOptionPane.showMessageDialog(null, "Try again");
								custIdField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							else {
								custIdField.setBackground(null);
							}
							
						
							String name = nameField.getText();
							if (!Character.isUpperCase(name.charAt(0))) {
								JOptionPane.showMessageDialog(null, "Name must start with a capital letter");
								JOptionPane.showMessageDialog(null, "Try again");
								nameField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							Pattern pattern = Pattern.compile("^[A-Za-z]{2,}(\\s+[A-Za-z]{2,})*$");
							boolean isValid = pattern.matcher(name).matches();
							if (isValid) {
								nameField.setBackground(null);
							} 	
							

							
							
							
							
							String DOB = DOBField.getText();

							if (DOB.matches("^(0?[1-9]|[1-2][0-9]|3[0-1])-(0?[1-9]|1[0-2])-(19|20)[0-9]{2}$")) {
								JOptionPane.showMessageDialog(null, "Date Of Birth is perfect!");
								DOBField.setBackground(null);
							} else {
								JOptionPane.showMessageDialog(null, "Date Of Birth must be in the format DD-MM-YYYY!");
								JOptionPane.showMessageDialog(null, "Try again");
								DOBField.setBackground(java.awt.Color.PINK);
								return;
							}
						
							
							
							

							String email = emailField.getText();

							if(!Pattern.matches("^[a-zA-Z0-9]+@{1}[a-zA-Z0-9]+[.]{1}[a-zA-Z0-9]+$", email)) {
								JOptionPane.showMessageDialog(null, "Enter a valid email", "Error", JOptionPane.ERROR_MESSAGE);
								JOptionPane.showMessageDialog(null, "Try again");
								emailField.setBackground(java.awt.Color.PINK);
								return;
							}
							else {
								JOptionPane.showMessageDialog(null, "Email format is perfect", "Good!", JOptionPane.INFORMATION_MESSAGE);
								emailField.setBackground(java.awt.Color.GREEN);
							}

					

						

							String phoneNumber = phoneNumField.getText();
							if (phoneNumber.length() != 10) {
								// The phone number should be 10 digits long
								JOptionPane.showMessageDialog(null, "Please enter a 10-digit phone number");
								JOptionPane.showMessageDialog(null, "Try again");
								phoneNumField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}

							char[] password = passfield.getPassword();
							if(password.length > 10) {
								JOptionPane.showMessageDialog(null, "Password cannot be more than 10 values long !");
								JOptionPane.showMessageDialog(null, "Try again");
								passfield.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statementd
							}

							if(password.length < 10) {
								JOptionPane.showMessageDialog(null, "Password must be 10 characters long !");
								JOptionPane.showMessageDialog(null, "Try again");
								passfield.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statementd
							}

							else {
							// Otherwise, the phone number is valid, so set it as a parameter and execute the statement
							preparedStmt.setObject(1, custIdField.getText()); // number
							preparedStmt.setObject(2, nameField.getText()); // max lengtt is 35
							preparedStmt.setObject(3, DOBField.getText()); // number
							preparedStmt.setObject(4, emailField.getText()); // max lenght is 60
							preparedStmt.setObject(5, phoneNumber);
							preparedStmt.setObject(6, passfield.getText());
							
							custIdField.setBackground(null);
							nameField.setBackground(null);
							DOBField.setBackground(null);
							phoneNumField.setBackground(null);
							passfield.setBackground(null);
							
							preparedStmt.execute();
							}
						
						}	catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "You are Signed up");
					}
				}
			});


		
			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					Container parent = cancelButton.getParent();

					while (!(parent instanceof JFrame)) {
						parent = parent.getParent();
					}
					JFrame frame = (JFrame) parent;
					frame.dispose();
				}
			});
			}
		
			

				catch(SQLException sqlException){
					sqlException.printStackTrace();
					}
					finally {
					try {
						//preparedStmt.close();
						//conn.close();
					}
					catch(Exception exception) {
						exception.printStackTrace();
						}
					}
				}


			}

