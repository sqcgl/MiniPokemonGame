import java.util.HashMap;
import java.util.Map;

public class MoveList {
    private static final Map<String, Move> moves = new HashMap<>();

    static {
        // Basic moves
        moves.put("Scratch", new Move("Scratch", Type.NORMAL, 10, 100));
        moves.put("Ember", new Move("Ember", Type.FIRE, 15, 100));
        moves.put("Vine Whip", new Move("Vine Whip", Type.GRASS, 15, 100));
        moves.put("Water Gun", new Move("Water Gun", Type.WATER, 15, 100));
        moves.put("Tackle", new Move("Tackle", Type.NORMAL, 10, 100));
        moves.put("Thunder Shock", new Move("Thunder Shock", Type.ELECTRIC, 15, 100));
        moves.put("Rock Throw", new Move("Rock Throw", Type.ROCK, 20, 90));
        moves.put("Ice Beam", new Move("Ice Beam", Type.ICE, 15, 100));

        // More advanced moves
        moves.put("Flamethrower", new Move("Flamethrower", Type.FIRE, 30, 100));
        moves.put("Hydro Pump", new Move("Hydro Pump", Type.WATER, 30, 80));
        moves.put("Solar Beam", new Move("Solar Beam", Type.GRASS, 30, 100));
        moves.put("Thunderbolt", new Move("Thunderbolt", Type.ELECTRIC, 30, 100));
        moves.put("Rock Slide", new Move("Rock Slide", Type.ROCK, 40, 70));
        moves.put("Blizzard", new Move("Blizzard", Type.ICE, 40, 70));
        moves.put("Fire Blast", new Move("Fire Blast", Type.FIRE, 40, 70));
    }

    public static Move getMove(String moveName) {
        return moves.get(moveName);
    }
}
