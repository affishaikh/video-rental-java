package com.twu.refactor;

public class ChildrenMovieRentCalculator extends MovieRentCalculator {

    @Override
    double calculateAmount(int days) {
        double amount = 1.5;
        if (days > 3) amount += (days - 3) * 1.5;
        return amount;
    }

    int getPointsFor(int days) {
        return 1;
    }
}
