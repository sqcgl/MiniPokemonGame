
public class Bulbasaur extends Pokemon {
    public Bulbasaur(int level) {
        super("Bulbasaur", Type.GRASS, level);
        movesBasedOnLevel();
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
    }
    
    @Override
    public Object evolve() {
    	if (this.getLevel() >= 8) {
    		return new Ivysaur(this.getLevel(), this.getMoves(), this.getExperiencePoint());
    	}
    	else {
    		return null;
    	}
    }
}
