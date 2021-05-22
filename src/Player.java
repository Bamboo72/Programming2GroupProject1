public class Player {
  /**
  *@Author Maximilian C. Sutton
  *@Version 1.00
  *@Since 2021-05-21
  */


  //varables that are inportant 
  private int x;
  private int y;
  static private String res;
  private String name; 
  private String hat;
  private String clothes; 
  private String color;
  private int[] inventory; 
  private int health;
  static private int roll1, roll2, diff, rad1, rad2;


  /**
  * a constructure that makes a player object 
  * @param int x, y, health
  * @param String name, hat, clothes, color
  * @param int [] inventory
  */
  public Player(int x, int y, String name, String hat, String clothes, String color, int[] inventory, int health){
    this.x = x;
    this.y = y;
    this.name = name;
    this.hat = hat;
    this.clothes = clothes;
    this.color = color;
    this.inventory = inventory;
    this.inventory = new int[6];
    this.health = health; 
  }






  /**
  * a method that gets the x position of a player 
  * @return int x
  */
  public int getXPos() {
    return x;
  }
	
  /**
  * a method that gets the y position of a player 
  * @return int y
  */
  public int getYPos() {
    return y;
  }



  /**
  * a method that sets the x position of a player 
  * @param int pos
  */
  public void setXPos(int pos) {
    x = pos;
  }
	
  /**
  * a method that sets the x position of a player 
  * @param int pos
  */
  public void setYPos(int pos) {
    y = pos;
  }



  /**
  * a method that gets the name of a player 
  * @return String name
  */
  public String getName() {
    return name;
  }

  /**
  * a method that gets the hat type of a player 
  * @return String hat
  */
  public String getHat() {
    return hat;
  }

  /**
  * a method that gets the clothing type of a player 
  * @return String clothes
  */
  public String getClothes() {
    return clothes;
  }

  /**
  * a method that gets the color of a player 
  * @return String color
  */
  public String getColor() {
    return color;
  }

  /**
  * a method that gets the invetory of a player 
  * @return int[] inventory
  */
  public int[] getInven(){
    return inventory;
  }

  /**
  * a method that gets the health of a player 
  * @return String health
  */
  public int getHealth() {
    return health;
  }

  /**
  * a method that dammages a player by 1 health point
  */
  public void damage() {
    health -= 1;
  }
	

  /**
  * makes two players fight and picks a winner based on random rolls
  * a random resorce is rolled at a random amount, buildings add to rolls but can be dammaged
  * only defender can take dammage if the attaker rolls 3 higher than them  
  * @param Plater playerOne, playerTwo
  */
  public static void attacking(Player playerOne, Player playerTwo) {
    roll1 = TheIsleOfLaeso.dice.roll();
    roll2 = TheIsleOfLaeso.dice.roll();
    rad1 = TheIsleOfLaeso.dice.roll() - 1;
    rad2 = TheIsleOfLaeso.dice.roll();
    if(rad1 == 0){
      res = "wood";
      System.out.println("wood was rolled");
    } else if(rad1 == 1){
      res = "people";
      System.out.println("people was rolled");
    } else if(rad1 == 2){
      res = "food";
      System.out.println("food was rolled");
    } else if(rad1 == 3){
      res = "stone";
      System.out.println("stone was rolled");
    } else if(rad1 == 4){
      res = "ore";
      System.out.println("ore was rolled");
    } else if(rad1 == 5){
      res = "magic";
      System.out.println("magic was rolled");
    } else {
      res = "wood";
      System.out.println("YOU BIG DUMB");
    }
    if(checkForPlayerAtStructure(playerTwo, 'f') != null){
      roll2 ++;
      System.out.println("defender is at a fort");
    } 
    if(checkForPlayerAtStructure(playerOne, 'v') != null){
      roll1 ++;
      System.out.println("attacker is at a village");
    } 
    if(roll1 > roll2 + 2){
      if(checkForPlayerAtStructure(playerTwo) != null){
        checkForPlayerAtStructure(playerTwo).addHealth(-5); // how do I change
        System.out.println("Attaker rolled higher than defender by 3+, at a fort");
      } else {
        playerTwo.damage();
	System.out.println("Attaker rolled higher than defender by 3+, defender dammaged");
      }
      playerTwo.addResource(res, -rad2);
      playerOne.addResource(res, rad2);
      System.out.println("Recsorces given to attacker");
    } else if(roll1 > roll2){
      System.out.println("Attaker rolled higher than defender");
      if(checkForPlayerAtStructure(playerTwo) != null){
        diff = roll2 - roll1;
        checkForPlayerAtStructure(playerTwo).addHealth(diff);
	System.out.println("defender building dammaged");
      }
      playerTwo.addResource(res, -rad2);
      playerOne.addResource(res, rad2);
      System.out.println("Recsorces given to attacker");
    } else if(roll1 + 2 < roll2) {
      if(checkForPlayerAtStructure(playerOne) != null){
        checkForPlayerAtStructure(playerOne).addHealth(-5); // how do I change 
	System.out.println("Defender rolled higher than defender by 3+, at a village");
      } 
      playerOne.addResource(res, -rad2);
      playerTwo.addResource(res, rad2);
      System.out.println("Recsorces given to defender");
    } else if(roll1 < roll2) {
      if(checkForPlayerAtStructure(playerTwo) != null){
        diff = roll1 - roll2;
        checkForPlayerAtStructure(playerTwo).addHealth(diff);
	System.out.println("attaker building dammaged");
      }
      playerOne.addResource(res, -rad2);
      playerTwo.addResource(res, rad2);
      System.out.println("Recsorces given to defender");
    }
  }
  
  

  /**
  * to check if a player is on a type of structure that is passed in 
  * @param Player p
  * @param char type
  * @returns Structure s
  */
  public static Structure checkForPlayerAtStructure(Player p, char type){ // Checks if there is a specific building type at the player location
    for(Structure s: TheIsleOfLaeso.structures){
      if(p.getXPos() == s.getX()){
        if(p.getYPos() == s.getY()){
          if(s.getType() == type ){
            return s;
          }
        }
      }
    }
    return null;
  }
	
	
	
  /**
  * to check if a player is on a structure 
  * @param Player p
  * @returns Structure s
  */
  public static Structure checkForPlayerAtStructure(Player p){ // Checks if there is a specific building type at the player location
    for(Structure s: TheIsleOfLaeso.structures){
      if(p.getXPos() == s.getX()){
        if(p.getYPos() == s.getY()){
          return s;
        }
      }
    }
    return null;
  }

	
	
  /**
  * to check a tile and see if it has a structure on it
  * @param int x, y
  * @returns Structure s
  */
  public static Structure checkForStructure(int x, int y){ // Checks if there is a structure at the x and y
    for(Structure s: TheIsleOfLaeso.structures){
      if(s.getX() == x){
        if(s.getY() == y){
          return s;
        }
      }
    }
    return null;
  }

	
	
  /**
  * to check a tile and see if it has a player on it
  * @param int x, y
  * @returns boolean
  */
  public static boolean checkForPlayer(int x, int y){ // Checks if there is a player at the x and y
    for(int i = 0; i < TheIsleOfLaeso.numOfPlayer; i++){
      if(TheIsleOfLaeso.players[i].getXPos() == x){
        if(TheIsleOfLaeso.players[i].getYPos() == y){
          return true;
        }
      }
    }
    return false;
  }

	
	
  /**
  * returns back a player at pos passed in
  * @param int x, y
  * @returns Player
  */
  public static Player getPlayerAt(int x, int y){ 
    for(int i = 0; i < TheIsleOfLaeso.numOfPlayer; i++){
      if(TheIsleOfLaeso.players[i].getXPos() == x){
        if(TheIsleOfLaeso.players[i].getYPos() == y){
          return TheIsleOfLaeso.players[i];
        }
      }
    }
    return null;
  }

	
	
  /**
  * a function to control movment 
  * @param String direction
  */
  public void move(String direction){
    direction = direction.toLowerCase();
    switch(direction){
      case "lu":
        x -= 1;
        y += 1;
        break;
      case "ld":
        x -= 1;
        y -= 1;
        break;
      case "ru":
        x += 1;
        y += 1; 
        break;
      case "rd":
        x += 1;
        y -= 1; 
        break;
      default:
        System.out.println("YOU BIG DUMB");
    }
  }


  /**
  * a functionn to clear a players inventory
  */
  public void clearInventory() {
    for(int i = 0; i < 6; i++) {
      //first fill with empty int
      inventory[i] = 0;
    }  
  }
 
	
	
  /**
  * a functionn to get a resource in players inventory
  * @param String resource 
  * @returns int amount
  */
  public int getResource(String resource) {
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

	
	
 /**
 * a functionn to add to a recorce to a players inventory
 * @param String resource 
 */
  public void addResource(String resource) {
    resource = resource.toLowerCase();
    switch(resource){
      case "wood ":
        inventory[0] += 1;
        break;
      case "people ":
        inventory[1] += 1;
        break;
      case "food ":
        inventory[2] += 1;  
        break;
      case "stone ":
        inventory[3] += 1;  
        break;
      case "ore ":
        inventory[4] += 1; 
        break;
      case "magic ":
        inventory[5] += 1; 
        break;
      default:
        System.out.println("YOU BIG DUMB");
    }
  }

	
	
  /**
  * a functionn to add to a players inventory, can add more than one
  * @param String resource 
  * @param int amount
  */
  public void addResource(String resource, int amount) {
    resource = resource.toLowerCase();
    switch(resource){
      case "wood ":
        inventory[0] += amount;
        break;
      case "people ":
        inventory[1] += amount;
        break;
      case "food ":
        inventory[2] += amount;  
        break;
      case "stone ":
        inventory[3] += amount;  
        break;
      case "ore ":
        inventory[4] += amount; 
        break;
      case "magic ":
        inventory[5] += amount; 
        break;
      default:
        System.out.println("YOU BIG DUMB");
    }
  }
}
