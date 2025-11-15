/**
 * This class represents a bag of chips. Chips have a full
 * price and a sale price.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Chips implements DiscountedItem {

    public String getName() {
        return "Chips";
    }

    public double getDiscountPrice() {
        return 3.99;
    }

    public double getFullPrice() {
        return 5.99;
    }

    public String toString() {
        return String.format("%s, price: $%.2f",
                getName(), getFullPrice());
    }
}
