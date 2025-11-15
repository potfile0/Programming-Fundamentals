/**
 * This class represents a carton of eggs.
 * Eggs have a full price and a discounted sale price.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Eggs implements DiscountedItem {

    public String getName() {
        return "Eggs";
    }

    public double getFullPrice() {
        return 3.50;
    }

    public double getDiscountPrice() {
        return 2.50;
    }

    public String toString() {
        return String.format("%s, price: $%.2f",
                getName(), getFullPrice());
    }
}
