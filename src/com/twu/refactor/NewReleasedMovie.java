package com.twu.refactor;

class NewReleasedMovie extends Movie {
    NewReleasedMovie(String avengers) {
        super(avengers, Movie.NEW_RELEASE);
    }

    @Override
    double calculateAmountFor(int days) {
        return days * 3;
    }

    @Override
    int calculatePointsFor(int days) {
        if(days > 1) return 2;
        return 1;
    }
}
