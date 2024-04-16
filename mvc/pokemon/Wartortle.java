import java.util.List;

public class Wartortle extends Pokemon {
	public Wartortle(String name, int level) {
        super(name, Type.WATER, level);
        movesBasedOnLevel();
    }
	
	public Wartortle(String name, int level, List<Move> moves) {
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
        if (this.getLevel() >= 10) {
        	System.out.println(this.getName() + " has evloved to " + "Blastoise");
            return new Blastoise(this.getName(), this.getLevel(), this.getMoves());
        }
        else {
            return this;
        }
    }
}
