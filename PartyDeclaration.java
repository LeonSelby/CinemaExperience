package com.leonselby.test.CinemaExperience;

import java.util.InputMismatchException;

public class PartyDeclaration {

    static MovieScreening screen1 = new MovieScreening();
    static int assignedSeating;
    static int partySize;
    static int remainingSeatingForParty;
    static int children;
    static int students;
    static int elderly;
    static int standardCustomers;
    static String totalCosting;

   static int priceFinalWed = (children * 2) + (students * 4) + (elderly * 4) + (6 * standardCustomers);

    public static int askForPartySize() {
        System.out.println("How many people are in your party?");
        return TakeInput.takeNextInt();
    } // Produces INT as party size.

    public static int partyAssignedOriginal(int input) throws InputMismatchException {
        int requestedSeats;
        requestedSeats = input;

        int assignedSeats = 0;
        try {
            if (requestedSeats <= (screen1.getSeats() - screen1.getCustomers() - assignedSeats)) {
                assignedSeats = requestedSeats;
                assignedSeating = requestedSeats;
            } else {

                handleTooMany();
                assignedSeats = 0;
                assignedSeating = 0;
            }
        } catch (InputMismatchException ime) {
            requestedSeats = askForPartySize();
        }
        return assignedSeats;
    } //Takes ask and checks it


    static String partyAnnouncer() {
        int temp = partyAssignedOriginal(askForPartySize());
        String tmp;
        if (temp == 0) {
            temp = partyAssignedOriginal(askForPartySize());
        }
        tmp = "You have been assigned " + temp + " seat(s).";
        partySize = temp;
        return tmp;
    } //Includes above two, checks for 0

    public static String partyComposition() {
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
//                case "0":
                default:
                    incorrectEntry();
                    partyRequest();
            }
        }
        System.out.println("You have selected " + tmp + ".");
        return tmp;
    } // Printing error message every time???

    public static String partyAnnouncement() {
        return "You have selected " + partyComposition() + ".";
    } // line for y/n


    static String childrenQuestion() {
        String q = "How many children are in your party?";
        return q;

    }//Scans partyAnnouncement for yes

    static int childrenAnswer() {
        Order o =new Order();

        int requestedChildren = 0;
        int assignedChildren = 0;
        String tmp = childrenQuestion();
        System.out.println(tmp);
        requestedChildren = TakeInput.takeNextInt();


        if (requestedChildren == 0) {
            assignedChildren = requestedChildren;
            remainingSeatingForParty = assignedSeating - assignedChildren;
            children = assignedChildren;
            o.addChildren(children);
        } else if (requestedChildren < assignedSeating - remainingSeatingForParty) {
            assignedChildren = requestedChildren;
            remainingSeatingForParty = assignedSeating - assignedChildren;
            children = assignedChildren;
        } else if (requestedChildren == assignedSeating - remainingSeatingForParty) {
            assignedChildren = requestedChildren;
            remainingSeatingForParty = assignedSeating - assignedChildren;
            children = assignedChildren;
            if (DaySelection.confirmedDay.equalsIgnoreCase("Wednesday")) {
                System.out.println("pricefinalwed is "+finalPriceDet() );
                totalCosting = "Your total cost will be £" + finalPriceDet() + ".";
                System.out.println("You have been assigned " + assignedChildren + " child ticket(s).");
                Greeting.thankEnd();
            }

            totalCosting = "Your total cost will be £" + priceFinal() + ".";
            System.out.println("You have been assigned " + assignedChildren + " child ticket(s).");
            Greeting.thankEnd();
        } else {
            remainingSeatingForParty = assignedSeating - assignedChildren;
            overPartySize();
            requestedChildren = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + assignedChildren + " child ticket(s).");
        return assignedChildren;
    }
