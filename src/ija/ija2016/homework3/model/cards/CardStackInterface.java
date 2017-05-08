/**
 * Rozhran� reprezentuj�c� pracujici pole, rozsiruje balicek karet.
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

import java.io.Serializable;

/**
 * rozhrani reprezentujici pracujici pole, rozsiruje balicek karet
 * @author Tomas Holik, xholik13
 */
public interface CardStackInterface extends Serializable, CanAddInterface{
	/**
	 * Vlo�� karty ze z�sobn�ku stack na vrchol z�sobn�ku. Karty vkl�d� ve stejn�m po�ad�, v jak�m jsou uvedeny v z�sobn�ku stack.
	 * @param stack - zasobnik vkladanych karet
	 * @return Usp�nost akce.
	 */
	public abstract boolean put(CardStack stack);
	
	/**
	 * Metoda odebere ze z�sobn�ku sekvenci karet od zadan� karty a� po vrchol z�sobn�ku. Pokud je hledan� karta na vrcholu, bude v sekvenci pouze jedna karta.
	 * @param card - Hledan� karta.
	 * @return Z�sobn�k karet obsahuj�c� odebranou sekvenci. Pokud hledan� karta v z�sobn�ku nen�, vrac� null.
	 */
	public abstract CardStack pop(Card card);

	
	
	public abstract void add(CardDeck deck, int cardsToInsert);
}
