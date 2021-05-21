public class Player {
  /**
  *@Author Maximilian C. Sutton
  *@Version 1.00
  *@Since 2021-05-21
  */


    //varables that are inportant 
    private int x;
    private int y;
    private String res;
    private String name; 
    private String hat;
    private String clothes; 
    private String color;
    private int[] inventory; 
    private int health;
    private int roll1, roll2, diff, rad1, rad2;


  /**
  * a constructure 
  * @param x, y, playerNum
  * @param name, hat, clothes, color, dirFace
  * @param inventory
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







  public int getXPos() {
    return x;
  }

  public int getYPos() {
    return y;
  }




  public void setXPos(int pos) {
    x = pos;
  }

  public void setYPos(int pos) {
    y = pos;
  }




  public String getName() {
    return name;
  }

  public String getHat() {
    return hat;
  }

  public String getClothes() {
    return clothes;
  }

  public String getColor() {
    return color;
  }


  public int[] getInven(){
    return inventory;
  }

  public int getHealth() {
    return health;
  }

  public void damage() {
    health -= 1;
  }




     public void attacking(Player playerOne, Player playerTwo) {
      roll1 = TheIsleOfLaeso.dice.roll();
      roll2 = TheIsleOfLaeso.dice.roll();
      rad1 = TheIsleOfLaeso.dice.roll() - 1;
      rad2 = TheIsleOfLaeso.dice.roll();
      switch(rad1){
        case 0:
          res = "wood";
          break;
        case 1:
          res = "people";
          break;
        case 2:
          res = "food";
          break;
        case 3:
          res = "stone";
          break;
        case 4:
          res = "ore";
          break;
        case 5:
          res = "magic";
          break;
        default:
          res = "wood";
          System.out.println("YOU BIG DUMB");
      }
      
      if(checkForPlayerAtStructure(playerTwo, 'f') != null){
        roll2 ++;
      } 
      if(checkForPlayerAtStructure(playerOne, 'v') != null){
        roll1 ++;
      } 
      if(roll1 > roll2 + 2){
        if(checkForPlayerAtStructure(playerTwo) != null){
          checkForPlayerAtStructure(playerTwo).addHealth(-5);
        } else {
          playerTwo.damage();
        }
        playerTwo.addResource(res, -rad2);
        playerOne.addResource(res, rad2);
      } else if(roll1 > roll2){
        if(checkForPlayerAtStructure(playerTwo) != null){
          diff = roll2 - roll1;
          checkForPlayerAtStructure(playerTwo).addHealth(diff);
        }
        playerTwo.addResource(res, -rad2);
        playerOne.addResource(res, rad2);
      } else if(roll1 + 2 < roll2) {
        if(checkForPlayerAtStructure(playerOne) != null){
          checkForPlayerAtStructure(playerOne).addHealth(-5);
        } else {
          playerOne.damage();
        }
        playerOne.addResource(res, -rad2);
        playerTwo.addResource(res, rad2);
      } else if(roll1 < roll2) {
        if(checkForPlayerAtStructure(playerTwo) != null){
          diff = roll1 - roll2;
          checkForPlayerAtStructure(playerTwo).addHealth(diff);
        }
        playerOne.addResource(res, -rad2);
        playerTwo.addResource(res, rad2);
      }
    }



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

  public static boolean checkForStructure(int x, int y){ // Checks if there is a structure at the x and y
    for(Structure s: TheIsleOfLaeso.structures){
      if(s.getX() == x){
        if(s.getY() == y){
            return true;
        }
      }
    }
    return false;
  }

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
  * a function to control movment 
  * @param dirFace
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
  * @param resource 
  * @returns amount
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
  * @param resource 
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
  * @param resource 
  * @param amount
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