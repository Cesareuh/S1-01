import java.util.Scanner;

public class Jeu {
    private PaquetCartes main; 
    private PaquetCartes pioche; 
    private PileCartes[] piles; 

    public PaquetCartes getMain(){
        return main; 
    }

    public PaquetCartes getPioche(){
        return pioche; 
    }

    public PileCartes[] getPiles(){
        return piles; 
    }

    /**
     * Constructeur à partir d'un nombre de cartes défini avec le paramètre max
     * @param max
     */
    public Jeu (int max){
        piles = new PileCartes[4];
        piles[0] = new PileCartes(true, max);
        piles[1] = new PileCartes(true, max);
        piles[2] = new PileCartes(false, max);
        piles[3] = new PileCartes(false, max);

        pioche = new PaquetCartes(); 
        pioche.remplir(max); 
        pioche.melangerPaquet(); 

        main = new PaquetCartes();
        for(int i=0; i<8; i++){
            Carte c = pioche.prendreCarteDessus(); 
            main.insererTri(c);
        }

    }

    /**
     * Constructeur à partir d'un paquet de carte existant
     * @param pc
     */
    public Jeu (PaquetCartes pc){
        /* on ajoute 3 car quand on entre 100 dans le max de cartes, il y aura des cartes de 2 à 99 donc 97 cartes
         Il faut donc ajouter 3 pour retrouver le nombre de cartes qu'on avait entré de bas*/
        int max = pc.getNbCartes() + 3;
        pioche = pc;
        piles = new PileCartes[4];
        piles[0] = new PileCartes(true, max);
        piles[1] = new PileCartes(true, max);
        piles[2] = new PileCartes(false, max);
        piles[3] = new PileCartes(false, max);

        main = new PaquetCartes();
        for(int i=0; i<8; i++){
            Carte c = pioche.prendreCarteDessus(); 
            main.insererTri(c);
        }
    } 

    public String toString(){
        String s = "";
        s += "#####################################\n";
        for(int i = 0; i < 4; i++){
            s += "- PILE " + i + " : " + piles[i] + "\n";
        }
        s += "#####################################\n";
        s += "Reste " + pioche.getNbCartes() + " cartes dans la pioche\n";
        s += "#####################################\n";
        s += "Main du joueur :\n";
        s += main.toString();
        s += "\n#####################################\n";


        return s;
    }

    /**
     * Pose la carte sur la pile donnée si elle est posable
     * @param indice indice de la carte de la main à jouer
     * @param numPile indice de la pile sur laquelle jouer
     * @return
     */
    public boolean jouerCarte(int indice, int numPile){
        boolean b = false; 
        if (piles[numPile].etrePosable(main.getCarte(indice))){
            piles[numPile].poserCarte(main.retirerCarte(indice)); 
            b = true;
        }
        return b;
    }

    /**
     * retourne :
     * 1 : la partie est gagnée
     * 0 : le jeu n'est pas fini
     * -1 : la partie est perdue
     */
    public int etreFini(){
        int fini = 0;

        if(main.etreVide() && pioche.etreVide()){
            fini = 1;
        }

        boolean posable = false;

        // Pour chaque pile, vérifie chaque carte de la main et change la variable posable en vrai si une des carte est posable
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < main.getNbCartes(); j++){
                if(piles[i].etrePosable(main.getCarte(j))) posable = true;
                j++;
            }
        }
        
        if(!posable) fini = -1;

        return fini;
    }

    /**
     * Vérifie si il manque 2 cartes et complète la main en fonction des cartes restantes dans la pioche
     */
    public void completerMain(){
        if(main.getNbCartes()  <= 6){
            if(pioche.getNbCartes() > 1){
                main.insererTri(pioche.prendreCarteDessus());
                main.insererTri(pioche.prendreCarteDessus());
            }else if(pioche.getNbCartes() == 1){
                main.insererTri(pioche.prendreCarteDessus());
            }
        }
    }

    /*
      méthode lancerJeu :


        À faire tant qu'il est possible de jouer :
            afficher l'état du jeu avec toString
            
            
            demander au joueur quelle carte poser
            vérifier si l'index demandé est le bon et afficher une erreur sinon
            demander au joueur quelle pile choisir
            vérifier si l'index demandé est le bon et afficher une erreur sinon
            appeler jouerCarte avec les paramètres acquis précédemment si il n'y a eu aucune erreur

            appeler la fonction completerMain
      
        Afficher si la partie a été perdue ou gagnée
     */

    /**
     * Déroulement du jeu
     */
    public void lancerJeu(){
        Scanner sc = new Scanner(System.in);
        int index_carte;
        int index_pile;
        
        while(etreFini() == 0){
            System.out.println(this);
            
            System.out.println("Quelle carte poser ?\n");
            index_carte = sc.nextInt();

            if(index_carte >= 0 && index_carte < main.getNbCartes()){
                System.out.println("Quelle pile ?\n");
                index_pile = sc.nextInt();

                if(index_pile < 0 || index_pile >= 4){
                    System.out.println("**ERREUR** pile inexistante\n");
                }else{
                    if(!jouerCarte(index_carte, index_pile)){
                        System.out.println("Cette carte ne peut pas être posée sur cette pile\n");
                    }
                }
                
            }else{
                System.out.println("**ERREUR** carte inexistante\n");
            }
            completerMain();
        }

        // Annonce de la victoire ou de la défaite
        if(etreFini() == 1){
            System.out.println("Bravo tu as gagné !!!");
        }else{
            System.out.println("Perdu... Tu feras mieux la prochaine fois !");
        }
    }

    public static void main(String[] args){
        Jeu j = new Jeu(100);
        j.lancerJeu();
    }
}