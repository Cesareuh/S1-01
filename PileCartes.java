public class PileCartes {
    private boolean croissant;
    private PaquetCartes paquet;

    /**
     * Constructeur d'une pile
     * @param pCroissant pile croissante si vrai
     */
    public PileCartes(boolean pCroissant){
        int max = 100;
        croissant = pCroissant;
        paquet = new PaquetCartes();
        if(croissant){
            paquet.ajouterCarteFin(new Carte(1));
        }else{
            paquet.ajouterCarteFin(new Carte(max));
        }
    }

    /**
     * Constructeur d'une pile
     * @param pCroissant pile croissante si vrai
     * @param max nombre maximum de cartes
     */
    public PileCartes(boolean pCroissant, int max){
        croissant = pCroissant;
        paquet = new PaquetCartes();
        if(croissant){
            paquet.ajouterCarteFin(new Carte(1));
        }else{
            paquet.ajouterCarteFin(new Carte(max));
        }
    }

    /**
     * Vérifie si la carte en paramètre est posable sur la pile
     * @param c
     * @return
     */
    public boolean etrePosable(Carte c){
        boolean b = false;
        if(croissant){
            if(c.etrePlusGrand(paquet.getDerniereCarte()) || c.avoirDiffDe10(paquet.getDerniereCarte())){
                b = true; 
            }
        }else{
            if(paquet.getDerniereCarte().etrePlusGrand(c) || paquet.getDerniereCarte().avoirDiffDe10(c)){
                b = true;
            }
        }
        return b; 
    }

    /**
     * Pose la carte en paramètre sur la pile si elle est posable
     * @param c
     * @return
     */
    public boolean poserCarte(Carte c){
        boolean b = false;
        if(etrePosable(c)){
            paquet.ajouterCarteFin(c);
            b = true;
        }
        return b;  
    }

    /**
     * @return Dernière carte posée sur la pile
     */
    public Carte getDerniereCarte(){
        return paquet.getDerniereCarte();
    }

    /**
     * @return Affiche la classe pile
     */
    public String toString(){
        String s = "";

        if(croissant){
            s += "c";
        }else{
            s += "d";
        }
        s += "-" + getDerniereCarte() + "-" + "(" + paquet.getNbCartes() + ")";

        return s;
    }

    
}
