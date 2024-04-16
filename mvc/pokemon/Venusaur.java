import java.util.List;

public class Venusaur extends Pokemon {
	public Venusaur(String name, int level) {
        super(name, Type.GRASS, level);
        movesBasedOnLevel();
    }
	
	public Venusaur(String name, int level, List<Move> moves) {
        super(name, Type.GRASS, level, moves);
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
		return this;
	}
}
