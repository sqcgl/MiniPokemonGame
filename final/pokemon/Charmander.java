public class Charmander extends Pokemon {
    public Charmander(int level) {
        super("Charmander", Type.FIRE, level);
        movesBasedOnLevel();
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
    }
    
    @Override
    public Object evolve() {
    	if (this.getLevel() >= 8) {
    		return new Charmeleon(this.getLevel(), this.getMoves(), this.getExperiencePoint());
    	}
    	else {
    		return null;
    	}
    }
}