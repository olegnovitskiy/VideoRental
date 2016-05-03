package com.fmdev.refactoring;

/**
 * Для обеспечения общего поведения подклассов
 */
public abstract class Price {
    public abstract FilmType getFilmType();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
