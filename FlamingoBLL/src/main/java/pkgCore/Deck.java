package pkgCore;
import pkgEnum.*;

import java.util.*;

public class Deck {

	ArrayList<Card> cards = new ArrayList();

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
	
	public Card draw()
	{		
		return cards.remove(0);
	}
	public int getDeckSize()
	{
		return cards.size();
	}
}
