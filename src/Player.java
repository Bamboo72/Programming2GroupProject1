import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
  /**
  *@Author Maximilian C. Sutton
  *@Version 0.75
  *@Since 2021-04-26
  */

  static private int x;
  static private int y;
  static private String name; 
  static private int playerNum;
  static private String hat;
  static private String clothes; 
  static private String color;
  static private int[] inventory; 

  public Player(int x, int y, String name, int playerNum, String hat, String clothes, String color, int[] inventory){
    this.x = x;
    this.y = y;
    this.name = name;
    this.playerNum = playerNum;
    this.hat = hat;
    this.clothes = clothes;
    this.color = color;
    this.inventory = inventory;
    this.inventory = new int[6];
  }

  public static void moveLU(){
    x = x - 1;
    y = y + 1;
  }

  public static void moveLD(){
    x = x - 1;
    y = y - 1;
  }

  public static void moveRU(){
    x = x + 1;
    y = y + 1;
  }

  public static void moveRD(){
    x = x + 1;
    y = y - 1;
  }

  public static int getXPos() {
    return x;
  }
  public static int getYPos() {
    return y;
  }

  /**
  * a function that colects recorces 
  * @param x
  * @param y
  * @param dirFace
  */
  static public void gather(int x, int y, String dirFace){
		
  }

  /**
  * a function that builds buildings 
  * @param x
  * @param y
  * @param type
  * @param dirFace
  */
  static public void build (int x, int y, String type, String dirFace){

  }

  static public void clearInventory() {
    for(int i = 0; i < 6; i++) {
      //first fill with empty int
      inventory[i] = 0;
    }  
  }

  static public int getResource(String resource) {
    resource = resource.toLowerCase();
    int amount = 0;
    switch(resource){
      case "wood":
        amount = inventory[0]; 
        break;
      case "people":
        amount = inventory[1]; 
        break;
      case "food":
        amount = inventory[2]; 
        break;
      case "stone":
        amount = inventory[3]; 
        break;
      case "ore":
        amount = inventory[4]; 
        break;
      case "magic":
        amount = inventory[5]; 
        break;
      default:
        amount = 0;
        System.out.println("YOU BIG DUMB");
    }
    return amount;
  }

  static public void setResource(String resource) {
    resource = resource.toLowerCase();
    switch(resource){
      case "wood":
        inventory[0] += 1;
        break;
      case "people":
        inventory[1] += 1;
        break;
      case "food":
        inventory[2] += 1;  
        break;
      case "stone":
        inventory[3] += 1;  
        break;
      case "ore":
        inventory[4] += 1; 
        break;
      case "magic":
        inventory[5] += 1; 
        break;
      default:
        System.out.println("YOU BIG DUMB");
    }
  }

  static public void setResource(String resource, int amount) {
    resource = resource.toLowerCase();
    switch(resource){
      case "wood":
        inventory[0] += amount;
        break;
      case "people":
        inventory[1] += amount;
        break;
      case "food":
        inventory[2] += amount;  
        break;
      case "stone":
        inventory[3] += amount;  
        break;
      case "ore":
        inventory[4] += amount; 
        break;
      case "magic":
        inventory[5] += amount; 
        break;
      default:
        System.out.println("YOU BIG DUMB");
    }
  }
}