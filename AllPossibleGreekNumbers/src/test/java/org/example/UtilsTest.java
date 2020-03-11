package org.example;


import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class UtilsTest {


    // Inner static class that checks the Valid length of a number -->  boolean isValidLength(String input)
    @RunWith(Parameterized.class)
    public static class HasNumberValidLength {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {false, "12345678910"},
                    {false, "0"},
                    {false, "123"},
                    {false, "-5"},
                    {true, "1234567890"},
                    {true, "12345678912345"},
                    {false, "165465432165465234567890"},
            });
        }


        private String string;
        private boolean expectedBoolean;

        public HasNumberValidLength( boolean expected, String string) {
            this.string = string;
            this.expectedBoolean = expected;
        }

        @Test
        public void hasNumberValidLength() {
            assertEquals(expectedBoolean, Utils.isValidLength(string));
        }
    }





    //Checks if the returned number is indeed the first number of an int value -->  int findFirstDigitOfPositiveNumber(int n)
    @RunWith(Parameterized.class)
    public static class IsFirstDigitCorrect {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {1, 1234},
                    {2, 23112312},
                    {0, 0},
            });
        }

        private int number;
        private int firstNumber;

        public IsFirstDigitCorrect(int firstNumber, int number) {
            this.number = number;
            this.firstNumber = firstNumber;
        }

        @Test
        public void isFirstDigitCorrect() {
            assertEquals(firstNumber, Utils.findFirstDigitOfPositiveNumber(number));
        }
    }


    //Checks if the length of digits of a given integer is correct -->   int numLength(int input)
    @RunWith(Parameterized.class)
    public static class IsLengthOfANumberCorrect {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {4, 1234},
                    {8, 23112312},
                    {1, 0},
                    {3, -123},
            });
        }


        private int number;
        private int length;

        public IsLengthOfANumberCorrect(int length, int number) {
            this.number = number;
            this.length = length;
        }

        @Test
        public void isLengthOfANumberCorrect() {
            assertEquals(length, Utils.numLength(number));
        }
    }



    //Checks if the returned String has no space between its characters -->   String withoutSpace(String input)
    @RunWith(Parameterized.class)
    public static class HasNoSpaceBetweenChars {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {"12345678910", "123 4567 891 0"},
                    {"0", "0"},
                    {"123", "123"},
                    {"HelloWorld", "Hello World"},
                    {"Hello132World99", "Hello 132 World9 9"},
                    {"-^&*", "- ^ & * "},

            });
        }


        private String input;
        private String output;

        public HasNoSpaceBetweenChars( String output, String input) {
            this.input = input;
            this.output = output;
        }

        @Test
        public void hasNoSpaceBetweenChars() {
            assertEquals(output, Utils.withoutSpace(input));
        }
    }





    //Checks if the returned String has removed any nonNumeric characters- -->  String stripNonDigits(String input )
    @RunWith(Parameterized.class)

    public static class HasNoNumericValues {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {"210", "210hello"},
                    {"210", "210"},
                    {"210", "hello210hello"},
            });
        }


        private String input;
        private String output;

        public HasNoNumericValues(String output, String input) {
            this.input = input;
            this.output = output;
        }

        @Test
        public void hasNonNumericDigitsRemoved() {
            assertEquals(output, Utils.stripNonDigits(input));
        }

    }

    //Checks if the method returns an ArrayList of Strings from a given String input-->  stringToStringArrayList (String input)
    @RunWith(Parameterized.class)

    public static class HasArrayListCreated {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {Arrays.asList("210", "80", "51"), "210 80 51"},
                    {Collections.singletonList("210"), "210"},
                    {Collections.singletonList(""), ""},
            });
        }


        private String input;
        private List<String> output;

        public HasArrayListCreated(List<String> output, String input) {
            this.input = input;
            this.output = output;
        }

        @Test
        public void hasNonNumericDigitsRemoved() {
            assertEquals(output, Utils.stringToStringArrayList(input));
        }

    }

    //Checks if the conversion to int has taken place   -->  stringArrayListToIntArrayList(List<String> input)
    @RunWith(Parameterized.class)

    public static class HasBeenConvertedToIntArrayList {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {Arrays.asList(1,2,3,4,5), Arrays.asList("1", "2", "3", "4", "5")},
                    {Arrays.asList(1), Arrays.asList("1")},
                    {null, Arrays.asList("")},
            });
        }


        private List<String> input;
        private List<Integer> output;

        public HasBeenConvertedToIntArrayList(List<Integer> output, List<String> input) {
            this.input = input;
            this.output = output;
        }

        @Test
        public void hasBeenConvertedToIntArrayList() {
            assertEquals(output, Utils.stringArrayListToIntArrayList(input));
        }



    }//Checks if all non numeric digits have been removed from every string of the arraylist   -->  filterStringList (List<String> input)
    @RunWith(Parameterized.class)

    public static class HaveDigitsBeenRemoved {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {Arrays.asList("1","2","3","4","5"), Arrays.asList("1a", "2b", "3c", "4ASDFG", "5@@")},
                    {Arrays.asList("1"), Arrays.asList("1")},
                    {Arrays.asList(), Arrays.asList("")},
            });
        }


        private List<String> input;
        private List<String> output;

        public HaveDigitsBeenRemoved(List<String> output, List<String> input) {
            this.input = input;
            this.output = output;
        }

        @Test
        public void haveDigitsBeenRemoved() {
            assertEquals(output, Utils.filterStringList(input));
        }

    }


}