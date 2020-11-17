/*
 * author: jkiper
 *  Programming Project One
 * Spring 2019
 * 
 */

public class Application {

	public static void main(String[] args) {
		
		Dealer cd1 = new Dealer();
		
		cd1.deal();
		
		for (int i = 1; i <= 5; i++) {
			
			System.out.println(cd1.evaluateHand());
				
			if (i % 5 == 0)
				System.out.println();

		}
	}	
}