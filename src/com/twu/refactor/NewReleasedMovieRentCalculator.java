package com.twu.refactor;

class NewReleasedMovieRentCalculator extends MovieRentCalculator {

    @Override
    double calculateAmount(int days) {
        return days * 3;
    }

    @Override
    int getPointsFor(int days) {
        if(days > 1) return 2;
        return 1;
    }
}
