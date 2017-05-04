/**
 * Trida vytvarejicic veskere nutne hraci prostredky
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.board;
import ija.ija2016.homework3.model.cards.Card;
import ija.ija2016.homework3.model.cards.CardDeck;
import ija.ija2016.homework3.model.cards.CardDeckInterface;
import ija.ija2016.homework3.model.cards.CardInterface;
import ija.ija2016.homework3.model.cards.CardStack;
import ija.ija2016.homework3.model.cards.CardStackInterface;

/**
 * Trida implementujici abstraktni tridu factory solitaire, vytvari prostredky pro funkcnost klandike
 * @author Tomas Holik, xholik13
 *
 */
public class FactoryKlondike extends AbstractFactorySolitaire {
	
	private CardDeck deck = CardDeck.createStandardDeck();
	



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
	 * Vytváøí objekt reprezentující balíèek karet
	 * @return Balicek karet
	 */
	public CardDeck createCardDeck() {
		CardDeck deck = CardDeck.createStandardDeck();
		return deck;
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
	
	public CardStack createSourcePack() {
		CardStack stack = new CardStack();
		return stack;
	}
	
	public CardStack createSourcePack(int cardsToInsert) {
		CardStack stack = new CardStack();
		stack.add(this.deck, cardsToInsert);
		return stack;
	}

	/**
	 * Vytvari objekt reprezentujici pracovni pole pro karty
	 * @return pracovni pole
	 */
	public CardStack createWorkingPack() {
		CardStack stack = CardStack.createWorkingPack();
		return stack;
	}

	public CardStack createWorkingPack(int cardsToInsert) {
		CardStack stack = CardStack.createWorkingPack();
		stack.add(this.deck, cardsToInsert);
		return stack;
	}

}
