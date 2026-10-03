package swingLearn.animalEmotion;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class animalHidingGame {
    public static void main(String args[]){
        JFrame frame = new JFrame("Guess where is kittyyyyy");

        CardLayout cardLayout = new CardLayout();
        JPanel allPages = new JPanel(cardLayout);
        JPanel mainPage = new JPanel();

// Import Images ===========================================================================================================

        ImageIcon donaldImage = new ImageIcon("swingLearn/animalEmotion/images/donald.png");
        ImageIcon doraImage = new ImageIcon("swingLearn/animalEmotion/images/dora.jpeg");
        ImageIcon amandaImage = new ImageIcon("swingLearn/animalEmotion/images/amanda.jpeg");
        ImageIcon nerdImage = new ImageIcon("swingLearn/animalEmotion/images/nerd.jpg"); // startPage avatar

        ImageIcon nerdyCatImage = new ImageIcon("swingLearn/animalEmotion/images/nerdyCat.jpg");
        ImageIcon happyCatImage = new ImageIcon("swingLearn/animalEmotion/images/happyCat.jpg");
        ImageIcon sillyCatImage = new ImageIcon("swingLearn/animalEmotion/images/sillyCat.jpg");
        ImageIcon angryCatImage = new ImageIcon("swingLearn/animalEmotion/images/angryCat.jpg"); // sPage cats

        ImageIcon r1Hide1 = new ImageIcon("swingLearn/animalEmotion/images/q1Bed.png");
        ImageIcon r1Hide2 = new ImageIcon("swingLearn/animalEmotion/images/q1Garden.jpg");
        ImageIcon r1Hide3 = new ImageIcon("swingLearn/animalEmotion/images/q1Toilet.jpg");
        ImageIcon r1Hide4 = new ImageIcon("swingLearn/animalEmotion/images/q1Kitchen.jpeg"); // Round 1 Places
        
        ImageIcon emptyBox = new ImageIcon ("swingLearn/animalEmotion/images/emptyBox.jpg"); // Empty Box

        ImageIcon healthImage = new ImageIcon ("swingLearn/animalEmotion/images/health.png"); // Health

// Health / Text ===========================================================================================================

        int health[] = {10};

        JLabel[] healthLabel = new JLabel[10];
        
        for (int h = 0; h < healthLabel.length; h++){
            healthLabel[h] = new JLabel(healthImage);
        }

        JPanel healthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        healthPanel.setVisible(false);
        JLabel titleLabel = new JLabel("Choose your kitty!");
        titleLabel.setVisible(false);
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(titleLabel);
        JPanel universalBorderLayout = new JPanel(new BorderLayout());

        for (int h = 0; h < healthLabel.length; h++){
            healthPanel.add(healthLabel[h]);
        }

// Start Page ==============================================================================================================

        JPanel startPage = new JPanel(new FlowLayout());
        JLabel nameText = new JLabel("Enter your name & choose your character");
        JTextField nameTBox = new JTextField(30);
        nameText.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameTBox.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
        namePanel.add(nameText);
        namePanel.add(nameTBox);
        JPanel avatarSelection = new JPanel(new GridLayout(2, 2));
        namePanel.add(avatarSelection);
        String avatarName = nameTBox.getText();
        
        JButton avatar1 = new JButton(donaldImage);
        JButton avatar2 = new JButton(doraImage);
        JButton avatar3 = new JButton(amandaImage);
        JButton avatar4 = new JButton(nerdImage);

        JButton[] avatarButtons = {
            avatar1, avatar2, avatar3, avatar4
        };

        for (JButton button : avatarButtons){
            avatarSelection.add(button);
        }

        for (JButton button : avatarButtons){
            button.addActionListener(e->{
            titleLabel.setText("Choose your kitty!");
            cardLayout.show(allPages, "selectionPage");
            healthPanel.setVisible(true);
            titleLabel.setVisible(true);
            });
        }

        startPage.add(namePanel);

// Selection Page ==========================================================================================================
        
        JPanel selectionPage = new JPanel();
        JPanel sPagePanel1 = new JPanel(new GridLayout(2, 2));

        JButton p1Button1 = new JButton(nerdyCatImage);
        JButton p1Button2 = new JButton(happyCatImage);
        JButton p1Button3 = new JButton(sillyCatImage);
        JButton p1Button4 = new JButton(angryCatImage);

        JButton[] p1Buttons = {
            p1Button1, p1Button2, p1Button3, p1Button4};

        p1Button1.setPreferredSize(new Dimension(265, 265));
        p1Button2.setPreferredSize(new Dimension(265, 265));
        p1Button3.setPreferredSize(new Dimension(265, 265));
        p1Button4.setPreferredSize(new Dimension(265, 265));

        p1Button1.addActionListener(e->{ // Page 1
            titleLabel.setText("Where is Nerdy Cat hiding?");
            cardLayout.show(allPages, "round1");
        });

        p1Button2.addActionListener(e->{
            titleLabel.setText("Where is Happy Cat hiding?");
            cardLayout.show(allPages, "round2");
        });

        p1Button3.addActionListener(e->{
            titleLabel.setText("Where is Silly Cat hiding?");
            cardLayout.show(allPages, "round3");
        });

        p1Button4.addActionListener(e->{
            titleLabel.setText("Where is Angry Cat hiding?");
            cardLayout.show(allPages, "round4");
        });

// Create Array Variables for Rounds =======================================================================================
        
        JPanel[] roundPage = new JPanel[4];
        for (int i = 0; i < roundPage.length; i++) {
            roundPage[i] = new JPanel(new BorderLayout());
        }

        JPanel[] roundTopPage = new JPanel[4];
        for (int i = 0; i < roundTopPage.length; i++) {
            roundTopPage[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));
        }

        JPanel[] roundCenterPage = new JPanel[4];
        for (int i = 0; i < roundCenterPage.length; i++) {
            roundCenterPage[i] = new JPanel(new GridLayout (2,2));
        }

        JPanel[] roundCenterPageCorrector = new JPanel[4];
        for (int i = 0; i < roundCenterPageCorrector.length; i++) {
            roundCenterPageCorrector[i] = new JPanel();
        }

        JPanel[] roundBottomPage = new JPanel[4];
        for (int i = 0; i < roundBottomPage.length; i++) {
            roundBottomPage[i] = new JPanel(new FlowLayout(FlowLayout.CENTER));  // Round Pages Arrangement
        }

        Random rRandom = new Random();
        int[] rRandomNumber = new int[4];
        for (int i = 0; i < rRandomNumber.length; i++) {
            rRandomNumber[i] = rRandom.nextInt(4) + 1;  // Generate Random Number
        }

        ImageIcon[] hideImage = {
            r1Hide1, r1Hide2, r1Hide3, r1Hide4};  // Hide Image Array

        ImageIcon[] catImage = {
            nerdyCatImage, happyCatImage, sillyCatImage, angryCatImage};  // Cat Image Array


        JButton[][] rButtons = new JButton[4][4];
        for (int round = 0; round < 4; round++) {
            for (int i = 0; i < 4; i++) {
                rButtons[round][i] = new JButton(hideImage[i]);
                rButtons[round][i].setPreferredSize(new Dimension(260, 260));
            }
        }

        JButton[] backButton = new JButton[4];
        for (int i = 0; i < backButton.length; i++) {
            backButton[i] = new JButton("Back");

            backButton[i].addActionListener (e-> {
                cardLayout.show(allPages, "selectionPage");
                titleLabel.setText("Choose your kitty!");
            });
        }


        boolean[][] rClicked = {
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
            {true, true, true, true},
        };

        boolean[] rClear = {false, false, false, false};

// Rounds ==================================================================================================================

        for (int round = 0; round < 4; round++){
            int rCurrent = round + 1;
            for (int i = 0; i < p1Buttons.length; i++){
                int iCurrent = i + 1;
                rButtons[rCurrent - 1 ][iCurrent - 1].addActionListener(e->{
                    if (rClicked[rCurrent - 1 ][iCurrent - 1] == true){
                        if (iCurrent == rRandomNumber[rCurrent - 1 ]){
                            rButtons[rCurrent-1][iCurrent-1].setIcon(catImage[rCurrent-1]);
                            rClear[rCurrent - 1 ] = true;
                            p1Buttons[rCurrent - 1].setEnabled(false);
                            Timer rClearTimer = new Timer(100, t-> {
                                int nextRoundConfirm = JOptionPane.showConfirmDialog(
                                    frame,
                                    "Proceed to the next round?",
                                    "Confirm",
                                    JOptionPane.YES_NO_OPTION
                                );
                                for (int c = 0; c < 4; c++){
                                    if (rClear[c] = true);
                                }
                                if (nextRoundConfirm == JOptionPane.YES_OPTION){

                                    if (rCurrent == 0){
                                        titleLabel.setText("Where is Nerdy Cat hiding?");
                                        cardLayout.show(allPages, "round1");
                                    }
                                    else if (rCurrent == 1){
                                        titleLabel.setText("Where is Happy Cat hiding?");
                                        cardLayout.show(allPages, "round2");
                                    }
                                    else if (rCurrent == 2){
                                        titleLabel.setText("Where is Silly Cat hiding?");
                                        cardLayout.show(allPages, "round3");
                                    }
                                    else if (rCurrent == 3){
                                        titleLabel.setText("Where is Angry Cat hiding?");
                                        cardLayout.show(allPages, "round4");
                                    }
                                }
                                if (nextRoundConfirm == JOptionPane.NO_OPTION){
                                    cardLayout.show(allPages, "selectionPage");
                                }
                            });
                            rClearTimer.setRepeats(false);
                            rClearTimer.start();
                        }
                        else {
                            rButtons[rCurrent - 1 ][iCurrent - 1].setIcon(emptyBox);
                            health[0] -= 1;
                            healthLabel[health[0]].setIcon(null);
                        }
                    rClicked[rCurrent - 1 ][iCurrent - 1] = false;
                    }
                });
            }
            roundPage[rCurrent - 1 ].add(roundTopPage[rCurrent - 1 ], BorderLayout.NORTH);
            roundCenterPageCorrector[rCurrent - 1 ].add(roundCenterPage[rCurrent - 1 ]);
            roundPage[rCurrent - 1 ].add(roundCenterPageCorrector[rCurrent - 1 ], BorderLayout.CENTER);
            roundBottomPage[rCurrent - 1 ].add(backButton[round]);
            roundPage[rCurrent - 1 ].add(roundBottomPage[rCurrent - 1 ], BorderLayout.SOUTH);

            for (JButton button : rButtons[round]) {
                    roundCenterPage[rCurrent - 1 ].add(button);
                }
        }

// Result Page =============================================================================================================

        JPanel resultPage = new JPanel();




// Ending ==================================================================================================================

        frame.setLayout(new FlowLayout());
        frame.setLayout(new BorderLayout());

        for (JButton button : p1Buttons){
            sPagePanel1.add(button);
        }
        selectionPage.add(sPagePanel1);

        allPages.add(startPage, "start");
        allPages.add(selectionPage, "selectionPage");
        allPages.add(roundPage[0], "round1");
        allPages.add(roundPage[1], "round2");
        allPages.add(roundPage[2], "round3");
        allPages.add(roundPage[3], "round4");
        allPages.add(resultPage);
        universalBorderLayout.add(titlePanel, BorderLayout.NORTH);
        universalBorderLayout.add(healthPanel, BorderLayout.CENTER);
        mainPage.add(universalBorderLayout);
        mainPage.add(allPages);
        frame.add(mainPage);

        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
