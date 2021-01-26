/**
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-1-26
 */


public class Resource {
    char type;
    int amount;

    /**
     * The constructor for a resource object
     * @param type the type of resource
     * @param amount the amount of the resource
     */
    public Resource(char type, int amount) {
        this.type = type;
        this.amount = amount;
    }
}
