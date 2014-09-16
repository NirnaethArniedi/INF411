class Test3{

	public static void test(int x, int y) {
			CountWall countWall = new CountWall(x);
			System.out.println("Nombre de murs de largeur " + x + " et de hauteur " + y + ": ");
			System.out.println(countWall.count(y));
	}

	public static void main(String[] args) {
		test(9,3);
		test(12,4);
		test(30,10);
	}
}
