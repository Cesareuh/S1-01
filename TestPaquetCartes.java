import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Paquet
 * fonctionne correctement
 */
public class TestPaquetCartes {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPaquetCartes(), args);
	}

	    /**
     * test des methodes
     */
    public void test_0_verifieMethodes() {
        // Question 4.1
        Carte[] tabC = {new Carte(10), new Carte(20)};
        PaquetCartes paq = new PaquetCartes(tabC);
        paq.ajouterCarteFin(new Carte(25));
        paq.retirerCarte(0);

        // Question 4.2
        PaquetCartes paq2 = new PaquetCartes();

        // Question 4.3
        paq2.remplir(20);

        // Question 4.4
        int tabInt[] = {10,20,30,40,50};
        PaquetCartes paq3 = new PaquetCartes(tabInt);

        // Question 4.5
        Carte c = paq.getCarte(0);
        Carte c2 = paq.getDerniereCarte();
        int nb = paq.getNbCartes();
        boolean vide = paq.etreVide();

        // question 4.7
        paq.melangerPaquet();

        // question  4.8
        paq.insererTri(new Carte(23));

        // question  4.9
        Carte c3 = paq.prendreCarteDessus();

    }
	
	/**
	 * test du constructeur vide
	 */
	@Test
	public void test1_constructeur() {
		PaquetCartes paquet = new PaquetCartes();
		assertEquals("paquet devrait avoir 0 carte", 0, paquet.getNbCartes());
	}

	/**
	 * test du constructeur parametres
	 */
	@Test
	public void test2_constructeurParam() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());
	}


        /**
	 * test getCarte
	 */
	@Test
	public void test3_getCarte_ok() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(1);
		assertEquals("la carte 1 a pour valeur 2", 2, c.getValeur());
	}

	/**
	 * test getCarte hors tableau
	 */
	@Test
	public void test4_getCarte_horsTableau() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		assertEquals("paquet devrait avoir 3 cartes", 3, paquet.getNbCartes());

                Carte c = paquet.getCarte(3);
		assertEquals("la carte 3 n'existe pas", null, c);
	}

	/**
	 * test ajoutCarteFin ok
	 */
	@Test
	public void test5_ajoutCarteFin() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		paquet.ajouterCarteFin(new Carte(4));

		assertEquals("paquet devrait avoir 4 cartes", 4, paquet.getNbCartes());

                // chaque carte doit etre bien placee: place i => valeur i+1
                for (int i=0;i<3;i++) {
			Carte c = paquet.getCarte(i);
			assertEquals("la carte "+i+"a pour valeur"+(i+1), i+1, c.getValeur());	
		}
		
	}

	/**
	 * test retirerCarte ok
	 */
	@Test
	public void test6_retirerCarte() {
		Carte[] tab = new Carte[3];
		tab[0] = new Carte(1);
		tab[1] = new Carte(2);
		tab[2] = new Carte(3);
					
		PaquetCartes paquet = new PaquetCartes(tab);
		Carte c = paquet.retirerCarte(1);
		
		// test paquet
		assertEquals("paquet devrait avoir 2 cartes", 2, paquet.getNbCartes());
		assertEquals("premiere carte valeur 1", 1, paquet.getCarte(0).valeur);
		assertEquals("seconde carte valeur 3", 3, paquet.getCarte(1).valeur);
			
		// test carte retournee
		assertEquals("carte retiree a pour valeur 2", 2, c.getValeur());
  
		
	}


	/* au dessus fait pendant le tp11
	 * ------------------------------------------------------------------
	  en dessous fait pendant la SAÉ */



	/**
	 * Test pour la méthode remplir
	 */

	 @Test
	 public void test7_remplir(){
		PaquetCartes p = new PaquetCartes();
		p.remplir(100);
		for(int i = 0; i < 98; i++){
			int val_carte = i +2;
			assertEquals("la carte" + i + " devrait être égale à " + val_carte, val_carte, p.getCarte(i).getValeur());
		}
	 }

	/**
	 * Test pour voir si la dernière carte est la bonne
	 */
	@Test
	public void test8_getDerniereCarte(){
		PaquetCartes p = new PaquetCartes();
		p.remplir(100);
		assertEquals("Devrait retourner 99 qui est la dernière carte", 99, p.getDerniereCarte().getValeur());
	}

	/**
	 * Test la méthode etreVide si il n'y a pas de carte
	 */
	@Test
	public void test9_etreVide(){
		PaquetCartes p = new PaquetCartes();
		assertEquals("Le paquet doit être vide", true, p.etreVide());
	}

	/**
	 * Test la méthode etreVide si il y a au moins une carte
	 */
	@Test
	public void test9_etreVide2(){
		PaquetCartes p = new PaquetCartes();
		p.remplir(10);
		assertEquals("Le paquet ne doit pas être vide", false, p.etreVide());
	}
	
	/**
	 * Test de l'insertion d'une carte dans l'ordre
	 */
	@Test
	public void test10_insererTri(){
		PaquetCartes p = new PaquetCartes();
		p.remplir(100);
		int taille_ini = p.getNbCartes();

		p.insererTri(new Carte(10));
		assertEquals("Le paquet devrait être plus grand de 1", taille_ini+1, p.getNbCartes());

		for(int i = 1; i < p.getNbCartes(); i++){
			assertEquals("La carte précédente doit être plus petite ou égale", true, p.getCarte(i - 1).getValeur() <= p.getCarte(i).getValeur());
		}
	}

	/**
	 * Test de l'insertion d'une carte dans l'ordre quand la pile est vide
	 */
	@Test
	public void test11_insererTri_vide(){
		PaquetCartes p = new PaquetCartes();
		int taille_ini = p.getNbCartes();

		p.insererTri(new Carte(10));
		assertEquals("Le paquet devrait être plus grand de 1", taille_ini+1, p.getNbCartes());
	}

	/**
	 * Test prendre la premiere carte
	 */
	@Test
	public void test12_prendreCarteDessus(){
		PaquetCartes p = new PaquetCartes();
		p.remplir(10);

		Carte c = p.getCarte(0);
		assertEquals("La carte retournée devrait être la première du paquet", c, p.prendreCarteDessus());
	}
	
	/**
	 * Test prendre la premiere carte paquet vide
	 */
	@Test
	public void test13_prendreCarteDessus_vide(){
		PaquetCartes p = new PaquetCartes();

		assertEquals("La carte retournée devrait être la première du paquet", null, p.prendreCarteDessus());
	}
	
}
