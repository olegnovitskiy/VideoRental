package com.fmdev.refactoring;

/**
 * Для обеспечения общего поведения подклассов
 */
public abstract class Price {
    public abstract FilmType getFilmType();

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
}
