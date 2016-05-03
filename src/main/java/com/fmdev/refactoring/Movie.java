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
        // Бонус за новинки на два дня
        if (getFilmType() == FilmType.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
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
