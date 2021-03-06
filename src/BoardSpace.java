/**
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-3-6
 */

public class BoardSpace {

    private Resource r;
    private String terrain;

    /**
     * The constructor for if there is a resource in the space
     */
    public BoardSpace() {
        
    }

    /**
     * The constructor for if there is a square in the space
     * @param terrain
     */
    public BoardSpace(String terrain) {
        this.terrain = terrain;
    }

    /**
     * This method returns the resource found in the space
     * @return the resource found in the space
     */
    public Resource getResource() {
        return r;
    }

    /**
     * This method returns the terrain type of the space
     * @return terrain
     */
    public String getTerrain() {
        return terrain;
    }
}