//import java.util.TreeMap;

/**
 * Class for an event generator. Does not need to be instantiated as an object; all methods are static.
 * The generator can pick a random event, or can take a specified event, and make it take effect.
 * @author Brandon Winters
 * @since 2021-5-14
 */
public class NaturalEventGenerator {

    /** a random event, with weighted probability */
    public static final int RANDOM = -1;

    /** moves the player in a random direction */
    public static final int TORNADO = 0;

    /** burns 1-3 wood */
    public static final int FIRE = 1;

    /** 20% chance of burning 1 wood; if this occurs, 50% chance of breaking one stone. 2% chance of damaging the player. 100% change of killing one person. */
    public static final int LIGHTNING = 2;

    /** eats 1-2 food */
    public static final int BUGS = 3;

    /** 50% chance of removing 1 food; if this occurs, 50% chance of killing one person. 100% chance of killing one other person, regardless of the previous outcomes */
    public static final int PLAGUE = 4;

    /** breaks 1-3 stone */
    public static final int EXPLOSION = 5;

    /** trades 1-2 people for 1-2 stone (equal -people for equal +stone) */
    public static final int ABDUCTION = 6;

    /** gives 1-2 people */
    public static final int ADOPTION = 7;

    /** 50% chance of giving 2 food. 10% chance of killing one person. 50% chance of washing away 2 wood. */
    public static final int TSUNAMI = 8;

    /** removes 1-2 food and people */
    public static final int FAMINE = 9;

    /** grows 2-3 food */
    public static final int RAIN = 10;

    /** gives 1-2 wood from falling trees. For every wood, 50% chance of killing one person */
    public static final int EARTHQUAKE = 11;

    /** washes away 1-2 food or grows 1-2 food; equally weighted. 10% chance of giving one wood from falling trees */
    public static final int FLOOD = 12;

//    public static void main(String[] args) {
//        Player player = new Player(0, 0, "Bob", "Hat", "Clothes", "Red", new int[] {0, 0, 0, 0, 0, 0}, 100);
//        Player player1 = new Player(0, 0, "Rob", "Hat", "Clothes", "Red", new int[] {0, 0, 0, 0, 0, 0}, 100);
//        TreeMap<Integer, Integer> occurrenceRates = new TreeMap<>();
//        int tests = 100000;
//        for (int i = 0; i < tests; i++) {
//            int eventID = generateRandomEventID();
//            if (occurrenceRates.get(eventID) != null)
//                occurrenceRates.replace(eventID, occurrenceRates.get(eventID) + 1);
//            else
//                occurrenceRates.put(eventID, 1);
//        }
//        for (Integer key : occurrenceRates.keySet()) {
//            System.out.println(key + ": " + occurrenceRates.get(key) + " ~" + (occurrenceRates.get(key) / (double)tests * 100 + "%"));
//        }
//        for (int i = 0; i < tests; i++) {
//            System.out.println(generateEvent(player));
//            System.out.println("x: " + player.getXPos());
//            System.out.println("y: " + player.getYPos());
//            System.out.println("wood: " + player.getResource("wood"));
//            System.out.println("people: " + player.getResource("people"));
//            System.out.println("food: " + player.getResource("food"));
//            System.out.println("stone: " + player.getResource("stone"));
//            System.out.println("health: " + player.getHealth());
//        }
//        Player[] players = new Player[] {player, player1};
//        for (int i = 0; i < tests; i++) {
//            System.out.println(generateGlobalEvent(players));
//            System.out.println("x: " + player.getXPos());
//            System.out.println("y: " + player.getYPos());
//            System.out.println("wood: " + player.getResource("wood"));
//            System.out.println("people: " + player.getResource("people"));
//            System.out.println("food: " + player.getResource("food"));
//            System.out.println("stone: " + player.getResource("stone"));
//            System.out.println("health: " + player.getHealth());
//            System.out.println("x1: " + player1.getXPos());
//            System.out.println("y1: " + player1.getYPos());
//            System.out.println("wood1: " + player1.getResource("wood"));
//            System.out.println("people1: " + player1.getResource("people"));
//            System.out.println("food1: " + player1.getResource("food"));
//            System.out.println("stone1: " + player1.getResource("stone"));
//            System.out.println("health1: " + player1.getHealth());
//        }
//    }

