import java.util.List;

public class Ivysaur extends Pokemon {
	public Ivysaur(String name, int level) {
        super(name, Type.GRASS, level);
        movesBasedOnLevel();
    }
	
	public Ivysaur(String name, int level, List<Move> moves) {
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
    }
	
	@Override
    public Object evolve() {
    	if (this.getLevel() >= 10) {
    		System.out.println(this.getName() + " has evloved to " + "Venusaur");
    		return new Venusaur(this.getName(), this.getLevel(), this.getMoves());
    	}
    	else {
    		return this;
    	}
    }
}
