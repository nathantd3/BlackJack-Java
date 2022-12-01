package com.hardstuck.blackjack;
import java.util.Scanner;

import com.hardstuck.blackjack.models.Card;
import com.hardstuck.blackjack.models.Deck;
import com.hardstuck.blackjack.models.Hand;

public class BlackJack {
	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		Hand playerHand = new Hand();
		Hand dealerHand = new Hand();
		Scanner scanner = new Scanner(System.in);
	    
		playerHand.dealHand(myDeck);
		dealerHand.dealHand(myDeck);
		
		System.out.println("---Player Hand---");
		playerHand.showHand();
		
		System.out.println("\n---Dealer Hand---");
		Card showCard = (dealerHand.getCards()).get(0);
		System.out.println(showCard.getName() + " " + showCard.getSuit());
		System.out.println("*****");
		
		if(playerHand.getTotal() == 21) {
			System.out.println("\nBLACKJACK!!");
		}
		else {
			while(!playerHand.isBust()) {
				System.out.println("\nType 'h' to hit or 's' to stay");
				String input = scanner.nextLine();
				if(input.equals("h")) {
					System.out.println("\n---Player Hand--- ");
					playerHand.hit(myDeck);
				}
				else if(input.equals("s")) {
					break;
				}
				else {
					System.out.println("Invalid input, try again!");
				}
			}
		}
		
		if(playerHand.isBust()) {
			System.out.println("\nYOU BUST, DEALER WINS... ");
			System.out.println("\n---Dealer Hand--- ");
			dealerHand.showHand();
		}
		else {
			while(!dealerHand.isBust() && dealerHand.getTotal() <= 17 ){
				if(dealerHand.getTotal() == 17 && dealerHand.getAceVal() == 0 && (dealerHand.getCards()).size() == 2) {
					break;
				}
				dealerHand.hit(myDeck);
			}
			if(dealerHand.isBust()) {
				System.out.println("\nDEALER BUSTS, YOU WIN!!!");
				System.out.println("\n---Player Hand--- ");
				playerHand.showHand();
				System.out.println("\n---Dealer Hand--- ");
				dealerHand.showHand();
			}
			else if(playerHand.getTotal() > dealerHand.getTotal()) {
				System.out.println("\nYOU WIN!!!");
				System.out.println("\n---Player Hand--- ");
				playerHand.showHand();
				System.out.println("\n---Dealer Hand--- ");
				dealerHand.showHand();
			}
			else if(playerHand.getTotal() == dealerHand.getTotal()) {
				System.out.println("\nTIE! YOU PUSH... ");
				System.out.println("\n---Player Hand--- ");
				playerHand.showHand();
				System.out.println("\n---Dealer Hand--- ");
				dealerHand.showHand();
			}
			else {
				System.out.println("\nDEALER WINS WITH... ");
				System.out.println("\n---Player Hand--- ");
				playerHand.showHand();
				System.out.println("\n---Dealer Hand--- ");
				dealerHand.showHand();
			}
		}
		
		scanner.close();
		
	}
	

	
	
}