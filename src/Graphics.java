
/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
* This is the Graphics class for the Isle of Laeso group project.
*/

/*
TODO:

- Make a way to stop buttons from working? - Maybe a boolean called active that is turned on/off when conditions are met?

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
import java.awt.GraphicsEnvironment;

public class Graphics extends JFrame {

    int displayState;
    JFrame frame = new JFrame();
    Container con = this.getContentPane();
    JPanel activePanel;
    ArrayList<JButton> buttonList = new ArrayList<JButton>();
    ArrayList<JPanel> textPanelList = new ArrayList<JPanel>();
    ArrayList<JPanel> resourceList = new ArrayList<JPanel>();
    ArrayList<JPanel> playerList = new ArrayList<JPanel>();
    ArrayList<JPanel> buildingList = new ArrayList<JPanel>();

    static int hmp = 2;
    String boardText = "Welcome to the Isle of Laeso!";

    /**
     * This is the constructor for the graphics class which sets up some of the
     * JFrame attributes
     */
    public Graphics() {
        this.displayState = 0;
        this.setBounds(10, 10, 1294, 764);
        this.setResizable(false);
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
                startButton.setBounds(485, 390, 311, 85);
                buttonList.add(startButton);

                ImageIcon instructionsButtonImage = new ImageIcon(".//res//ButtonInstructions.png");
                JButton instructionsButton = new JButton(instructionsButtonImage);
                ActionListener instructionsListener = new GoToInstructions();
                instructionsButton.addActionListener(instructionsListener);
                instructionsButton.setBounds(485, 490, 311, 85);
                buttonList.add(instructionsButton);

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

                int[] tempInventory = new int[5];
                Player joey = new Player(100, 100, "Joey", "Armor", "Casual", "Yellow", tempInventory, 3);
                displayPlayer(joey);

                displayResource(0, 200, 100);
                displayResource(1, 200, 130);
                displayResource(2, 200, 160);
                displayResource(3, 200, 190);
                displayResource(4, 200, 220);
                displayResource(5, 200, 250);

                displayBuilding(0, "Red", 300, 100);
                displayBuilding(1, "Yellow", 300, 150);
                displayBuilding(2, "Green", 300, 200);
                displayBuilding(3, "Blue", 300, 250);

                con.add(settingsButton);
                con.add(creditsButton);
                con.add(instructionsButton);
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

                displayText("Player 1:", 40, 200, 200, 200, 36f); // This will change based off the turn variable.

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
                ActionListener armorBodyListener = new SetBodyArmor();
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

                previewPlayer();

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

                displayBoardText(boardText);

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
                buildButton.setBounds(435, 589, 138, 138);
                buttonList.add(buildButton);

                ImageIcon dieImage = new ImageIcon(".//res//Die1.png"); // We'll have to add an if statement here to
                                                                        // display
                                                                        // the correct die depending on the settings
                JButton dieButton = new JButton(dieImage);
                ActionListener dieListener = new DiceRoll();
                dieButton.addActionListener(dieListener);
                dieButton.setBounds(571, 589, 138, 138);
                buttonList.add(dieButton);

                ImageIcon attackImage = new ImageIcon(".//res//ButtonAttack.png");
                JButton attackButton = new JButton(attackImage);
                ActionListener attackListener = new Build();
                attackButton.addActionListener(attackListener);
                attackButton.setBounds(707, 589, 138, 138);
                buttonList.add(attackButton);

                MousePressListener mpl = new MousePressListener();
                activePanel.addMouseListener(mpl);

                con.add(dieButton);
                con.add(buildButton);
                con.add(attackButton);
                con.add(boardPanel);

                break;
            case 6:
                ImageIcon instructionsImage = new ImageIcon(".//res//BackgroundInstructions.png");
                JLabel instructionsLabel = new JLabel(instructionsImage);
                JPanel instructionsPanel = new JPanel();
                instructionsPanel.setBounds(0, 0, 1280, 720);
                activePanel = instructionsPanel;
                instructionsPanel.add(instructionsLabel);

                ImageIcon backButtonImage5 = new ImageIcon(".//res//ButtonX.png");
                JButton backButton5 = new JButton(backButtonImage5);
                ActionListener backListener5 = new GoToTitle();
                backButton5.addActionListener(backListener5);
                backButton5.setBounds(1200, 10, 64, 64);
                buttonList.add(backButton5);

                con.add(backButton5);
                con.add(instructionsPanel);
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
    public void hideActivePanel() { // Maybe I should split this up so everything isnt refreshed when the big panel
                                    // changes
        if (activePanel != null) {
            activePanel.setVisible(false);
        }
        for (JButton button : buttonList) {
            button.setVisible(false);
        }
        for (JPanel panel : textPanelList) {
            panel.setVisible(false);
        }
        for (JPanel panel : playerList) {
            panel.setVisible(false);
        }
        for (JPanel panel : resourceList) {
            panel.setVisible(false);
        }
        for (JPanel panel : buildingList) {
            panel.setVisible(false);
        }

    }

    public void hidePlayers() { // Not used...
        for (JPanel panel : playerList) {
            panel.setVisible(false);
        }
    }

    public void refreshPlayerCreation() {
        hideActivePanel();
        sceneDisplay(4);
        refresh();
    }

    public void refreshBoard() {
        hideActivePanel();
        sceneDisplay(5);
        refresh();
    }

    /**
     * This method displays text at the top of the screen. Specifically for the game
     * board.
     * 
     * @param text
     */
    public void displayBoardText(String text) {

        // This code is modified from
        // https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        Font customFont = null;
        try {
            // create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Norse-Bold.otf")).deriveFont(42f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel textLabel = new JLabel(text);
        textLabel.setFont(customFont);
        textLabel.setForeground(new Color(0, 0, 0)); // Changes the text color

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(0, 0, 0, 0));
        textPanel.setBounds(0, 10, 1280, 100);
        textPanel.add(textLabel);
        textPanelList.add(textPanel);
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
    public void displayText(String text, int x, int y, int w, int h, float size) {

        // (Again) This code is modified from
        // https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java
        Font customFont = null;
        try {
            // create the font to use. Specify the size!
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Norse-Bold.otf")).deriveFont(size);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // register the font
            ge.registerFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        JLabel textLabel = new JLabel(text);
        textLabel.setFont(customFont);
        textLabel.setForeground(new Color(0, 0, 0)); // Changes the text color

        JPanel textPanel = new JPanel();
        textPanel.setBackground(new Color(0, 0, 0, 0));
        textPanel.setBounds(x, y, w, h);
        textPanel.add(textLabel);
        textPanelList.add(textPanel);
        con.add(textPanel);
    }

    /**
     * This method displays the character depending on the ___
     * 
     * @param x
     * @param y
     */
    public void displayPlayer(Player p) {

        ImageIcon characterHat = new ImageIcon();
        ImageIcon characterColor = new ImageIcon();
        ImageIcon characterBody = new ImageIcon();

        characterColor = new ImageIcon(".//res//CharacterN.png");
        characterBody = new ImageIcon(".//res//CharacterN.png");

        if (p.getHat().equals("Casual")) {
            characterHat = new ImageIcon(".//res//CasualHat.png");
        } else if (p.getHat().equals("Armor")) {
            characterHat = new ImageIcon(".//res//ArmorHat.png");
        } else if (p.getHat().equals("Traditional")) {
            characterHat = new ImageIcon(".//res//TraditionalHat.png");
        }

        if (p.getColor().equals("Red")) {
            characterColor = new ImageIcon(".//res//HeadRed.png");
        } else if (p.getColor().equals("Yellow")) {
            characterColor = new ImageIcon(".//res//HeadYellow.png");
        } else if (p.getColor().equals("Green")) {
            characterColor = new ImageIcon(".//res//HeadGreen.png");
        } else if (p.getColor().equals("Blue")) {
            characterColor = new ImageIcon(".//res//HeadBlue.png");
        }

        if (p.getClothes().equals("Casual")) {
            characterBody = new ImageIcon(".//res//CasualBody.png");
        } else if (p.getClothes().equals("Armor")) {
            characterBody = new ImageIcon(".//res//ArmorBody.png");
        } else if (p.getClothes().equals("Traditional")) {
            characterBody = new ImageIcon(".//res//TraditionalBody.png");
        }

        JLabel hatLabel = new JLabel(characterHat);
        JPanel hatPanel = new JPanel();
        hatPanel.setBackground(new Color(0, 0, 0, 0));
        hatPanel.setBounds(p.getXPos(), p.getYPos() - 3, 64, 74);
        hatPanel.add(hatLabel);

        JLabel colorLabel = new JLabel(characterColor);
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(new Color(0, 0, 0, 0));
        colorPanel.setBounds(p.getXPos(), p.getYPos() + 10, 64, 74);
        colorPanel.add(colorLabel);

        JLabel bodyLabel = new JLabel(characterBody);
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(0, 0, 0, 0));
        bodyPanel.setBounds(p.getXPos(), p.getYPos() + 40, 64, 74);
        bodyPanel.add(bodyLabel);

        playerList.add(hatPanel);
        playerList.add(colorPanel);
        playerList.add(bodyPanel);
        con.add(hatPanel);
        con.add(colorPanel);
        con.add(bodyPanel);

    }

    /**
     * This method displays the resource depending on the type and coords.
     * 
     * @param type
     * @param x
     * @param y
     */
    public void displayResource(int type, int x, int y) { // I'm not sure what the types are for the resources
        ImageIcon resImage = new ImageIcon();

        if (type == 0) {
            resImage = new ImageIcon(".//res//ResLog.png");
        } else if (type == 1) {
            resImage = new ImageIcon(".//res//ResPerson.png");
        } else if (type == 2) {
            resImage = new ImageIcon(".//res//ResFood.png");
        } else if (type == 3) {
            resImage = new ImageIcon(".//res//ResRock.png");
        } else if (type == 4) {
            resImage = new ImageIcon(".//res//ResOre.png");
        } else if (type == 5) {
            resImage = new ImageIcon(".//res//ResMagic.png");
        }

        JLabel resLabel = new JLabel(resImage);
        JPanel resPanel = new JPanel();
        resPanel.setBackground(new Color(0, 0, 0, 0));
        resPanel.setBounds(x, y, 64, 74);
        resPanel.add(resLabel);
        resourceList.add(resPanel);
        con.add(resPanel);
    }

    /**
     * This method displays the resource depending on the type and coords.
     * 
     * @param type
     * @param x
     * @param y
     */
    public void displayBuilding(int type, String color, int x, int y) { // I'm not sure what the types are for the
                                                                        // resources
        ImageIcon buildingImage = new ImageIcon();

        if (type == 0) { // Town
            if (color.equals("Brown")) {
                buildingImage = new ImageIcon(".//res//TownBrown.png");
            } else if (color.equals("Red")) {
                buildingImage = new ImageIcon(".//res//TownRed.png");
            } else if (color.equals("Yellow")) {
                buildingImage = new ImageIcon(".//res//TownYellow.png");
            } else if (color.equals("Green")) {
                buildingImage = new ImageIcon(".//res//TownGreen.png");
            } else if (color.equals("Blue")) {
                buildingImage = new ImageIcon(".//res//TownBlue.png");
            }

        } else if (type == 1) { // Fort
            if (color.equals("Brown")) {
                buildingImage = new ImageIcon(".//res//FortBrown.png");
            } else if (color.equals("Red")) {
                buildingImage = new ImageIcon(".//res//FortRed.png");
            } else if (color.equals("Yellow")) {
                buildingImage = new ImageIcon(".//res//FortYellow.png");
            } else if (color.equals("Green")) {
                buildingImage = new ImageIcon(".//res//FortGreen.png");
            } else if (color.equals("Blue")) {
                buildingImage = new ImageIcon(".//res//FortBlue.png");
            }

        } else if (type == 2) { // Port
            if (color.equals("Brown")) {
                buildingImage = new ImageIcon(".//res//PortBrown.png");
            } else if (color.equals("Red")) {
                buildingImage = new ImageIcon(".//res//PortRed.png");
            } else if (color.equals("Yellow")) {
                buildingImage = new ImageIcon(".//res//PortYellow.png");
            } else if (color.equals("Green")) {
                buildingImage = new ImageIcon(".//res//PortGreen.png");
            } else if (color.equals("Blue")) {
                buildingImage = new ImageIcon(".//res//PortBlue.png");
            }

        } else if (type == 3) { // Storehouse
            if (color.equals("Brown")) {
                buildingImage = new ImageIcon(".//res//StorehouseBrown.png");
            } else if (color.equals("Red")) {
                buildingImage = new ImageIcon(".//res//StorehouseRed.png");
            } else if (color.equals("Yellow")) {
                buildingImage = new ImageIcon(".//res//StorehouseYellow.png");
            } else if (color.equals("Green")) {
                buildingImage = new ImageIcon(".//res//StorehouseGreen.png");
            } else if (color.equals("Blue")) {
                buildingImage = new ImageIcon(".//res//StorehouseBlue.png");
            }
        }

        JLabel buildingLabel = new JLabel(buildingImage);
        JPanel buildingPanel = new JPanel();
        buildingPanel.setBackground(new Color(0, 0, 0, 0));
        buildingPanel.setBounds(x, y, 64, 74);
        buildingPanel.add(buildingLabel);
        buildingList.add(buildingPanel);
        con.add(buildingPanel);
    }

    public void previewPlayer() {
        Player tempPlayer = new Player(1100, 620, TheIsleOfLaeso.name, TheIsleOfLaeso.hat, TheIsleOfLaeso.clothes,
                TheIsleOfLaeso.color, null, 3);
        displayPlayer(tempPlayer);
    }

}

// ================================================================================================================================================
// ================================================================================================================================================
// ================================================================================================================================================

// ____________________ GO TOs ____________________

/**
 * This class makes the button that switches the scene display to the credits
 * screen
 */
class GoToCredits implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(1);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the settings
 * screen
 */
class GoToSettings implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(2);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the
 * instructions screen
 */
class GoToInstructions implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(6);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the "How many
 * players" screen
 */
class GoToHMP implements ActionListener { // AKA the Start button

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(3);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the character
 * creations screen
 * 
 * This button also creates the correct number of Player objects, depending on
 * the hmp variable.
 */
class GoToCharacterCreate implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(4);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the board
 * screen
 */
class GoToBoard implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(5);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the title
 * screen
 */
class GoToTitle implements ActionListener { // This should also call a reset method to reset the players and board

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(0);
        TheIsleOfLaeso.g.refresh();

    }
}

// ____________________ HOW MANY PLAYERS ____________________

/**
 * This class makes the button that sets the number of players to 2.
 */
class SetHMP2 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.numOfPlayer = 2;
    }
}

