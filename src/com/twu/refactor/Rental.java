package com.twu.refactor;

class Rental {

    private Movie movie;

    private int daysRented;

    Rental(Movie movie, int daysRented) {
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
                thisAmount += this.movie.getAmountFor(this.daysRented);
                break;
            case Movie.NEW_RELEASE:
                thisAmount += this.daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += this.movie.getAmountFor(this.daysRented);
                break;
        }

        return thisAmount;
    }
}