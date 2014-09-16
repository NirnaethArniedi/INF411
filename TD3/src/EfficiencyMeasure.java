 
public class EfficiencyMeasure {
	
	/**
	 * Returns the compression rate of the binary image img
	 */
	static float compressionRate(BinaryImage img) {
		int size = img.getSize();
		//int x = img.getWidth();
		//int y = img.getHeight();
		QuadTree tree = QuadTreeCompression.getQuadTreeFromImage(img,0,0,size);
		String encoding = QuadTree.encodeQuadTreeToString(tree);
		double d = Math.log(3)/Math.log(2);
		float ln3 = (float) d;
		float cRate =encoding.length()*ln3/(size*size);
		return cRate;
	}
	
	/**
	 * Constructs a random binary image (each pixel is black or white with probability p)
	 */
	static BinaryImage randomBinaryImage(int size, float prob) {
		BinaryImage img = new BinaryImage(size);
		for(int x = 0; x<size;x++)
			for(int y = 0;y <size;y++)
				if(Math.random()>prob) img.fillAreaWhite(x, y, 1);
		return img;
	}
	
	/**
	 * Plots the values on a square binary image of a given size
	 */
	static BinaryImage valuesToImage(float[] values, int size) {
		BinaryImage img = new BinaryImage(size);
		img.fillAreaWhite(0, 0, size);
		float m =0;
		int x= 0;
		for(float y : values){
			if(y>m) m=y;
		}
		int lng = values.length;
		for(float y : values){
			float o = y/m;
			int or;
			or = (int)o;
			System.out.println(or);
			float a = x*size/lng;
			int ab;
			ab = (int) a;
			System.out.println(ab);
			img.fillAreaBlack(ab,or, 1);
			x++;
		}
		return img;
	}
}
