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
import javax.swing.JTextField;


public class updateingInvoice {

    /**
     * Here you are able to update an invoice
     * @param args
     */

public static void main(String [] args) {

    JFrame frame = new JFrame("Update Invoice Table!");
        
    // Set the size of the frame
    frame.setSize(1200, 200);

    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the layout of the frame to a grid layout
    frame.setLayout(new GridLayout(4, 2));
	
        
    JLabel invoice = new JLabel("Enter a InvoiceId that you want to update");
    JTextField invoiceField = new JTextField();

    JLabel companyName = new JLabel("Enter a CompanyName that you want to update");
    JTextField companyNameField = new JTextField();

    JLabel address = new JLabel("Enter a Address that you want to update");
    JTextField addressField = new JTextField();

    JLabel phoneNum = new JLabel("Enter a Phone Number that you want to update");
    JTextField phoneNumField = new JTextField();

    JLabel email = new JLabel("Enter a Email that you want to update");
    JTextField emailField = new JTextField();

    JLabel Description = new JLabel("Enter a Description that you want to update");
    JTextField DescriptionField = new JTextField();

    JLabel date = new JLabel("Enter a date that you want to update");
    JTextField dateField = new JTextField();


   
    JButton invoiceButton = new JButton("Update Invoice");
    JButton cancelButton = new JButton("Cancel");



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
  

        try{

            invoiceButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    try {
                        
                        String myUrl = "jdbc:mysql://localhost/project";

                        Connection conn = DriverManager.getConnection(myUrl, "root", "");

                        String sql = "UPDATE invoice SET CompanyName = ?, Address = ?, PhoneNumber = ?, Email = ?, Description = ?, Date = ? WHERE InvoiceId = ?";
                        

                        PreparedStatement pstmt = conn.prepareStatement(sql);

                        try {
                       
                        String comName = companyNameField.getText();
                        if (!Character.isUpperCase(comName.charAt(0))) {
                            JOptionPane.showMessageDialog(null, "Company Name must start with a capital letter");
                            JOptionPane.showMessageDialog(null, "Try again");
                            companyNameField.setBackground(java.awt.Color.PINK);
                            return; // Don't execute the prepared statement
                        }
                        Pattern pattern = Pattern.compile("^[A-Za-z]{2,}(\\s+[A-Za-z]{2,})*$");
                        boolean isValid = pattern.matcher(comName).matches();
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
                



                        
                        String invoiceId = invoiceField.getText();
                        if(invoiceId.length() != 5) {
                            JOptionPane.showMessageDialog(null, "InvoiceId must be a 5-digit number");
                            JOptionPane.showMessageDialog(null, "Try again");
                            invoiceField.setBackground(java.awt.Color.PINK);
                            return; // Don't execute the prepared statement
                        }



                        else {
                        pstmt.setString(1, comName);
                        pstmt.setString(2, address);
                        pstmt.setString(3, phoneNumber);
                        pstmt.setString(4, email);
                        pstmt.setString(5, description);
                        pstmt.setString(6, date);
                        pstmt.setString(7, invoiceId);
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
           

    






    