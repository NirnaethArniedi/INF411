import java.util.LinkedList;

public class TestsFunctions {

	static final int M = 10; // les éléments des tableaux sont dans 1..M

	// teste si un tableau t est dans l'ordre
	static boolean is_sorted(Tableau t) {
		for (int i = 1; i < t.length(); i++)
			if (t.compare(i, i-1)<0)
				return false;
		return true;
	}

	// regroupe les occurrences d'un tableau t
	static int[] occurrences(Tableau t) {
		int[] occ = new int[M];
		for (int i = 0; i < t.length(); i++)
			occ[t.get(i)-1]++;
		return occ;
	}

	// teste si deux tableaux ont les mêmes éléments avec les mêmes occurences
	static boolean is_permut(int[] occ1, int[] occ2) {
		for (int i = 0; i < M; i++)
			if (occ1[i] != occ2[i])
				return false;
		return true;
	}

	// affiche un tableau t
	static String print(int[] t) {
		String s = "[";
		for (int i = 0; i < t.length; i++)
			s += (i == 0 ? "" : ", ") + t[i];
		return s + "]";
	}

	// affiche une liste de tableaux
	static String print(LinkedList<int[]> l) {
		String s = "";
		for (int[] t : l)
			s += print(t) + "\n";
		return s;
	}

	// tableau aléatoire (avec éléments dans 1..M)
	static int[] randomArray(int len) {
		int[] t = new int[len];
		for (int i = 0; i < len; i++)
			t[i] = (int) (M * Math.random()) + 1;
		return t;
	}
	
	static boolean are_equal(Tableau t1, Tableau t2){
		if(t1.length()!=t2.length()) return false;
		for(int i=0; i<t1.length(); i++)
			if(t1.get(i)!=t2.get(i)) return false;
		return true;
	}
	
	static void subSort(int[] t, int deb, int fin){
		for(int k=deb; k<fin-1; k++){
			int min=k;
			for(int i=k+1; i<fin; i++)
				if(t[i]<t[min]) min=i;
			int tmp=t[k];
			t[k]=t[min];
			t[min]=tmp;
		}
	}
	
	static int rand(int min, int max){
		return (int)(Math.random()*(max+1-min))+min;
	}
		
	//teste le merge
	static void testMerge(){
		System.out.println("test du merge :\n");
		for (int len = 2; len < 10; len++)
			for (int j = 0; j <= len; j++){
				int[] tab=randomArray(len);
				int l=rand(0,len-2);
				int m=rand(l+1,len-1);
				int r=rand(m+1,len);
				subSort(tab,l,m);
				subSort(tab,m,r);
				Tableau avant=new Tableau(tab);
				Tableau apres=new Tableau(tab);
				MergeSort.merge(apres, l, m, r);
				testMerge(avant,apres,l,m,r);
			}
		System.out.println("SUCCÈS \n");
	}
	
	//teste le merge sur le tableau avant
	static void testMerge(Tableau avant, Tableau apres, int lo, int mi, int hi){
		Tableau ssavt=new Tableau(avant,lo,mi,hi);
		Tableau ssaps=new Tableau(apres,lo,mi,hi);
		Tableau debavt=new Tableau(avant,0,0,lo);
		Tableau debaps=new Tableau(apres,0,0,lo);
		Tableau finavt=new Tableau(avant,hi,hi,avant.length());
		Tableau finaps=new Tableau(apres,hi,hi,apres.length());
		System.out.println("  test avec            t = " + avant+ " lo="+lo+" mi="+mi+" hi="+hi);
		System.out.println("  merge(t,lo,mi,hi) => t = " + apres + "\n");
		if(!are_equal(debavt, debaps) || !are_equal(finavt, finaps)){
			System.out.println("ÉCHEC : les éléments hors de la zone de fusion ont été modifiés");
			System.exit(1);
		}
		int[] occavt=occurrences(ssavt);
		int[] occaps=occurrences(ssaps);
		if(!is_permut(occavt,occaps)){
			System.out.println("ÉCHEC : les éléments dans la zone de fusion diffèrent");
			System.exit(1);
		}
		if(!is_sorted(ssaps)){
			System.out.println("ÉCHEC : la zone de fusion n'est pas triée");
			System.exit(1);
		}
		
	}

