/**
 * Trida reprezentujici hraci balicek
 * @author Tom� Hol�k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package model.cards;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Trida reprezentujici hraci balicek
 * @author Tomas Holik, xholik13
 */
public class CardDeck implements CardDeckInterface 
{
	public ArrayList<Card> karty;
	private Card.Color color;
  
	public CardDeck(Card.Color color) 
	{
		this.color = color;
		this.karty = new ArrayList<Card>(13);
	}
	
	/**
	 * Konstruktor vytvarejici balicek karet
	 * @param size - velikost balicku
	 */
	public CardDeck(int size) 
	{
    
		if (size % 4 != 0) {
			throw new IllegalArgumentException("Size has to be divisible by 4");
		}
    
		int numberofeachcard = size / 4;
    
		Set<Card> cardDeck = new HashSet<Card>();
    
		for (int i = 1; i <= numberofeachcard; i++) cardDeck.add(new Card(Card.Color.CLUBS, i));
		for (int i = 1; i <= numberofeachcard; i++) cardDeck.add(new Card(Card.Color.DIAMONDS, i));
		for (int i = 1; i <= numberofeachcard; i++) cardDeck.add(new Card(Card.Color.HEARTS, i));
		for (int i = 1; i <= numberofeachcard; i++) cardDeck.add(new Card(Card.Color.SPADES, i));
    
		this.color = null;
		this.karty = new ArrayList<Card>(size);
		this.karty.addAll(cardDeck);
	}
  
	/**
	 * Kontruktor vytvarejici standartni balicek karet
	 * @return balicek o velikosti 52 karet, kazda 13 karet
	 */
	public static CardDeck createStandardDeck() 
	{
		CardDeck balicek = new CardDeck(52);
		balicek.color = null;
    
		return balicek;
	}
	
	/**
	 * Vytvari cilovy balicek
	 * @param color - cilova barva
	 * @return Cilovy balicek
	 */
	public static CardDeck createTargetPack(Card.Color color) 
	{
		CardDeck balicek = new CardDeck(color);
		return balicek;
	}
  
	/**
	 * @return velikost balicku
	 */
	public int size() 
	{
		return karty.size();
	}
  
	/**
	 * Vlozi kartu na vrchol balicku
	 * @param card - vkladana karta
	 * @return Uspesnost akce
	 */
	public boolean put(Card card) 
	{
		if(this.color != null) {
			if(this.karty.isEmpty()) {
				if((card.color() == this.color) && (card.value() == 1)) {
					this.karty.add(card);
					return true;
				}
				else {
					return false;
				}
			}
			else if(((this.size()+1) == card.value()) && ((this.color == card.color()))) {
				this.karty.add(card);
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
  
	/**
	 * Odebere kartu z vrcholu balicku. Pokud je balicek prazdny, vraci null
	 * @return Vraci kartu z vrcholu balicku
	 */
	public Card pop() 
	{
		if(this.isEmpty()) {
			return null;
		}
		Card Card = (Card)karty.remove(karty.size() - 1);
    
		return Card;
	}
  
	/**
	 * Vrati kartu z vrcholu zasobniku (karta zustava na zasobnkiku). Pokud je balicek prazdny, vraci null.
	 * @return Karta z vrcholu balicku
	 */
	public Card get() 
	{
		if(this.karty.isEmpty()) {
			return null;
		}
		
		Card card = this.karty.get(this.karty.size()-1);
		
		return card;

	}
    
	/**
	 * Vr�t� kartu na uvedenem indexu. Spodni karta je na indexu 0, vrchol je na indexu size()-1. Pokud je bal��ek pr�zdn�, nebo index mimo rozsah, vrac� null.
	 * @param index - pozice karty v balicku
	 * @return karta na uvedenem indexu
	 */
	public Card get(int index) 
	{
		if((this.karty.isEmpty()) || (index > (this.karty.size()-1)) || (index < 0)) {
			return null;
		}
		Card card = this.karty.get(index);
		return card;
	}
  
	/**
	 * Test, zda je bal��ek karet pr�zdn�.
	 * @return Vrac� true, pokud je bal��ek pr�zdn�.
	 */
	public boolean isEmpty() 
	{
		return this.karty.isEmpty();
	}
}
