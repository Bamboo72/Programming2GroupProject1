/**
 * This class is a die to be used in the game.
 * @author Andrew Blodgett
 * @version 1.0
 * @since 2020-12-9
 */

import java.util.Random;


 public class Dice {
    Random rand = new Random();
    int sides;

    /**
     * The constructor for a new Dice object
     * @param sides
     * @param amount
     */
    public Dice(int sides, int amount) {}

    /**
     * Rolls the die by choosing a random number between 1 and the number of sides
     * @return
     */
    public int roll() {
        return rand.nextInt(sides) + 1;
    }
 }
