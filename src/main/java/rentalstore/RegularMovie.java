package rentalstore;

public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }
    public double getAmount(Rental each) {
        double amount = 2;
        if (each.getDayRented() > 2) {
            amount += (each.getDayRented() - 2) * 1.5;
        }
        return amount;
    }
}
