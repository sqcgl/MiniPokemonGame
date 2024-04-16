import java.util.List;

public class Charizard extends Pokemon {
	public Charizard(int level) {
        super("Charizard", Type.FIRE, level);
        movesBasedOnLevel();
    }
	
	public Charizard(int level, List<Move> moves, int experiencePoint) {
        super("Charizard", Type.FIRE, level, moves, experiencePoint);
    }
	
	@Override
	void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Scratch");
        }

        // Learn Ember at level 7
        if (this.getLevel() >= 7) {
            this.learnMove("Ember");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Flamethrower");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Fire Blast");
        }
    }
	
	@Override
	public Object evolve() {
		return null;
	}
}
