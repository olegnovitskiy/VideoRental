package com.fmdev.refactoring;

import java.util.ArrayList;

/**
 * Клиент магазина
 */
public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        // Сумма задолженности
        double totalAmount = 0;
        // Бонусные очки арендатора, начисляются когда он впаривает фильм клиенту
        int frequentRenterPoints = 0;
        // Результирующая строка с отчетом об общей задолжености клиента
        String result = "Учет аренды для " + getName() + "\n";

        for (Rental each : rentals) {
            frequentRenterPoints = getFrequentRenterPoints(each);


            // Показать результаты для этой аренды
            result += "\t" + each.getMovie().getTitle() + "\t" + each.getCharge() + "\n";
            totalAmount += each.getCharge();
        }

        // Добавить к отчету нижний колонтитул с итоговой информацией
        result += "Сумма задолжености составляет " + totalAmount + "\n" +
                "Вы заработали " + frequentRenterPoints + " очков за активность";

        return result;
    }

    private int getFrequentRenterPoints(Rental each) {
        int frequentRenterPoints = 0;
        // Добавить очки для орендатора
        frequentRenterPoints++;

        // Бонус за новинки на два дня
        if (each.getMovie().getFilmType() == FilmType.NEW_RELEASE && each.getDaysRented() > 1) {
            frequentRenterPoints++;
        }
        return frequentRenterPoints;
    }

}
