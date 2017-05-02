/**
 * Rozhraní reprezentující jednu kartu.
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */
package ija.ija2016.homework3.model.cards;

/**
 * Rozhrani reprezentujici jednu kartu. Karta obsahuje informaci o své hodnotì (1 až 13) a barvì. Tyto informace jsou nastaveny konstruktorem. Hodnota 1 reprezentuje eso (ace), 11 až 13 postupnì kluk (jack), královna (queen) a král (king). Barvu definuje výètový typ Color.
 * @author Tomas Holik, xholik13
 *
 */
public interface CardInterface {
	
	/**
	 * @return Hodnota karty
	 */
	public abstract int value();
	  
	/**
	 * Testuje, zda je karta otocena licem nahoru
	 * @return Vysledek testu, true = karta je otocena licem nahoru.
	 */
	public abstract boolean isTurnedFaceUp();
	  
	/**
	 * Otoci kartu licem nahoru. Pokud tak uz je, nedela nic.
	 * @return Informace, zda doslo k otoceni karty (=true) nebo ne
	 */
	public abstract boolean turnFaceUp();
	  
	/**
	 * @return Barva karty
	 */
	public abstract Card.Color color();
	  
	/**
	 * Testuje, zda má karta podobnou barvu jako karta zadaná. Podobnou barvou se myslí èerná (piky, køíže) a èervená (káry a srdce).
	 * @param c - karta pro srovnani
	 * @return Informace o shodì barev karet.
	 */
	public abstract boolean similarColorTo(Card c);
	  
	/**
	 * Porovná hodnotu karty se zadanou kartou c. Pokud jsou stejné, vrací 0. Pokud je karta vìtší než zadaná c, vrací kladný rozdíl hodnot.
	 * @param c - Karta, s kterou se porovnává.
	 * @return Vrací rozdíl hodnot karet.
	 */
	public abstract int compareValue(Card c);
}
