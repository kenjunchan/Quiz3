package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class Hand {

	private int iScore;
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Hand()
	{
		
	}
	
	public int[] ScoreHand()
	{
		int [] iScore = new int[2];
		
		iScore[0] = 5;
		iScore[1] = 10;
		
		Collections.sort(cards);
		
		int tempyScore = 0;
		for (Card c: cards)
		{
			if(c.geteRank() == eRank.ACE)
			{
					tempyScore += 1;
			}
			else if(c.geteRank() == eRank.JACK || c.geteRank() == eRank.QUEEN || c.geteRank() == eRank.KING)
			{
				tempyScore += 10;
			}
			else
			{
				tempyScore += c.geteRank().getiRankNbr();
			}
		}
		
		iScore[0] = tempyScore;
		int tempxScore = 0;
		for (Card c: cards)
		{
			if(c.geteRank() == eRank.ACE)
			{
				if((tempxScore + 11) > 21)
				{
					tempxScore += 1;
				}
				else
				{
					tempxScore += 11;
				}
			}
			else if(c.geteRank() == eRank.JACK || c.geteRank() == eRank.QUEEN || c.geteRank() == eRank.KING)
			{
				tempxScore += 10;
			}
			else
			{
				tempxScore += c.geteRank().getiRankNbr();
			}
			
		}
		iScore[1] = tempxScore;
		return iScore;
	}
	
	public void Draw(Deck d)
	{
		this.AddCard(d.draw());
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
