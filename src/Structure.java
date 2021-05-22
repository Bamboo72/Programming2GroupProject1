/**
 * The class that represents a structure for isle of laeso.
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-05-13
 */

public class Structure {

    char type; // Building types: 'r' for resource gatherer, 'v' for village, 'f' for fortress, 'p' for port, and 'b' for boat.
    int[] cost;
    int x, y;
    int health, owner;
    static String resources;

    /**
     * The constructor for the Structure class.
     * @param buildingType, x, y, buildingHealth, buildingOwner
     */
    public Structure(char buildingType, int x, int y, int buildingHealth, int buildingOwner) {
        type = buildingType;
        cost = new int[5];
        findBuildCost();
        this.x = x;
        this.y = y;
        health = buildingHealth;
        owner = buildingOwner;
    }

    /**
     * This method will determine the cost of a building using the type.
     */
    private void findBuildCost() {
        /**
         * cost[0] is wood
         * cost[1] is people
         * cost[2] is food
         * cost[3] is stone
         * cost[4] is ore
         */
        switch(type) {
            case 'r':
                cost[0] = 4;
                cost[1] = 0;
                cost[2] = 3;
                cost[3] = 0;
                cost[4] = 0;
                break;
            case 'v':
                cost[0] = 5;
                cost[1] = 5;
                cost[2] = 0;
                cost[3] = 5;
                cost[4] = 0;
                break;
            case 'f':
                cost[0] = 0;
                cost[1] = 5;
                cost[2] = 0;
                cost[3] = 7;
                cost[4] = 3;
                break;
            case 'p':
                cost[0] = 6;
                cost[1] = 0;
                cost[2] = 0;
                cost[3] = 5;
                cost[4] = 4;
                break;
            case 'b':
                cost[0] = 9;
                cost[1] = 7;
                cost[2] = 7;
                cost[3] = 0;
                cost[4] = 0;
                break;
            default: break;
        }
    }

    /**
     * A method to get the building type.
     * @return type
     */
    public char getType() {
        return type;
    }

    /**
     * A method to get the building cost.
     * @return cost
     */
    public int[] getCost() {
        return cost;
    }

    /**
     * A method to get the x-coordinate
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * A method to get the y-coordinate
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * A method to get the building's health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    public void addHealth(int amount) {
        health += amount;
    }

    public void gatherResources() {
        if (type == 'r') {
            if (TheIsleOfLaeso.i.getBoard()[y+1][x].length() > 2) {
                resources += TheIsleOfLaeso.i.getBoard()[y+1][x].substring(2);
                TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[y+1][x].substring(2), x, y+1);
            } else if (TheIsleOfLaeso.i.getBoard()[y-1][x].length() > 2) {
                resources += TheIsleOfLaeso.i.getBoard()[y-1][x].substring(2);
                TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[y-1][x].substring(2), x, y-1);
            } else if (TheIsleOfLaeso.i.getBoard()[y][x+1].length() > 2) {
                resources += TheIsleOfLaeso.i.getBoard()[y][x+1].substring(2);
                TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[y][x+1].substring(2), x+1, y);
            } else if (TheIsleOfLaeso.i.getBoard()[y][x-1].length() > 2) {
                resources += TheIsleOfLaeso.i.getBoard()[y][x-1].substring(2);
                TheIsleOfLaeso.i.remove(TheIsleOfLaeso.i.getBoard()[y][x-1].substring(2), x-1, y);
            }
        }
    }
}