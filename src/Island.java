/**
 * This class is the island/game board.
 *
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-3-6
 */
import java.util.Random;

public class Island {
    public double resourceSpawnRate = .1;
    String[][] board = {
  /*         0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30 */
  /*0*/    {"o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","r ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o "},
  /*1*/    {"o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","o ","r ","v ","r ","o ","r ","o ","r ","o ","r ","o ","o ","o ","o ","o ","r ","o ","r ","o ","o ","o "},
  /*2*/    {"o ","o ","r ","o ","r ","o ","o ","o ","o ","o ","r ","m ","r ","m ","r ","c ","r ","f ","r ","f ","r ","o ","r ","o ","r ","p ","r ","f ","r ","o ","o "},
  /*3*/    {"o ","r ","w ","r ","w ","r ","o ","r ","o ","r ","c ","r ","m ","r ","m ","r ","c ","r ","f ","r ","w ","r ","w ","r ","p ","r ","v ","r ","v ","r ","o "},
  /*4*/    {"o ","o ","r ","w ","r ","w ","r ","p ","r ","f ","r ","c ","r ","o ","r ","c ","r ","c ","r ","w ","r ","w ","r ","w ","r ","w ","r ","p ","r ","o ","o "},
  /*5*/    {"o ","r ","l ","r ","w ","r ","w ","r ","f ","r ","f ","r ","l ","r ","m ","r ","w ","r ","w ","r ","w ","r ","w ","r ","w ","r ","o ","r ","o ","o ","o "},
  /*6*/    {"o ","o ","r ","m ","r ","w ","r ","w ","r ","f ","r ","o ","r ","o ","r ","m ","r ","w ","r ","w ","r ","o ","r ","o ","r ","o ","o ","o ","o ","o ","o "},
  /*7*/    {"o ","o ","o ","r ","o ","r ","f ","r ","w ","r ","f ","r ","p ","r ","m ","r ","m ","r ","c ","r ","o ","o ","o ","o ","o ","r ","o ","r ","o ","o ","o "},
  /*8*/    {"o ","o ","o ","o ","o ","o ","r ","f ","r ","f ","r ","f ","r ","p ","r ","c ","r ","m ","r ","m ","r ","o ","r ","o ","r ","f ","r ","c ","r ","o ","o "},
  /*9*/    {"o ","o ","o ","o ","o ","r ","f ","r ","f ","r ","f ","r ","p ","r ","p ","r ","c ","r ","m ","r ","c ","r ","f ","r ","f ","r ","l ","r ","o ","o ","o "},
  /*10*/   {"o ","o ","o ","o ","r ","f ","r ","f ","r ","o ","r ","v ","r ","p ","r ","p ","r ","f ","r ","c ","r ","f ","r ","f ","r ","c ","r ","c ","r ","o ","o "},
  /*11*/   {"o ","o ","o ","r ","f ","r ","l ","r ","f ","r ","o ","r ","p ","r ","o ","r ","o ","r ","o ","r ","f ","r ","f ","r ","o ","r ","o ","r ","o ","o ","o "},
  /*12*/   {"o ","o ","o ","o ","r ","o ","r ","o ","r ","o ","o ","o ","r ","o ","o ","o ","o ","o ","o ","o ","r ","o ","r ","o ","o ","o ","o ","o ","o ","o ","o "}
}; /* o = ocean, r = resource, l = land, v = village, m = mountain, c = crags, f = forest, p = plains, w = waste  */

    /**
     * Returns the board representing the island
     *
     * @return the game board
     */
    public String[][] getBoard() {
      return board;
    }

    /**
     * The method used to remove an element from the game board
     * @param x, y
     * @param e
     */
    public void remove(String e, int x, int y) {
      if(board[y][x].contains(e)) {
        board[y][x] = board[y][x].substring(0, board[y][x].indexOf(e)) + board[y][x].substring(board[y][x].indexOf(e) + e.length(), board[y][x].length());
      } else {
        System.out.println("Uhhhhhh... This is awkward... I guess that element wasn't actually there so I couldn't remove it. You have drawn the ire of the gods; prepare to be smitten.");
      }
    }

