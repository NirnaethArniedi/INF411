
public class Test41 {
	public static void main(String[] args) {
		System.out.println("compression rate for Mondrian1: " + EfficiencyMeasure.compressionRate(new BinaryImage("Mondrian1.png")));
		System.out.println("compression rate for Mondrian2: " + EfficiencyMeasure.compressionRate(new BinaryImage("Mondrian2.png")));
		System.out.println("compression rate for Pollock1: " + EfficiencyMeasure.compressionRate(new BinaryImage("Pollock1.png")));
		System.out.println("compression rate for Pollock2: " + EfficiencyMeasure.compressionRate(new BinaryImage("Pollock2.png")) + "\n\n");
	}
}
