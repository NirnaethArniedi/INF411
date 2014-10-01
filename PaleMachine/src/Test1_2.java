
public class Test1_2 {


	public static void main(String[] args) {
		BST T =new BST(57);
		T = BST.add(T, 18);
		T = BST.add(T, 228);
		T = BST.add(T, 23);
		T = BST.add(T, 49);
		T = BST.add(T, 11);
		T = BST.add(T, 20);
		T = BST.add(T, 139);
		T = BST.add(T, 252);
		T = BST.add(T, 124);

		BST W = new BST(T, 43, new BST(79));
		BST X = new BST(T, 139, W);
		
		BST A = new BST(2);
		A = new BST(null, 0, A);
		A = new BST(A, 1, new BST(3));
		
		System.out.println("Les arbres A, T, W et X sont-ils des" +
				" arbres binaires de recherche?\n" + BST.isBST(A) + " " +BST.isBST(T) + " "
				+ BST.isBST(W) + " " + BST.isBST(X));
		
	}

}
