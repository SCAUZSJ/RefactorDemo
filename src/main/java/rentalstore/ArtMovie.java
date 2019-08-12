package rentalstore;

public class ArtMovie extends Movie {

    public ArtMovie(String title) {
        super(title);
    }
    @Override
    public double getAmount(Rental each) {
        return each.getDayRented() * 6.0;
    }
}
