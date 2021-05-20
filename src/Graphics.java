/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
* This is the Graphics class for the Isle of Laeso group project.
*/

/*
TODO:
    - Maybe fix the offset issue by assigning each spot on the map with an x and y? Each thing would still have its own offset based on its image, but the locations will all be mapped..
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
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
import java.io.FileNotFoundException;
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
    JTextField activeTextField;

    static int hmp = 2;
    String boardText = "Welcome to the Isle of Laeso!";

    boolean diceRolled = false;

    String playerName = "[type name here]";
    String colorTaken = "";
    String toBeBuilt = null;

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

                /*
                 * These lines are just practice for displaying players, resources, and
                 * buildings
                 */
                // int[] tempInventory = new int[5];
                // Player joey = new Player(100, 100, "Joey", "Casual", "Traditional", "Red",
                // tempInventory, 3);
                // displayPlayer(joey);
                // displaySmallPlayer(joey);

                // displayResource(0, 200, 100);
                // displayResource(1, 200, 130);
                // displayResource(2, 200, 160);
                // displayResource(3, 200, 190);
                // displayResource(4, 200, 220);
                // displayResource(5, 200, 250);

                // displayBuilding(0, "Red", 300, 100);
                // displayBuilding(1, "Yellow", 300, 150);
                // displayBuilding(2, "Green", 300, 200);
                // displayBuilding(3, "Blue", 300, 250);

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

                // This button was added later, and I had to make it different so I added a 3 to
                // the end of everything
                ImageIcon checkButtonImage3 = new ImageIcon(".//res//ButtonCheck.png");
                JButton checkButton3 = new JButton(checkButtonImage3);
                ActionListener checkListener3 = new GoToTitle(); // This might need to be a unique button that saves the
                                                                 // settings
                checkButton3.addActionListener(checkListener3);
                checkButton3.setBounds(1200, 620, 64, 64);
                buttonList.add(checkButton3);

                // ____________________ DICE BUTTONS ____________________

                // Solution to make the button background and border disapear from
                // https://stackoverflow.com/questions/423950/rounded-swing-jbutton-using-java
                ImageIcon die1Image = new ImageIcon(".//res//Die1.png");
                JButton die1Button = new JButton(die1Image);
                ActionListener die1Listener = new SetDie1();
                die1Button.addActionListener(die1Listener);
                die1Button.setBounds(469, 288, 117, 117);
                buttonList.add(die1Button);

                ImageIcon die2Image = new ImageIcon(".//res//Die2.png");
                JButton die2Button = new JButton(die2Image);
                ActionListener die2Listener = new SetDie2();
                die2Button.addActionListener(die2Listener);
                die2Button.setBounds(591, 288, 117, 117);
                buttonList.add(die2Button);

                ImageIcon die3Image = new ImageIcon(".//res//Die3.png");
                JButton die3Button = new JButton(die3Image);
                ActionListener die3Listener = new SetDie3();
                die3Button.addActionListener(die3Listener);
                die3Button.setBounds(713, 288, 117, 117);
                buttonList.add(die3Button);

                ImageIcon die4Image = new ImageIcon(".//res//Die4.png");
                JButton die4Button = new JButton(die4Image);
                ActionListener die4Listener = new SetDie4();
                die4Button.addActionListener(die4Listener);
                die4Button.setBounds(835, 288, 117, 117);
                buttonList.add(die4Button);

                // ____________________ RESOURCE RATES BUTTONS ____________________

                ImageIcon lowImage = new ImageIcon(".//res//ButtonLow.png");
                JButton lowButton = new JButton(lowImage);
                ActionListener lowListener = new SetSpawnLow();
                lowButton.addActionListener(lowListener);
                lowButton.setBounds(469, 420, 117, 117);
                buttonList.add(lowButton);

                ImageIcon medImage = new ImageIcon(".//res//ButtonMed.png");
                JButton medButton = new JButton(medImage);
                ActionListener medListener = new SetSpawnMed();
                medButton.addActionListener(medListener);
                medButton.setBounds(591, 420, 117, 117);
                buttonList.add(medButton);

                ImageIcon highImage = new ImageIcon(".//res//ButtonHigh.png");
                JButton highButton = new JButton(highImage);
                ActionListener highListener = new SetSpawnHigh();
                highButton.addActionListener(highListener);
                highButton.setBounds(713, 420, 117, 117);
                buttonList.add(highButton);

                // ____________________ NATURAL DISASTER BUTTONS ____________________

                ImageIcon onImage = new ImageIcon(".//res//ButtonOn.png");
                JButton onButton = new JButton(onImage);
                ActionListener onListener = new SetDisastersOn();
                onButton.addActionListener(onListener);
                onButton.setBounds(469, 557, 117, 117);
                buttonList.add(onButton);

                ImageIcon offImage = new ImageIcon(".//res//ButtonOff.png");
                JButton offButton = new JButton(offImage);
                ActionListener offListener = new SetDisastersOff();
                offButton.addActionListener(offListener);
                offButton.setBounds(591, 557, 117, 117);
                buttonList.add(offButton);

                // ____________________ DEFAULT BUTTON ____________________

                ImageIcon defaultImage = new ImageIcon(".//res//ButtonDefault.png");
                JButton defaultButton = new JButton(defaultImage);
                ActionListener defaultListener = new SettingsDefault();
                defaultButton.addActionListener(defaultListener);
                defaultButton.setBounds(835, 557, 117, 117);
                buttonList.add(defaultButton);
                displayText("Default is", 935, 577, 200, 200, 18f);
                displayText("The first die color,", 935, 597, 200, 200, 18f);
                displayText("medium spawn rate,", 935, 617, 200, 200, 18f);
                displayText("and disasters off.", 935, 637, 200, 200, 18f);

                displayText("Preferred:", 275, 308, 200, 200, 36f);
                displayText("Die:", 275, 348, 200, 200, 36f);
                displayText("Resource", 275, 440, 200, 200, 36f);
                displayText("Spawn Rate:", 275, 480, 200, 200, 36f);
                displayText("Natural", 275, 577, 200, 200, 36f);
                displayText("Disasters:", 275, 617, 200, 200, 36f);

                con.add(backButton2);
                con.add(checkButton3);

                con.add(die1Button);
                con.add(die2Button);
                con.add(die3Button);
                con.add(die4Button);

                con.add(lowButton);
                con.add(medButton);
                con.add(highButton);

                con.add(onButton);
                con.add(offButton);

                con.add(defaultButton);

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

                displayText("Player " + TheIsleOfLaeso.playerTurn + ":", 1050, 570, 200, 200, 36f);
                displayText(colorTaken, 760, 330, 600, 200, 21f);

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

                ImageIcon nextPlayerImage = new ImageIcon(".//res//ButtonCheck.png");
                JButton nextPlayerButton = new JButton(nextPlayerImage);
                ActionListener nextPlayer = new GoToNextPlayer();
                nextPlayerButton.addActionListener(nextPlayer);
                nextPlayerButton.setBounds(1200, 620, 64, 64);
                buttonList.add(nextPlayerButton);

                JTextField nameInput = new JTextField(playerName);
                nameInput.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                nameInput.setBounds(490, 170, 517, 97);
                nameInput.setBackground(new Color(0, 150, 150));
                nameInput.setForeground(new Color(40, 40, 40));
                activeTextField = nameInput;

                Font customFont = null;
                try {
                    // create the font to use. Specify the size!
                    customFont = Font.createFont(Font.TRUETYPE_FONT, new File(".//res//Norse-Bold.otf"))
                            .deriveFont(42f);
                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    // register the font
                    ge.registerFont(customFont);
                } catch (IOException | FontFormatException e) {
                    e.printStackTrace();
                }
                nameInput.setFont(customFont);

                JPanel textFieldBorderPanel = new JPanel();
                textFieldBorderPanel.setBackground(new Color(78, 87, 102));
                textFieldBorderPanel.setBounds(488, 168, 521, 101);
                textPanelList.add(textFieldBorderPanel);

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

                if (TheIsleOfLaeso.playerTurn < TheIsleOfLaeso.numOfPlayer) {
                    con.add(nextPlayerButton);
                } else {
                    con.add(checkButton2);
                }

                con.add(backButton4);

                con.add(nameInput);
                con.add(textFieldBorderPanel);

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

                ImageIcon dieImage = new ImageIcon();
                try {
                    if (IOSettings.findDie().equals("Die1")) {
                        dieImage = new ImageIcon(".//res//Die1.png");
                    } else if (IOSettings.findDie().equals("Die2")) {
                        dieImage = new ImageIcon(".//res//Die2.png");
                    } else if (IOSettings.findDie().equals("Die3")) {
                        dieImage = new ImageIcon(".//res//Die3.png");
                    } else if (IOSettings.findDie().equals("Die4")) {
                        dieImage = new ImageIcon(".//res//Die4.png");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                JButton dieButton = new JButton(dieImage);
                ActionListener dieListener = new DiceRoll();
                dieButton.addActionListener(dieListener);
                dieButton.setBounds(571, 589, 138, 138);
                buttonList.add(dieButton);

                ImageIcon attackImage = new ImageIcon(".//res//ButtonAttack.png");
                JButton attackButton = new JButton(attackImage);
                ActionListener attackListener = new Attack();
                attackButton.addActionListener(attackListener);
                attackButton.setBounds(707, 589, 138, 138);
                buttonList.add(attackButton);

                ImageIcon endTurnImage = new ImageIcon(".//res//ButtonEndTurn.png");
                JButton endTurnButton = new JButton(endTurnImage);
                ActionListener endTurnListener = new EndTurn();
                endTurnButton.addActionListener(endTurnListener);
                endTurnButton.setBounds(571, 589, 138, 138);
                buttonList.add(endTurnButton);

                MousePressListener mpl = new MousePressListener();
                activePanel.addMouseListener(mpl);

                /*
                 * These lines were made for testing displaying the profiles int[] inventory =
                 * new int[6]; Player profilePlayer = new Player(79, 630, "Billy Bob", "Armor",
                 * "Armor", "Green", inventory, 3); profilePlayer.addResource("wood", 3);
                 * profilePlayer.addResource("ore", 99);
                 *
                 * Player profilePlayer2 = new Player(297, 630, "Billy Bob", "Armor", "Armor",
                 * "Green", inventory, 3);
                 *
                 * Player profilePlayer3 = new Player(1135, 630, "Billy Bob", "Armor", "Armor",
                 * "Green", inventory, 3);
                 *
                 * Player profilePlayer4 = new Player(915, 630, "Billy Bob", "Armor", "Armor",
                 * "Green", inventory, 3);
                 *
                 * profileDisplay(profilePlayer); profileDisplay(profilePlayer2);
                 * profileDisplay(profilePlayer3); profileDisplay(profilePlayer4);
                 *
                 * // displayWin(0, profilePlayer);
                 */

                // Depending on the number of players, display in different places
                // 2: X O O X
                // 3: O O O X
                // 4: O O O O

                // 79, 630 \ 297, 630 \ 915, 630 \ 1135, 630
                if (TheIsleOfLaeso.numOfPlayer == 4) {
                    profileDisplay(TheIsleOfLaeso.players[0], 79, 630);
                    profileDisplay(TheIsleOfLaeso.players[1], 297, 630);
                    profileDisplay(TheIsleOfLaeso.players[2], 915, 630);
                    profileDisplay(TheIsleOfLaeso.players[3], 1135, 630);
                } else if (TheIsleOfLaeso.numOfPlayer == 3) {
                    profileDisplay(TheIsleOfLaeso.players[0], 79, 630);
                    profileDisplay(TheIsleOfLaeso.players[1], 297, 630);
                    profileDisplay(TheIsleOfLaeso.players[2], 915, 630);
                } else if (TheIsleOfLaeso.numOfPlayer == 2) {
                    profileDisplay(TheIsleOfLaeso.players[0], 297, 630);
                    profileDisplay(TheIsleOfLaeso.players[1], 915, 630);
                }

                displayBoard();

                if (!diceRolled) {
                    con.add(dieButton);
                } else {
                    con.add(endTurnButton);
                }

                con.add(buildButton);
                con.add(attackButton);
                con.add(boardPanel);

                break;
            case 6: // Instructions
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
            case 7: // Build Menu

                displayText("Click on the building you want to construct.", 0, 15, 1280, 60, 30f);
                if (toBeBuilt != null) {
                    displayText("Build a ", 950, 557, 90, 60, 30f);
                    displayText(toBeBuilt + "?", 930, 587, 130, 60, 30f);
                }
                displayText("Cancel", 990, 85, 70, 70, 30f);

                ImageIcon settingsImage2 = new ImageIcon(".//res//BackgroundSettings.png");
                JLabel settingsLabel2 = new JLabel(settingsImage2);
                JPanel settingsPanel2 = new JPanel();
                settingsPanel2.setBounds(0, 0, 1280, 720);
                activePanel = settingsPanel2;
                settingsPanel2.add(settingsLabel2);

                ImageIcon buildMenuImage = new ImageIcon();
                buildMenuImage = new ImageIcon(".//res//BuildMenu.png");
                JLabel buildMenuLabel = new JLabel(buildMenuImage);
                JPanel buildMenuPanel = new JPanel();
                buildMenuPanel.setBackground(new Color(0, 0, 0, 0));
                buildMenuPanel.setBounds(203, 10, 873, 697);
                buildMenuPanel.add(buildMenuLabel);
                playerList.add(buildMenuPanel);

                // This button was copied from the credits display scene, but I had to make it
                // different so I added a 6 to the end of everything
                ImageIcon backButtonImage6 = new ImageIcon(".//res//ButtonX.png");
                JButton backButton6 = new JButton(backButtonImage6);
                ActionListener backListener6 = new GoBackToBoard();
                backButton6.addActionListener(backListener6);
                backButton6.setBounds(1000, 19, 64, 64);
                buttonList.add(backButton6);

                // This button was copied from the HMP display scene, but I had to make it
                // different so I added a 4 to the end of everything
                ImageIcon checkButtonImage4 = new ImageIcon(".//res//ButtonCheck.png");
                JButton checkButton4 = new JButton(checkButtonImage4);
                ActionListener checkListener4 = new GoToBoardToBuild();
                checkButton4.addActionListener(checkListener4);
                checkButton4.setBounds(1000, 635, 64, 64);
                buttonList.add(checkButton4);

                BuildMenuMousePressListener bmmpl = new BuildMenuMousePressListener();
                activePanel.addMouseListener(bmmpl);

                con.add(backButton6);
                con.add(checkButton4);
                con.add(buildMenuPanel);
                con.add(settingsPanel2);

                break;
            case 8: // Win Screen

                ImageIcon settingsImage3 = new ImageIcon(".//res//BackgroundSettings.png");
                JLabel settingsLabel3 = new JLabel(settingsImage3);
                JPanel settingsPanel3 = new JPanel();
                settingsPanel3.setBounds(0, 0, 1280, 720);
                activePanel = settingsPanel3;
                settingsPanel3.add(settingsLabel3);

                // This button was copied from the credits display scene, but I had to make it
                // different so I added a 7 to the end of everything
                ImageIcon backButtonImage7 = new ImageIcon(".//res//ButtonX.png");
                JButton backButton7 = new JButton(backButtonImage7);
                ActionListener backListener7 = new GoToTitle();
                backButton7.addActionListener(backListener7);
                backButton7.setBounds(217, 652, 64, 64);
                buttonList.add(backButton7);

                // This button was copied from the HMP display scene, but I had to make it
                // different so I added a 5 to the end of everything
                ImageIcon checkButtonImage5 = new ImageIcon(".//res//ButtonCheck.png");
                JButton checkButton5 = new JButton(checkButtonImage5);
                ActionListener checkListener5 = new GoToBoard(); // THIS NEEDS TO CALL THE RESET GAME METHOD OR
                                                                 // SOMETHING
                checkButton5.addActionListener(checkListener5);
                checkButton5.setBounds(1000, 652, 64, 64);
                buttonList.add(checkButton5);

                JPanel extraPanel = new JPanel();
                extraPanel.setBackground(new Color(255, 255, 255));
                extraPanel.setBounds(203, 650, 873, 70); // 203, 10, 873, 639
                textPanelList.add(extraPanel);

                con.add(backButton7);
                con.add(checkButton5);
                con.add(extraPanel);
                con.add(settingsPanel3);

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
        if (activeTextField != null) {
            activeTextField.setVisible(false);
        }
    }

    public void hidePlayers() { // Not used...
        for (JPanel panel : playerList) {
            panel.setVisible(false);
        }
    }

    public void refreshPlayerCreation() {
        if (activeTextField != null) {
            playerName = activeTextField.getText();
        }
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
     * This method displays the character depending on the Player object's x and y
     * and traits (Note that this is the big version used for the preview Player and
     * profiles)
     *
     * @param p
     */
    public void displayPlayer(Player p, int x, int y) {

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
        hatPanel.setBounds(x, y - 3, 64, 74);
        hatPanel.add(hatLabel);

        JLabel colorLabel = new JLabel(characterColor);
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(new Color(0, 0, 0, 0));
        colorPanel.setBounds(x, y + 10, 64, 74);
        colorPanel.add(colorLabel);

        JLabel bodyLabel = new JLabel(characterBody);
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(0, 0, 0, 0));
        bodyPanel.setBounds(x, y + 40, 64, 74);
        bodyPanel.add(bodyLabel);

        playerList.add(hatPanel);
        playerList.add(colorPanel);
        playerList.add(bodyPanel);
        con.add(hatPanel);
        con.add(colorPanel);
        con.add(bodyPanel);

    }

    /**
     * This method displays the character depending on the Player object's x and y
     * and traits (Note that this is the small version used for displaying a player
     * on the board)
     *
     */
    public void displaySmallPlayer(Player p, int x, int y) {

        ImageIcon characterHat = new ImageIcon();
        ImageIcon characterColor = new ImageIcon();
        ImageIcon characterBody = new ImageIcon();

        characterHat = new ImageIcon(".//res//CharacterN.png");
        characterColor = new ImageIcon(".//res//CharacterN.png");
        characterBody = new ImageIcon(".//res//CharacterN.png");

        if (p.getHat().equals("Casual")) {
            characterHat = new ImageIcon(".//res//CasualHatSmall.png");
        } else if (p.getHat().equals("Armor")) {
            characterHat = new ImageIcon(".//res//ArmorHatSmall.png");
        } else if (p.getHat().equals("Traditional")) {
            characterHat = new ImageIcon(".//res//TraditionalHatSmall.png");
        }

        if (p.getColor().equals("Red")) {
            characterColor = new ImageIcon(".//res//HeadRedSmall.png");
        } else if (p.getColor().equals("Yellow")) {
            characterColor = new ImageIcon(".//res//HeadYellowSmall.png");
        } else if (p.getColor().equals("Green")) {
            characterColor = new ImageIcon(".//res//HeadGreenSmall.png");
        } else if (p.getColor().equals("Blue")) {
            characterColor = new ImageIcon(".//res//HeadBlueSmall.png");
        }

        if (p.getClothes().equals("Casual")) {
            characterBody = new ImageIcon(".//res//CasualBodySmall.png");
        } else if (p.getClothes().equals("Armor")) {
            characterBody = new ImageIcon(".//res//ArmorBodySmall.png");
        } else if (p.getClothes().equals("Traditional")) {
            characterBody = new ImageIcon(".//res//TraditionalBodySmall.png");
        }

        JLabel hatLabel = new JLabel(characterHat);
        JPanel hatPanel = new JPanel();
        hatPanel.setBackground(new Color(0, 0, 0, 0));
        hatPanel.setBounds(x, y - 2, 64, 74);
        hatPanel.add(hatLabel);

        JLabel colorLabel = new JLabel(characterColor);
        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(new Color(0, 0, 0, 0));
        colorPanel.setBounds(x, y + 6, 64, 74);
        colorPanel.add(colorLabel);

        JLabel bodyLabel = new JLabel(characterBody);
        JPanel bodyPanel = new JPanel();
        bodyPanel.setBackground(new Color(0, 0, 0, 0));
        bodyPanel.setBounds(x, y + 26, 64, 74);
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
    public void displayResource(int type, int x, int y) {
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
                buildingImage = new ImageIcon(".//res//FortGrey.png");
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
        } else if (type == 4) { // Boat
            if (color.equals("Brown")) {
                buildingImage = new ImageIcon(".//res//Boat.png");
            } else if (color.equals("Red")) {
                buildingImage = new ImageIcon(".//res//BoatRed.png");
            } else if (color.equals("Yellow")) {
                buildingImage = new ImageIcon(".//res//BoatYellow.png");
            } else if (color.equals("Green")) {
                buildingImage = new ImageIcon(".//res//BoatGreen.png");
            } else if (color.equals("Blue")) {
                buildingImage = new ImageIcon(".//res//BoatBlue.png");
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

    public void displayHeart(int x, int y) {
        ImageIcon heartImage = new ImageIcon();
        heartImage = new ImageIcon(".//res//Heart.png");
        JLabel heartLabel = new JLabel(heartImage);
        JPanel heartPanel = new JPanel();
        heartPanel.setBackground(new Color(0, 0, 0, 0));
        heartPanel.setBounds(x, y, 30, 30);
        heartPanel.add(heartLabel);
        playerList.add(heartPanel);
        con.add(heartPanel);

    }

    /**
     * This method displays what the player's character will look like.
     */
    public void previewPlayer() {
        Player tempPlayer = new Player(1100, 620, TheIsleOfLaeso.name, TheIsleOfLaeso.hat, TheIsleOfLaeso.clothes,
                TheIsleOfLaeso.color, null, 3);
        displayPlayer(tempPlayer, 1100, 620);
    }

    /**
     * This method displays a player's profile.
     *
     * @param p
     */
    public void profileDisplay(Player p, int x, int y) {

        // int x = p.getXPos();
        // int y = p.getYPos();

        // - Display player name
        // displayText(p.getName(), x - 96, y - 40, 150, 40, 27f);
        displayText(p.getName(), x - 56, y - 40, 110, 40, 27f);
        // - Display player
        displayPlayer(p, x, y);
        // - Display resource types
        displayResource(0, x - 79, y - 10);
        displayResource(1, x - 79, y + 17);
        displayResource(2, x - 79, y + 50);
        displayResource(3, x + 54, y - 10);
        displayResource(4, x + 54, y + 20);
        displayResource(5, x + 54, y + 50);
        // - Display amounts of resources
        displayText("x" + p.getResource("wood"), x - 29, y - 3, 30, 30, 20f);
        displayText("x" + p.getResource("people"), x - 29, y + 27, 30, 30, 20f);
        displayText("x" + p.getResource("food"), x - 29, y + 57, 30, 30, 20f);
        displayText("x" + p.getResource("stone"), x + 104, y - 3, 30, 30, 20f);
        displayText("x" + p.getResource("ore"), x + 104, y + 27, 30, 30, 20f);
        displayText("x" + p.getResource("magic"), x + 104, y + 57, 30, 30, 20f);
        // - Display health
        if (p.getHealth() == 3) {
            displayHeart(x + 60, y - 35);
            displayHeart(x + 85, y - 35);
            displayHeart(x + 110, y - 35);
        } else if (p.getHealth() == 2) {
            displayHeart(x + 85, y - 35);
            displayHeart(x + 110, y - 35);
        } else if (p.getHealth() == 1) {
            displayHeart(x + 110, y - 35);
        }
    }

    public void displayWin(int type, Player p) {

        TheIsleOfLaeso.g.hideActivePanel();

        displayText("Do you want to play again with the same players?", 0, 672, 1280, 60, 30f);
        displayText("Yes", 985, 612, 90, 60, 30f);
        displayText("Title", 214, 612, 70, 70, 30f);

        ImageIcon winImage = new ImageIcon();

        if (type == 0) { // Boat win
            winImage = new ImageIcon(".//res//WinScreenBoat.png");
        } else if (type == 1) { // Magic win
            winImage = new ImageIcon(".//res//WinScreenMagic.png");
        } else if (type == 2) { // Kill win
            winImage = new ImageIcon(".//res//WinScreenKill.png");
        }

        JLabel winLabel = new JLabel(winImage);
        JPanel winPanel = new JPanel();
        winPanel.setBackground(new Color(0, 0, 0, 0));
        winPanel.setBounds(203, 10, 873, 641);
        winPanel.add(winLabel);
        playerList.add(winPanel);
        displayText(p.getName(), 0, 180, 1280, 100, 60f);

        con.add(winPanel);

        TheIsleOfLaeso.g.sceneDisplay(8);
        TheIsleOfLaeso.g.refresh();

    }

    public void displayBoard() {
        String[][] theBoard = TheIsleOfLaeso.i.getBoard();

        int xOffset = 0;
        int yOffset = 0;

        for (int i = 0; i < theBoard.length; i++) {
            for (int j = 0; j < theBoard[i].length; j++) {

                if (j > 25) {
                    xOffset = -20;
                } else if (j > 20) {
                    xOffset = -10;
                } else if (j > 15) {
                    xOffset = -5;
                } else if (j > 10) {
                    xOffset = +2;
                } else if (j > 5) {
                    xOffset = +10;
                } else if (j > 0) {
                    xOffset = +12;
                }

                if (i > 8) {
                    yOffset = 0;
                } else if (i > 4) {
                    yOffset = -3;
                } else if (i > 0) {
                    yOffset = -6;
                }

                // Display resources
                if (TheIsleOfLaeso.i.contains("wood", j, i)) {
                    displayResource(0, (j * 43) - 35 + xOffset, (i * 40) + 73 + yOffset);
                } else if (TheIsleOfLaeso.i.contains("people", j, i)) {
                    displayResource(1, (j * 43) - 33 + xOffset, (i * 40) + 67 + yOffset);
                } else if (TheIsleOfLaeso.i.contains("food", j, i)) {
                    displayResource(2, (j * 43) - 31 + xOffset, (i * 40) + 73 + yOffset);
                } else if (TheIsleOfLaeso.i.contains("stone", j, i)) {
                    displayResource(3, (j * 43) - 30 + xOffset, (i * 40) + 73 + yOffset);
                } else if (TheIsleOfLaeso.i.contains("ore", j, i)) {
                    displayResource(4, (j * 43) - 33 + xOffset, (i * 40) + 73 + yOffset);
                } else if (TheIsleOfLaeso.i.contains("magic", j, i)) {
                    displayResource(5, (j * 43) - 31 + xOffset, (i * 40) + 73 + yOffset);
                }
            }
        }

        // Display players
        for (int i = 0; i < TheIsleOfLaeso.numOfPlayer; i++) {

            displaySmallPlayer(TheIsleOfLaeso.players[i], (TheIsleOfLaeso.players[i].getXPos() * 43) - 12 + xOffset,
                    (TheIsleOfLaeso.players[i].getYPos() * 40) + 73 + yOffset);
        }

        // Display buildings

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

        TheIsleOfLaeso.makeMakeingMeMakeMethods(TheIsleOfLaeso.numOfPlayer);

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(4);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the next
 * player's character creations screen
 */
class GoToNextPlayer implements ActionListener {

    public void actionPerformed(ActionEvent event) {

        int x = 0;
        int y = 0;

        if (TheIsleOfLaeso.playerTurn == 1) {
            x = 7;
            y = 8;
        } else if (TheIsleOfLaeso.playerTurn == 2) {
            x = 18;
            y = 7;
        } else if (TheIsleOfLaeso.playerTurn == 3) {
            x = 12;
            y = 11;
        }

        // (x * 43) - 35, (y * 40) + 73,
        TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1] = new Player(x, y,
                TheIsleOfLaeso.g.activeTextField.getText(), TheIsleOfLaeso.hat, TheIsleOfLaeso.clothes,
                TheIsleOfLaeso.color, TheIsleOfLaeso.inventory, 3);

        if (TheIsleOfLaeso.color.equals("Red")) {
            SetColorRed.taken = true;
        } else if (TheIsleOfLaeso.color.equals("Yellow")) {
            SetColorYellow.taken = true;
        } else if (TheIsleOfLaeso.color.equals("Green")) {
            SetColorGreen.taken = true;
        } else if (TheIsleOfLaeso.color.equals("Blue")) {
            SetColorBlue.taken = true;
        }

        if (!SetColorRed.taken) {
            TheIsleOfLaeso.color = "Red";
        } else if (!SetColorYellow.taken) {
            TheIsleOfLaeso.color = "Yellow";
        } else if (!SetColorGreen.taken) {
            TheIsleOfLaeso.color = "Green";
        } else if (!SetColorBlue.taken) {
            TheIsleOfLaeso.color = "Blue";
        }

        TheIsleOfLaeso.g.playerName = "[type name here]";

        TheIsleOfLaeso.playerTurn++;
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

        int x = 0;
        int y = 0;

        if (TheIsleOfLaeso.playerTurn == TheIsleOfLaeso.numOfPlayer) {
            x = 12;
            y = 1;
        }

        TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1] = new Player(x, y,
                TheIsleOfLaeso.g.activeTextField.getText(), TheIsleOfLaeso.hat, TheIsleOfLaeso.clothes,
                TheIsleOfLaeso.color, TheIsleOfLaeso.inventory, 3);

        TheIsleOfLaeso.playerTurn = 1;
        TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName()
                + "'s turn. Roll the dice!";

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(5);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the board
 * screen but without the character creation that goes with the GoToBoard
 * button.
 */
class GoBackToBoard implements ActionListener {

    public void actionPerformed(ActionEvent event) {

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(5);
        TheIsleOfLaeso.g.refresh();

    }
}

/**
 * This class makes the button that switches the scene display to the board
 * screen and builds a new building at the player's location
 */
class GoToBoardToBuild implements ActionListener {

    public void actionPerformed(ActionEvent event) {

        // Check if resource counts are enough

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(5);
        TheIsleOfLaeso.g.refresh();

        // Make the building using the string toBeBuilt

        if (TheIsleOfLaeso.playerTurn < TheIsleOfLaeso.numOfPlayer) {
            TheIsleOfLaeso.playerTurn++;
        } else {
            TheIsleOfLaeso.playerTurn = 1;
        }
        TheIsleOfLaeso.g.diceRolled = false;
        TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName()
                + "'s turn. Roll the dice!";
        TheIsleOfLaeso.i.resourceGeneration();
        TheIsleOfLaeso.g.refreshBoard();
    }
}

/**
 * This class makes the button that switches the scene display to the title
 * screen
 */
class GoToTitle implements ActionListener { // This should also call a reset method to reset the players and board

    public void actionPerformed(ActionEvent event) {
        if (TheIsleOfLaeso.g.activeTextField != null) {
            TheIsleOfLaeso.g.playerName = "[type name here]";
        }
        SetColorRed.taken = false;
        SetColorYellow.taken = false;
        SetColorGreen.taken = false;
        SetColorBlue.taken = false;

        TheIsleOfLaeso.color = "Red";

        TheIsleOfLaeso.playerTurn = 1;
        TheIsleOfLaeso.g.diceRolled = false;

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(0);
        TheIsleOfLaeso.g.refresh();

    }
}

// ____________________ SETTINGS ____________________

/**
 * This class makes the button that sets the die to die1.
 */
class SetDie1 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet("Die1", IOSettings.findSpawnRate(),
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the die to die2.
 */
class SetDie2 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet("Die2", IOSettings.findSpawnRate(),
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the die to die3.
 */
class SetDie3 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet("Die3", IOSettings.findSpawnRate(),
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the die to die4.
 */
class SetDie4 implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet("Die4", IOSettings.findSpawnRate(),
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the resource spawn rate to low.
 */
class SetSpawnLow implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet(IOSettings.findDie(), "SpawnRateLow",
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the resource spawn rate to medium.
 */
class SetSpawnMed implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet(IOSettings.findDie(), "SpawnRateMed",
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that sets the resource spawn rate to high.
 */
class SetSpawnHigh implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet(IOSettings.findDie(), "SpawnRateHigh",
                    IOSettings.findNaturalDis().equals("naturalDistrue"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that turns on natural disasters.
 */
class SetDisastersOn implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet(IOSettings.findDie(), IOSettings.findSpawnRate(), true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that turns on natural disasters.
 */
class SetDisastersOff implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.addsSet(IOSettings.findDie(), IOSettings.findSpawnRate(), false);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * This class makes the button that puts all settings to default.
 */
class SettingsDefault implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        try {
            IOSettings.restor();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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

    static boolean taken = false;

    public void actionPerformed(ActionEvent event) {
        // IslandDrawing.g.hidePlayers(); // I don't like needing to redo the entire
        // scene each time a button is clicked. I would prefer to just use
        // hidePlayers(), but that hasn't worked so far.

        if (!taken) {
            TheIsleOfLaeso.color = "Red";
            TheIsleOfLaeso.g.colorTaken = "";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        } else {
            TheIsleOfLaeso.g.colorTaken = "Red is already taken";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        }

    }
}

/**
 * This class makes the button that sets a player's color to yellow.
 */
class SetColorYellow implements ActionListener {

    static boolean taken = false;

    public void actionPerformed(ActionEvent event) {
        if (!taken) {
            TheIsleOfLaeso.color = "Yellow";
            TheIsleOfLaeso.g.colorTaken = "";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        } else {
            TheIsleOfLaeso.g.colorTaken = "Yellow is already taken";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        }
    }
}

/**
 * This class makes the button that sets a player's color to green.
 */
class SetColorGreen implements ActionListener {

    static boolean taken = false;

    public void actionPerformed(ActionEvent event) {
        if (!taken) {
            TheIsleOfLaeso.color = "Green";
            TheIsleOfLaeso.g.colorTaken = "";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        } else {
            TheIsleOfLaeso.g.colorTaken = "Green is already taken";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        }
    }
}

/**
 * This class makes the button that sets a player's color to blue.
 */
class SetColorBlue implements ActionListener {

    static boolean taken = false;

    public void actionPerformed(ActionEvent event) {
        if (!taken) {
            TheIsleOfLaeso.color = "Blue";
            TheIsleOfLaeso.g.colorTaken = "";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        } else {
            TheIsleOfLaeso.g.colorTaken = "Blue is already taken";
            TheIsleOfLaeso.g.refreshPlayerCreation();
        }
    }
}

// ____________________ HATS ____________________

/**
 * This class makes the button that sets a player's hat to causal.
 */
class SetHatCasual implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Casual";
        TheIsleOfLaeso.g.colorTaken = "";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's hat to armor.
 */
class SetHatArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Armor";
        TheIsleOfLaeso.g.colorTaken = "";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's hat to traditional.
 */
class SetHatTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.hat = "Traditional";
        TheIsleOfLaeso.g.colorTaken = "";
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
        TheIsleOfLaeso.g.colorTaken = "";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's body to armor.
 */
class SetBodyArmor implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.clothes = "Armor";
        TheIsleOfLaeso.g.colorTaken = "";
        TheIsleOfLaeso.g.refreshPlayerCreation();
    }
}

/**
 * This class makes the button that sets a player's body to traditional.
 */
class SetBodyTraditional implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        TheIsleOfLaeso.clothes = "Traditional";
        TheIsleOfLaeso.g.colorTaken = "";
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

        // System.out.println("The rolls were " + roll1 + " and " + roll2);
        TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName() + "'s turn. "
                + roll1 + " moves, " + roll2 + " collects left";

        // TheIsleOfLaeso.incPhase(TheIsleOfLaeso.getPhase());
        // System.out.println("The phase is now " + TheIsleOfLaeso.getPhase());

        TheIsleOfLaeso.g.diceRolled = true;
        TheIsleOfLaeso.moveLeft = roll1;
        System.out.println(TheIsleOfLaeso.moveLeft);
        TheIsleOfLaeso.collectsLeft = roll2;
        System.out.println(TheIsleOfLaeso.collectsLeft);
        TheIsleOfLaeso.g.refreshBoard();
    }
}

/**
 * This class makes the button that ends a player's turn without attacking or
 * building.
 */
class EndTurn implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        // TheIsleOfLaeso.incPhase(TheIsleOfLaeso.getPhase());
        // System.out.println("The phase is now " + TheIsleOfLaeso.getPhase());

        if (TheIsleOfLaeso.playerTurn < TheIsleOfLaeso.numOfPlayer) {
            TheIsleOfLaeso.playerTurn++;
        } else {
            TheIsleOfLaeso.playerTurn = 1;
        }
        TheIsleOfLaeso.g.diceRolled = false;
        TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName()
                + "'s turn. Roll the dice!";
        TheIsleOfLaeso.i.resourceGeneration();
        TheIsleOfLaeso.g.refreshBoard();

    }
}

/**
 * This class makes the button that opens the build menu.
 */
class Build implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        if (TheIsleOfLaeso.g.diceRolled) {
            TheIsleOfLaeso.g.hideActivePanel();
            TheIsleOfLaeso.g.sceneDisplay(7);
            TheIsleOfLaeso.g.refresh();
        }

    }
}

/**
 * This class makes the button that attacks players.
 */
class Attack implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        if (TheIsleOfLaeso.g.diceRolled) {
            System.out.println("The attack button was pressed");

            if (TheIsleOfLaeso.playerTurn < TheIsleOfLaeso.numOfPlayer) {
                TheIsleOfLaeso.playerTurn++;
            } else {
                TheIsleOfLaeso.playerTurn = 1;
            }
            TheIsleOfLaeso.g.diceRolled = false;
            TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName()
                    + "'s turn. Roll the dice!";
            TheIsleOfLaeso.i.resourceGeneration();
            TheIsleOfLaeso.g.refreshBoard();
        }
    }

}
