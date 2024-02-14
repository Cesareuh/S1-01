import java.util.Random;

public class PaquetCartes{

    private Carte[] cartes;
    private Random random = new Random();

    /**
     * Constructeur qui crée un paquet vide
     */
    public PaquetCartes(){
        cartes = new Carte[0];
    }

    /**
     * Constructeur qui crée un paquet avec les cartes du paramètre c
     * @param c
     */
    public PaquetCartes(Carte[] c){
        cartes = c;
    }

    public PaquetCartes(int[] tabInt){
        cartes = new Carte[tabInt.length];
        for(int i = 0; i < tabInt.length; i++){
            cartes[i] = new Carte(tabInt[i]);
        }
    }

    /**
     * retourne le nombre de cartes du paquet
     * @return
     */
    public int getNbCartes(){
        return cartes.length;
    }

    /**
     * Retourne la carte à la position place
     * @param place
     * @return
     */
    public Carte getCarte(int place){
        Carte c = null;
        if (place < this.getNbCartes() && place >= 0){
            c = cartes[place];
        }
        return c;
    }

    /**
     * Retourne la dernière carte
     * @return
     */
    public Carte getDerniereCarte(){
        return cartes[cartes.length-1]; 
    }

    /**
     * Renvoie true si le paquet ne contient aucune carte, false sinon
     * @return
     */
    public boolean etreVide(){
        return(cartes.length==0); 
    }

    /**
     * remplit le paquet de cartes avec des cartes allant de 2 jusqu'à max-1
     * @param max
     */
    public void remplir(int max){
        Carte[] new_cartes = new Carte[max-2];
        for(int i = 0; i < new_cartes.length; i++){
            new_cartes[i] = new Carte(i+2);
        }
        cartes = new_cartes;
    }

    /**
     * Retourne une carte au hasard du paquet et la supprime du paquet
     * @return
     */
    private Carte piocherHasard(){
        int r = random.nextInt(cartes.length); 
        Carte c;
        
        if(etreVide()){
            c = null;  
        }else{
            c = getCarte(r); 
            retirerCarte(r);
        }

        return c ; 
    }

    /**
     * Mélange le paquet de cartes pour que les cartes soient dans un ordre aléatoire
     */
    public void melangerPaquet(){
        Carte[] new_cartes = new Carte[cartes.length];
        int i = 0;
        while(!etreVide()){
            new_cartes[i] = piocherHasard();
            i++;
        }
        cartes = new_cartes;
    }

    /**
     * Dans un paquet trié dans l'ordre croissant, insère la carte c au bon endroit pour que l'ordre reste croissant
     * @param c
     */
    public void insererTri(Carte c){
        int indice_carte = 0 ;
        if(getNbCartes() > 0 && c.getValeur() < cartes[cartes.length-1].getValeur()){
            while (c.getValeur() > cartes[indice_carte].getValeur()){
                indice_carte += 1;  
            }
            ajouterCarte(c, indice_carte);
        }else{
            ajouterCarteFin(c); 
        }      
    }

    /**
     * Retourne la carte du paquet et la retire du paquet
     * @return
     */
    public Carte prendreCarteDessus(){
        Carte c; 
        if(!etreVide()){
            c = retirerCarte(0);
        }else{
            c = null; 
        }
        return c; 
    }

    /**
     * Méthode toString qui retourne la chaîne de caractère représentant le paquet
     */
    public String toString(){
        String s = "";
        for(int i = 0; i < cartes.length; i++){
            s += i +  "-" +  getCarte(i) + " ";
        }
        s += "\n";
        return s;
    }

    /*  au dessus fait pendant la SAE
    --------------------------------------------------------------------------------
    en dessous fait pendant le TP11
    */
    public void ajouterCarteDebut(Carte c){
        Carte[] new_cartes = new Carte[cartes.length + 1];

        for(int i = 1; i <= cartes.length; i++){
            new_cartes[i] = cartes[i-1];
        }
        new_cartes[0] = c;

        cartes = new_cartes;
    }

    public void ajouterCarte(Carte c, int place){
        Carte[] new_cartes = new Carte[cartes.length+1];

        for(int i = 0; i < place; i++){
            new_cartes[i] = cartes[i];
        }
        new_cartes[place] = c;

        for(int i = place +1; i < new_cartes.length; i++){
            new_cartes[i] = cartes[i - 1];
        }

        cartes = new_cartes;
    }

    /*
    1. cr´eer un nouveau tableau de taille sup´erieure ;
    2. y recopier les objets cartes de l’attribut cartes ;
    3. ajouter dans la case suppl´ementaire la carte `a ajouter ;
    4. modifier les r´ef´erences pour que l’attribut cartes soit ´egal `a ce nouveau tableau.*/

    public void ajouterCarteFin(Carte c){

        Carte[] new_cartes = new Carte[this.getNbCartes() + 1];

        for(int i = 0; i < this.getNbCartes(); i++){
            new_cartes[i] = this.cartes[i];
        }

        new_cartes[this.getNbCartes()] = c;
        cartes = new_cartes;
    }

    /*
    1. supprimer cette carte du tableau de cartes (en cr´eant un nouveau tableau de taille inf´erieure) ;
    2. et retourner la carte correspondante. Si la place n’est pas correcte, la m´ethode ne fait rien et retourne null.
    */
   public Carte retirerCarte(int place){
    if(place >=0 && place < this.getNbCartes()){
        Carte[] new_cartes = new Carte[cartes.length - 1];
        Carte c = this.getCarte(place);

        for(int i = 0; i < place; i++){
            new_cartes[i]=cartes[i];
        }
        for(int i = place; i < new_cartes.length; i++){
            new_cartes[i]=cartes[i+1];
        }

        cartes = new_cartes;

        return c;
    }
    return null;
   } 
}