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

    int getCount(Order order, String type){
        int temp = 0;
        if(type.equalsIgnoreCase("children")){
            temp = order.getChildrenCount();
        }else if(type.equalsIgnoreCase("students")){
            temp = order.getStudentCount();
        }else if(type.equalsIgnoreCase("elderly")){
            temp = order.getElderlyCount();
        }else if(type.equalsIgnoreCase("standard")){
            temp = order.getStandardCount();
        }else if(type.equalsIgnoreCase("remaining")){
            temp = order.getSeatsRemaining();
        }else if(type.equalsIgnoreCase("party")){
            temp = order.getPartySize();
        }
        return temp;
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

    public int totalCustomers(){
        return getPartySize();
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

    String announceFinalPrice() {
        return "Your total cost for this visit will be £" + finalPriceDet() + ".";
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
