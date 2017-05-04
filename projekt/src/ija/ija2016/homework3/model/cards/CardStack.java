/**
 * Trida reprezentující pracujici pole.
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

import java.util.ArrayList;
import java.util.Objects;


public class CardStack implements CardStackInterface 
{
	
	private ArrayList<Card> karty;
	private int capacity;
	private Card Cardcolor;
	
	/**
	 * Konstruktor pro vytvoreni pracujiciho pole
	 * @param size - velikost pole
	 */
	public CardStack() 
	{
		this.capacity = 52;
		this.Cardcolor = null;
		this.karty = new ArrayList<Card>(52);
	}

	/**
	 * Konstruktor pro vytvoreni pracujiciho pole
	 * @param size - velikost pole
	 */
	public CardStack(int size) 
	{
		this.capacity = size;
		this.Cardcolor = null;
		this.karty = new ArrayList<Card>(size);
	}
	
	/**
	 * Konstruktor pro vytvoreni pracujiciho pole o velikosti 13
	 * @return Pracujici pole
	 */
	public static CardStack createWorkingPack() 
	{
		CardStack stack = new CardStack(13);
		return stack;
	}
	
	/**
	 * Vlozi kartu na vrchol balicku
	 * @param card - vkladana karta
	 * @return Uspesnost akce
	 */
	public boolean put(Card card) 
	{
		if((this.Cardcolor == null) && (this.isEmpty()) && (card.value() == 13)) {
			this.Cardcolor = new Card(card.color(), 13);
				this.karty.add(card);
				return true;
		}
		
		if(((this.capacity - (this.size())) == card.value()) && (this.Cardcolor != null)) {
			 if(!(card.similarColorTo(this.Cardcolor))) {
				this.Cardcolor = new Card(card.color(), 13);
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
	 * Vloží karty ze zásobníku stack na vrchol zásobníku. Karty vkládá ve stejném poøadí, v jakém jsou uvedeny v zásobníku stack.
	 * @param stack - Zásobník vkládaných karet.
	 * @return Uspìšnost akce.
	*/
	public boolean put(CardStack stack) 
	{
		if((stack == null) || (stack.isEmpty() == true) || this.isEmpty()) {
			return false;
		}
		karty.addAll(stack.karty);
		stack.karty.clear();
		return true;
	}
	
	  
	/**
	* Test, zda je balíèek karet prázdný.
	* @return Vrací true, pokud je balíèek prázdný.
	*/
	public boolean isEmpty() 
	{
		return this.karty.isEmpty();
	}
	
	/**
	 * @return velikost balicku
	 */
	public int size() 
	{
		return this.karty.size();
	}
	
	/**
	 * Odebere kartu z vrcholu balicku. Pokud je balicek prazdny, vraci null
	 * @return Vraci kartu z vrcholu balicku
	 */
	public Card pop() {
		if(this.isEmpty()) {
			return null;
		}
		Card Card = (Card)karty.remove(karty.size() - 1);
	    
		return Card;
	}
	
	/**
	 * Metoda odebere ze zásobníku sekvenci karet od zadané karty až po vrchol zásobníku. Pokud je hledaná karta na vrcholu, bude v sekvenci pouze jedna karta.
	 * @param card - Hledaná karta.
	 * @return Zásobník karet obsahující odebranou sekvenci. Pokud hledaná karta v zásobníku není, vrací null
	 */
	public CardStack pop(Card card) 
	{
		int lastindex = this.karty.lastIndexOf(card);
		
		if(lastindex == -1) {
			return null;
		}
		
		CardStack pomocny = new CardStack(this.size());
		
		if(lastindex == (this.karty.size()-1)) {
			pomocny.karty.add(this.karty.get(this.size()-1));
		}
		else {
			pomocny.karty.addAll((this.karty.subList(lastindex, this.size())));
		}

		
		if(lastindex == (this.karty.size()-1)) {
			this.karty.remove(lastindex);
		}
		else {
			this.karty.subList(lastindex, this.karty.size()).clear();
		}
		
		return pomocny;
	}
	
	public void add(CardDeck deck, int count) {
		if(count > this.capacity - this.size()) {
			throw new IllegalArgumentException("Not enough space in the stack");
		}
		if(count > deck.size()) {
			throw new IllegalArgumentException("Deck does not have enough cards");
		}
		for(;count > 0; count--) {
			this.karty.add(deck.pop());
		}
	}
	
	/**
	 * Prepise metodu equals, pro korektni kontrolu podobnosti objektu
	 */
	@Override
	public boolean equals(Object obj) 
	{
		
		if(obj == this) return true;
		if(!(obj instanceof CardStack)) {
			return false;
		}
		CardStack stack = (CardStack)obj;
		if(this.karty.isEmpty() != stack.karty.isEmpty()) {
			return false; 
		}
		if(this.karty.size() != stack.karty.size()) {
			return false;
		}
		if(this.capacity != stack.capacity) {
			return false;
		}
		if(!(stack.karty.containsAll(this.karty))) {
			return false;
		}
		return true;
	}
	
	/**
	 * Prepsani metody hashCode, nutnost pri prepsani equals
	 * @return true= hash hodnota
	 */
	@Override
	public int hashCode() 
	{
		return Objects.hash(karty, capacity);
	}
}
