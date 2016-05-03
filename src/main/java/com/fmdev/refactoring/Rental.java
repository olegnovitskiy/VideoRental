package com.fmdev.refactoring;

/**
 * Представляет данные о прокате фильма
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        double result = 0;
        // В зависимости от типа фильма, начисляем заданную стоимость за аренду
        switch (getMovie().getFilmType()) {
            case REGULAR:
                result = 2;
                if (getDaysRented() > 2) {
                    result += (getDaysRented() - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                result += getDaysRented() * 3;
                break;
            case CHILDRENS:
                result = 1.5;
                if (getDaysRented() > 3) {
                    result += (getDaysRented() - 3) * 1.5;
                }
                break;
            default:
        }
        return result;
    }

    public int getFrequentRenterPoints() {
        // Бонус за новинки на два дня
        if (getMovie().getFilmType() == FilmType.NEW_RELEASE && getDaysRented() > 1) {
            return 2;
        }
        return 1;
    }
}
