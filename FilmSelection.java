package com.leonselby.test.CinemaExperience;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

class FilmSelection {

    private static Film confirmedFilm;

    private static List<Film> filmSelection() {
        List<Film> filmArrayList = new ArrayList<Film>();
        filmArrayList.add(new Film("1", "Transformers: The Last Knight", "12"));
        filmArrayList.add(new Film("2", "Wonder Woman", "12"));
        filmArrayList.add(new Film("3", "The Mummy", "15"));
        filmArrayList.add(new Film("4", "Pirates of the Caribbean: Salazar's Revenge", "12"));
        filmArrayList.add(new Film("5", "Diary of a Wimpy Kid: The Long Haul", "U"));
        filmArrayList.add(new Film("6", "Baywatch", "15"));
        filmArrayList.add(new Film("7", "Guardians of the Galaxy Vol.2", "12"));
        return filmArrayList;
    }//Creates filmList for searching

    private static String askForFilm() {
        Film temp;
        filmSelection();
        System.out.println(TakeInput.question("film"));
        Films.listOfMovies();
        String tmp = "";
        boolean badInput = true;
        while (badInput) {
            try {
                temp = checkFilm(findFilm(TakeInput.takeNextLine(), filmSelection()));
                tmp = temp.toString();
                confirmedFilm = temp;
                return tmp;
            } catch (NullPointerException e) {
                TakeInput.incorrectFilm();
            } catch (InputMismatchException ime){
                TakeInput.incorrectFilm();
            }
        }
        return tmp;
    }

    private static Film findFilm(String input, List<Film> filmList) {
        Film tmp = null;
        for (Film m : filmList)
            if ((m.title.toLowerCase().equalsIgnoreCase(input))
                    ||
                    (m.ID.equalsIgnoreCase(input))) {
                tmp = m;
            }
        return tmp;
    }

    private static Film checkFilm(Film inputtedFilm) {
        Film filmT = null;
        if (inputtedFilm != null) {
            filmT = inputtedFilm;
        }
        return filmT;
    }

    static String filmAnnouncer() {
        String temp = askForFilm();
        if (temp.equalsIgnoreCase("")) {
            temp = askForFilm();
        }
        return "You have selected " + temp;
    }//checks for blank

     static Film getConfirmedFilm() {
        return confirmedFilm;
    }
}
