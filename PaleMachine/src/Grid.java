import java.util.*;

class Grid {

	HashMap<GridCell,LinkedList<Point2D>> hMap;	
	double R;

	// constructeur
	public Grid(double R) {
		hMap = new HashMap<GridCell, LinkedList<Point2D>>();
		this.R = R;
	}

	// ajoute un nouveau point a' la grille
	public void addPoint(Point2D p) {
		GridCell grid = new GridCell(p,R);
		// si hMap ne contient pas la cellule consideree on ajoute grid a hMap associe a la liste vide
		if(!hMap.containsKey(grid))
			hMap.put(grid, new LinkedList<Point2D>());
		hMap.get(grid).add(p); // on ajoute p a la liste de grid.
		return;
		//throw new Error ("a' comple'ter (question 2.3)");
	}

	// ajoute tous les points a' la grille
	public void addPoints(Point2D[] pts) {
		for(int i =0; i<pts.length; i++)
			addPoint(pts[i]);
		return;
		//throw new Error ("a' comple'ter (question 2.3)");
	}

	// recupere les points contenus dans la cellule c et ses 8 voisines dans la grille
	public Point2D[] getNearbyPoints(GridCell c) {
		LinkedList<Point2D> L = new LinkedList<Point2D>(); // on cree une liste pour mettre tous nos points
		for (int dx = -1; dx <= 1; dx++)
			for (int dy = -1; dy <= 1; dy++) {
				GridCell grid = c.shift(dx,dy);
				LinkedList<Point2D> L1 = hMap.get(grid);
				if(L1!=null)
					L.addAll(L1); // on copie les points de la grille grid dans la liste de tous nos points
			}
		//une fois la double boucle finie on convertit L en tableau :
		Point2D[] tab = new Point2D[L.size()];
		int i =0;
		while(L.size()!=0){
			tab[i]=L.getLast();
			L.removeLast();
			i++;
		}
		
		return tab;
		
	}


}