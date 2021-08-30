package com.charlottetimbreza;

public class Main {

    public static void main(String[] args) {
        //Initializing players and linked list
        Player asuna = new Player(1, "Asuna", 100);
        Player lethalBacon = new Player (2, "LethalBacon", 205);
        Player hpDeskjet = new Player (3, "HpDeskjet", 34);
        Player zhazha = new Player (4, "Zhazha", 3);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        //adding players into the linked list
        playerLinkedList.addToFront(hpDeskjet);
        playerLinkedList.addToFront(lethalBacon);
        playerLinkedList.addToFront(zhazha);
        playerLinkedList.addToFront(asuna);

        //printing list
        playerLinkedList.printListNext();

        playerLinkedList.removeFrontNode();
        System.out.println("\n\nAfter removing first node: ");
        PlayerLinkedList.printListNext();

        System.out.println("\n" + playerLinkedList.contains(new Player(3, "HpDeskjet", 34)));
        System.out.println(playerLinkedList.contains(asuna));
        System.out.println(playerLinkedList.indexOf(zhazha));
    }
}
