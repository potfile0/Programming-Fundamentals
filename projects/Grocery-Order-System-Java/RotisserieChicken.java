/**
 * This class represents a rotisserie chicken.
 * It can be hot or cold.
 * 
 * @author sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class RotisserieChicken implements GroceryItem {

    private boolean hot;

    public RotisserieChicken(boolean h) {
        hot = h;
    }

    public String getName() {
        return hot ? "Hot Rotisserie Chicken" : "Rotisserie Chicken";
    }

    public double getFullPrice() {
        return hot ? 7.99 : 6.99;
    }

    public String toString() {
        return String.format("%s, price: $%.2f",
                getName(), getFullPrice());
    }
}
