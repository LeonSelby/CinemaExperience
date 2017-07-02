package com.leonselby.test.CinemaExperience;

import sun.tracing.NullProviderFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

class TakeInput {

    //Questions

    static String question(String type) {
        String tmp = "";
        if (type.equalsIgnoreCase("offer")) {
            tmp = TakeInput.partyOfferQuestion();
        } else if (type.equalsIgnoreCase("children")) {
            tmp = TakeInput.childrenQuestion();
        } else if (type.equalsIgnoreCase("students")) {
            tmp = TakeInput.studentQuestion();
        } else if (type.equalsIgnoreCase("elderly")) {
            tmp = TakeInput.elderlyQuestion();
        } else if (type.equalsIgnoreCase("day")) {
            tmp = TakeInput.askForDay();
        } else if (type.equalsIgnoreCase("film")) {
            tmp = TakeInput.filmRequest();
        }
        return tmp;
    }

    static int questionOffers(Order order, String type) {
        System.out.println(TakeInput.question(type));
        int requested = TakeInput.takeNextInt();
        boolean badInput = true;
        while (badInput) {
            if ((requested < order.getSeatsRemaining()) && (requested > 0)) {
                PartyDeclaration.assignReqToAssigned(order, type, requested);
                PartyDeclaration.adjustRemainingSeats(order);
                badInput = false;
            } else if (requested == order.getSeatsRemaining()) {
                PartyDeclaration.assignReqToAssigned(order, type, requested);
                PartyDeclaration.adjustRemainingSeats(order);
                System.out.println(order.announceFinalPrice());
                Greeting.thankEnd();
            } else if (requested < 0) {
                PartyDeclaration.adjustRemainingSeats(order);
                TakeInput.needPosPlease();
                requested = TakeInput.takeNextInt();
            } else if(requested == 0){
                PartyDeclaration.adjustRemainingSeats(order);
                badInput = false;
            }else {
                PartyDeclaration.adjustRemainingSeats(order);
                TakeInput.overPartySize(order);
                requested = TakeInput.takeNextInt();
            }
        }
        System.out.println("You have been assigned " + order.getCount(order, type) + " " + type + " ticket(s).");
        return order.getCount(order, type);
    }

    static String askForDay() {
        return ("Please choose the day of your visit by typing the day or the corresponding number.");
    }//asks to type day

    static String filmRequest() {
        return "Please select a film by typing the full title or its corresponding number.";
    }

    static String partyOfferQuestion() {
        return "Does anyone in your party qualify for these offers? Please type \"yes\" or \"no\".";
    }//asks "yes or no for offers?"

    static int askForPartySize() {
        System.out.println("How many people are in your party?");
        return TakeInput.takeNextInt();
    } // Produces INT as party size.

    static String childrenQuestion() {
        return "How many children are in your party?";

    }//returns "how many children?"

    static String studentQuestion() {
        return "How many of your party are students?";
    } // returns "how many students?"

    static String elderlyQuestion() {
        return "How many of your party are over 65?";
    } // returns "how many elderly?"

    //Scanners
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
            } catch (NumberFormatException nfe) {
                needIntPlease();
            }
        }
        return tmp;
    }


    //Errors
    private static void needIntPlease() {
        System.out.println("We're sorry! Please input a number!");
    }

    static void needPosPlease() {
        System.out.println("We're sorry! Please input a number above zero (0)!");
    }

    static void needYesNoPlease() {
        System.out.println("We're sorry! Please insert \"yes\" or \"no\".");
    }

    static void incorrectDay() {
        System.out.println("We're sorry! We can not recognise that input, please try again.");
    }

    static void incorrectFilm() {
        System.out.println("We're sorry! We could not recognise that input, please try again.");
    }

    static void incorrectEntry() {
        System.out.println("We're sorry! We could not recognise that answer, " +
                "please respond with either \"yes\" or \" no\".");
    }

    static void handleTooMany() {
        System.out.println("Sorry, there is not enough seating for a party that size!");
    }

    static void handleTooFew() {
        System.out.println("We're sorry, we cannot remove a customer because that screening is already empty!");
    }

    static void overPartySize(Order order) {
        System.out.println("We're sorry! That number is higher than the available seats!" +
                "\n There are " + order.getSeatsRemaining() + " party members available for an offer. Please try again!");
    }
}