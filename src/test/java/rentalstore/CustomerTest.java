package rentalstore;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer customer = new Customer("Jerry");

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        Movie regularMovie = new RegularMovie("Titanic" );
        Rental oneDayRental = new Rental(regularMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        Movie regularMovie = new RegularMovie("Titanic");
        Rental threeDayRental = new Rental(regularMovie, 3);
        customer.addRental(threeDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.5\n" +
                "Amount owed is 3.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental oneDayRental = new Rental(newReleaseMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        Movie newReleaseMovie = new NewReleaseMovie("Titanic");
        Rental twoDayRental = new Rental(newReleaseMovie, 2);
        customer.addRental(twoDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        Movie childrenMovie = new ChildMovie("Titanic");
        Rental oneDayRental = new Rental(childrenMovie, 1);
        customer.addRental(oneDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new ChildMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);

        String statement = customer.statement();

        assertEquals("Rental Record for Jerry\n" +
                "\tTitanic\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        Movie childrenMovie = new ChildMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 4);
        customer.addRental(fourDayRental);
        String statement = customer.htmlStatement();
        System.out.println(statement);
        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_art_movie_for_1_day() {
        Movie childrenMovie = new ArtMovie("Titanic");
        Rental fourDayRental = new Rental(childrenMovie, 1);
        customer.addRental(fourDayRental);
        String statement = customer.htmlStatement();
        System.out.println(statement);
        assertEquals("<H1>Rentals for <EM>Jerry</EM></H1><P>\n" +
                "Titanic: 6.0<BR>\n" +
                "<P>You owe<EM>6.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }
}

