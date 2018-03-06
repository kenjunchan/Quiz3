package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	@Test
	public void TestDeck() {
		Deck d1 = new Deck(1);
		assertEquals(52,d1.getDeckSize());
		
		Deck d6 = new Deck(6);
		assertTrue(d6.getDeckSize() == 312);
		//	TODO: Build a deck(1), make sure there are 52 cards in the deck
		//	TODO: Build a deck(6), make sure there are 312 cards in the deck 
	}

}
