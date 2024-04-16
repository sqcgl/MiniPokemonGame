import java.util.List;

public class Blastoise extends Pokemon {
	public Blastoise(String name, int level) {
        super(name, Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Blastoise(String name, int level, List<Move> moves) {
        super(name, Type.WATER, level, moves);
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
		return this;
	}
}
