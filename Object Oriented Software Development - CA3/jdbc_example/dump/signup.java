import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class signup extends InsertCustomerCLI {

		public static final JButton b = null;

		public signup(String title) {
		    // Set title, layout, and background colour
		    super(title);
		    setLayout(new FlowLayout());
		    getContentPane().setBackground(Color.gray);
		
		    // Create button listener
		    ButtonListener listener = new ButtonListener();
		
			JButton b = new JButton("Sign up!");
		    add(b);
		    b.addActionListener(listener);
		

		    // Attach window listener
		    addWindowListener(new WindowCloser());
		}//end constructor
		



		class ButtonListener implements ActionListener {
			public void signup(ActionEvent evt) {
				Color currentBackground =  getContentPane().getBackground();
		 		String buttonLabel = evt.getActionCommand();

				if(buttonLabel.equals("Sign up!")) {
					getContentPane().setBackground(Color.BLUE);

					/* 
					JLabel label = new JLabel("This is the sign up page");
					JOptionPane button = new JOptionPane("This is a button");
					add(button);

					add(label);

					*/

					labelAndButtons();
				}

				


				}

				

			public void setBackground(Color darkGray) {
			}


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		}


		// Listener for window
		class WindowCloser extends WindowAdapter {
			public void windowClosing(WindowEvent evt) {
		 		System.exit(0);
			}
		}

		
        public void signup(ActionEvent evt) {
			

        }


		public void labelAndButtons() {
			
			// database URL
			final String DATABASE_URL = "jdbc:mysql://localhost/customer";
			Connection connection = null;
			PreparedStatement pstat = null;



			// Create a new JFrame
			JFrame frame = new JFrame("Sign up !");
		
			// Set the size of the frame
			frame.setSize(280, 125);
		
			// Set the default close operation
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
			// Set the layout of the frame to a grid layout
			
			//frame.setLayout(new GridLayout(4, 2));
		
			// Create labels and text fields for the username and password
			JLabel custId = new JLabel("Enter CustomerId:");
			JTextField custIdField = new JTextField();

			JLabel name = new JLabel("Enter your name:");
			JPasswordField nameField = new JPasswordField();

			JLabel DOB = new JLabel("Enter your Date of birth:");
			JTextField DOBField = new JTextField();

			JLabel email = new JLabel("Enter your Email:");
			JTextField emailField = new JTextField();

			JLabel phoneNum = new JLabel("Enter your Phone Number");
			JTextField phoneNumField = new JTextField();


			//might encrypt down the line
			JLabel password = new JLabel("Enter a secure password");
			JTextField passfield = new JTextField();


		
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
			//frame.add(cancelButton);
		
			// Make the frame visible
			frame.setVisible(true);


			/* 
			JFrame frame = new JFrame();
			frame.setSize(200, 1000);
			//setBackground(Color.PINK);

			frame = new JFrame("This is the sign up page !");


			JButton button = new JButton( "Enter CustomerId");
			add(button);
			String custId = JOptionPane.showInputDialog( "Enter CustomerId") ;
			String name = JOptionPane.showInputDialog( "Enter your name");
			String DOB = JOptionPane.showInputDialog("Enter your Date of birth");
			

			int custIdNumber = Integer.parseInt(custId); // validates itself
			int DOBNumber = Integer.parseInt(DOB);

			//JOptionPane.showMessageDialog(null, "You were born on " + DOBNumber);
			

			/* 
			if(DOBNumber == 1) {
				JOptionPane.showMessageDialog(null, "You were born in January !");				
			}
			
			if(DOBNumber == 2) {
				JOptionPane.showMessageDialog(null, "You were born in February !");				
			}

			if(DOBNumber == 3) {
				JOptionPane.showMessageDialog(null, "You were born in March !");				
			}

			if(DOBNumber == 4) {
				JOptionPane.showMessageDialog(null, "You were born in April !");				
			}

			if(DOBNumber == 5) {
				JOptionPane.showMessageDialog(null, "You were born in May !");		
			}

			if(DOBNumber == 6) {
				JOptionPane.showMessageDialog(null, "You were born in June !");		
			}

			if(DOBNumber == 7) {
				JOptionPane.showMessageDialog(null, "You were born in July !");		
			}
				
			if(DOBNumber == 8) {
				JOptionPane.showMessageDialog(null, "You were born in August !");		
			}

			if(DOBNumber == 9) {
				JOptionPane.showMessageDialog(null, "You were born in September !");		
			}

			if(DOBNumber == 10) {
				JOptionPane.showMessageDialog(null, "You were born in October !");		
			}

			if(DOBNumber == 11) {
				JOptionPane.showMessageDialog(null, "You were born in November !");		
			}

			if(DOBNumber == 12) {
				JOptionPane.showMessageDialog(null, "You were born in December !");		
			}

			if(DOBNumber != 1 && DOBNumber != 2 && DOBNumber != 3 && DOBNumber != 4 && DOBNumber != 5 && DOBNumber != 6 && DOBNumber != 7 && DOBNumber != 8 && DOBNumber != 9 && DOBNumber != 10 && DOBNumber != 11 && DOBNumber != 12) {
				JOptionPane.showMessageDialog(null, "Invalid number entered !");		
			}
			
			


			String email = JOptionPane.showInputDialog("Enter your Email");
			String phoneNumber = JOptionPane.showInputDialog("Enter your Phone Number");

			String password = JOptionPane.showInputDialog("Enter a secure password");

			//	int phoneNumber_Num = Integer.parseInt(phoneNumber);		will validate down the line

			*/


			int i = 0;

			try {
			// establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL, "root","");
			// create Prepared Statement for inserting data into table
			pstat = connection.prepareStatement("INSERT INTO Customer (CustomerId, Name, DateOfBirth, Email, PhoneNumber, Password) VALUES (?,?,?,?,?,?)");
			pstat.setString(1, custId.toString());
			pstat.setString(2, name.toString());
			pstat.setString(3, DOB.toString());
			pstat.setString(4, email.toString());
			pstat.setString(5, phoneNum.toString());
			pstat.setString(6, password.toString());
			
			i = pstat.executeUpdate();

			JOptionPane.showInputDialog(null, "You are signed up and ready to go !");
			
			/* 
			//Valadating

			if(custId == null && name == null && DOB == null && email == null && phoneNumber == null) {
				if(DOBNumber != 1 && DOBNumber != 2 && DOBNumber != 3 && DOBNumber != 4 && DOBNumber != 5 && DOBNumber != 6 && DOBNumber != 7 && DOBNumber != 8 && DOBNumber != 9 && DOBNumber != 10 && DOBNumber != 11 && DOBNumber != 12) {
					JOptionPane.showMessageDialog(null, "Invalid number entered !");		
					//i = 0;
					pstat.setString(3, DOB);
					
					System.out.println(null + " Information not added to table !");
				}
			} 
			else {
				if(i != 0) {
					System.out.println(i + " record successfully added to the table !");
				}
			}
			*/
			
			}

			catch(SQLException sqlException){
				JOptionPane.showInputDialog(null, sqlException);
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
