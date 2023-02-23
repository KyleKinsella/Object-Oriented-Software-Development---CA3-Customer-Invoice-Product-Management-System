import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class testHelp {



    private static final String EXIT_ON_CLOSE = null;




    public testHelp() {

        initUI();
    
    }



    
    private void initUI() {

        JButton quitButton = new JButton("Quit");
        JButton button1 = new JButton("button1");
        JButton button2 = new JButton("button2");
        JButton button3 = new JButton("button3");
        JPanel panel = new JPanel();
    
        quitButton.addActionListener(new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    
        button1.addActionListener(new ActionListener() {
    
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    
        getContentPane().add(panel);
    
        panel.add(quitButton);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
    
        setTitle("example");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void setDefaultCloseOperation(String exitOnClose) {
    }




    private void setLocationRelativeTo(Object object) {
    }




    private void setSize(int i, int j) {
    }




    private void setTitle(String string) {
    }




    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );
    }

    private Container getContentPane() {
        return null;
    }




    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                testHelp ex = new testHelp();
                ex.setVisible(true);
            }
        });
    }




    protected void setVisible(boolean b) {
    }

}





