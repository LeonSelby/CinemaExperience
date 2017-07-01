package com.leonselby.test.CinemaExperience;


class DaySelection {


    public static String getConfirmedDay() {
        return confirmedDay;
    }

    static String confirmedDay;

    static String dayAnnouncement() {
        askForDay();
        Day.listOfDays();
        return dayAnnouncer();
    }

    private static String dayAnnouncer() {
        String tmp = daySelector();
        String output = "You have selected " + confirmedDay + ", standard tickets are £8 today.";
        if (confirmedDay.equalsIgnoreCase("wednesday")) {
            output = "You have selected Wednesday, all tickets are £2 off today!";
        }
        return output;
    }

    private static String daySelector() {

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
                    incorrectDay();
                    askForDay();
            }
        }
        confirmedDay = selectedDayString;
        return selectedDayString;
    }

    private static void incorrectDay() {
        System.out.println("We're sorry! We can not recognise that input, please try again.");
    }

    private static void askForDay() {
        System.out.println("Please choose the day of your visit by typing the day or the corresponding number.");
    }
}
