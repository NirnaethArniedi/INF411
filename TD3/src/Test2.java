
public class Test2 {
	public static void main(String[] args) {
		int size = 256;
		System.out.println("Testing the construction of an image from a tree");
		BinaryImage img = new BinaryImage(size);
		QuadTree black = new QuadTree(0);
		QuadTree white = new QuadTree(1);
		QuadTree B = white;
		QuadTree C = new QuadTree(white, black, black, white);
		QuadTree D = black;
		QuadTree E = new QuadTree(white, white, white, black);
		QuadTree A = new QuadTree(B, C, D, E);
		QuadTreeCompression.getImageFromQuadTree(A, img, 0, 0, size);
		new ImageViewer(img);
	}

}
