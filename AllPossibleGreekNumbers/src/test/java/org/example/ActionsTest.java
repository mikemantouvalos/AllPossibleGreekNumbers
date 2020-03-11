package org.example;


import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Enclosed.class)
public class ActionsTest {

    public static List<Integer> listOfInts = new ArrayList(Arrays.asList(200, 10, 50, 3, 80, 0, 900, 60, 1, 2));
    public static List<Integer> listOfInts1 = new ArrayList(Arrays.asList(200, 10, 80, 0, 900, 60, 500, 50, 3));


    public static List<List<Integer>> getListOfGroups() {
        List<Integer> item1 = new ArrayList(Arrays.asList(200, 10));
        List<Integer> item2 = new ArrayList(Arrays.asList(50, 3));
        List<Integer> item3 = new ArrayList(Arrays.asList(80));
        List<Integer> item4 = new ArrayList(Arrays.asList(0));
        List<Integer> item5 = new ArrayList(Arrays.asList(900, 60, 1));
        List<Integer> item6 = new ArrayList(Arrays.asList(2));

        List<List<Integer>> groupedList = new ArrayList<>();
        groupedList.add(item1);
        groupedList.add(item2);
        groupedList.add(item3);
        groupedList.add(item4);
        groupedList.add(item5);
        groupedList.add(item6);
        return groupedList;

    }public static List<List<Integer>> getListOfGroups1() {
        List<Integer> item1 = new ArrayList(Arrays.asList(200, 10));
        List<Integer> item2 = new ArrayList(Arrays.asList(80));
        List<Integer> item3 = new ArrayList(Arrays.asList(0));
        List<Integer> item4 = new ArrayList(Arrays.asList(900, 60));
        List<Integer> item5 = new ArrayList(Arrays.asList(500,50,3));

        List<List<Integer>> groupedList = new ArrayList<>();
        groupedList.add(item1);
        groupedList.add(item2);
        groupedList.add(item3);
        groupedList.add(item4);
        groupedList.add(item5);
        return groupedList;
    }



    public static List<List<Integer>> getListWithPossibleAmbiguities() {
        List<Integer> item1 = new ArrayList(Arrays.asList(20010, 210));
        List<Integer> item2 = new ArrayList(Arrays.asList(503, 53));
        List<Integer> item3 = new ArrayList(Arrays.asList(80));
        List<Integer> item4 = new ArrayList(Arrays.asList(0));
        List<Integer> item5 = new ArrayList(Arrays.asList(900601, 90061,9601, 961));
        List<Integer> item6 = new ArrayList(Arrays.asList(2));

        List<List<Integer>> AmbiguitiesList = new ArrayList<>();
        AmbiguitiesList.add(item1);
        AmbiguitiesList.add(item2);
        AmbiguitiesList.add(item3);
        AmbiguitiesList.add(item4);
        AmbiguitiesList.add(item5);
        AmbiguitiesList.add(item6);
        return AmbiguitiesList;
    }


    public static List<String> getPossibleNumbers(){
        List<String> possibleNumList = new ArrayList<>();
        possibleNumList.add("200105038009006012");
        possibleNumList.add("2105038009006012");
        possibleNumList.add("20010538009006012");
        possibleNumList.add("210538009006012");
        possibleNumList.add("20010503800900612");
        possibleNumList.add("210503800900612");
        possibleNumList.add("2001053800900612");
        possibleNumList.add("21053800900612");
        possibleNumList.add("2001050380096012");
        possibleNumList.add("21050380096012");
        possibleNumList.add("200105380096012");
        possibleNumList.add("2105380096012");
        possibleNumList.add("200105038009612");
        possibleNumList.add("2105038009612");
        possibleNumList.add("20010538009612");
        possibleNumList.add("210538009612");
        return possibleNumList;
    }


    // Checks if a number from 101 to 999 that can cause ambiguities can break into 3 parts  --> List<Integer>  expandNumbersOfThreeDigits(List<Integer> inputList)
    @RunWith(Parameterized.class)
    public static class HasThreeNumbersBeenExpanded {

        private List<Integer> input;
        private List<Integer> output;

