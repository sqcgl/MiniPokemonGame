import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Gameplay {
    private static Scanner scanner = new Scanner(System.in);

    public int options(PokemonList myPokemonList) {
        System.out.println("Your Pokemon Team:");
        System.out.println(myPokemonList.toString());
        System.out.println("Would you like to: ");
        System.out.print("1. Fight Wild Pokemon \n"
                + "2. Fight Elite Pokemon \n"
                + "3. Change Head Pokemon\n"
                + "4. Exit\n");
        int userInput;
        userInput = scanner.nextInt();
        return userInput;
    }
    
    public void attack(Pokemon attacker, Pokemon defender) {
        if (attacker.getMoves().isEmpty()) {
            System.out.println(attacker.name + " has no moves to use!");
            return;
        }

        // Select a random move
        Move selectedMove = attacker.getMoves().get(new Random().nextInt(attacker.moves.size()));

        // Calculate damage
        int damage = selectedMove.getPower();
        if (checkCounter(selectedMove, defender)) {
            damage *= 2; // Double the damage if it's a counter
        }

        // Apply damage
        defender.setHealthPoints(defender.getHealthPoints() - damage);
        System.out.println(attacker.getName() + " uses " + selectedMove.getName() + " on " + defender.getName() + " dealing " + damage + " damage!");
        System.out.println(defender.getName() + " have " + defender.getHealthPoints() + "/" + defender.getMaxHealth() + " health points left");

        if (defender.getHealthPoints() <= 0) {
        	defender.fainted = true;
        }
    }
    
    private boolean checkCounter(Move move, Pokemon otherPokemon) {
        // This method checks if the move type counters the other Pokemon's type
        // Assuming Type class has a method isCounter() which checks counter relationship
        return move.getType().isCounter(otherPokemon.getType());
    }
    
    public boolean battle(PokemonList myPokemonList, Pokemon opponent) {
        for (int i = 0; i < myPokemonList.countAll(); i++) {
            Pokemon currentPokemon = myPokemonList.getPokemon(i);
            if (currentPokemon.getHealthPoints() <= 0) continue;  // Skip if already fainted

            System.out.println(currentPokemon.getName() + " I choose you!");

            while (currentPokemon.getHealthPoints() > 0 && opponent.getHealthPoints() > 0) {
                attack(currentPokemon, opponent);
                if (opponent.getHealthPoints() <= 0) {
                    System.out.println(opponent.getName() + " has fainted!");
                    afterMath(myPokemonList, currentPokemon, opponent, i);
                    return true;  // Opponent fainted, you win
                }
                attack(opponent, currentPokemon);
                if (currentPokemon.getHealthPoints() <= 0) {
                    System.out.println(currentPokemon.getName() + " has fainted!");
                    currentPokemon.setFainted(true);  // Mark current Pokemon as fainted
                    break;  // Exit the loop as current Pokemon can no longer fight
                }
            }
        }

        // Check if all Pokemon have fainted
        if (myPokemonList.allFainted()) {
            return false;  // Lost the battle
        }
        return true;  // Won the battle or still have fighting Pokemon
    }

    public void afterMath(PokemonList myPokemonList, Pokemon pokemon, Pokemon faintedPokemon, int currentIndex) {
        pokemon.gainExperiencePoint(faintedPokemon);
        boolean newLevel = pokemon.levelUp();
        if (newLevel) {
        	System.out.println(pokemon.getName() + " is now level " + pokemon.getLevel() + "!");
        }
        Pokemon evolvedPokemon = (Pokemon) pokemon.evolve();
        /*
        if(pokemon.getName() == "Slowpoke" && faintedPokemon.getName() == "Shellder") { // Extension Special Evolve
        	evolvedPokemon = new Slowbro(pokemon.getLevel(), pokemon.getMoves(), pokemon.getExperiencePoint());
        }
        */
        if(evolvedPokemon != null) {
            System.out.println(pokemon.getName() + " has evolved to " + evolvedPokemon.getName() + "!");
            myPokemonList.removePokemon(currentIndex); // Remove the current Pokemon
            myPokemonList.addPokemon(evolvedPokemon); // Might have to adjust the head later on the option page
        }
    }

    public boolean battleSimulation(PokemonList myPokemonList, Pokemon opponent) {
        boolean outcome = battle(myPokemonList, opponent);
        if(outcome) {
            System.out.println("You won the battle");
            if(decideToCatch(opponent)) {
                catchPokemon(opponent, myPokemonList);
            }
            myPokemonList.restAll();
            return true;
        } else {
            System.out.println("You lose the battle");
            return false;
        }
    }

    public boolean battleElitePokemon(PokemonList myPokemonList, PokemonList elitePokemonList) {
        Pokemon elitePokemon = elitePokemonList.popPokemon();
        System.out.println("Encountered a elite " + elitePokemon.getName() + " at level " + elitePokemon.getLevel());
        return battleSimulation(myPokemonList, elitePokemon);
    }

    public boolean battleWildPokemon(PokemonList myPokemonList, List<Class<? extends Pokemon>> wildPokemonClasses, PokemonList elitePokemons) {
        Random rand = new Random();
        Class<? extends Pokemon> wildClass = wildPokemonClasses.get(rand.nextInt(wildPokemonClasses.size()));
        int randLevel = rand.nextInt(myPokemonList.getPokemon(0).getLevel() - 4 , myPokemonList.getPokemon(0).getLevel());
        if (randLevel < 1) {randLevel = 1;}
        Pokemon wildPokemon = createPokemonInstance(wildClass, randLevel);
        System.out.println("Encountered a wild " + wildPokemon.getName() + " at level " + wildPokemon.getLevel());
        return battleSimulation(myPokemonList, wildPokemon);
    }

    public Pokemon createPokemonInstance(Class<? extends Pokemon> clazz, int level) {
        try {
            Constructor<? extends Pokemon> constructor = clazz.getConstructor(int.class);
            return constructor.newInstance(level);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean decideToCatch(Pokemon pokemon) {
        System.out.println("Press 1 if you would like to catch " + pokemon.getName() + " any other key if you don't");
        int userInput;
        userInput = scanner.nextInt();
        return userInput == 1;
    }

    public void catchPokemon(Pokemon pokemon, PokemonList pokemonList) {
        if(pokemonList.countAll() > 5) {
            System.out.println("You can only carry 6 Pokemon with you, would you like to release one?\n"
                    + "Press 1 if you would like to any other key if you don't.");
            int userInput;
            userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("Which pokemon would you like to release? Enter the number:");
                printList(pokemonList.convertName());
                int pokemonIndex = scanner.nextInt() - 1;
                if (pokemonIndex >= 0 && pokemonIndex < 6) {
                    pokemonList.removePokemon(pokemonIndex);
                    catchPokemon(pokemon, pokemonList);
                } else {
                    catchPokemon(pokemon, pokemonList);
                }
            }
        }
        else {
            pokemonList.addPokemon(pokemon);
            pokemonList.makeHeadPokemon(1);
        }
    }

    public int changeHeadPokemon(PokemonList myPokemonList) {
        System.out.println("Which pokemon would you like to make it head Pokemon?");
        printList(myPokemonList.convertName());
        int pokemonIndex = scanner.nextInt() - 1;
        if (pokemonIndex >= 0 && pokemonIndex < myPokemonList.countAll()) {
            return pokemonIndex;
        } else {
            return changeHeadPokemon(myPokemonList);
        }
    }
    
    public void printList(List<String> nameList) {
    	for (int i = 0; i < nameList.size(); i++) { // Print each name with an index starting at 1
    		System.out.println((i + 1) + ". " + nameList.get(i));
    	}
    	System.out.println();
    }
}
