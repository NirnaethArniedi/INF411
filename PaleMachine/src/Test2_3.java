import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Test2_3 {

	public static LinkedList<Point2D> ListFromArray(Point2D[] t) {
		  	LinkedList<Point2D> result=new LinkedList<Point2D>();
		  	for(int i=0;i<t.length;i++)
		  		result.add(t[i]);
		  	return result;
		  }
		  

	public static void main (String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new File("rand_cloud.txt"));
		int n = sc.nextInt() / 10; sc.nextLine();
		Point2D[] points = new Point2D[n];
		for (int i=0; i<n; i++) {
			String s = sc.nextLine();
			Scanner ssc = new Scanner (s);
			ssc.useLocale(Locale.US);
			points[i] = new Point2D(60*ssc.nextDouble(), 60*ssc.nextDouble());
//			System.out.println(points[i]);
		}
		sc.close();

	  	System.out.println("Test 2.3");
	  	
	  	LinkedList<Point2D> l=ListFromArray(points);
	  	  	
	  	Fenetre f=new Fenetre(l);
	  	Grid grid=new Grid(8);  	
	  	grid.addPoints(points);
	  	for(int i=0;i<points.length;i++) {
	  		GridCell c=new GridCell(points[i], 8);
	  		if(grid.hMap.containsKey(c)==false) {
	  			System.out.println("Erreur: L'un des points de l'ensemble n'est contenu dans aucune cellule de votre grille");
	  			return;
	  		}
	  		else if(grid.hMap.get(c).size()==0){
	  			System.out.println("Erreur: Vous avez créé une cellule inutile car elle ne contient aucun point de l'ensemble");
	  		}
	  		else
	  			f.addCell(c);
	  	}

	  	f=new Fenetre(l);
	  	grid=new Grid(5);  	
	  	grid.addPoints(points);
	  	for(int i=0;i<points.length;i++) {
	  		GridCell c=new GridCell(points[i], 5);
	  		if(grid.hMap.containsKey(c)==false) {
	  			System.out.println("Erreur: point contenu dans une cellule non existante");
	  			return;
	  		}
	  		else if(grid.hMap.get(c).size()==0){
	  			System.out.println("Erreur: cellule vide (ne contenant aucun point)");
	  		}
	  		else
	  			f.addCell(c);
	  	}

	  	System.out.println("Fin du Test 2.3");
	}
	
}
