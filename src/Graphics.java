
/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
* This is the Graphics class for the Isle of Laeso group project.
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

public class Graphics extends JFrame {

    int displayState;
    JFrame frame = new JFrame();
    Container con = this.getContentPane();
    JPanel activePanel;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<JPanel> panelList = new ArrayList<JPanel>(); // Copied from Maze Game- may not need

    /**
     * This is the constructor for the graphics class which sets up some of the
     * JFrame attributes
     */
    public Graphics() {
        this.displayState = 0;
        this.setBounds(10, 10, 1285, 760);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    /**
     * This method will display different scenes depending on the displayState
     * 
     * @param displayNum
     */
    public void sceneDisplay(int displayNum) {
        switch (displayNum) {
        case 0: // Title Screen
            ImageIcon titleImage = new ImageIcon(".//res//TitleScreen.png");
            JLabel titleLabel = new JLabel(titleImage);
            JPanel titlePanel = new JPanel();
            titlePanel.setBounds(0, 0, 1280, 720);
            activePanel = titlePanel;
            titlePanel.add(titleLabel);

            ImageIcon startButtonImage = new ImageIcon(".//res//ButtonStart.png");
            JButton startButton = new JButton(startButtonImage);
            ActionListener startListener = new GoToHMP();
            startButton.addActionListener(startListener);
            startButton.setBounds(320, 390, 311, 85);
            buttonList.add(startButton);

            ImageIcon creditsButtonImage = new ImageIcon(".//res//ButtonCredits.png");
            JButton creditsButton = new JButton(creditsButtonImage);
            ActionListener creditsListener = new GoToCredits();
            creditsButton.addActionListener(creditsListener);
            creditsButton.setBounds(0, 620, 311, 85);
            buttonList.add(creditsButton);

            ImageIcon settingsButtonImage = new ImageIcon(".//res//ButtonSettings.png");
            JButton settingsButton = new JButton(settingsButtonImage);
            ActionListener settingsListener = new GoToSettings();
            settingsButton.addActionListener(settingsListener);
            settingsButton.setBounds(900, 620, 311, 85);
            buttonList.add(settingsButton);

            con.add(settingsButton);
            con.add(creditsButton);
            con.add(startButton);
            con.add(titlePanel);

            break;
        case 1: // Credits
            ImageIcon creditsImage = new ImageIcon(".//res//BackgroundCredits.png");
            JLabel creditsLabel = new JLabel(creditsImage);
            JPanel creditsPanel = new JPanel();
            creditsPanel.setBounds(0, 0, 1280, 720);
            activePanel = creditsPanel;
            creditsPanel.add(creditsLabel);

            ImageIcon backButtonImage = new ImageIcon(".//res//ButtonX.png");
            JButton backButton = new JButton(backButtonImage);
            ActionListener backListener = new GoToTitle();
            backButton.addActionListener(backListener);
            backButton.setBounds(1180, 10, 64, 64);
            buttonList.add(backButton);

            con.add(backButton);
            con.add(creditsPanel);

            break;
        case 2: // Settings
            ImageIcon settingsImage = new ImageIcon(".//res//BackgroundSettings.png");
            JLabel settingsLabel = new JLabel(settingsImage);
            JPanel settingsPanel = new JPanel();
            settingsPanel.setBounds(0, 0, 1280, 720);
            activePanel = settingsPanel;
            settingsPanel.add(settingsLabel);

            // This button was copied from the credits display scene, but I had to make it
            // different so I added a 2 to the end of everything
            ImageIcon backButtonImage2 = new ImageIcon(".//res//ButtonX.png");
            JButton backButton2 = new JButton(backButtonImage2);
            ActionListener backListener2 = new GoToTitle();
            backButton2.addActionListener(backListener2);
            backButton2.setBounds(1180, 10, 64, 64);
            buttonList.add(backButton2);

            con.add(backButton2);
            con.add(settingsPanel);

            break;
        case 3: // How Many Players?
            ImageIcon hmpImage = new ImageIcon(".//res//BackgroundHMP.png");
            JLabel hmpLabel = new JLabel(hmpImage);
            JPanel hmpPanel = new JPanel();
            hmpPanel.setBounds(0, 0, 1280, 720);
            activePanel = hmpPanel;
            hmpPanel.add(hmpLabel);

            // This button was copied from the credits display scene, but I had to make it
            // different so I added a 3 to the end of everything
            ImageIcon backButtonImage3 = new ImageIcon(".//res//ButtonX.png");
            JButton backButton3 = new JButton(backButtonImage3);
            ActionListener backListener3 = new GoToTitle();
            backButton3.addActionListener(backListener3);
            backButton3.setBounds(1180, 10, 64, 64);
            buttonList.add(backButton3);

            ImageIcon checkButtonImage = new ImageIcon(".//res//ButtonCheck.png");
            JButton checkButton = new JButton(checkButtonImage);
            ActionListener checkListener = new GoToCharacterCreate();
            checkButton.addActionListener(checkListener);
            checkButton.setBounds(1180, 620, 64, 64);
            buttonList.add(checkButton);

            con.add(checkButton);
            con.add(backButton3);
            con.add(hmpPanel);

            break;
        case 4: // Character Creation
            ImageIcon characterCreationImage = new ImageIcon(".//res//BackgroundCharacterCreate.png");
            JLabel characterCreationLabel = new JLabel(characterCreationImage);
            JPanel characterCreationPanel = new JPanel();
            characterCreationPanel.setBounds(0, 0, 1280, 720);
            activePanel = characterCreationPanel;
            characterCreationPanel.add(characterCreationLabel);

            // This button was copied from the credits display scene, but I had to make it
            // different so I added a 4 to the end of everything
            ImageIcon backButtonImage4 = new ImageIcon(".//res//ButtonX.png");
            JButton backButton4 = new JButton(backButtonImage4);
            ActionListener backListener4 = new GoToTitle();
            backButton4.addActionListener(backListener4);
            backButton4.setBounds(1180, 10, 64, 64);
            buttonList.add(backButton4);

            // This button was copied from the HMP display scene, but I had to make it
            // different so I added a 2 to the end of everything
            ImageIcon checkButtonImage2 = new ImageIcon(".//res//ButtonCheck.png");
            JButton checkButton2 = new JButton(checkButtonImage2);
            ActionListener checkListener2 = new GoToBoard();
            checkButton2.addActionListener(checkListener2);
            checkButton2.setBounds(1180, 620, 64, 64);
            buttonList.add(checkButton2);

            con.add(checkButton2);
            con.add(backButton4);
            con.add(characterCreationPanel);

            break;

        case 5: // Game Board
        ImageIcon boardImage = new ImageIcon(".//res//BackgroundBoard.png");
        JLabel boardLabel = new JLabel(boardImage);
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(0, 0, 1280, 720);
        activePanel = boardPanel;
        boardPanel.add(boardLabel);
        
        con.add(boardPanel);

            break;
        default:
            System.out.println("Unknown number/ not yet implemented");
        }
    }

    /**
     * This method will refresh the frame when it is called
     */
    public void refresh() {
        validate();
        repaint();
    }

    /**
     * This method will hide the active panel so a new one can be displayed
     */
    public void hideActivePanel() {
        if (activePanel != null) {
            activePanel.setVisible(false);
        }
        for (JButton button : buttonList) {
            button.setVisible(false);
        }
        for (JPanel panel : panelList) {
            panel.setVisible(false);
        }

    }

}

/**
 * This class makes the button that switches the scene display to the credits
 * screen
 */
class GoToCredits implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(1);
        IslandDrawing.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the settings
 * screen
 */
class GoToSettings implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(2);
        IslandDrawing.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the "How many
 * players" screen
 */
class GoToHMP implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(3);
        IslandDrawing.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the character
 * creations screen
 */
class GoToCharacterCreate implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(4);
        IslandDrawing.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the board
 * screen
 */
class GoToBoard implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(5);
        IslandDrawing.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the title
 * screen
 */
class GoToTitle implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(0);
        IslandDrawing.g.refresh();

    }
}
