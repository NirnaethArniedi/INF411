
public class Tableau {

	private int[] tab;
	private DrawMergeSort draw;
	private static int compteur;
	private boolean aux;

	public Tableau(int[] t){
		tab=new int[t.length];
		for(int i=0; i<t.length; i++) tab[i]=t[i];
		compteur=0;
		aux=false;
	}
	
	public Tableau(int[] t, DrawMergeSort d){ 
		tab=t; 
		draw=d; 
		draw.draw(t);
		//draw.pause(200);
		compteur=0;
		aux=false;
	}

	public Tableau(Tableau t, int lo, int mi, int hi) { 
		tab=new int[hi-lo]; 
		draw=t.draw;
		aux=true;
		if(draw!=null){
			draw.erase(draw.zoneBottom(t.tab, 0, t.tab.length));
			draw.paintRed(draw.zoneBottom(t.tab, lo, mi));
			draw.paintBlue(draw.zoneBottom(t.tab, mi, hi));
		}
		int[] aux=new int[t.length()];
		for(int i=0; i<hi-lo; i++) {
			aux[i+lo]=t.tab[i+lo];
			tab[i]=t.tab[lo+i];
			if(draw!=null)
				draw.paintBlack(draw.rectBottom(t.tab, i+lo));
		}
		if(draw!=null) draw.pause(20);
	}

	public int compare(int i, int j){
		compteur++;
		return tab[i]-tab[j];
	}

	public void change(int k, int val) { 
		if(draw!=null && !aux)
			draw.erase(draw.rectTop(tab, k));
		tab[k]=val; 
		if(draw!=null && !aux){
			draw.paintGray(draw.rectTop(tab, k));
			draw.pause(1);
			draw.paintBlack(draw.rectTop(tab, k));
			draw.pause(1);
		}
	}
	
	static void initCompteur(){
		compteur=0;
	}
	
	static int getCompteur(){
		return compteur;
	}

	public int get(int k) { return tab[k]; }
	
	public int length() { return tab.length; }

	public String toString(){
		String s = "[";
		for (int i = 0; i < tab.length; i++)
			s += (i == 0 ? "" : ", ") + tab[i];
		return s + "]";
	}
}
