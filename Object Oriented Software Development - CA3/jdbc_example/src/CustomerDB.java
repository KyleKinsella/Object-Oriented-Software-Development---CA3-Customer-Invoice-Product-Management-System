import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CustomerDB extends JFrame implements ActionListener {

    // GUI components
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JTextArea textArea;

    // Database connection
    private Connection connection;

    // Constructor
    public CustomerDB() {
        // JTextField t1 = new JTextField(5);
        // t1.setPreferredSize(new Dimension(125,80));      
        // Set up GUI components
        label = new JLabel("Enter SQL query:");
        textField = new JTextField(20);
        textField.setPreferredSize(new Dimension(125, 30));
        button = new JButton("Run Query");
        button.addActionListener(this);
        textArea = new JTextArea(10, 20);

        // Add components to JFrame
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Connect to database
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String myUrl = "jdbc:mysql://localhost/project";
            connection = DriverManager.getConnection(myUrl, "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Set JFrame properties
        setTitle("Displaying Query Results");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent event) {
        try {
            // Execute SQL query
            String query = textField.getText();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
    
            // Display column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            StringBuilder columnNames = new StringBuilder();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                columnNames.append(columnName).append("\t");
            }
            textArea.setText(columnNames.toString() + "\n");
    
            // Display results in JTextArea
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    Object value = resultSet.getObject(i);
                    textArea.append(value.toString() + "\t");
                }
                textArea.append("\n");
            }
    
            // Close database resources
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        CustomerDB db = new CustomerDB();
    }
}