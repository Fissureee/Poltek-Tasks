package org.example;

import java.util.*;

public class MostVotedName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input the number of names: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < names.length; i++){
            System.out.printf("Input the %d name: ", i);
            names[i] = sc.next();
        }
        String mostVotedName = findMostVotedName(names);
        System.out.println("The most voted name is " + mostVotedName);
    }

    public static String findMostVotedName(String[] names) {
        // Base case: if there is only one name in the array, return it
        if (names.length == 1) {
            return names[0];
        }

        // Recursive case: split the array in half and find the most voted name in each half
        int mid = names.length / 2;
        String[] leftHalf = Arrays.copyOfRange(names, 0, mid);
        String[] rightHalf = Arrays.copyOfRange(names, mid, names.length);
        String leftMostVotedName = findMostVotedName(leftHalf);
        String rightMostVotedName = findMostVotedName(rightHalf);

        // Find the most voted name overall by comparing the frequency of each name in each half
        int leftCount = countOccurrences(leftHalf, leftMostVotedName);
        int rightCount = countOccurrences(rightHalf, rightMostVotedName);
        if (leftCount > rightCount) {
            return leftMostVotedName;
        } else {
            return rightMostVotedName;
        }
    }

    // Helper function to count the number of occurrences of a name in an array
    public static int countOccurrences(String[] names, String name) {
        int count = 0;
        for (String n : names) {
            if (n.equals(name)) {
                count++;
            }
        }
        return count;
    }
}
