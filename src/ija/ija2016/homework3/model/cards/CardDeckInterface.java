/**
 * Rozhran� reprezentuj�c� balicek karet.
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

/**
 * Rozhrani reprezentujici balicek karet.
 * @author Tomas Holik, xholik13
 */
public interface CardDeckInterface {
	
	/**
	 * Vr�t� kartu z vrcholu z�sobn�ku (karta z�st�v� na z�sobn�ku). Pokud je bal��ek pr�zdn�, vrac� null.
	 * @return Karta z vrcholu bal��ku.
	 */
	public abstract Card get();
	  
	/**
	 * Vr�t� kartu na uvedenem indexu. Spodni karta je na indexu 0, vrchol je na indexu size()-1. Pokud je bal��ek pr�zdn�, nebo index mimo rozsah, vrac� null.
	 * @param i - Pozice karty v balicku.
	 * @return Karta z vrcholu bal��ku.
	 */
	public abstract Card get(int i);
	  
	/**
	 * Test, zda je bal��ek karet pr�zdn�.
	 * @return Vrac� true, pokud je bal��ek pr�zdn�.
	 */
	public abstract boolean isEmpty();
	  
	/**
	 * Odebere kartu z vrcholu bal��ku. Pokud je bal��ek pr�zdn�, vrac� null.
	 * @return Karta z vrcholu balicku
	 */
	public abstract Card pop();
	  
	/**
	 * Vlo�� kartu na vrchol bal��ku.
	 * @param c - vkladana karta
	 * @return Uspesnost akce
	 */
	public abstract boolean put(Card c);
	  
	/**
	 * @return Aktualni pocet karet v balicku
	 */
	public abstract int size();
}
