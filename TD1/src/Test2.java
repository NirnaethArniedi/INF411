
public class Test2 {
	public static void main(String[] args){
    	Deck d = new Deck(13);
    	System.out.println(d);
    	System.out.print("Drawn Integers: ");
    	for (int i=0; i<=52; i++)
    		System.out.print(d.draw() + " ");
    	System.out.println();
    	System.out.println(d);
    } 
}
