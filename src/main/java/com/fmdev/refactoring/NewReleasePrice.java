package com.fmdev.refactoring;

/**
 * Фильм-новинка
 */
public class NewReleasePrice extends Price {
    @Override
    public FilmType getFilmType() {
        return FilmType.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }
}
