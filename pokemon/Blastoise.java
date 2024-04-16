import java.util.List;

public class Blastoise extends Pokemon {
	public Blastoise(int level) {
        super("Blastoise", Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Blastoise(int level, List<Move> moves, int experiencePoint) {
        super("Blastoise", Type.WATER, level, moves, experiencePoint);
    }
	
	@Override
    void movesBasedOnLevel() {
        if (this.getLevel() >= 1) {
            this.learnMove("Tackle");
        }
        if (this.getLevel() >= 7) {
            this.learnMove("Water Gun");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Hydro Pump");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Blizzard");
        }
    }
	
	@Override
	public Object evolve() {
		return null;
	}
}
