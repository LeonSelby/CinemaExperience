package com.leonselby.test.CinemaExperience;


class Greeting {

    static String greetingWelcome() {
        return "Welcome to QA Cinemas!";
    }

    static String thankYou() {
        return "Thank you for your visit! Enjoy "+ FilmSelection.confirmedFilm +"!";
    }

    static void greetCustomer() {
        System.out.println(greetingWelcome());
    }

    static void thankCustomer() {
        System.out.println(thankYou());
    }

    static void thankEnd(){
        thankCustomer();
        System.exit(0);
    }
}
