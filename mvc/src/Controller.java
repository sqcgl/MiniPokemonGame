import java.util.List;

public class Controller {
	private PokemonList model;
	private PokemonView view;
	
    public Controller(PokemonList model, PokemonView view) {
        this.model = model;
        this.view = view;
    }
    
    public void pickStarter (List<Pokemon> starters) {
    	view.displayStarters(starters);
    	int choice = view.promptForStarterChoice();
    	if(choice >= 0 && choice < starters.size()) {
    		Pokemon starter = starters.get(choice);
    		model.addPokemon(starter);
    		view.displayMessage("You have chosen " + starter.getName() + "!");
    	} else {
    		view.displayInvalid();
    		pickStarter(starters);
    	}
    }
}
