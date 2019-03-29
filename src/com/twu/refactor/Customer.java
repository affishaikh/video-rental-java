package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentalList = new ArrayList<Rental>();

	Customer(String name) {
		this.name = name;
	}

	void addRental(Rental arg) {
		rentalList.add(arg);
	}

	String statement() throws InvalidPriceCodeException {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			double amountForSpecificMovie;
			Rental rental = rentals.next();

			amountForSpecificMovie = rental.calculateAmount();

			// add frequent renter points
			frequentRenterPoints += rental.calculatePoints();

			// show figures for this rental
			result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(amountForSpecificMovie).append("\n");
			totalAmount += amountForSpecificMovie;
		}

		// add footer lines
		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}

	private String getName() {
		return name;
	}
}
