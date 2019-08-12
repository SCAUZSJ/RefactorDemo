package rentalstore;

public abstract class Statement {

    public String getStatement(Customer customer){
        String result = getHeader(customer);
        for (Rental each : customer.getRentals()) {
            result += getEachRental(each);
        }
        result += getFooter(customer);
        return result;
    }


    protected abstract String getFooter(Customer customer);

    protected abstract String getEachRental(Rental each);

    protected abstract String getHeader(Customer customer);

    protected double getTotalAmount(Customer customer) {
        return customer.getRentals().stream().mapToDouble(Rental::getMovieAmount).sum();
    }

    protected boolean isNewReleaseAndMoreOneDay(Rental each) {
        return ((each.getMovie() instanceof NewReleaseMovie) && (each.getDayRented()>1));
    }

    protected int getFrequentRenterPoint(Customer customer) {
        int frequentRenterPoints = 0;
        for (Rental each :customer.getRentals()){
            frequentRenterPoints++;
            if(isNewReleaseAndMoreOneDay(each)){
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }
}
