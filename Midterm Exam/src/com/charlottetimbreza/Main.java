package com.charlottetimbreza;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CardStack deck = new CardStack("Deck");
        populateStack(deck);
        CardStack hand = new CardStack("Hand");
        CardStack discardPile = new CardStack("Discard Pile");

        deck.printStack();
        pauseTest();
        while (!deck.isEmpty()) {
            printRandomCommand(deck, hand, discardPile);
            pauseTest();
            printCardPiles(deck, hand, discardPile);
            pauseTest();
        }
    }

    //used as a system pause
    public static void pauseTest() {
        System.out.println("Press any key to continue...");
        Scanner pauser = new Scanner(System.in);
        pauser.nextLine();
    }

    public static void populateStack (CardStack stack) {
        stack.push(new Card ("Avian"));
        stack.push(new Card ("Burstinatrix"));
        stack.push(new Card ("Hero Signal"));
        stack.push(new Card ("Bubbleman"));
        stack.push(new Card ("Polymerization"));
        stack.push(new Card ("Neos"));
        stack.push(new Card ("Bladedge"));
        stack.push(new Card ("Fusion Recovery"));
        stack.push(new Card ("Necroshade"));
        stack.push(new Card ("Wildheart"));
        stack.push(new Card ("Neo Bubbleman"));
        stack.push(new Card ("Sparkman"));
        stack.push(new Card ("Burstinatrix"));
        stack.push(new Card ("Avian"));
        stack.push(new Card ("Hero Flash"));
        stack.push(new Card ("Polymerization"));
        stack.push(new Card ("Wildheart"));
        stack.push(new Card ("Clayman"));
        stack.push(new Card ("Spark Blaster"));
        stack.push(new Card ("Sparkman"));
        stack.push(new Card ("Skyscraper"));
        stack.push(new Card ("Clay Charge"));
        stack.push(new Card ("Feather Wing"));
        stack.push(new Card ("Clayman"));
        stack.push(new Card ("Miracle Fusion"));
        stack.push(new Card ("Bubbleman"));
        stack.push(new Card ("Bladedge"));
        stack.push(new Card ("Skyscraper 2 - Hero City"));
        stack.push(new Card ("Hero Barrier"));
        stack.push(new Card ("Neos"));
    }

    public static int getRandomInt (int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

    public static void printDrawCommand (CardStack deck, CardStack hand, int numOfCards) {
        System.out.println("Draw " + numOfCards + " cards");
        System.out.println("Drew the following card/s: ");
        if (numOfCards > deck.size())
            numOfCards = deck.size();
        for(int i = 0; i < numOfCards; i++) {
            Card currentCard = deck.pop();
            System.out.println(currentCard + " ");
            hand.push(currentCard);
        }
        System.out.println("(Drew " + numOfCards + " cards)");
    }

    public static void printDiscardCommand (CardStack hand, CardStack discardPile, int numOfCards) {
        System.out.println("Discard " + numOfCards + " cards");
        System.out.println("Discarded the following card/s: ");
        if (numOfCards > hand.size())
            numOfCards = hand.size();
        for(int i = 0; i < numOfCards; i++) {
            Card currentCard = hand.pop();
            System.out.println(currentCard + " ");
            discardPile.push(currentCard);
        }
        System.out.println("(Discarded " + numOfCards + " cards)");
    }

    public static void printRetrieveCommand (CardStack hand, CardStack discardPile, int numOfCards) {
        System.out.println("Get " + numOfCards + " cards from the discard pile.");
        System.out.println("Got the following card/s form the discard pile: ");
        if (numOfCards > discardPile.size())
            numOfCards = discardPile.size();
        for(int i = 0; i < numOfCards; i++) {
            Card currentCard = discardPile.pop();
            System.out.println(currentCard + " ");
            hand.push(currentCard);
        }
        System.out.println("(Retrieved " + numOfCards + " cards)");
    }

    public static void printRandomCommand (CardStack deck, CardStack hand, CardStack discardPile) {

        int rng = getRandomInt(2);
        int numOfCards = getRandomInt(4) + 1;
        if (rng == 0) {
            printDrawCommand(deck, hand, numOfCards);
        }
        else if (rng == 1) {
            printDiscardCommand(hand, discardPile, numOfCards);
        }
        else if (rng == 2) {
            printRetrieveCommand(hand, discardPile, numOfCards);
        }
    }

    public static void printCardPiles(CardStack deck, CardStack hand, CardStack discardPile) {
        deck.printStack();
        System.out.println();
        hand.printStack();
        System.out.println();
        discardPile.printStack();
    }
}
