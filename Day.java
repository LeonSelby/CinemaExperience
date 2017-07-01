package com.leonselby.test.CinemaExperience;


public enum Day {
    Monday("1"),
    Tuesday("2"),
    Wednesday("3"),
    Thursday("4"),
    Friday("5"),
    Saturday("6"),
    Sunday("7");

    public final String dayNum;

    Day(String number){
        dayNum = number;
    }

    public String getDayNum() {
        return dayNum;
    }
    static void listOfDays() {

        for (Day listOfDays : Day.values())
            System.out.printf("%s) %s \n", listOfDays.getDayNum(), listOfDays);
    }
}
