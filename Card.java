/*
 *  This class represents a Card object that 
 * can be used in various card games.
 * 
 * author: jkiper
 * Programming Project One
 * Spring 2019
 */

public class Card{

	private final String face;// face of card ("Ace", "Deuce", ...)
	private final String suit;// suit of card ("Hearts", "Diamonds", ...)
	
	/**
	    * Constructor to initialize card's face and suit.
	    * @param face
	    * @param suit
	    */
	public Card(String cardF, String cardS) {
		
		this.face = cardF;
		this.suit = cardS;
		
	}//end preferred constructor
	
	 /**
	    * Getter
	    * @return - face
	    */
	public String getFace() {
		   return face;
	   }//end getFace
	
	/**
	    * Getter 
	    * @return - suit
	    */
	   public String getSuit() {
		   return suit;
	   }//end getSuit
@Override
	public String toString() {
		
		return face + " of " + suit;
		
	}//end toString
	
}//end class