package org.example;



import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Enclosed.class)
public class AnalyzerTest {

    // Inner static class that checks the Valid length of a number -->  boolean isValidLength(String input)
    @RunWith(Parameterized.class)
    public static class IsUserInputValid {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {true, "333 22 11 0"},
                    {true, "210a 80b asd32asd 2"},
                    {false, "4444 333 22 11 0"},
                    {false, ""},
                    {false, "asd"},
            });
        }


        private String number;
        private boolean expectedBoolean;

        public IsUserInputValid( boolean expected, String string) {
            this.number = string;
            this.expectedBoolean = expected;
        }

        @Test
        public void hasNumberValidLength() {
            assertEquals(expectedBoolean, Analyzer.isUserInputValid(number));
        }
    }

    //Checks if a given Greek Number is Valid -->  String isNumberValid(String input)
    @RunWith(Parameterized.class)
    public static class IsNumberValid {


        @Parameterized.Parameters
        public static Collection<Object []> testConditions(){
            return Arrays.asList(new Object[][] {
                    {" [phone number : VALID]", "2108051669"},
                    {" [phone number : VALID]", "00306975417522"},
                    {" [phone number : VALID]", "6975417522"},
                    {"[INVALID NUMBER]", "210a 80b asd32asd 2"},
                    {" [phone number: INVALID] ", "21080516691"},
                    {" [phone number: INVALID] ", "00402108051945"},
                    {" [phone number: INVALID] ", "00303108051945"},
            });
        }


        private String number;
        private String message;

        public IsNumberValid( String message, String number) {
            this.number = number;
            this.message = message;
        }

        @Test
        public void ssNumberValid() {
            assertEquals(message, Analyzer.isNumberValid(number));
        }
    }






}