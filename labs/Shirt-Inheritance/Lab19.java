import java.util.*;

public class Lab19 {
    public static void main(String[] args) {
        //Want to store 5 shirt orders
        Shirt[] orders = new Shirt[5];

        //1) regular shirt, lavender, 3
        Shirt s1 = new Shirt(ShirtColor.Lavender);
        s1.setCount(3);
        //2) polo shirt, purple, 5
        PoloShirt s2 = new PoloShirt();
        s2.setColor(ShirtColor.Purple);
        s2.setCount(5);
        //3) button-up shirt, white, 4, long-sleeved
        ButtonUpShirt s3 = new ButtonUpShirt(ShirtColor.White);
        s3.setCount(4);
        s3.makeLongSleeved();
        //4) button-up shirt, gray, 2, short-sleeved
        ButtonUpShirt s4 = new ButtonUpShirt(ShirtColor.Gray);
        s4.setCount(2);
        //5) regular shirt, black, 10
        Shirt s5 = new Shirt(ShirtColor.Black);
        s5.setCount(10);

        orders[0] = s1;
        orders[1] = s2;
        orders[2] = s3;
        orders[3] = s4;
        orders[4] = s5;
        //Want to print information (customization + order cost)
        for(Shirt s: orders) {
            System.out.println(s);
        }
    }
}