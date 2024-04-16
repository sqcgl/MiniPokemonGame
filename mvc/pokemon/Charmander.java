public class Charmander extends Pokemon {
    public Charmander(String name, int level) {
        super(name, Type.FIRE, level);
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
    		System.out.println(this.getName() + " has evloved to " + "Charmeleon");
    		return new Charmeleon(this.getName(), this.getLevel(), this.getMoves());
    	}
    	else {
    		return this;
    	}
    }
}