	// teste le top-down mergeSort sur le tableau t
	static void testTopDownMergeSortAux(Tableau t) {
		System.out.println("  test avec       t = " + t);
		int[] occ1 = occurrences(t);
		MergeSort.topDownMergeSort(t);
		int[] occ2 = occurrences(t);
		System.out.println("  mergeSort(t) => t = " + t + "\n");
		if (!is_sorted(t)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		if (!is_permut(occ1, occ2)) {
			System.out.println("ÉCHEC : les éléments diffèrent");
			System.exit(1);
		}
	}

	// teste du top-down mergeSort
	static void testTopDownMergeSort() {
		System.out.println("test du top-down mergeSort :\n");
		for (int len = 0; len < 10; len++)
			for (int j = 0; j <= len; j++)
				testTopDownMergeSortAux(new Tableau(randomArray(len)));
		System.out.println("SUCCÈS \n");
	}

	// teste du top-down mergeSort, avec visualisation
	static void testTopDownMergeSortVisual() {
		System.out.print("test du top-down mergeSort : ");
		int[] t = randomArray(10);
		DrawMergeSort d = new DrawMergeSort("top-down merge sort", 400, 400);
		Tableau tab=new Tableau(t,d);
		MergeSort.topDownMergeSort(tab);
		if (!is_sorted(tab)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		System.out.println("SUCCÈS \n");
	}

	// teste le bottom-up mergeSort sur le tableau t
	static void testBottomUpMergeSortAux(int[] t) {
		System.out.println("  test avec       t = " + print(t));
		Tableau tab=new Tableau(t);
		int[] occ1 = occurrences(tab);
		MergeSort.bottomUpMergeSort(tab);
		int[] occ2 = occurrences(tab);
		System.out.println("  mergeSort(t) => t = " + tab + "\n");
		if (!is_sorted(tab)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		if (!is_permut(occ1, occ2)) {
			System.out.println("ÉCHEC : les éléments diffèrent");
			System.exit(1);
		}
	}

	// teste du bottom-up mergeSort
	static void testBottomUpMergeSort() {
		System.out.println("test du bottom-up mergeSort :\n");
		for (int len = 0; len < 10; len++)
			for (int j = 0; j <= len; j++)
				testBottomUpMergeSortAux(randomArray(len));
		System.out.println("SUCCÈS \n");
	}	

	// teste du bottom-up mergeSort, avec visualisation
	static void testBottomUpMergeSortVisual() {
		System.out.print("test du bottom-up mergeSort : ");
		int[] t = randomArray(10);
		DrawMergeSort d = new DrawMergeSort("bottom-up merge sort", 400, 400);
		Tableau tab=new Tableau(t,d);
		MergeSort.bottomUpMergeSort(tab);
		if (!is_sorted(tab)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		System.out.println("SUCCÈS \n");
	}
	
	static void testFindRun(int[] t, int lo, int hi){
		System.out.println("  test avec  t  = " + print(t)+" lo="+lo);
		System.out.println("  findRun(t,lo) = "+ hi);
		for(int i=lo+1; i<hi; i++){
			if(t[i]<t[i-1]){
				System.out.println("ÉCHEC : hi="+hi+" n'est pas correct");
				System.exit(1);
			}
		}
		if(hi<t.length && t[hi]>=t[hi-1]){
			System.out.println("ÉCHEC : hi="+hi+" n'est pas correct");
			System.exit(1);
		}
		System.out.println();
	}
	
	static void testFindRun(){
		System.out.println("test du find run :\n");
		for (int len = 0; len < 10; len++)
			for (int j = 0; j <= len; j++){
				int[] t=randomArray(len);
				int lo=rand(0, len-1);
				int hi=MergeSort.findRun(new Tableau(t), lo);
				testFindRun(t,lo,hi);
			}
		System.out.println("SUCCÈS \n");
	}

	// teste le natural mergeSort sur le tableau t
	static void testNaturalMergeSortAux(int[] t) {
		System.out.println("  test avec       t = " + print(t));
		Tableau tab=new Tableau(t);
		int[] occ1 = occurrences(tab);
		MergeSort.naturalMergeSort(tab);
		int[] occ2 = occurrences(tab);
		System.out.println("  mergeSort(t) => t = " + tab + "\n");
		if (!is_sorted(tab)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		if (!is_permut(occ1, occ2)) {
			System.out.println("ÉCHEC : les éléments diffèrent");
			System.exit(1);
		}
	}

	// teste du natural mergeSort
	static void testNaturalMergeSort() {
		System.out.println("test du natural mergeSort :\n");
		for (int len = 0; len < 10; len++)
			for (int j = 0; j <= len; j++)
				testNaturalMergeSortAux(randomArray(len));
		System.out.println("SUCCÈS \n");
	}

	// teste du natural mergeSort, avec visualisation
	static void testNaturalMergeSortVisual() {
		System.out.print("test du natural mergeSort : ");
		int[] t = randomArray(10);
		DrawMergeSort d = new DrawMergeSort("natural merge sort", 400, 400);
		Tableau tab=new Tableau(t,d);
		MergeSort.naturalMergeSort(tab);
		if (!is_sorted(tab)) {
			System.out.println("ÉCHEC : le résultat n'est pas trié");
			System.exit(1);
		}
		System.out.println("SUCCÈS \n");
	}

	//	// teste la génération exhaustive des permutations par méthode recursive
	//	static void testRecursiveGeneration() {
	//		LinkedList<int[]> perms = GeneratePermutations.recursiveGeneration(4);
	//		System.out.println(perms.size() + " permutations de [0,1,2,3] :");
	//		System.out.println(print(perms));	}
	//
	//	// teste la génération exhaustive des permutations dans l'ordre lexicographique
	//	static void testLexicographicGeneration() {
	//		LinkedList<int[]> perms = GeneratePermutations.lexicographicGeneration(4);
	//		System.out.println(perms.size() + " permutations de [0,1,2,3] :");
	//		System.out.println(print(perms));	}
	//
	//	// teste la génération exhaustive des permutations par chemin hamiltonien, méthode récursive
	//	static void testHamiltonianPathGenerationRec() {
	//		LinkedList<int[]> perms = GeneratePermutations.hamiltonianPathGenerationRec(4);
	//		System.out.println(perms.size() + " permutations de [0,1,2,3]  :");
	//		System.out.println(print(perms));
	//	}
	//
	//	// teste la génération exhaustive des permutations par chemin hamiltonien
	//	static void testHamiltonianPathGeneration() {
	//		LinkedList<int[]> perms = GeneratePermutations.hamiltonianPathGeneration(4);
	//		System.out.println(perms.size() + " permutations de [0,1,2,3]  :");
	//		System.out.println(print(perms));
	//	}
	//
	//	// teste la génération exhaustive des permutations par chemin hamiltonien
	//	static void testPrintHamiltonianPathGeneration() {
	//		GeneratePermutations.printHamiltonianPathGeneration(4);
	//	}
	//
	//	// factorielle
	//	static int factorial(int n) {
	//		if (n == 0) return 1;
	//		else return n*factorial(n-1);
	//	}
	//
	//	// teste la correction des algorithmes de tri fusion sur toutes les permutations de petite taille
	//	static void testAllMergeSort() {
	//		for (int len = 0; len < 6; len++) {
	//			LinkedList<int[]> perms = GeneratePermutations.recursiveGeneration(len);
	//			if (perms.size() != factorial(len)) throw new Error("votre génération des permutations ne fonctionne pas");
	//			for (int[] perm : perms) {
	//				int[] copiePerm = perm.clone();
	//				MergeSortOld.mergeSort(copiePerm);
	//				if (!is_sorted(copiePerm)) System.out.println("ÉCHEC : le résultat n'est pas trié pour " + print(perm));
	//				copiePerm = perm.clone();
	//				MergeSortOld.bottomUpMergeSort(copiePerm);
	//				if (!is_sorted(copiePerm)) System.out.println("ÉCHEC : le résultat n'est pas trié pour " + print(perm));
	//				copiePerm = perm.clone();
	//				MergeSortOld.naturalMergeSort(copiePerm);
	//				if (!is_sorted(copiePerm)) System.out.println("ÉCHEC : le résultat n'est pas trié pour " + print(perm));
	//			}
	//		}
	//		System.out.println("SUCCÈS : vos trois algorithmes de tri fusion fonctionnent sur toutes les permutations de taille 6\n");
	//	}

	// teste les compteurs de comparaison sur les trois algorithmes de tri fusion
	static void testCompteursComparaisons(int n) {
		System.out.println("nombre de comparaisons sur un tableau aléatoire :");
		int[] perm = randomArray(n);
		Tableau tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.topDownMergeSort(tab);
		System.out.println("mergeSort :         " + Tableau.getCompteur());		
		tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.bottomUpMergeSort(tab);
		System.out.println("bottomUpMergeSort : " + Tableau.getCompteur());		
		tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.naturalMergeSort(tab);
		System.out.println("naturalMergeSort :  " + Tableau.getCompteur());		

		System.out.println("\n" + "nombre de comparaisons sur un tableau déjà trié :");
		perm = new int[n];
		for (int i = 0; i < n; i++) perm[i] = i;
		tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.topDownMergeSort(tab);
		System.out.println("mergeSort :         " + Tableau.getCompteur());		
		tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.bottomUpMergeSort(tab);
		System.out.println("bottomUpMergeSort : " + Tableau.getCompteur());		
		tab=new Tableau(perm);
		Tableau.initCompteur();
		MergeSort.naturalMergeSort(tab);
		System.out.println("naturalMergeSort :  " + Tableau.getCompteur());			}
}
