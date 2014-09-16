
public class Test51 {

	public static void main(String[] args) {
		Battle b = new Battle();
		int g = b.game();
		switch (g) {
		case -1: System.out.println("Infinite game"); break;
		case 0: System.out.println("Draw game"); break;
		case 1: System.out.println("Player 1 wins"); break;
		case 2: System.out.println("Player 2 wins"); break;
		default: throw new Error ("Unexpected game outcome: "+g);
		}
	}

}
