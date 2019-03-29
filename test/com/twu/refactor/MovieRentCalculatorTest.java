package com.twu.refactor;

import junit.framework.TestCase;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieRentCalculatorTest extends TestCase {
    public void testShouldReturnTheAmountOfARegularMovieForTwoDays() throws InvalidPriceCodeException {
        MovieRentCalculator rentCalculator = MovieRentCalculator.getCalculatorFor(Movie.REGULAR);
        double expected = 3.5;
        double actual = rentCalculator.calculateAmount(3);
        assertEquals(expected, actual);
    }

    public void testShouldThrowAnInvalidPriceCodeException() {
        assertThrows(InvalidPriceCodeException.class, new Executable() {
            public void execute() throws Throwable {
                MovieRentCalculator.getCalculatorFor(4);
            }
        });
    }
}