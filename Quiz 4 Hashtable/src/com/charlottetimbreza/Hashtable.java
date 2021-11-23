package com.charlottetimbreza;

public class Hashtable {
    private StoredPlayer[] hashtable;

    public Hashtable()
    {
        hashtable = new StoredPlayer[10];
    }

    private int hashKey(String key)
    {
        //not the best for hashing function
        //makes sure that the key is within the hashtable length
        // makes conlfict with key that are the same length
        return key.length() % hashtable.length;
    }

    public void put (String key, Player value)
    {
        int hashedKey = hashKey(key);

        if (isOccupied(hashedKey))
        {
            //do linear probing: puts the colliding key to the next available slot
            int stoppingIndex = hashedKey;

            if (hashedKey == hashtable.length -1)
            {
                hashedKey = 0;
            }
            else
            {
                hashedKey++;
            }

            while(isOccupied(hashedKey) && hashedKey != stoppingIndex)
            {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }

        }

        //checks for collision
        if (isOccupied(hashedKey))
        {
            System.out.println("Sorry, there is already an element at position" + hashedKey);
        }
        else
        {
            hashtable[hashedKey] = new StoredPlayer(key, value);
        }
    }

    //function to check if index is occupied
    private boolean isOccupied(int index)
    {
        return hashtable[index] != null;
    }

    public Player get(String key)
    {
        int hashedKey = findKey(key);

        if (hashedKey == -1)
        {
            return null;
        }
        return hashtable[hashedKey].value;
    }

    private int findKey(String key)
    {
        int hashedKey = hashKey(key);

        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        //do linear probing: puts the colliding key to the next available slot
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex && hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (hashtable[hashedKey] != null
                && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        return -1;
    }

    public void printHashtable()
    {
        for (int i = 0; i < hashtable.length; i++)
        {
            if (hashtable[i] != null)
            {
                System.out.println("Element " + i + " " + hashtable[i].value);
            }
            else
            {
                System.out.println("Element " + i + " null");
            }
        }
    }

    //supposed remove function
    public void remove(String key)
    {
        int index = findKey(key);
        hashtable[index] = null;
    }
}
