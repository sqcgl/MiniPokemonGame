import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CharmanderTest {

	private Charmander charmander;
	
	@Before
	public void setUp() {
		charmander = new Charmander("Jack", 5);
	}

	@Test
	public void testGetName() {
		assertEquals("Jack", charmander.getName());
	}
	
	@Test
	public void testGetType() {
		assertEquals(Type.FIRE, charmander.getType());
	}
	
	@Test
    public void testGetLevel() {
        assertEquals(5, charmander.getLevel());
    }

    @Test
    public void testMovesAtLevel5() {
        List<Move> moves = charmander.getMoves();
        assertTrue(moves.contains(MoveList.getMove("Scratch")));
        assertFalse(moves.contains(MoveList.getMove("Ember"))); // Ember is learned at level 7
    }

    @Test
    public void testLearnMoveByLevel() {
        Charmander higherLevelCharmander = new Charmander("Jack", 7);
        List<Move> moves = higherLevelCharmander.getMoves();
        assertTrue(moves.contains(MoveList.getMove("Ember")));
    }
    
    @Test
    public void testEvolve() {
        Charmander charmanderBeforeEvolve = new Charmander("Jack", 7);
        Object evolvedForm = charmanderBeforeEvolve.evolve();
        
        // Check if evolvedForm is still Charmander at level 7
        assertTrue(evolvedForm instanceof Charmander);

        Charmander charmanderToEvolve = new Charmander("Jack", 8);
        evolvedForm = charmanderToEvolve.evolve();

        // Check if evolvedForm is Charizard at level 12
        assertTrue(evolvedForm instanceof Charmeleon);
        assertEquals("Jack", ((Charmeleon)evolvedForm).getName());
        assertEquals(8, ((Charmeleon)evolvedForm).getLevel());
        
        Charmeleon charmeleonToEvolve = new Charmeleon("Jack", 12);
        evolvedForm = charmeleonToEvolve.evolve();

        // Check if evolvedForm is Charizard at level 12
        assertTrue(evolvedForm instanceof Charizard);
        assertEquals("Jack", ((Charizard)evolvedForm).getName());
        assertEquals(12, ((Charizard)evolvedForm).getLevel());
    }

}
