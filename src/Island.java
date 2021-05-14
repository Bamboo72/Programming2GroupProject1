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
/*0*/    {"o","o","o","o","o","o","o","o","o","o","o","o","r","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o","o"},
/*1*/    {"o","o","o","o","o","o","o","o","o","o","o","r","v","r","o","r","o","r","o","r","o","o","o","o","o","r","o","r","o","o","o"},
/*2*/    {"o","o","r","o","r","o","o","o","o","o","r","m","r","m","r","h","r","f","r","f","r","o","r","o","r","p","r","f","r","o","o"},
/*3*/    {"o","r","w","r","w","r","o","r","o","r","h","r","m","r","m","r","h","r","f","r","w","r","w","r","p","r","v","r","v","r","o"},
/*4*/    {"o","o","r","w","r","w","r","p","r","f","r","h","r","o","r","h","r","h","r","w","r","w","r","w","r","w","r","p","r","o","o"},
/*5*/    {"o","r","l","r","w","r","w","r","f","r","f","r","l","r","m","r","w","r","w","r","w","r","w","r","w","r","o","r","o","o","o"},
/*6*/    {"o","o","r","m","r","w","r","w","r","f","r","o","r","o","r","m","r","w","r","w","r","o","r","o","r","o","o","o","o","o","o"},
/*7*/    {"o","o","o","r","o","r","f","r","w","r","f","r","p","r","m","r","m","r","h","r","o","o","o","o","o","r","o","r","o","o","o"},
/*8*/    {"o","o","o","o","o","o","r","f","r","f","r","f","r","p","r","h","r","m","r","m","r","o","r","o","r","f","r","h","r","o","o"},
/*9*/    {"o","o","o","o","o","r","f","r","f","r","f","r","p","r","p","r","h","r","m","r","h","r","f","r","f","r","l","r","o","o","o"},
/*10*/   {"o","o","o","o","r","f","r","f","r","o","r","v","r","p","r","p","r","f","r","h","r","f","r","f","r","h","r","h","r","o","o"},
/*11*/   {"o","o","o","r","f","r","l","r","f","r","o","r","p","r","o","r","o","r","o","r","f","r","f","r","o","r","o","r","o","o","o"},
/*12*/   {"o","o","o","o","r","o","r","o","r","o","o","o","r","o","o","o","o","o","o","o","r","o","r","o","o","o","o","o","o","o","o"}
}; /* o = ocean, r = resource, l = land, v = village, m = mountain, h = hills, f = forest, p = plains, w = waste  */

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
