package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.Enums.BLANK_CHAR;
import static org.example.Enums.SPACE;

public class Utils {



    // Removes all non numeric digits from each element of the arrayList and return a filtered List. (Optional function in case the user says something between the numbers).
    public static List<String> filterStringList(List<String> input) {
        //   return input.stream().map(Utils::stripNonDigits).collect(Collectors.toList());

        List<String> newStringList = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            // checks if the string input has any space, so it can prevent an exception. That can happen when there is a double space in the initial Input String.
            if (!input.get(i).equals("")) {
                String newString = stripNonDigits(input.get(i));
                newStringList.add(newString);
            }
        }
        return newStringList;
    }
    
    // Converts an arrayList of Strings to an ArrayList of int
    public static List<Integer> stringArrayListToIntArrayList(List<String> input) {

        try {
            return input.stream().map(Integer::parseInt).collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Could not convert to int.");
            return null;
        }
    }


    // Creates a List<String> from a String that separates the numbers with space.
    public static List<String> stringToStringArrayList(String input) {
        return Arrays.asList(input.split(" "));
    }

    // Returns a String with any non numeric digits removed.
    public static String stripNonDigits(String input) {
        return input.replaceAll("[^\\d.]", "");
    }

    // Removes all the spaces from a String
    public static String withoutSpace(String input) {
        return input.replaceAll(SPACE, BLANK_CHAR);
    }

    // Returns true if the Length of a given String is either 10 or 14 characters.
    public static boolean isValidLength(String input) {
        return input.length() == 10 || input.length() == 14;
    }

    // Returns the first digit of any given Integer
    public static int findFirstDigitOfPositiveNumber(int n) {
        // Remove last digit from number
        // until only one digit is left
        while (n >= 10)
            n /= 10;
        // return the first digit
        return n;
    }

    // Returns the length of any given int
    public static int numLength(int input) {
        if (input < 0) {
            return String.valueOf(input).length() - 1;
        }
        return String.valueOf(input).length();
    }

}
