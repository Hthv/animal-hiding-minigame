package swingLearn.animalEmotion;

import javax.swing.*;
import java.awt.*;

public class animalEmotionGame {
    public static void main (String args[]){

        JFrame frame = new JFrame("Choose your cat");
        JButton button1 = new JButton("Nerdy Cat");
        JButton button2 = new JButton("Happy Cat");
        JButton button3 = new JButton("Silly Cat");
        JButton button4 = new JButton("Angry Cat");
        JButton clearButton = new JButton("Clear Image");

        JLabel qLabel = new JLabel("Who stole the chocolate?");
        qLabel.setBounds(100,30, 200 ,30);

        JLabel imageLabel = new JLabel();
        JPanel buttonPanel = new JPanel();
        JPanel imagePanel = new JPanel();

        frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout());

        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(clearButton);
        imagePanel.add(imageLabel);

        frame.add(qLabel);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(imagePanel, BorderLayout.CENTER);

        button1.addActionListener(e->{
            ImageIcon image = new ImageIcon("swingLearn/animalEmotion/nerdyCat.jpg");
            imageLabel.setIcon(image);
        });

        button2.addActionListener(e->{
            ImageIcon image = new ImageIcon("swingLearn/animalEmotion/happyCat.jpg");
            imageLabel.setIcon(image);
        });

        button3.addActionListener(e->{
            ImageIcon image = new ImageIcon("swingLearn/animalEmotion/sillyCat.jpg");
            imageLabel.setIcon(image);
        });

        button4.addActionListener(e->{
            ImageIcon image = new ImageIcon("swingLearn/animalEmotion/angryCat.jpg");
            imageLabel.setIcon(image);
        });

        clearButton.addActionListener(e->{
            imageLabel.setIcon(null);
        });

        frame.setSize(700,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
