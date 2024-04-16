import java.util.List;

public class Charmeleon extends Pokemon {
    public Charmeleon(String name, int level) {
        super(name, Type.FIRE, level);
        movesBasedOnLevel();
    }
	
	public Charmeleon(String name, int level, List<Move> moves) {
        super(name, Type.FIRE, level, moves);
    }
	
	@Override
	void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Scratch");
        }

        // Learn Ember at level 7
        if (this.getLevel() >= 7) {
            this.learnMove("Ember");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Flamethrower");
        }
    }
	
	@Override
    public Object evolve() {
    	if (this.getLevel() >= 10) {
    		System.out.println(this.getName() + " has evloved to " + "Charizard");
    		return new Charizard(this.getName(), this.getLevel(), this.getMoves());
    	}
    	else {
    		return this;
    	}
    }
}
