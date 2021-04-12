
/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
* This is the Graphics class for the Isle of Laeso group project.
*/

/*
TODO:
- Learn how to use the fonts in the res folder
- Make methods to display characters and resources
- A reset method to reset player data and board

Team?:
- Add functionality to buttons - Other guys code needed for that
- Figure out how the build menu will work
- Make a way to stop buttons from working? - Maybe a boolean called active that is turned on/off when conditions are met?

Extra:
- Add a way to display what the character looks like on the character creation screen.

*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Container;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

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
            startButton.setBounds(481, 390, 311, 85);
            buttonList.add(startButton);

            ImageIcon creditsButtonImage = new ImageIcon(".//res//ButtonCredits.png");
            JButton creditsButton = new JButton(creditsButtonImage);
            ActionListener creditsListener = new GoToCredits();
            creditsButton.addActionListener(creditsListener);
            creditsButton.setBounds(30, 620, 311, 85);
            buttonList.add(creditsButton);

            ImageIcon settingsButtonImage = new ImageIcon(".//res//ButtonSettings.png");
            JButton settingsButton = new JButton(settingsButtonImage);
            ActionListener settingsListener = new GoToSettings();
            settingsButton.addActionListener(settingsListener);
            settingsButton.setBounds(930, 620, 311, 85);
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
            backButton.setBounds(1200, 10, 64, 64);
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
            backButton2.setBounds(1200, 10, 64, 64);
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
            backButton3.setBounds(1200, 10, 64, 64);
            buttonList.add(backButton3);

            ImageIcon checkButtonImage = new ImageIcon(".//res//ButtonCheck.png");
            JButton checkButton = new JButton(checkButtonImage);
            ActionListener checkListener = new GoToCharacterCreate();
            checkButton.addActionListener(checkListener);
            checkButton.setBounds(1200, 620, 64, 64);
            buttonList.add(checkButton);

            ImageIcon HMP2Image = new ImageIcon(".//res//Button2.png");
            JButton HMP2Button = new JButton(HMP2Image);
            HMP2Button.setContentAreaFilled(false);
            HMP2Button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener HMP2Listener = new SetHMP2();
            HMP2Button.addActionListener(HMP2Listener);
            HMP2Button.setBounds(438, 420, 118, 118);
            buttonList.add(HMP2Button);

            ImageIcon HMP3Image = new ImageIcon(".//res//Button3.png");
            JButton HMP3Button = new JButton(HMP3Image);
            HMP3Button.setContentAreaFilled(false);
            HMP3Button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener HMP3Listener = new SetHMP3();
            HMP3Button.addActionListener(HMP3Listener);
            HMP3Button.setBounds(581, 420, 118, 118);
            buttonList.add(HMP3Button);

            ImageIcon HMP4Image = new ImageIcon(".//res//Button4.png");
            JButton HMP4Button = new JButton(HMP4Image);
            HMP4Button.setContentAreaFilled(false);
            HMP4Button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener HMP4Listener = new SetHMP4();
            HMP4Button.addActionListener(HMP4Listener);
            HMP4Button.setBounds(724, 420, 118, 117);
            buttonList.add(HMP4Button);

            con.add(checkButton);
            con.add(backButton3);
            con.add(HMP2Button);
            con.add(HMP3Button);
            con.add(HMP4Button);
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
            backButton4.setBounds(1200, 10, 64, 64);
            buttonList.add(backButton4);

            // This button was copied from the HMP display scene, but I had to make it
            // different so I added a 2 to the end of everything
            ImageIcon checkButtonImage2 = new ImageIcon(".//res//ButtonCheck.png");
            JButton checkButton2 = new JButton(checkButtonImage2);
            ActionListener checkListener2 = new GoToBoard();
            checkButton2.addActionListener(checkListener2);
            checkButton2.setBounds(1200, 620, 64, 64);
            buttonList.add(checkButton2);

            // ____________________ COLOR BUTTONS ____________________

            // Solution to make the button background and border disapear from
            // https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
            ImageIcon redImage = new ImageIcon(".//res//ButtonRed.png");
            JButton redButton = new JButton(redImage);
            redButton.setContentAreaFilled(false);
            redButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener redListener = new SetColorRed();
            redButton.addActionListener(redListener);
            redButton.setBounds(450, 288, 117, 117);
            buttonList.add(redButton);

            ImageIcon yellowImage = new ImageIcon(".//res//ButtonYellow.png");
            JButton yellowButton = new JButton(yellowImage);
            yellowButton.setContentAreaFilled(false);
            yellowButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener yellowListener = new SetColorYellow();
            yellowButton.addActionListener(yellowListener);
            yellowButton.setBounds(572, 288, 117, 117);
            buttonList.add(yellowButton);

            ImageIcon greenImage = new ImageIcon(".//res//ButtonGreen.png");
            JButton greenButton = new JButton(greenImage);
            greenButton.setContentAreaFilled(false);
            greenButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener greenListener = new SetColorGreen();
            greenButton.addActionListener(greenListener);
            greenButton.setBounds(694, 288, 117, 117);
            buttonList.add(greenButton);

            ImageIcon blueImage = new ImageIcon(".//res//ButtonBlue.png");
            JButton blueButton = new JButton(blueImage);
            blueButton.setContentAreaFilled(false);
            blueButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener blueListener = new SetColorBlue();
            blueButton.addActionListener(blueListener);
            blueButton.setBounds(816, 288, 117, 117);
            buttonList.add(blueButton);

            // ____________________ HAT BUTTONS ____________________

            ImageIcon casualHatImage = new ImageIcon(".//res//ButtonCasualHat.png");
            JButton casualHatButton = new JButton(casualHatImage);
            casualHatButton.setContentAreaFilled(false);
            casualHatButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener casualHatListener = new SetHatCasual();
            casualHatButton.addActionListener(casualHatListener);
            casualHatButton.setBounds(514, 420, 117, 117);
            buttonList.add(casualHatButton);

            ImageIcon armorHatImage = new ImageIcon(".//res//ButtonArmorHat.png");
            JButton armorHatButton = new JButton(armorHatImage);
            armorHatButton.setContentAreaFilled(false);
            armorHatButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener armorHatListener = new SetHatArmor();
            armorHatButton.addActionListener(armorHatListener);
            armorHatButton.setBounds(636, 420, 117, 117);
            buttonList.add(armorHatButton);

            ImageIcon traditionalHatImage = new ImageIcon(".//res//ButtonTraditionalHat.png");
            JButton traditionalHatButton = new JButton(traditionalHatImage);
            traditionalHatButton.setContentAreaFilled(false);
            traditionalHatButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener traditionalHatListener = new SetHatTraditional();
            traditionalHatButton.addActionListener(traditionalHatListener);
            traditionalHatButton.setBounds(758, 420, 117, 117);
            buttonList.add(traditionalHatButton);

            // ____________________ BODY BUTTONS ____________________

            ImageIcon casualBodyImage = new ImageIcon(".//res//ButtonCasualBody.png");
            JButton casualBodyButton = new JButton(casualBodyImage);
            casualBodyButton.setContentAreaFilled(false);
            casualBodyButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener casualBodyListener = new SetBodyCasual();
            casualBodyButton.addActionListener(casualBodyListener);
            casualBodyButton.setBounds(514, 557, 117, 117);
            buttonList.add(casualBodyButton);

            ImageIcon armorBodyImage = new ImageIcon(".//res//ButtonArmorBody.png");
            JButton armorBodyButton = new JButton(armorBodyImage);
            armorBodyButton.setContentAreaFilled(false);
            armorBodyButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener armorBodyListener = new SetHatArmor();
            armorBodyButton.addActionListener(armorBodyListener);
            armorBodyButton.setBounds(636, 557, 117, 117);
            buttonList.add(armorBodyButton);

            ImageIcon traditionalBodyImage = new ImageIcon(".//res//ButtonTraditionalBody.png");
            JButton traditionalBodyButton = new JButton(traditionalBodyImage);
            traditionalBodyButton.setContentAreaFilled(false);
            traditionalBodyButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            ActionListener traditionalBodyListener = new SetBodyTraditional();
            traditionalBodyButton.addActionListener(traditionalBodyListener);
            traditionalBodyButton.setBounds(758, 557, 117, 117);
            buttonList.add(traditionalBodyButton);

            con.add(checkButton2);
            con.add(backButton4);

            con.add(redButton);
            con.add(yellowButton);
            con.add(greenButton);
            con.add(blueButton);

            con.add(casualHatButton);
            con.add(armorHatButton);
            con.add(traditionalHatButton);

            con.add(casualBodyButton);
            con.add(armorBodyButton);
            con.add(traditionalBodyButton);

            con.add(characterCreationPanel);

            break;

        case 5: // Game Board

            displayBoardText("Welcome to the Isle of Laeso!");

            ImageIcon boardImage = new ImageIcon(".//res//BackgroundBoard.png");
            JLabel boardLabel = new JLabel(boardImage);
            JPanel boardPanel = new JPanel();
            boardPanel.setBounds(0, 0, 1280, 720);
            activePanel = boardPanel;
            boardPanel.add(boardLabel);

            ImageIcon buildImage = new ImageIcon(".//res//ButtonBuild.png");
            JButton buildButton = new JButton(buildImage);
            ActionListener buildListener = new Build();
            buildButton.addActionListener(buildListener);
            buildButton.setBounds(435, 584, 138, 138);
            buttonList.add(buildButton);

            ImageIcon dieImage = new ImageIcon(".//res//Die1.png"); // We'll have to add an if statement here to display
                                                                    // the correct die depending on the settings
            JButton dieButton = new JButton(dieImage);
            ActionListener dieListener = new DiceRoll();
            dieButton.addActionListener(dieListener);
            dieButton.setBounds(571, 584, 138, 138);
            buttonList.add(dieButton);

            ImageIcon attackImage = new ImageIcon(".//res//ButtonAttack.png");
            JButton attackButton = new JButton(attackImage);
            ActionListener attackListener = new Build();
            attackButton.addActionListener(attackListener);
            attackButton.setBounds(707, 584, 138, 138);
            buttonList.add(attackButton);

            con.add(dieButton);
            con.add(buildButton);
            con.add(attackButton);
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

    /**
     * This method displays text at the top of the screen. Specifically for the game
     * board.
     * 
     * @param text
     */
    public void displayBoardText(String text) { // Trying to figure out how to use the fonts in the res folder...

        JLabel textLabel = new JLabel(text);
        textLabel.setForeground(new Color(0, 0, 0)); // Changes the text color

         // Font norse;
        // try {
        // textLabel.setFont(Font.createFont(Font.TRUETYPE_FONT, new
        // File(".//res//Norse-Bold.otf")));

        // } catch (FontFormatException | IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(0, 0, 0, 0));
        textPanel.setBounds(0, 30, 1280, 30);
        textPanel.add(textLabel);
        panelList.add(textPanel);
        con.add(textPanel);
    }

    /**
     * This method displays text at the passed in location.
     * 
     * @param text
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public void displayText(String text, int x, int y, int w, int h) {

        JLabel textLabel = new JLabel(text);
        textLabel.setForeground(new Color(0, 0, 0)); // Changes the text color

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(0, 0, 0, 0));
        textPanel.setBounds(x, y, w, h);
        textPanel.add(textLabel);
        panelList.add(textPanel);
        con.add(textPanel);
    }

    /**
     * This method displays the character depending on the ___
     * @param x
     * @param y
     */
    public void displayCharacter(int x, int y){ // I'm not sure how we'll pass in the data that determines the character, so I'll save this for later

    }

     /**
     * This method displays the resource depending on the type and coords.
     * @param type
     * @param x
     * @param y
     */
    public void displayResource(int type, int x, int y){ // I'm not sure what the types are for the resources

    }

}

