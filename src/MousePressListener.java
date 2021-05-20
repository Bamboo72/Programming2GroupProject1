// Jacob Schwartz - 5/7/2021
// This is the MouseListener class for the Laeso project.
// Code copied then modified from my Maze Game project.

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

/**
 * This class handles the mouse events that move the character
 */
class MousePressListener implements MouseListener {

    /**
     * This method detects when the mouse is clicked and moves the character
     * depending on a variety of conditions (character direction and location)
     */
    public void mouseClicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        int rowNum = 0, colNum = 0;

        System.out.println("(" + x + ", " + y + ")");

        // y /= 45.385;
        y = (y - 70) / 40;
        // y = (y - 70) / 45.385 ;
        if (0 < y && y <= 1) { // 1.54
            rowNum = 0;
        } else if (1 < y && y <= 2) {
            rowNum = 1;
        } else if (2 < y && y <= 3) {
            rowNum = 2;
        } else if (3 < y && y <= 4) {
            rowNum = 3;
        } else if (4 < y && y <= 5) {
            rowNum = 4;
        } else if (5 < y && y <= 6) {
            rowNum = 5;
        } else if (6 < y && y <= 7) {
            rowNum = 6;
        } else if (7 < y && y <= 8) {
            rowNum = 7;
        } else if (8 < y && y <= 9) {
            rowNum = 8;
        } else if (9 < y && y <= 10) {
            rowNum = 9;
        } else if (10 < y && y <= 11) {
            rowNum = 10;
        } else if (11 < y && y <= 12) {
            rowNum = 11;
        } else if (12 < y && y <= 13) {
            rowNum = 12;
        } else {
            rowNum = -1;
        }

        // x /= 42.667;
        x = (x + 21.333) / 42.666;
        // x = (x - 21.333) / 42.667 ;
        if (0 < x && x <= 1) { // 1.54
            colNum = 0;
        } else if (1 < x && x <= 2) {
            colNum = 1;
        } else if (2 < x && x <= 3) {
            colNum = 2;
        } else if (3 < x && x <= 4) {
            colNum = 3;
        } else if (4 < x && x <= 5) {
            colNum = 4;
        } else if (5 < x && x <= 6) {
            colNum = 5;
        } else if (6 < x && x <= 7) {
            colNum = 6;
        } else if (7 < x && x <= 8) {
            colNum = 7;
        } else if (8 < x && x <= 9) {
            colNum = 8;
        } else if (9 < x && x <= 10) {
            colNum = 9;
        } else if (10 < x && x <= 11) {
            colNum = 10;
        } else if (11 < x && x <= 12) {
            colNum = 11;
        } else if (12 < x && x <= 13) {
            colNum = 12;
        } else if (13 < x && x <= 14) {
            colNum = 13;
        } else if (14 < x && x <= 15) {
            colNum = 14;
        } else if (15 < x && x <= 16) {
            colNum = 15;
        } else if (16 < x && x <= 17) {
            colNum = 16;
        } else if (17 < x && x <= 18) {
            colNum = 17;
        } else if (18 < x && x <= 19) {
            colNum = 18;
        } else if (19 < x && x <= 20) {
            colNum = 19;
        } else if (20 < x && x <= 21) {
            colNum = 20;
        } else if (21 < x && x <= 22) {
            colNum = 21;
        } else if (22 < x && x <= 23) {
            colNum = 22;
        } else if (23 < x && x <= 24) {
            colNum = 23;
        } else if (24 < x && x <= 25) {
            colNum = 24;
        } else if (25 < x && x <= 26) {
            colNum = 25;
        } else if (26 < x && x <= 27) {
            colNum = 26;
        } else if (27 < x && x <= 28) {
            colNum = 27;
        } else if (28 < x && x <= 29) {
            colNum = 28;
        } else if (29 < x && x <= 30) {
            colNum = 29;
        } else if (30 < x && x <= 31) {
            colNum = 30;
        } else {
            colNum = -1;
        }

        System.out.println("Col: " + colNum + ", Row: " + rowNum);

        int currentPlayerX = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getXPos();
        int currentPlayerY = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getYPos();

        System.out.println("Player at x: " + currentPlayerX + ", y: " + currentPlayerY);

