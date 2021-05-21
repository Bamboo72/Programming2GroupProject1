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

  static int winType = 0; // Replacement for boolean isWon so that we can display the different win screens

  //static ArrayList<Player> players = new ArrayList<Player>();
  static Player[] players = new Player[numOfPlayer];
  static ArrayList<Structure> structures = new ArrayList<Structure>();

  static Player a;
  static Player b;
  static Player c;
  static Player d;

  public static boolean checkForPlayerAtStructure(Player p, int type){ // Checks if there is a specific building type at the player location
    for(Structure s: structures){
      if(p.getXPos() == s.getX()){
        if(p.getYPos() == s.getY()){
            if(s.getType() == type ){
              return true;
            }
        }
      }
    }
    return false;
  }

  public static int checkWin(){

    int whichPlayerToCheck; // Because the win check happens after the turn is incremented, we have to account for the turn going from the last player to the first player
    if(playerTurn == 1){ // So the last player went and the turn returned to player 1
      whichPlayerToCheck = numOfPlayer - 1;
    } else { // So the previous player went, and turn moved to the next player
      whichPlayerToCheck = playerTurn - 2;
    }

    System.out.println("The player turn is now " + playerTurn + " so it's " + players[playerTurn - 1].getName() + "'s turn, but we are doing a win check for " + players[whichPlayerToCheck].getName() );
    System.out.print("Win Check: ");
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
      winType = 1;
      System.out.println("KILL WIN!!");
    }

    //the magic win
    if(players[whichPlayerToCheck].getInven()[5] > 8){
      winType = 2;
      System.out.println("MAGIC WIN!!");
    }

    //the boat win
    if(players[whichPlayerToCheck].getResource(people) > 5 && players[whichPlayerToCheck].getResource(food) > 11){ //checks if they have enought recorces
      
        boolean boatNearby = false;
        for(Structure s: structures){
          if(s.getType() == 'p' && s.owner == whichPlayerToCheck && s.getX() == players[whichPlayerToCheck].getXPos() && s.getY() == players[whichPlayerToCheck].getYPos()){
            int currentPlayerX = TheIsleOfLaeso.players[whichPlayerToCheck].getXPos();
            int currentPlayerY = TheIsleOfLaeso.players[whichPlayerToCheck].getYPos();
            if (s.getY() == currentPlayerY + 1 &&  s.getX() == currentPlayerX + 1) {
                boatNearby = true;
            } else if (s.getY() == currentPlayerY + 1 &&  s.getX() == currentPlayerX - 1) {
              boatNearby = true;
            } else if (s.getY() == currentPlayerY - 1 &&  s.getX() == currentPlayerX + 1) {
              boatNearby = true;
            } else if (s.getY() == currentPlayerY - 1 &&  s.getX() == currentPlayerX - 1) {
              boatNearby = true;
            }
          }
        }
        if(boatNearby){
          winType = 3;
          System.out.println("BOAT WIN!!");
        }
        
    }

    if(winType == 0){
      System.out.println("no win detected");
    }
    return winType;
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