import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class UpdateingCustomer {

    /**
     * Here you are able to update a customers details
     * @param args
     */
public static void main(String [] args) {

    JFrame frame = new JFrame("Update Customer Table!");
        
    // Set the size of the frame
    frame.setSize(1200, 200);

    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the layout of the frame to a grid layout
    frame.setLayout(new GridLayout(4, 2));
	

    JLabel custId = new JLabel("Enter a CustomerId that you want to update");
    JTextField custIdField = new JTextField();

    JLabel name = new JLabel("Enter a Name that you want to update");
    JTextField nameField = new JTextField();

    JLabel DOB = new JLabel("Enter a Date of birth that you want to update");
    JTextField DOBField = new JTextField();

    JLabel email = new JLabel("Enter a Email that you want to update");
    JTextField emailField = new JTextField();

    JLabel phoneNum = new JLabel("Enter a Phone number that you want to update");
    JTextField phoneNumField = new JTextField();

    JLabel password = new JLabel("Enter a secure password that you want to update");
    JPasswordField passfield = new JPasswordField();



    JButton updateButton = new JButton("Update Customer");
    JButton cancelButton = new JButton("Cancel");



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

    frame.add(updateButton);
    frame.add(cancelButton);


    // Make the frame visible
    frame.setVisible(true);


        try{
         
            updateButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    try {
                        
                        String myUrl = "jdbc:mysql://localhost/project";

                        Connection conn = DriverManager.getConnection(myUrl, "root", "");

                        String sql = "UPDATE customer SET Name = ?, DateOfBirth = ?, Email = ?, PhoneNumber = ?, Password = ? WHERE CustomerId = ?";
                        

                        PreparedStatement pstmt = conn.prepareStatement(sql);

                        try {
                    
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



                        String dateOfBirth = DOBField.getText();

                        if (dateOfBirth.matches("^(0?[1-9]|[1-2][0-9]|3[0-1])-(0?[1-9]|1[0-2])-(19|20)[0-9]{2}$")) {
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
                        String Password = new String(password);
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



                        
                        String CustomerId = custIdField.getText();
                        if(CustomerId.length() != 5) {
                            JOptionPane.showMessageDialog(null, "CustomerId must be a 5-digit number");
                            JOptionPane.showMessageDialog(null, "Try again");
                            custIdField.setBackground(java.awt.Color.PINK);
                            return; // Don't execute the prepared statement
                        }
                       


                        else {
                        pstmt.setString(1, name);
                        pstmt.setString(2, dateOfBirth);
                        pstmt.setString(3, email);
                        pstmt.setString(4, phoneNumber);
                        pstmt.setString(5, Password);
                        pstmt.setString(6, CustomerId);
                        
                        custIdField.setBackground(null);
                        nameField.setBackground(null);
                        DOBField.setBackground(null);
                        phoneNumField.setBackground(null);
                        passfield.setBackground(null);
                        }
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                
                    int result = pstmt.executeUpdate();

                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Record updated successfully");
                        } else {
                        JOptionPane.showMessageDialog(null, "Record not updated");
                        }
                
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
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
            finally {
            try{
            //preparedStmt.close();
            //conn.close();
            }
            catch (Exception exception) {
            exception.printStackTrace();
        }
        }
    } 
} 
           

    






    