import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PokemonListTest {

    private PokemonList pokemonList;

    @Before
    public void setUp() {
        pokemonList = new PokemonList();
        pokemonList.addPokemon(new Pikachu(5));
        pokemonList.addPokemon(new Charmander(5));
    }

    @Test
    public void testAddPokemon() {
        assertEquals(2, pokemonList.countAll());
        pokemonList.addPokemon(new Squirtle(5));
        assertEquals(3, pokemonList.countAll());
    }

    @Test
    public void testRemovePokemon() {
        pokemonList.removePokemon(0); // Remove Pikachu
        assertEquals(1, pokemonList.countAll());
        assertEquals("Pikachu", pokemonList.getPokemon(0).getName());
    }

    @Test
    public void testGetTotalHealth() {
        int totalHealth = pokemonList.getPokemon(0).getHealthPoints() + pokemonList.getPokemon(1).getHealthPoints();
        assertEquals(totalHealth, pokemonList.getTotalHealth());
    }

    @Test
    public void testPopPokemon() {
        Pokemon popped = pokemonList.popPokemon();
        assertNotNull(popped);
        assertEquals("Charmander", popped.getName());
        assertEquals(1, pokemonList.countAll());
    }

    @Test
    public void testIsEmpty() {
        assertFalse(pokemonList.isEmpty());
        pokemonList.removePokemon(0);
        pokemonList.removePokemon(0);
        assertTrue(pokemonList.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovePokemonWithInvalidPosition() {
        pokemonList.removePokemon(5); // Trying to remove non-existent position
    }
}
