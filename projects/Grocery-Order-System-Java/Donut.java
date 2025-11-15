/**
 * This class represents donuts, which can be frosted or plain.
 * Donuts come in counts and also have a discount price.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Donut implements CountableItem, DiscountedItem {

    private boolean frosted;
    private int count;

    public Donut(boolean f) {
        frosted = f;
        count = 1;
    }

    public String getName() {
        return frosted ? "Frosted Donut" : "Plain Donut";
    }

    public void setCount(int num) {
        if (num >= 1 && num <= 12) {
            count = num;
        }
    }

    public int getCount() {
        return count;
    }

    public double getUnitPrice() {
        return frosted ? 1.50 : 1.25;
    }

    public double getFullPrice() {
        return count * getUnitPrice();
    }

    public double getDiscountPrice() {
        return 0.7 * getFullPrice(); 
    }

    public String toString() {
        return String.format("%s, count: %d, price: $%.2f",
                getName(), getCount(), getFullPrice());
    }
}
