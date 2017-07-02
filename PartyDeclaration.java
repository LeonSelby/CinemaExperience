package com.leonselby.test.CinemaExperience;

import java.util.InputMismatchException;

class PartyDeclaration {

    private static MovieScreening screen1 = new MovieScreening();
    private static Order o = new Order();

    private static int partyAssignedOriginal() throws InputMismatchException {
        int requestedSeats;
        requestedSeats = TakeInput.askForPartySize();
        int assignedSeats = 0;
        boolean badInput = true;
        while (badInput) {
            try {
                if ((requestedSeats <= (screen1.getSeats() - screen1.getCustomers()) && (requestedSeats > 0))) {
                    assignedSeats = requestedSeats;
                    badInput = false;
                } else {
                    TakeInput.handleTooMany();
                    assignedSeats = 0;
                    requestedSeats = TakeInput.askForPartySize();
                }
            } catch (InputMismatchException ime) {
                requestedSeats = TakeInput.askForPartySize();
            }
        }
        return assignedSeats;
    } //Takes ask and checks if room

    private static String partyAnnouncer() {
        int temp = partyAssignedOriginal();
        String tmp;
        if (temp <= 0) {
            TakeInput.needPosPlease();
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
        System.out.println(TakeInput.question("offer"));
        Customers.listOfPrices();
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
                    TakeInput.incorrectEntry();
                    System.out.println(TakeInput.question("offer"));
                    Customers.listOfPrices();
                    break;
            }
        }
        System.out.println("You have selected " + tmp + ".");
        return tmp;
    } // Asks for Party Size, returns answer to offers

    private static String partyAnnouncement() {
        return "You have selected " + partyComposition() + ".";
    }

//    private static int childrenAnswer() {
//
//        System.out.println(TakeInput.question("children"));
//        int requested = TakeInput.takeNextInt();
//        if (requested < o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "children", requested);
//            adjustRemainingSeats(o);
//        } else if (requested == o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "children", requested);
//            adjustRemainingSeats(o);
//            System.out.println(o.announceFinalPrice());
//            Greeting.thankEnd();
//        } else {
//            adjustRemainingSeats(o);
//            TakeInput.overPartySize(o);
//            requested = TakeInput.takeNextInt();
//        }
//        System.out.println("You have been assigned " + o.getChildrenCount() + " child ticket(s).");
//        return o.getChildrenCount();
//    } //returns number of children that have been assigned
//
//    private static int studentAnswer() {
//
//        System.out.println(TakeInput.question("students"));
//        int requested = TakeInput.takeNextInt();
//        if (requested < o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "students", requested);
//            adjustRemainingSeats(o);
//        } else if (requested == o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "students", requested);
//            adjustRemainingSeats(o);
//            o.announceFinalPrice();
//            Greeting.thankEnd();
//        } else {
//            adjustRemainingSeats(o);
//            TakeInput.overPartySize(o);
//            requested = TakeInput.takeNextInt();
//        }
//        System.out.println("You have been assigned " + o.getStudentCount() + " student ticket(s).");
//        return o.getStudentCount();
//    }//returns number of student that have been assigned
//
//    private static int elderlyAnswer() {
//        System.out.println(TakeInput.question("elderly"));
//        int requested = TakeInput.takeNextInt();
//        if (requested < o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "elderly", requested);
//            adjustRemainingSeats(o);
//        } else if (requested == o.getSeatsRemaining()) {
//            assignReqToAssigned(o, "elderly", requested);
//            adjustRemainingSeats(o);
//            o.announceFinalPrice();
//            Greeting.thankEnd();
//        } else {
//            adjustRemainingSeats(o);
//            TakeInput.overPartySize(o);
//            requested = TakeInput.takeNextInt();
//        }
//        System.out.println("You have been assigned " + o.getElderlyCount() + " elderly ticket(s).");
//        return o.getElderlyCount();
//    }//returns number of elderly that have been assigned

    static String partyConfig() {
        String offerAnswer = partyAnnouncement();
        if (offerAnswer.contains("Yes")) {
            adjustRemainingSeats(o);
            TakeInput.questionOffers(o, "children");
            TakeInput.questionOffers(o, "students");
            TakeInput.questionOffers(o, "elderly");
            updateStandard(o);
            return o.announceFinalPrice();
        }
        updateStandard(o);
        return o.announceFinalPrice();
    }

    static void assignReqToAssigned(Order order, String typePl, int requestedNum) {
        if (typePl.equalsIgnoreCase("children")) {
            order.addChildren(requestedNum);
        } else if (typePl.equalsIgnoreCase("students")) {
            order.addStudent(requestedNum);
        } else if (typePl.equalsIgnoreCase("elderly")) {
            order.addElderly(requestedNum);
        }
    }

    static void adjustRemainingSeats(Order order) {
        order.setSeatsRemaining(order.getPartySize() - order.getChildrenCount() -
                order.getStudentCount() - order.getElderlyCount());
    }

    private static void updateStandard(Order order) {
        order.addStandard(order.getSeatsRemaining());
    }

}
