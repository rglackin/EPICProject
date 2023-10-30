import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;
public class QuizOver implements ActionListener {
    User u = new User();
    static JFrame frame = new JFrame("Quiz Over");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();
    JButton btnNext = new JButton("Exit to Menu", null);
    JLabel lblUsername = new JLabel("Username: ");
    JLabel lblMark = new JLabel();
    JLabel lblTitle = new JLabel("Quiz Over");

    public QuizOver(User u) {
        this.u = u;
        writeResult();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        lblUsername.setText(lblUsername.getText() + "" + u.getUsername());
        lblMark.setText("Mark: "+u.getMark()+"/18");
        lblMark.setFont(new Font("", Font.BOLD, 20));
        lblTitle.setFont(new Font("", Font.BOLD, 20));
        lblUsername.setFont(new Font("", Font.BOLD, 20));
        panel.setSize(700, 500);
        panel.setLayout(layout);
        panel.add(btnNext);
        panel.add(lblMark);
        
        panel.add(lblUsername);
        panel.add(lblTitle);
        // lblUsername CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblUsername, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblUsername, -50, SpringLayout.VERTICAL_CENTER, panel);
        // lblTitle CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblTitle, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.NORTH, lblTitle, 20, SpringLayout.NORTH, panel);
        // lblMark CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblMark, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, lblMark, 50, SpringLayout.VERTICAL_CENTER, panel);
        // btnNext CONSTRAINTS
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnNext, 0, SpringLayout.HORIZONTAL_CENTER, panel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnNext, 80, SpringLayout.VERTICAL_CENTER, panel);

        

        frame.add(panel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        btnNext.addActionListener(this);
        btnNext.setActionCommand("next");
       
    }

    public void writeResult() {
    	try {
    	      File myObj = new File("results.txt");
    	      myObj.createNewFile();
    	} catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	}
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("results.txt", true));
            try {
                Scanner reader = new Scanner("results.txt");
                while (reader.hasNextLine()) {
                	writer.write("\n");
                	reader.nextLine();
					
                	}
                reader.close();
              } catch (IOException e) {e.printStackTrace();}
            writer.write(u.getUsername() + " " + u.getMark());
            writer.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "next":
                new MenuScreen(u);
                frame.dispose();    
                break;
        
            
        }   
    }
}
