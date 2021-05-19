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

  static Graphics g = new Graphics();
  static Dice dice = new Dice(6);
  static IOSettings s = new IOSettings();
  static Island i = new Island();

  static private boolean run = true;
  static private boolean play = false;
  static private int apRoll;
  static private int moveLeft;
  static private int collectsLeft;
  static private int phase = 0;

  static int[] inventory = new int[6];
  static String name = "duhadway";
  static String hat = "Casual";
  static String clothes = "Casual";
  static String color = "Red";
 
  static int numOfPlayer = 4;

  static int playerTurn = 1;

  //static ArrayList<Player> players = new ArrayList<Player>();
  static Player[] players = new Player[numOfPlayer];

  static Player a;
  static Player b;
  static Player c;
  static Player d;

  /** 
  *manages the turn and intitalises one players turn
  *@param int 
  */
  public static void turn(){
    
  }

  public static void checkWin(int numOfAlive){
    if (numOfAlive <= 1){
      boolean run = false; 
      boolean play = false; 
      System.out.println("How did you change my life");
    }
  }

  // Phase might not be needed. Due to further thinking,
  // I've come to the conclusion that we only need to detect 
  // whether the player has rolled the die or not. 
  // So maybe a boolean would work better?
  public static void incPhase(int phase){
    if(phase >= 3){
      phase = 0;
    } else {
      phase ++;
    }
  }

  public static int getPhase(){
    return phase;
  }


  public static boolean isDead(Player player){
    int h = player.getHealth();
    boolean isAreDead = false; 
    if(h <= 0){
      isAreDead = true;
    }
    return isAreDead; 
  }


  public static void makeMakeingMeMakeMethods(int numOfP){
    a = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    b = new Player(6, 6, name, hat, clothes, color, inventory, 3);
    players[0] = a;
    players[1] = b;
    if(numOfP == 4) {
      c = new Player(6, 6, name, hat, clothes, color, inventory, 3);
      d = new Player(6, 6, name, hat, clothes, color, inventory, 3);
      players[2] = c;
    players[3] = d;
    } else if(numOfP == 3){
      c = new Player(6, 6, name, hat, clothes, color, inventory, 3);
      players[2] = c;
    }
  }

  public static void main(String[] args) throws FileNotFoundException  {
    boolean run = true;
    boolean play = false;

    String lu = "wood";

    /* broken bc cant find player objects  
    *a.addResource(lu, 7);            
    *System.out.println(a.getResource(lu));
    *System.out.println(b.getResource(lu)); 
    */

    g.sceneDisplay(0); 
    g.refresh();   
  }	
}