import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HelloWorldAdventure {
    private JFrame window;
    private JPanel titleNameContainer;
    private JPanel startButtonContainer;
    private JLabel titleName;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 40);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 25);
    private JButton startButton, choice1, choice2, choice3, choice4;
    private JPanel mainTextPanel, choiceButtonPanel, playerPanel;
    private JTextArea mainTextArea;
    private JLabel hpLabel, hpLabelNumber, itemLabel, itemLabelName;

    private Player player;
    private int lives = 3;
    private String chosenLanguage;
    private String position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HelloWorldAdventure());
    }

    public HelloWorldAdventure() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        titleNameContainer = new JPanel();
        titleNameContainer.setBounds(100, 100, 600, 150);
        titleNameContainer.setBackground(Color.black);

        titleName = new JLabel("HELLO WORLD");
        titleName.setForeground(Color.white);
        titleName.setFont(titleFont);

        startButtonContainer = new JPanel();
        startButtonContainer.setBounds(300, 400, 200, 100);
        startButtonContainer.setBackground(Color.black);

        startButton = new JButton("START");
        startButton.setBackground(Color.darkGray);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);
        startButton.setOpaque(true);
        startButton.setBorderPainted(true);
        startButton.setBorder(BorderFactory.createLineBorder(Color.white, 2));

        titleNameContainer.add(titleName);
        startButtonContainer.add(startButton);

        window.add(titleNameContainer);
        window.add(startButtonContainer);

        window.setVisible(true);
    }

    public void createGameScreen() {
        titleNameContainer.setVisible(false);
        startButtonContainer.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        window.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 180);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1, 0, 10));
        window.add(choiceButtonPanel);

        choice1 = createButton("Choice 1", "c1");
        choice2 = createButton("Choice 2", "c2");
        choice3 = createButton("Choice 3", "c3");
        choice4 = createButton("Choice 4", "c4");

        choiceButtonPanel.add(choice1);
        choiceButtonPanel.add(choice2);
        choiceButtonPanel.add(choice3);
        choiceButtonPanel.add(choice4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        window.add(playerPanel);

        hpLabel = new JLabel("Lives:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        itemLabel = new JLabel("Item:");
        itemLabel.setFont(normalFont);
        itemLabel.setForeground(Color.white);
        playerPanel.add(itemLabel);

        itemLabelName = new JLabel();
        itemLabelName.setFont(normalFont);
        itemLabelName.setForeground(Color.white);
        playerPanel.add(itemLabelName);

        window.revalidate();
        window.repaint();

        askPlayerName();
    }

    private JButton createButton(String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.white);
        button.setFont(normalFont);
        button.setFocusPainted(false);
        button.addActionListener(choiceHandler);
        button.setActionCommand(actionCommand);
        button.setOpaque(true);
        button.setBorderPainted(true);
        button.setBorder(BorderFactory.createLineBorder(Color.white, 2));
        return button;
    }

    public void askPlayerName() {
        position = "askName";
        mainTextArea.setText("Enter your name:");
        choice1.setText("Enter");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void chooseLanguage() {
        position = "chooseLanguage";
        mainTextArea.setText("Choose a programming language:");
        choice1.setText("Java");
        choice2.setText("Python");
        choice3.setText("C++");
        choice4.setText("");
    }

    public void showBackstory() {
        position = "backstory";
        mainTextArea.setText(player.getName() + ", you're a college student who lost your dog, Byte. " +
                "Your mischievous coding professor has taken Byte! " +
                "To get your dog back, you must complete coding challenges in " + chosenLanguage + ".");
        choice1.setText("Continue");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void dormChallenge() {
        position = "dormChallenge";
        String challenge = "";
        switch (chosenLanguage) {
            case "Java":
                challenge = "What is the output of the following code?\nSystem.out.println(\"Hello World\");";
                break;
            case "Python":
                challenge = "What is the output of the following Python code?\nprint('Hello World')";
                break;
            case "C++":
                challenge = "What is the output of the following C++ code?\nstd::cout << \"Hello World\";";
                break;
        }
        mainTextArea.setText("Your dorm room is cluttered. You remember Byte playing with a USB drive. " +
                "Solve the coding challenge to find it.\n\n" + challenge);
        choice1.setText("Hello world");
        choice2.setText("hello world");
        choice3.setText("Hello World");
        choice4.setText("HELLO WORLD");
    }

    public void libraryChallenge() {
        position = "libraryChallenge";
        String challenge = "";
        switch (chosenLanguage) {
            case "Java":
                challenge = "Fix the error in the following code:\nint num = \"10\";";
                break;
            case "Python":
                challenge = "Fix the error in the following code:\nnum = '10'\nprint(num + 10)";
                break;
            case "C++":
                challenge = "Fix the error in the following code:\nint num = \"10\";";
                break;
        }
        mainTextArea.setText("You arrive at the quiet library. A glowing book holds a coding challenge.\n\n" + challenge);
        choice1.setText("int num = 10;");
        choice2.setText("num = 10");
        choice3.setText("int num = '10';");
        choice4.setText("num = int(10)");
    }

    public void computerLabChallenge() {
        position = "computerLabChallenge";
        String challenge = "";
        switch (chosenLanguage) {
            case "Java":
            case "C++":
                challenge = "Fix the code to store a character:\nchar grade = 'A\";";
                break;
            case "Python":
                challenge = "Fix the code to store a character:\ngrade = 'A\"";
                break;
        }
        mainTextArea.setText("You enter the dimly lit Computer Lab. A terminal is on, with a coding problem.\n\n" + challenge);
        choice1.setText("char grade = 'A';");
        choice2.setText("grade = 'A'");
        choice3.setText("char grade = \"A\";");
        choice4.setText("grade = \"A\"");
    }

    public void finalChallenge() {
        position = "finalChallenge";
        String challenge = "";
        switch (chosenLanguage) {
            case "Java":
            case "C++":
                challenge = "Fix the loop to print numbers 1 to 5:\n" +
                        "for (int i = 0; i <= 5; i++) {\nSystem.out.println(i);\n}";
                break;
            case "Python":
                challenge = "Fix the loop to print numbers 1 to 5:\n" +
                        "for i in range(0, 6):\n    print(i)";
                break;
        }
        mainTextArea.setText("You've made it to AJ's office. He's waiting for you. Complete the final coding challenge to get your dog back.\n\n" + challenge);
        choice1.setText("for (int i = 1; i <= 5; i++)");
        choice2.setText("for i in range(1, 6):");
        choice3.setText("for (int i = 1; i < 6; i++)");
        choice4.setText("for i in range(1, 5):");
    }

    public void endGame() {
        position = "endGame";
        mainTextArea.setText("Congratulations! You've completed the final challenge and retrieved your dog, Byte!");
        choice1.setText("Play Again");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("Exit");
    }

    public void lose() {
        position = "lose";
        mainTextArea.setText("Game over! You've lost all your lives.");
        choice1.setText("Play Again");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("Exit");
    }

    public class TitleScreenHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();

            switch(position) {
                case "askName":
                    if(yourChoice.equals("c1")) {
                        String name = JOptionPane.showInputDialog(window, "Enter your name:");
                        if(name != null && !name.trim().isEmpty()) {
                            player = new Player(name);
                            chooseLanguage();
                        } else {
                            mainTextArea.setText("Please enter a valid name.");
                        }
                    }
                    break;
                case "chooseLanguage":
                    if(yourChoice.equals("c1")) {
                        chosenLanguage = "Java";
                        showBackstory();
                    } else if(yourChoice.equals("c2")) {
                        chosenLanguage = "Python";
                        showBackstory();
                    } else if(yourChoice.equals("c3")) {
                        chosenLanguage = "C++";
                        showBackstory();
                    }
                    break;
                case "backstory":
                    if(yourChoice.equals("c1")) {
                        dormChallenge();
                    }
                    break;
                case "dormChallenge":
                    if(yourChoice.equals("c3")) {
                        player.addItem("USB Drive");
                        libraryChallenge();
                    } else {
                        loseLife();
                    }
                    break;
                case "libraryChallenge":
                    if((chosenLanguage.equals("Java") || chosenLanguage.equals("C++")) && yourChoice.equals("c1") ||
                            chosenLanguage.equals("Python") && yourChoice.equals("c2")) {
                        player.addItem("Map");
                        computerLabChallenge();
                    } else {
                        loseLife();
                    }
                    break;
                case "computerLabChallenge":
                    if((chosenLanguage.equals("Java") || chosenLanguage.equals("C++")) && yourChoice.equals("c1") ||
                            chosenLanguage.equals("Python") && yourChoice.equals("c2")) {
                        player.addItem("Keycard");
                        finalChallenge();
                    } else {
                        loseLife();
                    }
                    break;
                case "finalChallenge":
                    if((chosenLanguage.equals("Java") || chosenLanguage.equals("C++")) && yourChoice.equals("c1") ||
                            chosenLanguage.equals("Python") && yourChoice.equals("c2")) {
                        endGame();
                    } else {
                        loseLife();
                    }
                    break;
                case "endGame":
                    if(yourChoice.equals("c1")) {
                        player = null;
                        lives = 3;
                        chosenLanguage = null;
                        askPlayerName();
                    } else if(yourChoice.equals("c4")) {
                        System.exit(0);
                    }
                    break;
                case "lose":
                    if(yourChoice.equals("c1")) {
                        player = null;
                        lives = 3;
                        chosenLanguage = null;
                        askPlayerName();
                    } else if(yourChoice.equals("c4")) {
                        System.exit(0);
                    }
                    break;
            }
            updatePlayerPanel();
        }
    }

    public void loseLife() {
        lives--;
        if(lives > 0) {
            mainTextArea.setText("Wrong answer! You have " + lives + " lives left. Try again.");
        } else {
            lose();
        }
        updatePlayerPanel();
    }

    public void updatePlayerPanel() {
        hpLabelNumber.setText("" + lives);
        itemLabelName.setText(player != null ? player.getLastItem() : "");
    }

    private class Player {
        private String name;
        private List<String> inventory = new ArrayList<>();

        public Player(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void addItem(String item) {
            inventory.add(item);
        }

        public String getLastItem() {
            return inventory.isEmpty() ? "" : inventory.get(inventory.size() - 1);
        }
    }
}