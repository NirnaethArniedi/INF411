
public class Test31 {
	public static void main(String[] args) {  // n=taille du jeu, m=nombre de coupes aleatoires
		int n=52, m=100000;
    	double[] hist = new double[n+1];
    	Deck d=new Deck(13);
    	// on calcule m coupes aleatoires selon la loi binomiale
    	for (int i=0; i<m; i++)
    		hist[d.cut()]++;
    	// on calcule la deviation de la distribution obtenue par rapport a la vraie loi binomiale en norme sup
    	double max = 0;
    	for (int i=0; i<n; i++) {
    		// normalisation de la distribution obtenue
    		hist[i] /= m;
    		// calcul du coefficient binomial
    		double coeff = 1;
    		for (int j=1; j<=i; j++)
    			coeff *= (double)(n+1-j)/j/2;
    		coeff /= (long)1<<(n-i);
    		// comparaison avec le nombre d'occurences trouve
    		max = Math.max(max, (double)Math.abs(coeff-hist[i]));
    	}
    	System.out.println("Deviation from binomial law: " + max);
    }
}
