import java.util.List;

public class Charmeleon extends Pokemon {
    public Charmeleon(int level) {
        super("Charmeleon", Type.FIRE, level);
        movesBasedOnLevel();
    }
	
	public Charmeleon(int level, List<Move> moves, int experiencePoint) {
        super("Charmeleon", Type.FIRE, level, moves, experiencePoint);
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
    }
	
	@Override
    public Object evolve() {
    	if (this.getLevel() >= 10) {
    		return new Charizard(this.getLevel(), this.getMoves(), this.getExperiencePoint());
    	}
    	else {
    		return null;
    	}
    }
}
