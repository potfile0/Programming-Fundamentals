/**
 * This class represents a grocery order. It can hold any grocery items,
 * create a standard or random order, and calculate totals and savings.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
import java.util.*;

public class GroceryOrder {

    private ArrayList<GroceryItem> items;

    public GroceryOrder(boolean standard) {
        items = new ArrayList<>();
        if (standard) {
            createStandardOrder();
        } else {
            createRandomOrder();
        }
    }

    private void createStandardOrder() {
        Apple a = new Apple();
        a.setCount(5);
        items.add(a);

        items.add(new Chips());

        Donut d1 = new Donut(true);
        d1.setCount(4);
        items.add(d1);

        Donut d2 = new Donut(false);
        d2.setCount(3);
        items.add(d2);

        items.add(new Eggs());
        items.add(new Eggs());

        Orange o = new Orange(true);
        o.setCount(3);
        items.add(o);

        items.add(new RotisserieChicken(true));
        items.add(new RotisserieChicken(false));
    }

    private void createRandomOrder() {
        Random rand = new Random();
        int numItems = rand.nextInt(17) + 4; 

        for (int i = 0; i < numItems; i++) {
            int choice = rand.nextInt(6);

            switch (choice) {
                case 0 -> { 
                    Apple a = new Apple();
                    a.setCount(rand.nextInt(5) + 1);
                    items.add(a);
                }
                case 1 -> items.add(new Chips());
                case 2 -> { 
                    boolean frosted = rand.nextBoolean();
                    Donut d = new Donut(frosted);
                    d.setCount(rand.nextInt(12) + 1);
                    items.add(d);
                }
                case 3 -> items.add(new Eggs());
                case 4 -> { 
                    boolean organic = rand.nextBoolean();
                    Orange o = new Orange(organic);
                    o.setCount(rand.nextInt(3) + 1);
                    items.add(o);
                }
                case 5 -> { 
                    boolean hot = rand.nextBoolean();
                    items.add(new RotisserieChicken(hot));
                }
            }
        }
    }

    public double getTotalFullPrice() {
        double total = 0;
        for (GroceryItem g : items) {
            total += g.getFullPrice();
        }
        return total;
    }

    public double getTotalDiscountPrice() {
        double total = 0;
        for (GroceryItem g : items) {
            if (g instanceof DiscountedItem di) {
                total += di.getDiscountPrice();
            } else {
                total += g.getFullPrice();
            }
        }
        return total;
    }

    public double getSavings() {
        return getTotalFullPrice() - getTotalDiscountPrice();
    }

    public ArrayList<GroceryItem> getAllItems() {
        return items;
    }

    public ArrayList<CountableItem> getCountableItems() {
        ArrayList<CountableItem> list = new ArrayList<>();
        for (GroceryItem g : items) {
            if (g instanceof CountableItem c) {
                list.add(c);
            }
        }
        return list;
    }

    public ArrayList<DiscountedItem> getDiscountedItems() {
        ArrayList<DiscountedItem> list = new ArrayList<>();
        for (GroceryItem g : items) {
            if (g instanceof DiscountedItem d) {
                list.add(d);
            }
        }
        return list;
    }
}
