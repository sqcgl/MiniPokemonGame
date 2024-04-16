import java.util.List;

public class Venusaur extends Pokemon {
	public Venusaur(int level) {
        super("Venusaur", Type.GRASS, level);
        movesBasedOnLevel();
    }
	
	public Venusaur(int level, List<Move> moves, int experiencePoint) {
        super("Venusaur", Type.GRASS, level, moves, experiencePoint);
    }
	
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Scratch");
        }

        if (this.getLevel() >= 7) {
            this.learnMove("Vine Whip");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Solar Beam");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Rock Slide");
        }
    }
    
	@Override
	public Object evolve() {
		return null;
	}
}
