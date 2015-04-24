package com.twu.biblioteca.library;

import com.twu.biblioteca.com.twu.biblioteca.exceptions.InvalidRatingException;
import com.twu.biblioteca.library.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by watsonarw on 23/04/15.
 */
public class MovieTest {

    @Test
    public void testMovieWithRating() {
        Movie titanic = new Movie("Titanic", 1997, "James Cameron", 7.7);
        String expected = "Titanic (1997) - James Cameron, 7.7/10";
        assertEquals(expected, titanic.toString());
    }

    @Test
    public void testMovieWithoutRating() {
        Movie titanic = new Movie("Titanic", 1997, "James Cameron");
        String expected = "Titanic (1997) - James Cameron, unrated";
        assertEquals(expected, titanic.toString());
    }

    @Test(expected = InvalidRatingException.class)
    public void testMovieRatingBelowOneIsInvalid() {
        Movie mov = new Movie("Attack of the Killer Tomatoes!", 1978, "John De Bello", 0.99);
    }

    @Test
    public void testMovieRatingIsOne() {
        Movie mov = new Movie("Attack of the Killer Tomatoes!", 1978, "John De Bello", 1.0);
        String expected = "Attack of the Killer Tomatoes! (1978) - John De Bello, 1.0/10";
        assertEquals(expected, mov.toString());
    }

    @Test(expected = InvalidRatingException.class)
    public void testMovieRatingAboveTenIsInvalid() {
        Movie mov = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10.01);
    }

    @Test
    public void testMovieRatingIsTen() {
        Movie mov = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10.0);
        String expected = "The Shawshank Redemption (1994) - Frank Darabont, 10.0/10";
        assertEquals(expected, mov.toString());
    }
}
