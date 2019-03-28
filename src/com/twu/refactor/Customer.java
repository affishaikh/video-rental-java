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

	private String getName() {
		return name;
	}

	String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount;
			Rental rental = rentals.next();
			thisAmount = rental.calculateAmount();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for a two day new release rental
			if ((rental.getMovie().getPriceCode() == Movie.getNewRelease())
					&& rental.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for this rental
			result += "\t" + rental.getMovie().getTitle() + "\t"
					+ thisAmount + "\n";
			totalAmount += thisAmount;

		}
		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints
				+ " frequent renter points";
		return result;
	}

}
