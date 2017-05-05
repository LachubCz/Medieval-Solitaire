/**
 * Abstraktni trida pro factory klondike
 * @author Tom� Hol�k, xholik13
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
 * Abstraktni trida pro factory klondike
 * @author Tom� Hol�k
 */
public abstract class AbstractFactorySolitaire {
	
	/**
	 * Vytv��� objekt reprezentuj�c� bal��ek karet
	 * @return Balicek karet
	 */
	public abstract CardDeck createCardDeck();
	
	/**
	 * Vytvori objekt reprezentujici kartu
	 * @param color - barva karty
	 * @param value - hodnota karty
	 * @return Objekt karty. Pokud je nektery z parametru neplatny (objekt nelze vytvorit), vraci null
	 */
	public abstract Card createCard(Card.Color color, int value);
	
	/**
	 * Vytvari objekt reprezentujici cilovy balicek. Cilem hrace je vlozit vsechny karty zadane barvy do ciloveho balicku.
	 * @param color - zadana barva
	 * @return Cilovy balicek
	 */
	public abstract CardDeck createTargetPack(Card.Color color);
	
	
	public abstract CardStack createSourcePack();
	
	public abstract CardStack createSourcePack(int cardsToInsert);
	
	/**
	 * Vytvari objekt reprezentujici pracovni pole pro karty
	 * @return pracovni pole
	 */
	public abstract CardStack createWorkingPack();
	
	public abstract CardStack createWorkingPack(int cardsToInsert);
}
