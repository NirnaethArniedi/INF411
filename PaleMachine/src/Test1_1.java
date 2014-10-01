
public class Test1_1 {

	public static void main(String[] args) {
	
		BST T =new BST(57);
		
		// Au depart l'arbre T est une feuille
		System.out.println("L'arbre T est-il une feuille? " + T.isLeaf()+ " ");

		// Puis on lui ajoute deux sommets.
		T = BST.add(T, 	18);
		T = BST.add(T, 228);
		
		System.out.println("L'arbre T est-il une feuille? " + T.isLeaf());
		System.out.println("--------------------------");
		
		// Ensuite on lui en ajoute plein d'autres
		T = BST.add(T, 23);
		T = BST.add(T, 49);
		T = BST.add(T, 11);
		T = BST.add(T, 20);
		T = BST.add(T, 139);
		T = BST.add(T, 252);
		T = BST.add(T, 124);
		
		System.out.println("Liste ordonnee des sommets de T:  " + BST.BSTToString(T));
		System.out.println("--------------------------");
		
		System.out.println("La valeur minimale des sommets de T est: " + BST.getMin(T) + " ");
		System.out.println("On retire ce sommet.");
		T = BST.removeMin(T);
		System.out.println("La valeur minimale des sommets de T est: " + BST.getMin(T) + "");
		 
		System.out.println("--------------------------");
		
		// On retire deux sommets a T
		T = BST.remove(T, 228);
		T = BST.remove(T, 419);
		System.out.println("Liste ordonnee des sommets de T:  " + BST.BSTToString(T));
		
		System.out.println("--------------------------");
		System.out.println("L'abre T contient-il les sommets 11, 18 et 124?  "
				+ BST.contains(T, 11) + " " + BST.contains(T,18) + " " + BST.contains(T,124));
	}

}
