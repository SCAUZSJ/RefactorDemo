package rentalstore;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }
    public double getAmount(Rental each) {
        return each.getDayRented() * 3;
    }

    @Override
    public double getFrequentRenterPoint(Rental rental) {
        return rental.getDayRented()>1 ? 2:1;
    }
}
