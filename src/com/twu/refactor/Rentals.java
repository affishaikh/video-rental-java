package com.twu.refactor;

import java.util.ArrayList;
import java.util.List;

class Rentals {
    private List<Rental> rentalList = new ArrayList<Rental>();

    Rentals add(Rental rental) {
        this.rentalList.add(rental);
        return this;
    }

    double calculateAmount() throws InvalidPriceCodeException {
        double totalAmount = 0;

        for (Rental rental : rentalList) {
            totalAmount += rental.calculateAmount();
        }

        return totalAmount;
    }

    int calculatePoints() throws InvalidPriceCodeException {
        int frequentRenterPoints = 0;

        for (Rental rental : rentalList) {
            frequentRenterPoints += rental.calculatePoints();
        }

        return frequentRenterPoints;
    }
}
