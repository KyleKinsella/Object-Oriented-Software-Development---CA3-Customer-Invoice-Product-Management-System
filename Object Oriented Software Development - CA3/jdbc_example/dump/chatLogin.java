import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class chatLogin extends JFrame {
    
public static void main(String[] args) {
    
        // Create a new JFrame
        JFrame frame = new JFrame("Login !");

        // Set the size of the frame
        frame.setSize(325, 142);

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout of the frame to a grid layout


        // Create labels and text fields for the username and password
        //auth(null, null);
        JLabel email = new JLabel("Email: ");
        JTextField emailLabel = new JTextField();
        JLabel password = new JLabel("Password:");
        JPasswordField passwordLabel = new JPasswordField();

        JButton loginButton = new JButton("Login");
    

        frame.add(email);
        frame.add(emailLabel);
        frame.add(password);
        frame.add(passwordLabel);
        frame.add(loginButton);

        frame.setVisible(true);
    }
}
