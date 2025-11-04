//general class, parent class, super class, base class
public class BakeryOrder {
    //All bakery oders have count, name, unit price ($2.99)
    protected int count;
    protected String name;
    protected double unitPrice = 2.99;

    //Constructor takes count, name
    public BakeryOrder(String n, int c) {
        count = c;
        name = n;
    }

    //setCount changes count
    public void setCount(int newCount) {
        count = newCount;
    }

    //totalPrice fets the price of the order
    public double totalPrice() {
        return count*unitPrice;
    }

    //print prints the name, count, and total price
    public void print() {
        System.out.printf("%s, %d, total:$%.2f%n", name, count, totalPrice());
    }
}
