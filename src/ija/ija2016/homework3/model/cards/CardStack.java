/**
 * Trida reprezentujĂ­cĂ­ pracujici pole.
 * @author TomĂˇĹˇ HolĂ­k, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

import java.util.ArrayList;
import java.util.Objects;


public class CardStack implements CardStackInterface 
{
	private CardDeck source = new CardDeck(); 
	private ArrayList<Card> karty;
	private int capacity;
	private Card Cardcolor;
        
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
        
        public void emplaceStack(Card pop) {
            this.karty.add(pop);
        }
	
	public void InitPut(Card card)		
	{		
		this.Cardcolor = new Card(card.color(), 13);		
		this.karty.add(card);		
	}
        
        
	
	/**
	 * Konstruktor pro vytvoreni pracujiciho pole o velikosti 13
	 * @return Pracujici pole
	 */
	public static CardStack createWorkingPack() 
	{
		CardStack stack = new CardStack(19);
		return stack;
	}
	
	/**
	 * Vlozi kartu na vrchol balicku
	 * @param card - vkladana karta
	 * @return Uspesnost akce
	 */
	public boolean put(Card card) 
	{
		if((this.isEmpty()) && (card.value() == 13)) {
			this.Cardcolor = new Card(card.color(), 13);
				this.karty.add(card);
				return true;
		}
		
		if (!this.isEmpty())
		{
			if((this.CanPut() == card.value()) && (this.Cardcolor != null)) {
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
		else {
			return false;
		}
	}
	
	public int CanPutStack()
	{
		Card card = (Card)karty.get(karty.size() - 1);
		return (card.value() - 1); 
	}
	
	public boolean canPutCard(Card card) 
	{
		if((this.isEmpty()) && (card.value() == 13)) {
				return true;
		}
		
		if (!this.isEmpty())
		{
			if((this.CanPutStack() == card.value()) && (this.Cardcolor != null)) {
				 if(!(card.similarColorTo(this.Cardcolor))) {
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
		else {
			return false;
		}
	}
	
	public Card getFromStack(int index)
	{
		if (!this.karty.isEmpty())
			return this.karty.get(index);
		else
			return null;
	}
		
	/**
	 * VloĹľĂ­ karty ze zĂˇsobnĂ­ku stack na vrchol zĂˇsobnĂ­ku. Karty vklĂˇdĂˇ ve stejnĂ©m poĂ¸adĂ­, v jakĂ©m jsou uvedeny v zĂˇsobnĂ­ku stack.
	 * @param stack - ZĂˇsobnĂ­k vklĂˇdanĂ˝ch karet.
	 * @return UspĂ¬Ĺˇnost akce.
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
	
    public Card topStack() {
    	if(!this.karty.isEmpty())
    		return this.karty.get(this.karty.size()-1);
    	return null;
    }
    
	/**
	* Test, zda je balĂ­Ă¨ek karet prĂˇzdnĂ˝.
	* @return VracĂ­ true, pokud je balĂ­Ă¨ek prĂˇzdnĂ˝.
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
	
    public Card getStack(int index) {
        return this.karty.get(index);
    }
	
	public int CanPut()
	{
		Card card = (Card)karty.get(karty.size() - 1);
		return (card.value() - 1); 
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
		
		if(this.isEmpty())		
		{		
			return Card;		
		}		
		else		
		{		
			Card Temp = (Card)karty.remove(karty.size() - 1);		
			Temp.turnFaceUp();		
			this.InitPut(Temp);		
		}		
		
		return Card;
	}
	
	/**
	 * Metoda odebere ze zĂˇsobnĂ­ku sekvenci karet od zadanĂ© karty aĹľ po vrchol zĂˇsobnĂ­ku. Pokud je hledanĂˇ karta na vrcholu, bude v sekvenci pouze jedna karta.
	 * @param card - HledanĂˇ karta.
	 * @return ZĂˇsobnĂ­k karet obsahujĂ­cĂ­ odebranou sekvenci. Pokud hledanĂˇ karta v zĂˇsobnĂ­ku nenĂ­, vracĂ­ null
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

    //funkce pracujici se stack
    public boolean showNext() {
        if(this.size() > 0) {
            Card card = this.karty.remove(this.size() - 1);
            card.turnFaceUp();
            return this.source.karty.add(card);
        }
        return false;
    }

    //funkce pracujici se stack
    public boolean hideTopCard() {
        if(!this.source.karty.isEmpty()) {
            Card card = this.source.karty.remove(this.karty.size() - 1);
            card.turnFaceDown();
            return this.karty.add(card);
        }
        return false;
    }

    //funkce pracujici se stack
    public boolean MoveBackToStack() {
        if(this.sizeOfStack() == 0) {
            for(int i = this.source.size() - 1; i >= 0; i--) {
                this.karty.add(this.source.karty.remove(i));
                this.karty.get(this.sizeOfStack() - 1).turnFaceDown();
            }
        }
        return false;
    }
    
    //funkce pracujici se stack
    public int sizeOfStack() {
        return this.size();
    }
    


    
    //na zbytek funkci pouzit funkce z CardDeck
    public CardDeck getDeck() {
        return this.source;
    }
    
    public boolean isSourceEmpty() {
        return this.source.isEmpty();
    }
    
    public Card get(int index) {
        return this.source.get(index);
    }

    public void emplace(Card remove) {
        this.source.emplace(remove);
    }

    public Card top() {
        return this.source.top();
    }

    public boolean canPut(Card card) {
        return this.source.canPut(card);
    }

    public boolean contains(Card card) {
        return this.source.contains(card);
    }
    
    
}
