import java.util.List;

public class Ivysaur extends Pokemon {
	public Ivysaur(int level) {
        super("Ivysaur", Type.GRASS, level);
        movesBasedOnLevel();
    }
	
	public Ivysaur(int level, List<Move> moves, int experiencePoint) {
        super("Ivysaur", Type.GRASS, level, moves, experiencePoint);
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
    }
	
	@Override
    public Object evolve() {
    	if (this.getLevel() >= 10) {
    		return new Venusaur(this.getLevel(), this.getMoves(), this.getExperiencePoint());
    	}
    	else {
    		return null;
    	}
    }
}
