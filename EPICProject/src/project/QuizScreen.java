package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

public class QuizScreen implements ActionListener {
    User u = new User();
    qaBank bank = new qaBank();
    int[] qNums;
    int qPointer = 0;
    int marks=0;
    // initialising frame and components
    static JFrame frame = new JFrame("Quiz");
    JPanel formatPanel = new JPanel();
    JPanel quizPanel = new JPanel();
    SpringLayout layout = new SpringLayout();
    // SpringLayout quizLayout = new SpringLayout();

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
    JLabel lblMarks = new JLabel("Marks: "+marks);
    ButtonGroup ansGroup = new ButtonGroup();

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
        lblQuestion.setFont(new Font("", Font.BOLD, 14));
        // set format panel size/layout
        formatPanel.setSize(1000, 700);
        formatPanel.setLayout(layout);
        // setup radio button group
        radiGroup.add(radIncDiff);
        radiGroup.add(radRandom);

        ansGroup.add(btnAnsZero);
        ansGroup.add(btnAnsOne);
        ansGroup.add(btnAnsTwo);
        ansGroup.add(btnAnsThree);
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
        quizPanel.setSize(1000, 700);
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

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsZero, -200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsZero, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsOne, 200, SpringLayout.HORIZONTAL_CENTER, quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsOne, 50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsTwo, -200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsTwo, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, btnAnsThree, 200, SpringLayout.HORIZONTAL_CENTER,
                quizPanel);
        layout.putConstraint(SpringLayout.VERTICAL_CENTER, btnAnsThree, -50, SpringLayout.VERTICAL_CENTER, quizPanel);

        btnStart.addActionListener(this);
        btnStart.setActionCommand("startQuiz");

        btnAnsZero.addActionListener(this);
        btnAnsZero.setActionCommand("a0");

        btnAnsOne.addActionListener(this);
        btnAnsOne.setActionCommand("a1");

        btnAnsTwo.addActionListener(this);
        btnAnsTwo.setActionCommand("a2");

        btnAnsThree.addActionListener(this);
        btnAnsThree.setActionCommand("a3");

        frame.add(formatPanel);
        frame.add(quizPanel);
        frame.pack();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "startQuiz":
                if (radIncDiff.isSelected()) {
                    startQuiz(true);
                } else if (radRandom.isSelected()) {
                    startQuiz(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Select a format");
                }
                break;
            case "a0":
                nextQuestion(0);
                break;
            case "a1":
                nextQuestion(1);
                break;
            case "a2":
                nextQuestion(2);
                break;
            case "a3":
                nextQuestion(3);
                break;
        }
    }

    public void startQuiz(boolean incOrRand) {
        formatPanel.setVisible(false);
        quizPanel.setVisible(true);

        qNums = bank.incOrRand(incOrRand);
        nextQuestion(-1);
    }

    public void nextQuestion(int answerChoice) {
        if(answerChoice>=0){
            System.out.println(bank.correctAnswer(qNums[qPointer]));
        }
        lblQuestion.setText(bank.returnQuestion(qNums[qPointer]));
        try{
        btnAnsTwo.setVisible(true);
        btnAnsThree.setVisible(true);
        btnAnsZero.setText(bank.returnAnswer(qNums[qPointer], 0));
        btnAnsOne.setText(bank.returnAnswer(qNums[qPointer], 1));
        btnAnsTwo.setText(bank.returnAnswer(qNums[qPointer], 2));
        btnAnsThree.setText(bank.returnAnswer(qNums[qPointer], 3));
        }
        catch(ArrayIndexOutOfBoundsException e){
            btnAnsTwo.setVisible(false);
            btnAnsThree.setVisible(false);
        }
        qPointer++;
    }
}