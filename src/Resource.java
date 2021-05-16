/**
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2021-3-6
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

    public void increase() {
        amount++;
    }

    public void takeResources(int taken) {
        amount -= taken;
    }
}