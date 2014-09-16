
public class Pair {
		int fst, snd;
		
		Pair(int fst, int snd) {
			this.fst = fst ;
			this.snd = snd ;
		}
		@Override
		public int hashCode() {
			return this.fst+this.snd;
		}
		
		public boolean equals(Object o){
			Pair p = (Pair)o;
			return this.fst==p.fst && this.snd==p.snd;
		}
}

