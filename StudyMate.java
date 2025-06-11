import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class StudyMate {
    public static void main(String[] args) {
        // for look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // main frame
        JFrame frame = new JFrame("StudyMate");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);
        frame.getContentPane().setBackground(Color.decode("#424242"));

        // panel with 3 rows, 2 columns
        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setBackground(Color.decode("#424242"));

        // buttons
        JButton faceAttendanceButton  = new JButton("Facial Attendance");
        JButton studyvideoButton      = new JButton("Video Links");
        JButton quizButton            = new JButton("Tests");
        JButton assignmentButton      = new JButton("Assignments");
        JButton wordGameButton        = new JButton("Word Game");
        JButton numberGameButton      = new JButton("Number Game");
        
        // uniform font
        Font btnFont = new Font("Arial", Font.BOLD, 30);
        for (JButton btn : new JButton[]{
            faceAttendanceButton, studyvideoButton, quizButton, assignmentButton,
            wordGameButton, numberGameButton
        }) {
            btn.setFont(btnFont);
        }

        // action listeners
        studyvideoButton.addActionListener(e -> {
            StudyVideos studyvideo = new StudyVideos();
            studyvideo.showVideoLinks();
        });

        quizButton.addActionListener(e -> {
            Quiz quiz = new Quiz();
            quiz.start();
        });

        assignmentButton.addActionListener(e -> {
            Assignment assignment = new Assignment();
            assignment.showAssignments();
        });

        wordGameButton.addActionListener(e -> {
            WordGuessGame wordGame = new WordGuessGame();
            wordGame.start();
        });

        numberGameButton.addActionListener(e -> {
            GuessTheNumberGame numberGame = new GuessTheNumberGame();
            numberGame.start();
        });

        faceAttendanceButton.addActionListener(e -> {
            try {
                ProcessBuilder pb = new ProcessBuilder(
                    "python3",
                    "/Users/vipinchoudhary/Desktop/FaceAttendanceProject/face_attendance.py"
                );
                pb.inheritIO();
                pb.start();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    frame,
                    "Error starting face attendance system:\n" + ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // add buttons in two columns
        panel.add(faceAttendanceButton);
        panel.add(studyvideoButton);
        panel.add(quizButton);
        panel.add(assignmentButton);
        panel.add(wordGameButton);
        panel.add(numberGameButton);
        
        
        frame.add(panel);
        frame.setVisible(true);
    }
}