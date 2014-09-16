
public class Test0 {
	public static void main(String[] args) {
		// creating an image
		BinaryImage createdImg = new BinaryImage(256);
		createdImg.fillAreaWhite(0, 128, 128);
		createdImg.fillAreaWhite(128, 0, 128);
		new ImageViewer(createdImg);

		// loading an image
		BinaryImage loadedImg = new BinaryImage("Example256.png");
		new ImageViewer(loadedImg);
	}
}
