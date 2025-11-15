/**
 * This class represents apples, which are sold as a countable item.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Apple implements CountableItem {

    private int count;

    public Apple() {
        count = 1;
    }

    public String getName() {
        return "Apple";
    }

    public void setCount(int num) {
        if (num >= 1 && num <= 5) {
            count = num;
        }
    }

    public int getCount() {
        return count;
    }

    public double getUnitPrice() {
        return 0.75;
    }

    public double getFullPrice() {
        return count * getUnitPrice();
    }

    public String toString() {
        return String.format("%s, count: %d, price: $%.2f",
                getName(), getCount(), getFullPrice());
    }
}
