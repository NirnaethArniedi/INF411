class Test4{

	public static void main(String[] args) {
		Table t = new Table();
		System.out.println(t.find(1,2));
		t.add(1,2,3);
		t.add(17,23,42);
		System.out.println(t.find(1,2).result);
		System.out.println(t.find(1,3));
		System.out.println(t.find(17,23).result);
	}



}
