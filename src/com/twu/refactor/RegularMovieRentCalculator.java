package com.twu.refactor;

class RegularMovieRentCalculator extends MovieRentCalculator {
    @Override
    double calculateAmount(int days) {
        double amount = 2;
        if (days > 2) amount += (days - 2) * 1.5;
        return amount;
    }

    @Override
    int getPointsFor(int days) {
        return 1;
    }
}
