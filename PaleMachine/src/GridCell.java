class GridCell {
	
	double x,y; // coordonnees du coin inferieur gauche de la cellule
	double R;
	
	// constructeur
	public GridCell(Point2D p, double R) {
		this.R = R;
		this.x = R*Math.floor(p.getX()/R);
		this.y = R*Math.floor(p.getY()/R);
	}
	
	// renvoie la cellule de'cal'ee de dx colonnes et dy lignes par rapport a` la cellule courante dans la grille 
	public GridCell shift(int dx, int dy) {
		return new GridCell(new Point2D(x+R/2+dx*R, y+R/2+dy*R), R);
	}

	public boolean equals(Object o) {
    	GridCell grid = (GridCell) o;
    	return(this.x==grid.x && this.y == grid.y);
		//throw new Error ("a' comple'ter (question 2.2)");
	}
	
	public int hashCode() {
    	double xR= this.x/this.R;
    	double yR= this.y/this.R;
    	double hC=Math.floor(xR+42*yR);
    	int hash = (int) hC;
    	return hash;
	}

	public String toString() {
    	return ("("+this.x+","+this.y+")");
		
	//	throw new Error ("a' comple'ter (question 2.2)");
	}
  
}
