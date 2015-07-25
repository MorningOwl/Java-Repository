import util.Deck;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.print(deck.getAbbrString());

	}

}
