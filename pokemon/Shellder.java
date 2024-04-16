
public class Shellder extends Pokemon {
    public Shellder(int level) {
        super("Shellder", Type.WATER, level);
        movesBasedOnLevel();
    }
    @Override
    void movesBasedOnLevel() {
        if (this.getLevel() >= 1) {
            this.learnMove("Water Gun");
        }
    }
    
    @Override
    public Object evolve() {
    	return null;
    }
}
