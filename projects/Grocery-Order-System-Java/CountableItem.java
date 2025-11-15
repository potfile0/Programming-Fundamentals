/**
 * This interface is for grocery items that come in counts
 * (like apples, donuts, oranges). They track quantity and
 * have a unit price.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public interface CountableItem extends GroceryItem {
    void setCount(int num);
    int getCount();
    double getUnitPrice();
}
