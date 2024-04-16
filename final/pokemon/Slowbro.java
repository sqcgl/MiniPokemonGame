import java.util.List;

public class Slowbro extends Pokemon {
	public Slowbro(int level) {
        super("Slowbro", Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Slowbro(int level, List<Move> moves, int experiencePoint) {
        super("Slowbro", Type.WATER, level, moves, experiencePoint);
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
		return null;
	}
}
