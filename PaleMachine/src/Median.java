import java.util.Arrays;
import java.util.LinkedList;


public class Median {

	// calcule la k-ie`me plus petite valeur contenue dans le tableau t
	public static double linearMedian (double t[], int k) {  
		return linearMedian(t, 0, t.length, k-1);
	}


	// calcule la (k+1)-e`me plus petite valeur contenue dans le tableau t entre les indice l et r
	private static double linearMedian (double t[], int l, int r, int k) {  // computes value at index k in sorted array
		// quadratic-time computation for small instances
		if (r-l <= 30)
			return medianViaInsertionSort(t, l, r, k);
		// compute the medians and store them at the beginning of the segment
		int nbmed = 0;
		for (int i=l; i<r; i+=5){
			double m = medianViaInsertionSort(t, i, Math.min(i+5, r), (Math.min(i+5, r)-i)/2);
			for (int j=i; j<Math.min(i+5, r); j++)
				if (t[j]==m) {
					swap(t, j, l+nbmed++);
					break; // to prevent issues when the value m is duplicated in the array
				}
		}
		// compute the median of the medians
		double m = linearMedian (t, l, l+nbmed, nbmed/2);
		// partition the table according to the pivot
		int midx = l;
		for (int i=l; i<r; i++)
			if (t[i]<m)
				swap(t, i, midx++);
		// recursive call
		if (midx-l > k)
			return linearMedian (t, l, midx, k);
		else if (midx-l < k)
			return linearMedian (t, midx, r, k-(midx-l));
		else  // midx==l => array is split around k-median m
			return m;
	}

	private static void swap (double[] t, int i, int j){
		double temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	private static double medianViaInsertionSort (double[] t, int l, int r, int k) {
		// insertion sort
		for (int j=l+1; j<r; j++) {
			for (int s = j; s>l; s--)
				if (t[s] < t[s-1]) // swap
					swap(t, s-1, s);
				else
					break;
		}			
		// retrieve k-th element
		return t[l+k];
	}

	public static LinkedList<Double> medians (double[] t, int k) {
		LinkedList<Double> res = new LinkedList<Double>();
		for (int i=k/4; i<t.length; i+=k/4)
			res.add(Median.linearMedian(t, 0, t.length, i));
		return res;
	}

	public static void main (String[] args) {
		System.out.println("Testing linear median:");
		for (int i=1; i<=1e7; i*=10) {
			double[] t = new double[i];
			double[] tbis = new double[i];
			for (int j=0; j<i; j++) {
				t[j] = (int)(Math.random()*i+1);
				tbis[j] = t[j];
			}
			Arrays.sort(tbis);
			long tstart = System.nanoTime();
			if (linearMedian(t, 0, i, i/2) != tbis[i/2])
				throw new Error ("linear median differs from sorting based median");
			long tend = System.nanoTime();
			System.out.println("  Time for n="+i+": "+(tend-tstart)+" nanoseconds");
		}
		System.out.println("No error found");
	}
}
