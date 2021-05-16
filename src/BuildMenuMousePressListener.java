// Jacob Schwartz - 5/14/2021
// This is the MouseListener class for the build menu.
// Code copied then modified from the MousePressListener class.

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class BuildMenuMousePressListener implements MouseListener{
    /**
     * This method detects when the mouse is clicked and changes the string toBeBuilt accordingly
     */
    public void mouseClicked(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        int rowNum = 0;

        System.out.println("(" + x + ", " + y + ")");

        y = (y - 20) / 134;
        if (0 < y && y <= 1) { // 1.54
            rowNum = 0;
            TheIsleOfLaeso.g.toBeBuilt = "Storehouse";
        } else if (1 < y && y <= 2) {
            rowNum = 1;
            TheIsleOfLaeso.g.toBeBuilt = "Town";
        } else if (2 < y && y <= 3) {
            rowNum = 2;
            TheIsleOfLaeso.g.toBeBuilt = "Fort";
        } else if (3 < y && y <= 4) {
            rowNum = 3;
            TheIsleOfLaeso.g.toBeBuilt = "Port";
        } else if (4 < y && y <= 5) {
            rowNum = 4;
            TheIsleOfLaeso.g.toBeBuilt = "Boat";
        } else {
            rowNum = -1;
        }

        System.out.println("Row: " + rowNum + ", toBeBuilt " + TheIsleOfLaeso.g.toBeBuilt);

        TheIsleOfLaeso.g.hideActivePanel();
        TheIsleOfLaeso.g.sceneDisplay(7);
        TheIsleOfLaeso.g.refresh();
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
