

public class BattleDriver {
    public static void main(String[] args) {
    	PokemonList testList;
        Wartortle pokemon1;
        Charizard pokemon2;
        Venusaur pokemon3;
        
        testList = new PokemonList();
        pokemon1 = new Wartortle("Wartortle", 10);
        pokemon2 = new Charizard("Charizard", 10);
        pokemon3 = new Venusaur("Venusaur", 40);
        testList.addPokemon(pokemon1);
        testList.addPokemon(pokemon2);
        
        System.out.println(testList.battle(pokemon3));
        //pokemons.add(new Charmander("Charmy", 7)); // Level 7 to ensure it has Ember
        //pokemons.add(new Charmeleon("Leo", 18)); // Level 18, assuming it has some moves
        //pokemons.add(new Charizard("Zardy", 40)); // Level 40 Charizard
        //pokemons.add(new Squirtle("Squirty", 8)); // Level 8 Squirtle
        //pokemons.add(new Wartortle("Torty", 20)); // Level 20 Wartortle
        //pokemons.add(new Blastoise("Blasty", 40)); // Level 40 Blastoise

        /*
        System.out.println(pokemon1.getName() + " battles " + pokemon2.getName());
        pokemon1.attack(pokemon2);
        System.out.println(pokemon2.getName() + ":" + pokemon2.getHealthPoints());
        pokemon2.attack(pokemon1);
        System.out.println(pokemon1.getName() + ":" + pokemon1.getHealthPoints());
        */
        
    }
}