static String askForData(String message){
        System.out.println(message);
        return TakeInput.takeNextLine();
}
//static String feedbackMessage(String message, String variableToOutput){
//    System.out.println(message + variableToOutput);
//
//}

    static String studentQuestion() {
        String q = "How many of your party are students?";
        return q;
    }

    static int studentAnswer() {
        int requestedStudents = 0;
        int assignedStudents = 0;
//        int remainingPrior = remainingSeatingForParty;
        String tmp = studentQuestion();
        System.out.println(tmp);
        requestedStudents = TakeInput.takeNextInt();

        if (requestedStudents == 0) {
            assignedStudents = requestedStudents;
            remainingSeatingForParty = assignedSeating - assignedStudents;
        } else if (requestedStudents < assignedSeating - remainingSeatingForParty) {
            assignedStudents = requestedStudents;
            remainingSeatingForParty = assignedSeating - assignedStudents;
        } else if (requestedStudents == assignedSeating - remainingSeatingForParty) {
            assignedStudents = requestedStudents;
            remainingSeatingForParty = assignedSeating - remainingSeatingForParty;
            if (DaySelection.confirmedDay.equalsIgnoreCase("Wednesday")) {
                totalCosting = "Your total cost will be £" + (4 * assignedStudents) + ".";
                System.out.println("You have been assigned " + assignedStudents + " student ticket(s).");
                Greeting.thankEnd();
            }
            totalCosting = "Your total cost will be £" + (6 * assignedStudents) + ".";
            System.out.println("You have been assigned " + assignedStudents + " student ticket(s).");
            Greeting.thankEnd();
        } else {
            remainingSeatingForParty = assignedSeating - assignedStudents;
            overPartySize();
            requestedStudents = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + assignedStudents + " student ticket(s).");
        return assignedStudents;
    }

    static String elderlyQuestion() {
        String q = "How many of your party are over 65?";

        return q;
    }

    public static int priceFinal () {
        return (children * 4) + (students * 6) + (elderly * 6) + (8 * standardCustomers);
    }
    static int elderlyAnswer() {
        int requestedElderly = 0;
        int assignedElderly = 0;
        int remainingPrior = remainingSeatingForParty;
        String tmp = elderlyQuestion();
        if (tmp.contains("many")) {
            System.out.println(tmp);
            requestedElderly = TakeInput.takeNextInt();
        }
        if (requestedElderly == 0) {
            assignedElderly = requestedElderly;
            remainingSeatingForParty = remainingPrior - assignedElderly;
        } else if (requestedElderly < assignedSeating - remainingSeatingForParty) {
            assignedElderly = requestedElderly;
            remainingSeatingForParty = remainingPrior - assignedElderly;
        } else if (requestedElderly == assignedSeating - remainingSeatingForParty) {
            assignedElderly = requestedElderly;
            remainingSeatingForParty = remainingPrior - remainingSeatingForParty;
            if (DaySelection.getConfirmedDay().equalsIgnoreCase("Wednesday")) {
                totalCosting = "Your total cost will be £" + (4 * assignedElderly) + ".";
                System.out.println("You have been assigned " + assignedElderly + " elderly ticket(s).");
                Greeting.thankEnd();
            }
            totalCosting = "Your total cost will be £" + (6 * assignedElderly) + ".";
            System.out.println("You have been assigned " + assignedElderly + " elderly ticket(s).");
            Greeting.thankEnd();
        } else {
            remainingSeatingForParty = remainingPrior - assignedElderly;
            overPartySize();
            requestedElderly = TakeInput.takeNextInt();
        }
        System.out.println("You have been assigned " + assignedElderly + " elderly ticket(s).");
        return assignedElderly;
    }


    static String calculateCost() {
        int seatsRemaining3 = 0;

        String offerAnswer = partyComposition();
        int assignedSeats = assignedSeating;
        if (offerAnswer.equals("Yes")) {
            int children = childrenAnswer();

            int seatsRemaining = assignedSeats - children;
            System.out.println(seatsRemaining);
            if (seatsRemaining > 0) {
                int students = studentAnswer();
                int seatsRemaining2 = seatsRemaining - students;
                if (seatsRemaining2 > 0) {
                    int elderly = elderlyAnswer();
                    seatsRemaining3 = seatsRemaining2 - elderly;
                }
            }
            int standardCustomers;
            standardCustomers = seatsRemaining3;

        } else {
            standardCustomers = assignedSeating;
        }
        System.out.println("end" + seatsRemaining3);
        String temp = "Your total cost is £" + finalPriceDet();
        return temp;


    }


   static int finalPriceDet(){
int temp = 0;
if(DaySelection.getConfirmedDay().equals("Wednesday")){
   temp = priceFinalWed;
}else {
    temp = priceFinal();
}  return temp;
    }


    private static void overPartySize() {
        System.out.println("We're sorry! That number is higher than the available seats!" +
                "\n There are " + remainingSeatingForParty + " party members available for an offer. Please try again!");
    }


    public static void partyRequest() {
        System.out.println("Does anyone in your party qualify for these offers? Please type \"yes\" or \"no\".");
        Customers.listOfPrices();
    }

    private static void handleTooMany() {
        System.out.println("Sorry, there is not enough seating for a party that size!");
    }

    private void handleTooFew() {
        System.out.println("We're sorry, we cannot remove a customer because that screening is already empty!");
    }

    private static void incorrectEntry() {
        System.out.println("We're sorry! We could not recognise that answer, " +
                "please respond with either \"yes\" or \" no\".");
    }
}
