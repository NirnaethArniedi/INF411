
public class MergeSort {

	static void merge(Tableau t, int lo, int mi, int hi) {
		Tableau aux=new Tableau(t,lo,mi,hi);// duplique les élements t[lo,hi[ dans un nouveau tableau aux
		int i = 0;
		int j = mi-lo;
		for(int k = lo ; k < hi ; k++)
			if( i < mi-lo && (j == hi-lo || aux.compare(i, j)<=0))
				t.change(k,aux.get(i++));
			else
				t.change(k, aux.get(j++));
		return;
		// à compléter
	}

	static void topDownMergeSortRec(Tableau t, int lo, int hi) {
		if(hi-lo<2)
			return;
		else{
			int mi = lo+(hi-lo)/2;
			topDownMergeSortRec(t,lo,mi);
			topDownMergeSortRec(t,mi,hi);
			merge(t,lo,mi,hi);
		}
		return;
		// à compléter
	}

	static void topDownMergeSort(Tableau t) {
		topDownMergeSortRec(t,0,t.length());
	}

	static void bottomUpMergeSort(Tableau t){
		// à compléter
	}

	static int findRun(Tableau t, int lo) {
		return -1; // à supprimer
		// à compléter
	}

	static void naturalMergeSort(Tableau t) {
		// à compléter
	}
}
