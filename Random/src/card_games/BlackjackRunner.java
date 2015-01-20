package card_games;

import java.util.Scanner;

import villa7.Print;

public class BlackjackRunner {
	
	private static Print p;
	private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
    	p = new Print();
    
       int money;          // Amount of money the user has.
       int bet;            // Amount user bets on a game.
       boolean userWins;   // Did the user win the game?
       
       p.nl("Welcome to the game of blackjack.");
       p.nl("");
       
       money = 100;  // User starts with $100.
    
       while (true) {
           p.nl("You have " + money + " dollars.");
           do {
              p.nl("How many dollars do you want to bet?  (Enter 0 to end.)");
              p.l("$ ");
              bet = sc.nextInt();
              if (bet < 0 || bet > money)
                  p.nl("Your answer must be between 0 and " + money + '.');
           } while (bet < 0 || bet > money);
           if (bet == 0)
              break;
           userWins = playBlackjack();
           if (userWins)
              money = money + bet;
           else
              money = money - bet;
           p.nl("");
           if (money == 0) {
              p.nl("Looks like you've are out of money!");
              break;
           }
       }
       
       p.nl("");
       p.nl("You leave with $" + money + '.');
    
    } // end main()
    
    
    static boolean playBlackjack() {
 
       BlackjackDeck deck;                  // A deck of cards.  A new deck for each game.
       BlackjackHand dealerHand;   // The dealer's hand.
       BlackjackHand userHand;     // The user's hand.
       
       deck = new BlackjackDeck();
       dealerHand = new BlackjackHand();
       userHand = new BlackjackHand();
 
       /*  Shuffle the deck, then deal two cards to each player. */
       
       deck.shuffle();
       dealerHand.addCard(deck.drawCard());
       dealerHand.addCard(deck.drawCard());
       userHand.addCard(deck.drawCard());
       userHand.addCard(deck.drawCard());
       
       p.nl("");
       p.nl("");
       
       /* Check if one of the players has Blackjack (two cards totaling to 21).
          The player with Blackjack wins the game.  Dealer wins ties.
       */
       
       if (dealerHand.getBlackjackValue() == 21) {
            p.nl("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
            p.nl("User has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
            p.nl("");
            p.nl("Dealer has Blackjack.  Dealer wins.");
            return false;
       }
       
       if (userHand.getBlackjackValue() == 21) {
            p.nl("Dealer has the " + dealerHand.getCard(0) + " and the " + dealerHand.getCard(1) + ".");
            p.nl("User has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
            p.nl("");
            p.nl("You have Blackjack.  You win.");
            return true;
       }
       
       /*  If neither player has Blackjack, play the game.  First the user 
           gets a chance to draw cards (i.e., to "Hit").  The while loop ends 
           when the user chooses to "Stand".  If the user goes over 21,
           the user loses immediately.
       */
       
       while (true) {
           
            /* Display user's cards, and let user decide to Hit or Stand. */
 
            p.nl("");
            p.nl("");
            p.nl("Your cards are:");
            for ( int i = 0; i < userHand.getNumCards(); i++ )
               p.nl("    " + userHand.getCard(i));
            p.nl("Your total is " + userHand.getBlackjackValue());
            p.nl("");
            p.nl("Dealer is showing the " + dealerHand.getCard(0));
            p.nl("");
            p.l("Hit (H) or Stand (S)? ");
            String userAction;  // User's response, 'H' or 'S'.
            do {
               userAction = sc.next().toUpperCase();
               if (userAction.contentEquals("H") && userAction.contentEquals("S"))
                  p.l("Please respond H or S:  ");
            } while (userAction.contentEquals("H") && userAction.contentEquals("S"));
 
            /* If the user Hits, the user gets a card.  If the user Stands,
               the loop ends (and it's the dealer's turn to draw cards).
            */
 
            if ( userAction.contentEquals("S")) {
                    // Loop ends; user is done taking cards.
                break;
            }
            else {  // userAction is 'H'.  Give the user a card.  
                    // If the user goes over 21, the user loses.
            	BlackjackCard newCard = deck.drawCard();
                userHand.addCard(newCard);
                p.nl("");
                p.nl("User hits.");
                p.nl("Your card is the " + newCard);
                p.nl("Your total is now " + userHand.getBlackjackValue());
                if (userHand.getBlackjackValue() > 21) {
                    p.nl("");
                    p.nl("You busted by going over 21.  You lose.");
                    p.nl("Dealer's other card was the " + dealerHand.getCard(1));
                    return false;  
                }
            }
            
       } // end while loop
       
       /* If we get to this point, the user has Stood with 21 or less.  Now, it's
          the dealer's chance to draw.  Dealer draws cards until the dealer's
          total is > 16.  If dealer goes over 21, the dealer loses.
       */
 
       p.nl("");
       p.nl("User stands.");
       p.nl("Dealer's cards are");
       p.nl("    " + dealerHand.getCard(0));
       p.nl("    " + dealerHand.getCard(1));
       while (dealerHand.getBlackjackValue() <= 16) {
    	   BlackjackCard newCard = deck.drawCard();
          p.nl("Dealer hits and gets the " + newCard);
          dealerHand.addCard(newCard);
          if (dealerHand.getBlackjackValue() > 21) {
             p.nl("");
             p.nl("Dealer busted by going over 21.  You win.");
             return true;
          }
       }
       p.nl("Dealer's total is " + dealerHand.getBlackjackValue());
       
       /* If we get to this point, both players have 21 or less.  We
          can determine the winner by comparing the values of their hands. */
       
       p.nl("");
       if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
          p.nl("Dealer wins on a tie.  You lose.");
          return false;
       }
       else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
          p.nl("Dealer wins, " + dealerHand.getBlackjackValue() + " points to " + userHand.getBlackjackValue() + ".");
          return false;
       }
       else {
          p.nl("You win, " + userHand.getBlackjackValue() + " points to " + dealerHand.getBlackjackValue() + ".");
          return true;
       }
 
    }  // end playBlackjack()
 
 
 } // end class Blackjack
