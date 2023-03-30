import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class innerJoin {

    /**
     * Here you are able to inner join two tables together
     * @param args
     * @throws SQLException
     */

    public static void main(String[] args) throws SQLException {

        String myUrl = "jdbc:mysql://localhost/project";

        Connection conn = DriverManager.getConnection(myUrl, "root", "");

        String query = "SELECT * FROM Customer INNER JOIN Invoice ON customer.DateOfBirth = invoice.Date";
        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();

        String result = "";
        while (rs.next()) {
            int customerId = rs.getInt("CustomerId");
            String customerName = rs.getString("Name");
            int invoiceId = rs.getInt("InvoiceId");

            result += "CustomerId: " + customerId + "\nCustomerName: " + customerName + "\nInvoiceId: " + invoiceId + "\n\n";
        }

        JOptionPane.showMessageDialog(null, result);
    }
}