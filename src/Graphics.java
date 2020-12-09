/**
* @author Jacob Schwartz
* @version 1.0
* @since 2020-12-9
*/

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;

/**
* This is the class that handles all game graphics for the Isle of Laeso Game.
*/
public class Graphics extends Canvas{
//TODO
  JFrame frame = new JFrame("The Isle of Laeso");
  Canvas canvas = new Graphics();
  canvas.setSize(400, 400);
          frame.add(canvas);
          frame.pack();
          frame.setVisible(true);

  public void paint(Graphics g){

  }

  public static void main(String[] args ){

  }
}
