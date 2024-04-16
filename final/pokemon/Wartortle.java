import java.util.List;

public class Wartortle extends Pokemon {
	public Wartortle(int level) {
        super("Wartortle", Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Wartortle(int level, List<Move> moves, int experiencePoint) {
        super("Wartortle", Type.WATER, level, moves, experiencePoint);
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
        if (this.getLevel() >= 10) {
            return new Blastoise(this.getLevel(), this.getMoves(), this.getExperiencePoint());
        }
        else {
            return null;
        }
    }
}
