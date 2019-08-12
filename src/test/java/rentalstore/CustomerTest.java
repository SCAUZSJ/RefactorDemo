package rentalstore;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class CustomerTest {

    @Test
    public void should_return_right_statement_when_customer_no_rent_book() {
        Customer customer = new Customer("milo");
        String out = customer.statement();
        Assert.assertEquals("Rental Record for milo\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points",out);
    }

    @Test
    public void should_return_right_statement_when_customer_rent_one_regular_movie_for_1_day(){

        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_regular",Movie.REGULAR),1));
        String out = customer.statement();
        Assert.assertEquals("Rental Record for milo\n" +
                "\tmovie_regular\t2.0\n" +
                "Amount owed is 2.0\n" +
                "You earned 1 frequent renter points",out);
    }

    @Test
    public void should_return_right_statement_when_customer_rent_one_regular_movie_for_4_day() {
        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_regular",Movie.REGULAR),4));
        String out = customer.statement();

        Assert.assertEquals("Rental Record for milo\n" +
                "\t" + "movie_regular" + "\t5.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 1 frequent renter points", out);
    }

    @Test
    public void should_return_right_statement_when_customer_rent_one_new_release_movie_for_1_day() {
        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_new_release",Movie.NEW_RELEASE),1));
        String out = customer.statement();

        Assert.assertEquals("Rental Record for milo\n" +
                "\tmovie_new_release\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", out);
    }
    @Test
    public void should_return_right_statement_when_customer_rent_one_new_release_movie_for_2_day() {
        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_new_release",Movie.NEW_RELEASE),2));
        String out = customer.statement();

        Assert.assertEquals("Rental Record for milo\n" +
                "\tmovie_new_release\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", out);
    }

    @Test
    public void should_return_right_statement_when_customer_rent_one_child_movie_for_1_day() {
        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_child_movie",Movie.CHILDRENS),1));
        String out = customer.statement();

        Assert.assertEquals("Rental Record for milo\n" +
                "\tmovie_child_movie\t1.5\n" +
                "Amount owed is 1.5\n" +
                "You earned 1 frequent renter points", out);
    }

    @Test
    public void should_return_right_statement_when_customer_rent_one_child_movie_for_4_day() {
        Customer customer = new Customer("milo");
        customer.addRental(new Rental(new Movie("movie_child_movie",Movie.CHILDRENS),4));
        String out = customer.statement();

        Assert.assertEquals("Rental Record for milo\n" +
                "\tmovie_child_movie\t3.0\n" +
                "Amount owed is 3.0\n" +
                "You earned 1 frequent renter points", out);
    }

}
