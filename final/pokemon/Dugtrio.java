import java.util.List;

public class Dugtrio extends Pokemon {
	public Dugtrio(int level) {
        super("Dugtrio", Type.ROCK, level);
        movesBasedOnLevel();
    }
	
	public Dugtrio(int level, List<Move> moves, int experiencePoint) {
        super("Dugtrio", Type.ROCK, level, moves, experiencePoint);
    }
	
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Tackle");
        }

        if (this.getLevel() >= 6) {
            this.learnMove("Rock Throw");
        }
        
        if (this.getLevel() >= 8) {
            this.learnMove("Rock Slide");
        }
    }
    
	@Override
	public Object evolve() {
		return null;
	}
}
