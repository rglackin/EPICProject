import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class StatsScreen implements ActionListener {
    User u;

    static JFrame frame = new JFrame("Statistics");
    JPanel panel = new JPanel();
    SpringLayout layout = new SpringLayout();
    
    JLabel lblTitle = new JLabel("Statistics");
    JTable tblStats = new JTable();

    public StatsScreen(User u){
        this.u = u;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setBackground(Color.CYAN);
        
        panel.setSize(700, 500);
        panel.setLayout(layout);
        panel.add(tblStats);
        panel.add(lblTitle);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}