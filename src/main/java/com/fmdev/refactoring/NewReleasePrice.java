package com.fmdev.refactoring;

/**
 * Фильм-новинка
 */
public class NewReleasePrice extends Price {
    @Override
    public FilmType getFilmType() {
        return FilmType.NEW_RELEASE;
    }
}
