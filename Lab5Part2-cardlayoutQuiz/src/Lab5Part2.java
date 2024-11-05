import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lab5Part2 extends JFrame implements ActionListener {
    static JPanel panel1, panel2, panel3, resultPanel, q1, q2, q3;
    static JRadioButton ansButton1, ansButton2, ansButton3;
    static ButtonGroup ansButtonGroup;
    static JButton nextButton;
    static Container contentPane;
    static int page_counter;
    static CardLayout cardLayout;

    private Lab5Part2() {
        setTitle("Lab 5 Part 2 Survey");
        setSize(600, 500);
        contentPane = getContentPane();

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        resultPanel = new JPanel();

        q1 = QuestionPanelCreator("Q1. Choose your favourite snack:", "Chocolate", "Crisps", "Popcorn");
        panel1.add(q1);


        contentPane.setLayout(new CardLayout());
        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);
        contentPane.add(resultPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Lab5Part2();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        page_counter = 0;
        page_counter++;
        if (e.getSource() instanceof JButton) {
            cardLayout = (CardLayout) contentPane.getLayout();
            cardLayout.next(contentPane);
            q2 = QuestionPanelCreator("Q2. Choose your favourite pet: ", "Dog", "Cat", "Pigeon");
            panel2.add(q2);
            System.out.println("Page " + page_counter);

        }

        if ( e.getSource() instanceof JButton && page_counter == 1) {
            q3 = QuestionPanelCreator("Q3. Choose your favourite drink: ", "Coke", "Fanta", "Sprite");
            panel3.add(q3);
        }


    }

    public JPanel QuestionPanelCreator(String question, String ans1, String ans2, String ans3) {

        JPanel mainPanel = new JPanel();
        JPanel questionPanel = new JPanel();
        JPanel answerPanel = new JPanel();
        JPanel nextButtonPanel = new JPanel();

        JTextArea questionTextArea = new JTextArea();
        questionTextArea.setText(question);
        questionTextArea.setEditable(false);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);

        ansButton1 = new JRadioButton();
        ansButton1.setText(ans1);
        ansButton1.addActionListener(this);

        ansButton2 = new JRadioButton();
        ansButton2.setText(ans2);
        ansButton2.addActionListener(this);

        ansButton3 = new JRadioButton();
        ansButton3.setText(ans3);
        ansButton3.addActionListener(this);

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        nextButtonPanel.add(nextButton);

        ansButtonGroup = new ButtonGroup();
        ansButtonGroup.add(ansButton1);
        ansButtonGroup.add(ansButton2);
        ansButtonGroup.add(ansButton3);

        answerPanel.add(ansButton1);
        answerPanel.add(ansButton2);
        answerPanel.add(ansButton3);

        questionPanel.add(questionTextArea);
        mainPanel.add(questionPanel);
        mainPanel.add(answerPanel);
        mainPanel.add(nextButtonPanel);
        mainPanel.setLayout(new GridLayout(3, 1));

        return mainPanel;
    }
}

