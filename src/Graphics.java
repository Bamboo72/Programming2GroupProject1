
/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
*/

import java.util.Scanner; // Temporary import for testing purposes

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Container;

public class Graphics extends JFrame {

    private static int displayState;
    JFrame frame = new JFrame();
    Container con = this.getContentPane();

    public Graphics() {
        this.displayState = 0;
        this.setBounds(10, 10, 1280, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JLabel testLabel = new JLabel("TEST");
        this.add(testLabel);
        testLabel.setLocation(1000, 50);
    }

    // This will display different things based on the displayState
    public void display(int displayNum) {
        switch (displayNum) {
            case 0:
                System.out.println("Title Screen");

                ImageIcon titleImage = new ImageIcon(".//res//TitleScreen.png");
                JLabel titleLabel = new JLabel(titleImage);

                JPanel titlePanel = new JPanel();
                titlePanel.setBounds(0, 0, 400, 389);

                titlePanel.add(titleLabel);
                con.add(titlePanel);

                // JButton button = new JButton("test");
                // button.setBounds(565, 390, 153, 43);
                // this.add(button);

                /*
                 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
                 * Auto-generated catch block e.printStackTrace(); }
                 * 
                 * titlePanel.setVisible(false);
                 */
                break;
            case 1:
                System.out.println("Credits");

                break;
            case 2:
                System.out.println("Start Screen");

                ImageIcon startImage = new ImageIcon(".//res//StartScreen.png");
                JLabel startLabel = new JLabel(startImage);

                JPanel startPanel = new JPanel();
                startPanel.setBounds(0, 0, 400, 389);

                startPanel.add(startLabel);
                con.add(startPanel);

                break;
            case 3:
                System.out.println("Character Creator");
                break;
            default:
                System.out.println("Unknown number/ not yet implemented");
        }
    }

    // This will refresh the frame whenever a change is made
    public void refresh() {
        frame.revalidate();
    }

    public static void main(String[] args) {
        Graphics g = new Graphics();

        Scanner inputReader = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println(
                    "Choose an option: (0) Title Screen (1) Credits (2) Start Screen (3) Character Creator (4) Exit");
            g.displayState = inputReader.nextInt();
            if (g.displayState == 4) {
                run = false;
            }
            g.display(displayState);
            g.refresh();
        }
        inputReader.close();
    }
}
