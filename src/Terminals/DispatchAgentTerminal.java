package Terminals;
import Logic.DispatchAgent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DispatchAgentTerminal extends JFrame implements ActionListener{
    DispatchAgent currentAgent;
    JMenuBar mbar;
    JMenu menu;
    JMenuItem newOrder;
    
    public DispatchAgentTerminal(DispatchAgent currentAgent){
        this.currentAgent = currentAgent;
        setTitle(currentAgent.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 300);
        
        mbar = new JMenuBar();
        setJMenuBar(mbar);
        menu = new JMenu(); 
        menu.setText("Order");
        mbar.add(menu);
        newOrder = new JMenuItem();
        newOrder.setText("New Order..");
        menu.add(newOrder);
        newOrder.addActionListener(this);
        
    }

    public class AddOrderDialog extends JDialog implements ActionListener{
        
        JTextField orgin,destination,dateTime,userId;
        JButton addOrder;
        JLabel orginL,destinationL,scheduledL,userIdL,addOrderL;
        JRadioButton immediate,scheduled,auto,manual;
        ButtonGroup scheduleTime,autoManual;
        
        public AddOrderDialog(){
            setTitle("Add Order");
            setSize(300,300);
            userId = new JTextField(10);
            orgin = new JTextField(10);
            destination = new JTextField(10);
            dateTime = new JTextField(25);
            addOrderL = new JLabel("Add Order..");
            addOrderL.setFont(new Font("Serif", Font.BOLD, 16));
            userIdL = new JLabel("User ID: ");
            addOrder = new JButton("Add Order");
            orginL = new JLabel("Orgin: ");
            destinationL = new JLabel("Destination: ");
            immediate = new JRadioButton("Immediate");
            scheduled = new JRadioButton("Scheduled");
            scheduleTime = new ButtonGroup();
            scheduleTime.add(immediate);
            scheduleTime.add(scheduled);
            auto = new JRadioButton("auto");
            manual = new JRadioButton("manual");
            autoManual = new ButtonGroup();
            autoManual.add(auto);
            autoManual.add(manual);
            
            scheduledL = new JLabel("Scheduled Time :");

            setLayout(null);
                add(addOrderL);
                addOrderL.setBounds(10,10,100,20);
                add(userId);
                userId.setBounds(140, 40, 120, 20);
                add(userIdL);
                userIdL.setBounds(10, 40, 60, 14);
                add(orgin);
                orgin.setBounds(140, 70, 120, 20);
                //orgin.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                add(destination);
                destination.setBounds(140, 100, 120, 20);
                //destination.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                add(orginL);
                orginL.setBounds(10, 70, 60, 14);
                add(destinationL);
                destinationL.setBounds(10, 100, 80, 14);
                add(immediate);
                immediate.setBounds(80, 130, 100, 14);
                immediate.addActionListener(this);
                add(scheduled);
                scheduled.setBounds(180, 130, 100, 14);
                scheduled.addActionListener(this);
                add(scheduledL);
                scheduledL.setBounds(20, 160, 100, 14);
                scheduledL.setEnabled(false);
                add(dateTime);
                dateTime.setBounds(140, 158, 120, 20);
                dateTime.setEnabled(false);
                add(auto);
                auto.setBounds(80, 190, 100, 14);
                auto.setEnabled(false);
                auto.addActionListener(this);
                add(manual);
                manual.setBounds(180, 190, 100, 14);
                manual.setEnabled(false);
                manual.addActionListener(this);
                add(addOrder);
                addOrder.setBounds(160, 220, 100, 23);
                addOrder.addActionListener(this);
        }
        
        
        @Override
        public void actionPerformed(ActionEvent ae) {
                if(ae.getSource().equals(addOrder)){
                    if(userId.getText().equals("") || orgin.getText().equals("") || destination.getText().equals("") || scheduleTime.getSelection()==null ){
                        // check for other fields upon scheduleTime selection
                            JOptionPane.showMessageDialog(this, "Some Fileds are empty!", "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        int confirmation = JOptionPane.showConfirmDialog (this, "Save Order?","Confirm",JOptionPane.YES_NO_OPTION);
                        if(confirmation == JOptionPane.YES_OPTION){
                            System.out.println("Adding order");
                            // need to modify with correct details
                            currentAgent.placeOrder(userId.getText(), orgin.getText(), destination.getText(), true, true, null);
                        }
                    }
                }
                else if(ae.getSource().equals(immediate)){
                    scheduledL.setEnabled(false);
                    dateTime.setEnabled(false);
                    auto.setEnabled(true);
                    manual.setEnabled(true);
                    System.out.println("Setting immediate");
                }
                else if(ae.getSource().equals(scheduled)){
                    dateTime.setEnabled(true);
                    scheduledL.setEnabled(true);
                    auto.setEnabled(false);
                    manual.setEnabled(false);
                }
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource().equals(newOrder)){
            System.out.println("Hello");
            AddOrderDialog aod = new AddOrderDialog();
            aod.setVisible(true);
        }
    }

}
