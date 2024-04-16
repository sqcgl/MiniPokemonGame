
public class Diglett extends Pokemon{
    public Diglett(int level) {
        super("Diglett", Type.ROCK, level);
        movesBasedOnLevel();
    }
    
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Tackle");
        }

        if (this.getLevel() >= 6) {
            this.learnMove("Rock Throw");
        }
    }
    
    @Override
    public Object evolve() {
    	if (this.getLevel() >= 7) {
    		return new Dugtrio(this.getLevel(), this.getMoves(), this.getExperiencePoint());
    	}
    	else {
    		return null;
    	}
    }
}
