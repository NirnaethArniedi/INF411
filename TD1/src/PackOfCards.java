import java.util.LinkedList;


public class PackOfCards {
	
	private LinkedList<Integer> cl;
	
	public PackOfCards() {
		cl=new LinkedList<Integer>();
	}
	
	public PackOfCards(PackOfCards s){
		cl=new LinkedList<Integer>();
		for(Integer i:s.cl)
			cl.add(i);
	}

	boolean isEmpty(){
		return cl.isEmpty();
	}
	
	int size(){
		return cl.size();
	}
	
	void add(int c){
		cl.add(c);
	}
	
	void addAll(PackOfCards s){
		cl.addAll(s.cl);
	}
	
	int getFirst(){
		return cl.poll();
	}
	
	public String toString(){
		return size()+" cards: "+cl;
	}
	
}
