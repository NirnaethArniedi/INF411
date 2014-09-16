class Test1{

	public static void main(String[] args) {
		CountWall countWall = new CountWall(10);
		System.out.println(countWall.allrows);
		countWall = new CountWall(32);
		System.out.println(countWall.allrows.size());
	}

}
