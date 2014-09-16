import java.util.LinkedList;
import java.util.ArrayList;

class CountWall{
	LinkedList<Integer> allrows; // toutes les rangées possibles d'une largeur fixée
	Table memo;
	
	/** constructeur : mur de briques de largeur width */
	CountWall(int width) {
		
		// On prépare un tableau où la case i va contenir toutes les rangées de longueur i
		ArrayList<LinkedList<Integer>> rows = new ArrayList<LinkedList<Integer>>(width + 1);
		
		// On commence par remplir toutes les cases avec la liste vide
		for(int i = 0; i <= width; i++) 
			rows.add(new LinkedList<Integer>());
		
		// Puis on les édite.
		// les premières valeurs sont particulières:
		// pour les longueur 0 et 1, il n'y a aucune rangée possible; on ne fait rien
		// pour les longueur 2 et 3, il y a exactement une rangée possible: 0 
		rows.get(2).add(0);
		rows.get(3).add(0);
		
		// pour les autres longueurs, une ligne de briques commence par une brique de longueur 2 ou 3...		
		for(int j = 4; j<=width; j++){
			
			// on prend toutes les rangees de longueur i-2 et i-3
			LinkedList<Integer> listM2=rows.get(j-2); 
			LinkedList<Integer> listM3=rows.get(j-3);
			
			// pour chaque rangee de longueur i-2 on ajoute un contact et une brique de largeur 2 en bout de rangee
			for(int k = 0; k < listM2.size();k++){
				rows.get(j).add((listM2.get(k)|1)<<2); 
			}
			// idem que pour 2
			for(int p = 0; p < listM3.size();p++){

				rows.get(j).add((listM3.get(p)|1)<<3);
			}
			
		}	
		this.allrows = rows.get(width);
		this.memo = new Table();
	}
	
	/** count(row, height) : compte les murs de hauteur height dont la première rangée est row */
	long count(int row, int height) {
		if(height==1) return 1;
		long c = 0 ;
		Triple search=memo.find(row,height);
		if(search!=null){
			return search.result;
		}
		for(int s : allrows){
			if((s & row)==0) c+=count(s, height-1);
		}
		memo.add(row, height, c);
		return c;
	}
	
	/** count(height) : compte tous les murs de hauteur height */
	long count(int height) {
		long c = 0;
		for(int s : allrows){
			c+=count(s,height);
		}
		return c;
	}

}
