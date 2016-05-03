package com.fmdev.refactoring;

/*
 * Представляет данные о фильмах
 */
public class Movie {
    private String title;
    private FilmType filmType;

    public Movie(String title, FilmType filmType) {
        this.title = title;
        this.filmType = filmType;
    }

    public FilmType getFilmType() {
        return filmType;
    }

    public void setFilmType(FilmType filmType) {
        this.filmType = filmType;
    }

    public String getTitle() {
        return title;
    }
}