    /**
     * the method used to add an element to the game board
     * @param x, y
     * @param e
     */
    public void add(String e, int x, int y) {
      board[y][x] += e;
    }

    /**
     * Checks if a certain space on the board contains a string
     * @param x, y
     * @param e
     */
    public boolean contains(String e, int x, int y) {
      if(board[y][x].contains(e)) return true;
      else return false;
    }

    public void build(char type, int x, int y) {
      switch(type) {
        case 's':
          add("storehouse ", x, y);
        case 'v':
          add("village ", x, y);
        case 'f':
          add("fort ", x, y);
        case 'p':
          add("port ", x, y);
        case 'b':
          add("boat ", x, y);
        default: break;
      }
    }

    /**
     * This method randomly generates resources on resource spaces based on the terrains adjacent to them.
     */
    public void resourceGeneration() {
      for (int y = 0; y < board.length; y++) {
        for (int x = 0; x < board[y].length; x++) {
          if (board[y][x].contains("r ")) {
            double woodChance = 0;
            double peopleChance = 0;
            double foodChance = 0;
            double stoneChance = 0;
            double oreChance = 0;
            double magicChance = 0;
            if (y > 0) {
              switch(board[y-1][x].charAt(0)) {
                case 'f':
                  woodChance += 0.15;
                  break;
                case 'm':
                  oreChance += 0.15;
                  break;
                case 'c':
                  stoneChance += 0.15;
                  break;
                case 'v':
                  peopleChance += 0.27;
                  break;
                case 'p':
                  foodChance += 0.2;
                  break;
                case 'l':
                  magicChance += 0.1;
                }
            }
            if (y < 12) {
              switch(board[y+1][x].charAt(0)) {
                case 'f':
                  woodChance += 0.15;
                  break;
                case 'm':
                  oreChance += 0.15;
                  break;
                case 'c':
                  stoneChance += 0.15;
                  break;
                case 'v':
                  peopleChance += 0.27;
                  break;
                case 'p':
                  foodChance += 0.2;
                  break;
                case 'l':
                  magicChance += 0.1;
              }
            }
            if (x > 0) {
              switch(board[y][x-1].charAt(0)) {
                case 'f':
                  woodChance += 0.15;
                  break;
                case 'm':
                  oreChance += 0.15;
                  break;
                case 'c':
                  stoneChance += 0.15;
                  break;
                case 'v':
                  peopleChance += 0.27;
                  break;
                case 'p':
                  foodChance += 0.2;
                  break;
                case 'l':
                  magicChance += 0.1;
              }
            }
            if (x < 30) {
              switch(board[y][x+1].charAt(0)) {
                case 'f':
                  woodChance += 0.15;
                  break;
                case 'm':
                  oreChance += 0.15;
                  break;
                case 'c':
                  stoneChance += 0.15;
                  break;
                case 'v':
                  peopleChance += 0.27;
                  break;
                case 'p':
                  foodChance += 0.2;
                  break;
                case 'l':
                  magicChance += 0.1;
              }
            }

            Random r = new Random();
            double rand = r.nextDouble();
            if (rand < woodChance * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "wood ";
            } else if (rand < (woodChance + peopleChance) * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "people ";
            } else if (rand < (woodChance + peopleChance + foodChance) * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "food ";
            } else if (rand < (woodChance + peopleChance + foodChance + stoneChance) * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "stone ";
            } else if (rand < (woodChance + peopleChance + foodChance + stoneChance + oreChance) * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "ore ";
            } else if (rand < (woodChance + peopleChance + foodChance + stoneChance + oreChance + magicChance) * resourceSpawnRate) {
              remove(board[y][x].substring(2), x, y);
              board[y][x] += "magic ";
            }
          }
        }
      }
    }

    // main method for testing
    public static void main(String[] args) {
      Island i = new Island();
      // i.resourceGeneration();
      // i.resourceGeneration();
      // i.resourceGeneration();
      for(String[] s : i.getBoard()){
        for(String ss: s){
          System.out.print(ss + " ");
        }
        System.out.println("");
      }
    }

  }