/**
 * This class makes the button that sets the number of players to 3.
 */
class SetHMP3 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.numOfPlayer = 3;
    }
}

/**
 * This class makes the button that sets the number of players to 4.
 */
class SetHMP4 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.numOfPlayer = 4;
    }
}

// ____________________ COLORS ____________________

/**
 * This class makes the button that sets a player's color to red.
 */
class SetColorRed implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.color = "Red";
        // IslandDrawing.g.hidePlayers(); // I don't like needing to redo the entire
        // scene each time a button is clicked. I would prefer to just use
        // hidePlayers(), but that hasn't worked so far.
        TheIsleOfLaeso.g.refreshPlayerCreation();

    }
}

/**
 * This class makes the button that sets a player's color to yellow.
 */
class SetColorYellow implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.color = "Yellow";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's color to green.
 */
class SetColorGreen implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.color = "Green";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's color to blue.
 */
class SetColorBlue implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.color = "Blue";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

// ____________________ HATS ____________________

/**
 * This class makes the button that sets a player's hat to causal.
 */
class SetHatCasual implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Casual";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's hat to armor.
 */
class SetHatArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Armor";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's hat to traditional.
 */
class SetHatTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Traditional";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

// ____________________ BODYS ____________________

/**
 * This class makes the button that sets a player's body to causal.
 */
class SetBodyCasual implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.clothes = "Casual";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's body to armor.
 */
class SetBodyArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.clothes = "Armor";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's body to traditional.
 */
class SetBodyTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.clothes = "Traditional";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

// ____________________ BOARD BUTTONS ____________________

/**
 * This class makes the button that rolls the dice.
 */
class DiceRoll implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        int roll1, roll2;
        roll1 = TheIsleOfLaeso.dice.roll();
        roll2 = TheIsleOfLaeso.dice.roll();

        System.out.println("The rolls were " + roll1 + " and " + roll2);
        TheIsleOfLaeso.g.boardText = "Player _'s turn. " + roll1 + " moves, " + roll2 + " collects left";

        TheIsleOfLaeso.g.refreshBoard();

        TheIsleOfLaeso.incPhase();
        System.out.println("The phase is now " + TheIsleOfLaeso.getPhase());
    }
}

/**
 * This class makes the button that ends a player's turn without attacking or
 * building.
 */
class EndTurn implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.incPhase();
        System.out.println("The phase is now " + TheIsleOfLaeso.getPhase());
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