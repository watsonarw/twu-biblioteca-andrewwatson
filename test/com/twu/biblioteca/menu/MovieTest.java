package com.twu.biblioteca.menu;

import com.twu.biblioteca.Movie;
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

    @Test
    public void testMovieRatingBelowOneIsUnrated() {
        Movie mov = new Movie("Attack of the Killer Tomatoes!", 1978, "John De Bello", 0.99);
        String expected = "Attack of the Killer Tomatoes! (1978) - John De Bello, unrated";
        assertEquals(expected, mov.toString());
    }

    @Test
    public void testMovieRatingIsOne() {
        Movie mov = new Movie("Attack of the Killer Tomatoes!", 1978, "John De Bello", 0.99);
        String expected = "Attack of the Killer Tomatoes! (1978) - John De Bello, unrated";
        assertEquals(expected, mov.toString());
    }

    @Test
    public void testMovieRatingAboveTenIsUnrated() {
        Movie mov = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10.01);
        String expected = "The Shawshank Redemption (1994) - Frank Darabont, unrated";
        assertEquals(expected, mov.toString());
    }

    @Test
    public void testMovieRatingIsTen() {
        Movie mov = new Movie("The Shawshank Redemption", 1994, "Frank Darabont", 10.01);
        String expected = "The Shawshank Redemption (1994) - Frank Darabont, unrated";
        assertEquals(expected, mov.toString());
    }
}
