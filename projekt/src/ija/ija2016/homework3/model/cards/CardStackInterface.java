/**
 * Rozhraní reprezentující pracujici pole, rozsiruje balicek karet.
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

/**
 * rozhrani reprezentujici pracujici pole, rozsiruje balicek karet
 * @author Tomas Holik, xholik13
 */
public interface CardStackInterface {
	/**
	 * Vloží karty ze zásobníku stack na vrchol zásobníku. Karty vkládá ve stejném poøadí, v jakém jsou uvedeny v zásobníku stack.
	 * @param stack - zasobnik vkladanych karet
	 * @return Uspìšnost akce.
	 */
	public abstract boolean put(CardStack stack);
	
	/**
	 * Metoda odebere ze zásobníku sekvenci karet od zadané karty až po vrchol zásobníku. Pokud je hledaná karta na vrcholu, bude v sekvenci pouze jedna karta.
	 * @param card - Hledaná karta.
	 * @return Zásobník karet obsahující odebranou sekvenci. Pokud hledaná karta v zásobníku není, vrací null.
	 */
	public abstract CardStack pop(Card card);

	
	
	public abstract void add(CardDeck deck, int cardsToInsert);
}
