package com.charlottetimbreza;

public class Main {

    public static void main(String[] args) {
        //for bubble sorting
        int[] numbers = new int[10];
        populateArray(numbers);

        System.out.println("Before bubble sorting:");
        printArray(numbers);

        bubbleSort(numbers);

        System.out.println("\nAfter bubble sorting:");
        printArray(numbers);

        //for selection sorting
        int[] numbers2 = new int[10];
        //populateArray() sometimes provides 2 identical integers and due to selection sort
        // being unstable I opted to manually create my own array
        numbers2[0] = -21;
        numbers2[1] = 420;
        numbers2[2] = 13;
        numbers2[3] = 236;
        numbers2[4] = 169;
        numbers2[5] = 154;
        numbers2[6] = 425;
        numbers2[7] = 79;
        numbers2[8] = 527;
        numbers2[9] = 145;

        System.out.println("\n\nBefore selection sorting:");
        printArray(numbers2);

        selectionSort(numbers2);

        System.out.println("\nafter selection sorting:");
        printArray(numbers2);
    }

    private static int randomInt(int min, int max)
    {
        return (int)Math.floor(Math.random()*(max-min+1)+min);
    }

    private static void populateArray(int[] arr)
    {
        int min = -21;
        int max = 420;

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = randomInt(min, max);
        }
    }

    private static void printArray(int[] arr)
    {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    private static void bubbleSort(int[] arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            for (int i = 0; i < lastSortedIndex; i++)
            {
                if (arr[i] < arr[i + 1])
                {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[]arr)
    {
        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--)
        {
            int smallestIndex = 0;

            for(int i = 1; i <= lastSortedIndex; i++)
            {
                if (arr[i] < arr[smallestIndex])
                {
                    smallestIndex = i;
                }
            }
            int temp = arr[lastSortedIndex];
            arr[lastSortedIndex] = arr[smallestIndex];
            arr[smallestIndex] = temp;
        }
    }
}
