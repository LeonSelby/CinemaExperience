package com.leonselby.test.CinemaExperience;

public enum Films {
    TF ("1", "Transformers: The Last Knight"),
    WW ("2", "Wonder Woman"),
    TM ("3", "The Mummy"),
    PotC ("4", "Pirates of the Caribbean: Salazar's Revenge"),
    DoaWK ("5", "Diary of a Wimpy Kid: The Long Haul"),
    Baywatch ("6", "Baywatch"),
    GotG2 ("7", "Guardians of the Galaxy Vol.2");

    public final String filmNum;
    public final String filmTitle;

    Films(String number, String fTitle){
        filmTitle = fTitle;
        filmNum = number;
    }

    public String getFilmNum() {
        return filmNum;
    }
    public String getFilmTitle(){
        return filmTitle;
    }

    static void listOfMovies() {

        for (Films listOfMovies : Films.values())
            System.out.printf("%s) %s \n", listOfMovies.getFilmNum(), listOfMovies.getFilmTitle());
    }
}
