
public class GifsRecordings {

	/**
	 * @param args
	 */
	public static void mergegif(){
		int[] t={4,3,1,5,7,3,8,2,9,6};
		DrawMergeSort d = new DrawMergeSort("top down merge sort", 400, 400);
		Tableau tab=new Tableau(t,d);
		int l=2, m=5, r=7;
		d.pause(200);
		d.paintGray(d.zoneTop(t, l,r));
		for(int i=l; i<r; i++) d.paintBlack(d.rectTop(t, i));
		System.out.println("hop");
		d.pause(20);
		d.paintRed(d.zoneBottom(t, l,m));
		d.paintBlue(d.zoneBottom(t, m,r));
		for(int i=l; i<r; i++) d.paintBlack(d.rectBottom(t, i));
		d.pause(20);
		MergeSort.merge(tab, l, m, r);
		
	}
	
	public static void findRungif(){
		int[] t={4,3,7,1,3,5,8,2,9,6};
		DrawMergeSort d = new DrawMergeSort("top down merge sort", 400, 400);
		@SuppressWarnings("unused")
		Tableau tab=new Tableau(t,d);
		d.pause(200);
		d.drawFindRun(t, 3);
	}
	
	public static void mergesortgif(){
		int[] t={4,3,7,1,5,3,8,2,9,6};
		DrawMergeSort d = new DrawMergeSort("top down merge sort", 400, 400);
		Tableau tab=new Tableau(t,d);
		
		MergeSort.topDownMergeSort(tab);
	}
	
	public static void main(String[] args) {
		
		findRungif();
	}

}
