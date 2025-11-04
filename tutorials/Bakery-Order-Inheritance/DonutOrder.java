public class DonutOrder extends BakeryOrder{
    //as if DonutOrder has count, name, unitPrice

    private boolean frosting;

    //make default donut order be 1
    public DonutOrder(String n, boolean f) {
        //if we don't call the parent constructor, then the compiler calls the default parent constructor for us
        super(n, 1);

        frosting = f;
        unitPrice = 1.75;

        //initializes all the fields to their default value
    }

    //override setCount
    public void setCount(int newCount) {
        if (newCount <= 12) {
            count = newCount;
        }
    }

    public void setFrosting(boolean f) {
        frosting = f;
    }

    //override totalPrice
    public double totalPrice() {

        //account for the drosting cost
        double price = 0;
        if (frosting) {
            price = 0.25 * count;
        }

        //account for the donut cost
        if(count <=6) {
            //no discount
            price += (unitPrice) * count;

        }
        else {
            //discount beyond 6
            price += unitPrice * 6 + (unitPrice-0.50) *(count - 6);
        }
        return price;

    }

    //as if DonutOrder has setCount, totalPrice, print

    //donuts are $1.75 each for the first 6, but $1.25 for any beyond 6. Limit 12.

    //can optionally have frosting, which is $0.25 extra per donut (no discount).
}
