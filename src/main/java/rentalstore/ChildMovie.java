package rentalstore;

public class ChildMovie extends Movie {
    public ChildMovie(String title) {
        super(title);
    }
    public double getAmount(Rental each) {
        double amount = 1.5;
        if (each.getDayRented() > 3) {
            amount += (each.getDayRented() - 3) * 1.5;
        }
        return amount;
    }
}
