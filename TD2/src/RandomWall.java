import java.util.LinkedList;

public class RandomWall {
	Integer width; // largeur du mur
	CountWall countWall; // champ contenant la liste des rangées possibles, et permettant de calculer les nombres de murs dont la première rangée est row
	LinkedList<Integer> rows; // liste des rangées du mur, de bas en haut, représentées par des entiers 

	/** fill(row, height) : construit un mur aléatoire uniforme de hauteur height dont la première rangée est row, en stockant les rangées dans rows */
	void fill(int row, int height) {
        this.rows.push(row);
		if(height > 1) {
			// on choisit aléatoirement la ligne suivante avec la distribution de probabilité donnée par la fonction count
			// À COMPLÉTER
			// on tire ensuite récursivement un mur de hauteur height-1 et dont la première ligne est nextRow
			// À COMPLÉTER
		}
	}

	/** randomWall(height) : construit un mur aléatoire uniforme de largeur width et de hauteur height */
	RandomWall(int width, int height) {
		this.width = width;
		this.countWall = new CountWall(width);
		// À COMPLÉTER
	}

	/** toString : affiche un mur aléatoire */
	public String toString() {
		if(this.width == null) throw new Error("Impossible to print a wall without its width!");
		String result = "";
		// À COMPLÉTER
		return result;
	}


}
