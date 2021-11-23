package com.charlottetimbreza;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayQueue matchmakingQueue = new ArrayQueue(7);
        int gameCounter = 0;

        while (gameCounter < 10) {
            addToMatchmaking(matchmakingQueue);
            printPauseTurn();
            if(matchmakingQueue.size() >= 5) {
                gameCounter++;
                System.out.println("Game " + gameCounter + " has started with the following players!")
                startGame( matchmakingQueue);
            }
            System.out.println("\nMatchmaking Queue");
            matchmakingQueue.printQueue();
            System.out.print("\n");
        }

    }

    public static void printPauseTurn() {
        System.out.println("Press enter to end the turn and start a new one");
        Scanner pause = new Scanner(System.in);
        pause.nextLine();
    }

    public static int rng(int min, int max) {
        Random random = new Random();
        return random.nextInt(((max - min) + 1) + min);
    }

    public static void addToMatchmaking(ArrayQueue arrayQueue) {
        int randNumber = rng(1, 7);
        System.out.println("Added players to matchmaking queue: ");
        for (int i = 0; i < randNumber; i++) {
            int randPlayerId = rng(0, 200);
            Player currentPlayer = new Player(randPlayerId);
            arrayQueue.add(currentPlayer);
            System.out.println(currentPlayer);
        }
    }

    public static void startGame(ArrayQueue arrayQueue) {
        for (int i = 0; i < 5; i++) {
            System.out.println(arrayQueue.peek());
            arrayQueue.remove();

        }
    }
}
