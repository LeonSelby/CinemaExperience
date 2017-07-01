package com.leonselby.test.CinemaExperience;

public class Main {

    public static void main(String[] args) {


        Greeting.greetCustomer();

        System.out.println("\n" + DaySelection.dayAnnouncement());
        System.out.println("\n" + FilmSelection.filmAnnouncer());
//        System.out.println(PartyDeclaration.partyAnnouncer());

//      PartyDeclaration.partyComposition(); //error message printing every time

//        System.out.println(PartyDeclaration.totalCosting);
//        System.out.println(DaySelection.getConfirmedDay());
//        System.out.println(FilmSelection.confirmedFilm);
        System.out.println(PartyDeclaration.calculateCost());

        Greeting.thankCustomer();

    }
}

//ERROR PRINTING IN YES NO

