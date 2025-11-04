import java.util.*;

public class Tutorial10 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //This will not compile. Can't store a parent object in a child variable.
        //CookieOrder c = new BakeryOrder("Muffins", 2);

        BakeryOrder[] order = new BakeryOrder[10];
        order[0] = new BakeryOrder("Scones", 3);
        order[1] = new CookieOrder("Chocolate Chip Cookies");
        order[2] = new DonutOrder("Old Fashioned", false);

        //print bakery order info
        for(int i = 0; i < 3; i++) {
            order[i].print();
        }

        //try changing all counts to be 9
        for (int i = 0; i < 3; i++) {
            order[i].setCount(9);
        }

        //set all donuts to have frosting
        for (int i = 0; i < 3; i++) {
            if (order[i] instanceof DonutOrder) {
                DonutOrder d = (DonutOrder) order[i];
                d.setFrosting(true);
            }
        }
        
        //print bakery order info
        for (int i = 0; i < 3; i++) {
            order[i].print();
        }
    }
}
