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
		
		iScore[0] = 0;
		iScore[1] = 0;
		//Card testCard = new Card(eSuit.DIAMONDS, eRank.QUEEN);
		//System.out.println(testCard.geteRank().getiRankNbr());
		
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
			
			//	TODO: Determine the score.  
			//			Cards:
			//			2-3-4 - score = 11
			//			5-J-Q - score = 25
			//			5-6-7-2 - score = 20
			//			J-Q	- score = 20
			//			8-A = score = 9 or 19
			//			4-A = score = 5 or 15
		}
		iScore[1] = tempxScore;
		System.out.println("SCORE 1 " + tempyScore + " " + iScore[0]);
		System.out.println("SCORE 2 " + tempxScore + " " + iScore[1]);
		
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
