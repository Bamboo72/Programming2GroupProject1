/**
 * The class that represents a structure for isle of laeso. 
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-05-13
 */

public class Structure {
    
    private char type; // Building types: 'r' for resource gatherer, 'v' for village, 'f' for fortress, 'p' for port, and 'b' for boat.
    private int[] cost;
    private int x, y, health;

    /**
     * The constructor for the Structure class.
     * @param buildingType
     */
    public Structure(char buildingType, int x, int y, int buildingHealth) {
        type = buildingType;
        cost = new int[5];
        findBuildCost();
        this.x = x;
        this.y = y;
        health = buildingHealth;
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
            case 'f':
                cost[0] = 0;
                cost[1] = 5;
                cost[2] = 0;
                cost[3] = 7;
                cost[4] = 3;
            case 'p':
                cost[0] = 6;
                cost[1] = 0;
                cost[2] = 0;
                cost[3] = 5;
                cost[4] = 4;
            case 'b':
                cost[0] = 9;
                cost[1] = 7;
                cost[2] = 7;
                cost[3] = 0;
                cost[4] = 0;
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
    
}