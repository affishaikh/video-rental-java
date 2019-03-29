package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
	private String name;
	private List<Rental> rentalList = new ArrayList<Rental>();
	private Rentals rentals;

	Customer(String name) {
		this.name = name;
		this.rentals = new Rentals();
	}

	void addRental(Rental rental) {
		rentalList.add(rental);
		rentals.add(rental);
	}

	String statement() throws InvalidPriceCodeException {
		double totalAmount = rentals.calculateAmount();
		int frequentRenterPoints = rentals.calculatePoints();
		StringBuilder result = generateStatement(totalAmount, frequentRenterPoints);
		return result.toString();
	}

	private StringBuilder generateStatement(double totalAmount, int frequentRenterPoints) throws InvalidPriceCodeException {
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			double amountForSpecificMovie;
			Rental rental = rentals.next();
			amountForSpecificMovie = rental.calculateAmount();
			result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(amountForSpecificMovie).append("\n");
		}

		result.append("Amount owed is ").append(totalAmount).append("\n");
		result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");
		return result;
	}

	private String getName() {
		return name;
	}
}
