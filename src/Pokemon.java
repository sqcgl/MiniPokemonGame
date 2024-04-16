import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {
    // Parameter of the Pokemon
	protected String name; // Pokemon's name
	protected Type type; // Pokemon's type
	protected int maxHealth; // Pokemon's maximum health
	protected int healthPoints; // Pokemon's current health point(hp)
	protected int level; // Pokemon's level
	protected int experiencePoint; // Pokemon's current experience point(exp)
	protected int experienceBar; // Total experience the people need to level up
	protected List<Move> moves; // Pokemon's moves
	protected boolean fainted;
	
    // Constructor to create a new Pokemon
    public Pokemon(String name, Type type, int level) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.maxHealth = 20 + this.level * 5; // 20 base health + level * 5
        this.healthPoints = this.maxHealth; // default to it's max health at the beginning
        this.experiencePoint = 0; // default to 0 at the beginning
        this.experienceBar = this.level *3; // 3 times of it's current level
        this.moves = new ArrayList<Move>(); // Max 4 moves
        this.fainted = false;
    }
    
    public Pokemon(String name, Type type, int level, List<Move> moves, int experiencePoint) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.maxHealth = 20 + this.level * 5; // 20 base health + level * 5
        this.healthPoints = this.maxHealth; // default to it's max health at the beginning
        this.experiencePoint = experiencePoint; // default to 0 at the beginning
        this.experienceBar = this.level *3; // 3 times of it's current level
        this.moves = moves; // Max 4 moves
        this.fainted = false;
    }
    
    // Getters
    public String getName() {
        return this.name;
    }

    public Type getType() {
        return this.type;
    }

    public int getHealthPoints() {
        return this.healthPoints;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExperiencePoint() {
        return this.experiencePoint;
    }
    
    public int getExperiencBar() {
        return this.experienceBar;
    }
    
    public int getMaxHealth() {
        return this.maxHealth;
    }
    
    public List<Move> getMoves() {
    	return this.moves;
    }
    
    public boolean getFainted() {
    	return this.fainted;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setHealthPoints (int healthPoints) {
    	if(healthPoints < 0) {
    		healthPoints = 0;
    	}
        this.healthPoints = healthPoints;
    }

    public void setLevel(int newLevel) throws IllegalArgumentException {
        if (newLevel < 1) {
            throw new IllegalArgumentException("Level must be at least 1");
        } else {
            // Update the level
            this.level = newLevel;
            // Update max health based on the new level
            this.maxHealth = 20 + this.level * 5;
            // Update the health points to the new max health
            this.healthPoints = this.maxHealth;
            // Update the experience bar to be 3 times the new level
            this.experienceBar = this.level * 3;
            // Optionally reset the current experience to zero or adjust as needed
            this.experiencePoint = 0;
        }
    }

    public void setExperiencePoint(int experiencePoint) { 
        this.experiencePoint = experiencePoint;
    }
    
    public void setMoves(List<Move> moves) throws IllegalArgumentException {
    	if(moves.size() > 4) {
    		throw new IllegalArgumentException("Pokemon can only have 4 moves");
    	}
    	else {
    		this.moves = moves;
    	}
    }
    
    public void setFainted(boolean fainted) {
    	this.fainted = fainted;
    }
    
   // Method
    
    public void rest() {
        this.healthPoints = this.maxHealth;
    }
    
    public void gainExperiencePoint(Pokemon otherPokemon) {
    	this.experiencePoint += otherPokemon.getLevel();
    }
    
    public boolean levelUp() {
        // Check if the experience points are greater than the experience bar
        if (this.experiencePoint >= this.experienceBar) {
            this.level += 1; // Increase the level by 1
            this.experiencePoint -= this.experienceBar; // Set the current experience points to the excess amount
            this.experienceBar = this.level * 3; // Update the experience bar for the new level
            this.maxHealth = 20 + this.level * 5; // Update the max health bar for the new level
            return true;
        }
        return false;
    }
    
    public String toString() {
        return "Level " + this.level + " " + this.getName() + " " + " HP:" + this.getHealthPoints() + "/" + this.getMaxHealth() + " EXP:" + this.getExperiencePoint() + "/" + this.getExperiencBar() + "\n";
    }
    
    public void learnMove(String moveName) {
    	this.moves.add(MoveList.getMove(moveName));
    }
    
    // abstract methods
    
    abstract void movesBasedOnLevel();
    abstract Object evolve();


}