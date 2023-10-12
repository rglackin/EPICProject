package project;
import javax.swing.*;
import java.awt.event.*;
public class LoginScreen {
    private String usernameInput,passwordInput;
    
    public String getUsernameInput(){return usernameInput;}
    public String getPassInput(){return passwordInput;}
    public LoginScreen(){
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame= new JFrame("Login"); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
         
        JLabel lblUser = new JLabel("Username: ");
        JTextField txtUser = new JTextField("", 15);
        JLabel lblPass = new JLabel("Password: ");
        JTextField txtPass = new JTextField("", 15);
        JButton btnLogin = new JButton("Login", null);
        //text.setBounds(200, 200,400,500);;
        panel.setSize(300, 300);
        panel.setLayout(layout);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);   
        panel.add(btnLogin);
        
        // Put constraint on components
        //USERNAME CONTROLS
        layout.putConstraint(SpringLayout.WEST, lblUser, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblUser, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtUser, 5, SpringLayout.EAST, lblUser);
        layout.putConstraint(SpringLayout.NORTH, txtUser, 50, SpringLayout.NORTH, panel);
        //PASSWORD CONTROLS       
        layout.putConstraint(SpringLayout.WEST, lblPass, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblPass, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtPass, 5, SpringLayout.EAST, lblPass);
        layout.putConstraint(SpringLayout.NORTH, txtPass, 80, SpringLayout.NORTH, panel);
        //LOGIN BUTTON CONTROLS
        layout.putConstraint(SpringLayout.WEST, btnLogin, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnLogin, 105, SpringLayout.NORTH, panel);
        frame.add(panel);
        frame.pack();
        frame.setSize(500, 500); 
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                usernameInput = txtUser.toString();
                passwordInput = txtPass.toString();
                if(!usernameInput.contains(" ")||!passwordInput.contains(" ")||!usernameInput.isBlank()||!passwordInput.isBlank()){
                
                }
            }
        });
        
        frame.setVisible(true); 
        
    }
    //@Override
    
    }

