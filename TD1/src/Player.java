
public class Player {
	private PackOfCards cards;
	
	public Player() {
		PackOfCards c = new PackOfCards();
		this.cards = c;
	}
	public Player(Player p) {
		this.cards =new PackOfCards(p.cards);
	}
	 public boolean hasNoCards() {
		 return cards.isEmpty();
	 }
	 
	 public int nbCards() {
		 return cards.size();
	 }
	 
	 public void take(int c) {
		 cards.add(c);
	 }

	 public void takeAll(PackOfCards s) {
		 cards.addAll(s);
	 }

	 public int play() {
		 return cards.getFirst();
	 }
	 
	 public String toString() {
		 return cards.toString();
	 }
}

	
