/**
 * Rozhraní reprezentující balicek karet.
 * @author Tomáš Holík, xholik13
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
	 * Vrátí kartu z vrcholu zásobníku (karta zùstává na zásobníku). Pokud je balíèek prázdný, vrací null.
	 * @return Karta z vrcholu balíèku.
	 */
	public abstract Card get();
	  
	/**
	 * Vrátí kartu na uvedenem indexu. Spodni karta je na indexu 0, vrchol je na indexu size()-1. Pokud je balíèek prázdný, nebo index mimo rozsah, vrací null.
	 * @param i - Pozice karty v balicku.
	 * @return Karta z vrcholu balíèku.
	 */
	public abstract Card get(int i);
	  
	/**
	 * Test, zda je balíèek karet prázdný.
	 * @return Vrací true, pokud je balíèek prázdný.
	 */
	public abstract boolean isEmpty();
	  
	/**
	 * Odebere kartu z vrcholu balíèku. Pokud je balíèek prázdný, vrací null.
	 * @return Karta z vrcholu balicku
	 */
	public abstract Card pop();
	  
	/**
	 * Vloží kartu na vrchol balíèku.
	 * @param c - vkladana karta
	 * @return Uspesnost akce
	 */
	public abstract boolean put(Card c);
	  
	/**
	 * @return Aktualni pocet karet v balicku
	 */
	public abstract int size();
}
