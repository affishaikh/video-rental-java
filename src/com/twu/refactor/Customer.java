package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

class Customer {
	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	Customer(String name) {
		this.name = name;
	}

	void addRental(Rental arg) {
		rentalList.add(arg);
	}

	String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
		while (rentals.hasNext()) {
			double thisAmount;
			Rental rental = rentals.next();

			thisAmount = rental.calculateAmount();

			// add frequent renter points
			frequentRenterPoints += rental.calculatePoints();

			// show figures for this rental
			result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
			totalAmount += thisAmount;

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
