package pkgCore;

import java.util.ArrayList;
import java.util.Collections;

import Exceptions.DeckException;
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
		
		Collections.sort(cards);
		for (Card c: cards)
		{
			if(c.geteRank() == eRank.ACE)
			{
					iScore[0] += 1;
					iScore[1] += 1;
					if(iScore[1] + 10 <= 21)
					{
						iScore[1] += 10;
					}
			}
			else if(c.geteRank() == eRank.JACK || c.geteRank() == eRank.QUEEN || c.geteRank() == eRank.KING)
			{
				iScore[0] += 10;
				iScore[1] += 10;
			}
			else
			{
				iScore[0] += c.geteRank().getiRankNbr();
				iScore[1] += c.geteRank().getiRankNbr();
			}
		}
		SetHandScore(iScore);
		return iScore;
	}
	public boolean bCanDealerHit()
	{
		for(int iScore : ScoreHand())
		{
			if(iScore >= 17)
			{
				return false;
			}
		}
		return true;
	}
	public boolean bCanPlayerDraw()
	{
		for(int iScore : ScoreHand())
		{
			if(iScore < 21)
				return true;
		}
		return false;
	}
	public boolean isBlackjack()
	{
		int[] iScores = ScoreHand();
		if(cards.size() == 2 && iScores[1] == 21)
		{
			return true;
		}
		return false;
	}
	public void SetHandScore(int[] Scores)
	{
		this.iScore = Scores[0];
		if(Scores[1] <= 21)
		{
			this.iScore = Scores[1];
		}
	}
	public void Draw(Deck d) throws DeckException
	{
		this.AddCard(d.draw());
	}
	
	private void AddCard(Card c)
	{
		cards.add(c);
	}
	
}
