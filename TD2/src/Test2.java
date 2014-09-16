class Test2{

	public static void main(String[] args) {
		int width = 9;
		CountWall c = new CountWall(width);
		Integer a = 72;

		System.out.println("Liste des rangees de largeur " + width + " : ");
		System.out.println(c.allrows + " " + "\n");
		System.out.println("Nombre de murs de largeur " + width + ", de hauteur 6, et commencant par la rangee " + a + " : ");
		System.out.println(c.count(a, 6));
	}

}
