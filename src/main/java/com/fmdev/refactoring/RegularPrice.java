package com.fmdev.refactoring;

/**
 * Обычный фильм
 */
public class RegularPrice extends Price {
    @Override
    public FilmType getFilmType() {
        return FilmType.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        double result = 2;
        if (daysRented > 2) {
            result += (daysRented - 2) * 1.5;
        }
        return result;
    }
}
