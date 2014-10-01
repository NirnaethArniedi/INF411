import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;


public class Test2_5 {

	public static void main (String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner (new File("rand_cloud.txt"));
		int n = sc.nextInt(); sc.nextLine();
		Point2D[] points = new Point2D[n];
		for (int i=0; i<n; i++) {
			String s = sc.nextLine();
			Scanner ssc = new Scanner (s);
			ssc.useLocale(Locale.US);
			points[i] = new Point2D(ssc.nextDouble(), ssc.nextDouble());
//			System.out.println(points[i]);
		}
		sc.close();

		System.out.println("Test 2.5");
	  	// test decreasing values of k by steps of 10 or 100
		while (n>0) {
	  		double r = SmallestkRadius.minkRadiusRandDet(points, n);
	  		System.out.println(r/2+" <= "+n+"-radius <= "+r);
	  		if (n>100)
	  			n -= 100;
	  		else
	  			n -=10;
  		}
  		System.out.println("End Test 2.5");
	}
}
