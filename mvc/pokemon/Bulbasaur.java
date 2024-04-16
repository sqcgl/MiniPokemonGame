
public class Bulbasaur extends Pokemon {
    public Bulbasaur(String name, int level) {
        super(name, Type.GRASS, level);
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
    		System.out.println(this.getName() + " has evloved to " + "Ivysaur");
    		return new Ivysaur(this.getName(), this.getLevel(), this.getMoves());
    	}
    	else {
    		return this;
    	}
    }
}
