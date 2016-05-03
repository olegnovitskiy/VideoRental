package com.fmdev.refactoring;

/**
 * Created by NIO on 03.05.2016. All rights reserved.
 */
public class App {
    public static void main(String[] args) {
        Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        Movie terminator2 = new Movie("Terminator2", FilmType.REGULAR);
        Movie LOTR2 = new Movie("Lord of The Rings 2", FilmType.NEW_RELEASE);
        Movie LOTR3 = new Movie("Lord of The Rings 3", FilmType.NEW_RELEASE);

        Rental rental1 = new Rental(terminator, 10);
        Rental rental2 = new Rental(terminator2, 5);
        Rental rental3 = new Rental(LOTR2, 3);
        Rental rental4 = new Rental(LOTR3, 15);

        Customer billy = new Customer("Billy");
        Customer bobby = new Customer("Bobby");
        Customer julia = new Customer("Julia");

        billy.addRental(rental1);
        bobby.addRental(rental2);
        julia.addRental(rental3);
        julia.addRental(rental4);

        System.out.printf("Отчет по клиенту: %s \n %s \n\n", billy.getName(), billy.statement());
        System.out.printf("Отчет по клиенту: %s \n %s \n\n", bobby.getName(), bobby.statement());
        System.out.printf("Отчет по клиенту: %s \n %s \n\n", julia.getName(), julia.statement());
    }
}
