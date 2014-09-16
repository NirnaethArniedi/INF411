
public class Test44 {

	public static void main(String[] args) {
		int n = 100000;
		Battle b = new Battle();
		switch (b.game(n)) {
		case 0: System.out.println("Draw game"); break;
		case 1: System.out.println("Player 1 wins"); break;
		case 2: System.out.println("Player 2 wins"); break;
		}

	}

}
