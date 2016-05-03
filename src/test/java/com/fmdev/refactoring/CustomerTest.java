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
    public void WithoutRentalHTMLStatement() throws Exception {
        Customer billy = new Customer("Billy");

        // Ожидаемый вид отчета
        String expected =
                "<h1>Учет аренды для <em>Billy</em></h1><p>\n<p>Сумма задолжености составляет <em>0.0</em><p>\nВы заработали <em>0</em> очков за активность<p>";

        assertEquals(expected, billy.htmlStatement());
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
    public void ChildrenOneDayOneRentalHTMLStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator, 1));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tTerminator\t1.5<br />\n<p>Сумма задолжености составляет <em>1.5</em><p>\nВы заработали <em>1</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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
    public void ChildrenManyDaysOneRentalHTMLStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator, 8));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tTerminator\t9.0<br />\n<p>Сумма задолжености составляет <em>9.0</em><p>\nВы заработали <em>1</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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
    public void RegularOneDayOneRentalHTMLStatement() throws Exception {
        final Movie terminator2 = new Movie("Terminator 2", FilmType.REGULAR);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator2, 1));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tTerminator 2\t2.0<br />\n<p>Сумма задолжености составляет <em>2.0</em><p>\nВы заработали <em>1</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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
    public void RegularManyDaysOneRentalHTMLStatement() throws  Exception {
        final Movie terminator2 = new Movie("Terminator 2", FilmType.REGULAR);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(terminator2, 5));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tTerminator 2\t6.5<br />\n<p>Сумма задолжености составляет <em>6.5</em><p>\nВы заработали <em>1</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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
    public void ReleaseOneDayOneRentalHTMLStatement() throws Exception {
        final Movie bummer = new Movie("Бумер", FilmType.NEW_RELEASE);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(bummer, 1));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tБумер\t3.0<br />\n<p>Сумма задолжености составляет <em>3.0</em><p>\nВы заработали <em>1</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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
    public void ReleaseManyDaysOneRentalHTMLStatement() throws Exception {
        final Movie bummer = new Movie("Бумер", FilmType.NEW_RELEASE);
        Customer billy = new Customer("Billy");
        billy.addRental(new Rental(bummer, 5));

        String expected = "<h1>Учет аренды для <em>Billy</em></h1><p>\n\tБумер\t15.0<br />\n<p>Сумма задолжености составляет <em>15.0</em><p>\nВы заработали <em>2</em> очков за активность<p>";
        assertEquals(expected, billy.htmlStatement());
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

    @Test
    public void ChildrenOneDayTwoRentalsHTMLStatement() throws Exception {
        final Movie terminator = new Movie("Terminator", FilmType.CHILDRENS);
        final Movie terminator2 = new Movie("Terminator 2", FilmType.CHILDRENS);
        Customer julia = new Customer("Julia");
        julia.addRental(new Rental(terminator, 1));
        julia.addRental(new Rental(terminator2, 1));

        String expected = "<h1>Учет аренды для <em>Julia</em></h1><p>\n\tTerminator\t1.5<br />\n\tTerminator 2\t1.5<br />\n<p>Сумма задолжености составляет <em>3.0</em><p>\nВы заработали <em>2</em> очков за активность<p>";
        assertEquals(expected, julia.htmlStatement());
    }
}