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
        MovieRentCalculator rentCalculatorFor = MovieRentCalculator.getRentCalculatorFor(this.movie.getPriceCode());
        return rentCalculatorFor.calculateAmount(this.daysRented);
    }

    int calculatePoints() {
        MovieRentCalculator rentCalculatorFor = MovieRentCalculator.getRentCalculatorFor(this.movie.getPriceCode());
        return rentCalculatorFor.getPointsFor(this.daysRented);
    }
}