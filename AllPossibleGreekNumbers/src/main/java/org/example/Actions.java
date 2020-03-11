package org.example;

import java.util.ArrayList;
import java.util.List;
import static org.example.Utils.*;

public class Actions {


    // Expands every number that may cause ambiguities to its core components
    public static List<Integer> expandNumbers(List<Integer> inputList) {
        List<Integer> expandedList = expandNumbersOfTwoDigits(expandNumbersOfThreeDigits(inputList));
        return expandedList;
    }

    // Transforms every number from 101 to 999 in to two components (For example : 654 --> 600, 54) and pushes the result into the same list.
    public static List<Integer> expandNumbersOfThreeDigits(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            if ((inputList.get(i) > 100 && inputList.get(i) < 1000) && (inputList.get(i) % 100 != 0)) {
                int firstDigit = findFirstDigitOfPositiveNumber(inputList.get(i));
                int multipleOfTen = firstDigit * 100;
                inputList.set(i, inputList.get(i) - multipleOfTen);
                inputList.add(i, multipleOfTen);
            }
        }
        return inputList;
    }

    // Transforms every number from 13 to 99 in to two components (For example : 95 --> 90, 5) and pushes the result into the same list.
    public static List<Integer> expandNumbersOfTwoDigits(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            if ((inputList.get(i) > 12 && inputList.get(i) < 100) && (inputList.get(i) % 10 != 0)) {
                int firstDigit = findFirstDigitOfPositiveNumber(inputList.get(i));
                int multipleOfTen = firstDigit * 10;
                inputList.set(i, inputList.get(i) - multipleOfTen);
                inputList.add(i, multipleOfTen);
            }
        }
        return inputList;
    }

    // Creates a list of lists. Each list holds either a number or a group of numbers. The group of numbers are the numbers that are causing ambiguities.
    public static List<List<Integer>> groupNumbers(List<Integer> input) {

        List<List<Integer>> mainList = new ArrayList<>(); // creating a Main list that contains List items
        int i = 0;
        // We use while loop instead of for loop because we need to have control over the counter "i".
        while (i < input.size()) {
            // We will scan the expanded list given from this method parameter, to see if there are any groups of numbers that can cause ambiguities. Then, each number that is not causing ambiguities, along with
            // the group of numbers that do, will be added as list items, to another List<List>.
            List<Integer> listInt = new ArrayList<>(); // List that contains 1 to 3 numbers depending on the ambiguities found)
            if(input.size()>1)
            while (numLength(input.get(i)) > numLength(input.get(i + 1)) && input.get(i+1)!=0)  {
                listInt.add(input.get(i));
                i++;
                // check so that "i" cannot be greater than the last index of the array, to prevent Index out Bounds exception.
                if (i == input.size() - 1)
                    break;
            }
            // this adds either the last digit of the group that causes ambiguities or one number that doesn't cause ambiguities.
            listInt.add(input.get(i));
            i++;
            mainList.add(listInt);
            // checks if the counter has reached the list's size. This happens when the last number of the input list doesn't cause any ambiguities. It also prevents an index out of bounds exception for the above while statement
            if (i == input.size() - 1) {
                List<Integer> listInt1 = new ArrayList<>();
                listInt1.add(input.get(i));
                mainList.add(listInt1);
                break;
            }
        }

        return mainList;
    }

    //Finds all the possible ambiguities from the lists of integers. Returns A list of lists with every possible ambiguities.
    public static List<List<Integer>> allPossibleAmbiguities(List<List<Integer>> groupList) {

        List<List<Integer>> mainList = new ArrayList<>();

        for (int i = 0; i < groupList.size(); i++) {
            if (groupList.get(i).size() == 1) {
                int number = groupList.get(i).get(0);
                List<Integer> newList = new ArrayList<>();
                newList.add(number);
                mainList.add(newList);
            } else if (groupList.get(i).size() == 2) {
                int number1 = groupList.get(i).get(0);
                int number2 = groupList.get(i).get(1);
                //if first's number length is 3digits (e.g 300) and second 2digits (e.g 50) then it should store : {30050, 350}
                if(numLength (groupList.get(i).get(0) ) ==3 ) {
                    if(groupList.get(i).get(1) < 10){
                        List<Integer> newList = new ArrayList<>();
                        newList.add(number1 * 10 + number2);
                        newList.add(number1 + number2);
                        mainList.add(newList);
                    }else{
                        List<Integer> newList = new ArrayList<>();
                        newList.add(number1 * 100 + number2);
                        newList.add(number1 + number2);
                        mainList.add(newList);
                    }

                    //if first's number length is 2digits (e.g 30) and second 2digits (e.g 5) then it should store : {305 , 35}
                }else {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(number1 * 10 + number2);
                    newList.add(number1 + number2);
                    mainList.add(newList);
                }
            } else if (groupList.get(i).size() == 3) {
                int number1 =  groupList.get(i).get(0);
                int number2 =  groupList.get(i).get(1);
                int number3 =  groupList.get(i).get(2);
                List<Integer> newList = new ArrayList<>();
                newList.add(number1 * 1000 + number2 * 10 + number3);
                newList.add(number1 * 100 + number2 + number3);
                newList.add((number1 + number2) * 10 + number3);
                newList.add(number1 + number2 + number3);
                mainList.add(newList);
            }
        }
        return mainList;
    }

    // Returns a List with all the possible numbers, considering every possible ambiguities may happen from Greek Language.
    // It calculates it using the Cartesian Product between multiple lists.
    public static List<String> possibleNumbersList(List<List<Integer>> mainList) { //
        int solutions = 1;
        List<String> finalList = new ArrayList<>();
        for (int i = 0; i < mainList.size(); solutions *= mainList.get(i).size(), i++) ;
        int count = 0;
        for (int i = 0; i < solutions; i++) {
            int j = 1;
            StringBuilder stringBuilder = new StringBuilder();
            for (List list : mainList) {
                stringBuilder.append(list.get((i / j) % list.size()).toString());
                j *= list.size();
            }
            String string = stringBuilder.toString();
            finalList.add(string);
            count++;
        }
        System.out.println("\n Total results: " + count + "\n");
        return finalList;
    }



}


