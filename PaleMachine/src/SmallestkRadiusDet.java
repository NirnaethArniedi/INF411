import java.util.LinkedList;


public class SmallestkRadiusDet {
	
	
	// calcule le rayon du plus petit disque contenant k points du tableau pts (version de'terministe)
	public static double minkRadiusDet(Point2D[] pts, int k) {
		double res = Double.MAX_VALUE;
		for (double h : splittingHorizontalLines(pts, k))
  			for (double v : splittingVerticalLines(pts, k))
  				res = Math.min(res, SmallestkRadius.kRadius(new Point2D(v,h), pts, k));
		return res;
	}

	private static LinkedList<Double> splittingHorizontalLines(Point2D[] points, int k) {
		double[] y = new double[points.length];
		for (int i=0; i<points.length; i++)
			y[i] = points[i].getY();
		return Median.medians(y, k);
	}

	private static LinkedList<Double> splittingVerticalLines(Point2D[] points, int k) {
		double[] x = new double[points.length];
		for (int i=0; i<points.length; i++)
			x[i] = points[i].getX();
		return Median.medians(x, k);
	}	


}
