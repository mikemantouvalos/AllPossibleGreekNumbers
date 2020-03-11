package org.example;

import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" \nType a String of numbers, separated with space. Each number should be from 0 to 999");
        String inputString1 = scanner.nextLine();
        scanner.close();
        Analyzer.analyze(inputString1);
    }
}

