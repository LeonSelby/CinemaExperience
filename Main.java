package com.leonselby.test.CinemaExperience;

public class Main {

    public static void main(String[] args) {
        Greeting.greetCustomer();
        System.out.println("\n" + DaySelection.dayAnnouncement());
        System.out.println("\n" + FilmSelection.filmAnnouncer());
        System.out.println(PartyDeclaration.partyConfig());



        Greeting.thankCustomer();
    }
}


