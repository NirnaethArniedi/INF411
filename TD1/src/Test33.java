
public class Test33 {

	public static void main(String[] args) {
		Deck d = new Deck(13);
		PackOfCards s = d.split();
		System.out.println("First heap: " + d);
		System.out.println("Second heap: " + s);
		d.riffleWith(s);
		System.out.println("Riffle result: " + d);
	}

}
