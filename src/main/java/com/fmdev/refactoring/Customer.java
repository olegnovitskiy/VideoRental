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
        // Результирующая строка с отчетом об общей задолжености клиента
        String result = "Учет аренды для " + getName() + "\n";

        for (Rental rental : rentals) {
            // Показать результаты для этой аренды
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }

        // Добавить к отчету нижний колонтитул с итоговой информацией
        result += "Сумма задолжености составляет " + getTotalCharge() + "\n" +
                "Вы заработали " + getTotalFrequentRenterPoints() + " очков за активность";

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        // Общая сумма бонусов
        int result = 0;

        // Просматриваем все фильмы и определяем сколько накапало бонусов дилеру
        for (Rental rental: rentals) {
            result += rental.getFrequentRenterPoints();
        }

        return result;
    }

    private double getTotalCharge() {
        double result = 0;

        for (Rental rental : rentals) {
            result += rental.getCharge();
        }
        return result;
    }

}
