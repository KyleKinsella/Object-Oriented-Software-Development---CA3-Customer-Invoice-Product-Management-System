import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.*;


public class insertProduct {

	/**
	 * Here you are able to insert a product into the product table
	 * @param args
	 */

	  public static void main(String[] args) {

		// Create a new JFrame
		JFrame frame = new JFrame("Insert Product");
	
		// Set the size of the frame
		frame.setSize(900, 250);
	
		// Set the default close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Set the layout of the frame to a grid layout
		frame.setLayout(new GridLayout(6,7));
	
		// Create labels and text fields for the username and password
		JLabel productId = new JLabel("Enter ProductId:");
		JTextField productIdField = new JTextField();

		JLabel nameOfProduct = new JLabel("Enter name of product:");
		JTextField nameOfProductField = new JTextField();

        JLabel numOfProductsBought = new JLabel("Enter number of product's bought:");
        JTextField numOfProductsBoughtField = new JTextField();

        JLabel colorOfProduct = new JLabel("Enter color of product:");
        JTextField colorOfProductField = new JTextField();

        JLabel priceOfProduct = new JLabel("Enter price of product:");
        JTextField priceOfProductField = new JTextField();


		



	
		// Create a login button and a cancel button

		JButton productButton = new JButton("Insert Product");
		JButton cancelButton = new JButton("Cancel");
        

	
	
		// Add the labels, text fields, and buttons to the frame
		frame.add(productId);
		frame.add(productIdField);
		frame.add(nameOfProduct);
		frame.add(nameOfProductField);
        frame.add(numOfProductsBought);
        frame.add(numOfProductsBoughtField);
        frame.add(colorOfProduct);
        frame.add(colorOfProductField);
        frame.add(priceOfProduct);
        frame.add(priceOfProductField);


		frame.add(productButton);
        frame.add(cancelButton);
		//frame.add(cancelButton);
	
		// Make the frame visible
		frame.setVisible(true);
		
		
		String myUrl = "jdbc:mysql://localhost/project";
	
 		
		try {
		
			Connection conn = DriverManager.getConnection(myUrl, "root", "");
			

			String sql = "INSERT INTO product (ProductId, NameOfProduct, NumberOfProductsBought, ColorOfProduct, PriceOfProduct) VALUES(?,?,?,?,?)";
			
			conn.prepareStatement(sql);
			productButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// code to be executed when button is clicked
					String buttonLabel = e.getActionCommand();

					if(buttonLabel.equals("Insert Product")) {

						PreparedStatement preparedStmt;
						try {
							preparedStmt = conn.prepareStatement(sql);


							
							String productId = productIdField.getText();
							if(productId.length() != 5) {
								JOptionPane.showMessageDialog(null, "ProductId must be a 5-digit number");
								JOptionPane.showMessageDialog(null, "Try again");
								productIdField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}
							else {
								productIdField.setBackground(null);
							}


							String NameOfProduct = nameOfProductField.getText();
							if (!Character.isUpperCase(NameOfProduct.charAt(0))) {
								JOptionPane.showMessageDialog(null, "Product name must start with a capital letter");
								JOptionPane.showMessageDialog(null, "Try again");
								nameOfProductField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}

							String numberOfProductsBoughtStr = numOfProductsBoughtField.getText();
							int numberOfProductsBought = Integer.parseInt(numberOfProductsBoughtStr);

							if (numberOfProductsBought > 200) {
								JOptionPane.showMessageDialog(null, "Sorry, you can't buy more than 200 products");
								JOptionPane.showMessageDialog(null, "Try again");
								numOfProductsBoughtField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}



							String colorOfProduct = colorOfProductField.getText();
							String[] colors = {"Red", "orange", "yellow", "green", "blue", "indigo", "violet"};

							boolean foundMatch = false;
							for (String color : colors) {
								if (colorOfProduct.equalsIgnoreCase(color)) {
									foundMatch = true;
									break;
								}
							}
							if (!foundMatch) {
								JOptionPane.showMessageDialog(null, "That color is not in the list of colors, Please select a color from the list");
								colorOfProductField.setBackground(java.awt.Color.PINK);
								JOptionPane.showMessageDialog(null, colors);
							}


							String priceofproduct = priceOfProductField.getText();
							if (!Pattern.matches("[\\d.]+", priceofproduct)) {
								JOptionPane.showMessageDialog(null, "Price must be a number not a string !");
								JOptionPane.showMessageDialog(null, "Try again");
								priceOfProductField.setBackground(java.awt.Color.PINK);
								return; // Don't execute the prepared statement
							}


							else {
							preparedStmt.setObject(1, productIdField.getText());
							preparedStmt.setObject(2, nameOfProductField.getText());
							preparedStmt.setObject(3, numOfProductsBoughtField.getText());
							preparedStmt.setObject(4, colorOfProductField.getText());
							preparedStmt.setObject(5, priceOfProductField.getText());
							
							productIdField.setBackground(null);
							nameOfProductField.setBackground(null);
							numOfProductsBoughtField.setBackground(null);
							colorOfProductField.setBackground(null);
							priceOfProductField.setBackground(null);

							preparedStmt.execute();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
                        }
                        
						JOptionPane.showMessageDialog(null, "Product has been inserted to the product table !");
					
					}
				}
			});
				
			
				
			cancelButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
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