// Jacob Schwartz - 12/12/2020
// Practice making graphics with Java

//setLayout(null)?
// Use JPanels?

import java.awt.Color;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Container;

public class IslandDrawing extends JFrame {


    public IslandDrawing() {

        Container con = this.getContentPane();

        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
       // panel.setLayout(null);
        panel.setBounds(500, 500, 400, 389); // 400 389
        panel.setBackground(Color.BLUE);

        panel2.setBounds(450, 450, 400, 400); // 400 389
        panel2.setBackground(Color.RED);

        panel3.setBounds(550, 550, 400, 400); // 400 389
      //  panel3.setBackground(Color.RED);

        con.add(panel3);
        con.add(panel);
        con.add(panel2);

        // Make ImageIcons and put them on the labels
        ImageIcon image = new ImageIcon(getClass().getResource("res/tlink.jpg"));
      //  ImageIcon image = new ImageIcon(".//res//tlink.jpg");
        ImageIcon image2 = new ImageIcon(getClass().getResource("res/title.png"));
        ImageIcon image3 = new ImageIcon(getClass().getResource("res/bread.jpg"));

        // JLabel label = new JLabel(image);
        JLabel label = new JLabel(image);
        //label.setIcon(image);
        JLabel label2 = new JLabel(image2);
        JLabel label3 = new JLabel(image3);

        panel.add(label);
        panel2.add(label2);
        panel3.add(label3);

        // label.setLocation(500, 500);
        // label2.setLocation(500, 1000);

        JLabel testLabel = new JLabel("TEST");
        this.add(testLabel);
        testLabel.setLocation(1000,50);
        //testLabel.setSize(200, 14);

       // label.setLocation(0,0);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        panel.setVisible(true);
        this.setVisible(true);
    }


    // This version of IslandDrawing() works
/*
    public IslandDrawing() {
        ImageIcon image = new ImageIcon(getClass().getResource("res/tlink.jpg"));
        ImageIcon image2 = new ImageIcon(getClass().getResource("res/title.png"));
        // ImageIcon image2 = new ImageIcon(getClass().getResource("res/OceanBackground.jpg"));

        JLabel label = new JLabel(image);
        JLabel label2 = new JLabel(image2);
        this.add(label, BorderLayout.PAGE_START);
        this.add(label2, BorderLayout.LINE_END);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }
*/

    public static void main(String[] args) {
        new IslandDrawing();
    }
}
