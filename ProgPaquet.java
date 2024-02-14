public class ProgPaquet{
    public static void main(String[] args){
        Carte[] tabC = {new Carte(10), new Carte(20)};
        PaquetCartes paq = new PaquetCartes(tabC);
        System.out.println(paq);
        paq.ajouterCarteFin(new Carte(25));
        System.out.println(paq);

        paq.retirerCarte(0);
        System.out.println(paq);

        // question 4.7
        paq.melangerPaquet();
        System.out.println(paq);

        // question  4.8
        paq.insererTri(new Carte(23));



    }
}