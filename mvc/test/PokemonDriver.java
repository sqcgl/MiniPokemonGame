import java.util.Arrays;
import java.util.List;

public class PokemonDriver {
    public static void main(String[] args) {
    	PokemonList myPokemonList = new PokemonList(); // Model
    	PokemonView view = new PokemonView(); // View
    	Controller controller = new Controller(myPokemonList, view); //Controller
    	
    	// Create a list for starters
    	List<Pokemon> starters = Arrays.asList(
    			new Charmander("Charmander", 5),
    			new Bulbasaur("Bulbasaur", 5),
    			new Squirtle("Squirtle", 5)
    			);
    	controller.pickStarter(starters);
    	System.out.print(myPokemonList.toString());
    }
}
