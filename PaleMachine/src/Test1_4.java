import java.util.LinkedList;

public class Test1_4 {
		
	public static void main(String[] args){
		
		System.out.println("Arbre parfait de hauteur 0 (un unique sommet).");
		BST B = new BST(0);
		int[] t = new int[]{0};
		LinkedList<Integer> L =BST.getRootsOfSubtrees(B, t);
		System.out.println("Feuilles rouges: 0. Noeuds verts: " + L);
		t = new int[]{};
		L =BST.getRootsOfSubtrees(B, t);
		System.out.println("Pas de feuilles rouges. Noeuds verts: " + L +"\n");
		
		
		
		BST[] tab = new BST[8];
		for(int i = 0; i<8; i++){
			tab[i] = new BST(new BST(4*i), 4*i + 1 , new BST(4*i+2));
		}
		BST[] tabb = new BST[4];
		for(int i = 0; i<4; i++){
			tabb[i] = new BST(tab[2*i] , 8*i +3 , tab[2*i+1]);
		}
		BST A = new BST(new BST(tabb[0], 7, tabb[1]), 15, new BST(tabb[2], 23, tabb[3]));
		
		System.out.println("Arbre parfait de hauteur 4.");
		
		t = new int[]{0, 2, 12, 24};
		L = new LinkedList<Integer>();
		BST.computeKeys(t, L, A, 0, 2);
		System.out.println("Test computeKeys(t, L, A, 0, 2) avec t = [0, 2, 12, 24]: " + L + "\n");
		
		L = BST.getRootsOfSubtrees(A, t);
		System.out.println("Feuilles rouges: 0, 2, 12, 24. Noeuds verts: " + L);
		

		
		t = new int[]{6, 12, 16, 20, 22};
		L = BST.getRootsOfSubtrees(A, t);
		System.out.println("feuilles rouges: 6, 12, 16, 20, 22. Noeuds verts: "+ L);
		t = new int[]{};
		L = BST.getRootsOfSubtrees(A, t);
		System.out.println("Pas de feuilles rouges. Noeuds verts: "+ L);
		t = new int[]{0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
		L = BST.getRootsOfSubtrees(A, t);
		System.out.println("Toutes les feuilles rouges. Noeuds verts: "+ L);
				

	}
}
