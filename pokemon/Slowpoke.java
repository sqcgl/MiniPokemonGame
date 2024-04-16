
public class Slowpoke extends Pokemon {
    public Slowpoke(int level) {
        super("Slowpoke", Type.WATER, level);
        movesBasedOnLevel();
    }
    @Override
    void movesBasedOnLevel() {
        if (this.getLevel() >= 1) {
            this.learnMove("Tackle");
        }
        if (this.getLevel() >= 7) {
            this.learnMove("Water Gun");
        }
    }
    
    @Override
    public Object evolve() {
	        if (this.getLevel() >= 8) {
	            return new Slowbro(this.getLevel(), this.getMoves(), this.getExperiencePoint());
	        }
	        else {
	            return null;
	        }
	    }
    // Delete the if statement just return null if you want to try special evolve
}
