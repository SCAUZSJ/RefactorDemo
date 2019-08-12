package rentalstore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = getHeader();
        for (Rental each : this.rentals) {
            result += getEachRental(each,each.getMovieAmount());
        }
        result += getFooter();
        return result;
    }

    private double getTotalAmount() {
        return this.rentals.stream().mapToDouble(Rental::getMovieAmount).sum();
    }

    private boolean isNewReleaseAndMoreOneDay(Rental each) {
        return ((each.getMovie() instanceof NewReleaseMovie) && (each.getDayRented()>1));
    }

    private String getEachRental(Rental each, double thisAmount) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
    }

    private String getHeader() {
        return "Rental Record for " + getName() + "\n";
    }

    private String getFooter() {
        String footer = "Amount owed is " + getTotalAmount() + "\n";
        footer += "You earned " + getFrequentRenterPoint() + " frequent renter points";
        return footer;
    }

    private int getFrequentRenterPoint() {
        int frequentRenterPoints = 0;
        for (Rental each :this.rentals){
            frequentRenterPoints++;
            if(isNewReleaseAndMoreOneDay(each)){
                frequentRenterPoints++;
            }
        }
        return frequentRenterPoints;
    }
}
