import java.util.ArrayList;

/**
 * Class for an improved event generator, which also affects structures. Does not need to be instantiated as an object; all methods are static.
 * The generator can pick a random event, or can take a specified event, and make it take effect.
 * @author Brandon Winters
 * @since 2021-5-21
 */
public class EnhancedNaturalEventGenerator extends NaturalEventGenerator {

    /*
        Event: player effect | structure effect

        Random: a random event, with weighted probability
        Tornado: moves the player in a random direction | 20% chance of damaging building
        Fire: burns 1-3 wood | 50% chance of damaging building
        Lightning: 20% chance of burning 1 wood; if this occurs, 50% chance of breaking one stone. 2% chance of damaging the player. 100% change of killing one person. | 20% chance to damage building
        Bugs: eats 1-2 food | no effect
        Plague: 50% chance of removing 1 food; if this occurs, 50% chance of killing one person. 100% chance of killing one other person, regardless of the previous outcomes | no effect
        Explosion: breaks 1-3 stone | 50% chance of damaging building
        Abduction: trades 1-2 people for 1-2 stone (equal -people for equal +stone) | heals building
        Adoption: gives 1-2 people | no effect
        Tsunami: 50% chance of giving 2 food. 10% chance of killing one person. 50% chance of washing away 2 wood. | 75% chance of damaging building
        Famine: removes 1-2 food and people | no effect
        Rain: grows 2-3 food | if the previous event was fire, heals building
        Earthquake: gives 1-2 wood from falling trees. For every wood, 50% chance of killing one person | 60% chance of damaging building
        Flood: washes away 1-2 food or grows 1-2 food; equally weighted. 10% chance of giving one wood from falling trees | 30% chance of damaging building
     */

    public static int previousEvent = -1;

    /**
     * Puts into effect a randomly selected event. Selection generated from {@link #generateRandomEventID()}
     * @param impactedStructure the structure for the event to occur to and affect.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateEvent(Structure impactedStructure) {
        return generateEvent(RANDOM, impactedStructure);
    }

    /**
     * Puts into effect an event with a specified eventID.
     * @param eventID the type of event to do. If given an invalid value, {@link #generateRandomEventID()} will provide an eventID.
     * @param impactedStrucure the structure for the event to occur to and affect.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateEvent(int eventID, Structure impactedStrucure) {
        double random = Math.random();
        if (!isValidEventID(eventID))
            return generateEvent(generateRandomEventID(), impactedStrucure);
        switch (eventID) {
            case TORNADO:
            case LIGHTNING:
            case FLOOD:
                if (random < 0.2)
                    impactedStrucure.addHealth(-1);
                break;
            case FIRE:
            case EXPLOSION:
                if (random < 0.5)
                    impactedStrucure.addHealth(-1);
                break;
            case ABDUCTION:
                impactedStrucure.addHealth(1);
                break;
            case TSUNAMI:
                if (random < 0.75)
                    impactedStrucure.addHealth(-1);
                break;
            case RAIN:
                if (previousEvent == FIRE)
                    impactedStrucure.addHealth(1);
                break;
            case EARTHQUAKE:
                if (random < 0.6)
                    impactedStrucure.addHealth(-1);
                break;
        }
        previousEvent = eventID;
        return getEventIDName(eventID);
    }

    /**
     * Generates an random event which impacts a list of players and structures. The specific outcomes (chances within the event) are not necessarily the same for each.
     * However, the same event will occur to everything.
     * @param players the players in the game to impact. For a truly "global" event, list all players in the game.
     * @param structures the structures in the game to impact.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateGlobalEvent(Player[] players, Structure[] structures) {
        return generateGlobalEvent(RANDOM, players, structures);
    }

    /**
     * Generates an event which impacts a list of players. The specific outcomes (chances within the event) are not necessarily the same for each player.
     * However, the same event will occur to all of the players.
     * @param eventID the type of event to do. If given an invalid value, {@link #generateRandomEventID()} will provide an eventID. The same event will occur to all players.
     * @param players the players in the game to impact. For a truly "global" event, list all players in the game.
     * @param structures the structures in the game to impact.
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateGlobalEvent(int eventID, Player[] players, Structure[] structures) {
        if (!isValidEventID(eventID)) {
            eventID = generateRandomEventID();
        }
        for (Player player : players) {
            generateEvent(eventID, player);
        }
        for (Structure structure : structures) {
            generateEvent(eventID, structure);
        }
        return getEventIDName(eventID);
    }

    /**
     * Generates an event which impacts a list of players. The specific outcomes (chances within the event) are not necessarily the same for each player.
     * However, the same event will occur to all of the players.
     * @param eventID the type of event to do. If given an invalid value, {@link #generateRandomEventID()} will provide an eventID. The same event will occur to all players.
     * @param players the players in the game to impact. For a truly "global" event, list all players in the game.
     * @param structures the structures in the game to impact.
     * @param probability the individual probabilities for the event to occur to each object (0.5, for example, should lead to approximately 50% of the objects being affected)
     * @return the name of the event which happened, with an exclamation point at the end. Example: "Tsunami!"
     */
    public static String generateGlobalEvent(int eventID, Player[] players, Structure[] structures, double probability) {
        if (!isValidEventID(eventID)) {
            eventID = generateRandomEventID();
        }
        for (Player player : players) {
            if (Math.random() < probability)
                generateEvent(eventID, player);
        }
        for (Structure structure : structures) {
            if (Math.random() < probability)
                generateEvent(eventID, structure);
        }
        return getEventIDName(eventID);
    }

    public static Structure[] selectRandomStructures(Structure[] structures) {
        return selectRandomStructures(structures, 0.5);
    }

    public static Structure[] selectRandomStructures(Structure[] structures, double probability) {
        ArrayList<Structure> returnList = new ArrayList<>();
        for (Structure structure : structures) {
            if (Math.random() < probability)
                returnList.add(structure);
        }
        Structure[] newStructures = new Structure[returnList.size()];
        return returnList.toArray(newStructures);
    }
}
