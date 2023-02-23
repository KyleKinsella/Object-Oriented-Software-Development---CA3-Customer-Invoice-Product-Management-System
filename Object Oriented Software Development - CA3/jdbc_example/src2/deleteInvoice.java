import java . sql .Connection;
import java . sql .DriverManager;
import java . sql .PreparedStatement;
import java . sql .SQLException;

import javax.swing.JOptionPane;

public class deleteInvoice {

public static void main(String [] args) {
// database URL
final String DATABASE_URL = "jdbc:mysql://localhost/project";
Connection connection = null;
PreparedStatement pstat = null;

int i = 0;


String invoiceId = JOptionPane.showInputDialog( "Enter InvoiceId that you want to remove");

int invoiceIdDelete = Integer.parseInt(invoiceId);

int InvoiceId = invoiceIdDelete;

if(invoiceIdDelete == InvoiceId) {

    try{
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "");
        // create Prepared Statement for deleting data from the table
        pstat = connection.prepareStatement("Delete From invoice Where InvoiceId=?");
        pstat.setInt(1, InvoiceId);
    
        // delete data from the table
        i = pstat.executeUpdate();

        JOptionPane.showMessageDialog(null, i + " Invoice has been removed from the invoice table !");
        //System.out.println(i + " record successfully removed from the table ! ");


        /* 
        //validating

        if(custIdDelete != CustomerId) {
            JOptionPane.showMessageDialog(null, "The number you entered has already been removed previously");
        }
        else {
        System.out.println(i + " record successfully removed from the table ! ");
        }
        */
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

