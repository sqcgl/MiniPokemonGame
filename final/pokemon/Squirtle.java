public class Squirtle extends Pokemon {
    public Squirtle(int level) {
        super("Squirtle", Type.WATER, level);
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
            return new Wartortle(this.getLevel(), this.getMoves(), this.getExperiencePoint());
        }
        else {
            return null;
        }
    }
}
