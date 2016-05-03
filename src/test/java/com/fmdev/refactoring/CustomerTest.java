package com.fmdev.refactoring;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Тесты
 */
public class CustomerTest {

    @Test
    public void WithoutRentalStatement() throws Exception {
        Customer billy = new Customer("Billy");

        // Ожидаемый вид отчета
        String expected =
                "Учет аренды для Billy\nСумма задолжености составляет 0.0\nВы заработали 0 очков за активность";

        assertEquals(expected, billy.statement());
    }

    @Test
    public void ChildrenOneDayOneRentalStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator, 1));

        String expected = "Учет аренды для Billy\n\tTerminator\t1.5\nСумма задолжености составляет 1.5\nВы заработали 1 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void ChildrenManyDaysOneRentalStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator, 8));

        String expected = "Учет аренды для Billy\n\tTerminator\t9.0\nСумма задолжености составляет 9.0\nВы заработали 1 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void RegularOneDayOneRentalStatement() throws Exception {
        final Movie terminator2 = new Movie("Terminator 2", FilmType.REGULAR);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator2, 1));

        String expected = "Учет аренды для Billy\n\tTerminator 2\t2.0\nСумма задолжености составляет 2.0\nВы заработали 1 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void RegularManyDaysOneRentalStatement() throws  Exception {
        final Movie terminator2 = new Movie("Terminator 2", FilmType.REGULAR);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator2, 5));

        String expected = "Учет аренды для Billy\n\tTerminator 2\t6.5\nСумма задолжености составляет 6.5\nВы заработали 1 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void ReleaseOneDayOneRentalStatement() throws Exception {
        final Movie bummer = new Movie("Бумер", FilmType.NEW_RELEASE);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(bummer, 1));

        String expected = "Учет аренды для Billy\n\tБумер\t3.0\nСумма задолжености составляет 3.0\nВы заработали 1 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void ReleaseManyDaysOneRentalStatement() throws Exception {
        final Movie bummer = new Movie("Бумер", FilmType.NEW_RELEASE);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(bummer, 5));

        String expected = "Учет аренды для Billy\n\tБумер\t15.0\nСумма задолжености составляет 15.0\nВы заработали 2 очков за активность";
        assertEquals(expected, billy.statement());
    }

    @Test
    public void ChildrenOneDayTwoRentalsStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        final Movie terminator2 = new Movie("Terminator 2", FilmType.CHILDRENS);
        Customer julia = new Customer("Julia");
        julia.addRental(new Rental(terminator, 1));
        julia.addRental(new Rental(terminator2, 1));

        String expected = "Учет аренды для Julia\n\tTerminator\t1.5\n\tTerminator 2\t1.5\nСумма задолжености составляет 3.0\nВы заработали 2 очков за активность";
        assertEquals(expected, julia.statement());
    }
}