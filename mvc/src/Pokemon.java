import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    
    public Pokemon(String name, Type type, int level, List<Move> moves) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.maxHealth = 20 + this.level * 5; // 20 base health + level * 5
        this.healthPoints = this.maxHealth; // default to it's max health at the beginning
        this.experiencePoint = 0; // default to 0 at the beginning
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
        this.healthPoints = healthPoints;
    }

    public void setLevel(int level) throws IllegalArgumentException {
    	if (level < 1) {
            throw new IllegalArgumentException("Level must be at least 1");
        } else {
            this.level = level;
        }
    }

    public void setExperiencePoint(int experiencePoint) { 
        this.experiencePoint = experiencePoint;
    }
    
    public void setMoves(List<Move> moves) throws IllegalArgumentException {
    	if(moves.size() > 4) {
    		throw new IllegalArgumentException("Pokemon can only haev 4 moves");
    	}
    	else {
    		this.moves = moves;
    	}
    }
    
   // Method  
    /*
    public void attack(Pokemon otherPokemon) {
        if (this.moves.isEmpty()) {
            System.out.println(this.name + " has no moves to use!");
            return;
        }

        // Select a random move
        Move selectedMove = this.moves.get(new Random().nextInt(this.moves.size()));

        // Calculate damage
        int damage = selectedMove.getPower();
        if (checkCounter(selectedMove, otherPokemon)) {
            damage *= 2; // Double the damage if it's a counter
        }

        // Apply damage
        otherPokemon.setHealthPoints(otherPokemon.getHealthPoints() - damage);
        System.out.println(this.name + " uses " + selectedMove.getName() + " on " + otherPokemon.getName() + " dealing " + damage + " damage!");

        if (otherPokemon.getHealthPoints() <= 0) {
            System.out.println(otherPokemon.getName() + " fainted!");
            otherPokemon.fainted = true;
        }
    }
    */
    
    public int attack(Pokemon opponent) {
        if (!moves.isEmpty()) {
            Move selectedMove = moves.get(new Random().nextInt(moves.size()));
            int damage = selectedMove.getPower();
            if (checkCounter(selectedMove, opponent)) {
                damage *= 2; // Double the damage if it's a counter
            }
            opponent.setHealthPoints(opponent.getHealthPoints() - damage);
            return damage; // return the damage dealt
        }
        return 0; // no damage dealt if no moves
    }

    private boolean checkCounter(Move move, Pokemon otherPokemon) {
        // This method checks if the move type counters the other Pokemon's type
        // Assuming Type class has a method isCounter() which checks counter relationship
        return move.getType().isCounter(otherPokemon.getType());
    }
    
    public void rest() {
        this.healthPoints = this.maxHealth;
        System.out.println(this.name + " is resting.");
        System.out.println(this.name + " Currently have " + this.healthPoints + " and " + this.experiencePoint + "/" + this.experienceBar + " experience.");
    }
    
    public void gainExperiencePoint(Pokemon otherPokemon) {
    	this.experiencePoint += otherPokemon.getLevel();
    }
    
    public void levelUp() {
        // Check if the experience points are greater than the experience bar
        if (this.experiencePoint >= this.experienceBar) {
            this.level += 1; // Increase the level by 1
            this.experiencePoint -= this.experienceBar; // Set the current experience points to the excess amount
            this.experienceBar = this.level * 3; // Update the experience bar for the new level
            this.maxHealth = 20 + this.level * 5; // Update the max health bar for the new level
            System.out.println(this.getClass() + " is now level " + this.level + "!");
        }
    }
    
    public String toString() {
        return "Level " + this.level + " " + this.getClass() + " ";
    }
    
    public void learnMove(String moveName) {
        if (this.moves.size() < 4) {
            // Directly add the move if less than 4
            this.moves.add(MoveList.getMove(moveName));
        } else {
            // Offer choice to replace a move
            replaceMove(moveName);
        }
    }

    private void replaceMove(String newMoveName) {
        System.out.println(this.name + " is trying to learn " + newMoveName + ", but it already knows 4 moves.");
        System.out.println("Would you like to replace an existing move? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        if ("yes".equalsIgnoreCase(userInput)) {
            System.out.println("Which move would you like to forget? Enter the number:");
            for (int i = 0; i < this.moves.size(); i++) {
                System.out.println((i + 1) + ": " + this.moves.get(i).getName());
            }

            int moveIndex = scanner.nextInt() - 1;
            if (moveIndex >= 0 && moveIndex < this.moves.size()) {
                System.out.println(this.name + " forgot " + this.moves.get(moveIndex).getName() + " and learned " + newMoveName + ".");
                this.moves.set(moveIndex, MoveList.getMove(newMoveName));
            } else {
                System.out.println("Invalid move number. No move was forgotten.");
            }
        } else {
            System.out.println(this.name + " did not learn " + newMoveName + ".");
        }
        scanner.close();
    }
    
    // abstract methods
    
    abstract void movesBasedOnLevel();
    abstract Object evolve();


}