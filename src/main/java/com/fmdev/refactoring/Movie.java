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
        double result = 0;
        // В зависимости от типа фильма, начисляем заданную стоимость за аренду
        switch (getFilmType()) {
            case REGULAR:
                result = 2;
                if (daysRented > 2) {
                    result += (daysRented - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += daysRented * 3;
                break;
            case CHILDRENS:
                result = 1.5;
                if (daysRented > 3) {
                    result += (daysRented - 3) * 1.5;
                }
                break;
            default:
        }

        return result;
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
