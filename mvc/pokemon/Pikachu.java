import java.util.List;

public class Pikachu extends Pokemon {
	public Pikachu(String name, int level) {
        super(name, Type.ELECTRIC, level);
        movesBasedOnLevel();
    }
	
	public Pikachu(String name, int level, List<Move> moves) {
        super(name, Type.ELECTRIC, level, moves);
    }
	
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Scratch");
        }

        if (this.getLevel() >= 7) {
            this.learnMove("Tackle");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Thunder Shock");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Thunderbolt");
        }
    }
    
	@Override
	public Object evolve() {
		return this;
	}
}
