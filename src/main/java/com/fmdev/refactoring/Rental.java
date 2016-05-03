package com.fmdev.refactoring;

/**
 * Представляет данные о прокате фильма
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        // Бонус за новинки на два дня
        if (getMovie().getFilmType() == FilmType.NEW_RELEASE && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
