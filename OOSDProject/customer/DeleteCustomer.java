import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java . sql .SQLException;

import javax.swing.JOptionPane;

public class DeleteCustomer {

    /**
     * Here you are able to remove a customer from the customer table
     * @param args
     */


public static void main(String [] args) {
// database URL
final String DATABASE_URL = "jdbc:mysql://localhost/project";
Connection connection = null;
PreparedStatement pstat = null;

int i = 0;

String custId = JOptionPane.showInputDialog("Enter CustomerId that you want to remove");

int custIdDelete = Integer.parseInt(custId);

int CustomerId = custIdDelete;

if(custIdDelete == CustomerId) {

    try{
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
        // create Prepared Statement for deleting data from the table
        pstat = connection.prepareStatement("Delete From Customer Where CustomerId=?");
        pstat.setInt(1, CustomerId);
    
        // delete data from the table
        i = pstat.executeUpdate();

        JOptionPane.showMessageDialog(null, i + " Customer has been removed from the table !");
    }
    

    catch(SQLException sqlException ) {
        sqlException.printStackTrace();
        }
        finally {
        try{
        pstat.close();
        connection.close();
        }
        catch (Exception exception) {
        exception.printStackTrace(); 
        }
    }
    } // end main
}
};