        public HasThreeNumbersBeenExpanded(List<Integer> output, List<Integer> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {
            return Arrays.asList(new Object[][]{
                    {new ArrayList(Arrays.asList(400, 56)), new ArrayList(Arrays.asList(456))},
                    {new ArrayList(Arrays.asList(90)), new ArrayList(Arrays.asList(90))},
            });
        }

        @Test
        public void hasThreeNumbersBeenExpanded() {
            assertEquals(output, Actions.expandNumbersOfThreeDigits(input));
        }
    }


    // Checks if a number from 13 to 99 that can cause ambiguities can break into 2 parts  --> List<Integer>  expandNumbersOfTwoDigits(List<Integer> inputList)
    @RunWith(Parameterized.class)
    public static class HasTwoNumbersBeenExpanded {

        private List<Integer> input;
        private List<Integer> output;

        public HasTwoNumbersBeenExpanded(List<Integer> output, List<Integer> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {
            return Arrays.asList(new Object[][]{
                    {new ArrayList(Arrays.asList(40, 6)), new ArrayList(Arrays.asList(46))},
                    {new ArrayList(Arrays.asList(12)), new ArrayList(Arrays.asList(12))},
            });
        }

        @Test
        public void hasTwoNumbersBeenExpanded() {
            assertEquals(output, Actions.expandNumbersOfTwoDigits(input));
        }
    }


    // Checks if a number tha can cause Ambiguities have completely been expanded.  --> List<Integer>  expandNumbers(List<Integer> inputList)
    @RunWith(Parameterized.class)
    public static class HasNumberBeenFullyExpanded {

        private List<Integer> input;
        private List<Integer> output;

        public HasNumberBeenFullyExpanded(List<Integer> output, List<Integer> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {
            return Arrays.asList(new Object[][]{
                    {new ArrayList(Arrays.asList(400, 60, 5)), new ArrayList(Arrays.asList(465))},
                    {new ArrayList(Arrays.asList(100)), new ArrayList(Arrays.asList(100))},
            });
        }

        @Test
        public void hasNumberBeenFullyExpanded() {
            assertEquals(output, Actions.expandNumbers(input));
        }
    }


    // Checks if a new List has been created, which contains every possible group of numbers that can cause ambiguities. -->  List<List<Integer>> groupNumbers(List<Integer> input)
    @RunWith(Parameterized.class)
    public static class HasListBeenGrouped {

        private List<Integer> input;
        private List<Integer> output;

        public HasListBeenGrouped(List<Integer> output, List<Integer> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {


            return Arrays.asList(new Object[][]{
                    {getListOfGroups(), listOfInts},
                    {getListOfGroups1(), listOfInts1}
            });
        }

        @Test
        public void hasListBeenGrouped() {
            assertEquals(output, Actions.groupNumbers(input));
        }
    }





    // Checks if a new List has been created, which contains every possible ambiguities from the given list -->  List<List<Integer>> allPossibleAmbiguities(List<List<Integer>> groupList)
    @RunWith(Parameterized.class)
    public static class HasReturnedAllTheAmbiguities {

        private List<List<Integer>> input;
        private List<List<Integer>> output;

        public HasReturnedAllTheAmbiguities(List<List<Integer>> output, List<List<Integer>> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {


            return Arrays.asList(new Object[][]{
                    {getListWithPossibleAmbiguities(), getListOfGroups()}
            });
        }

        @Test
        public void hasReturnedAllTheAmbiguities() {
            assertEquals(output, Actions.allPossibleAmbiguities(input));
        }
    }




    // Checks if all possible numbers have been created -->  List<String> possibleNumbersList(List<List<Integer>> mainList)
    @RunWith(Parameterized.class)
    public static class AreAllPossibleNumbersFound {

        private List<List<Integer>> input;
        private List<String> output;

        public AreAllPossibleNumbersFound(List<String> output, List<List<Integer>> input) {
            this.output = output;
            this.input = input;
        }

        @Parameterized.Parameters
        public static Collection<Object[]> testConditions() {


            return Arrays.asList(new Object[][]{
                    {getPossibleNumbers(), getListWithPossibleAmbiguities()}
            });
        }

        @Test
        public void areAllPossibleNumbersFound() {
            assertEquals(output, Actions.possibleNumbersList(input));
        }
    }

}