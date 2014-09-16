
public class Test42 {
	public static void main(String[] args) {
		System.out.println("compression rate for random binary images: ");
		int N = 500;
		float[] values = new float[N];
		for(int i = 0; i < N; i++){
			values[i] = EfficiencyMeasure.compressionRate(EfficiencyMeasure.randomBinaryImage(256, (float) i/N));
		}
		new ImageViewer(EfficiencyMeasure.valuesToImage(values, N));
	}
}
