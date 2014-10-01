import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Test2_2 {

	public static LinkedList<Point2D> ListFromArray(Point2D[] t) {
		  	LinkedList<Point2D> result=new LinkedList<Point2D>();
		  	for(int i=0;i<t.length;i++)
		  		result.add(t[i]);
		  	return result;
		  }
		  

	public static void main (String[] args) throws FileNotFoundException, SecurityException, NoSuchMethodException {
		Scanner sc = new Scanner (new File("rand_cloud.txt"));
		int n = sc.nextInt(); sc.nextLine();
		Point2D[] points = new Point2D[n];
		for (int i=0; i<n; i++) {
			String s = sc.nextLine();
			Scanner ssc = new Scanner (s);
			ssc.useLocale(Locale.US);
			points[i] = new Point2D(60*ssc.nextDouble(), 60*ssc.nextDouble());
//			System.out.println(points[i]);
		}
		sc.close();

	  	System.out.println("Test 2.2");

	  	LinkedList<Point2D> l=ListFromArray(points);
//	  	GridCell c1 = new GridCell(new Point2D(50.3, 17), 20);
//	  	GridCell c2 = new GridCell(new Point2D(15.6, 33.9), 10);
	  	GridCell cRed=new GridCell(l.get(25), 20);
	  	GridCell cBlue=new GridCell(l.get(40), 20);

	  	// check if first part or second part of question must be tested
//	  	boolean testFirstPart = 
////	  			(GridCell.class.getMethod("equals").getDeclaringClass().getName() != "GridCell") ||
//	  			(GridCell.class.getMethod("hashCode").getDeclaringClass().getName() != "GridCell") ||
//	  			(GridCell.class.getMethod("toString").getDeclaringClass().getName() != "GridCell");
	  			
	    
//	  	if (testFirstPart) {
//	  		System.out.println("Grid cell of point (50.3, 17) = ("+c1.x+","+c1.y+")" );
//	  		System.out.println("Grid cell of point (15.6, 33.9) = ("+c2.x+","+c2.y+")" );
//	  	}
	  	
//	  	else {
	  		Fenetre f=new Fenetre(l);

	  		f.addCell(cRed); f.addCell(cBlue);
	  		for(int i=0;i<points.length;i++) {
	  			if(cRed.equals(new GridCell(points[i], 20)))
	  				f.addRedPoint(points[i]);
	  			if(cBlue.equals(new GridCell(points[i], 20)))
	  				f.addBluePoint(points[i]);
	  		}
	  		System.out.println("first cell, "+f.redPoints.size()+" points: "+cRed);
	  		System.out.println("second cell, "+f.bluePoints.size()+" points: "+cBlue);

	  		f=new Fenetre(l);

	  		cRed=new GridCell(l.get(130), 10);
	  		cBlue=new GridCell(l.get(121), 10);
	  		f.addCell(cRed); f.addCell(cBlue);
	  		for(int i=0;i<points.length;i++) {
	  			if(cRed.equals(new GridCell(points[i], 10)))
	  				f.addRedPoint(points[i]);
	  			if(cBlue.equals(new GridCell(points[i], 10)))
	  				f.addBluePoint(points[i]);
	  		}
	  		System.out.println("first cell, "+f.redPoints.size()+" points: "+cRed);
	  		System.out.println("second cell, "+f.bluePoints.size()+" points: "+cBlue);
//	  	}
	  	
	  	
	  	System.out.println("Fin du Test 2.2");
	}
	
}
