package com.fmdev.refactoring;

/**
 * Для обеспечения общего поведения подклассов
 */
public abstract class Price {
    public abstract FilmType getFilmType();

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        // Бонус за новинки на два дня
        if (getFilmType() == FilmType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
