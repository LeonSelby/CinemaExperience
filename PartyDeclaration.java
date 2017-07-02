package com.leonselby.test.CinemaExperience;

import java.util.InputMismatchException;

class PartyDeclaration {

    private static MovieScreening screen1 = new MovieScreening();
    private static Order o = new Order();

    private static int askForPartySize() {
        System.out.println("How many people are in your party?");
        return TakeInput.takeNextInt();
    } // Produces INT as party size.

    private static int partyAssignedOriginal() throws InputMismatchException {
        int requestedSeats;
        requestedSeats = askForPartySize();
        int assignedSeats = 0;
        try {
            if (requestedSeats <= (screen1.getSeats() - screen1.getCustomers())) {
                assignedSeats = requestedSeats;
            } else {
                handleTooMany();
                assignedSeats = 0;
            }
        } catch (InputMismatchException ime) {
            requestedSeats = askForPartySize();
        }
        return assignedSeats;
    } //Takes ask and checks if room

    private static String partyAnnouncer() {
        int temp = partyAssignedOriginal();
        String tmp;
        if (temp == 0) {
            temp = partyAssignedOriginal();
        }
        tmp = "You have been assigned " + temp + " seat(s).";
        o.setPartySize(temp);
        adjustRemainingSeats(o);
        return tmp;
    } //Includes above two, checks for 0, adds PartySize to order

    private static String partyComposition() {
        System.out.println(partyAnnouncer());
        System.out.println("\nWe have discounted prices for Children, Students, and the elderly.");
        partyRequest();
        String tmp = "";
        boolean answerNotGiven = true;
        while (answerNotGiven) {
            switch (TakeInput.takeNextLine().toLowerCase()) {
                case "yes":
                case "y":
                    tmp = "Yes";
                    answerNotGiven = false;
                    break;
                case "no":
                case "n":
                    tmp = "No";
                    answerNotGiven = false;
                    break;
                default:
                    incorrectEntry();
                    partyRequest();
            }
        }
        System.out.println("You have selected " + tmp + ".");
        return tmp;
    } // Asks for Party Size, returns answer to offers

    private static String partyAnnouncement() {
        return "You have selected " + partyComposition() + ".";
    }

    private static String childrenQuestion() {
        return "How many children are in your party?";

    }//returns "how many children?"

    private static int childrenAnswer() {

        System.out.println(childrenQuestion());
        int requested = TakeInput.takeNextInt();
        System.out.println(requested);
        if (requested < o.getSeatsRemaining()) {
            assignReqToAssigned(o, "children", requested);
            adjustRemainingSeats(o);
        } else if (requested == o.getSeatsRemaining()) {
            assignReqToAssigned(o, "children", requested);
            adjustRemainingSeats(o);
            System.out.println(o.announceFinalPrice());
            Greeting.thankEnd();
        } else {
            adjustRemainingSeats(o);
            overPartySize();
            requested = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + o.getChildrenCount() + " child ticket(s).");
        return o.getChildrenCount();
    } //returns number of children that have been assigned

    private static String studentQuestion() {
        return "How many of your party are students?";
    } // returns "how many students?"

    private static int studentAnswer() {

        System.out.println(studentQuestion());
        int requested = TakeInput.takeNextInt();

        if (requested < o.getSeatsRemaining()) {
            assignReqToAssigned(o, "students", requested);
            adjustRemainingSeats(o);
        } else if (requested == o.getSeatsRemaining()) {
            assignReqToAssigned(o, "students", requested);
            adjustRemainingSeats(o);
            o.announceFinalPrice();
            Greeting.thankEnd();
        } else {
            adjustRemainingSeats(o);
            overPartySize();
            requested = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + o.getStudentCount() + " student ticket(s).");
        return o.getStudentCount();
    }//returns number of student that have been assigned

    private static String elderlyQuestion() {
        return "How many of your party are over 65?";
    } // returns "how many elderly?"

    private static int elderlyAnswer() {

        System.out.println(elderlyQuestion());
        int requested = TakeInput.takeNextInt();

        if (requested < o.getSeatsRemaining()) {
            assignReqToAssigned(o, "elderly", requested);
            adjustRemainingSeats(o);
        } else if (requested == o.getSeatsRemaining()) {
            assignReqToAssigned(o, "elderly", requested);
            adjustRemainingSeats(o);
            o.announceFinalPrice();
            Greeting.thankEnd();
        } else {
            adjustRemainingSeats(o);
            overPartySize();
            requested = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + o.getElderlyCount() + " elderly ticket(s).");
        return o.getElderlyCount();
    }//returns number of elderly that have been assigned

    static String partyConfig() {
        String offerAnswer = partyAnnouncement();
        if (offerAnswer.contains("Yes")) {
            childrenAnswer();
            studentAnswer();
            elderlyAnswer();
            updateStandard(o);
        }
        updateStandard(o);
        return o.announceFinalPrice();
    }

    private static void assignReqToAssigned(Order order, String typePl, int requestedNum) {
        if (typePl.equalsIgnoreCase("children")) {
            order.addChildren(requestedNum);
        } else if (typePl.equalsIgnoreCase("students")) {
            order.addStudent(requestedNum);
        } else if (typePl.equalsIgnoreCase("elderly")) {
            order.addElderly(requestedNum);
        }
    }

    private static void adjustRemainingSeats(Order order) {
        order.setSeatsRemaining(order.getPartySize() - order.getChildrenCount() -
                order.getStudentCount() - order.getElderlyCount());
    }

    private static void updateStandard(Order order) {
        order.addStandard(order.getSeatsRemaining());
    }

    private static void overPartySize() {
        System.out.println("We're sorry! That number is higher than the available seats!" +
                "\n There are " + o.getSeatsRemaining() + " party members available for an offer. Please try again!");
    }

    private static void partyRequest() {
        System.out.println("Does anyone in your party qualify for these offers? Please type \"yes\" or \"no\".");
        Customers.listOfPrices();
    }

    private static void handleTooMany() {
        System.out.println("Sorry, there is not enough seating for a party that size!");
    }

//    private static void handleTooFew() {
//        System.out.println("We're sorry, we cannot remove a customer because that screening is already empty!");
//    }

    private static void incorrectEntry() {
        System.out.println("We're sorry! We could not recognise that answer, " +
                "please respond with either \"yes\" or \" no\".");
    }
}
