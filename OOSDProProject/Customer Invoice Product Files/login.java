import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class login extends loginPage {

	/**
	 * This is my login system
	 * @param args
	 */

	public static void main(String[] args) {
	
		login login = new login();
		login.Auth();		
	}

	public void Auth() {
	
		// Create a new JFrame
		JFrame frame = new JFrame("Login !");
	
		// Set the size of the frame
		frame.setSize(350, 142);
	
		// Set the default close operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		// Set the layout of the frame to a grid layout
		frame.setLayout(new GridLayout(4, 2));
	
		// Create labels and text fields for the username and password
		//auth(null, null);
		JLabel email = new JLabel("Email: ");
		JTextField emailLabel = new JTextField();
		JLabel password = new JLabel("Password:");
		JPasswordField passwordLabel = new JPasswordField();

		JButton loginButton = new JButton("Login");
		JButton cancelButton = new JButton("Cancel");
        


		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				String email = emailLabel.getText();
				char[] password = passwordLabel.getPassword();

				try {

					String myUrl = "jdbc:mysql://localhost/project";

					Connection conn = DriverManager.getConnection(myUrl, "root", "");

					String sql = "SELECT * FROM customer WHERE Email='" + email + "' AND Password='" + new String(password) + "'";					//SELECT * FROM customer WHERE Email=? AND Password=?

					conn.prepareStatement(sql);

					PreparedStatement preparedStmt;
								
					preparedStmt = conn.prepareStatement(sql);

					ResultSet result = preparedStmt.executeQuery();



				
          			
					if(result.next()) {
						
						loginPage main = new loginPage();
						main.main(null);

						JOptionPane.showMessageDialog(null, "You are logged in !");
					}
					else {
						JOptionPane.showMessageDialog(null, "Login failed !");
					}
					conn.close();

				} 
				catch (Exception ex) {
					ex.printStackTrace();
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
	
		frame.add(email);
		frame.add(emailLabel);
		frame.add(password);
		frame.add(passwordLabel);
		frame.add(loginButton);
		frame.add(cancelButton);
	
		// Make the frame visible
		frame.setVisible(true);
	  }
	}

