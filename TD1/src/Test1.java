
public class Test1 {
	public static void main(String[] args) {
		Player p = new Player();
		p.take(1); p.take(2); p.take(3);
		System.out.println(p);
		p.play();
		System.out.println(p);
		Player q = new Player();
		System.out.println(p.hasNoCards()+", "+q.hasNoCards());
		PackOfCards s=new PackOfCards();
		s.add(2);
		s.add(3);
	    q.take(1);
	    q.takeAll(s);
		System.out.println(p);
		System.out.println(q);
	}
}
