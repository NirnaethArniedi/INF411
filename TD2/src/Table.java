import java.util.LinkedList;

class Table {
    final static int M = 5003;
    LinkedList<Triple>[] buckets;

    @SuppressWarnings("unchecked")
    Table() {
        this.buckets = new LinkedList[M]; // ne pas écrire <Triple> ici
        for(int i=0; i<M;i++)
        	this.buckets[i]= new LinkedList<Triple>();
    }
    // calcule une valeur de hachage arbitraire pour la paire (x,y).
    int hashCode(int x, int y) {
    	return 42*x-33*y ;
    }
    
    //renvoie la valeur de hashCode(x,y) modulo M
    int bucket(int x, int y){
    	int buck = hashCode(x,y) % M ;
    	if(buck<0) return buck+M;
    	return buck;
    }
    
    //ajoute une entrée dans la table de hachage
    void add(int x, int y, long r){
    	this.buckets[bucket(x,y)].add(new Triple(x,y,r));
    }
    
    //recherche dans la table une entrée pour le couple (x,y)
    Triple find(int x, int y){
    	int axe = bucket(x,y);
    	int sizeB=this.buckets[axe].size();
    	if(sizeB==0) 
    		return null;
    	for(Triple l:buckets[axe]){
    		if(l.x==x && l.y==y)
    			return l;
    	}
    	return null;
    }
    
}
