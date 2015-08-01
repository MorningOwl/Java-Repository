package util;

import java.util.Collections;
import java.util.Stack;

public class Deck {
	private final Suit[] suits = { Suit.CLOVER, Suit.DIAMOND, Suit.HEART,
			Suit.SPADE };
	private final Rank[] ranks = { Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR,
			Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN,
			Rank.JACK, Rank.QUEEN, Rank.KING };
	private Stack<Card> deck;

	public Deck() {
		deck = new Stack<Card>();
		int suitCount = 0;
		int rankCount = 0;
		int size = suits.length * ranks.length;
		for (int i = 0; i < size; i++) {
			if (suitCount >= suits.length) {
				rankCount = 0;
			}
			if (rankCount >= ranks.length) {
				rankCount = 0;
				suitCount++;
			}
			rankCount++;
			deck.push(new Card(suits[suitCount], ranks[rankCount-1], rankCount + 1));
		}
		deck.push(new Card(Suit.JOKER, Rank.JOKER, 0));
		deck.push(new Card(Suit.JOKER, Rank.JOKER, 0));
	}
	
	public void shuffle(){
		Collections.shuffle(deck);
	}
	
	public int getSize(){
		return deck.size();
	}
	
	public Card draw(){
		return deck.pop();
	}
	
	public String getAbbrString(){
		String str = "";
		for (Card c : deck) {
			str += c.getAbbr() + "\n";
		}
		return str;
	}

	public String toString() {
		String str = "";
		for (Card c : deck) {
			str += c + "\n";
		}
		return str;
	}
}
