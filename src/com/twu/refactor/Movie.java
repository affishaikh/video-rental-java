package com.twu.refactor;

class Movie {
	static final int  CHILDRENS = 2;
	static final int  REGULAR = 0;
	static final int  NEW_RELEASE = 1;

	private String title;
	private int priceCode;

	Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	static int getNewRelease() {
		return NEW_RELEASE;
	}

	int getPriceCode() {
		return priceCode;
	}

	void setPriceCode(int arg) {
    	priceCode = arg;
	}

	String getTitle () {
		return title;
	}

//	int getPointsFor(int daysRented) {
//		if (this.priceCode == Movie.NEW_RELEASE && daysRented > 1) return 2;
//		return 1;
//	}

//	double calculateAmountFor(int days) {
//		double amount = 0;
//
//		switch (this.getPriceCode()) {
//			case Movie.REGULAR:
//				amount = getRegularMovieAmountFor(days);
//				break;
//			case Movie.NEW_RELEASE:
//				amount = getNewReleasedMovieAmountFor(days);
//				break;
//			case Movie.CHILDRENS:
//				amount = getChildrenMovieAmountFor(days);
//				break;
//		}
//
//		return amount;
//	}
//
//	private double getChildrenMovieAmountFor(int days) {
//		double amount = 1.5;
//		if (days > 3) amount += (days - 3) * 1.5;
//		return amount;
//	}
//
//	private double getNewReleasedMovieAmountFor(int days) {
//		return days * 3;
//	}
//
//	private double getRegularMovieAmountFor(int days) {
//		double amount = 2;
//		if (days > 2) amount += (days - 2) * 1.5;
//		return amount;
//	}
}

