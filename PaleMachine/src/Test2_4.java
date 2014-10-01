import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Test2_4 {

	public static LinkedList<Point2D> ListFromArray(Point2D[] t) {
		  	LinkedList<Point2D> result=new LinkedList<Point2D>();
		  	for(int i=0;i<t.length;i++)
		  		result.add(t[i]);
		  	return result;
		  }
		  

	public static void main (String[] args) throws FileNotFoundException {
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


	  	System.out.println("Test 2.4");
  	  	
	  	double R = 8;
	  	Grid grid=new Grid(R);  	
	  	grid.addPoints(points);
	  	 	

	  	Point2D queryPoint=new Point2D(30.5,35.);
	  	System.out.println("point "+queryPoint+" has "+grid.getNearbyPoints(new GridCell(queryPoint, R)).length+" neighbors in the grid");
	  	queryPoint=new Point2D(50,20);
	  	System.out.println("point "+queryPoint+" has "+grid.getNearbyPoints(new GridCell(queryPoint, R)).length+" neighbors in the grid");
	  	queryPoint=new Point2D(0,0);
	  	System.out.println("point "+queryPoint+" has "+grid.getNearbyPoints(new GridCell(queryPoint, R)).length+" neighbors in the grid");
	  	
	  	System.out.println("Fin du Test 2.4");
	}
	
}
