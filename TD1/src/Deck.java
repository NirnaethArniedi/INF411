
public class Deck {
	
	private PackOfCards s;
	
	public Deck (int nbVals) {
		this.s = new PackOfCards();
		for(int i=1; i<nbVals+1; i++) {
			for(int j=0;j<4;j++) s.add(i);
		}
	}
	
	public Integer draw() {
		if(s.isEmpty()) return null;
		return s.getFirst();
	}
	
	public String toString() {
		return s.toString();
	}
	
	public int cut() {
		int c;
		c=0;
		for(int i=0;i<s.size();i++){
			double test=Math.random();
			if(test<0.5) c++;
		}
		return c;
	}
	
	public PackOfCards split() {
		int c = cut();
		PackOfCards tas2 = new PackOfCards();
		for(int i=0; i<c; i++){
			tas2.add(s.getFirst());
		}
		return tas2;
	}
	
	public void riffleWith(PackOfCards s1) {
		PackOfCards s2 = new PackOfCards();
		int a=s.size();
		int b=s1.size();
		while(a+b>0){
			double test = Math.random();
			if(s1.isEmpty() || test*(a+b)>a && !s.isEmpty()){
				s2.add(s.getFirst());
				a--;
			}
			else{
				s2.add(s1.getFirst());
				b--;
			}
		}
		s.addAll(s2);
	}
	
	public void riffleShuffle(int m) {
		for(int i=0;i<m;i++){
			PackOfCards tas2=split();
			riffleWith(tas2);
		}
	}
}
