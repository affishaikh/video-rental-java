package com.twu.refactor;

abstract class MovieRentCalculator {

    abstract double calculateAmount(int days);

    abstract int getPointsFor(int days);

    static MovieRentCalculator getRentCalculatorFor(int priceCode) {
        MovieRentCalculator movieRentCalculator = null;

        switch (priceCode) {
            case Movie.REGULAR:
                movieRentCalculator = new RegularMovieRentCalculator();
                break;
            case Movie.NEW_RELEASE:
                movieRentCalculator = new NewReleasedMovieRentCalculator();
                break;
            case Movie.CHILDRENS:
                movieRentCalculator = new ChildrenMovieRentCalculator();
                break;
        }

        return movieRentCalculator;
    }
}
