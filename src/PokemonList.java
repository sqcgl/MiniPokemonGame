import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PokemonList {
	
	private ADTList<Pokemon> pList;
	
	public PokemonList() {
		pList = new ADTList<Pokemon>();
	}
	
	public void addPokemon(Pokemon pokemon) { // Add a pokemon
		pList.addNode(pokemon);
	}
	
	public void removePokemon(int position) { // Remove a pokemon 
		pList.removeNode(position);
	}
	
	// Getters
	public Pokemon getPokemon(int position) { // Get a pokemon
		return pList.getNode(position);
	}
	
    public int getTotalHealth() {
        return pList.fold(0, (totalHealth, pokemon) -> totalHealth + pokemon.getHealthPoints());
    }
	
	 private PokemonList filterTasks(Predicate<Pokemon> predicate) { // Take a predicate and return a list base on it
		 PokemonList filteredList = new PokemonList();
		 for (int i = 0; i < pList.count(); i++) { // Add to list
			 Pokemon pokemon = pList.getNode(i);
			 if (predicate.test(pokemon)) {
				 filteredList.addPokemon(pokemon);
				 }
			 }
		 return filteredList;
	 }
	 
	 public PokemonList getFullHealthList() { // Get a list of completed Tasks
		 return filterTasks(p -> p.getHealthPoints() == p.getMaxHealth());
	 }
	 
	 public PokemonList getTypeList(Type type) {
		 return filterTasks(p -> p.getType() == type);
	 }
	 
	 public String toString() {
		 return pList.toString();
	 }
	 
	 public List<String> convertName() {
		 ADTList<String> names = pList.map(Pokemon::getName); // Use map to transform each pokemon into names

		 List<String> nameList = new ArrayList<>();
		 for (int i = 0; i < names.count(); i++) {
			 nameList.add(names.getNode(i));
		 }
		return nameList;
	 }
	 
	 public int countAll() {
		 return pList.count();
	 }
	 
	 public void makeHeadPokemon(int position) {
		 pList.makeHeadNode(position);
	 }
	 
	 public Pokemon popPokemon() { // For poping elite Pokemon
		 return pList.pop();
	 }
	 
	 public boolean allFainted() {
		 for (int i = 0; i < this.countAll(); i++) {
			 if (!this.getPokemon(i).getFainted()) {
				 return false;  // Found a Pokemon that has not fainted
			 }
		 }
		 return true;  // All Pokemon have fainted
	 }
	 
	 
	 public void restAll() {
		 for (int i = 0; i < this.countAll(); i++) {
			 Pokemon pokemon = this.getPokemon(i);
			 pokemon.rest();
		 }
	}

	public boolean isEmpty() {
		return pList.isEmpty();
	}

}
