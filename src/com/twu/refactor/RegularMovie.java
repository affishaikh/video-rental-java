package com.twu.refactor;

class RegularMovie extends Movie {
    RegularMovie(String name) {
        super(name, 0);
    }

    @Override
    double calculateAmountFor(int days) {
        double amount = 2;
        if (days > 2) amount += (days - 2) * 1.5;
        return amount;
    }
}
