import java.util.List;

public class Slowbro extends Pokemon {
	public Slowbro(String name, int level) {
        super(name, Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Slowbro(String name, int level, List<Move> moves) {
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
    }
    
	@Override
	public Object evolve() {
		return this;
	}
}
