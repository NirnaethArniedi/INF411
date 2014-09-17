/**
 * @author J-C. Filliatre
 *	  same fringe: do two BST contain the same values?
 * the left branch of the tree is built as a list of
 * pairs (value, right sub-tree), of type Enum
 * the list is bottom-up: the head is the leftmost,
 * innermost element of the tree
 */
public class Enum {
	final int root;
	final TreeNode right;
	final Enum next;

	// Basic constructor initialising fields with corresponding
	// arguments

	public Enum(int root, TreeNode right, Enum next) {
		this.root = root;
		this.right = right;
		this.next = next;
	}

	// Converts a tree t into a list Enum appended to acc

	static Enum build(TreeNode t, Enum acc) {
		if(t == null)
			return acc;
		else{
			Enum e = new Enum(t.value, t.right, acc);
			return build(t.left,e);
		}
		//throw new Error("A completer: exo 2");
	}

	// Compares two objects of class Enum, seen as sets

	static boolean equals(Enum x, Enum y) {
		if(y==null)
			if(x==null)
				return true;
			else return false;
		else if(x==null)
			return false;
		if(x.root != y.root)
			return false;
		Enum xp = build(x.right,x.next);
		Enum yp = build(y.right,y.next);
		return equals(xp,yp);
		//throw new Error("A completer: exo 2");
	}

}
