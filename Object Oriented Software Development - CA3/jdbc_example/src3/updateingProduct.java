import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class updateingProduct {
public static void main(String [] args) {

    JFrame frame = new JFrame("Update Product Table!");
        
    // Set the size of the frame
    frame.setSize(930, 260);

    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the layout of the frame to a grid layout
    frame.setLayout(new GridLayout(6, 6));
	

    JLabel product = new JLabel("Enter a ProductId that you want to update");
    JTextField productField = new JTextField();

    JLabel nameOfProduct = new JLabel("Enter name of product that you want to update");
    JTextField nameOfProductField = new JTextField();

    JLabel NumberOfProductsBought = new JLabel("Enter number of products bought that you want to update");
    JTextField numberOfProductsBoughtField = new JTextField();

    JLabel ColorOfProduct = new JLabel("Enter a color that you want to update");
    JTextField colorOfProductField = new JTextField();

    JLabel PriceOfProduct = new JLabel("Enter a price that you want to update");
    JTextField priceOfProductField = new JTextField();



   
    JButton productButton = new JButton("Update Product");
    JButton cancelButton = new JButton("Cancel");



    frame.add(product);
    frame.add(productField);

    frame.add(nameOfProduct);
    frame.add(nameOfProductField);

    frame.add(NumberOfProductsBought);
    frame.add(numberOfProductsBoughtField);


    frame.add(ColorOfProduct);
    frame.add(colorOfProductField);
    
    frame.add(PriceOfProduct);
    frame.add(priceOfProductField);


    frame.add(productButton);
    frame.add(cancelButton);
    //frame.add(cancelButton);

    // Make the frame visible
    frame.setVisible(true);
 

        try{

            productButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    
                    String myUrl = "jdbc:mysql://localhost/project";

                    Connection conn = DriverManager.getConnection(myUrl, "root", "");

                    String sql = "UPDATE product SET NameOfProduct = ?, NumberOfProductsBought = ?, ColorOfProduct = ?, PriceOfProduct = ? WHERE ProductId = ?";
                    

                    PreparedStatement pstmt = conn.prepareStatement(sql);

                    try {
                    
                    String name = nameOfProductField.getText();
                    if (!Character.isUpperCase(name.charAt(0))) {
                        JOptionPane.showMessageDialog(null, "Product name must start with a capital letter");
                        JOptionPane.showMessageDialog(null, "Try again");
                        nameOfProductField.setBackground(java.awt.Color.PINK);
                        return; // Don't execute the prepared statement
                    }


                    
                    String numberOfProductsBoughtStr =  numberOfProductsBoughtField.getText();
                    int numberOfProductsBought = Integer.parseInt(numberOfProductsBoughtStr);

                    if (numberOfProductsBought > 200) {
                        JOptionPane.showMessageDialog(null, "Sorry, you can't buy more than 200 products");
                        JOptionPane.showMessageDialog(null, "Try again");
                        numberOfProductsBoughtField.setBackground(java.awt.Color.PINK);
                        return; // Don't execute the prepared statement
                    }


                    String colorr = colorOfProductField.getText();

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



                    String productid = productField.getText();
                    if(productid.length() != 5) {
                        JOptionPane.showMessageDialog(null, "ProductId must be a 5-digit number");
                        JOptionPane.showMessageDialog(null, "Try again");
                        productField.setBackground(java.awt.Color.PINK);
                        return; // Don't execute the prepared statement
                    }


                    else {
                    pstmt.setString(1, name);
                    pstmt.setString(2, numberOfProductsBoughtStr);
                    pstmt.setString(3, colorr);
                    pstmt.setString(4, priceofproduct);
                    pstmt.setString(5, productid);
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
           

    






    