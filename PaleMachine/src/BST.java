import java.util.LinkedList;

public class BST {
	final int value;
	final BST left, right;


	BST(int i){
		this.value = i;
		this.left = this.right = null;
		//throw new Error("A completer.");
	}

	BST(BST l, int i, BST r){
		this.left = l ;
		this.value = i;
		this.right = r;
		//throw new Error("A completer.");
	}

	public boolean isLeaf(){
		return (this.right == null && this.left == null);
		//throw new Error("A completer.");
	}


	public static String BSTToString(BST T){
		if(T==null)
			return "";
		else if(T.isLeaf())
			return(T.value + " ");
		else{
			String sl = BSTToString(T.left);
			String sr = BSTToString(T.right);
			return(sl+T.value+" "+sr);
		}
	}

	public static boolean contains(BST T, int i){
		if(T==null)
			return false;
		int c = T.value - i;
		if(c>0)
			return contains(T.left,i);
		else if(c<0)
			return contains(T.right,i);
		else return true;
		//throw new Error("A completer.");
	}

	public static boolean isBSTBounded(BST T, int min, int max){
		if(T==null)
			return true;
		else if(T.value<=min || T.value>=max)
			return false; // Si T.value est out of Bounds on renvoie Faux
		else 
			return( isBSTBounded(T.left,min,T.value) && isBSTBounded(T.right,T.value,max) ); // sinon on teste si a droite et a gauche on verifie bien la propriete d'arbre binaire de recherche 
		
		//throw new Error("A completer");
	}


	public static boolean isBST(BST T){
		return isBSTBounded(T, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	public static BST perfectBST(int h, int head){
		if(h==0) // a l'etage 0 on a que des feuilles,
			return new BST(head);
		else // on cree un arbre avec a droite et a gauche des arbres de hauteur h-1 avec les valeurs adequates.
			return new BST( perfectBST(h-1,head-(1<<(h-1))) , head , perfectBST(h-1,head+(1<<(h-1))) );
		//throw new Error("A completer.");
	} 

	public static BST perfectBST(int h){
		return perfectBST(h, (1<<h)-1);
		//throw new Error("A completer.");
	}


	// On suppose maintenant que l'on a un arbre binaire de recherche parfait




	public static void computeKeys(int[] t, LinkedList<Integer> L, BST A, int min, int max){
		if(A==null)
			return;
		else if(t.length==0|| t.length == min||max==0||t[max-1]<A.value && t[min]>A.value)
			// on teste plusieurs possibilite : le tableau est vide OU min a pris une valeur egale a la longueur du tableau OU max est nul OU la valeur de A 'est pas comprise entre t[max-1] et t.[min]. Dans tous ces cas on est tombe sur un noeud vert, on ajoute A.value a L.
			L.add(A.value);
		// si les noeuds rouges sont dans les sous arbres de A, on recherche les noeuds verts en changeant les bornes de recherches min et max, en fonction de la valeur en racine de A.
		else{ 
			int m = indexOfClosestAbove(t,A.value);
			int maxL=Math.min(m,max);
			int minR=Math.max(m,min);
			computeKeys(t,L,A.left, min,maxL);
			computeKeys(t,L,A.right, minR,max);
			return;
		}
		//throw new Error("A completer.");
	}

	public static LinkedList<Integer> getRootsOfSubtrees(BST A, int [] t){
		LinkedList<Integer> L = new LinkedList<Integer>();
		if(t==null)
			L.add(A.value);
		else
			computeKeys(t,L,A,0,t.length);
		return L;
	} 


	//*************************************************************
	// ne pas modifier le code fourni en dessous de cette ligne
	//*************************************************************


	public static int indexOfClosestAbove(int[] t, int j){
		int min = 0;
		int max = t.length-1;
		while(min <= max){
			int mid = (min+max)/2;
			if(j == t[mid])
				return mid;
			if(j < t[mid])
				max = mid-1;
			else
				min = mid+1;
		}
		return min;
	}


	public static BST add(BST T, int i){
		if(T ==  null){
			return new BST(i);
		}
		if(i > T.value){
			return new BST(T.left, T.value, add(T.right, i));
		}
		if(i<T.value){
			return new BST(add(T.left, i), T.value, T.right);
		}
		return T;
	}


	static int getMin(BST T){
		BST A = T;
		while(A.left != null){
			A=A.left;
		}
		return A.value;
	}

	public static BST remove(BST T, int i){
		if(T == null){
			return null;
		}
		if(i>T.value){
			return new BST(T.left, T.value, remove(T.right, i));
		}
		if(i<T.value){
			return new BST(remove(T.left, i), T.value, T.right);
		}
		if(T.right == null){
			return T.left;
		}
		return new BST(T.left, getMin(T.right), removeMin(T.right));

	}

	public static BST removeMin(BST T){
		if(T == null){
			return null;
		}
		if(T.left == null){
			return T.right;
		}
		return new BST(removeMin(T.left), T.value, T.right);
	}



}
