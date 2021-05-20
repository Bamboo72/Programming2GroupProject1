import java.util.*;
import java.io.*;

public class TheIsleOfLaeso{

  /**
  *@Author Maximilian C. Sutton (most of main, Character Creation class, Player class, Settings class, Settings files)
  *@Author Jacob Schwartz (put 100000 hr in, Graphics class, Cool Art, Island layout, Buttons/Mouse class, some of main)
  *@Author Andrew Blodgett (Resource Generation Class, Dice class, Island class, Structure/Build class)
  *@Author Brandon Winters (Catastrophe Mode class)
  *@Version 0.91
  *@Since 2021-5-20
  */

  static Graphics g = new Graphics();
  static Dice dice = new Dice(6);
  static IOSettings s = new IOSettings();
  static Island i = new Island();

  static int moveLeft;
  static int collectsLeft;

  static int[] inventory = new int[6];
  static String name = "duhadway";
  static String hat = "Casual";
  static String clothes = "Casual";
  static String color = "Red";
  static String magic = "magic";
  static String people = "people";
  static String food = "food";
 
  static int numOfPlayer = 4;

  static int playerTurn = 1;
 
  static int numAlive = 2;

  static boolean isWon = false;

  //static ArrayList<Player> players = new ArrayList<Player>();
  static Player[] players = new Player[numOfPlayer];

  static Player a;
  static Player b;
  static Player c;
  static Player d;

  public static boolean checkWin(){
    //the kill win
    numAlive = numOfPlayer;
    if(isDead(a) == true){
      numAlive--;
    }
    if(isDead(b) == true){
      numAlive--;
    }
    if(numOfPlayer == 4) {
      if(isDead(c) == true){
        numAlive--;
      }
      if(isDead(d) == true){
        numAlive--;
      }
    } else if(numOfPlayer == 3){
      if(isDead(c) == true){
        numAlive--;
      }
    }
    if(numAlive <= 0){
      isWon = true;
    }

    //the magic win
    if(players[playerTurn-1].getResource(magic) > 8){
      isWon = true;
    }

    //the boat win
    if(players[playerTurn-1].getResource(people) > 5 && players[playerTurn-1].getResource(food) > 11){ //checks if they have enought recorces
      if(  /*were you put if they are AT a boat and if they HAVE a boat*/  ){
        isWon = true;
      }
    }

    return isWon;
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
    g.sceneDisplay(0); 
    g.refresh();   
  }	
}