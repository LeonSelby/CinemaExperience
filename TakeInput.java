package com.leonselby.test.CinemaExperience;

import java.util.InputMismatchException;
import java.util.Scanner;

class TakeInput {

    static Scanner sc = new Scanner(System.in);

    static String takeNextLine() {
        return sc.nextLine();
    }

    static int takeNextInt() {
        boolean badInput = true;
        int tmp = 0;
        while (badInput) {
            try {
                tmp = Integer.parseInt(sc.nextLine());
                badInput = false;
            } catch (InputMismatchException ex) {
                needIntPlease();
            }
        }
        return  tmp;
    }


    static void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }

    static void needYesNoPlease() {
        System.out.println("We're sorry! Please insert \"yes\" or \"no\".");
    }
}