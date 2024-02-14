/**
 * represente une carte trés simple juste avec une valeur
 */
class Carte{

  /** 
   * la valeur de la carte
   */
  public int valeur;

  /**
   * constructeur de carte
   * 
   * @param val valeur de la carte
   */
  public Carte (int val){
    this.valeur = val;
  }

  /**
   * getter
   */
  public int getValeur(){
    return this.valeur;
  }

  public String toString(){
    return "c"+valeur;
  }

  /**
   * 
   * @param c
   * @return Vrai si la carte en paramètre est plus petite
   */
  public boolean etrePlusGrand(Carte c){
    return valeur > c.getValeur();
  }
  
  /**
   * 
   * @param c
   * @return vrai si a une différence de 10 avec la carte en paramètre
   */
  public boolean avoirDiffDe10(Carte c){
    return (this.valeur-c.valeur==10 || this.valeur-c.valeur==-10);
  }
}
