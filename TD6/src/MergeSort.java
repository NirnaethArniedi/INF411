
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
		int k = 0;
		int l = t.length();
		while(l>(1 << k)){
			int i = 0;
			int dk = 1<<k;
			//
			while( l-i>0 ){
				if(l-i >= 2*dk){
					merge(t,i,i+dk,i+2*dk);
					i=i+2*dk;
				}
				else if(l-i>dk && l-i <2*dk){
					merge(t,i,i+dk,l);
					i=l;
				}
				else break;
			}
			k++;
		}
		// à compléter
	}

	static int findRun(Tableau t, int lo) {
		int i =lo,j=lo+1;
		while(j<t.length()){
			if(t.compare(i++, j)>0)
				break;
			j++;
		}
		return j;
	}

	static void naturalMergeSort(Tableau t) {
		int i = 0;
		while(findRun(t,0)<t.length()){
			i=0;
			while(i<t.length()){
				int mi= findRun(t,i);
				int hi=mi;
				if(mi<t.length()){
					hi = findRun(t,mi);
					merge(t,i,mi,hi);
					i=hi;
				}
				else break;
			}
		}
	}
}
