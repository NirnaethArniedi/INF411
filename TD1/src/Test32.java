
public class Test32 {
    public static void main(String[] args) {
    	for (int i=0; i<5; i++) {
    		Deck d = new Deck(13);
    		PackOfCards s = d.split();
    		System.out.println("First heap: " + d);
    		System.out.println("Second heap: " + s);
    		System.out.println();
    	}
    }
}
