package com.fmdev.refactoring;

/**
 * Обычный фильм
 */
public class RegularPrice extends Price {
    @Override
    public FilmType getFilmType() {
        return FilmType.REGULAR;
    }
}
