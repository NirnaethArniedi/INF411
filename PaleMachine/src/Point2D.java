// Point a deux coordonnes reelles
class Point2D {

	private double x, y;
	
	// constructeur
	Point2D(double x, double y) {
		this.x = x; 
		this.y = y;
	}
  
	// renvoie la coordonnee x du point
	public double getX(){
  		return x;
  	}
  
	// renvoie la coordonnee y du point
  	public double getY() {
  		return y;
  	}

  	// renvoie la distance euclidienne entre le point courant et le point p
  	double distanceTo(Point2D p) {
  		return Math.sqrt((x-p.x)*(x-p.x) + (y-p.y)*(y-p.y));
  	}  

  	public String toString() {
  		return "(" + x + "," + y + ")";
  	}
  
  
}
