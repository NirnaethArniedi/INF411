
public class Test3 {
	public static void main(String[] args) {
		System.out.println("Testing the construction of a tree from an image");

		// First test with a constructed image
		int size = 256;
		BinaryImage img = new BinaryImage(size);
		QuadTree black = new QuadTree(0);
		QuadTree white = new QuadTree(1);
		QuadTree B = white;
		QuadTree C = new QuadTree(white, black, black, white);
		QuadTree D = black;
		QuadTree E = new QuadTree(white, white, white, black);
		QuadTree A = new QuadTree(B, C, D, E);
		QuadTreeCompression.getImageFromQuadTree(A, img, 0, 0, size);
		reconstructImage(img);

		// Second test with a real image
		reconstructImage(new BinaryImage("Example256.png"));
	}

	static void reconstructImage(BinaryImage img) {
		// Construct a new Quad-tree from an image
		QuadTree treeFromImage = QuadTreeCompression.getQuadTreeFromImage(img, 0, 0, img.getSize());
		BinaryImage reconstructedImage = new BinaryImage(img.getSize());
		QuadTreeCompression.getImageFromQuadTree(treeFromImage, reconstructedImage, 0, 0, img.getSize());

		//visualize the result
		new ImageViewer(reconstructedImage);

	}
}
