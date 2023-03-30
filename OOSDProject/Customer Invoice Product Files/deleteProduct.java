import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java . sql .SQLException;

import javax.swing.JOptionPane;

public class deleteProduct {

    /**
     * Here you are able to delete a product from the product table
     * @param args
     */

public static void main(String [] args) {
// database URL
final String DATABASE_URL = "jdbc:mysql://localhost/project";
Connection connection = null;
PreparedStatement pstat = null;

int i = 0;


String productId = JOptionPane.showInputDialog( "Enter ProductId that you want to remove");

int productIdDelete = Integer.parseInt(productId);

int ProductId = productIdDelete;

if(productIdDelete == ProductId) {

    try{
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
        
        // create Prepared Statement for deleting data from the table
        pstat = connection.prepareStatement("Delete From product Where ProductId=?");
        pstat.setInt(1, ProductId);
    
        // delete data from the table
        i = pstat.executeUpdate();

        JOptionPane.showMessageDialog(null, i + " Product has been removed from the product table !");
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

