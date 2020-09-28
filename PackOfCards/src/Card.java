import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class Card implements Comparable<Card> {	
	private final Rank rank;
	private final Suite suite;
	private final static Map<String,Card>  CARD_CACHE = initCache();
	public Card(Rank rank, Suite suite) {
		super();
		this.rank = rank;
		this.suite = suite;
	}
	public Rank getRank() {
		return rank;
	}
	public Suite getSuite() {
		return suite;
	}
	public String toString() {
		return String.format("%s of %s", rank,suite);
	}
	private static String cardKey(final Rank rank,final Suite suite) {
		return rank + " of "+suite;
		
	}
	private static Map<String,Card> initCache() {
		System.out.println("CARD CARD ===InitCache method alled");
		final Map<String,Card> cache = new HashMap<>();
		for (final Suite s:Suite.values()) {
			for (final Rank r:Rank.values())
				cache.put(cardKey(r, s), new Card(r,s));
		}
		return Collections.unmodifiableMap(cache);
	}
	
	public static  Card getCard(Rank r,Suite s) {
		Card card = CARD_CACHE.get(cardKey(r, s));
		if (card != null)
			return card;
		throw new RuntimeException("Card Not available");
	}
	
	@Override
	public int compareTo(Card o) {
		//final int rankComparision = Integer.compare(this.getRank().getRankValue(), o.getRank().getRankValue());
		//if (rankComparision != 0)
		//	return rankComparision;
		//return Integer.compare(this.getSuite().getSuiteValue(), o.getSuite().getSuiteValue());
		
		////
		
		int suiteComparision = Integer.compare(this.getSuite().getSuiteValue(), o.getSuite().getSuiteValue());
		if (suiteComparision != 0)
			return suiteComparision;
		return Integer.compare(this.getRank().getRankValue(), o.getRank().getRankValue());
		
			
		
	}
	

}
