import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {
    JFrame window;
    Container container;
    JPanel titleNameContainer;
    JPanel startButtonContainer;
    JLabel titleName;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    JButton startButton;
    public static void main(String[] args)throws Exception{
        new App();
    }
    public App(){
        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setVisible(true);
        
        container = window.getContentPane();
        
        titleNameContainer = new JPanel();
        titleNameContainer.setBounds(100, 100, 600, 150);
        titleNameContainer.setBackground(Color.black);
        
        titleName = new JLabel("HELLO WORLD");
        titleName.setForeground(Color.white);
        titleName.setFont(titleFont);
        titleName.setBounds(50,50,450,50);
        

        
        startButtonContainer = new JPanel();
        startButtonContainer.setBounds(300,400,200,100);
        startButtonContainer.setBackground(Color.blue);
        startButtonContainer.setLayout(null);
        
        // startButton = new JButton("START");
        // startButton.setBackground(Color.black);
        // startButton.setForeground(Color.white);

        
        titleNameContainer.add(titleName);
        startButtonContainer.add(startButton);
        
        container.add(titleNameContainer);
        container.add(startButtonContainer);
        
    }
} 

