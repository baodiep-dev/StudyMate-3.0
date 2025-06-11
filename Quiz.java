import javax.swing.*;
import java.awt.*;

public class Quiz {
    private String[] subjects = {"Java", "C", "Python"};
    private String selectedSubject;
    private String[] questions;
    private String[][] options;
    private int[] answers;
    private int score = 0;
    private int currentQuestionIndex = 0;

    public void start() {
        selectedSubject = (String) JOptionPane.showInputDialog(
            null,
            "Choose a subject:",
            "Subject Selection",
            JOptionPane.QUESTION_MESSAGE,
            null,
            subjects,
            subjects[0]
        );

        if (selectedSubject != null) {
            loadQuestions(selectedSubject);
            showQuizFrame();
        }
    }

    private void loadQuestions(String subject) {
        switch (subject) {
            case "Java":
                questions = new String[]{
                    "What is Java?",
                    "What is inheritance in Java?",
                    "What is an interface?",
                    "What does JVM stand for?",
                    "Who developed Java?"
                };
                options = new String[][]{
                    {"A scripting language", "An object-oriented programming language widely used", "A markup language for websites", "A type of coffee"},
                    {"A method to inherit data", "A mechanism where one class acquires the properties and behaviors of another class completely", "A function call style", "A kind of error in Java"},
                    {"A user interface toolkit", "A reference type in Java that can contain only abstract methods and static fields used effectively", "A variable inside a class", "A method inside a loop"},
                    {"Java Visual Machine", "Java Virtual Machine", "Just Verified Module", "Java Verification Mechanism"},
                    {"Bill Gates", "James Gosling", "Mark Zuckerberg", "Guido van Rossum"}
                };
                answers = new int[]{1, 1, 1, 1, 1};
                break;

            case "C":
                questions = new String[]{
                    "Who is the creator of C?",
                    "What is a pointer in C?",
                    "What is a segmentation fault?",
                    "What is a header file?",
                    "What does the 'main' function do?"
                };
                options = new String[][]{
                    {"James Gosling", "Dennis Ritchie who created C at Bell Labs", "Ken Thompson", "Bjarne Stroustrup"},
                    {"A kind of variable", "A variable that stores the memory address of another variable accurately", "An error handler", "A class name"},
                    {"A syntax error", "A runtime error caused due to illegal memory access during execution", "A memory leak", "An input error"},
                    {"A comment in the code", "A file with .h extension that contains function declarations and macro definitions properly", "A main file", "A binary executable"},
                    {"Stores user inputs", "Marks the beginning of program execution exactly", "Declares variables", "Performs calculation"}
                };
                answers = new int[]{1, 1, 1, 1, 1};
                break;

            case "Python":
                questions = new String[]{
                    "What type of language is Python?",
                    "What is indentation in Python?",
                    "What is a list in Python?",
                    "What is a function in Python?",
                    "Who created Python?"
                };
                options = new String[][]{
                    {"Compiled low-level", "An interpreted, high-level programming language that is easy to read", "Only object-oriented", "Scripting only"},
                    {"A space issue", "A whitespace used to define code blocks clearly in Python", "A comment marker", "A memory unit"},
                    {"A collection", "A collection which is ordered and changeable with duplicate items supported", "A constant", "A mathematical set"},
                    {"An operator", "A block of organized, reusable code used to perform a single action precisely", "A loop", "A variable"},
                    {"James Gosling", "Guido van Rossum who developed Python in 1989", "Dennis Ritchie", "Linus Torvalds"}
                };
                answers = new int[]{1, 1, 1, 1, 1};
                break;
        }
    }

    private void showQuizFrame() {
        JFrame quizFrame = new JFrame(selectedSubject + " Quiz");
        quizFrame.setSize(800, 700);
        quizFrame.setLayout(new BorderLayout());
        quizFrame.getContentPane().setBackground(Color.decode("#424242"));

        JTextArea questionArea = new JTextArea();
        questionArea.setEditable(false);
        questionArea.setFont(new Font("Arial", Font.BOLD, 22));
        questionArea.setForeground(Color.BLACK);
        questionArea.setBackground(Color.decode("#E0FFFF"));

        JPanel answerPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        answerPanel.setBackground(Color.decode("#424242"));

        updateQuestionAndOptions(quizFrame, questionArea, answerPanel);

        quizFrame.add(questionArea, BorderLayout.NORTH);
        quizFrame.add(answerPanel, BorderLayout.CENTER);
        quizFrame.setVisible(true);
    }

    private void updateQuestionAndOptions(JFrame quizFrame, JTextArea questionArea, JPanel answerPanel) {
        if (currentQuestionIndex >= questions.length) {
            JOptionPane.showMessageDialog(quizFrame, "Your score: " + score + "/" + questions.length);
            quizFrame.dispose();
            return;
        }

        questionArea.setText(questions[currentQuestionIndex]);
        answerPanel.removeAll();

        for (int i = 0; i < options[currentQuestionIndex].length; i++) {
            JButton answerButton = new JButton(options[currentQuestionIndex][i]);
            answerButton.setFont(new Font("Arial", Font.BOLD, 20));
            answerButton.setBackground(Color.WHITE);
            answerButton.setForeground(Color.BLACK);
            answerButton.setOpaque(true);
            answerButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

            int answerIndex = i;

            answerButton.addActionListener(e -> {
                if (answerIndex == answers[currentQuestionIndex]) {
                    score++;
                }
                currentQuestionIndex++;
                updateQuestionAndOptions(quizFrame, questionArea, answerPanel);
                quizFrame.revalidate();
                quizFrame.repaint();
            });

            answerPanel.add(answerButton);
        }

        quizFrame.revalidate();
        quizFrame.repaint();
    }

    public static void main(String[] args) {
        new Quiz().start();
    }
}
