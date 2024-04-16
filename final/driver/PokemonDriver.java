import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PokemonDriver {
    private static Scanner scanner = new Scanner(System.in);
    private static Gameplay gameplay = new Gameplay();

    public static void main(String[] args) {
        // Create a PokemonList to store your Pokemon
        PokemonList myPokemonList = new PokemonList();
        
        // Create a List to store wild pokemon class
        List<Class<? extends Pokemon>> wildPokemonClasses = new ArrayList<>();
        wildPokemonClasses.add(Diglett.class);
        wildPokemonClasses.add(Pikachu.class);
        wildPokemonClasses.add(Slowpoke.class);
        wildPokemonClasses.add(Shellder.class);
        
        // Create elite pokemon class
        PokemonList elitePokemons = new PokemonList();
        elitePokemons.addPokemon(new Charizard(13));
        elitePokemons.addPokemon(new Blastoise(12));
        elitePokemons.addPokemon(new Venusaur(11));
        elitePokemons.addPokemon(new Dugtrio(10));
        elitePokemons.addPokemon(new Shellder(7));
        
        // Create a list for starters
        List<Pokemon> starters = Arrays.asList(
            new Charmander(7),
            new Bulbasaur(7),
            new Squirtle(7)
        );

        // Choose a starter
        System.out.println("Choose your starter Pokemon:");
        for (int i = 0; i < starters.size(); i++) {
            Pokemon p = starters.get(i);
            System.out.println((i + 1) + ". " + p.getName());
        }
        int userInput;
        do {
            System.out.println("Enter the number of your choice:");
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a number! Please enter a valid number:");
                scanner.next();
            }
            userInput = scanner.nextInt();
            if (userInput < 1 || userInput >= starters.size() + 1) {
                System.out.println("Invalid choice, please pick again!");
            }
        } while (userInput < 1 || userInput >= starters.size() + 1);

        Pokemon starter = starters.get(userInput - 1);
        myPokemonList.addPokemon(starter);
        System.out.println("You have chosen " + starter.getName() + "!");

        int option;
        do {
            option = gameplay.options(myPokemonList);
            switch (option) {
                case 1:
                    if (myPokemonList.getTotalHealth() > 0) {
                        gameplay.battleWildPokemon(myPokemonList, wildPokemonClasses, elitePokemons);
                    } else {
                        option = 4;  // Set option to 4 to exit the loop after displaying status
                    }
                    break;
                case 2:
                    if (myPokemonList.getTotalHealth() > 0) {
                        if (!elitePokemons.isEmpty()) {
                            gameplay.battleElitePokemon(myPokemonList, elitePokemons);
                        } else {
                            System.out.println("You have defeated all elite Pokemons!");
                        }
                    } else {
                        option = 4;  // Set option to 4 to exit the loop after displaying status
                    }
                    break;
                case 3:
                    int index = gameplay.changeHeadPokemon(myPokemonList);
                    myPokemonList.makeHeadPokemon(index);
                    break;
                case 4:
                    System.out.println("Exiting game...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
            // Additional check outside of the switch to handle cases where health might become zero during battles
            if (myPokemonList.getTotalHealth() <= 0) {
                System.out.println("All your Pokemon have fainted! Exiting game...");
                break;
            }
        } while (option != 4);

        scanner.close();
    }
}
