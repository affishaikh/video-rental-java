package com.twu.refactor;

abstract class MovieRentCalculator {

    abstract double calculateAmount(int days);

    abstract int getPointsFor(int days);

    static MovieRentCalculator getCalculatorFor(int priceCode) throws InvalidPriceCodeException {
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

        if(movieRentCalculator == null) {
            throw new InvalidPriceCodeException();
        }

        return movieRentCalculator;
    }
}
