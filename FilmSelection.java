package com.leonselby.test.CinemaExperience;


import java.util.ArrayList;
import java.util.List;

class FilmSelection {

   static Film confirmedFilm;

    static List<Film> filmSelection() {
        List<Film> filmArrayList = new ArrayList<Film>();
        filmArrayList.add(new Film("1", "Transformers: The Last Knight", "12"));
        filmArrayList.add(new Film("2", "Wonder Woman", "12"));
        filmArrayList.add(new Film("3", "The Mummy", "15"));
        filmArrayList.add(new Film("4", "Pirates of the Caribbean: Salazar's Revenge", "12"));
        filmArrayList.add(new Film("5", "Diary of a Wimpy Kid: The Long Haul", "U"));
        filmArrayList.add(new Film("6", "Baywatch", "15"));
        filmArrayList.add(new Film("7", "Guardians of the Galaxy Vol.2", "12"));
        return filmArrayList;
    }

    static String filmRequest() {
        return "Please select a film by typing the full title or its corresponding number.";
    }

    static String askForFilm() {
        Film temp = null;
        filmSelection();
        System.out.println(filmRequest());
        Films.listOfMovies();
        String tmp ="";
       try{
           temp = checkFilm(findFilm(TakeInput.takeNextLine(), filmSelection()));
           tmp =  temp.toString();
           confirmedFilm = temp;
           return tmp;
       }
       catch (NullPointerException e){incorrectFilm();}
       return tmp;
    }

    static Film findFilm(String input, List<Film> filmList) {
        Film tmp = null;
        for (Film m : filmList)
            if ((m.title.toLowerCase().equalsIgnoreCase(input))
                    ||
                    (m.ID.equalsIgnoreCase(input))) {
                tmp = m;
            }
        return tmp;
    }

    static Film checkFilm(Film inputtedFilm) {
        Film filmT = null;

    if (inputtedFilm != null) {
        filmT = inputtedFilm;
    }
        return filmT;
    }

    static String filmSelector() {
        String tmp;
        tmp = askForFilm();
        return tmp;
    }

    static String filmAnnouncer() {
        String temp = filmSelector();
        if(temp.equalsIgnoreCase("")){
           temp = filmSelector();
        }
        return "You have selected " + temp;
    }

    static void incorrectFilm() {
        System.out.println("We're sorry! We could not recognise that input, please try again.");
    }

    public static Film getConfirmedFilm() {
        return confirmedFilm;
    }
}
