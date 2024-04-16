
public class Diglett extends Pokemon{
    public Diglett(String name, int level) {
        super(name, Type.ROCK, level);
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
    		System.out.println(this.getName() + " has evloved to " + "Dugtrio");
    		return new Dugtrio(this.getName(), this.getLevel(), this.getMoves());
    	}
    	else {
    		return this;
    	}
    }
}
