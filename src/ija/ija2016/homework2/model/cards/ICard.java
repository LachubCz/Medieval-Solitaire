/**
 * Rozhraní reprezentující jednu kartu.
 * @author Tomáš Holík, xholik13
 * @author Petr Buchal, xbucha02
 * @version 0.2
 */

package ija.ija2016.homework3.model.cards;

import java.util.Objects;

/**
 * Trida reprezentujici jednu kartu, implementuje rozhrani CardInterface. Karta obsahuje informaci o své hodnotì (1 až 13) a barvì. Tyto informace jsou nastaveny konstruktorem. Hodnota 1 reprezentuje eso (ace), 11 až 13 postupnì kluk (jack), královna (queen) a král (king). Barvu definuje výètový typ Color.
 * @author Holajz
 */
public class Card implements CardInterface {
	private final Card.Color barva;
	private final int value;
	private boolean isturned;
	
	  
	/**
	 * Konstruktor pro vytvoreni karty
	 * @param c - barva karty
	 * @param value - hodnota karty
	 */
	public Card(Card.Color c, int value) {
			this.isturned = false;
			this.barva = c;
			this.value = value;
	}
		
	/**
	 * Vyctovy typ reprezentujici barvu karty
	 * @author Tomas Holik
	 *
	 */
	public static enum Color {
		SPADES("S"), DIAMONDS("D"), HEARTS("H"), CLUBS("C");
			
		private String type;
		//pri zavolani Color se automaticky ulozi SPADES jako "S"
		//enum.valueOf() - implicitni metoda - pri zavolani valueof("S")
		// vrati hodnotu stringu
		//enum.values() - implicitni metoda - vrati vsechny instance enumu
		private Color(String typ) {
			this.type = typ;
		}
			
		@Override
		public String toString() {
			return this.type;
		}
	}
	
	/**
	 * @return Hodnota karty
	 */
	public int value() {
		return this.value;
	}
	  
	/**
	 * Testuje, zda je karta otocena licem nahoru
	 * @return Vysledek testu, true = karta je otocena licem nahoru.
	 */
	public boolean isTurnedFaceUp() {
		return this.isturned;
	}
	  
	/**
	 * Otoci kartu licem nahoru. Pokud tak uz je, nedela nic.
	 * @return Informace, zda doslo k otoceni karty (=true) nebo ne
	 */
	public boolean turnFaceUp() {
		if(this.isturned == false) {
			this.isturned = true;
			return true;
		}
		return false;
	}
	  
	/**
	 * @return Barva karty
	 */
	public Card.Color color() {
		return this.barva;
	}
	  
	/**
	 * Testuje, zda má karta podobnou barvu jako karta zadaná. Podobnou barvou se myslí èerná (piky, køíže) a èervená (káry a srdce).
	 * @param c - karta pro srovnani
	 * @return Informace o shodì barev karet.
	 */
	public boolean similarColorTo(Card c) {
		if(((c.color() == Card.Color.CLUBS) || (c.color() == Card.Color.SPADES)) && ((this.color() == Card.Color.CLUBS) || (this.color() == Card.Color.SPADES))) {
			return true;
		}
		else if(((c.color() == Card.Color.DIAMONDS) || (c.color() == Card.Color.HEARTS)) && ((this.color() == Card.Color.DIAMONDS) || (this.color() == Card.Color.HEARTS))) {
			return true;
		}
		return false;
	}
	  
	/**
	 * Porovná hodnotu karty se zadanou kartou c. Pokud jsou stejné, vrací 0. Pokud je karta vìtší než zadaná c, vrací kladný rozdíl hodnot.
	 * @param c - Karta, s kterou se porovnává.
	 * @return Vrací rozdíl hodnot karet.
	 */
	public int compareValue(Card c) {
		if(c.value == this.value) {
			return 0;
		}
		else if(this.value > c.value) {
			int difference =  this.value - c.value;
			return difference;
		}
		else {
			int difference =  this.value - c.value;
			return difference;
		}
	}
	  
	/**
	 * Prepsani metody toString, pro korektni vypis na vystup
	 * @return Vraci string ve formatu [hodnota karty]([barva karty])
	 */
	@Override
	public String toString() {
		String convert = "1";
			
		if(this.value > 1 && this.value < 11) {
			convert = Integer.toString(this.value);
		}
		else {
			switch(value) {
			case 1: convert = "A";
			break;
			case 11: convert = "J";
			break;
			case 12: convert = "D";
			break;
			case 13: convert = "K";
			break;	
			}
		}
		return (convert + "(" + this.barva.toString() + ")"); 
	}
	
	/**
	 * Prepsani metody equals, pro korektni kontrola podobnosti dvou karet
	 * @param obj - Objekt pro porovnani
	 * @return true= je podobny
	 */
	@Override
	public boolean equals(Object obj) {
			
		if(obj == this) return true;
		if(!(obj instanceof Card)) {
			return false;
		}
		Card card = (Card)obj;
		return value == card.value && Objects.equals(barva, card.barva);
	}
		
	/**
	 * Prepsani metody hashCode, nutnost pri prepsani equals
	 * @return true= hash hodnota
	 */
	@Override
	public int hashCode() {
		return Objects.hash(value, barva);
	}
}
