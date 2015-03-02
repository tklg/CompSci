package elevens_5_8;

public class Part7_Questions {
	
	/*
	 * 1: required for an elevens board - 
	 * 		active cards
	 * 		can make move
	 * 		cards left
	 * 		deck
	 * 		
	 * 2: algorithm for Elevens game
	 */
		if (play()) {
			//print result
		}
		
		function play() {
			//choose cards
			//check to see if chosen cards include >=1 pair of cards that add to 11, or a JQk triple
			//if check = true, place cards
			
			while (true) {
				//wait for user to choose cards and click button
				button.on("click", function() {
					//check
					if (numCardsSelected == 2) {
						//check that 2 cards add to 11
						//remove 2 cards, choose 2 new cards and add to board
					} else if (numCardsSelected == 3) {
						//check that the 3 cards are J, Q, K
						//remove 3 cards, choose 3 new cards and add to board
					} else {
						//deselect cards and do nothing
					}
				});
				
				//check possible moves remaining in existing cards
				//check cards left in deck
				
				if (numCardsRemaining == 0) {
					return true;
				} else if (numPossibleMoves == 0) {
					return false
				} else {
					//continue
				}
			}
		}
	/*
	 * 3: elevensboard.java
	 * 		the file contains all required methods
	 * 
	 * 4:
	 * 	a:
	 * 		dealMyCards() is called from the constructor and from the newGame() method
	 * 
	 * 	b:
	 * 		the isLegal() method should call the containsPairSum11() and containsJQK() methods
	 * 
	 * 	c:
	 * 		returns array(0,1,3,6,7)
	 * 
	 * 	d:
	 * 		for (List i : cIndexes) {
	 * 			print(cardAt(i).toString());
	 * 		}
	 * 
	 * 	e:
	 * 		isLegal needs to get the indexes of the active cards so that the 2 methods have a list of selected cards to check
	 */

}
