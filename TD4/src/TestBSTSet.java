import java.util.*;

/**
 * @author Luca Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * Provides methods for testing operations on ordered sets (implementation based on binary search trees)
 */
public class TestBSTSet {

	  public static void main(String[] args) {
     // test1();
		  test2();
		  //test3();
		  //test4();
	  }

	  /**
	   * Test basic operations on BST: creation, addition, min search, element search
	   */
	  public static void test1() {
		  BSTSet b1=new BSTSet(); // create an empty binary search tree
		  int n=10;
		  for(int i=n/2;i>0;i--)
			  b1.add(i);
		  for(int i=n/2;i<n;i++)
			  b1.add(i);
		  new Fenetre(b1.root);
		  
		  System.out.println("S1="+b1);
		  System.out.println(b1.contains(1));
		  System.out.println(b1.contains(2));
		  System.out.println(b1.contains(4));
		  System.out.println(b1.contains(0));
		  System.out.println(b1.contains(10));
		  System.out.println("min="+b1.getMin());
	  }
	  	  
	  /**
	   * Test subset
	   */
	  public static void test2() {
		  System.out.println("Testing subset");
		  BSTSet b1=new BSTSet();
		  BSTSet b2=new BSTSet();
		  int n=10;
		  
		  Random generator = new Random(10); // initialize the pseudo random generator 
		  PriorityQueue<Integer> l=new PriorityQueue<Integer>();
		  for(int i=0;i<n;i++){
        int p = (int)(generator.nextDouble()*(2*n));
        if (!l.contains(p)) l.add(p);
      }

		  b1= new BSTSet(ofList(l)); // create first tree from a list
		  System.out.println("b1="+b1);
		  new Fenetre(b1.root);
		  
		  generator = new Random(10); // re-initialize the pseudo random generator 
		  for(int i=0;i<n+4;i++)
		    	b2.add((int)(generator.nextDouble()*(2*n))); // create second tree with random insertion order
		  System.out.println("b2="+b2);
		  new Fenetre(b2.root);
		  
		  System.out.println("b1<=b2? "+b1.subset(b2));
		  System.out.println("b2<=b1? "+b2.subset(b1));
	  }

	  /**
	   * Test union of two binary search trees
	   */
	  public static void test3() {
		  System.out.println("Testing union");
		  BSTSet b1=new BSTSet(); // create an empty binary search tree
		  int n=5;
		  for(int i=n/2;i>0;i--)
			  b1.add(2*i);
		  for(int i=n/2;i<n;i++)
			  b1.add(2*i);
		  new Fenetre(b1.root);
		    
		  Queue<Integer> l = new LinkedList<Integer>();
		  for(int i=0;i<n*2;i++)
		    	l.add(2*i+1);

		  BSTSet b2= new BSTSet(ofList(l)); // a binary search tree from a list
		  new Fenetre(b2.root);
		    
		  BSTSet u1=b1.union(b2);
		  new Fenetre(((BSTSet)u1).root);

		  BSTSet u2=b2.union(b1);
		  new Fenetre(((BSTSet)u2).root);
		  
		  System.out.println("b1: "+b1);
		  System.out.println("b2: "+b2);
		  System.out.println("u1:=b1 U b2 = "+u1);
		  System.out.println("u2:=b2 U b1 = "+u2);		  
	  }
	  
	  /**
	   * Test equality
	   */
	  public static void test4() {
		  System.out.println("Testing equality");
		  BSTSet b1=new BSTSet();
		  BSTSet b2=new BSTSet();
		  int n=10;
		  
		  Random generator = new Random(10); // initialize the pseudo random generator 

		  PriorityQueue<Integer> l=new PriorityQueue<Integer>();
		  for(int i=0;i<n;i++){
        int p = (int)(generator.nextDouble()*(2*n));
        if (!l.contains(p)) l.add(p);
      }

		  b1= new BSTSet(ofList(l)); // create first tree from a list
		  
		  generator = new Random(10); // re-initialize the pseudo random generator 
		  for(int i=0;i<n;i++)
		    	b2.add((int)(generator.nextDouble()*(2*n))); // create second tree with random insertion order
		  
		  System.out.println("b2="+b2);
		  System.out.println("b1="+b1);
		  new Fenetre(b1.root);
		  new Fenetre(b2.root);
		  
		  System.out.println("b1==b2? "+b1.equals(b2));
		  System.out.println("b2==b1? "+b2.equals(b1));
		  
		  System.out.println("\nUpdating b2");
		  b2.add(15);
		  System.out.println("b2="+b2);
		  System.out.println("b1="+b1);
		  System.out.println("b1==b2? "+b1.equals(b2));
		  System.out.println("b2==b1? "+b2.equals(b1));
		  
		  // testing equals on sets of String
		  System.out.println();
		  BSTSet s2=new BSTSet();		
		  BSTSet s1=new BSTSet();		
		  s2.add(34); s2.add(23); s2.add(67); s2.add(2);
		  s2.add(34); s2.add(23); s2.add(17); s2.add(56);
		  s2.add(99); s2.add(77);
		  s1.add(77); s1.add(23); s1.add(67); s1.add(2);
		  s1.add(34); s1.add(23); s1.add(56); s1.add(17);
		  s1.add(99); s1.add(34);

		  System.out.println("s1= "+s1);
		  System.out.println("s2= "+s2);
		  System.out.println("s1=s2? "+s1.equals(s2));
		  new Fenetre(s1.root);
		  new Fenetre(s2.root);
	  }


  static TreeNode ofList(Queue<Integer> l, int n, int k) {
		//throw new Error("A completer: exo 1");
    if (k == 0) { // 0 <= n <= 1
      if (n == 0) return null;
      int v = l.poll();
      return new TreeNode(v);
    } else {
      int n1 = (n - 1) / 2;
      TreeNode left = ofList(l, n1, k - 1);
      int v = l.poll();
      TreeNode right = ofList(l, n - n1 - 1, k - 1);
      return new TreeNode(left, v, right);
    }
  }
	  
  static TreeNode ofList(Queue<Integer> l) {
    int n = l.size();
    return ofList(l, n, (int)(Math.log(n) / Math.log(2)));
  }


}
