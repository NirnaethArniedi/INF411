

public class SmallestkRadius {


	// calcule le rayon du plus petit disque centre' en p et contenant k points du tableau pts
	public static double kRadius (Point2D p, Point2D[] pts, int k) {  
		double[] t = new double[pts.length];
		for(int i = 0; i<pts.length; i++){
			t[i]=pts[i].distanceTo(p);
		}
		return Median.linearMedian(t, k);
		//throw new Error ("a' comple'ter (question 2.1)");
	}

	// calcule le rayon du plus petit disque contenant k points du tableau pts (version nai"ve)
	public static double minkRadiusRand(Point2D[] pts, int k) {
		double ray=Double.MAX_VALUE;
		for(int i=0; i<pts.length; i++){
			double rand = Math.random();
			if(k*rand<1){ 
				double rad = kRadius(pts[i],pts,k);
				ray=Math.min(rad,ray);
			}
		}
		return ray;
	}

	// calcule le rayon du plus petit disque contenant k points du tableau pts (version finale)
	public static double minkRadiusRandDet(Point2D[] pts, int k) {
		throw new Error ("a' comple'ter (question 2.5)");
	}

}
