/**
 * This class is the island/game board.
 * 
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-3-6
 */

public class Island {
  String[][] board = {
/*         0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28  29  30 */
/*0*/    {"w","w","w","w","w","w","w","w","w","w","w","w","r","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w","w"},
/*1*/    {"w","w","w","w","w","w","w","w","w","w","w","r","l","r","w","r","w","r","w","r","w","w","w","w","w","r","w","r","w","w","w"},
/*2*/    {"w","w","r","w","r","w","w","w","w","w","r","l","r","l","r","l","r","l","r","l","r","w","r","w","r","l","r","l","r","w","w"},
/*3*/    {"w","r","l","r","l","r","w","r","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w"},
/*4*/    {"w","w","r","l","r","l","r","l","r","l","r","l","r","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","w"},
/*5*/    {"w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","r","w","w","w"},
/*6*/    {"w","w","r","l","r","l","r","l","r","l","r","w","r","w","r","l","r","l","r","l","r","w","r","w","r","w","w","w","w","w","w"},
/*7*/    {"w","w","w","r","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","w","w","w","w","r","w","r","w","w","w"},
/*8*/    {"w","w","w","w","w","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","r","w","r","l","r","l","r","w","w"},
/*9*/    {"w","w","w","w","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","w","w"},
/*10*/   {"w","w","w","w","r","l","r","l","r","w","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","l","r","w","w"},
/*11*/   {"w","w","w","r","l","r","l","r","l","r","w","r","l","r","w","r","w","r","w","r","l","r","l","r","w","r","w","r","w","w","w"},
/*12*/   {"w","w","w","w","r","w","r","w","r","w","w","w","r","w","w","w","w","w","w","w","r","w","r","w","w","w","w","w","w","w","w"}
  }; /* w = water, r = resource, l = land */

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
   * 
   * @param x
   * @param y
   */
  public void remove(int x, int y) {
  }

  /**
   * the method used to add an element to the game board
   * 
   * @param x
   * @param y
   */
  public void add(int x, int y) {
  }

  // main method for testing
  // public static void main(String[] args) {
  //   Island i = new Island();
  //   for(String[] s : i.getBoard()){
  //     for(String ss: s){
  //       System.out.print(ss + " ");
  //     }
  //     System.out.println("");
  //   }
  // }

}
