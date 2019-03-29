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

    double calculateAmount() throws InvalidPriceCodeException {
        MovieRentCalculator rentCalculator = MovieRentCalculator.getCalculatorFor(this.getMoviePriceCode());
        return rentCalculator.calculateAmount(this.daysRented);
    }


    int calculatePoints() throws InvalidPriceCodeException {
        MovieRentCalculator rentCalculator = MovieRentCalculator.getCalculatorFor(this.getMoviePriceCode());
        return rentCalculator.getPointsFor(this.daysRented);
    }

    private int getMoviePriceCode() {
        return this.movie.getPriceCode();
    }
}
