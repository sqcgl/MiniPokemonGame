

public class Pikachu extends Pokemon {
	public Pikachu(int level) {
        super("Pikachu", Type.ELECTRIC, level);
        movesBasedOnLevel();
    }
	
    @Override
    void movesBasedOnLevel() {
        // Add Scratch if level is 1 or higher
        if (this.getLevel() >= 1) {
            this.learnMove("Scratch");
        }

        if (this.getLevel() >= 7) {
            this.learnMove("Tackle");
        }
        
        if(this.getLevel() >= 9) {
        	this.learnMove("Thunder Shock");
        }
        
        if(this.getLevel() >= 11) {
        	this.learnMove("Thunderbolt");
        }
    }
    
	@Override
	public Object evolve() {
		return null;
	}
}
