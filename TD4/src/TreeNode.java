import java.util.Queue;
import java.util.LinkedList;

/**
 * @author J-C. Filliatre and L. Castelli Aleardi (INF421, 2013, Ecole Polytechnique)
 * An implementation of an ordered set based on binary search trees
 */
public class TreeNode {

	final int value;
	final TreeNode left, right;


	// Constructs a node with 2 children

	public TreeNode(TreeNode left, int value, TreeNode right) {
		this.value = value ;
		this.left = left ; 
		this.right = right ;
	}

	// Constructs a leaf

	public TreeNode(int value) {
		this.value = value;
		this.left = this.right = null;
	}

	// Determines whether tree b contains x; b may represent the empty
	// set.

	static boolean contains(TreeNode b, int x) {
		if(b.value == x)
			return true;

		int c = x - b.value;

		if(b.left != null && c<0)
			return contains(b.left,x);
		if(b.right != null  && c>0 )
			return contains(b.right,x);

		return false;
	}

	// Returns the smallest element contained in tree b, assumed to
	// represent a non-empty set

	static int getMin(TreeNode b) {
		while(b.left != null)
			b = b.left;

		return b.value;
	}

	// Adds x to tree b

	static TreeNode add(TreeNode b, int x) {
		if (b == null)
			return new TreeNode(x);

		int c = x - b.value;
		if (c<0)
			return new TreeNode(add(b.left,x),b.value,b.right);
		if(c>0)
			return new TreeNode(b.left,b.value,add(b.right,x));

		return b;	
	}

	/* split(v,s) returns two trees, containing values
	 * from s smaller and greater than s
	 */
	static Pair split(int x, TreeNode s) {
		if(s == null)
			return new Pair(null,null);
		int c = x - s.value;
		TreeNode b;
		TreeNode a;
		if( c == 0 ){ //  on sait ou couper 
			b = s.right;
			a = s.left;
		}
		else if(c<0){ 
			Pair pr = split(x,s.left);
			b =  new TreeNode(pr.b,s.value,s.right);
			a = pr.a;
		}
		else{
			Pair pr = split(x,s.right);
			a =  new TreeNode(s.left,s.value,pr.a);
			b = pr.b;
		}
		
		Pair p = new Pair(a,b);
		return p;
		
	}

	/* Returns a tree representing the union of the two sets represented
	 * by s1 and s2 */

	static TreeNode union(TreeNode s1, TreeNode s2) {
		if(s1 == null)
			return s2;
		else if(s2==null)
			return s1;
		else{
			int a = s1.value;
			Pair pr = split(a,s2);
			TreeNode treeLeft = union(s1.left,pr.a);
			TreeNode treeRight = union(s1.right,pr.b);
			TreeNode treeUn = new TreeNode(treeLeft,a,treeRight);
			return treeUn;
		}
		//throw new Error("A completer: exo 2");
	}

	/* Determines whether the set represented by s1 is a subset of that
	 * represented by s2 */

	static boolean subset(TreeNode s1, TreeNode s2) {
		if(s1 == null)
			return true;
		else if(s2==null)
			return false;
		else{
			int c = s2.value-s1.value ;
			if(c==0)
				return (subset(s1.left,s2.left) && subset(s1.right,s2.right));
			else if(c<0){
				TreeNode ap = new TreeNode(null,s1.value,s1.right);
				return(subset(s1.left,s2) && subset(ap,s2.right));
			}
			else if(c>0){
				TreeNode app = new TreeNode(s1.left,s1.value,null);
				return(subset(s1.right,s2) && subset(app,s2.left));
			}

		}
		return false;
		//throw new Error("A completer: exo 2");
	}

	/* Determines whether the set represented by s1 is equal to that
	 * represented by s2 */

	static boolean equals(TreeNode x, TreeNode y) {
		return Enum.equals(Enum.build(x,  null), Enum.build(y, null));
	} 

	/* Converts the tree to a string using the infix enumeration
	 * order */

	public String infixOrder() {
		String result="";
		if(this.left!=null) result=result+this.left.infixOrder();
		result=result+" "+this.value;
		if(this.right!=null) result=result+this.right.infixOrder();
		return result;
	}

	/**
	 * Return the list of elements listed according to infix order
	 */
	public LinkedList<Integer> toList() {
		LinkedList<Integer> result=null;
		if(this.left!=null) result=(this.left.toList());
		if(result==null) result=new LinkedList<Integer>();
		result.add(this.value);
		if(this.right!=null) result.addAll(this.right.toList());
		return result;
	}

}
