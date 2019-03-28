package com.twu.refactor;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class CustomerTest extends TestCase {

    private static final String TEST_DATA_PATH = "test/data";

    private Customer neji = new Customer("Dinsdale Pirhana");


    public void setUp() {
        Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
        Movie ran = new Movie("Ran", Movie.REGULAR);
        Movie la = new Movie("LA Confidential", Movie.getNewRelease());
        Movie trek = new Movie("Star Trek 13.2", Movie.getNewRelease());
        Movie wallace = new Movie("Wallace and Gromit", Movie.CHILDRENS);

        neji.addRental(new Rental(python, 3));
        neji.addRental(new Rental(ran, 1));
        neji.addRental(new Rental(la, 2));
        neji.addRental(new Rental(trek, 1));
        neji.addRental(new Rental(wallace, 6));
    }

    public void testEmpty() throws Exception {
        neji = new Customer("Dinsdale Pirhana");
        equalsFile("1st Output", "outputEmpty", neji.statement());
    }

    public void testCustomer() throws Exception {
        equalsFile("1st Output", "output1", neji.statement());
    }

    public void testChange() throws Exception {
        Movie avengers = new Movie("Avengers", Movie.NEW_RELEASE);
        neji.addRental(new Rental(avengers, 1));
        avengers.setPriceCode(Movie.REGULAR);
        equalsFile("1st Output", "outputChange", neji.statement());
    }

    public void testShouldReturnTheStatementWhenPurchasedAChildrenMovie() throws Exception {
        Customer naruto = new Customer("Naruto");
        Movie avengers = new ChildrenMovie("Avengers");

        naruto.addRental(new Rental(avengers, 1));
        equalsFile("1st Output", "narutoBill", naruto.statement());
    }

    public void testShouldReturnTheStatementWhenPurchasedARegularMovie() throws Exception {
        Customer kakashi = new Customer("Kakashi");
        Movie avengers = new RegularMovie("Avengers");

        kakashi.addRental(new Rental(avengers, 3));
        equalsFile("1st Output", "kakashiBill", kakashi.statement());
    }

    public void testShouldReturnTheStatementWhenPurchasedANewRealeasedMovie() throws Exception {
        Customer lee = new Customer("Lee");
        Movie avengers = new NewReleasedMovie("Avengers");

        lee.addRental(new Rental(avengers, 1));
        equalsFile("1st Output", "leeBill", lee.statement());
    }

    /*
    public void testHtml() throws Exception {
        equalsFile("1st Output", "outputHtml", neji.htmlStatement());
    }
    */

    private void equalsFile(String message, String fileName, String actualValue) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(TEST_DATA_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine = null;
        while ((thisFileLine = file.readLine()) != null) {
            assertEquals("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }

}
