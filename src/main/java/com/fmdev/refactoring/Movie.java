package com.fmdev.refactoring;

/*
 * Представляет данные о фильмах
 */
public class Movie {
    private String title;
    private Price price;

    public Movie(String title, FilmType filmType) {
        this.title = title;
        setFilmType(filmType);
    }

    public FilmType getFilmType() {
        return price.getFilmType();
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return price.getFrequentRenterPoints(daysRented);
    }

    public void setFilmType(FilmType filmType) {
        switch (filmType) {
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            case REGULAR:
                price = new RegularPrice();
                break;
        }
    }

}
