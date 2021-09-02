package com.charlottetimbreza;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList <Card> stack;
    private String name;

    public CardStack(String name) {
        stack = new LinkedList<>();
        this.name = name;
    }

    public void push (Card card) {stack.push(card);}

    public boolean isEmpty() {return stack.isEmpty();}

    public Card pop() {
        return stack.pop();
    }

    public int size () {return stack.size();}

    public void printStack() {
        ListIterator<Card> iterator = stack.listIterator();
        System.out.println("Printing " + name + ": ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
