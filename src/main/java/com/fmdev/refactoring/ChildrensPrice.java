package com.fmdev.refactoring;

/**
 * Фильм для детей
 */
public class ChildrensPrice extends Price {
    @Override
    public FilmType getFilmType() {
        return FilmType.CHILDRENS;
    }
}
