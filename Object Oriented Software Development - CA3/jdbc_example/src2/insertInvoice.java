import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;


public class insertInvoice {


    public static void main(String[] args) {
	
		// Create a new JFrame
		JFrame frame = new JFrame("Insert Invoice");
	
		// Set the size of the frame
		frame.setSize(900, 200);
	
		// Set the default close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Set the layout of the frame to a grid layout
		frame.setLayout(new GridLayout(5, 10));
	
		// Create labels and text fields for the username and password
		JLabel invoice = new JLabel("Enter InvoiceId:");
		JTextField invoiceField = new JTextField();

		JLabel companyName = new JLabel("Enter your Company name:");
		JTextField companyNameField = new JTextField();

        JLabel address = new JLabel("Enter your Address:");
        JTextField addressField = new JTextField();

        JLabel phoneNum = new JLabel("Enter your Phone Number");
        JTextField phoneNumField = new JTextField();

	
        JLabel email = new JLabel("Enter your Email:");
        JTextField emailField = new JTextField();

        JLabel Description = new JLabel("Enter your Description:");
        JTextField DescriptionField = new JTextField();

    	JLabel date = new JLabel("Enter the date:");
        JTextField dateField = new JTextField();

	
		// Create a login button and a cancel button

		JButton invoiceButton = new JButton("Insert Invoice");
		JButton cancelButton = new JButton("Cancel");
        

	
	
		// Add the labels, text fields, and buttons to the frame
		frame.add(invoice);
		frame.add(invoiceField);
		frame.add(companyName);
		frame.add(companyNameField);
        frame.add(address);
        frame.add(addressField);
        frame.add(phoneNum);
        frame.add(phoneNumField);
        frame.add(email);
        frame.add(emailField);
        frame.add(Description);
        frame.add(DescriptionField);
		frame.add(date);
		frame.add(dateField);



		frame.add(invoiceButton);
        frame.add(cancelButton);
		//frame.add(cancelButton);
	
		// Make the frame visible
		frame.setVisible(true);
		
		
		String myUrl = "jdbc:mysql://localhost/project";
	
 		
		try {
		
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			

			String sql = "INSERT INTO invoice (InvoiceId, CompanyName, Address, PhoneNumber, Email,  Description, Date) VALUES(?,?,?,?,?,?,?)";
			
			conn.prepareStatement(sql);
			invoiceButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// code to be executed when button is clicked
					String buttonLabel = e.getActionCommand();

					if(buttonLabel.equals("Insert Invoice")) {

						PreparedStatement preparedStmt;
						try {
							preparedStmt = conn.prepareStatement(sql);


							try {
							} 
							catch (NumberFormatException NumberFormatException) {
								
							} catch (Exception e2) {
								
							}
							
							


							String invoiceId = invoiceField.getText();
							if(invoiceId.length() != 5) {
								JOptionPane.showMessageDialog(null, "InvoiceId must be a 5-digit number");
								JOptionPane.showMessageDialog(null, "Try again");
								invoiceField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							
						
							String companyName = companyNameField.getText();
							if (!Character.isUpperCase(companyName.charAt(0))) {
								JOptionPane.showMessageDialog(null, "Company Name must start with a capital letter");
								JOptionPane.showMessageDialog(null, "Try again");
								companyNameField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							Pattern pattern = Pattern.compile("^[A-Za-z]{2,}(\\s+[A-Za-z]{2,})*$");
							boolean isValid = pattern.matcher(companyName).matches();
							if (isValid) {
								companyNameField.setBackground(null);
							} 	
							

							
							
							
							
							String address = addressField.getText();
							if (!Character.isUpperCase(address.charAt(0))) {
								JOptionPane.showMessageDialog(null, "Address must start with a capital letter");
								JOptionPane.showMessageDialog(null, "Try again");
								addressField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							Pattern pattern2 = Pattern.compile("^[A-Za-z]{2,}(\\s+[A-Za-z]{2,})*$");
							boolean isValid2 = pattern2.matcher(address).matches();
							if (isValid2) {
								addressField.setBackground(null);
							} 	


						
							String phoneNumber = phoneNumField.getText();
							if (phoneNumber.length() != 10) {
								// The phone number should be 10 digits long
								JOptionPane.showMessageDialog(null, "Please enter a 10-digit phone number");
								JOptionPane.showMessageDialog(null, "Try again");
								phoneNumField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
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
					

						

						
						



							

							String description = DescriptionField.getText();
							if (!Character.isUpperCase(description.charAt(0))) {
								JOptionPane.showMessageDialog(null, "Description must start with a capital letter");
								JOptionPane.showMessageDialog(null, "Try again");
								DescriptionField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							Pattern pattern3 = Pattern.compile("^[A-Za-z]{2,}(\\s+[A-Za-z]{2,})*$");
							boolean isValid3 = pattern3.matcher(description).matches();
							if (isValid3) {
								DescriptionField.setBackground(null);
							} 





							String date = dateField.getText();

							if (date.matches("^(0?[1-9]|[1-2][0-9]|3[0-1])-(0?[1-9]|1[0-2])-(19|20)[0-9]{2}$")) {
								JOptionPane.showMessageDialog(null, "Date Of Birth is perfect!");
								dateField.setBackground(null);
							} 

							if(!date.matches("^(0?[1-9]|[1-2][0-9]|3[0-1])-(0?[1-9]|1[0-2])-(19|20)[0-9]{2}$")) {
								JOptionPane.showMessageDialog(null, "Date must be in the format DD-MM-YYYY!");
								JOptionPane.showMessageDialog(null, "Try again");
								dateField.setBackground(java.awt.Color.PINK);
								return;
							}

							else {
							//Otherwise, the phone number is valid, so set it as a parameter and execute the statement
							preparedStmt.setObject(1, invoiceField.getText());
							preparedStmt.setObject(2, companyNameField.getText());
							preparedStmt.setObject(3, addressField.getText());
						    preparedStmt.setObject(4, phoneNumField.getText());
							preparedStmt.setObject(5, emailField.getText());
                            preparedStmt.setObject(6, DescriptionField.getText());
                            preparedStmt.setObject(7, dateField.getText());

							invoiceField.setBackground(null);
							companyNameField.setBackground(null);
							addressField.setBackground(null);
							phoneNumField.setBackground(null);
							emailField.setBackground(null);
							DescriptionField.setBackground(null);
							dateField.setBackground(null);

							preparedStmt.execute();
							}
						
						}	catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "Invoice has been inserted to the invoice table !");
					}
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

