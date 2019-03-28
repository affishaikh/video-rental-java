package com.twu.refactor;

public class NewReleasedMovieRentCalculator extends MovieRentCalculator {

    @Override
    double calculateAmount(int days) {
        return days * 3;
    }
}
