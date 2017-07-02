package com.leonselby.test.CinemaExperience;

class MovieScreening {

    private int seats = 100, customers = 0;

    int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    MovieScreening() {
        customers = 0;
    }

    MovieScreening(int seats) {
        this.seats = seats;
    }
}