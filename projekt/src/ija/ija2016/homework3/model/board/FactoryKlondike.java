/**
 * Trida vytvarejicic veskere nutne hraci prostredky
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.board;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardStack;

/**
 * Trida implementujici abstraktni tridu factory solitaire, vytvari prostredky pro funkcnost klandike
 * @author Tomas Holik, xholik13
 *
 */
public class FactoryKlondike extends AbstractFactorySolitaire {

	/**
	 * Vytváøí objekt reprezentující balíèek karet
	 * @return Balicek karet
	 */
	public CardDeck createCardDeck() {
		CardDeck deck = CardDeck.createStandardDeck();
		return deck;
	}

	/**
	 * Vytvori objekt reprezentujici kartu
	 * @param color - barva karty
	 * @param value - hodnota karty
	 * @return Objekt karty. Pokud je nektery z parametru neplatny (objekt nelze vytvorit), vraci null
	 */
	public Card createCard(Card.Color color, int value) {
		if(value > 13 || value < 1) {
			return null;
		}
		else {
			Card card = new Card(color, value);
			return card;
		}

	}

	/**
	 * Vytvari objekt reprezentujici cilovy balicek. Cilem hrace je vlozit vsechny karty zadane barvy do ciloveho balicku.
	 * @param color - Zadana barva
	 * @return Cilovy balicek
	 */
	public CardDeck createTargetPack(Card.Color color) {
		CardDeck deck = CardDeck.createTargetPack(color);
		return deck;
	}

	/**
	 * Vytvari objekt reprezentujici pracovni pole pro karty
	 * @return pracovni pole
	 */
	public CardStack createWorkingPack() {
		CardStack stack = CardStack.createWorkingPack();
		return stack;
	}

}
