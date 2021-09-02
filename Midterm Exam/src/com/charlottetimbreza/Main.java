package com.charlottetimbreza;

import java.util.LinkedList;
import java.util.Random;

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
            printDeckInfo(deck, hand, discardPile);
            pauseTest();
        }
    }

    //used as a system pause
    public static void pauseTest() {
        System.out.println("Press any key to continue...");
        new java.util.Scanner(System.in).nextLine();
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

    public static void printRandomCommand (CardStack deck, CardStack hand, CardStack discardPile) {
        //int rng = getRandomInt(2);
        int rng = 0;
        int numOfCards = getRandomInt(4) + 1;
        if (rng == 0) {
            System.out.println("Draw " + numOfCards + " cards");
            System.out.println("Drew the following card/s: ");
            for(int i = 0; i < numOfCards; i++) {
                Card currentCard = deck.pop();
                System.out.println(currentCard + " ");
                hand.push(currentCard);
            }
        }
        else if (rng == 1) {
            System.out.println("Discard " + numOfCards + " cards");
            System.out.println("Discarded the following card/s: ");
            for(int i = 0; i < numOfCards; i++) {
                Card currentCard = hand.pop();
                System.out.println(currentCard + " ");
                discardPile.push(currentCard);
            }
        }
        else if (rng == 2) {
            System.out.println("Get " + numOfCards + " cards from the discard pile.");
            System.out.println("Got the following card/s form the discard pile: ");
            for(int i = 0; i < numOfCards; i++) {
                Card currentCard = discardPile.pop();
                System.out.println(currentCard + " ");
                hand.push(currentCard);
            }
        }
    }

    public static void printDeckInfo (CardStack deck, CardStack hand, CardStack discardPile) {
        deck.printStack();
        System.out.println();
        hand.printStack();
        System.out.println();
        discardPile.printStack();
    }
}
