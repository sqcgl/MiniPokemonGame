
public class Slowpoke extends Pokemon {
    public Slowpoke(String name, int level) {
        super(name, Type.WATER, level);
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
        	System.out.println(this.getName() + " has evloved to " + "Slowbro");
            return new Slowbro(this.getName(), this.getLevel(), this.getMoves());
        }
        else {
            return this;
        }
    }
}
