package rentalstore;

public class StatementText extends  Statement {

    @Override
    protected String getFooter(Customer customer) {
        String footer = "Amount owed is " + getTotalAmount(customer) + "\n";
        footer += "You earned " + getFrequentRenterPoint(customer) + " frequent renter points";
        return footer;
    }
    @Override
    protected String getEachRental(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + each.getMovieAmount() + "\n";
    }

    @Override
    protected String getHeader(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }


}
