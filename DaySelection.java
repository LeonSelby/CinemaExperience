package com.leonselby.test.CinemaExperience;


class DaySelection {

    private static String confirmedDay;

    static String dayAnnouncement() {
        TakeInput.askForDay();
        Day.listOfDays();
        return dayAnnouncer();
    } //Prints list of Days and Q for user, runs dayAnnouncer()

    private static String dayAnnouncer() {
        daySelector();
        String output = "You have selected " + confirmedDay + ", standard tickets are £8 today.";
        if (confirmedDay.equalsIgnoreCase("wednesday")) {
            output = "You have selected Wednesday, all tickets are £2 off today!";
        }
        return output;
    } //Prints to console based on confirmed day (runs daySelector())

    private static void daySelector() {
        String selectedDayString = "";
        boolean dayNotAssigned = true;
        while (dayNotAssigned) {
            switch (TakeInput.takeNextLine().toLowerCase()) {
                case "monday":
                case "1":
                    selectedDayString = "Monday";
                    dayNotAssigned = false;
                    break;
                case "tuesday":
                case "2":
                    selectedDayString = "Tuesday";
                    dayNotAssigned = false;
                    break;
                case "wednesday":
                case "3":
                    selectedDayString = "Wednesday";
                    dayNotAssigned = false;
                    break;
                case "thursday":
                case "4":
                    selectedDayString = "Thursday";
                    dayNotAssigned = false;
                    break;
                case "friday":
                case "5":
                    selectedDayString = "Friday";
                    dayNotAssigned = false;
                    break;
                case "saturday":
                case "6":
                    selectedDayString = "Saturday";
                    dayNotAssigned = false;
                    break;
                case "sunday":
                case "7":
                    selectedDayString = "Sunday";
                    dayNotAssigned = false;
                    break;
                case "0":
                default:
                    TakeInput.incorrectDay();
                    TakeInput.askForDay();
                    break;
            }
        }
        confirmedDay = selectedDayString;
    } //Sets confirmedDay

    static String getConfirmedDay() {
        return confirmedDay;
    }
}
