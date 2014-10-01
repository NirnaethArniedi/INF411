
public class Test1_3 {
	
	public static int height(BST T){
			if(T == null){
				return 0;
			}
			return 1+(int)(Math.max(height(T.left), height(T.right)));
		}

		public static boolean isBalanced(BST T){
			if(T == null){
				return true;
			}
			return (height(T.left) == height(T.right)) && isBalanced(T.left) && isBalanced(T.right);
		}
		
	public static void main(String[] args) {
		BST A = BST.perfectBST(2);
		System.out.println("On construit un arbre parfait de hauteur 2.");
		System.out.println("Est-il equilibre?  " + isBalanced(A)+"");
		System.out.println("Liste ordonnee de ses sommets:  " + BST.BSTToString(A));
		System.out.println("----------------------------");
		System.out.println("On construit un arbre parfait de hauteur 4.");		
		BST B = BST.perfectBST(4);
		System.out.println("Est-il equilibre?  " + isBalanced(B)+"");
		System.out.println("Liste ordonnee de ses sommets:  " + BST.BSTToString(B));
	}

}
