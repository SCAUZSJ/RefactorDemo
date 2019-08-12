package rentalstore;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title) {
        super(title);
    }
    public double getAmount(Rental each) {
        return each.getDayRented() * 3;
    }
}
