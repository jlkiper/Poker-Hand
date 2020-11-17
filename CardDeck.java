/*
 * This class represents a deck of cards object that 
 * can be used in various card games
 * 
 * author: jkiper
 * Programming Project One
 * Spring 2019
 * 
 */

import java.security.SecureRandom;

public class CardDeck{
	
	private Card[] cardDeck;//array of Card objects
	private int currentCard;//index of next Card to be dealt (0-51)
	private static final int NUMBER_OF_CARDS = 52;//constant # of Cards
	private static final SecureRandom randomNumbers = new SecureRandom(); // random number generator
	
	/**
	 * Constructor to build the card deck.
	 */
	public CardDeck(){
		
		cardDeck = new Card[NUMBER_OF_CARDS];//create array of Card objects
		
		String[] suits = new String []  {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		String[] faces = new String [] {"Ace", "Deuce", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
		
		currentCard = 0;//first Card dealt will be deck[0]
		
		// populate deck with Card objects
		for(int count = 0; count < cardDeck.length; count++) {
			
			cardDeck[count] = new Card(faces[count % 13], suits[count / 13]);
			
		}//end suit loop
	}//end CardDeck
	
	/**
	 * Shuffle deck of Cards with one-pass algorithm
	 */
	public void shuffle(){
		
		// next call to method dealCard should start at deck[0] again
		currentCard = 0;
		
		// for each Card, pick another random Card (0-51) and swap them
		for(int first = 0; first < cardDeck.length; first++){
			
			// select a random number between 0 and 51
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			// swap current Card with randomly selected Card
			Card temp = cardDeck[first];
			cardDeck[first] = cardDeck[second];
			cardDeck[second] = temp;
			
		}//end loop	
	}//end shuffle
	
	// deal one Card
	   /**
	    * Method to deal a single Card.
	    * @return - Card object
	    */
	public Card dealCard(){
		
		// determine whether Cards remain to be dealt
		if (currentCard < cardDeck.length) {
			
			return cardDeck[currentCard++];// return current Card in array
			
		}//end if statement
		else {
			System.out.println("Out of cards.");//print out message
			
				return( null );// return null to indicate that all Cards were dealt
				
		}//end else statement
	}//end dealCard
}//end class