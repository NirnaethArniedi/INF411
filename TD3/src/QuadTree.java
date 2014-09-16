/**
 * Class for representing a QuadTree
 */
public class QuadTree {
	
	private int color; // color of the node
	private QuadTree[] children; // the children of the node
			
	/**
	 * Construct a leaf (no descendants), with a given color
	 */
	public QuadTree(int color) {
		this.children = null;
		this.color = color;
 	}
	
	/**
	 * Construct an internal node of a Quad-tree (four children), color is set to -1
	 */
	public QuadTree(QuadTree topLeft, QuadTree topRight, QuadTree bottomLeft, QuadTree bottomRight) {
		this.color = -1;
		this.children =new QuadTree[4];
		this.children[0]= topLeft;
		this.children[1]= topRight;
		this.children[2]= bottomLeft;
		this.children[3]= bottomRight;
	}

	/**
	 * Say whether a node is a leaf (no descendants)
	 */
	public boolean isLeaf() {
		return !(this.color==-1);
	}

	/**
	 * Return the color of a leaf, or -1 for an internal node 
	 */
	public int getColor() {
		return this.color;
	}
		
	/**
	 * Return the i-th child of the node 
	 */
	public QuadTree getChild(int i) {
		return this.children[i-1];
	}
	
	/**
	 * Return a ternary encoding of a Quad-tree
	 */
	public static String encodeQuadTreeToString(QuadTree a) {
		
		if(a.isLeaf()) return a.getColor()+"";
		else{
			String s = "*";
			for( QuadTree x : a.children)
				s = s+encodeQuadTreeToString(x);
			return s;
		}
	}

	/**
	 * Index for decoding
	 */
	static int indexDecoding;

	/**
	 * Return a Quad-tree, obtained decoding a ternary string
	 */
	public static QuadTree decodeQuadTreeFromString(String encoding) {
		indexDecoding =0;
		return decodeFromIndex(encoding);
	}
	
	/**
	 * Return a Quad-tree, obtained decoding a ternary string starting from the position recorded by indexEncoding
	 */
	public static QuadTree decodeFromIndex(String encoding) {
		char s = encoding.charAt(indexDecoding);
		if(!(s=='*')){
			QuadTree a = new QuadTree(Character.getNumericValue(s));
			return a;
		}
		else { 
			indexDecoding++;
			QuadTree topLeft = decodeFromIndex(encoding);
			indexDecoding++;
			QuadTree topRight = decodeFromIndex(encoding);
			indexDecoding++;
			QuadTree bottomLeft= decodeFromIndex(encoding);
			indexDecoding++;
			QuadTree bottomRight = decodeFromIndex(encoding);
			QuadTree a = new QuadTree(topLeft,topRight,bottomLeft,bottomRight);
			return a;
		}
	}	
}
