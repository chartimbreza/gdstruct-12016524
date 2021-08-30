package com.charlottetimbreza;

import java.util.Objects;

public class PlayerLinkedList {
    private static PlayerNode head;
    private static int numberOfElements = 0; //for instructions no.2

    //adds a node to the front of the linked list
    public void addToFront (Player player) {
        PlayerNode playerNode = new PlayerNode(player);
        if (head != null) {
            head.setPreviousPlayer(playerNode);
        }
        playerNode.setNextPlayer(head);
        head = playerNode;
        numberOfElements += 1;
    }

    //for instruction no.1 | removes the first node of the linked list
    public void removeFrontNode () {
        PlayerNode current = head;
        current.getNextPlayer().setPreviousPlayer(null);
        head = current.getNextPlayer();
        current = null;
        numberOfElements -= 1;
    }

    //prints the linked list
    public static void printListNext() {
        PlayerNode current = head;
        System.out.print("Head -> ");
        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
        System.out.println("Number of elements in list: " + numberOfElements);
    }

    //used to check if previous nodes are working
    public static void printListPrevious () {
        PlayerNode current = head;

        //sets current to last node
        while (current.getNextPlayer() != null)
            current = current.getNextPlayer();

        System.out.print("Last -> ");
        while (current.getPreviousPlayer() != null) {
            System.out.println(current.getPlayer() + " -> ");
            current = current.getPreviousPlayer();
        }
        System.out.println("null");
    }

    //for instructions no.3
    public boolean contains (Player player) {
        PlayerNode current = head;
        boolean isItMatching = false;
        while (current != null) {
            if (Objects.equals(current.getPlayer(), player)) {
                isItMatching = true;
                break;
            }
            current = current.getNextPlayer();
        }
        return isItMatching;
    }

    //for instruction no.3
    public int indexOf (Player player) {
        PlayerNode current = head;
        int index = 0;
        while (current != null) {
            if (Objects.equals(current.getPlayer(), player))
                break;
            index += 1;
            current = current.getNextPlayer();
        }
        if (index == numberOfElements)
            return -1;
        else
            return index;
    }
}
