/* 


//Display the contents of the Authors table in the books database.
import java .awt.BorderLayout;
import java .awt.event . ActionListener ;
import java .awt.event .ActionEvent;
import java .awt.event .WindowAdapter;
import java .awt.event .WindowEvent;
import java . sql .SQLException;
import java . util . regex .PatternSyntaxException;
import javax .swing.JFrame;
import javax .swing.JTextArea;
import javax .swing. JScrollPane ;
import javax .swing.ScrollPaneConstants ;
import javax .swing.JTable;
import javax .swing.JOptionPane;
import javax .swing.JButton;
import javax .swing.Box;
import javax .swing.JLabel;
import javax .swing. JTextField ;
import javax .swing.RowFilter ;
import javax .swing. table .TableRowSorter;
import javax .swing. table .TableModel

public class DisplayQueryResults extends JFrame {
    static final String DATABASE_URL = "";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
    static final String DEFAULT QUERY = "SELECT * FROM Customer";
    
    private ResultSetTableModel tableModel;
    private JTextArea queryArea;

    public DisplayQueryResults() {
    super("Displaying Query Results");

    try {
    tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
    queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);
    queryArea.setWrapStyleWord(true);
    queryArea.setLineWrap(true);
    JScrollPane scrollPane = new JScrollPane( queryArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    JButton submitButton = new JButton("Submit Query");
    }

    Box boxNorth = Box.createHorizontalBox();
    boxNorth.add( scrollPane ) ;
    boxNorth.add( submitButton );
    JTable resultTable = new JTable( tableModel );
    JLabel filterLabel = new JLabel("Filter :");
    final JTextField filterText = new JTextField();
    JButton filterButton = new JButton("Apply Filter");
    Box boxSouth = Box.createHorizontalBox();
    boxSouth.add(filterLabel);
    boxSouth.add(filterText);
    boxSouth.add(filterButton);
    add(boxNorth, BorderLayout.NORTH );
    add(new JScrollPane( resultTable) , BorderLayout.CENTER );
    add(boxSouth, BorderLayout.SOUTH);
}

*/