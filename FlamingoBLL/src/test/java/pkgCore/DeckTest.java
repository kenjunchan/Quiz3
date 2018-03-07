package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeck() {
		Deck d1 = new Deck(1);
		assertEquals(52,d1.getDeckSize());
		
		Deck d6 = new Deck(6);
		assertEquals(d6.getDeckSize(), 312);
	}

}
