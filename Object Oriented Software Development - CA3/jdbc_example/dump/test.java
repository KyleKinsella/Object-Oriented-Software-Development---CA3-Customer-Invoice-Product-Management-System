import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test {
  public static void main(String[] args) {
    // Create a new JFrame
    JFrame frame = new JFrame("Login !");

    // Set the size of the frame
    frame.setSize(280, 125);

    // Set the default close operation
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the layout of the frame to a grid layout
    frame.setLayout(new GridLayout(4, 2));

    // Create labels and text fields for the username and password
    JLabel usernameLabel = new JLabel("Username:");
    JTextField usernameField = new JTextField();
    JLabel passwordLabel = new JLabel("Password:");
    JPasswordField passwordField = new JPasswordField();

    // Create a login button and a cancel button
    JButton loginButton = new JButton("Login");
    //JButton cancelButton = new JButton("Cancel");

    // Add the labels, text fields, and buttons to the frame
    frame.add(usernameLabel);
    frame.add(usernameField);
    frame.add(passwordLabel);
    frame.add(passwordField);
    frame.add(loginButton);
    //frame.add(cancelButton);

    // Make the frame visible
    frame.setVisible(true);
  }
}




/*
 import javax.swing.*;
import java.awt.event.*;

public class help {
    private JFrame frame;
    private JTextField fahrenheitField;
    private JTextField celsiusField;

    public static void main(String[] args) {
        help converter = new help();
        converter.createUI();
    }

    private void createUI() {
        frame = new JFrame("Fahrenheit to Celsius Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 175);

        JPanel panel = new JPanel();
        frame.add(panel);

        JLabel fahrenheitLabel = new JLabel("Fahrenheit");
        panel.add(fahrenheitLabel);
       
        fahrenheitField = new JTextField(8);
        panel.add(fahrenheitField);

       
        JLabel celsiusLabel = new JLabel("Celsius");
        panel.add(celsiusLabel);

        celsiusField = new JTextField(15);
        celsiusField.setEditable(false);
        panel.add(celsiusField);

        

        fahrenheitField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String fahrenheitText = fahrenheitField.getText();
                double fahrenheit = Double.parseDouble(fahrenheitText);
                double celsius = (fahrenheit - 32) * (5.0 / 9.0);
                celsiusField.setText(Double.toString(celsius));
            }

            
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub

                String fahrenheitText = fahrenheitField.getText();
                double fahrenheit = Double.parseDouble(fahrenheitText);
                double celsius = (fahrenheit - 32) * (5.0 / 9.0);
                celsiusField.setText(Double.toString(celsius));
                
            }
        });

        frame.setVisible(true);
    }
}
 */