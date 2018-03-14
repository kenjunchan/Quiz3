package pkgCore;
import pkgEnum.*;
import Exceptions.*;
import java.util.*;

public class Deck {

	ArrayList<Card> cards = new ArrayList<Card>();

	public Deck(int numberOfDecks)
	{
		for(int i = 0; i < numberOfDecks ; i++)
		{	
			for(eSuit eSuit : eSuit.values())
			{  
				for(eRank eRank : eRank.values())
				{
					cards.add(new Card(eSuit, eRank));
				}
			}
		}
		
		Collections.shuffle(cards);
	}
	public Deck() throws DeckException
	{
		this(1);
	}
	public Card draw() throws DeckException
	{		
		if(cards.size() == 0)
		{
			throw new DeckException(this);
		}
		return cards.remove(0);
	}
	public int getRemaining(Object eNum)
	{
		int count = 0;
		for(Card c : cards)
		{
			if(eNum instanceof eSuit && c.geteSuit() == eNum)
				count += 1;
			else if(eNum instanceof eRank && c.geteRank() == eNum)
				count += 1;	
		}
		return count;
	}
	public int getDeckSize()
	{
		return cards.size();
	}
}