    /**
     * Puts into effect a randomly selected event. Selection generated from {@link #generateRandomEventID()}
     * @param impactedPlayer the player for the event to occur to and affect.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateEvent(Player impactedPlayer) {
        return generateEvent(RANDOM, impactedPlayer);
    }

    /**
     * Puts into effect an event with a specified eventID.
     * @param eventID the type of event to do. If given an invalid value, {@link #generateRandomEventID()} will provide an eventID.
     * @param impactedPlayer the player for the event to occur to and affect.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateEvent(int eventID, Player impactedPlayer) {
        switch (eventID) {
            case TORNADO -> {
                double random = Math.random();
                String direction;
                if (random < 0.25) {
                    direction = "lu";
                } else if (random < 0.5) {
                    direction = "ld";
                } else if (random < 0.75) {
                    direction = "ru";
                } else {
                    direction = "rd";
                }
                impactedPlayer.move(direction);
                System.out.println("Warning: The player may have moved off the board.");
            } case FIRE -> {
                int lostWood = -(int)(Math.random() * 3) - 1;
                impactedPlayer.addResource("wood", lostWood);
            } case LIGHTNING -> {
                double random = Math.random();
                if (random < 0.1) {
                    impactedPlayer.addResource("stone", -1);
                }
                if (random < 0.2) {
                    impactedPlayer.addResource("wood", -1);
                }
                random = Math.random();
                if (random < 0.02) {
                    impactedPlayer.damage();
                }
                impactedPlayer.addResource("people", -1);
            } case BUGS -> {
                int lostFood = -(int)(Math.random() * 2) - 1;
                impactedPlayer.addResource("food", lostFood);
            } case PLAGUE -> {
                double random = Math.random();
                if (random < 0.5) {
                    impactedPlayer.addResource("food", -1);
                }
                if (random < 0.25) {
                    impactedPlayer.addResource("people", -1);
                }
                impactedPlayer.addResource("people", -1);
            } case EXPLOSION -> {
                int lostStone = -(int)(Math.random() * 3) - 1;
                impactedPlayer.addResource("stone", lostStone);
            } case ABDUCTION -> {
                int trade = (int)(Math.random() * 2) + 1;
                impactedPlayer.addResource("people", -trade);
                impactedPlayer.addResource("stone", trade);
            } case ADOPTION -> {
                int newPeople = (int)(Math.random() * 2) + 1;
                impactedPlayer.addResource("people", newPeople);
            } case TSUNAMI -> {
                double random = Math.random();
                if (random < 0.5) {
                    impactedPlayer.addResource("food", 2);
                }
                random = Math.random();
                if (random < 0.1) {
                    impactedPlayer.addResource("people", -1);
                }
                random = Math.random();
                if (random < 0.5) {
                    impactedPlayer.addResource("wood", -2);
                }
            } case FAMINE -> {
                int lostFoodAndPeople = -(int)(Math.random() * 2) - 1;
                impactedPlayer.addResource("food", lostFoodAndPeople);
                impactedPlayer.addResource("people", lostFoodAndPeople);
            } case RAIN -> {
                int food = (int)(Math.random() * 2) + 2;
                impactedPlayer.addResource("food", food);
            } case EARTHQUAKE -> {
                int wood = (int) (Math.random() * 2) + 1;
                impactedPlayer.addResource("wood", wood);
                for (int i = 0; i < wood; i++) {
                    if (Math.random() < 0.5)
                        impactedPlayer.addResource("people", -1);
                }
            } case FLOOD -> {
                int food = (int)(Math.random() * 2) + 1;
                if (Math.random() < 0.5) {
                    food = -food;
                }
                impactedPlayer.addResource("food", food);
                if (Math.random() < 0.1) {
                    impactedPlayer.addResource("wood", 1);
                }
            } default -> {
                return generateEvent(generateRandomEventID(), impactedPlayer);
            }
        }
        return getEventIDName(eventID);
    }

    /**
     * Generates an random event which impacts a list of players. The specific outcomes (chances within the event) are not necessarily the same for each player.
     * However, the same event will occur to all of the players.
     * @param players the players in the game to impact. For a truly "global" event, list all players in the game.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateGlobalEvent(Player[] players) {
        return generateGlobalEvent(RANDOM, players);
    }

    /**
     * Generates an event which impacts a list of players. The specific outcomes (chances within the event) are not necessarily the same for each player.
     * However, the same event will occur to all of the players.
     * @param eventID the type of event to do. If given an invalid value, {@link #generateRandomEventID()} will provide an eventID. The same event will occur to all players.
     * @param players the players in the game to impact. For a truly "global" event, list all players in the game.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateGlobalEvent(int eventID, Player[] players) {
        if (!isValidEventID(eventID)) {
            eventID = generateRandomEventID();
        }
        for (Player player : players) {
            generateEvent(eventID, player);
        }
        return getEventIDName(eventID);
    }

    /**
     * Provides a random eventID, with weighted probability.
     * Weighting:
     *  8%  Tornado     0
     *  7%  Fire        1
     *  8%  Lighting    2
     * 10%  Bugs        3
     *  6%  Plague      4
     *  8%  Explosion   5
     *  9%  Abduction   6
     *  6%  Adoption    7
     *  6%  Tsunami     8
     *  6%  Famine      9
     * 10%  Rain        10
     *  8%  Earthquake  11
     *  8%  Flood       12
     * @return a random eventID
     */
    public static int generateRandomEventID() {
        double p0 = 0.08;
        double p1 = 0.07 + p0;
        double p2 = 0.08 + p1;
        double p3 = 0.1 + p2;
        double p4 = 0.06 + p3;
        double p5 = 0.08 + p4;
        double p6 = 0.09 + p5;
        double p7 = 0.06 + p6;
        double p8 = 0.06 + p7;
        double p9 = 0.06 + p8;
        double p10 = 0.1 + p9;
        double p11 = 0.08 + p10;
        double p12 = 0.08 + p11;
        double selector = Math.random();
        if (selector < p0)
            return 0;
        else if (selector < p1)
            return 1;
        else if (selector < p2)
            return 2;
        else if (selector < p3)
            return 3;
        else if (selector < p4)
            return 4;
        else if (selector < p5)
            return 5;
        else if (selector < p6)
            return 6;
        else if (selector < p7)
            return 7;
        else if (selector < p8)
            return 8;
        else if (selector < p9)
            return 9;
        else if (selector < p10)
            return 10;
        else if (selector < p11)
            return 11;
        else if (selector < p12)
            return 12;
        else
            return -1; // this should be impossible to reach
    }

    /**
     * Gets the corresponding name of the event from the eventID
     * @param eventID the ID of the event
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String getEventIDName(int eventID) {
        return switch (eventID) {
            case TORNADO -> "Tornado!";
            case FIRE -> "Fire!";
            case LIGHTNING -> "Lightning!";
            case BUGS -> "Bugs!";
            case PLAGUE -> "Plague!";
            case EXPLOSION -> "Explosion!";
            case ABDUCTION -> "Abduction!";
            case ADOPTION -> "Adoption!";
            case TSUNAMI -> "Tsunami!";
            case FAMINE -> "Famine!";
            case RAIN -> "Rain!";
            case EARTHQUAKE -> "Earthquake!";
            case FLOOD -> "Flood!";
            default -> "???";
        };
    }

    /**
     * @param eventID the ID of the event
     * @return if the ID of the event is valid
     */
    public static boolean isValidEventID(int eventID) {
        return !getEventIDName(eventID).equals("???");
    }
}
