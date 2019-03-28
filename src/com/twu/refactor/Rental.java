package com.twu.refactor;

public class Rental {

    private Movie movie;

    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    int getDaysRented() {
        return daysRented;
    }

    Movie getMovie() {
        return movie;
    }


    double calculateAmount() {
        double thisAmount = 0;
        switch (this.movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (this.daysRented > 2)
                    thisAmount += (this.daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += this.daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (this.daysRented > 3)
                    thisAmount += (this.daysRented - 3) * 1.5;
                break;
        }

        return thisAmount;
    }
}