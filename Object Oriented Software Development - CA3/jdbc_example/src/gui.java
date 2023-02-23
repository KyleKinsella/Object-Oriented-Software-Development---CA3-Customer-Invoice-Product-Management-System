import java.awt.event.*;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class gui extends JFrame {


		public static final JButton b = null;

		public gui(String title) {
		    // Set title, layout, and background colour
		    super(title);
		    setLayout(new FlowLayout());
		    getContentPane().setBackground(Color.gray);
		
		    // Create button listener
		    ButtonListener listener = new ButtonListener();
		
		    
			JButton b = new JButton("Sign up!");
		    add(b);
		    b.addActionListener(listener);
			setBackground(Color.PINK);
		
		    // Add "Darker" button to frame and attach listener
		    b = new JButton("Login");
		    add(b);
		    b.addActionListener(listener);
			setBackground(Color.GREEN);
			
		    // Attach window listener
		    addWindowListener(new WindowCloser());
		}//end constructor
		


		
		// Listener for both buttons
		class ButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent evt) {
				Color currentBackground =  getContentPane().getBackground();
		 		String buttonLabel = evt.getActionCommand();


				if(buttonLabel.equals("Sign up!")) {
					getContentPane().setBackground(Color.BLUE);
					

					signupPage sign = new signupPage();

					sign.main(null);
				}

		
		
				if(buttonLabel.equals("Login")) {
					getContentPane().setBackground(Color.GREEN);
					

					login login = new login();

					login.main(null);
				}
				}
			public void setBackground(Color darkGray) {
			}
		}

		// Listener for window
		class WindowCloser extends WindowAdapter {
			public void windowClosing(WindowEvent evt) {
		 		System.exit(0);
			}
		}
}
