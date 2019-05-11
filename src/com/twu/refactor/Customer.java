package com.twu.refactor;

import java.util.ArrayList;
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
		return generateStatement(totalAmount, frequentRenterPoints);
	}

	private String generateStatement(double totalAmount, int frequentRenterPoints) throws InvalidPriceCodeException {
		String result = generateHeader() + generateMidSection() +
				generateFooter(totalAmount, frequentRenterPoints);
		return result;
	}

	private String generateHeader() {
		return "Rental Record for " + getName() + "\n";
	}

	private String generateMidSection() throws InvalidPriceCodeException {
		StringBuilder result = new StringBuilder();
		for (Rental rental1 : this.rentalList) {
			double amountForSpecificMovie;
			amountForSpecificMovie = rental1.calculateAmount();
			result.append("\t").append(rental1.getMovie().getTitle()).append("\t").append(amountForSpecificMovie).append("\n");
		}
		return result.toString();
	}

	private String generateFooter(double totalAmount, int frequentRenterPoints) {
		String result = "Amount owed is " + totalAmount + "\n" +
				"You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

	private String getName() {
		return name;
	}
}
