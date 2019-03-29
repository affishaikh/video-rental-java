package com.twu.refactor;

import junit.framework.TestCase;

public class RentalsTest extends TestCase {

    private Rental rental;
    private Rental rental1;


    public void setUp() {
        rental = new Rental(new Movie("Avengers", Movie.CHILDRENS), 1);
        rental1 = new Rental(new Movie("Fantastic Beasts", Movie.NEW_RELEASE), 3);
    }

    public void testShouldReturnTheTotalAmountForARentedMovie() throws InvalidPriceCodeException {
        Rentals rentals = new Rentals();
        rentals.add(rental);
        double expected = 1.5;
        assertEquals(expected, rentals.calculateAmount());
    }

    public void testShouldReturnTheTotalAmountForRentedMovies() throws InvalidPriceCodeException {
        Rentals rentals = new Rentals();
        rentals.add(rental).add(rental1);
        double expected = 10.5;
        assertEquals(expected, rentals.calculateAmount());
    }

    public void testShouldReturnTheTotalFrequentRenterPointsForAMovie() throws InvalidPriceCodeException {
        Rentals rentals = new Rentals();
        rentals.add(rental);
        int expected = 1;
        assertEquals(expected, rentals.calculatePoints());
    }

    public void testShouldReturnTheTotalFrequentRenterPointsForMultipleMovies() throws InvalidPriceCodeException {
        Rentals rentals = new Rentals();
        rentals.add(rental).add(rental1);
        int expected = 3;
        assertEquals(expected, rentals.calculatePoints());
    }
}