

public class Lapras extends Pokemon {
	public Lapras(int level) {
        super("Lapras", Type.ICE, level);
        movesBasedOnLevel();
    }
	
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Tackle");
        }

        if (this.getLevel() >= 7) {
            this.learnMove("Water Gun");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Ice Beam");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Blizzard");
        }
    }
    
	@Override
	public Object evolve() {
		return null;
	}
}
