package com.leonselby.test.CinemaExperience;

class Film {

    String ID;
    String title;
    String rating;

    Film() {
    }

    public Film(String ID, String title, String rating) {
        this.ID = ID;
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return "\"" + title + "\"" + " rated " + rating +".";
    }


}
