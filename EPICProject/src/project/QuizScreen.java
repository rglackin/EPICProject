package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class QuizScreen implements ActionListener {
    User u = new User();
    // initialising frame and components
    static JFrame frame = new JFrame("Quiz");
    JPanel formatPanel = new JPanel();
    JPanel quizPanel = new JPanel();
    SpringLayout layout = new SpringLayout();
    //SpringLayout quizLayout = new SpringLayout();

    JLabel lblSelectFormat = new JLabel("Select a Quiz Format");
    ButtonGroup radiGroup = new ButtonGroup();
    JRadioButton radRandom = new JRadioButton("Random selection");
    JRadioButton radIncDiff = new JRadioButton("Increasing Difficulty");
    JButton btnStart = new JButton("Start Quiz");
    JLabel lblQuestion = new JLabel("question");
    JButton btnAnsZero = new JButton("a0"); 
    JButton btnAnsOne = new JButton("a1"); 
    JButton btnAnsTwo = new JButton("a2"); 
    JButton btnAnsThree = new JButton("a3"); 

    public QuizScreen(User u) {
        this.u = u;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set background color
        formatPanel.setBackground(Color.CYAN);
        quizPanel.setBackground(Color.CYAN);
        radIncDiff.setBackground(Color.cyan);
        radRandom.setBackground(Color.cyan);
        // set title font
        lblSelectFormat.setFont(new Font("", Font.BOLD, 20));
        lblQuestion.setFont(new Font("", Font.BOLD, 20));
        // set format panel size/layout
        formatPanel.setSize(700, 500);
        formatPanel.setLayout(layout);
        // setup radio button group
        radiGroup.add(radIncDiff);
        radiGroup.add(radRandom);
        // add components to format panel
        formatPanel.add(lblSelectFormat);
        formatPanel.add(radIncDiff);
        formatPanel.add(radRandom);
        formatPanel.add(btnStart);

        quizPanel.setVisible(false);
        quizPanel.add(lblQuestion);
        quizPanel.add(btnAnsZero);
        quizPanel.add(btnAnsOne);
        quizPanel.add(btnAnsTwo);
        quizPanel.add(btnAnsThree);
        // set quiz panel size/layout
        quizPanel.setSize(700, 500);
        quizPanel.setLayout(layout);

        // Spring layout constraints
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblSelectFormat, 0, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, lblSelectFormat, 5, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, radIncDiff, -100, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, radIncDiff, 40, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, radRandom, 100, SpringLayout.HORIZONTAL_CENTER,
                formatPanel);
        layout.putConstraint(SpringLayout.NORTH, radRandom, 40, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnStart, 0, SpringLayout.HORIZONTAL_CENTER, formatPanel);
        layout.putConstraint(SpringLayout.NORTH, btnStart, 80, SpringLayout.NORTH, formatPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, lblQuestion, 0, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.NORTH, lblQuestion, 50, SpringLayout.NORTH, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsZero, -200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsZero, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsOne, 200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsOne, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsTwo, -200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsTwo, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsThree, 200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsThree, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        btnStart.addActionListener(this);
        btnStart.setActionCommand("startQuiz");
        

        frame.add(formatPanel);
        frame.add(quizPanel);
        frame.pack();
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            
            case "startQuiz":
                if(radIncDiff.isSelected()){
                    startQuiz(true);
                }
                else if(radRandom.isSelected()){
                    startQuiz(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Select a format");
                }
                break;
        }
    }

    public void startQuiz(boolean incOrRand) {
        formatPanel.setVisible(false);
        quizPanel.setVisible(true);

        
    }
}