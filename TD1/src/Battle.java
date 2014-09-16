
class Battle {
    private Player p1, p2;  // les deux joueurs
    private Deck cards;   // le paquet de cartes
    private static final int NVALS = 13;  // il y a 4*NVALS cartes
    
    private void deal() {
    	Integer c1= this.cards.draw();
    	while(c1!=null){
    		p1.take(c1);
    		p2.take(this.cards.draw());
    		c1=this.cards.draw();
    	}
    }
    	
    public Battle() {
    	this.p1 = new Player();
    	this.p2 = new Player();
    	this.cards = new Deck(NVALS);
    	this.cards.riffleShuffle(7);
    	deal();
    }
    public Battle(Battle b) {
    	this.p1 = new Player(b.p1);
    	this.p2 = new Player(b.p2);;
    }
    
    public boolean equals(Battle b) {
    	if(!this.p1.toString().equals(b.p1.toString())) return false;
    	if(!this.p2.toString().equals(b.p2.toString())) return false;
      	return true;
    }
    
    public void print() {
    	System.out.println("Player 1: "+p1.toString());
    	System.out.println("Player 2: "+p2.toString());
    }
    
    public boolean isOver() {
    	return (p1.hasNoCards() || p2.hasNoCards());
    }
    
    private int winner() {
    	if(!p1.hasNoCards()) return 1;
    	else if(!p2.hasNoCards()) return 2;
    	else return 0;
    }
    
    public void oneRound() {
    	PackOfCards trick = new PackOfCards();
    	if(isOver()) return;
    	int c1=p1.play();
    	int c2=p2.play();
    	trick.add(c1);
    	trick.add(c2);
    	// tirer une carte c1 pour le joueur 1 et une carte c2 pour le joueur 2
            // mettre c1 et c2 dans le pli
    	while (c1 == c2) {
    		if(isOver()) return;
    		trick.add(p1.play());
    		trick.add(p2.play());
    		if(isOver()) return;
    		c1=p1.play();
        	c2=p2.play();
    	}
    	if(c1>c2){
    		p1.takeAll(trick);
    	}
    	else{
    		p2.takeAll(trick);
    	}
            // déterminer le gagnant du pli (selon que c1 < c2 ou c1 > c2)
    	// et lui donner les cartes du pli
    }
    
    public int gameOrigin(int n) {
    	int nbP = 0;
    	while(nbP<n){
    		oneRound();
    		if(isOver()) return winner();
    		nbP++;
    	}
    	//System.out.println("Nombre de plis maximal atteint!");
    	if(p1.nbCards()>p2.nbCards()) return 1;
    	else if(p1.nbCards()<p2.nbCards()) return 2;
    	return 0;
    }
    public int game() {
        Battle turtle=this; // notre tortue
        Battle hare=new Battle(this); // notre lièvre
        while (true){
        turtle.oneRound();
        hare.oneRound();
        hare.oneRound();
        if(hare.isOver()) return hare.winner();
        else if(hare.equals(turtle)) return -1;
        }
    }
}