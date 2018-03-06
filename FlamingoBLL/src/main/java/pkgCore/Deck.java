package pkgCore;
import pkgEnum.*;

import java.util.*;

public class Deck {

	ArrayList<Card> cards = new ArrayList();

	public Deck(int numberOfDecks)
	{
		for(int i = 0; i < numberOfDecks; i++)
		{
			this.buildDeck(eSuit.DIAMONDS);
			this.buildDeck(eSuit.CLUBS);
			this.buildDeck(eSuit.HEARTS);
			this.buildDeck(eSuit.SPADES);
		}
	}
	
	public void buildDeck(eSuit eSuit)
	{
		Card c;
		//cards.add(c = new Card(eRank.ONE,eSuit));
		cards.add(c = new Card(eSuit, eRank.TWO));
		cards.add(c = new Card(eSuit, eRank.THREE));
		cards.add(c = new Card(eSuit, eRank.FOUR));
		cards.add(c = new Card(eSuit, eRank.FIVE));
		cards.add(c = new Card(eSuit, eRank.SIX));
		cards.add(c = new Card(eSuit, eRank.SEVEN));
		cards.add(c = new Card(eSuit, eRank.EIGHT));
		cards.add(c = new Card(eSuit, eRank.NINE));
		cards.add(c = new Card(eSuit, eRank.TEN));
		cards.add(c = new Card(eSuit, eRank.JACK));
		cards.add(c = new Card(eSuit, eRank.QUEEN));
		cards.add(c = new Card(eSuit, eRank.KING));
		cards.add(c = new Card(eSuit, eRank.ACE));
	}
	public Card draw()
	{
		int cardPosition = (int)(Math.random()*cards.size());
		Card returnCard = cards.get(cardPosition);
		cards.remove(cardPosition);
		return returnCard;
	}
	public int getDeckSize()
	{
		return cards.size();
	}
}
