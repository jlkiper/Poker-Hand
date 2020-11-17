/*
 * 
 * author: jkiper
 * 
 */

import java.util.Arrays;

public class Dealer {

	private CardDeck cardDeck;
	private Card[] hand; 
	private int[] suits;
	private int[] faces;
	
	public Dealer() {
		cardDeck = new CardDeck();
	    cardDeck.shuffle(); //places cards in a random order
	    hand = new Card[5];
	    
	
	    for(int i=0;i<hand.length;i++) {
	    	hand[i] = cardDeck.dealCard();
	    }
	   
	    suits = new int[5];
	    faces = new int[14];
	    
	}//end constructor

	
	/**
	 * Method to deal a hand of 5 cards
	 */
	public void deal() {
		resetCounters();
		for(int i=0; i<5; i++) {
			hand[i] = cardDeck.dealCard();
		}
		
	}//end deal
	
	
	/**
	 * Method to evaluate a hand of 5 cards
	 * @return - a string that lists the various
	 * playable hands (e.g. pair, two pairs, etc.)
	 */
	public String evaluateHand() {
		
		for(Card c : hand) {
			String face = c.getFace();
			switch(face) {
			case "Ace":
				faces[1]++;
				break;
			case "Deuce":
				faces[2]++;
				break;
			case "Three":
				faces[3]++;
				break;
			case "Four":
				faces[4]++;
				break;
			case "Five":
				faces[5]++;
				break;
			case "Six":
				faces[6]++;
				break;
			case "Seven":
				faces[7]++;
				break;
			case "Eight":
				faces[8]++;
				break;
			case "Nine":
				faces[9]++;
				break;
			case "Ten":
				faces[10]++;
				break;
			case "Jack":
				faces[11]++;
				break;
			case "Queen":
				faces[12]++;
				break;
			case "King":
				faces[13]++;
				break;
			default: 
			}//end switch
			
			String suit = c.getSuit();
			switch(suit) {
			case "Diamonds":
				suits[0]++;
				break;
			case "Hearts":
				suits[1]++;
				break;
			case "Spades":
				suits[2]++;
				break;
			case "Clubs":
				suits[3]++;
				break;
			default: 
			}//end switch
			
		}//end for loop
		
		StringBuilder sb = new StringBuilder();
		sb.append("Your hand has: \n");
		if(pair()) {
			sb.append("a pair\n");
		}
		if(twoPair()) {
			sb.append("two pair\n");
		}
		if(threeOfKind()) {
			sb.append("three of a kind\n");
		}
		if(fourOfKind()) {
			sb.append("four of a kind\n");
		}
		if(flush()) {
			sb.append("a flush\n");
		}
		if(straight()) {
			sb.append("a straight\n");
		}
		if(fullHouse()) {
			sb.append("a full house\n");
		}
		
		return sb.toString();
	}//end evaluateHand

	private boolean pair() {
		int numPairs = 0;
		for(int i = 1; i<=13;i++) {
			if(faces[i]==2)
				numPairs++;
		}
		if(numPairs!=1)
			return false;
		return true;
	}//end pair
	
	private boolean twoPair() {
		int numPairs = 0;
		for(int i = 1; i<=13;i++) {
			if(faces[i]==2)
				numPairs++;
		}
		if(numPairs!=2)
			return false;
		return true;
	}//end twoPair
	
	private boolean threeOfKind() {
		for(int i = 1; i<=13;i++) {
			if(faces[i]==3)
				return true;
		}
			return false;
	}//end threeOfKind
	
	private boolean fourOfKind() {
		for(int i = 1; i<=13;i++) {
			if(faces[i]==4)
				return true;
		}
			return false;
	}//end fourOfKind
	
	private boolean flush() {
		for(int i=1;i<suits.length;i++)
			if(suits[i]==5)
				return true;
		return false;
	}//endFlush
	
	private boolean straight() {
		int consecutiveCards = 0;
		for(int i = 1; i<=12;i++) {
			if(faces[i]==1 && faces[i+1]==1)
				consecutiveCards++;
		}
		if(consecutiveCards==4)
			return true;
		
		consecutiveCards=0;
		for(int i = 10; i<=12;i++) {
			if(faces[i]==1 && faces[i+1]==1)
				consecutiveCards++;
		}
		if(faces[1]==1)
			consecutiveCards++;
		
		if(consecutiveCards==4)
			return true;
		
		return false;
	}//end straight
	
	private boolean fullHouse() {
		int pair = 0;
		int threeOfKind = 0;
		for(int i = 1; i<=13;i++) {
			if(faces[i]==2)
				pair++;
			if(faces[i]==3)
				threeOfKind++;
		}
		
		if(pair==1 && threeOfKind==1)
			return true;
	
		return false;
	}//end fullHouse
	
	private void resetCounters() {
		 //initialize/reset the counters
	    for(int i=0;i<faces.length;i++) {
	    	faces[i]=0;
	    }
	    for(int j=0;j<suits.length;j++) {
	    	suits[j]=0;
	    }
	}//end resetCounters
	
	@Override
	public String toString() {
		return "Dealer [hand=" + Arrays.toString(hand) + "]";
	}//end toString
	
}//end class