// ____________________ GO TOS ____________________

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
class GoToTitle implements ActionListener { // This should also call a reset method to reset the players and board

    public void actionPerformed(ActionEvent event) {
        IslandDrawing.g.hideActivePanel();
        IslandDrawing.g.sceneDisplay(0);
        IslandDrawing.g.refresh();

    }
}

// ____________________ HOW MANY PLAYERS ____________________

/**
 * This class makes the button that sets the number of players to 2.
 */
class SetHMP2 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Number of players set to 2");

    }
}

/**
 * This class makes the button that sets the number of players to 3.
 */
class SetHMP3 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Number of players set to 3");

    }
}

/**
 * This class makes the button that sets the number of players to 4.
 */
class SetHMP4 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Number of players set to 4");

    }
}

// ____________________ COLORS ____________________

/**
 * This class makes the button that sets a player's color to red.
 */
class SetColorRed implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's color set to red");

    }
}

/**
 * This class makes the button that sets a player's color to yellow.
 */
class SetColorYellow implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's color set to yellow");

    }
}

/**
 * This class makes the button that sets a player's color to green.
 */
class SetColorGreen implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's color set to green");

    }
}

/**
 * This class makes the button that sets a player's color to blue.
 */
class SetColorBlue implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's color set to blue");

    }
}

// ____________________ HATS ____________________

/**
 * This class makes the button that sets a player's hat to causal.
 */
class SetHatCasual implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's hat set to casual");

    }
}

/**
 * This class makes the button that sets a player's hat to armor.
 */
class SetHatArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's hat set to armor");

    }
}

/**
 * This class makes the button that sets a player's hat to traditional.
 */
class SetHatTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's hat set to traditional");

    }
}

// ____________________ BODYS ____________________

/**
 * This class makes the button that sets a player's body to causal.
 */
class SetBodyCasual implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's body set to casual");

    }
}

/**
 * This class makes the button that sets a player's body to armor.
 */
class SetBodyArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's body set to armor");

    }
}

/**
 * This class makes the button that sets a player's body to traditional.
 */
class SetBodyTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("Current player's body set to traditional");

    }
}

// ____________________ BOARD BUTTONS ____________________

/**
 * This class makes the button that rolls the dice.
 */
class DiceRoll implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("The dice button was pressed");

    }
}

/**
 * This class makes the button that builds structures.
 */
class Build implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("The build button was pressed");

    }
}

/**
 * This class makes the button that attacks players.
 */
class Attack implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        System.out.println("The attack button was pressed");

    }
}