package com.twu.refactor;

class ChildrenMovie extends Movie {
    ChildrenMovie(String name) {
        super(name, Movie.CHILDRENS);
    }

    @Override
    double getAmountFor(int days) {
        double amount = 1.5;
        if (days > 3) amount += (days - 3) * 1.5;
        return amount;
    }
}
