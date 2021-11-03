package com.charlottetimbreza;

public class Main {

    public static void main(String[] args) {

        Player ploo = new Player (134, "Plooful", 135);
        Player wardell = new Player(536, "TSM Wardell", 648);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player surbroza = new Player (4631, "Surbroza", 684);
        Player anniDro = new Player(6919, "C9 Annie", 593);

        Hashtable hashtable = new Hashtable();
        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(surbroza.getUserName(), surbroza);
        hashtable.put(anniDro.getUserName(), anniDro);

        hashtable.printHashtable();
        System.out.println(hashtable.get("Surbroza"));
        hashtable.yeet("Surbroza");
        hashtable.yeet("TSM Wardell");
        System.out.println(hashtable.get("Surbroza"));
        hashtable.printHashtable();
    }
}
