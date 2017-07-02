package com.leonselby.test.CinemaExperience;


public enum Customers {
//    Standard("Standard", 8),
    OAP("OAP", 6),
    Student("Student", 6),
    Child("Child", 4);

    public final int originalPrice;
    public final String customerType;

    Customers(String type, int price) {
        customerType = type;
        originalPrice = price;
    }

    public String getCustomerType(){
        return customerType;
    }

    public int getOriginalPrice() {
        return originalPrice;
    }

    static void listOfPrices() {
        for (Customers listOfPrices : Customers.values())
            System.out.printf("%s £%s \n", listOfPrices.getCustomerType(), listOfPrices.getOriginalPrice());
    }

}




