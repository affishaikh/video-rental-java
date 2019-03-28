package com.twu.refactor;

class NewReleasedMovie extends Movie {
    NewReleasedMovie(String avengers) {
        super(avengers, Movie.NEW_RELEASE);
    }

    @Override
    double getAmountFor(int days) {
        return days * 3;
    }
}
