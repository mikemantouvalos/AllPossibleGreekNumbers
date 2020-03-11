package org.example;


import java.util.List;

import static org.example.Actions.*;
import static org.example.Enums.SPACE;
import static org.example.Utils.*;

public class Analyzer {


    // Checks if the user input is valid for the number analysis. (E.g. max number length between each space)
    public static boolean isUserInputValid(String input) {
        if (input.isEmpty() || input.matches("^[a-zA-Z]*$")) {
            return false;
        }
        // Convert Strings to Integers in a new List.
        List<Integer> list = stringArrayListToIntArrayList(filterStringList(stringToStringArrayList(input)));
        //  check every item of the array. If digits are greater than 3, that means that String input has more than 3 digits separated with Space, Which is not Valid.
        for (int i = 0; i < list.size(); i++) {
            if (Utils.numLength(list.get(i)) > 3) {
                return false;
            }
        }
        return true;
    }

    // Generates all the possible numbers from a given String, considering all the Ambiguities that might happen from Greek language.
    public static boolean analyze(String input) {
        if (!isUserInputValid(input)) {
            System.out.println("[INVALID NUMBER]");
            return false;
        }
        List<String> list = stringToStringArrayList(input);
        List<String> filteredList = filterStringList(list);
        List<Integer> intList = stringArrayListToIntArrayList(filteredList);
        List<Integer> expandedList = expandNumbers(intList);
        List<List<Integer>> categorizedNumbers = groupNumbers(expandedList);
        categorizedNumbers = allPossibleAmbiguities(categorizedNumbers);
        List<String> possibleNumbers = possibleNumbersList(categorizedNumbers);
        areNumbersValid(possibleNumbers);
        return true;
    }

    public static void areNumbersValid(List<String> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            System.out.println(inputList.get(i) + isNumberValid(inputList.get(i)));
        }
    }

    // Checks if a given number (without spaces) is considered a Greek Number. Greek Numbers should be either 10 or 14 digits long.
    // If they are 10 digits long, then they must start from "21" or "69"
    // If they are 14 digits long, then they must start from "00302" or "003069"
    public static String isNumberValid(String input) {
        // checks if String has any space between the characters. If so it converts it to String without Spaces. That helps when raw input is being checked
        if (input.contains(SPACE)) {
            String inputChecked = withoutSpace(input);
        }
        if (!input.matches("[0-9]+")) {
            return "[INVALID NUMBER]";
        }
        if (isValidLength(input)) {
            if (input.length() == 10) {
                if (input.startsWith("2") || input.startsWith("69")) {
                    return " [phone number : VALID]";
                } else {
                    return " [phone number: INVALID] ";
                }
            } else if (input.length() == 14) {
                if (input.startsWith("00302") || input.startsWith("003069")) {
                    return " [phone number : VALID]";
                } else {
                    return " [phone number: INVALID] ";
                }
            }
        } else {
            return " [phone number: INVALID] ";
        }
        return null;
    }
}
