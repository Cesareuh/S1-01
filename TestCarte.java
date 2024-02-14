import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Carte
 * fonctionne correctement
 */
public class TestCarte {

	/**
	 * methode de lancement des tests
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestCarte(), args);
	}

    /**
     * test des methodes
     */
    public void test_0_verifieMethodes(){
        Carte c = new Carte(10);
        Carte c2 = new Carte(20);

        int v = c.getValeur();
        String s = c.toString();

        boolean res = c.etrePlusGrand(c2);
        boolean diff = c.avoirDiffDe10(c2);
    }

	/**
	 * test du constructeur
	 */
	@Test
	public void test1_constructeur() {
		Carte c = new Carte(1);
		assertEquals("La carte doit avoir la valeur 1", 1, c.valeur);
	}

    /**
     * Test du toString
     */
    @Test
    public void test2_toString(){
        Carte c = new Carte(2);
        assertEquals("Doit retourner c2", "c2", c.toString());
    }

    /**
     * Test de la diff de 10 vrai
     */
    @Test
    public void test3_avoirDiffDe10_true(){
        Carte c1 = new Carte(2);
        Carte c2 = new Carte(12);

        assertEquals("Doit retourner true", true, c1.avoirDiffDe10(c2));
        assertEquals("Doit retourner true", true, c2.avoirDiffDe10(c1));
    }

    /**
     * Test de la diff de 10 faux si la diff est inférieure à 10
     */
    @Test
    public void test3_avoirDiffDe10_false1(){
        Carte c1 = new Carte(3);
        Carte c2 = new Carte(12);

        assertEquals("Doit retourner true", false, c1.avoirDiffDe10(c2));
        assertEquals("Doit retourner true", false, c2.avoirDiffDe10(c1));
    }


    /**
     * Test de la diff de 10 faux si la diff est supérieure à 10
     */
    @Test
    public void test3_avoirDiffDe10_false2(){
        Carte c1 = new Carte(1);
        Carte c2 = new Carte(12);

        assertEquals("Doit retourner true", false, c1.avoirDiffDe10(c2));
        assertEquals("Doit retourner true", false, c2.avoirDiffDe10(c1));
    }


}
