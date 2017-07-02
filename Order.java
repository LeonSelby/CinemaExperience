package com.leonselby.test.CinemaExperience;


class Order {

    private int partySize;
    private int seatsRemaining;
    private int standardCount;
    private int childrenCount;
    private int studentCount;
    private int elderlyCount;

  int getStandardCount() {
        return standardCount;
    }

  int getChildrenCount() {
        return childrenCount;
    }

    int getStudentCount() {
        return studentCount;
    }

    int getElderlyCount() {
        return elderlyCount;
    }

    void addChildren(int amount) {
        childrenCount += amount;
    }

    void addStudent(int amount) {
        studentCount += amount;
    }

    void addElderly(int amount) {
        elderlyCount += amount;
    }

    void addStandard(int amount) {
        standardCount += amount;
    }

    String orderDetails() {
        return "Standard: " + standardCount + ", " + "Children: " + childrenCount + ", " + "Student: " +
                studentCount + ", and Elderly: " + elderlyCount + ".";
    }

   private int finalPriceDet() {
        int temp;
        if (DaySelection.getConfirmedDay().equals("Wednesday")) {
            temp = priceFinalWed();
        } else {
            temp = priceFinal();
        }
        return temp;
    }

    private int priceFinal() {
        return (childrenCount * 4) + (studentCount * 6) + (elderlyCount * 6) + (8 * standardCount);
    }

    private int priceFinalWed() {
        return (childrenCount * 2) + (studentCount * 4) + (elderlyCount * 4) + (6 * standardCount);
    }

    String announceFinalPrice(){
      return "You're total cost for this visit will be £" + finalPriceDet() +".";
    }

    int getPartySize() {
        return partySize;
    }

    void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    int getSeatsRemaining() {
        return seatsRemaining;
    }

    void setSeatsRemaining(int seatsRemaining) {
        this.seatsRemaining = seatsRemaining;
    }
}
