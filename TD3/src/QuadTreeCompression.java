/**
 * Compression/decompression of binary images using Quad-trees
 */
public class QuadTreeCompression {

	/**
	 * Set a binary image corresponding to a given Quad-tree
	 */
	public static void getImageFromQuadTree(QuadTree t, BinaryImage img, int x, int y, int size) {
		switch(t.getColor()){
			case 1 : img.fillAreaWhite(x,y,size); return;
			case 0 : img.fillAreaBlack(x,y,size); return;
			case -1 :{
				getImageFromQuadTree(t.getChild(1),img,x,y,size/2);
				getImageFromQuadTree(t.getChild(2),img,x+size/2,y,size/2);
				getImageFromQuadTree(t.getChild(3),img,x,y+size/2,size/2);
				getImageFromQuadTree(t.getChild(4),img,x+size/2,y+size/2,size/2);
				return;
			}
		}
	}


	/**
	 * Return the Quad-tree representing an image
	 */
	public static QuadTree getQuadTreeFromImage(BinaryImage img, int x, int y, int size) {
		QuadTree black = new QuadTree(0);
		QuadTree white = new QuadTree(1);
		if(img.isConstantColor(x,y,size)){
			if(img.isBlack(x, y)) return black;
			else return white;
		}
		else{
			QuadTree topLeft = getQuadTreeFromImage(img,x,y,size/2);
			QuadTree topRight = getQuadTreeFromImage(img,x+size/2,y,size/2);
			QuadTree bottomLeft= getQuadTreeFromImage(img,x,y+size/2,size/2);
			QuadTree bottomRight =getQuadTreeFromImage(img,x+size/2,y+size/2,size/2);
			QuadTree a = new QuadTree(topLeft,topRight,bottomLeft,bottomRight);
			return a;
		}
	}
}
