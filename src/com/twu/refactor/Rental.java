package com.twu.refactor;

class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int getDaysRented() {
        return daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    double calculateAmount() {
        return this.movie.calculateAmountFor(this.daysRented);
    }

    int calculatePoints() {
        return this.movie.calculatePointsFor(this.daysRented);
    }
}