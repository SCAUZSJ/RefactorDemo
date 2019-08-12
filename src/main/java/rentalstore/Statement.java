package rentalstore;

public abstract class Statement {


    protected abstract String getFooter(Customer customer);

    protected abstract String getEachRental(Rental each);

    protected abstract String getHeader(Customer customer);

    public String getStatement(Customer customer){
        String result = getHeader(customer);
        for (Rental each : customer.getRentals()) {
            result += getEachRental(each);
        }
        result += getFooter(customer);
        return result;
    }

    protected double getTotalAmount(Customer customer) {
        return customer.getRentals().stream().mapToDouble(Rental::getMovieAmount).sum();
    }

    protected boolean isNewReleaseAndMoreOneDay(Rental each) {
        return ((each.getMovie() instanceof NewReleaseMovie) && (each.getDayRented()>1));
    }

    protected String getFrequentRenterPoint(Customer customer) {
        double frequentRenterPoint = customer.getRentals().stream().mapToDouble(Rental::getFrequentRenterPoint).sum();
        if(isDouble(frequentRenterPoint)) return String.valueOf(frequentRenterPoint);
        return String.valueOf((int)frequentRenterPoint);
    }

    protected boolean isArtMovie(Rental each){
        return each.getMovie() instanceof ArtMovie;
    }

    protected boolean isDouble(double num) {
        return !(num - Math.floor(num) < (1e-10));
    }


}
