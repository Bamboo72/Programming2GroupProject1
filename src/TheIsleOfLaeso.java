import java.util.*;
import java.io.*;

public class TheIsleOfLaeso{

  /**
  *@Author Maximilian C. Sutton
  *@Author Jacob Schwartz (already put 100000 hr in)
  *@Author Andrew Blodgett
  *@Version 0.01
  *@Since 2021-2-1
  */



  static private boolean run = true;
  static private boolean play = false;
  static private int apRoll;
  static private int moveRoll;

  /** 
  *manages the turn and intitalises one players turn
  *@param int the players number 
  */
  public static void turn(Player player){
    apRoll = Dice.roll();
    moveRoll = Dice.roll();
    System.out.println(apRoll);
    System.out.println(moveRoll);
    for(int i = 0; i <= moveRoll-1; i++){
      player.move("LU");
    }
  }

  public static void checkWin(int numOfAlive){
    if (numOfAlive <= 1){
      boolean run = false; 
      boolean play = false; 
      System.out.println("How did you change my life");
    }
  }


  public static void main(String[] args) throws FileNotFoundException  {
    boolean run = true;
    boolean play = false;

    int numOfPlayer = 4;

    int[] inventory = new int[6];
    String name = "duhadaway";
    String hat = "aHat";
    String clothes = "normal";
    String color = "blue";

    Player a = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    Player b = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    if(numOfPlayer == 4) {
      Player c = new Player(6, 6, name, hat, clothes, color, inventory, 3);
      Player d = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    } else if(numOfPlayer == 3){
      Player c = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    }
    IOSettings s = new IOSettings();
    Dice Dice = new Dice(6);

    System.out.println(a.getXPos());
    System.out.println(a.getYPos());
    turn(a);
    System.out.println(a.getXPos());
    System.out.println(a.getYPos());
  }	
}