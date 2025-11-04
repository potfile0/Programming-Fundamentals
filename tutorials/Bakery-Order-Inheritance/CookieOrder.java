//child class, derived class, sub class
public class CookieOrder extends BakeryOrder{

    public CookieOrder(String n) {
        //required to call the parent constructor here
        super(n, 2);
        
        unitPrice = 1.50;

        //unit price is $1.50

    }

    //method overwriting
    public void setCount(int newCount) {
        //enforce that we only order cookies in pair
        if (newCount % 2 == 0) {
            count = newCount;
        }
    }
 

    //cookies are $1.50 each but need to be purchased in pairs.

    //default is 2 cookies.

    //construcot takes count, name

    //setCount changes count


    
}
