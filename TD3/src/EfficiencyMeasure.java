 
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
		float o1 = (float) size-(size-1)/m;
		int oun;
		oun = (int) o1;
		for(float y : values){
			float o = (float) size-y*(size-1)/m;
			int or;
			or = (int)o;
			img.fillAreaBlack(x,or, 1);
			img.fillAreaBlack(x, oun, 1);
			x++;
		}
		return img;
	}
}
