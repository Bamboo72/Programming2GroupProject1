import java.util.*;
import java.io.*;

public class TheIsleOfLaeso{

  /**
  *@Author Maximilian C. Sutton (most of main, Character Creation class, Player class, Settings class, Settings files)
  *@Author Jacob Schwartz (put 100000 hr in, Graphics class, Cool Art, Island layout, Buttons/Mouse class, some of main)
  *@Author Andrew Blodgett (Resource Generation Class, Dice class, Island class, Structure/Build class)
  *@Author Brandon Winters (Catastrophe Modeclasses: NaturalEventGenerator class, EnhancedNaturalEventGenerator class)
  *@Version 0.91
  *@Since 2021-5-20
  */

  //graphics, dice, settings, and island objects 
  static Graphics g = new Graphics();
  static Dice dice = new Dice(6);
  static IOSettings s = new IOSettings();
  static Island i = new Island();

  //turn vars
  static int moveLeft;
  static int collectsLeft;

  //to make new player objects that dont crash the game
  static int[] inventory = new int[6];
  static String name = "duhadway";
  static String hat = "Casual";
  static String clothes = "Casual";
  static String color = "Red";
  static String magic = "magic";
  static String people = "people";
  static String food = "food";
 
  //more turn vars
  static int numOfPlayer = 4;

  static int playerTurn = 1;
 
  static int numAlive = 2;

  static int winType = 0; 

  //an arry of player objects to access ez
  //static ArrayList<Player> players = new ArrayList<Player>();
  static Player[] players = new Player[numOfPlayer];
  static ArrayList<Structure> structures = new ArrayList<Structure>();

  //empty player objects
  static Player a;
  static Player b;
  static Player c;
  static Player d;

  
  /**
  * checks all the win cons, kill, boat, and magic
  * @pram int numOfP
  * @retunrs int winType
  */
  public static int checkWin(int numOfP){
    int whichPlayerToCheck; 
    if(playerTurn == 1){ 
      whichPlayerToCheck = numOfPlayer - 1;
    } else {
      whichPlayerToCheck = playerTurn - 2;
    }

    System.out.println("The player turn is now " + playerTurn + " so it's " + players[playerTurn - 1].getName() + "'s turn, but we are doing a win check for " + players[whichPlayerToCheck].getName() );
    System.out.print("Win Check: ");
    //the kill win
    numAlive = numOfP;
    if(isDead(a) == true){
      numAlive--;
    }
    if(isDead(b) == true){
      numAlive--;
    }
    if(numOfP == 4) {
      if(isDead(c) == true){
        numAlive--;
      }
      if(isDead(d) == true){
        numAlive--;
      }
    } else if(numOfP == 3){
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

  /**
  * checks to see if a player is passed in is dead
  * @pram Player player
  * @retunrs boolean isAreDead
  */
  public static boolean isDead(Player player){
    int h = player.getHealth();
    boolean isAreDead = false; 
    if(h <= 0){
      isAreDead = true;
    }
    return isAreDead; 
  }

  /**
  * fills the players with things
  * @pram int numOfP
  */
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
