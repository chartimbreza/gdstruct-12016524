package com.charlottetimbreza;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);
        tree.insert(-83);

        //tree.traverseInOrder();
        tree.traverseInOrderDescending();
        //System.out.println(tree.get(55));
        //System.out.println(tree.getMax());
    }
}
