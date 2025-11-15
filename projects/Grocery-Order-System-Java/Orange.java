/**
 * This class represents oranges, which may be organic or not.
 * Oranges are sold as countable items.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Orange implements CountableItem {

    private int count;
    private boolean organic;

    public Orange(boolean o) {
        organic = o;
        count = 1;
    }

    public String getName() {
        return organic ? "Organic Orange" : "Orange";
    }

    public void setCount(int num) {
        if (num >= 1 && num <= 3) {
            count = num;
        }
    }

    public int getCount() {
        return count;
    }

    public double getUnitPrice() {
        return organic ? 1.25 : 0.99;
    }

    public double getFullPrice() {
        return count * getUnitPrice();
    }

    public String toString() {
        return String.format("%s, count: %d, price: $%.2f",
                getName(), getCount(), getFullPrice());
    }
}