        if (TheIsleOfLaeso.g.diceRolled) { // Row = Y, Col = X, Note that I'm calling the top of the screen top/up
            // if(colNum == currentPlayerX++ && rowNum == currentPlayerY){
            // System.out.println("To the Right");
            // }
            // if(colNum == currentPlayerX-- && rowNum == currentPlayerY){
            // System.out.println("To the Left");
            // }
            // if(rowNum == currentPlayerY++ && colNum == currentPlayerX){
            // System.out.println("To the Bottom");
            // }
            // if(rowNum == currentPlayerY-- && colNum == currentPlayerX){
            // System.out.println("To the Top");
            // }

            // if(colNum == currentPlayerX++ && rowNum == currentPlayerY++){
            // System.out.println("To the RD");
            // }
            // if(colNum == currentPlayerX++ && rowNum == currentPlayerY--){
            // System.out.println("To the RU");
            // }
            // if(rowNum == currentPlayerY++ && colNum == currentPlayerX--){
            // System.out.println("To the LD");
            // }
            // if(rowNum == currentPlayerY-- && colNum == currentPlayerX--){
            // System.out.println("To the LU");
            // }

            if(TheIsleOfLaeso.collectsLeft > 0){
              String theResource = TheIsleOfLaeso.i.getBoard()[rowNum][colNum];

              if (rowNum == currentPlayerY) {
                  if (colNum == currentPlayerX + 1) {
                      System.out.println("To the Right");

                      if (!theResource.equals("r")) {
                          TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getResource(theResource);
                          //TheIsleOfLaeso.i.remove(theResource, rowNum, colNum);
                          //TheIsleOfLaeso.i.add("r ", rowNum, colNum);
                          TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[rowNum][colNum].substring(2), rowNum, colNum);
                      }

                  }
                  if (colNum == currentPlayerX - 1) {
                      System.out.println("To the Left");
                      if (!theResource.equals("r")) {
                          TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getResource(theResource);
                          TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[rowNum][colNum].substring(2), rowNum, colNum);
                      }
                  }
              }

              if (colNum == currentPlayerX) {
                  if (rowNum == currentPlayerY + 1) {
                      System.out.println("To the Bottom");
                      if (!theResource.equals("r")) {
                          TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getResource(theResource);
                          TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[rowNum][colNum].substring(2), rowNum, colNum);
                      }

                  }
                  if (rowNum == currentPlayerY - 1) {
                      System.out.println("To the Top");
                      if (!theResource.equals("r")) {
                          TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getResource(theResource);
                          TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[rowNum][colNum].substring(2), rowNum, colNum);
                      }

                  }
              }
              TheIsleOfLaeso.collectsLeft = TheIsleOfLaeso.collectsLeft - 1;
              TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName() + "'s turn. "
                      + TheIsleOfLaeso.moveLeft + " moves, " + TheIsleOfLaeso.collectsLeft + " collects left";
                      TheIsleOfLaeso.g.refreshBoard();
            }


            if(TheIsleOfLaeso.moveLeft > 0){
              if (colNum == currentPlayerX + 1) {
                  if (rowNum == currentPlayerY + 1) {
                      System.out.println("To the RD");
                      TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].move("ru");


                  }
                  if (rowNum == currentPlayerY - 1) {
                      System.out.println("To the RU");
                      TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].move("rd");


                  }
              }

              if (colNum == currentPlayerX - 1) {
                  if (rowNum == currentPlayerY + 1) {
                      System.out.println("To the LD");
                      TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].move("lu");


                  }
                  if (rowNum == currentPlayerY - 1) {
                      System.out.println("To the LU");
                      TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].move("ld");


                  }
              }
              TheIsleOfLaeso.moveLeft = TheIsleOfLaeso.moveLeft - 1;
              TheIsleOfLaeso.g.boardText = TheIsleOfLaeso.players[TheIsleOfLaeso.playerTurn - 1].getName() + "'s turn. "
                      + TheIsleOfLaeso.moveLeft + " moves, " + TheIsleOfLaeso.collectsLeft + " collects left";
                      TheIsleOfLaeso.g.refreshBoard();
            }


        }
        System.out.println(TheIsleOfLaeso.i.getBoard()[rowNum][colNum]);
        System.out.println();

    }

    /**
     * This method returns whether a tile is a viable move or collect (detects if a
     * spot has a player, building, or is blank)
     *
     * @return boolean allowed or not depending on the tile occupants
     */
    public boolean allowedMoveCheck() {
        boolean allowed = false;
        return allowed;
    }

    /**
     * This method returns whether a tile has a resource or not (detects if a spot
     * has a resource or is blank)
     *
     * @return boolean allowed or not depending on the tile occupants
     */
    public boolean tileHasRes() {

        return true;
    }

    /**
     * Blank method
     */
    public void mouseEntered(MouseEvent event) {
    }

    /**
     * Blank method
     */
    public void mouseExited(MouseEvent event) {
    }

    /**
     * Blank method
     */
    public void mousePressed(MouseEvent event) {
    }

    /**
     * Blank method
     */
    public void mouseReleased(MouseEvent event) {
    }

}
