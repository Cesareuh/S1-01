import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

public class TestPileCartes {

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        // question 5.1
        PileCartes pile = new PileCartes(true,20);

        // question 5.2
        boolean res = pile.etrePosable(new Carte(15));

        // question 5.3
        boolean res2 = pile.poserCarte(new Carte(13));

        // question 5.5
        Carte c = pile.getDerniereCarte();

    }

    /**
     * Test des constructeurs
     */
    public void test1_constructeur_defaut(){
        PileCartes p = new PileCartes(true);
        PileCartes p2 = new PileCartes(false);

        assertEquals("Doit retourner la même carte que c", 1, p.getDerniereCarte().getValeur());
        assertEquals("Doit retourner la même carte que c2", 100, p2.getDerniereCarte().getValeur());

    }

    public void test2_constructeur_max(){
        int max = 6;
        PileCartes p = new PileCartes(true, max);
        PileCartes p2 = new PileCartes(false, max);

        assertEquals("Doit retourner la même carte que c", 1, p.getDerniereCarte().getValeur());
        assertEquals("Doit retourner la même carte que c2", 6, p2.getDerniereCarte().getValeur());

    }

    /**
     * vérifie si une carte est posable sur une pile croissante
     */
    public void test3_etrePosable_croissant(){
        PileCartes p = new PileCartes(true);
        Carte c = new Carte(20);
        Carte c2 = new Carte(4);
        Carte c3 = new Carte(10);

        assertEquals("La carte c doit être posable sur la pile p", true, p.poserCarte(c));
        assertEquals("La carte c2 ne doit pas être posable sur la pile p", false, p.poserCarte(c2));
        assertEquals("La carte c3 doit être posable sur la pile p", true, p.poserCarte(c3));
    }

    /**
     * vérifie si une carte est posable sur une pile decroissante
     */
    public void test4_etrePosable_decroissant(){
        PileCartes p = new PileCartes(false);
        Carte c = new Carte(81);
        Carte c2 = new Carte(89);
        Carte c3 = new Carte(91);

        assertEquals("La carte c doit être posable sur la pile p", true, p.poserCarte(c));
        assertEquals("La carte c2 ne doit pas être posable sur la pile p", false, p.poserCarte(c2));
        assertEquals("La carte c3 doit être posable sur la pile p", true, p.poserCarte(c3));
    }

    /**
     * lancement des tests
     */
    public static void main(String args[])
    {
        lancer(new TestPileCartes(),args);
    }
}
