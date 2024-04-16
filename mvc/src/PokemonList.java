import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
	 
	 public void changeName(int position, String name) {
		 Pokemon pokemon = pList.getNode(position);
		 pokemon.setName(name);
	 }
	 
	 public String toString() {
		 return pList.toString();
	 }
	 
	 public void printName() {
		 ADTList<String> names = pList.map(Pokemon::getName); // Use map to transform each pokemon into names

		 List<String> nameList = new ArrayList<>();
		 for (int i = 0; i < names.count(); i++) {
			 nameList.add(names.getNode(i));
		 }

		 for (String name : nameList) { // Print each name
			 System.out.println(name);
		 }
		 System.out.println();
	 }
	 
	 public int countAll() {
		 return pList.count();
	 }
	 
	 public void makeHeadPokemon(int position) {
		 pList.makeHeadNode(position);
	 }
	 
	 public void catchPokemon(Pokemon pokemon) {
		 if(pList.count() > 6) {
			 System.out.println("You can only carry 6 Pokemon with you, would you like to release one? (Yes/No)");
			 Scanner scanner = new Scanner(System.in);
			 String userInput = scanner.nextLine();
			 if ("yes".equalsIgnoreCase(userInput)) {
				 System.out.println("Which pokemon would you like to release? Enter the number:");
				 this.printName();
				 int pokemonIndex = scanner.nextInt() - 1;
				 if (pokemonIndex >= 0 && pokemonIndex < 6) {
					 this.removePokemon(pokemonIndex);
					 this.addPokemon(pokemon);
				 }
			 }
			 scanner.close();
		 }
		 else {
			 this.addPokemon(pokemon);
		 }
	 }
	 
	 public boolean battle(Pokemon pokemon) {
		 while(this.getTotalHealth() > 0) {
			 for(int i = 0; i < this.countAll(); i++) {
				 Pokemon currentPokemon = this.getPokemon(i);
				 while(currentPokemon.getHealthPoints() > 0) {
					 currentPokemon.attack(pokemon);
					 if(pokemon.getHealthPoints() <= 0) {
						 return true;
					 }
					 pokemon.attack(currentPokemon);
				 }
			 }
		 }
		 return false;
	 }
}
