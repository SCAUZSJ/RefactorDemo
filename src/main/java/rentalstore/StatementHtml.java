package rentalstore;

public class StatementHtml extends Statement {

    @Override
    protected String getFooter(Customer customer) {
        String result = "<P>You owe<EM>" + getTotalAmount(customer) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + getFrequentRenterPoint(customer) +
                "</EM> frequent renter points<P>";
        return result;
    }
    @Override
    protected String getEachRental(Rental each) {
        return each.getMovie().getTitle() + ": " + each.getMovieAmount() + "<BR>\n";
    }
    @Override
    protected String getHeader(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }
}
