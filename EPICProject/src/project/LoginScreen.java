package project;

import javax.swing.*;
import java.awt.event.*;

public class LoginScreen implements ActionListener {
    private String usernameInput, passwordInput;
    static User u = new User();
    static JFrame frame = new JFrame("Login");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();

    JLabel lblUser = new JLabel("Username: ");
    JTextField txtUser = new JTextField("", 15);
    JLabel lblPass = new JLabel("Password: ");
    JTextField txtPass = new JTextField("", 15);
    JButton btnLogin = new JButton("Login", null);
    JButton btnRegister = new JButton("Register New User", null);

    // text.setBounds(200, 200,400,500);;
    public LoginScreen() {
        // User user = new User();
        JFrame.setDefaultLookAndFeelDecorated(true);
        // JFrame frame= new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setSize(300, 300);
        panel.setLayout(layout);
        panel.add(lblUser);
        panel.add(txtUser);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(btnLogin);
        panel.add(btnRegister);
        // Put constraint on components
        // USERNAME CONTROLS
        layout.putConstraint(SpringLayout.WEST, lblUser, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblUser, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtUser, 5, SpringLayout.EAST, lblUser);
        layout.putConstraint(SpringLayout.NORTH, txtUser, 50, SpringLayout.NORTH, panel);
        // PASSWORD CONTROLS
        layout.putConstraint(SpringLayout.WEST, lblPass, 5, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, lblPass, 80, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, txtPass, 5, SpringLayout.EAST, lblPass);
        layout.putConstraint(SpringLayout.NORTH, txtPass, 80, SpringLayout.NORTH, panel);
        // LOGIN BUTTON CONTROLS
        layout.putConstraint(SpringLayout.WEST, btnLogin, 70, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnLogin, 105, SpringLayout.NORTH, panel);
        // REGISTER BUTTON CONTROLS
        layout.putConstraint(SpringLayout.WEST, btnRegister, 150, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, btnRegister, 105, SpringLayout.NORTH, panel);
        frame.add(panel);
        frame.pack();
        frame.setSize(500, 500);

        frame.setVisible(true);
        btnLogin.addActionListener(this);
        btnLogin.setActionCommand("Login");
        btnRegister.addActionListener(this);
        btnRegister.setActionCommand("Register");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        usernameInput = txtUser.getText();
        passwordInput = txtPass.getText();
        String[] info = { usernameInput, passwordInput };
        if (!usernameInput.contains(" ") && !passwordInput.contains(" ") && !usernameInput.isBlank()&& !passwordInput.isBlank()) {
            switch (e.getActionCommand()) {
                case "Login":
                    Login(info);
                    break;
                case "Register":
                    Register(info);
                    break;
            }
            OpenMenu();
        }
        else {
                System.out.println("Login Unsuccessful");
            }
    }

    public static void Login(String[] info) {
        //User u = new User();
        if (u.validLogIn(info)) {
                    System.out.println("Login Successful");
                } else {
                    System.out.println("Login Unsuccessful");
                }
    }
    public static void Register(String[] info) {
        //User u = new User();
        u.setUserInfo(info);
    }
    public static void OpenMenu(){
        new MenuScreen(u);
        frame.dispose();
        
    }
}
