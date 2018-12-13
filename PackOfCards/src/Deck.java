import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.IntStream;

public class Deck {
	private final Stack<Card> deckCards;
	
	private Deck() {
		deckCards = initDeck();
		
	}
	private Stack<Card> initDeck() {
		final Stack<Card> deckCards = new Stack<Card>();
		for (Suite s:Suite.values())
			for (Rank r: Rank.values()) {
				deckCards.push(Card.getCard(r, s));
			}
		//Collections.shuffle(deckCards);
		Collections.sort(deckCards);
		return deckCards;
				
		
	}
	public Optional<Card> deal() {
		return deckCards.empty()?Optional.empty():Optional.of(deckCards.pop());
	}
	public static void main(String[] args) {
		Deck deck = new Deck();
		int numberOfCardsToDeal = 52;
		IntStream.range(0,numberOfCardsToDeal).
		forEach(value->System.out.println(deck.deal()));
	}

}
