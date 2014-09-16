
public class Test12 {
	public static void main(String[] args) {
		System.out.println("Testing quad-tree encoding");
		QuadTree black = new QuadTree(0);
		QuadTree white = new QuadTree(1);
		QuadTree B = white;
		QuadTree C = new QuadTree(white, black, black, white);
		QuadTree D = black;
		QuadTree E = new QuadTree(white, white, white, black);
		QuadTree A = new QuadTree(B, C, D, E);
		System.out.println("encoding: " + QuadTree.encodeQuadTreeToString(A));
	}
}
