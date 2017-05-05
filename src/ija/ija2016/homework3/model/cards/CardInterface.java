/**
 * Rozhran� reprezentuj�c� jednu kartu.
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */
package ija.ija2016.homework3.model.cards;

/**
 * Rozhrani reprezentujici jednu kartu. Karta obsahuje informaci o sv� hodnot� (1 a� 13) a barv�. Tyto informace jsou nastaveny konstruktorem. Hodnota 1 reprezentuje eso (ace), 11 a� 13 postupn� kluk (jack), kr�lovna (queen) a kr�l (king). Barvu definuje v��tov� typ Color.
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
	 * Testuje, zda m� karta podobnou barvu jako karta zadan�. Podobnou barvou se mysl� �ern� (piky, k��e) a �erven� (k�ry a srdce).
	 * @param c - karta pro srovnani
	 * @return Informace o shod� barev karet.
	 */
	public abstract boolean similarColorTo(Card c);
	  
	/**
	 * Porovn� hodnotu karty se zadanou kartou c. Pokud jsou stejn�, vrac� 0. Pokud je karta v�t�� ne� zadan� c, vrac� kladn� rozd�l hodnot.
	 * @param c - Karta, s kterou se porovn�v�.
	 * @return Vrac� rozd�l hodnot karet.
	 */
	public abstract int compareValue(Card c);
}
