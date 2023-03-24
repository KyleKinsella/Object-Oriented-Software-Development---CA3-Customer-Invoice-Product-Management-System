import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class loginPage extends JFrame {

    public static void main(String[] args) {
      
      JFrame frame = new JFrame("");

      frame.setTitle("You have logged in !");
      frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      frame.setSize(1900, 1050);
      frame.setVisible(true);

      JPanel panel = new JPanel();
      frame.add(panel);

      //  Call insert customer, invoice, product
      JButton b1 = new JButton("Insert");
      //JTextField f1 = new JTextField(10);
      panel.add(b1);
      //panel.add(f1);


      b1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          JLabel insertWhitespace = new JLabel("            ");
          panel.add(insertWhitespace);

          JButton insertInvoiceButton = new JButton("Insert Invoice");
          panel.add(insertInvoiceButton);

          insertInvoiceButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              
                insertInvoice insertInvoice = new insertInvoice();
                insertInvoice.main(args);
            }

          });

          JButton insertProductButton = new JButton("Insert Product");
          panel.add(insertProductButton);

          insertProductButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              
              insertProduct insertProduct = new insertProduct();
              insertProduct.main(args);
            }
            
          });

          JButton insertCustomerButton = new JButton("Insert Customer");
          panel.add(insertCustomerButton);

          insertCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              signupPage insertCustomer = new signupPage();
              insertCustomer.main(args);
            }
            
          });
        }
      });
        

      //  call delete customer, invoice, product
      JButton b2 = new JButton("Delete");
      //JTextField f2 = new JTextField(10);
      panel.add(b2);

      b2.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          // TODO Auto-generated method stub
          JLabel deleteWhitespace = new JLabel("            ");
          panel.add(deleteWhitespace);

          JButton deleteInvoiceButton = new JButton("Delete Invoice");
          panel.add(deleteInvoiceButton);
         
         

          deleteInvoiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              deleteInvoice deleteInvoice = new deleteInvoice();
              deleteInvoice.main(args); 
            }
          });

          JButton deleteProductButton = new JButton("Delete Product");
          panel.add(deleteProductButton); 

          deleteProductButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              deleteProduct deleteProduct = new deleteProduct();
              deleteProduct.main(args); 
            }
          });

          JButton deleteCustomerButton = new JButton("Delete Customer");
          panel.add(deleteCustomerButton);

          deleteCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              DeleteCustomer deleteCustomer = new DeleteCustomer();
              deleteCustomer.main(args);
            }
            
          });
        }
        
      });
      //panel.add(f2);
    
      //  call update customer, invoice, product
      JButton b3 = new JButton("Update");
      //JTextField f3 = new JTextField(10);
      panel.add(b3);
      //panel.add(f3);



      b3.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          JLabel updateWhitespace = new JLabel("            ");
          panel.add(updateWhitespace);

          // TODO Auto-generated method stub
          JButton updateInvoiceButton = new JButton("Update Invoice");
          panel.add(updateInvoiceButton);

          updateInvoiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              updateingInvoice updateInvoice = new updateingInvoice();
              updateInvoice.main(args);
            }
          });

          JButton updateProductButton = new JButton("Update Product");
          panel.add(updateProductButton);

          updateProductButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              updateingProduct updateProduct = new updateingProduct();
              updateProduct.main(args);
            }
          });
          
          JButton updateCustomerButton = new JButton("Update Customer");
          panel.add(updateCustomerButton);
          
          updateCustomerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              // TODO Auto-generated method stub
              UpdateingCustomer updateCustomer = new UpdateingCustomer();
              updateCustomer.main(args);
            }
            
          });
        }

      });

      //  call retrieve customer, invoice, product
      JButton b4 = new JButton("Retrieve");
      //JTextField f4 = new JTextField(10);
      panel.add(b4);
      //panel.add(f4);




      b4.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

          JLabel updateWhitespace = new JLabel("            ");
          panel.add(updateWhitespace);

          DB retrieve = new DB();
          retrieve.main(args);
            }
          });
    }
}
    